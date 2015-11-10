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
	public String generateMoves(Pokemon poke);
	
	//Methods for View
	
	
}
