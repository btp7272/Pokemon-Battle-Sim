package pokemonBattleSim.models;

import pokemonBattleSim.formulas.*;
import pokemonBattleSim.types.*;
import java.util.*;
import javax.swing.*;
import pokemonBattleSim.views.*;

public class TeamBuilderModel {
	
	static TeamBuilderModel model;
	
	private Stack<String> buildLog;
	
	private ArrayList<IView> views;
	
	public ArrayList<Pokemon> buildTeam(Pokemon one, Pokemon two, Pokemon three, Pokemon four, Pokemon five, Pokemon six)
	{
		logData("----Building new Team----");
		ArrayList<Pokemon> Team = new ArrayList<Pokemon>();
		
		Team.add(one);
		Team.add(two);
		Team.add(three);
		Team.add(four);
		Team.add(five);
		Team.add(six);
		
		return Team;
	}
	
	/*
	 * Notify the any views of a change that has occured.
	 */
	public void notifyView()
	{
		for (IView view : this.views)
		{
			IView safeView = view;
			if (safeView != null);
			safeView.onViewNotify();
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
