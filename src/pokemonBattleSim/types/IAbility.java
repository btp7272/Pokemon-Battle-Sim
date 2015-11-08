package pokemonBattleSim.types;
import pokemonBattleSim.formulas.Formula;;

public interface IAbility 
{
	public String getName ();
	public String getDescription();
	public EventType getEventTrigger();
	public double run (Pokemon wielder, Pokemon opponent, IField field, Pokemon attacker, Pokemon defender, Move lastMoveUsed);
}
