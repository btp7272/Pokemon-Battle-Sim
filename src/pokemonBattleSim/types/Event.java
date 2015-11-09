package pokemonBattleSim.types;

public class Event 
{
<<<<<<< HEAD
	public static Boolean abilityEvent(IAbility ability, EventType type, IPokemon attacker, IPokemon defender, IField field, IPokemon attacker2, IPokemon defender2, Move lastMoveUsed)
=======
	public static Boolean abilityEvent(IAbility ability, EventType type, IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move lastMoveUsed)
>>>>>>> refs/remotes/origin/master
	{
		if(ability.getEventTrigger().getMask() == type.getMask())
		{
			ability.run(attacker, defender, field, attacker2, defender2, lastMoveUsed);
			return true;
		}
		
		return false;
	}
}
