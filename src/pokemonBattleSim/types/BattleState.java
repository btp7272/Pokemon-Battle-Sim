package pokemonBattleSim.types;

public enum BattleState 
{
	MOVE_START_UP(-1),
	MOVE_EXECUTION(0), 
	MOVE_COOL_DOWN(1),
	SWAP_START_UP(2),
	SWAP_EXECUTION(3),
	SWAP_COOL_DOWN(4);
	
	private final int mask;
	BattleState(int mask)
	{
		this.mask=mask;
	}
	public int getMask()
	{
		return mask;
	}
}
