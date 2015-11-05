package pokemonBattleSim.types;

import java.util.*;
import pokemonBattleSim.types.*;

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
				   public double run (IPokemon source, IPokemon target, IField field) 
				   { 
					   target.changeAtk(-1);
					   return 1;
				   }
			});
			
			abilityMap.put("Drizzle", new IAbility()
			{
				   int priority = 0;
				   String name = "Drizzle";
				   String description = "Summons rain.";
				   public int getPriority(){return priority;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon source, IPokemon target, IField field) 
				   { 
					   if(field.getWeather() == Weather.HEAVY_RAIN)
						   return 1;
					   else if(field.getWeather() == Weather.RAIN)
						   return 1;
					   else if(field.getWeather() == Weather.HEAVY_RAIN_NO_EFFECT)
						   return 1;
					   else if(field.getWeather() == Weather.RAIN_NO_EFFECT)
						   return 1;
					   else if(field.getWeather() == Weather.INTENSE_SUN)
						   return 1;
					   else if(field.getWeather() == Weather.INTENSE_SUN_NO_EFFECT)
						   return 1;
					   
					   field.setWeather(Weather.RAIN);
					   return 1;
				   }
			});
	}
}
