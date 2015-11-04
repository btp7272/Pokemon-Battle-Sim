package pokemonBattleSim.types;

import java.util.*;

public class AbilityMap
{
	public static Map < String, IAbility > abilityMap = new HashMap<>();
	
	static
	{
			abilityMap.put("Intimidate", new IAbility()
			{
				   int priority = 0;
				   String name = "Intimidate";
				   public int getPriority(){return priority;}
				   public String getName(){return name;}
				   public void run (IPokemon source, IPokemon target) 
				   { 
					   target.changeAtk(-1);
				   }
			});
	}
}
