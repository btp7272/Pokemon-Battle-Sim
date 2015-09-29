package pokemonBattleSim.types;

public enum Attribute 
{
	PHYSICAL(0), 
	SPECIAL(1),
	STATUS(2);
	
	private final int mask;
	
	Attribute(int mask)
	{
		this.mask = mask;
	}
	public int getMask()
	{
		return mask;
	}
}