package pokemonBattleSim.types;

import java.util.ArrayList;

public interface IPokemonTrainer {
	public int getTrainerID ();
	public IPokemon getPokemonTeamMember ( int index );
	public int getPokemonTeamMemberHP ( int index );
	
	public IPokemon getActiveTeamMember ();
	public boolean setActiveTeamMember ( int index );
}
