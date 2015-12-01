package pokemonBattleSim.controllers;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import pokemonBattleSim.models.BattleModel;
import pokemonBattleSim.models.IBattleModel;
import pokemonBattleSim.models.QueuedAction;
import pokemonBattleSim.views.BattleView;
import pokemonBattleSim.views.IView;

public class AIController implements IView{

	private BattleModel model;
	private int playerID;
	
	public AIController(BattleModel model, int playerID) {
		this.model = model;
		this.model.registerView(this);
		this.playerID = playerID;
	}

	@Override
	public void onViewNotify() {
		// check if pokemon is still able to battle
		if (model.isGameover()) return;
		if (model.getPlayerPokemonHP(playerID) > 0)
		{
			if (model.getOpponentPokemonHP(playerID) == 0) return;
			// check to see if the there is a move in the stack
			if (model.getTasks(playerID).size() < 2)
			{
				int moveIndex = (int) Math.floor(Math.random() * 4) + 1;
				System.out.println("[COM] Adding Move " + moveIndex);
				boolean output = model.RegisterMove(this.playerID, moveIndex, 1000, 2000);
				System.out.println("[COM] Move add result:" + output);
			}
		}
		// pokemon has fainted, attempt swap
		else
		{
			if (model.getTasks(playerID).size() >= 1) return;
			
			ArrayList<Boolean> availablePokemon = model.getPlayerAvailablePokemon(playerID);
			int swapIndex = -1;
			for (int i = 0; i < availablePokemon.size(); i++)
			{
				boolean isAvailable = availablePokemon.get(i).booleanValue();
				if (isAvailable)
				{
					swapIndex = i;
					break;
				}
			}
			if (swapIndex == -1) return;
			
			System.out.println("[COM] Trying to swap to " + swapIndex);
			boolean response = model.RegisterSwap(playerID, swapIndex);
		}
	}
}
