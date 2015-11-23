package pokemonBattleSim.types;

public interface IMoveEffect 
{
	public String getName();
	public String getDescription();
	public EventType getEventTrigger();
	public double run (IPokemon attacker, Move moveUsed);
}
