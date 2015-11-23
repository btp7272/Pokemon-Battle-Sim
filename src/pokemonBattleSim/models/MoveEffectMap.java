package pokemonBattleSim.models;

import java.util.HashMap;
import java.util.Map;

import pokemonBattleSim.models.AbilityMap.Stat;
import pokemonBattleSim.types.Event;
import pokemonBattleSim.types.EventType;
import pokemonBattleSim.types.IAbility;
import pokemonBattleSim.types.IField;
import pokemonBattleSim.types.IMoveEffect;
import pokemonBattleSim.types.IPokemon;
import pokemonBattleSim.types.Move;

public class MoveEffectMap 
{
	public static Map < String, IMoveEffect > effectMap = new HashMap<>();
	private static IBattleModel model = BattleModel.getInstance();
	
	static
	{
		effectMap.put("Giga Drain", new IMoveEffect()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Giga Drain";
			   String description = "Leeches 50% of the damage dealt.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon attacker, Move moveUsed)
			   { 
				  if(Event.statusVolatileEvent(attacker, EventType.HEAL, moveUsed))
				  {
					  //run event automatic
					  return 0;
				  }
				  attacker.changeHP(- moveUsed.getMoveEffectContainer().getDamageDelt() / 2);
				  return 1;
			   }
		});
		
	}
}
