package pokemonBattleSim.types;

public class MoveEffectContainer 
{
	private String moveName;
	private int consecutiveTurns, damageDelt;
	private Type[] originalTyping;
	
	public MoveEffectContainer(String name)
	{
		moveName = name;
		consecutiveTurns = 0;
		damageDelt = 0;
		originalTyping = null;
	}
	
	public void setDamgeDelt(int dmg){ damageDelt = dmg; }
	public void calcConsecutiveTurns(IPokemon poke)
	{ 
		if(poke.getLastMoveUsed().getName().equals(moveName))
			consecutiveTurns++;
		else
			consecutiveTurns = 0;
	}
	public void setOriginalTyping(Type t1, Type t2)
	{
		originalTyping = new Type[]{t1,t2};
	}
	
	public int getDamageDelt(){ return damageDelt; }
	public int getConsecutiveTurns(){ return consecutiveTurns; }
	public String getName(){ return moveName; }
	
	public void updateMoveEffectContainer(IPokemon poke, int dmgDelt)
	{
		calcConsecutiveTurns(poke);
		damageDelt = dmgDelt;
	}
	
	public void restoreOriginalTyping(IPokemon poke)
	{
		if(originalTyping == null)
		{
			return;
		}
		poke.setType(originalTyping[0], 1);
		poke.setType(originalTyping[1], 2);
	}
	
}
