package pokemonBattleSim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

import pokemonBattleSim.controllers.BattleController;
import pokemonBattleSim.models.BattleModel;
import pokemonBattleSim.models.PokemonMap;
import pokemonBattleSim.types.IPokemonTrainer;
import pokemonBattleSim.types.Pokemon;
import pokemonBattleSim.types.PokemonTrainer;
import pokemonBattleSim.views.BattleView;
import pokemonBattleSim.models.MoveMap;

public class App {
	public static void main (String[] args)
	{
		// This is the main entry point to the program, will use other classes
		IPokemonTrainer player;
		IPokemonTrainer computer;
		ArrayList<Pokemon> playerPokemon = new ArrayList<>();
		ArrayList<Pokemon> computerPokemon = new ArrayList<>();
		Map<Integer,ArrayList<String>> moveMap = new HashMap<>();
		for (int i = 0; i < 6; i++)
		{
			playerPokemon.add(PokemonMap.pokeMap.get("Pikachu"));			
			computerPokemon.add(PokemonMap.pokeMap.get("Terrakion"));
			ArrayList<String> m = new ArrayList<>();
			for (int j = 0; j < 6; j++)
			{
				m.add("ATTACK!");
			}
			moveMap.put(i,m);
		}
		player = new PokemonTrainer(playerPokemon);
		computer = new PokemonTrainer(computerPokemon);
		
		Timer timer = new Timer();
		BattleView view = new BattleView();
		BattleModel model = new BattleModel(player,computer,timer, 0);
		@SuppressWarnings("unused")
		BattleController controller = new BattleController(view,model,timer,moveMap,player,computer);
		
		view.setVisible(true);
	}
}
