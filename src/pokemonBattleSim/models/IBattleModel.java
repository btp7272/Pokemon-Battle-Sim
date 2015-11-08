package pokemonBattleSim.models;

import java.util.ArrayList;

import pokemonBattleSim.types.Move;

public interface IBattleModel {
	// Methods for Controller: Registering actions
	public boolean RegisterMove ( int playerID, String moveName, int activePeriod, int inactivePeriod );
	public boolean RegisterSwap ( int playerID, int swapIndex );
	
	// Methods for View: Data Retrieval
	public ArrayList<Boolean> getPlayerAvailablePokemon ( int playerID );
	public ArrayList<Boolean> getOpponentAvailablePokemon ( int playerID );
	public String getPlayerPokemonName ( int playerID, int index );
	public String getOpponentPokemonName ( int playerID, int index );
	public String getPlayerCurrentPokemonIndex ( int playerID);
	public String getOpponentCurrentPokemonIndex ( int playerID);
	public int getPlayerPokemonHP ( int playerID );
	public int getOpponentPokemonHP ( int playerID );
	public ArrayList<String> getMoveData ( int playerID );
	public ArrayList<String> getLogData ();
	public ArrayList<QueuedMove> getTasks ( int playerID );
	public boolean isGameover();
}
