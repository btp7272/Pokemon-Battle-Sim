package pokemonBattleSim.types;
import pokemonBattleSim.formulas.Formula;;

public interface IAbility 
{
	public int getPriority ();
	public String getName ();
	public String getDescription();
	public double run (IPokemon source, IPokemon target, IField field);
}
