package pokemonBattleSim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

import pokemonBattleSim.models.*;
import pokemonBattleSim.controllers.BattleController;
import pokemonBattleSim.models.BattleModel;
import pokemonBattleSim.models.SpeciesMap;
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
		ArrayList<Pokemon> playerTeam = new ArrayList<>();
		ArrayList<Pokemon> computerTeam = new ArrayList<>();
		Map<Integer,ArrayList<String>> moveMap = new HashMap<>();
		for (int i = 0; i < 6; i++)
		{
			playerTeam.add(speciesMap.get("Pikachu"));			
			computerTeam.add(SpeciesMap.pokeMap.get("Terrakion"));
			ArrayList<String> m = new ArrayList<>();
			for (int j = 0; j < 6; j++)
			{
				m.add("ATTACK!");
			}
			moveMap.put(i,m);
		}
		player = new PokemonTrainer(playerTeam);
		computer = new PokemonTrainer(computerTeam);
		
		Timer timer = new Timer();
		BattleView view = new BattleView(player.getTrainerID());
		BattleModel model = new BattleModel(player,computer,timer, 0);
		@SuppressWarnings("unused")
		BattleController controller = new BattleController(view,model,timer,moveMap,player,computer);
		
		view.setVisible(true);
	}
}
