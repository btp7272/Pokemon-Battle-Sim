package pokemonBattleSim.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;

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
	private int playerID;
	
	public BattleController(BattleView view, BattleModel model, int playerID) {
		// TODO Auto-generated constructor stub
		this.view = view;
		this.model = model;
		this.playerID = playerID;
		
		this.view.addMouseMotionListener(new MoveButtonListener());
		this.view.addPokemonButtonListner(new PokemonButtonListener());
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
			JButton btn = (JButton) e.getSource();
			String moveName = btn.getText();
			model.RegisterMove(playerID, moveName, 1000, 2000);
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
