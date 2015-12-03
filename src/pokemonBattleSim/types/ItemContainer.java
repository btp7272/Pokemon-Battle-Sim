package pokemonBattleSim.types;

public class ItemContainer 
{
	/*
	 * Container object to hold a pokemons held item and their effects. 
	 */
	
	private String itemName;
	private Move forcedMove;
	private boolean active;
	private int[] originalStats;
	
	public ItemContainer(String nm)
	{
		itemName = nm;
		forcedMove = null;
		active = false;
		originalStats = null;
	}
	
	public void setForcedMove(Move move){ forcedMove = move; }
	public void setActiveStatus(boolean act){ active = act; }
	public void setOriginalStat(IPokemon poke){ originalStats = new int[]{poke.getMaxAtk(), poke.getMaxDef(), poke.getMaxSpAtk(), poke.getMaxSpDef(), poke.getMaxSpeed()};}
	
	public String getName(){ return itemName; }
	public Move getForcedMove(){ return forcedMove; }
	public boolean getActiveStatus(){ return active; }
	public int getOriginalStat(int index){ return originalStats[index]; }
	
	public void resetItemStats()
	{
		active = false;
		forcedMove = null;
	}
}
