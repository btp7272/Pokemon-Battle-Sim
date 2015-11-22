package pokemonBattleSim.types;

import pokemonBattleSim.models.StatusMap;

public class Event 
{
	public static Boolean abilityEvent(IAbility ability, EventType type, IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed)
	{
		
		if(ability.getEventTrigger().getMask() == type.getMask())
		{
			ability.run(wielder, opponent, field, attacker, defender, moveUsed);
			return true;
		}
		
		return false;
	}
	
	public static Boolean statusVolatileEvent(IPokemon wielder, EventType type, Move moveUsed)
	{
		if(wielder.getVolatileStatus().isEmpty())
			return false;
		
		for(int i = 0; i < wielder.getVolatileStatus().size(); i++)
		{
			if(StatusMap.statusMap.get(wielder.getVolatileStatus().get(i)).getEventTrigger().getMask() == type.getMask())
			{
				StatusMap.statusMap.get(wielder.getVolatileStatus().get(i)).run(wielder, type, moveUsed);
				return true;
			}
		}
		
		return false;
	}
	
	public static Boolean statusNonVolatileEvent(IPokemon wielder, EventType type, Move moveUsed)
	{
		if(wielder.getNonVolatileStatus().getEventTrigger().getMask() == type.getMask())
		{
			wielder.getNonVolatileStatus().run(wielder,type,moveUsed);
			return true;
		}
		return false;
	}
}
