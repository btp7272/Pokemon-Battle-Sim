package pokemonBattleSim.models;

import pokemonBattleSim.types.IPokemon;
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

public class BattleModel implements IBattleModel {
	
	// holds the information for the battle
	private IPokemonTrainer playerOne;
	private IPokemonTrainer playerTwo;
	private Timer timer;
	
	private boolean playerOneActive;
	private boolean playerTwoActive;
	private Queue<MoveTask> playerOneTasks;
	private Queue<MoveTask> playerTwoTasks;
	private Map<Integer, MoveTask> taskMap;
	private Stack<String> log;
	private boolean isGameover;
	private int taskCounter;
	
	// Synchronization Lock Objects: required for synchronized sections
	private Object playerOneActiveLock 	= new Object();
	private Object playerTwoActiveLock 	= new Object();
	private Object taskMapLock 			= new Object();
	private Object taskCounterLock 		= new Object();
	private Object isGameoverLock 		= new Object();
	
	public BattleModel ( IPokemonTrainer playerOne, IPokemonTrainer playerTwo, Timer timer)
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
		timer.schedule(new DelayTask(Entity.PLAYERONE), 0);
		timer.schedule(new DelayTask(Entity.PLAYERTWO), 0);
	}
	
	/**
	 * will run when game ends automatically, clean up resources
	 */
	public void gameover ()
	{
		// do nothing if game is already over
		if (isGameover()) return; 
			
		isGameover = true;
	}
	
	@Override
	public synchronized boolean isGameover ()
	{
		return isGameover;
	}
	
	
	/**
	 * get the last 5 elements in the log
	 * @return a Stack of 5 elements or fewer
	 */
	@Override
	public ArrayList<String> getLogData ()
	{
		ArrayList<String> output = new ArrayList<>();
		synchronized (log)
		{
			for ( String logMessage : log)
			{
				output.add(logMessage);
			}
		}
		return output;
	}
	
	@Override
	public ArrayList<Boolean> getPlayerAvailablePokemon (int playerID)
	{
		ArrayList<Boolean> availability = new ArrayList<>();
		IPokemonTrainer trainer;
		if (playerID == this.playerOne.getTrainerID())
			trainer = this.playerOne;
		else if (playerID == this.playerTwo.getTrainerID())
			trainer = this.playerTwo;
		else 
			throw new IllegalArgumentException ("playerID does not match active players");
		
		for (int i = 0; i < 6; i++)
		{
			availability.set(i, (trainer.getPokemonTeamMember(i).getHP() > 0) );
		}
		
		return availability;
	}

	@Override
	public ArrayList<Boolean> getOpponentAvailablePokemon ( int playerID )
	{
		ArrayList<Boolean> availability = new ArrayList<>();
		IPokemonTrainer trainer;
		if (playerID == this.playerOne.getTrainerID())
			trainer = this.playerTwo;
		else if (playerID == this.playerTwo.getTrainerID())
			trainer = this.playerOne;
		else 
			throw new IllegalArgumentException ("playerID does not match active players");
		
		for (int i = 0; i < 6; i++)
		{
			availability.set(i, (trainer.getPokemonTeamMember(i).getHP() > 0) );
		}
		
		return availability;
	}

	@Override
	public int getPlayerPokemonHP ( int playerID )
	{
		if (playerID == this.playerOne.getTrainerID())
			return this.playerOne.getActiveTeamMember().getHP();
		else if (playerID == this.playerTwo.getTrainerID())
			return this.playerTwo.getActiveTeamMember().getHP();
		else 
			throw new IllegalArgumentException ("playerID does not match active players");
	}

	@Override
	public int getOpponentPokemonHP (int playerID)
	{
		if (playerID == this.playerOne.getTrainerID())
			return this.playerTwo.getActiveTeamMember().getHP();
		else if (playerID == this.playerTwo.getTrainerID())
			return this.playerOne.getActiveTeamMember().getHP();
		else 
			throw new IllegalArgumentException ("playerID does not match active players");
	}
	
	public ArrayList<String> getMoveData (int playerID)
	{
		ArrayList<String> moveNames = new ArrayList<>();
		IPokemon pokemon;
		if (playerID == this.playerOne.getTrainerID())
			pokemon = this.playerOne.getActiveTeamMember();
		else if (playerID == this.playerTwo.getTrainerID())
			pokemon = this.playerTwo.getActiveTeamMember();
		else 
			throw new IllegalArgumentException ("playerID does not match active players");
		
		for (int i = 1; i <= 4; i++)
		{
			synchronized (pokemon)
			{
				moveNames.add(pokemon.getMove(i).getName());
			}
		}
		
		return moveNames;
	}
	
	/**
	 * get a list of simplified queued moves for the view
	 * @param playerID
	 * @return
	 */
	@Override
	public ArrayList<QueuedMove> getTasks (int playerID)
	{
		ArrayList<QueuedMove> moves = new ArrayList<>();
		if (playerID == this.playerOne.getTrainerID())
		{
			synchronized (playerOneTasks)
			{
				for ( MoveTask task : playerOneTasks)
					moves.add(new QueuedMove(task.getMoveName(),task.getID(),task.getActivePeriod(),task.getInactivePeriod()));
			}
		}
		else if (playerID == this.playerTwo.getTrainerID())
		{
			synchronized (playerTwoTasks)
			{
				for ( RegisterTask task : playerTwoTasks)
					moves.add(new QueuedMove(task.getMoveName(),task.getID(),task.getActivePeriod(),task.getInactivePeriod()));
			}
		}
		else 
			throw new IllegalArgumentException ("playerID does not match active players");

		return moves;
	}
	
	@Override
	public synchronized boolean RegisterMove ( int playerID, Entity target, Move move, int activerPeriod, int inactiverPeriod )
	{
		synchronized (isGameoverLock)
		{
			if (isGameover) return false; // game is already over
		}
		
		
		if (playerID == this.playerOne.getTrainerID())
		{
			synchronized (this.playerOneTasks)
			{
				if (target == Entity.ENEMY)
				{
					
				}
			}
		}
		else if (playerID == this.playerTwo.getTrainerID())
		{
			
		}
		else throw new IllegalArgumentException ("playerID does not match active players");
		return true;
	}
	
	/**
	 * register a new action to the queues
	 * task are NOT registered to the timer yet
	 * @param souce the entity initiating the action (move, swap)
	 * @param target the target of the move
	 * @param args an object containing either a swap index or move
	 * @param activePeriod how long the move will take
	 * @param inactivePeriod how long to wait after the move
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
				Pokemon pokemon = playerOne.getActiveTeamMember();
				pokemon.changeHP(damage);
				if (pokemon.getHP()<=0)
				{
					// Pokemon has fainted
					int availablePokemon = 0;
					for (Pokemon p : playerOne.getPokemonTeam())
					{
						if (p.getHP() > 0)
							availablePokemon++;
					}
					if (availablePokemon == 0)
					{
						gameover();
					}
				}
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
				
				Pokemon pokemon = playerTwo.getActiveTeamMember();
				pokemon.changeHP(damage);
				if (pokemon.getHP()<=0)
				{
					// Pokemon has fainted
					int availablePokemon = 0;
					for (Pokemon p : playerTwo.getPokemonTeam())
					{
						if (p.getHP() > 0)
							availablePokemon++;
					}
					if (availablePokemon == 0)
					{
						gameover();
					}
				}
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
	
	
	/** 
	 * public class for managing tasks for the timer
	 * @author Shane
	 *
	 */
	private abstract class BattleTask extends TimerTask
	{
		protected final IPokemonTrainer source;
		protected final IPokemonTrainer target;
		private final int id;
		private final int activePeriod;
		private final int inactivePeriod;
		private boolean valid;
		
		public BattleTask (IPokemonTrainer source, IPokemonTrainer target, int id, int activePeriod, int inactivePeriod)
		{
			super();
			this.source = source;
			this.target = target;
			this.id = id;
			this.activePeriod = activePeriod;
			this.inactivePeriod = inactivePeriod;
			this.valid = true;
		}
	
		public final int getID ()
		{
			return this.id;
		}
		public final int getActivePeriod ()
		{
			return this.activePeriod;
		}
		public final int getInactivePeriod ()
		{
			return this.inactivePeriod;
		}
		
		public final void run ()
		{
			if (!this.valid) return;
			if (isGameover()) return;
			execute();
			remove();
		}
		
		public abstract void execute();
		
		private final void remove ()
		{
			if (!this.valid) return;
			
			// remove task from the proper queue
			if ( source == playerOne )
			{
				synchronized (playerOneTasks)
				{
					playerOneTasks.remove(this);
				}
				
				// register next task
				TimerTask task = new DelayTask(source);
				timer.schedule(task, inactivePeriod);
				synchronized (playerOneActiveLock)
				{
					playerOneActive = false;
				}
			}
			else if ( source == playerTwo )
			{
				synchronized (playerTwoTasks)
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
			
			this.valid = false;
		}
		
		@Override
		public final boolean equals (Object obj)
		{
			if (!(obj instanceof BattleTask))
				return false;
			
			BattleTask other = (BattleTask) obj;
			return this.id == other.id;
		}
	}
	
	private class MoveTask extends BattleTask
	{		
		private Move move;
		
		public MoveTask ( IPokemonTrainer source, IPokemonTrainer target, Move move, int id, int activePeriod, int inactivePeriod)
		{
			super(source, target, id, activePeriod, inactivePeriod);
			this.move = move;
		}
		
		@Override
		public void execute() {
			executeMove(source, target, move);
		}
	}
	
	private class SwapTask extends BattleTask
	{		
		private int swapIndex;
		
		public SwapTask ( IPokemonTrainer source, IPokemonTrainer target, int swapIndex, int id, int activePeriod, int inactivePeriod)
		{
			super(source, target, id, activePeriod, inactivePeriod);
			this.swapIndex = swapIndex;
		}
		
		@Override
		public void execute() {
			if (!playerOneActive && !playerTwoActive)
				this.source.setActiveTeamMember(swapIndex);
		}
	}
	
	/**
	 * supporting class for managing delays and next action
	 * @author Shane
	 *
	 */
	class DelayTask extends TimerTask
	{
		IPokemonTrainer player;
		
		public DelayTask (IPokemonTrainer player)
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
			BattleTask task;
			if (player.getTrainerID() == playerOne.getTrainerID())
			{
				// activate next action
				synchronized (playerOneTasks)
				{
					task = playerOneTasks.poll();
				}
				
				// check that task is available 
				if (task == null)
				{
					// wait
					timer.schedule(new DelayTask(player), 50);
					return;
				}
				
				// perform queued move from map
				synchronized (taskMapLock)
				{
					if (taskMap == null)
					{
						timer.schedule(new DelayTask(player), 50);
						return;
					}
					taskMap.remove(task.getID());
				}
				
				// set active period
				synchronized (playerOneActiveLock)
				{
					playerOneActive = true;
				}
				timer.schedule(task, task.getActivePeriod());
			}
			if (player.getTrainerID() == playerTwo.getTrainerID())
			{
				// activate next action
				synchronized (playerTwoTasks)
				{
					task = playerTwoTasks.poll();
				}
				
				// check that task is available 
				if (task == null)
				{
					// wait
					timer.schedule(new DelayTask(player), 50);
					return;
				}
				
				// perform queued move from map
				synchronized (taskMapLock)
				{
					if (taskMap == null)
					{
						timer.schedule(new DelayTask(player), 50);
						return;
					}
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
