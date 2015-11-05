package pokemonBattleSim.types;

public enum Weather 
{
	NONE(0), 
	RAIN(1),
	HEAVY_RAIN(2),
	RAIN_NO_EFFECT(3),
	HEAVY_RAIN_NO_EFFECT(4),
	SUN(5),
	INTENSE_SUN(6),
	SUN_NO_EFFECT(7),
	INTENSE_SUN_NO_EFFECT(8),
	HAIL(9),
	HAIL_NO_EFFECT(10),
	SANDSTORM(11),
	SANDSTORM_NO_EFFECT(12);
	
	private final int mask;
	Weather(int mask)
	{
		this.mask=mask;
	}
	public int getMask()
	{
		return mask;
	}
}
