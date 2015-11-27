package pokemonBattleSim.types;

public interface IMoveEffect 
{
	public String getName();
	public String getDescription();
	public EventType getEventTrigger();
	public double runPrimaryEffect(IPokemon attacker, Move moveUsed);
	public double runSecondaryEffect(IPokemon attacker, Move moveUsed);
}
