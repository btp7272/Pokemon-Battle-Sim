package pokemonBattleSim.models;

import pokemonBattleSim.types.Move;
import pokemonBattleSim.types.Pokemon;
import static pokemonBattleSim.formulas.Formula.*;

public class BattleModel {

	// holds the information for the battle
	private String message;
	
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
}
