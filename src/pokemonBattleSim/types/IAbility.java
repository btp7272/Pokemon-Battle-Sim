package pokemonBattleSim.types;
import pokemonBattleSim.formulas.Formula;;

public interface IAbility 
{
	public int getPriority ();
	public String getName ();
	public void run (IPokemon source, IPokemon target);
}
