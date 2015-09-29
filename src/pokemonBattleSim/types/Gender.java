package pokemonBattleSim.types;

public enum Gender 
{
	MALE(0),
	FEMALE(1),
	NEUTRAL(2);
	
	private final int mask;
	Gender(int mask)
	{
		this.mask = mask;
	}
	public int getMask()
	{
		return this.mask;
	}
}
