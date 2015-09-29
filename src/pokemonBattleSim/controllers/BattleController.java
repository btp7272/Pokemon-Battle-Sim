package pokemonBattleSim.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pokemonBattleSim.converters.MoveStringToObjectConverter;
import pokemonBattleSim.converters.PokemonStringToObjectConverter;
import pokemonBattleSim.models.BattleModel;
import pokemonBattleSim.types.Move;
import pokemonBattleSim.types.Pokemon;
import pokemonBattleSim.views.BattleView;

public class BattleController {

	private BattleView battleView;
	private BattleModel battleModel;
	
	public BattleController(BattleView view, BattleModel model) {
		// TODO Auto-generated constructor stub
		battleView = view;
		battleModel = model;
		
		battleView.addMoveButtonListener(new MoveButtonListener());
	}
	
	class MoveButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Pokemon firstPokemon = PokemonStringToObjectConverter.convert((battleView.getFirstPokemonName()));
			Pokemon secondPokemon = PokemonStringToObjectConverter.convert((battleView.getSecondPokemonName()));
			Move moveToUse = MoveStringToObjectConverter.convert(battleView.getMoveToUse());
			
			if (firstPokemon == null)
			{
				battleView.displayPopupMessage("Invalid first Pokemon name.");
				return;
			}
			else if (secondPokemon == null)
			{
				battleView.displayPopupMessage("Invalid second Pokemon name.");
				return;
			}
			else if (moveToUse == null)
			{
				battleView.displayPopupMessage("Invalid move name.");
				return;
			}
			
			battleModel.battle(firstPokemon, secondPokemon, moveToUse);
			battleView.displayPopupMessage(battleModel.getMessage());
		}
		
	}

}
