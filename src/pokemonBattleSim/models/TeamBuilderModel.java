package pokemonBattleSim.models;

import pokemonBattleSim.formulas.*;
import pokemonBattleSim.types.*;
import java.util.*;
import javax.swing.*;
import pokemonBattleSim.views.*;

public class TeamBuilderModel {
	static TeamBuilderModel model;
	static Object owner;
	
	public static void CreateTeamBuilderInstance(Object owner, IPokemonTrainer playerOne, IPokemonTrainer playerTwo) throws Exception
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
	
	private IPokemonTrainer playerOne;
	private IPokemonTrainer playerTwo;
	
	private boolean playerOneActive;
	private boolean playerTwoActive;
	
	private Stack<String> log;
	
	private ArrayList<IPokemonView> views;
	
	private TeamBuilderModel( IPokemonTrainer playerOne, IPokemonTrainer playerTwo)
	{
		this.views = new ArrayList<>();
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.playerOneActive = false;
		this.playerTwoActive = false;
		this.log = new Stack<>();
	}
}
