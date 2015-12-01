package pokemonBattleSim.types;

public interface IItem 
{
	public String getName();
	public String getDescription();
	public EventType getPrimaryEventTrigger();
	public EventType getSecondaryEventTrigger();
	public double runPrimaryEffect(IPokemon holder, Move moveUsed);
	public double runSecondaryEffect(IPokemon holder, Move moveUsed);
}
