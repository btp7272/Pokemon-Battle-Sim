package pokemonBattleSim.types;
public enum Contest 
{
	COOL(0),
	BEAUTIFUL(1),
	CUTE(2),
	CLEVER(3),
	TOUGH(4);
	
	private final int mask;
	
	Contest(int mask)
	{
		this.mask = mask;
	}
	public int getMask()
	{
		return mask;
	}
}
