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
import pokemonBattleSim.types.Move;
import pokemonBattleSim.types.Nature;
import pokemonBattleSim.types.Pokemon;
import pokemonBattleSim.types.PokemonTrainer;
import pokemonBattleSim.types.Species;
import pokemonBattleSim.types.StatusContainer;
import pokemonBattleSim.types.AbilityContainer;
import pokemonBattleSim.types.ItemContainer;
import pokemonBattleSim.views.BattleView;
import pokemonBattleSim.views.MainMenu;
import pokemonBattleSim.views.TeamBuilderView;
import pokemonBattleSim.models.MoveMap;

public class App {
	private static Object owner = new Object();
	public static void main (String[] args)
	{
		//System.setProperty("java.net.preferIPv4Stack" , "true");
		MainMenu.startup();
	}
}
