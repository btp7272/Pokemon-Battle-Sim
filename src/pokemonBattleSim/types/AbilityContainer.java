package pokemonBattleSim.types;

public class AbilityContainer 
{
	private String name;
	private int[] originalStats;
	private boolean active;
	
	public AbilityContainer(String nm, IPokemon poke)
	{
		name = nm;
		originalStats = new int[]{poke.getMaxAtk(), poke.getMaxDef(), poke.getMaxSpAtk(), poke.getMaxSpDef(), poke.getMaxSpeed()};
		active = false;
	}
	public void setActiveStatus(boolean bool){ active = bool; }
	
	public String getName(){ return name; }
	public int[] getOriginalStat(){ return originalStats; }
	public boolean getActiveStatus(){ return active; }
}
