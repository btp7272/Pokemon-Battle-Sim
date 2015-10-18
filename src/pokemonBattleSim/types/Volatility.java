package pokemonBattleSim.types;

public enum Volatility 
{
	nonVolatile(0),
	isVolatile(1);
	
	private final int mask;
	Volatility(int mask)
	{
		this.mask=mask;
	}
	public int getMask()
	{
		return mask;
	}
}