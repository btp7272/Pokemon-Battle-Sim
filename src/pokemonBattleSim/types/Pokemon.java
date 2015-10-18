/*
 * Bryan Powell 9-27-2015
 * Pokemon constructors and operators
 */
package pokemonBattleSim.types;
import pokemonBattleSim.formulas.Formula;

public class Pokemon 
{
	double indexNum;
	String name;
	int hp;
	int baseHp;
	int atk;
	int baseAtk;
	int def;
	int baseDef;
	int spAtk;
	int baseSpAtk;
	int spDef;
	int baseSpDef;
	int speed;
	int baseSpeed;
	double weight;
	double baseWeight;
	//Ability ability = null;
	Move moveOne = null;
	Move moveTwo = null;
	Move moveThree = null;
	Move moveFour = null;
	Type typeOne = null;
	Type baseTypeOne = null;
	Type typeTwo = null;
	Type baseTypeTwo = null;
	Gender gender = null;
	//heldItem item = null;
	
	private void setIndex(double index){ this.indexNum = index;}
	private void setName(String newName){ this.name = newName;}
	private void setHp(int health){	this.hp = Formula.calcHP(health); this.baseHp = hp;}
	private void setAtk(int attack){ this.atk = Formula.calcStat(attack); this.baseAtk = atk;}
	private void setDef(int defense){ this.def = Formula.calcStat(defense); this.baseDef = def;}
	private void setSpAtk(int spattack){ this.spAtk = Formula.calcStat(spattack); this.baseSpAtk = spAtk;}
	private void setSpDef(int spdefense){ this.spDef = Formula.calcStat(spdefense); this.baseSpDef = spDef;}
	private void setSpeed(int newSpeed){ this.speed = Formula.calcStat(newSpeed); this.baseSpeed = speed;}
	private void setWeight(double newWeight){ this.weight = newWeight; this.baseWeight = weight;}
	public void setGender(Gender gen){this.gender = gen;}
	//private void setAbility(Ability newAbility){ ability = newAbility;}
	private void setMove(Move newMove, int moveNum)
	{
		switch(moveNum)
		{
			case 1:
			{
				this.moveOne = newMove;
				break;
			}
			case 2:
			{
				this.moveTwo = newMove;
				break;
			}
			case 3:
			{
				this.moveThree = newMove;
				break;
			}
			case 4:
			{
				this.moveFour = newMove;
				break;
			}
			default:
			{
				System.err.println("Incorrect move number");
				break;
			}
		}
	}
	private void setType(Type newType, int typeNum)
	{
		switch(typeNum)
		{
			case 1:
			{
				this.typeOne = newType;
				break;
			}
			case 2:
			{
				this.typeTwo = newType;
				break;
			}
			default:
			{
				System.err.println("Incorrect type number");
				break;
			}
		}
	}

	public double getIndex(){return this.indexNum;}
	public String getName(){ return this.name;}
	public int getHP(){return this.hp;}
	public int getAtk(){return this.atk;}
	public int getDef(){return this.def;}
	public int getSpAtk(){return this.spAtk;}
	public int getSpDef(){return this.spDef;}
	public int getSpeed(){return this.speed;}
	public double getWeight(){return this.weight;}
	public Type getType1(){return this.typeOne;}
	public Type getType2(){return this.typeTwo;}
	public Gender getGender(){return this.gender;}
	
	/*
	 * Basic Constructors for Pokemon Objects
	 */
	public Pokemon(){} 
	
	/*
	 * Full constructor with two types
	 */
	public Pokemon(double indexNum, String name, int hp, int atk, int def, int spAtk, int spDef, int speed, Type typeOne, Type typeTwo)
	{
		setIndex(indexNum);
		setName(name);
		setHp(hp);
		setAtk(atk);
		setDef(def);
		setSpAtk(spAtk);
		setSpDef(spDef);
		setSpeed(speed);
		setType(typeOne,1);
		setType(typeTwo,2);
	}
	
	/*
	 * Full constructor for single-type Pokemon
	 */
	public Pokemon(double indexNum, String name, int hp, int atk, int def, int spAtk, int spDef, int speed, Type typeOne)
	{
		setIndex(indexNum);
		setName(name);
		setHp(hp);
		setAtk(atk);
		setDef(def);
		setSpAtk(spAtk);
		setSpDef(spDef);
		setSpeed(speed);
		setType(typeOne,1);
		setType(null,2);
	}
	
	
	/*
	 * Copy constructor
	 */
	public Pokemon(Pokemon a, Move move1, Move move2, Move move3, Move move4)
	{
		this.indexNum = a.getIndex();
		this.name = a.getName();
		this.hp = a.getHP();
		this.atk = a.getAtk();
		this.def = a.getDef();
		this.spAtk = a.getSpAtk();
		this.spDef = a.getSpDef();
		this.speed = a.getSpeed();
		this.typeOne = a.getType1();
		this.typeTwo = a.getType2();
		setMove(move1,1);
		setMove(move2,2);
		setMove(move3,3);
		setMove(move4,4);
	}
	
}
