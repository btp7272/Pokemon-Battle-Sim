package pokemonBattleSim.types;

public class MoveEffectContainer 
{
	private String moveName;
	private int consecutiveTurns, damageDelt;
	
	public MoveEffectContainer(String name)
	{
		moveName = name;
		consecutiveTurns = 0;
		damageDelt = 0;
	}
	
	public void setDamgeDelt(int dmg){ damageDelt = dmg; }
	public void calcConsecutiveTurns(IPokemon poke)
	{ 
		if(poke.getLastMoveUsed().getName().equals(moveName))
			consecutiveTurns++;
		else
			consecutiveTurns = 0;
	}
	
	public int getDamageDelt(){ return damageDelt; }
	public int getConsecutiveTurns(){ return consecutiveTurns; }
	public String getName(){ return moveName; }
	
	public void updateMoveEffectContainer(IPokemon poke, int dmgDelt)
	{
		calcConsecutiveTurns(poke);
		damageDelt = dmgDelt;
	}
	
}
