package pokemonBattleSim.models;

import java.util.Map;
import pokemonBattleSim.types.*;

public class StatusMap 
{
	static Map < String, IStatus > statusMap;
	
	static
	{
		statusMap.put("Healthy", new IStatus()
		{
				EventType trigger = EventType.NONE;
				String name = "Healthy";
				String description = "";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public double run (IPokemon wielder, EventType type, Move moveUsed)
				{
					return 1;
				}
		});
		
		statusMap.put("Confusion", new IStatus()
		{
				EventType trigger = EventType.PRE_ATTACK;
				String name = "Confusion";
				String description = "The confused condition causes a Pokémon to hurt itself in its confusion 50% of the time. The damage is done as if the Pokémon attacked itself with a 40-power typeless physical attack.";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public double run (IPokemon wielder, EventType type, Move moveUsed)
				{
					double damage;
			        double numerator, denomenator;
			        numerator = ( ( 2 * wielder.getLevel() ) + 10  ); 
			        numerator = numerator * wielder.getAtk() * 40;
			        denomenator = 250 * wielder.getDef();
			        damage = (numerator / denomenator) + 2;
			        wielder.changeHP((int)damage);
					return 1;
				}
		});
	}
}
