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
		Move testMove = MoveMap.moveMap.get("Giga Drain");
		
		Move[] moves = {MoveMap.moveMap.get("Flamethrower"),MoveMap.moveMap.get("Giga Drain"),MoveMap.moveMap.get("Focus Blast"),MoveMap.moveMap.get("Roost")};
		Pokemon member = new Pokemon(SpeciesMap.speciesMap.get("Mega Charizard Y"),"Confused",moves,IVs,EVs,100,Nature.Modest);
		member.setAbility(new AbilityContainer("Drought",-1));
		member.addVolatileStatus(new StatusContainer(-1,100,"Confusion",null));
		member.setNonVolatileStatus(new StatusContainer(-1,-1,"Healthy",null));
		playerTeam.add(member);
		
		//CREATE TYRANITAR
		int IVs2[] = {31,31,31,31,31,31};
		int EVs2[] = {0,252,0,0,4,252};
		Move[] moves2 = {MoveMap.moveMap.get("Crunch"),MoveMap.moveMap.get("Bullet Seed"),MoveMap.moveMap.get("Stone Edge"),MoveMap.moveMap.get("Earthquake")};
		member = new Pokemon(SpeciesMap.speciesMap.get("Tyranitar"),"Burned",moves2,IVs2,EVs2,100,Nature.Jolly);
		member.setAbility(new AbilityContainer("Sand Stream",-1));
		member.setNonVolatileStatus(new StatusContainer(member.getMaxAtk(),100,"Burn",null));
		playerTeam.add(member);
		
		//CREATE SLOWBRO
		int EVs3[] = {248,0,200,0,52,8};
		Move[] moves3 = {MoveMap.moveMap.get("Shadow Ball"),MoveMap.moveMap.get("Scald"),MoveMap.moveMap.get("Psyshock"),MoveMap.moveMap.get("Slack Off")};
		member = new Pokemon(SpeciesMap.speciesMap.get("Mega Slowbro"),"Encored",moves3,IVs,EVs3,100,Nature.Bold);
		member.setAbility(new AbilityContainer("Regenerator",-1));
		member.addVolatileStatus(new StatusContainer(-1,100,"Encore",MoveMap.moveMap.get("Slack Off")));
		member.setNonVolatileStatus(new StatusContainer(-1,-1,"Healthy",null));
		playerTeam.add(member);
		
		//CREATE FERROTHRON
		int IVs4[] = {31,31,31,31,31,0};
		int EVs4[] = {248,0,200,0,52,8};
		Move[] moves4 = {MoveMap.moveMap.get("Stealth Rock"),MoveMap.moveMap.get("Leech Seed"),MoveMap.moveMap.get("Power Whip"),MoveMap.moveMap.get("Gyro Ball")};
		member = new Pokemon(SpeciesMap.speciesMap.get("Ferrothorn"),"Badly Poisoned",moves4,IVs4,EVs4,100,Nature.Relaxed);
		member.setAbility(new AbilityContainer("Iron Barbs",-1));
		member.setNonVolatileStatus(new StatusContainer(-1,1,"Badly Poison",null));
		playerTeam.add(member);
		
		//CREATE LATIOS
		int EVs5[] = {0,0,0,252,4,252};
		Move[] moves5 = {MoveMap.moveMap.get("Draco Meteor"),MoveMap.moveMap.get("Psyshock"),MoveMap.moveMap.get("Recover"),MoveMap.moveMap.get("Defog")};
		member = new Pokemon(SpeciesMap.speciesMap.get("Latios"),"Paralyzed",moves5,IVs,EVs5,100,Nature.Timid);
		member.setAbility(new AbilityContainer("Levitate",-1));
		member.setNonVolatileStatus(new StatusContainer(member.getMaxSpeed(),100,"Paralysis",null));
		playerTeam.add(member);
		
		//CREATE GLISCOR
		int EVs6[] = {244,40,8,0,96,120};
		Move[] moves6 = {MoveMap.moveMap.get("Swords Dance"),MoveMap.moveMap.get("Earthquake"),MoveMap.moveMap.get("Knock Off"),MoveMap.moveMap.get("Roost")};
		member = new Pokemon(SpeciesMap.speciesMap.get("Gliscor"),"Poisoned",moves6,IVs2,EVs6,100,Nature.Careful);
		member.setAbility(new AbilityContainer("Poison Heal",-1));
		member.setNonVolatileStatus(new StatusContainer(-1,1,"Poison",null));
		playerTeam.add(member);
		
		Move[] moves7 = {MoveMap.moveMap.get("Thunderbolt"),MoveMap.moveMap.get("Surf"),MoveMap.moveMap.get("Shadowball"),MoveMap.moveMap.get("Toxic")};

		for (int i = 0; i < 6; i++)
		{
			member = new Pokemon(SpeciesMap.speciesMap.get("Pikachu"),"Pikablooooo",moves7,IVs,EVs,100,Nature.Timid);
			member.setAbility(new AbilityContainer("Levitate",-1));
			member.setNonVolatileStatus(new StatusContainer(-1,-1,"Healthy",null));
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
