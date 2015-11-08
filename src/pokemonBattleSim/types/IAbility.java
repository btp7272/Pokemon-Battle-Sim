package pokemonBattleSim.types;
import pokemonBattleSim.formulas.Formula;;

public interface IAbility 
{
	public String getName();
	public String getDescription();
	public EventType getEventTrigger();
	public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move lastMoveUsed);
}
