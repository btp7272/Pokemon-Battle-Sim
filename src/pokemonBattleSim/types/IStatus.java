package pokemonBattleSim.types;

public interface IStatus 
{
	public String getName();
	public String getDescription();
	public EventType getEventTrigger();
	public double run (IPokemon wielder, EventType type, Move moveUsed);
	//public int getDegree();
	//public void setDegree(int deg);
}
