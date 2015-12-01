package pokemonBattleSim.types;

import java.util.ArrayList;

public class PokemonTrainer implements IPokemonTrainer
{
	// private fields
	private static int PokemonTrainerID = 0;
	
	// instance fields
	private ArrayList<IPokemon> team;
	private int activePokemon;
	private int trainerID;
	
	public ArrayList<IPokemon> getTeam()
	{
		return this.team;
	}
	
	public PokemonTrainer ()
	{
		this.team = new ArrayList<> ();
		this.activePokemon = 0;
		this.trainerID = PokemonTrainerID++; 
	}
	
	public PokemonTrainer (ArrayList<Pokemon> team)
	{
		if (team.size() != 6) 
			throw new IllegalArgumentException ("Invalid Team size passed to Pokemon Trainer Constructor");
		
		this.team = new ArrayList<> ();
		for ( Pokemon initializer : team)
		{
			this.team.add(initializer);
		}
		this.activePokemon = 0;
		this.trainerID = PokemonTrainerID++; 
	}
	
	@Override
	public IPokemon getPokemonTeamMember (int index)
	{
		if (index < 0 || index >= this.team.size())
			throw new IllegalArgumentException ("index must be between 0-6");
		
		return this.team.get(index);
	}
	
	@Override
	public int getPokemonTeamMemberHP (int index)
	{
		if (index < 0 || index >= this.team.size())
			throw new IllegalArgumentException ("index must be between 0-6");
		
		return this.team.get(index).getHP();
	}
	
	@Override
	public IPokemon getActiveTeamMember () {
		return this.team.get(activePokemon);
	}

	@Override
	public boolean setActiveTeamMember(int index) {
		if (index < 0 || index >= this.team.size())
			throw new IllegalArgumentException ("index must be between 0-6");
		
		if (this.team.get(index).getHP() <= 0)
			return false;
		
		this.activePokemon = index;
		return true;
	}

	@Override
	public int getTrainerID() {
		return this.trainerID;
	}

	
}
