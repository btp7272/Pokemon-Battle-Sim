package pokemonBattleSim.types;

public enum EventType 
{
	NONE(-1),
	HP_CHANGE(0),
	HEAL(13),
	STATISTIC_CHANGE(1),
	ENTRY(2),
	EXIT(3),
	PRE_DAMAGE(4),
	POST_ATTACK(5),
	PRE_ATTACK(6),
	CONTINUOUS(7),
	PRE_STATUS_CHANGE(8),
	POST_STATUS_CHANGE(12),
	KO(9),
	WEATHER_CHANGE(10),
	PRE_SWITCH(11),
	PRE_QUEUE_REGISTER(14);
	
	private final int mask;
	EventType(int mask)
	{
		this.mask=mask;
	}
	public int getMask()
	{
		return mask;
	}
}
