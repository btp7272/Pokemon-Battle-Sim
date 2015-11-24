package pokemonBattleSim.types;

public interface IItem 
{
	public String getName();
	public String getDescription();
	public EventType getEventTrigger();
	public double run (IPokemon holder, Move moveUsed);
}
