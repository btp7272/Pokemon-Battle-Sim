package pokemonBattleSim.types;

public class AbilityContainer 
{
	private String name;
	private int originalStat;
	
	public AbilityContainer(String nm, int orStat)
	{
		name = nm;
		originalStat = orStat;
	}
	
	public String getName(){ return name; }
	public int getOriginalStat(){ return originalStat; }
}
