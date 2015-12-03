package pokemonBattleSim.types;

public class AbilityContainer 
{
	/*
	 * Holds a pokemons ability, originial stats for resetting, and a boolean to determine if their ability is active
	 */
	private String name;
	private int[] originalStats;
	private boolean active;
	
	public AbilityContainer(String nm)
	{
		name = nm;
		originalStats = null;
		active = false;
	}
	public void setActiveStatus(boolean bool){ active = bool; }
	public void setOriginalStats(IPokemon poke){ originalStats = new int[]{poke.getMaxAtk(), poke.getMaxDef(), poke.getMaxSpAtk(), poke.getMaxSpDef(), poke.getMaxSpeed()}; }
	
	public String getName(){ return name; }
	public int getOriginalStat(int index){ return originalStats[index]; }
	public boolean getActiveStatus(){ return active; }
}
