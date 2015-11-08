package pokemonBattleSim.types;

public class Event 
{
	public static Boolean abilityEvent(IAbility ability, EventType type, Pokemon wielder, Pokemon opponent, IField field, Pokemon attacker, Pokemon defender, Move lastMoveUsed)
	{
		if(ability.getEventTrigger().getMask() == type.getMask())
		{
			ability.run(wielder, opponent, field, attacker, defender, lastMoveUsed);
			return true;
		}
		
		return false;
	}
}
