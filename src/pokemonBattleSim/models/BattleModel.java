package pokemonBattleSim.models;

import pokemonBattleSim.types.IPokemonTrainer;
import pokemonBattleSim.types.Move;
import pokemonBattleSim.types.Pokemon;
import static pokemonBattleSim.formulas.Formula.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

public class BattleModel {
	// holds the information for the battle
	private IPokemonTrainer playerOne;
	private IPokemonTrainer playerTwo;
	private boolean playerOneActive;
	private boolean playerTwoActive;
	private Queue<RegisterTask> playerOneTasks;
	private Queue<RegisterTask> playerTwoTasks;
	private Map<Integer, RegisterTask> taskMap;
	private Stack<String> log;
	private int taskCounter;
	private Timer timer;
	private TimerTask counter;
	private int timeLeft;
	private boolean isGameover;
	
	// Synchronization Locks
	private Object playerOneLock;
	private Object playerTwoLock;
	private Object playerOneActiveLock;
	private Object playerTwoActiveLock;
	private Object playerOneTasksLock; 
	private Object playerTwoTasksLock;
	private Object taskMapLock;
	private Object taskCounterLock;
	private Object logLock;
	private Object timeLeftLock;
	private Object isGameoverLock;
	
	public BattleModel ( IPokemonTrainer playerOne, IPokemonTrainer playerTwo, Timer timer, int duration)
	{
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.playerOneActive = true;
		this.playerTwoActive = true;
		this.timer = timer;
		this.playerOneTasks = new ArrayDeque<>();
		this.playerTwoTasks = new ArrayDeque<>();
		this.taskMap = new HashMap<>();
		this.taskCounter = 0;
		this.log = new Stack<>();
		this.timeLeft = duration;
		this.counter = new TimerTask() {
			public void run () {
				synchronized (timeLeftLock)
				{
					timeLeft--;
					if (timeLeft <= 0)
						gameover();
				}
			}
		};
		this.timer.schedule(this.counter, 0, 1000); // count down once per second
	}
	
	public boolean isGameover ()
	{
		synchronized (isGameoverLock)
		{
			return isGameover;
		}
	}
	
	/**
	 * will run when game ends automatically, clean up resources
	 */
	public void gameover ()
	{
		synchronized (isGameoverLock)
		{
			// check if game is already over
			if (isGameover)
				return; 
			else 
			{
				isGameover = true;
				timer.cancel();
			}
		}
	}
	
	/**
	 * get the last 5 elements in the log
	 * @return a Stack of 5 elements or fewer
	 */
	public Stack <String> getLog ()
	{
		Stack<String> output = new Stack<>();
		synchronized (logLock)
		{
			for (int i = 0; i < 5 && i < log.size(); i++)
			{
				output.push(log.elementAt(i));
			}
		}
		return output;
	}
	
	public int getPokemonHealth (Entity player, int index)
	{
		Pokemon pokemon = null;
		if (player == Entity.PLAYERONE)
		{
			synchronized (playerOneLock)
			{
				pokemon = playerOne.getPokemonTeamMember(index);
			}
		}
		else if (player == Entity.PLAYERTWO)
		{
			synchronized (playerTwoLock)
			{
				pokemon = playerTwo.getPokemonTeamMember(index);
			}
		}
		return pokemon.getHP();
	}
	
	public ArrayList<LiteMove> getTasks (Entity player)
	{
		ArrayList<LiteMove> moves = new ArrayList<>();
		if (player == Entity.PLAYERONE)
		{
			synchronized (playerOneTasksLock)
			{
				for ( RegisterTask task : playerOneTasks)
					moves.add(new LiteMove(task.getMoveName(),task.getID(),task.getActivePeriod(),task.getInactivePeriod()));
			}
		}
		else if (player == Entity.PLAYERTWO)
		{
			synchronized (playerTwoTasksLock)
			{
				for ( RegisterTask task : playerTwoTasks)
					moves.add(new LiteMove(task.getMoveName(),task.getID(),task.getActivePeriod(),task.getInactivePeriod()));
			}
		}
		return moves;
	}
	
	/**
	 * register a new action to the queues
	 * task are NOT registered to the timer yet
	 * @param souce the entity initiating the action (move, swap)
	 * @param target the target of the move
	 * @param args an object containing either a swap index or move
	 * @param delay how long the move will take
	 */
	public boolean registerAction (Entity source, Entity target, RegisterActionArgs args, int activePeriod, int inActivePeriod)
	{
		synchronized (isGameoverLock)
		{
			if (isGameover) return false; // game is already over
		}
		int id;
		RegisterTask task;
		
		synchronized (taskCounterLock)
		{
			id = taskCounter++;
		}
		
		// Special Case: attempt a swap
		if (target == Entity.SWAP)
		{
			synchronized (playerOneActiveLock)
			{
			synchronized (playerTwoActiveLock)
			{
				if (playerOneActive || playerTwoActive) return false;
				else 
				{
					task = new RegisterTask(source, target, args, id, activePeriod, inActivePeriod);
					timer.schedule(task, 0);
				}
					
			}
			}
		}
		
		
		task = new RegisterTask(source, target, args, id, activePeriod, inActivePeriod);
		// Add task to corresponding queue
		if ( source == Entity.PLAYERONE )
		{
			synchronized (playerOneTasksLock)
			{
				playerOneTasks.add(task);
			}
		}
		else if (source == Entity.PLAYERTWO )
		{
			synchronized (playerTwoTasksLock)
			{
				playerTwoTasks.add(task);
			}
		}
		
		// register task to map
		synchronized (taskMapLock)
		{
			taskMap.put(id, task);
		}
		// timer.schedule(task, delay);
		return true;
	}
	
	/**
	 * cancel an action by id
	 * @param source the player who owns the id of the action
	 * @param id the id of the action
	 */
	public void cancelAction (Entity source, int id)
	{
		RegisterTask task;
		// remove task from map
		synchronized (taskMapLock)
		{
			task = taskMap.get(id);
			taskMap.remove(id);
		}
		
		// remove task from player
		if ( source == Entity.PLAYERONE )
		{
			synchronized (playerOneTasksLock)
			{
				playerOneTasks.remove(task);
				task.cancel();
			}
		}
		else if (source == Entity.PLAYERTWO )
		{
			synchronized (playerTwoTasksLock)
			{
				playerTwoTasks.remove(task);
				task.cancel();
			}
		}
	}
	
	/**
	 * Attempt to perform the specified action
	 * @param source the source object of the action
	 * @param target the target object of the action
	 * @param args the arguments that are required to perform the action
	 */
	private void performAction (Entity source, Entity target, RegisterActionArgs args )
	{
		synchronized (isGameoverLock)
		{
			if (isGameover) return; // game is already over
		}
		
		// [On-swap Action] target is swap
		if ( target == Entity.SWAP )
		{
			if ( source == Entity.ARENA || source == Entity.SWAP ) return; // source invalid for operation
			
			Pokemon original, swapped;
			if ( source == Entity.PLAYERONE ) 
			{
				synchronized (playerOneLock)
				{
					original = playerOne.getActiveTeamMember();
					swapped = playerOne.getPokemonTeamMember(args.getSwapIndex());
					// prevent swap is pokemon is unable to battle
					if (swapped == null) return;
					else if (swapped.getHP() <= 0) return;
					
					playerOne.swapActiveTeamMember(args.getSwapIndex());
					
					// clear queue
					synchronized (playerOneTasksLock)
					{
						playerOneTasks.clear();
					}
					
					synchronized (logLock)
					{
						log.push(original.getName() + " swapped with " + swapped.getName() + "\n");
					}
				}
			}
			else if ( source == Entity.PLAYERTWO ) 
			{
				synchronized (playerTwoLock)
				{
					original = playerTwo.getActiveTeamMember();
					swapped = playerTwo.getPokemonTeamMember(args.getSwapIndex());
					// prevent swap is pokemon is unable to battle
					if (swapped == null) return;
					else if (swapped.getHP() <= 0) return;
					
					playerTwo.swapActiveTeamMember(args.getSwapIndex());

					// clear queue
					synchronized (playerTwoTasksLock)
					{
						playerTwoTasks.clear();
					}

					synchronized (logLock)
					{
						log.push(original.getName() + " swapped with " + swapped.getName() + "\n");
					}
				}
			}
		}
		
		// [On-self Action] target is self
		else if ( target == source )
		{
			if ( source == Entity.ARENA || source == Entity.SWAP ) return; // source invalid for operation
			
			if ( source == Entity.PLAYERONE )
			{
				synchronized (playerOneLock)
				{
					// TODO apply affect to Player one
					
					synchronized (logLock)
					{
						log.push(playerOne.getActiveTeamMember().getName() + " used " + args.getMove() + " on itself\n");
					}
				}
			}
			else if ( source == Entity.PLAYERTWO )
			{
				synchronized (playerTwoLock)
				{
					// TODO apply affect to Player two
					
					synchronized (logLock)
					{
						log.push(playerTwo.getActiveTeamMember().getName() + " used " + args.getMove() + " on itself\n");
					}
				}
			}
		}
		
		// [On-Opponent Action] target is pokemon
		else if ( target == Entity.PLAYERONE )
		{
			synchronized (playerOneLock) 
			{ 
			synchronized (playerTwoLock)
			{
				if ( source == Entity.ARENA || source == Entity.SWAP ) return; // source invalid for operation
				int damage = calcDamage(playerOne.getActiveTeamMember(),playerTwo.getActiveTeamMember(), args.getMove());
	
				synchronized (logLock)
				{
					log.push(playerOne.getActiveTeamMember().getName() + " used " + args.getMove() + " on " + playerTwo.getActiveTeamMember().getName() + "\n");
				}
				// TODO damage player one
				// TODO swap active Pokemon is possible
				// TODO declare game over if no swap possible
			}
			}
		}
		else if ( target == Entity.PLAYERTWO )
		{
			synchronized (playerOneLock) 
			{ 
			synchronized (playerTwoLock)
			{
				if ( source == Entity.ARENA || source == Entity.SWAP ) return; // source invalid for operation
				int damage = calcDamage(playerTwo.getActiveTeamMember(),playerOne.getActiveTeamMember(), args.getMove());
				
				synchronized (logLock)
				{
					log.push(playerTwo.getActiveTeamMember().getName() + " used " + args.getMove() + " on " + playerOne.getActiveTeamMember().getName() + "\n");
				}
				// TODO damage player two
				// TODO swap active Pokemon is possible
				// TODO declare game over if no swap possible
			}
			}
		}
		
		// [On-arena Action] target is environmental effect
		else if ( target == Entity.ARENA){
			// TODO change environment
		}
		
		return; // request invalid
	}
	
	/**
	 * Enumeration to define entities
	 * @author Shane
	 *
	 */
	public enum Entity
	{
		PLAYERONE,
		PLAYERTWO,
		SWAP,
		ARENA;
	}
	
	/**
	 * supporting class for managing variable arguments
	 * @author Shane
	 *
	 */
	public class RegisterActionArgs 
	{
		private Move move;
		private int swapIndex;
		public RegisterActionArgs (Move move)
		{
			this.move = move;
			this.swapIndex = 0;
		}
		public RegisterActionArgs (int index)
		{
			this.move = null;
			this.swapIndex = index;
		}
		public Move getMove ()
		{
			return move;
		}
		public int getSwapIndex ()
		{
			return swapIndex;
		}
	}
	
	public class LiteMove
	{
		public String name;
		public int id;
		public int activePeriod;
		public int inactiverPeriod;
		
		public LiteMove (String name, int id, int activePeriod, int inactiverPeriod)
		{
			this.name = name;
			this.id = id;
			this.activePeriod = activePeriod;
			this.inactiverPeriod = inactiverPeriod;
		}
	}
	
	/** 
	 * public class for managing tasks for the timer
	 * @author Shane
	 *
	 */
	public class RegisterTask extends TimerTask
	{		
		private Entity source;
		private Entity target;
		private RegisterActionArgs args;
		private int id;
		private int activePeriod;
		private int inactivePeriod;
		
		public RegisterTask ( Entity source, Entity target, RegisterActionArgs args, int id, int activePeriod, int inactivePeriod)
		{
			super();
			this.source = source;
			this.target = target;
			this.args = args;
			this.id = id;
			this.activePeriod = activePeriod;
			this.inactivePeriod = inactivePeriod;
		}
		public String getMoveName ()
		{
			if (args.swapIndex > 0)
				return "SWAP";
			else
				return args.getMove().name;
		}
		public int getID ()
		{
			return id;
		}
		public int getActivePeriod ()
		{
			return activePeriod;
		}
		public int getInactivePeriod ()
		{
			return inactivePeriod;
		}
		
		@Override
		public void run() {
			performAction( source, target, args);

			synchronized (isGameoverLock)
			{
				if (isGameover) return; // game is already over
			}
			
			// remove task from the proper queue
			if ( source == Entity.PLAYERONE )
			{
				synchronized (playerOneTasksLock)
				{
					playerOneTasks.remove(this);
				}
				// register next task
				TimerTask task = new DelayTask (source);
				timer.schedule(task, inactivePeriod);
				synchronized (playerOneActiveLock)
				{
					playerOneActive = false;
				}
			}
			else if (source == Entity.PLAYERTWO )
			{
				synchronized (playerTwoTasksLock)
				{
					playerTwoTasks.remove(this);
				}
				// register next task
				TimerTask task = new DelayTask (source);
				timer.schedule(task, inactivePeriod);
				synchronized (playerTwoActiveLock)
				{
					playerTwoActive = false;
				}
			}
		}
		
		@Override
		public boolean equals (Object obj)
		{
			if (!(obj instanceof RegisterTask))
				return false;
			
			RegisterTask other = (RegisterTask) obj;
			return this.id == other.id;
		}
		
	}
	
	/**
	 * supporting class for managing delays and next action
	 * @author Shane
	 *
	 */
	class DelayTask extends TimerTask
	{
		Entity player;
		
		public DelayTask (Entity player)
		{
			this.player = player;
		}
		
		@Override
		public void run() {

			synchronized (isGameoverLock)
			{
				if (isGameover) return; // game is already over
			}
			
			// set player inactive
			RegisterTask task;
			if (player == Entity.PLAYERONE)
			{
				// activate next action
				synchronized (playerOneTasksLock)
				{
					task = playerOneTasks.poll();
				}
				
				// check that task is available 
				if (task == null)
				{
					// wait
					timer.schedule(new DelayTask(player), 50);
				}
				
				// perform queued move from map
				synchronized (taskMapLock)
				{
						taskMap.remove(task.getID());
				}
				
				// set active period
				synchronized (playerOneActiveLock)
				{
					playerOneActive = true;
				}
				timer.schedule(task, task.getActivePeriod());
			}
			if (player == Entity.PLAYERTWO)
			{
				// activate next action
				synchronized (playerTwoTasksLock)
				{
					task = playerTwoTasks.poll();
				}
				
				// check that task is available 
				if (task == null)
				{
					// wait
					timer.schedule(new DelayTask(player), 50);
				}
				
				// perform queued move from map
				synchronized (taskMapLock)
				{
						taskMap.remove(task.getID());
				}
				
				// set active period
				synchronized (playerTwoActiveLock)
				{
					playerTwoActive = true;
				}
				timer.schedule(task, task.getActivePeriod());
			}
			
		}
		
	}
	
}
