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
		logData("----Building new Team for player: "+player.getTrainerID()+"----");
		ArrayList<Pokemon> Team = null;
			
		String poke = "Pikachu";
		String nickname = "pika";
		
		Move[] moves = new Move[4];
			moves[1] = MoveMap.moveMap.get("Tackle");
			moves[2] = MoveMap.moveMap.get("Tackle");
			moves[3] = MoveMap.moveMap.get("Tackle");
			moves[4] = MoveMap.moveMap.get("Tackle");
		int[] IVs = {31,31,31,31,31,31};
		int[] EVs = {85,85,85,85,85,85};
		Pokemon temp = new Pokemon(SpeciesMap.speciesMap.get(poke), nickname, moves, IVs, EVs, 100, Nature.Timid);
		
		for(int i = 0; i < 6; i++)
		{
			addToTeam(temp, player);
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
