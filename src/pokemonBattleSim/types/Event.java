package pokemonBattleSim.types;

public class Event 
{
	public static Boolean abilityEvent(IAbility ability, EventType type, IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move lastMoveUsed)
	{
		if(ability.getEventTrigger().getMask() == type.getMask())
		{
			ability.run(wielder, opponent, field, attacker, defender, lastMoveUsed);
			return true;
		}
		
		return false;
	}
}
