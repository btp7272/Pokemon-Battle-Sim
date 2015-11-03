package pokemonBattleSim.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import pokemonBattleSim.models.BattleModel;
import pokemonBattleSim.models.BattleModel.Entity;
import pokemonBattleSim.models.MoveMap;
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
		this.timer.schedule(new UpdateUITask(), 0, 10);
	}
	
	class UpdateUITask extends TimerTask
	{
		@Override
		public void run() {
			// TODO Update UI move properly
			view.setPlayerOnePokemonHP(model.getPokemonHealth(Entity.PLAYERONE, 0));
			view.setPlayerTwoPokemonHP(model.getPokemonHealth(Entity.PLAYERTWO, 0));
			ArrayList<BattleModel.LiteMove> moveList = model.getTasks(Entity.PLAYERONE);
			ArrayList<String> moveStrings = new ArrayList<>();
			for (BattleModel.LiteMove move : moveList)
			{
				moveStrings.add(move.name);
			}
			view.setMoveQueueData(moveStrings, new QueueButtonListener());
			/*if (!model.getLog().isEmpty())
			{
				view.displayPopupMessage(model.getLog().pop());
			}*/
			//view.setMoveButtonData(moves, moveButtonListener);
		}	
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
			BattleModel.RegisterActionArgs args = model.new RegisterActionArgs(MoveMap.Pound);
			model.registerAction(Entity.PLAYERONE, Entity.PLAYERTWO, args, 1000, 2000);
			timer.schedule(new UpdateUITask(), 0);
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
