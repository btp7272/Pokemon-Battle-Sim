package pokemonBattleSim.models;

import pokemonBattleSim.formulas.Formula;
import pokemonBattleSim.types.IField;
import pokemonBattleSim.types.IPokemon;
import pokemonBattleSim.types.IPokemonTrainer;
import pokemonBattleSim.types.Move;
import pokemonBattleSim.types.Pokemon;
import pokemonBattleSim.types.Weather;
import pokemonBattleSim.views.IPokemonView;

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
	
	/*
	 * Singleton static methods
	 */
	static BattleModel model;
	static Object owner;
	
	public static void CreateInstance (Object owner, IPokemonTrainer playerOne, IPokemonTrainer playerTwo) throws Exception
	{
		if (BattleModel.owner == null) 
			BattleModel.owner = owner;
		else if (!BattleModel.owner.equals(owner)) 
			throw new Exception ("Object other than the owner attempted to change instance");
		
		BattleModel.model = new BattleModel(playerOne, playerTwo);
	}
	
	public static BattleModel getInstance ()
	{
		return BattleModel.model;
	}
	
	// holds the information for the battle
	private IPokemonTrainer playerOne;
	private IPokemonTrainer playerTwo;
	private Timer timer;
	
	private boolean playerOneActive;
	private boolean playerTwoActive;
	private Queue<BattleTask> playerOneTasks;
	private Queue<BattleTask> playerTwoTasks;
	private Stack<String> log;
	private boolean isGameover;
	private int taskCounter;
	
	private ArrayList<IPokemonView> views;
	
	// Synchronization Lock Objects: required for synchronized sections
	private Object playerOneActiveLock 	= new Object();
	private Object playerTwoActiveLock 	= new Object();
	private Object taskCounterLock 		= new Object();
	private Object isGameoverLock 		= new Object();
	
	public BattleModel ( IPokemonTrainer playerOne, IPokemonTrainer playerTwo )
	{
		this.views = new ArrayList<>();
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.playerOneActive = true;
		this.playerTwoActive = true;
		this.timer = new Timer();
		this.playerOneTasks = new ArrayDeque<>();
		this.playerTwoTasks = new ArrayDeque<>();
		this.taskCounter = 0;
		this.log = new Stack<>();
		timer.schedule(new DelayTask(playerOne), 0);
		timer.schedule(new DelayTask(playerTwo), 0);
	}
	
	/**
	 * will run when game ends automatically, clean up resources
	 */
	public synchronized void gameover ()
	{
		// do nothing if game is already over
		if (isGameover()) return; 
			
		isGameover = true;
	}
	
		/*
	 * Methods for View
	 */
	
	/**
	 * returns whether or not the game is over
	 */
	@Override
	public synchronized boolean isGameover ()
	{
		return isGameover;
	}
	
	/**
	 * get a copy of the log as it was last recorded
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

	public String getPlayerPokemonName ( int playerID, int index )
	{
		if (playerID == this.playerOne.getTrainerID())
			return this.playerOne.getPokemonTeamMember(index).getNickName();
		else if (playerID == this.playerTwo.getTrainerID())
			return this.playerTwo.getPokemonTeamMember(index).getNickName();
		else 
			throw new IllegalArgumentException ("playerID does not match active players");
	}
	
	public String getOpponentPokemonName ( int playerID, int index )
	{
		if (playerID == this.playerOne.getTrainerID())
			return this.playerTwo.getPokemonTeamMember(index).getNickName();
		else if (playerID == this.playerTwo.getTrainerID())
			return this.playerOne.getPokemonTeamMember(index).getNickName();
		else 
			throw new IllegalArgumentException ("playerID does not match active players");
	}
	
	public String getPlayerPokemonName ( int playerID )
	{
		if (playerID == this.playerOne.getTrainerID())
			return this.playerOne.getActiveTeamMember().getNickName();
		else if (playerID == this.playerTwo.getTrainerID())
			return this.playerTwo.getActiveTeamMember().getNickName();
		else 
			throw new IllegalArgumentException ("playerID does not match active players");
	}
	
	public String getOpponentPokemonName ( int playerID )
	{
		if (playerID == this.playerOne.getTrainerID())
			return this.playerTwo.getActiveTeamMember().getNickName();
		else if (playerID == this.playerTwo.getTrainerID())
			return this.playerOne.getActiveTeamMember().getNickName();
		else 
			throw new IllegalArgumentException ("playerID does not match active players");
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
	public ArrayList<QueuedAction> getTasks (int playerID)
	{
		ArrayList<QueuedAction> actions = new ArrayList<>();
		if (playerID == this.playerOne.getTrainerID())
		{
			synchronized (playerOneTasks)
			{
				for ( BattleTask task : playerOneTasks)
					actions.add(new QueuedAction(task.toString(),task.getID(),task.getActivePeriod(),task.getInactivePeriod()));
			}
		}
		else if (playerID == this.playerTwo.getTrainerID())
		{
			synchronized (playerTwoTasks)
			{
				for ( BattleTask task : playerTwoTasks)
					actions.add(new QueuedAction(task.toString(),task.getID(),task.getActivePeriod(),task.getInactivePeriod()));
			}
		}
		else 
			throw new IllegalArgumentException ("playerID does not match active players");

		return actions;
	}

	public void registerView(IPokemonView view)
	{
		IPokemonView safeView = view;
		if (safeView != null)
		this.views.add(safeView);
	}

	public void notifyView()
	{
		for (IPokemonView view : this.views)
		{
			IPokemonView safeView = view;
			if (safeView != null);
			safeView.onViewNotify();
		}
	}
	
	/*
	 * Methods for Controller
	 */
	
	@Override
	public synchronized boolean RegisterMove ( int playerID, String moveName, int activePeriod, int inactivePeriod )
	{
		synchronized (isGameoverLock)
		{
			if (isGameover) return false; // game is already over
		}
		
		if (playerID != this.playerOne.getTrainerID() && playerID != this.playerTwo.getTrainerID() )
			throw new IllegalArgumentException ("playerID does not match active players");
		
		BattleTask task;
		Move move;
		
		// get a new ID for this task
		int taskId;
		synchronized (taskCounterLock) { taskId = taskCounter++; }
		
		// retrieve the move and post create the task
		move = MoveMap.moveMap.get(moveName);
		if (move == null) return false; // invalid move name
		if (activePeriod < 20 || inactivePeriod < 20) return false; // invalid activity times
		
		if (playerID == this.playerOne.getTrainerID())
		{
			synchronized (this.playerOneTasks)
			{
				task = new MoveTask(playerOne, playerTwo, MoveMap.moveMap.get(move), taskId, activePeriod, inactivePeriod);
				playerOneTasks.add(task);
			}
		}
		else if (playerID == this.playerTwo.getTrainerID())
		{
			synchronized (this.playerTwoTasks)
			{
				task = new MoveTask(playerTwo, playerOne, MoveMap.moveMap.get(move), taskId, activePeriod, inactivePeriod);
				playerTwoTasks.add(task);
			}
		}
		else return false; // playerID doesn't match anyone
		notifyView();
		return true;
	}

	public synchronized boolean RegisterSwap ( int playerID, int swapIndex )
	{
		synchronized (isGameoverLock)
		{
			if (isGameover) return false; // game is already over
		}
		
		if (playerID != this.playerOne.getTrainerID() && playerID != this.playerTwo.getTrainerID() )
			throw new IllegalArgumentException ("playerID does not match active players");
		
		BattleTask task;
		int activePeriod = 20;
		int inactivePeriod = 20;

		// get a new ID for this task
		int taskId;
		synchronized (taskCounterLock) { taskId = taskCounter++; }
		
		if (playerID == this.playerOne.getTrainerID())
		{
			synchronized (this.playerOneTasks)
			{
				task = new SwapTask(playerOne, playerTwo, swapIndex, taskId, activePeriod, inactivePeriod);
			}
		}
		else if (playerID == this.playerTwo.getTrainerID())
		{
			synchronized (this.playerTwoTasks)
			{
				task = new SwapTask(playerTwo, playerOne, swapIndex, taskId, activePeriod, inactivePeriod);
			}
		}
		else return false; // playerID doesn't match anyone
		notifyView();
		return true;
	}
	
	public boolean DeregisterAction ( int playerID, int index )
	{
		int counter = 0;
		BattleTask taskToRemove;
		if (playerID == this.playerOne.getTrainerID())
		{
			synchronized (this.playerOneTasks)
			{
				if (counter < playerOneTasks.size()) return false;
				for (BattleTask task : playerOneTasks)
				{
					if (counter != index)
					{
						counter++; 
						continue;
					}
						
					playerOneTasks.remove(task);
					break;
				}
			}
		}
		else if (playerID == this.playerTwo.getTrainerID())
		{
			synchronized (this.playerTwoTasks)
			{
				if (counter < playerTwoTasks.size()) return false;
				for (BattleTask task : playerTwoTasks)
				{
					if (counter != index)
					{
						counter++; 
						continue;
					}
						
					playerTwoTasks.remove(task);
					break;
				}
			}
		}
		else return false;
		
		notifyView();
		return true;
	}
	
	/*
	 * Methods and Types for the Model
	 */
	
	public void executeMove(IPokemonTrainer source, IPokemonTrainer target, Move move) {
		synchronized (playerOne) { synchronized (playerTwo)
		{
		IPokemon attacker = source.getActiveTeamMember();
		IPokemon defender = target.getActiveTeamMember();
		// calculate and apply the damage
		int damage = Formula.calcDamage(attacker, defender, move, new IField() {

			@Override
			public Weather setWeather(Weather weather) {
				return null;
			}

			@Override
			public Weather getWeather() {
				return null;
			}});
		
		defender.changeHP(damage);
		
		
		// log the move
		synchronized (log)
		{
			log.push(attacker.getSpeciesName() + " used " + move.toString() + " on " + defender.getSpeciesName() + "\n");
		}
		
		// check for fainting
		if (attacker.getHP() <=0 )
		{
			int availablePokemon = 0;
			for (int i = 0; i < 6; i++)
			{
				if (source.getPokemonTeamMember(i).getHP() > 0)
					availablePokemon++;
			}
			if (availablePokemon == 0)
			{
				gameover();
			}
		}
		
		if (defender.getHP() <=0 )
		{
			int availablePokemon = 0;
			for (int i = 0; i < 6; i++)
			{
				if (source.getPokemonTeamMember(i).getHP() > 0)
					availablePokemon++;
			}
			if (availablePokemon == 0)
			{
				gameover();
			}
		}
		
		}} // synchronized (playerOne),(playerTwo)
		notifyView();
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
			notifyView();
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
		
		@Override
		public String toString ()
		{
			return "BattleTask";
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
			notifyView();
		}

		@Override
		public String toString ()
		{
			return move.toString();
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
			synchronized (playerOneActiveLock) { synchronized (playerTwoActiveLock)
			{	
				if (playerOneActive || playerTwoActive){
					return;
				}
				if (this.source.getTrainerID() == playerOne.getTrainerID())
				{
					playerOneTasks.clear();
				}
				else if (this.source.getTrainerID() == playerTwo.getTrainerID())
				{
					playerTwoTasks.clear();
				}
				
				this.source.setActiveTeamMember(swapIndex);
			}}
		}
		
		@Override
		public String toString ()
		{
			return "Swap to " + swapIndex;
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
