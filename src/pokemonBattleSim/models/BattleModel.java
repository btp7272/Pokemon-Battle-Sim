package pokemonBattleSim.models;

import pokemonBattleSim.types.IPokemonTrainer;
import pokemonBattleSim.types.Move;
import pokemonBattleSim.types.Pokemon;
import static pokemonBattleSim.formulas.Formula.*;

public class BattleModel {

	// holds the information for the battle
	private String message;
	private IPokemonTrainer playerOne;
	private IPokemonTrainer playerTwo;
	
	public boolean RegisterAction (PLAYER player, INTENT intent, RegisterActionArgs args )
	{
		Pokemon activePokemon;
		Pokemon inactivePokemon;
		IPokemonTrainer activePlayer;
		IPokemonTrainer inactivePlayer;
		if (player == PLAYER.ONE)
		{
			activePlayer = playerOne;
			inactivePlayer = playerTwo;
		}
		else // player == PLAYER.TWO
		{
			activePlayer = playerTwo;
			inactivePlayer = playerOne;
		}
		activePokemon = activePlayer.getActiveTeamMember();
		inactivePokemon = inactivePlayer.getActiveTeamMember();
		switch (intent)
		{
		case SWAP:
			if (true) // TODO check to see if swap would be valid and permitted
			{
				activePlayer.swapActiveTeamMember(args.getSwapIndex());
				// TODO update log
			}
			break;
		case OFFENSIVE:
			int damage;
			if (true) // TODO check to see if move is valid
			{
				damage = calcDamage(activePokemon, inactivePokemon, args.getMove());
				// TODO update log
			}
			break;
		case DEFENSIVE:
			if (true) // TODO check to see if move is valid
			{
				// TODO apply defensive effect
				// TODO update log
			}
			break;
		case STRATEGIC:
			if (true) // TODO check to see if move is valid
			{
				// TODO apply strategic event data to game
				// TODO update log
			}
		
		}
		return true;
	}
	
	// DEPRECATED: will delete before next release
	public void battle(Pokemon firstPokemon, Pokemon secondPokemon, Move moveToUse)
	{
		int damage = calcDamage(firstPokemon,secondPokemon,moveToUse);
		message = "";
		message += firstPokemon.getName() + " uses " + moveToUse.getName() + " on ";
		message += secondPokemon.getName() + " for "+ damage + " damage! ";
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public enum PLAYER
	{
		ONE,
		TWO;
	}
	
	public enum INTENT
	{
		SWAP,
		OFFENSIVE,
		DEFENSIVE,
		STRATEGIC;
	}
	
	public class RegisterActionArgs 
	{
		private Move move;
		private int swapIndex;
		public RegisterActionArgs (Move move)
		{
			this.move = move;
			this.swapIndex = 0;
		}
		public RegisterActionArgs (int index)
		{
			this.move = null;
			this.swapIndex = index;
		}
		public Move getMove ()
		{
			return move;
		}
		public int getSwapIndex ()
		{
			return swapIndex;
		}
	}
}
