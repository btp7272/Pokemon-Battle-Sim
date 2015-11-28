package pokemonBattleSim.models;

import pokemonBattleSim.formulas.Formula;
import pokemonBattleSim.types.Attribute;
import pokemonBattleSim.types.Event;
import pokemonBattleSim.types.EventType;
import pokemonBattleSim.types.IField;
import pokemonBattleSim.types.IPokemon;
import pokemonBattleSim.types.IPokemonTrainer;
import pokemonBattleSim.types.Move;
import pokemonBattleSim.types.Pokemon;
import pokemonBattleSim.types.Weather;
import pokemonBattleSim.views.IView;

import static pokemonBattleSim.formulas.Formula.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

public class OnlineBattleModel implements IBattleModel
{
	// Methods for Controller: Registering actions
		public boolean RegisterMove ( int playerID, String moveName, int activePeriod, int inactivePeriod );
		public boolean RegisterSwap ( int playerID, int swapIndex );
		public boolean DeregisterAction ( int playerID, int index );
		
		// Methods for View: Data Retrieval
		public ArrayList<Boolean> getPlayerAvailablePokemon ( int playerID );
		public ArrayList<Boolean> getOpponentAvailablePokemon ( int playerID );
		public String getPlayerPokemonSpeciesName ( int playerID, int index );
		public String getOpponentPokemonSpeciesName ( int playerID, int index );
		public String getPlayerPokemonSpeciesName ( int playerID );
		public String getOpponentPokemonSpeciesName ( int playerID );
		public String getPlayerPokemonName ( int playerID, int index );
		public String getOpponentPokemonName ( int playerID, int index );
		public String getPlayerPokemonName ( int playerID );
		public String getOpponentPokemonName ( int playerID );
		public int getPlayerPokemonHP ( int playerID );
		public int getOpponentPokemonHP ( int playerID );
		public IPokemon getPlayerPokemon ( int playerID );
		public IPokemon getOpponentPokemon ( int playerID );
		public IField getField();
		public ArrayList<String> getMoveData ( int playerID );
		public ArrayList<String> getLogData ();
		public ArrayList<QueuedAction> getTasks ( int playerID );
		public boolean isGameover();
		
		// Methods for View: Notification
		public void registerView(IView view);
		public void notifyView();
}
