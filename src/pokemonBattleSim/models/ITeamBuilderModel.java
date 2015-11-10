package pokemonBattleSim.models;

import java.util.ArrayList;

import pokemonBattleSim.types.Pokemon;
import pokemonBattleSim.types.PokemonTrainer;

public interface ITeamBuilderModel 
{
	//Methods for Controller
	
	public void addToTeam(Pokemon poke, PokemonTrainer player);
	public void removeFromTeam(int index, PokemonTrainer player);
	public void logData(String s);
	public static ITeamBuilderModel getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Methods for View
	
	
}
