package pokemonBattleSim.models;

import java.util.ArrayList;

import pokemonBattleSim.types.Move;

public interface IBattleModel {
	// Methods for Controller: Registering actions
	public boolean RegisterMove ( int playerID, Entity target, Move move, int activePeriod, int inactivePeriod );
	public boolean RegisterSwap ( int playerID, int swapIndex );
	
	// Methods for View: Data Retrieval
	public ArrayList<Boolean> getPlayerAvailablePokemon ( int playerID );
	public ArrayList<Boolean> getOpponentAvailablePokemon ( int playerID );
	public int getPlayerPokemonHP ( int playerID );
	public int getOpponentPokemonHP ( int playerID );
	public ArrayList<String> getMoveData ( int playerID );
	public ArrayList<String> getLogData ();
	public ArrayList<QueuedMove> getTasks ( int playerID );
	public boolean isGameover();
}
