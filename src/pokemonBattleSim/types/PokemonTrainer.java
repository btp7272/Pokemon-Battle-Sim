package pokemonBattleSim.types;

import java.util.ArrayList;

public class PokemonTrainer implements IPokemonTrainer
{
	private ArrayList<Pokemon> team;
	private Object teamLock = new Object();
	
	public PokemonTrainer (ArrayList<Pokemon> team)
	{
		this.team = team;
	}
	
	@Override
	public ArrayList<Pokemon> getPokemonTeam() 
	{
		return team;
	}

	@Override
	public Pokemon getPokemonTeamMember(int index) 
	{
		if (this.team == null || team.isEmpty())
			return null;

		if (index < 0 || index >= team.size())
			return null;
		
		return team.get(index);
	}

	@Override
	public boolean setPokemonTeamMember(int index, Pokemon pokemon) 
	{
		if (team == null)
			return false;
		
		if (index < 0 || index >= 6 || index >= (team.size() == 0 ? 1 : team.size()))
			return false;
		
		if (pokemon == null)
			return false;
		
		synchronized (teamLock)
		{
			this.team.set(index, pokemon);
			return true;
		}
	}

	@Override
	public Pokemon getActiveTeamMember() {
		if (this.team == null || team.isEmpty())
			return null;
		
		return this.team.get(0);
	}

	@Override
	public boolean swapActiveTeamMember(int index) {
		if (this.team == null || team.isEmpty())
			return false;
		
		if (index < 0 || index >= team.size())
			return false;
		
		synchronized (teamLock)
		{
			Pokemon initial = team.get(0);
			Pokemon swapped = team.get(index);
			Pokemon temp = initial;
			team.set(0, swapped);
			team.set(index, temp);
		}
		
		return false;
	}

	
}
