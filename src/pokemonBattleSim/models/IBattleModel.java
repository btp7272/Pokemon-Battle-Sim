package pokemonBattleSim.models;

import java.util.ArrayList;

import pokemonBattleSim.types.Move;
import pokemonBattleSim.views.IPokemonView;

public interface IBattleModel {
	// Methods for Controller: Registering actions
	public boolean RegisterMove ( int playerID, String moveName, int activePeriod, int inactivePeriod );
	public boolean RegisterSwap ( int playerID, int swapIndex );
	public boolean DeregisterAction ( int playerID, int index );
	
	// Methods for View: Data Retrieval
	public ArrayList<Boolean> getPlayerAvailablePokemon ( int playerID );
	public ArrayList<Boolean> getOpponentAvailablePokemon ( int playerID );
	public String getPlayerPokemonName ( int playerID, int index );
	public String getOpponentPokemonName ( int playerID, int index );
	public String getPlayerPokemonName ( int playerID);
	public String getOpponentPokemonName ( int playerID);
	public int getPlayerPokemonHP ( int playerID );
	public int getOpponentPokemonHP ( int playerID );
	public ArrayList<String> getMoveData ( int playerID );
	public ArrayList<String> getLogData ();
	public ArrayList<QueuedMove> getTasks ( int playerID );
	public boolean isGameover();
	
	// Methods for View: Notification
	public void registerView(IPokemonView view);
	public void notifyView();
}
