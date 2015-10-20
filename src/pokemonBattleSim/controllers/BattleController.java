package pokemonBattleSim.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;

import pokemonBattleSim.models.BattleModel;
import pokemonBattleSim.types.IPokemonTrainer;
import pokemonBattleSim.types.Move;
import pokemonBattleSim.types.Pokemon;
import pokemonBattleSim.types.PokemonTrainer;
import pokemonBattleSim.views.BattleView;

public class BattleController {

	private BattleView view;
	private BattleModel model;
	private Map<Integer,ArrayList<String>> moveMap;
	private Timer timer;
	
	public BattleController(BattleView view, BattleModel model, Timer timer, Map<Integer, ArrayList<String>> moveMap, IPokemonTrainer user, IPokemonTrainer com) {
		// TODO Auto-generated constructor stub
		this.view = view;
		this.model = model;
		this.timer = timer;
		this.moveMap = moveMap;
		
		// load the data for the starter pokemon
		this.view.setPlayerOnePokemonName(user.getActiveTeamMember().getName());
		this.view.setPlayerOnePokemonHP(user.getActiveTeamMember().getHP());
		
		// TODO IMPORTANT, image names do NOT correlate with pokemon names that include ANY spacing for various reasons.
		// 	Mega-Pokemon in particular do not correlate
		//  Pokemon with many forms do not correlate
		this.view.setPlayerOnePokemonDisplayImage(user.getActiveTeamMember().getName().toLowerCase());
		this.view.setPlayerTwoPokemonName(com.getActiveTeamMember().getName());
		this.view.setPlayerTwoPokemonHP(com.getActiveTeamMember().getHP());
		this.view.setPlayerTwoPokemonDisplayImage(com.getActiveTeamMember().getName().toLowerCase());
		
		this.view.setMoveButtonData(moveMap.get(0), new MoveButtonListener());
		ArrayList<String> userPokemon = new ArrayList<>();
		for (Pokemon poke : user.getPokemonTeam())
		{
			userPokemon.add(poke.getName());
		}
		this.view.setPokemonButtonData(userPokemon, new PokemonButtonListener());
	}
	
	class QueueButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			//TODO
		}	
	}
	
	class MoveButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			//TODO
		}	
	}
	
	class PokemonButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e)
		{
			//TODO
		}
	}
}
