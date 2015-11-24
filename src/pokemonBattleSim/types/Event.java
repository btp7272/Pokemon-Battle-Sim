package pokemonBattleSim.types;

import pokemonBattleSim.models.AbilityMap;
import pokemonBattleSim.models.ItemMap;
import pokemonBattleSim.models.MoveEffectMap;
import pokemonBattleSim.models.StatusMap;

public class Event 
{
	public static Boolean abilityEvent(EventType type, IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed)
	{
		if(AbilityMap.abilityMap.get(wielder.getAbility().getName()) == null)
			return false;
		
		if(AbilityMap.abilityMap.get(wielder.getAbility().getName()).getEventTrigger().getMask() == type.getMask())
		{
			AbilityMap.abilityMap.get(wielder.getAbility().getName()).run(wielder, opponent, field, attacker, defender, moveUsed);
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
			if(StatusMap.statusMap.get(wielder.getVolatileStatus().get(i).getName()).getEventTrigger().getMask() == type.getMask())
			{
				StatusMap.statusMap.get(wielder.getVolatileStatus().get(i).getName()).run(wielder, moveUsed);
				return true;
			}
		}
		
		return false;
	}
	
	public static Boolean statusNonVolatileEvent(IPokemon wielder, EventType type, Move moveUsed)
	{
		if(MoveEffectMap.effectMap.get(moveUsed.getName()) == null)
			return false;
		
		if(wielder.getNonVolatileStatus().getEventTrigger().getMask() == type.getMask())
		{
			wielder.getNonVolatileStatus().run(wielder,moveUsed);
			return true;
		}
		return false;
	}
	
	public static Boolean moveEffectEvent(IPokemon attacker, EventType type, Move moveUsed)
	{
		if(MoveEffectMap.effectMap.get(moveUsed.getName()) == null)
			return false;
		
		if(MoveEffectMap.effectMap.get(moveUsed.getName()).getEventTrigger().getMask() == type.getMask())
		{
			MoveEffectMap.effectMap.get(moveUsed.getMoveEffectContainer().getName()).run(attacker,moveUsed);
			return true;
		}
		
		return false;
	}
	
	public static Boolean itemEffectEvent(IPokemon holder, EventType type, Move moveUsed)
	{
		if(ItemMap.itemMap.get(holder.getItemContainer().getName()) == null)
			return false;
		
		if(holder.getItem().getEventTrigger().getMask() == type.getMask())
		{
			holder.getItem().run(holder,moveUsed);
			return true;
		}
		
		return false;
	}
}
