package pokemonBattleSim.types;

import java.util.ArrayList;

public class Species 
{
	private final String speciesName;
	private final int baseHP, baseAtk, baseDef, baseSpAtk, baseSpDef, baseSpeed;
	private final Type typeOne, typeTwo;
	private final double weight, indexNum;
	private ArrayList<String> learnableMoves;
	private ArrayList<String> learnableAbilities;
	
	/*
	 * Full constructor for duel-type Pokemon. This is for the map. It is
	 * never used to create the pokemon the users play with. This constructor passes the
	 * base statistic of the pokemon before the actual stat is calculate, which
	 * will be done in the copy constructor.
	 */
	public Species(double index, String name, int hp, int atk, int def, int spAtk, int spDef, int speed, Type type1, Type type2, double mass)
	{
		this.indexNum = index;
		this.speciesName = name;
		this.baseHP = hp;
		this.baseAtk = atk;
		this.baseDef = def;
		this.baseSpAtk = spAtk;
		this.baseSpDef = spDef;
		this.baseSpeed = speed;
		this.typeOne = type1;
		this.typeTwo = type2;
		this.weight = mass;
	}
	
	/*
	 * Full constructor for single-type Pokemon. This is for the map. It is never used
	 * to create the pokemon the users play with. This constructor passes the
	 * base statistic of the pokemon before the actual stat is calculated, which
	 * will be done in the copy constructor
	 */
	public Species(double index, String name, int hp, int atk, int def, int spAtk, int spDef, int speed, Type type1, double mass)
	{
		this.indexNum = index;
		this.speciesName = name;
		this.baseHP = hp;
		this.baseAtk = atk;
		this.baseDef = def;
		this.baseSpAtk = spAtk;
		this.baseSpDef = spDef;
		this.baseSpeed = speed;
		this.typeOne = type1;
		this.typeTwo = null;
		this.weight = mass;
	}
	
	public void setLearnableMoves(ArrayList<String> list)
	{
		this.learnableMoves = list;
	}
	
	public void setLearnableAbilities(ArrayList<String> list)
	{
		this.learnableAbilities = list;
	}
	
	public double getIndex(){return this.indexNum;}
	public String getName(){ return this.speciesName;}
	public int getBaseHP() {return this.baseHP;}
	public int getBaseAtk() {return this.baseAtk;}
	public int getBaseDef() {return this.baseDef;}
	public int getBaseSpAtk() {return this.baseSpAtk;}
	public int getBaseSpDef() {return this.baseSpDef;}
	public int getBaseSpeed() {return this.baseSpeed;}
	public double getWeight(){return this.weight;}
	public Type getType1(){return this.typeOne;}
	public Type getType2(){return this.typeTwo;}
	public ArrayList<String> getMoveSet(){return this.learnableMoves;}
	public ArrayList<String> getAbilitySet(){return this.learnableAbilities;}
}
