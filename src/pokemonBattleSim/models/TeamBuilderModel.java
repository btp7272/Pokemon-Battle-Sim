package pokemonBattleSim.models;

import pokemonBattleSim.formulas.*;
import pokemonBattleSim.types.*;
import java.util.*;
import javax.swing.*;
import pokemonBattleSim.views.*;

public class TeamBuilderModel {
	
	private Stack<String> buildLog;
	
	private ArrayList<IPokemonView> views;
	
	public ArrayList<Pokemon> buildTeam(PokemonTrainer player)
	{
		ArrayList<Pokemon> Team = null;
		while(teamVacancy(player))
		{
			ArrayList<String> poke = promptPlayer();
			Move[] moves = promptMoves();
			int[] IVs = promptIVs();
			int[] EVs = promptEVs();
			Pokemon temp = new Pokemon(SpeciesMap.speciesMap.get(poke.get(0)), poke.get(1), moves, IVs, EVs, 100, Nature.Timid);
			
		}
		
		return Team;
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
	
	public int[] promptIVs()
	{
		
	}
	
	/*
	 * Todo
	 * 
	 * PromptMoves take input from player in form of move names until there are 4 objects in the array list, then return that list.
	 */
	public Move[] promptMoves()
	{
		Move[] moves = new Move[4];
		while(moveVacancy(moves))
		{
			/*
			 * Replace with asking for moves
			 */
			moves[1] = MoveMap.moveMap.get("Tackle");
			moves[2] = MoveMap.moveMap.get("Tackle");
			moves[3] = MoveMap.moveMap.get("Tackle");
			moves[4] = MoveMap.moveMap.get("Tackle");
		}
		return moves;
	}
	
	
	/*
	 * Todo
	 * 			PromptPlayer will take input from the player in form a pokemon name and feed it to the team builder.
	 * 		It will also ask for a nickname.
	 */
	public ArrayList<String> promptPlayer()
	{
		ArrayList<String> names = null;
		names.add("Pikachu");
		names.add("pikapika");
		return names;
	}
	
	/*
	 * determine if there are any vacancies on the team
	 */
	public boolean teamVacancy(PokemonTrainer player)
	{
		boolean vacancy = false;
		for(int i = 0; i < 6; i ++)
		{
			if(player.getPokemonTeamMember(i) == null)
				vacancy = true;
		}
		return vacancy;
	}
	
	/*
	 * determine if there are any vacancies in the move list
	 */
	public boolean moveVacancy(Move [] moves)
	{
		boolean vacancy = false;
		for(int i = 0; i < 4; i ++)
		{
			if(moves[i] == null)
				vacancy = true;
		}
		return vacancy;
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
	
}
