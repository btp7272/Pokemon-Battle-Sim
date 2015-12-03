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
		this.view = view;
		this.model = model;
		this.playerID = playerID;
		
		this.view.addMoveButtonListener(new MoveButtonListener());
		this.view.addPokemonButtonListener(new PokemonButtonListener());
		this.model.notifyView();
	}

	/*
	 * Listen for moves being pressed by user
	 */
	class MoveButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			//System.out.println("Move Button pushed");
			JButton btn = (JButton) e.getSource();
			String moveName = btn.getText();
			boolean response = model.RegisterMove(playerID, moveName, 1000, 2000);
			//System.out.println("Move Button pushed: " + moveName + "    Response: " + response);
		}	
	}
	
	/*
	 * Listens for swap requests
	 */
	class PokemonButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e)
		{
			//System.out.println("Pokemon Button pushed");
			JButton btn = (JButton) e.getSource();
			int swapIndex = Integer.parseInt(btn.getText().substring(0, 1)) - 1;
			boolean response = model.RegisterSwap(playerID, swapIndex);
			//System.out.println("Index of selected Pokemon: " + swapIndex + "    Response: " + response);
		}
	}
}
