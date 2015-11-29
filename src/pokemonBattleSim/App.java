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
import pokemonBattleSim.models.MoveMap;

public class App {
	private static Object owner = new Object();
	public static void main (String[] args)
	{
		// This is the main entry point to the program, will use other classes
		IPokemonTrainer player;
		IPokemonTrainer computer;
		ArrayList<Pokemon> playerTeam = new ArrayList<>();
		ArrayList<Pokemon> computerTeam = new ArrayList<>();
		
		//CREATE CHARIZARD
		Map<Integer,ArrayList<String>> moveMap = new HashMap<>();
		int IVs[] = {31,0,31,31,31,31};
		int EVs[] = {96,0,0,196,0,216};
		
		Move[] moves = {new Move(MoveMap.moveMap.get("Flamethrower")),new Move(MoveMap.moveMap.get("Giga Drain")),new Move(MoveMap.moveMap.get("Focus Blast")),new Move(MoveMap.moveMap.get("Roost"))};
		Pokemon member = new Pokemon(SpeciesMap.speciesMap.get("Mega Charizard Y"),"Charizard",moves,IVs,EVs,100,Nature.Modest, new AbilityContainer("Drought"), new ItemContainer("Choice Specs"));
		//member.addVolatileStatus(new StatusContainer(-1,100,"Confusion",null));
		member.setPlayerID(0);
		playerTeam.add(member);
		
		//CREATE TYRANITAR
		int IVs2[] = {31,31,31,31,31,31};
		int EVs2[] = {0,252,0,0,4,252};
		Move[] moves2 = {new Move(MoveMap.moveMap.get("Crunch")),new Move(MoveMap.moveMap.get("Bullet Seed")),new Move(MoveMap.moveMap.get("Flamethrower")),new Move(MoveMap.moveMap.get("Earthquake"))};
		member = new Pokemon(SpeciesMap.speciesMap.get("Tyranitar"),"Serene Grace",moves2,IVs2,EVs2,100,Nature.Jolly, new AbilityContainer("Serene Grace"), new ItemContainer("None"));
		//member.setNonVolatileStatus(new StatusContainer(member.getMaxAtk(),100,"Burn",null));
		member.setPlayerID(0);
		playerTeam.add(member);
		
		//CREATE SLOWBRO
		int EVs3[] = {248,0,200,0,52,8};
		Move[] moves3 = {new Move(MoveMap.moveMap.get("Shadow Ball")),new Move(MoveMap.moveMap.get("Scald")),new Move(MoveMap.moveMap.get("Psyshock")),new Move(MoveMap.moveMap.get("Slack Off"))};
		member = new Pokemon(SpeciesMap.speciesMap.get("Mega Slowbro"),"LO Sheer Force",moves3,IVs,EVs3,100,Nature.Bold, new AbilityContainer("Sheer Force"), new ItemContainer("Life Orb"));
		//member.addVolatileStatus(new StatusContainer(-1,100,"Encore",MoveMap.moveMap.get("Slack Off")));
		member.setPlayerID(0);
		playerTeam.add(member);
		
		//CREATE FERROTHRON
		int IVs4[] = {31,31,31,31,31,0};
		int EVs4[] = {248,0,200,0,52,8};
		Move[] moves4 = {new Move(MoveMap.moveMap.get("Thunder Wave")),new Move(MoveMap.moveMap.get("Will-O-Wisp")),new Move(MoveMap.moveMap.get("Toxic")),new Move(MoveMap.moveMap.get("Thunder"))};
		member = new Pokemon(SpeciesMap.speciesMap.get("Ferrothorn"),"Toxic Poisoned",moves4,IVs4,EVs4,100,Nature.Relaxed, new AbilityContainer("Iron Barbs"), new ItemContainer("None"));
		member.setNonVolatileStatus(new StatusContainer(-1,0,"Toxic Poison",null));
		member.setPlayerID(0);
		playerTeam.add(member);
		
		//CREATE LATIOS
		int EVs5[] = {0,0,0,252,4,252};
		Move[] moves5 = {new Move(MoveMap.moveMap.get("Draco Meteor")),new Move(MoveMap.moveMap.get("Psyshock")),new Move(MoveMap.moveMap.get("Recover")),new Move(MoveMap.moveMap.get("Defog"))};
		member = new Pokemon(SpeciesMap.speciesMap.get("Latios"),"Paralyzed",moves5,IVs,EVs5,100,Nature.Timid, new AbilityContainer("Contrary"), new ItemContainer("None"));
		member.setNonVolatileStatus(new StatusContainer(member.getMaxSpeed(),100,"Paralysis",null));
		member.setPlayerID(0);
		playerTeam.add(member);
		
		//CREATE GLISCOR
		int EVs6[] = {244,40,8,0,96,120};
		Move[] moves6 = {new Move(MoveMap.moveMap.get("Swords Dance")),new Move(MoveMap.moveMap.get("Earthquake")),new Move(MoveMap.moveMap.get("Knock Off")),new Move(MoveMap.moveMap.get("Roost"))};
		member = new Pokemon(SpeciesMap.speciesMap.get("Gliscor"),"Poisoned",moves6,IVs2,EVs6,100,Nature.Careful, new AbilityContainer("Mold Breaker"), new ItemContainer("Life Orb"));
		member.setNonVolatileStatus(new StatusContainer(-1,50,"Poison",null));
		member.setPlayerID(0);
		playerTeam.add(member);
		
		Move[] moves7 = {new Move(MoveMap.moveMap.get("Thunderbolt")),new Move(MoveMap.moveMap.get("Surf")),new Move(MoveMap.moveMap.get("Shadow Ball")),new Move(MoveMap.moveMap.get("Toxic"))};

		for (int i = 0; i < 6; i++)
		{
			member = new Pokemon(SpeciesMap.speciesMap.get("Voltorb"),"Test Subject",moves7,IVs,EVs,100,Nature.Timid, new AbilityContainer("Volt Absorb"), new ItemContainer("Colbur Berry"));
			member.setPlayerID(1);
			computerTeam.add(member);
		}
		
		player = new PokemonTrainer(playerTeam);
		computer = new PokemonTrainer(computerTeam);
		
		Timer timer = new Timer();
		try {
			BattleModel.CreateInstance(owner, player, computer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BattleModel model = BattleModel.getInstance();
		BattleView view = new BattleView(player.getTrainerID());
		BattleController controller = new BattleController(view,model, player.getTrainerID());
		
		view.setVisible(true);
	}
}
