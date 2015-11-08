package pokemonBattleSim.types;
import pokemonBattleSim.formulas.Formula;;

public interface IAbility 
{
	public String getName();
	public String getDescription();
	public EventType getEventTrigger();
	public double run (IPokemon attacker, IPokemon defender, IField field, IPokemon attacker2, IPokemon defender2, Move lastMoveUsed);
}
