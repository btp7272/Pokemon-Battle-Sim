package pokemonBattleSim.models;

public class QueuedMove {
	public final String name;
	public final int id;
	public final int activePeriod;
	public final int inactiverPeriod;
	
	public QueuedMove (String name, int id, int activePeriod, int inactiverPeriod)
	{
		this.name = name;
		this.id = id;
		this.activePeriod = activePeriod;
		this.inactiverPeriod = inactiverPeriod;
	}
}
