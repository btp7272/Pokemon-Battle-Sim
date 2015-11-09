package pokemonBattleSim.types;

public interface IStatus 
{
	public String getName();
	public EventType getEventTrigger();
	public double run (IPokemon wielder, EventType type, Move moveUsed);
}
