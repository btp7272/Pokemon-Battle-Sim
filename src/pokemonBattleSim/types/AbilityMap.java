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
				   String description = "Lowers the foe's Attack by 1 stage.";
				   public int getPriority(){return priority;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public void run (IPokemon source, IPokemon target, IField field) 
				   { 
					   target.changeAtk(-1);
				   }
			});
	}
}
