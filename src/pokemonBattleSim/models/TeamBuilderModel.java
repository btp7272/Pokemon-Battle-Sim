package pokemonBattleSim.models;

import pokemonBattleSim.formulas.*;
import pokemonBattleSim.types.*;
import java.util.*;
import javax.swing.*;
import pokemonBattleSim.views.*;

public class TeamBuilderModel {
	static TeamBuilderModel model;
	static Object owner;
	
	public static void CreateTeamBuilderInstance(Object owner, PokemonTrainer playerOne, PokemonTrainer playerTwo) throws Exception
	{
		if(TeamBuilderModel.owner == null)
			TeamBuilderModel.owner = owner;
		else if(!TeamBuilderModel.owner.equals(owner))
			throw new Exception("Object other than owner is attemtping to change instance");
		
		TeamBuilderModel.model = new TeamBuilderModel(playerOne, playerTwo);
	}
	public static TeamBuilderModel getInstance ()
	{
		return TeamBuilderModel.model;
	}
	
	private PokemonTrainer playerOne;
	private PokemonTrainer playerTwo;
	
	private boolean playerOneActive;
	private boolean playerTwoActive;
	
	private Stack<String> buildLog;
	
	private ArrayList<IPokemonView> views;
	
	private TeamBuilderModel( PokemonTrainer playerOne, PokemonTrainer playerTwo)
	{
		this.views = new ArrayList<>();
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		
		/*
		 * initialize teams to null
		 */
		for(int i = 0; i < 6; i++){
			playerOne.getTeam().add(null);
			playerTwo.getTeam().add(null);
		}
		this.playerOneActive = true;
		this.playerTwoActive = false;
		this.buildLog = new Stack<>();
		logData("----New Builder Model Initalized----");
	}
	
	/*
	 * sets 1st null object in team to pokemon selected
	 */
	public void addToTeam(Pokemon poke, PokemonTrainer player)
	{
		int i = 0;
		for(IPokemon p : player.getTeam())
		{
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
