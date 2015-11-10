package pokemonBattleSim.models;

import pokemonBattleSim.formulas.*;
import pokemonBattleSim.types.*;
import java.util.*;
import javax.swing.*;
import pokemonBattleSim.views.*;

public class TeamBuilderModel {
	
	static TeamBuilderModel model;
	
	private Stack<String> buildLog;
	
	private ArrayList<IPokemonView> views;
	
	public ArrayList<Pokemon> buildTeam(PokemonTrainer player, Pokemon one, Pokemon two, Pokemon three, Pokemon four, Pokemon five, Pokemon six)
	{
		logData("----Building new Team for player: "+player.getTrainerID()+"----");
		ArrayList<Pokemon> Team = null;
		
		addToTeam(one, player);
		addToTeam(two, player);
		addToTeam(three, player);
		addToTeam(four, player);
		addToTeam(five, player);
		addToTeam(six, player);
		
		return Team;
	}
	
	public void notifyView()
	{
		for (IPokemonView view : this.views)
		{
			IPokemonView safeView = view;
			if (safeView != null);
			safeView.onViewNotify();
		}
	}
	
	public String generateAbilities(String poke)
	{
		Pokemon temp = new Pokemon(SpeciesMap.speciesMap.get(poke));
		String abilities = new String();
		
		/*
		 * Retrieve list of valid abilities in form ability, ability, ability
		 */
		//temp move set
		abilities = "Drizzle, Drought, Forecast";
		return abilities;
	}
	
	public String generateMoves(String poke)
	{
		Pokemon temp = new Pokemon(SpeciesMap.speciesMap.get(poke));
		String moves = new String();  
		
		/*
		 * Retrieve list of valid moves in form move, move, move
		 */
		
		//Temporary move set
		moves = "Tackle, Flamethrower, Thunderbolt";
		return moves;
	}
	
	
	/*
	 * sets 1st null object in team to pokemon selected
	 */
	public void addToTeam(Pokemon poke, PokemonTrainer player)
	{
		int i = 0;
		for(IPokemon p : player.getTeam())
		{
			if(i > 5)
				return;
			if(p == null)
			{
				player.getTeam().set(i, poke);
				logData("Player ID: "+player.getTrainerID()+" added "+poke.getSpeciesName()+" to team in position "+i);
				return;
			}
			i++;
		}
	}

	/*
	 * Remove pokemon from a team
	 */
	public void removeFromTeam(int index, PokemonTrainer player)
	{
		logData("Player ID: "+player.getTrainerID()+" removed "+player.getTeam().get(index).getSpeciesName()+" from position "+index);
		player.getTeam().set(index, null);
	}
	
	/*
	 * Log data
	 */
	public void logData(String s)
	{
		synchronized (buildLog)
		{
			buildLog.push(s);
		}
	}

	public static TeamBuilderModel getInstance() {
		return TeamBuilderModel.model;
	}
	
}
