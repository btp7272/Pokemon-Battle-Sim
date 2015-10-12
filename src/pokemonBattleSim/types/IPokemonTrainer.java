package pokemonBattleSim.types;

import java.util.ArrayList;

public interface IPokemonTrainer {
	public ArrayList<Pokemon> getPokemonTeam ();
	
	public Pokemon getPokemonTeamMember ();
	public boolean setPokemonTeamMember ( int index, Pokemon pokemon );
	
	public Pokemon getActiveTeamMember ();
	public boolean swapActiveTeamMember ( int targetIndex );
	
	public int getPokemonTeamID (Pokemon pokemon);
}
