package pokemonBattleSim.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pokemonBattleSim.models.BattleModel;
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
		
		this.view.addMoveButtonListener(new MoveButtonListener());
		this.view.addPokemonButtonListener(new PokemonButtonListener());
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
			JButton btn = (JButton) e.getSource();
			int swapIndex = Integer.parseInt(btn.getText().substring(0, 1));
			model.RegisterSwap(playerID, swapIndex);
		}
	}
}
