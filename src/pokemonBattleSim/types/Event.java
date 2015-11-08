package pokemonBattleSim.types;

public class Event 
{
	public static Boolean abilityEvent(IAbility ability, EventType type, IPokemon attacker, IPokemon defender, IField field, IPokemon attacker2, IPokemon defender2, Move lastMoveUsed)
	{
		if(ability.getEventTrigger().getMask() == type.getMask())
		{
			ability.run(attacker, defender, field, attacker2, defender2, lastMoveUsed);
			return true;
		}
		
		return false;
	}
}
