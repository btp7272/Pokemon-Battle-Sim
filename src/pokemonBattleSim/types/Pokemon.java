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
	int atkModifier = 0;
	int defModifier = 0;
	int spDefModifier = 0;
	int spAtkModifier = 0;
	int speedModifier = 0;
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
	
	public void setIndex(double index){ this.indexNum = index;}
	public void setName(String newName){ this.name = newName;}
	public void setHp(int health){	this.hp = Formula.calcHP(health); this.baseHp = this.hp;}
	public void setAtk(int attack){ this.atk = Formula.calcStat(attack); this.baseAtk = this.atk;}
	public void setDef(int defense){ this.def = Formula.calcStat(defense); this.baseDef = this.def;}
	public void setSpAtk(int spattack){ this.spAtk = Formula.calcStat(spattack); this.baseSpAtk = this.spAtk;}
	public void setSpDef(int spdefense){ this.spDef = Formula.calcStat(spdefense); this.baseSpDef = this.spDef;}
	public void setSpeed(int newSpeed){ this.speed = Formula.calcStat(newSpeed); this.baseSpeed = this.speed;}
	public void setWeight(double newWeight){ this.weight = newWeight; this.baseWeight = newWeight;}
	public void setGender(Gender gen){this.gender = gen;}
	
	//para: number -6 to 6. The stage of the stat
	public void changeAtk(int change)
	{
		this.atkModifier += change;
		if(this.atkModifier > 6)
		{
			this.atkModifier = 6;
		}
		if(this.atkModifier < -6)
		{
			this.atkModifier = -6;
		}
		switch(this.atkModifier) 
		{
			case -6 :
				this.atk = (int)(this.baseAtk * (2.0/8));
				break;
			case -5 :
				this.atk = (int)(this.baseAtk * (2.0/7));
				break;
			case -4 : 
				this.atk = (int)(this.baseAtk * (2.0/6));
				break;
			case -3 :
				this.atk = (int)(this.baseAtk * (2.0/5));
				break;
			case -2 :
				this.atk = (int)(this.baseAtk * (2.0/4));
				break;
			case -1 : 
				this.atk = (int)(this.baseAtk * (2.0/3));
				break;
			case 0 :
				this.atk = (int)(this.baseAtk * (2.0/2));
				break;
			case 1 :
				this.atk = (int)(this.baseAtk * (3.0/2));
				break;
			case 2 :
				this.atk = (int)(this.baseAtk * (4.0/2));
				break;
			case 3 : 
				this.atk = (int)(this.baseAtk * (5.0/2));
				break;
			case 4 :
				this.atk = (int)(this.baseAtk * (6.0/2));
				break;
			case 5 :
				this.atk = (int)(this.baseAtk * (7.0/2));
				break;
			case 6 : 
				this.atk = (int)(this.baseAtk * (8.0/2));
				break;
		}
	}
	
	public void changeDef(int change)
	{
		this.defModifier += change;
		if(this.defModifier > 6)
		{
			this.defModifier = 6;
		}
		if(this.defModifier < -6)
		{
			this.defModifier = -6;
		}
		switch(this.defModifier) 
		{
			case -6 :
				this.def = (int)(this.baseDef * (2.0/8));
				break;
			case -5 :
				this.def = (int)(this.baseDef * (2.0/7));
				break;
			case -4 : 
				this.def = (int)(this.baseDef * (2.0/6));
				break;
			case -3 :
				this.def = (int)(this.baseDef * (2.0/5));
				break;
			case -2 :
				this.def = (int)(this.baseDef * (2.0/4));
				break;
			case -1 : 
				this.def = (int)(this.baseDef * (2.0/3));
				break;
			case 0 :
				this.def = (int)(this.baseDef * (2.0/2));
				break;
			case 1 :
				this.def = (int)(this.baseDef * (3.0/2));
				break;
			case 2 :
				this.def = (int)(this.baseDef * (4.0/2));
				break;
			case 3 : 
				this.def = (int)(this.baseDef * (5.0/2));
				break;
			case 4 :
				this.def = (int)(this.baseDef * (6.0/2));
				break;
			case 5 :
				this.def = (int)(this.baseDef * (7.0/2));
				break;
			case 6 : 
				this.def = (int)(this.baseDef * (8.0/2));
				break;
		}
	}
	
	public void changeSpAtk(int change)
	{
		this.spAtkModifier += change;
		if(this.spAtkModifier > 6)
		{
			this.spAtkModifier = 6;
		}
		if(this.spAtkModifier < -6)
		{
			this.spAtkModifier = -6;
		}
		switch(this.spAtkModifier) 
		{
			case -6 :
				this.spAtk = (int)(this.baseSpAtk * (2.0/8));
				break;
			case -5 :
				this.spAtk = (int)(this.baseSpAtk * (2.0/7));
				break;
			case -4 : 
				this.spAtk = (int)(this.baseSpAtk * (2.0/6));
				break;
			case -3 :
				this.spAtk = (int)(this.baseSpAtk * (2.0/5));
				break;
			case -2 :
				this.spAtk = (int)(this.baseSpAtk * (2.0/4));
				break;
			case -1 : 
				this.spAtk = (int)(this.baseSpAtk * (2.0/3));
				break;
			case 0 :
				this.spAtk = (int)(this.baseSpAtk * (2.0/2));
				break;
			case 1 :
				this.spAtk = (int)(this.baseSpAtk * (3.0/2));
				break;
			case 2 :
				this.spAtk = (int)(this.baseSpAtk * (4.0/2));
				break;
			case 3 : 
				this.spAtk = (int)(this.baseSpAtk * (5.0/2));
				break;
			case 4 :
				this.spAtk = (int)(this.baseSpAtk * (6.0/2));
				break;
			case 5 :
				this.spAtk = (int)(this.baseSpAtk * (7.0/2));
				break;
			case 6 : 
				this.spAtk = (int)(this.baseSpAtk * (8.0/2));
				break;
		}
	}
	
		
	public void changeSpDef(int change)
	{
		this.spDefModifier += change;
		if(this.spDefModifier > 6)
		{
			this.spDefModifier = 6;
		}
		if(this.spDefModifier < -6)
		{
			this.spDefModifier = -6;
		}
		switch(this.spDefModifier) 
		{
			case -6 :
				this.spDef = (int)(this.baseSpDef * (2.0/8));
				break;
			case -5 :
				this.spDef = (int)(this.baseSpDef * (2.0/7));
				break;
			case -4 : 
				this.spDef = (int)(this.baseSpDef * (2.0/6));
				break;
			case -3 :
				this.spDef = (int)(this.baseSpDef * (2.0/5));
				break;
			case -2 :
				this.spDef = (int)(this.baseSpDef * (2.0/4));
				break;
			case -1 : 
				this.spDef = (int)(this.baseSpDef * (2.0/3));
				break;
			case 0 :
				this.spDef = (int)(this.baseSpDef * (2.0/2));
				break;
			case 1 :
				this.spDef = (int)(this.baseSpDef * (3.0/2));
				break;
			case 2 :
				this.spDef = (int)(this.baseSpDef * (4.0/2));
				break;
			case 3 : 
				this.spDef = (int)(this.baseSpDef * (5.0/2));
				break;
			case 4 :
				this.spDef = (int)(this.baseSpDef * (6.0/2));
				break;
			case 5 :
				this.spDef = (int)(this.baseSpDef * (7.0/2));
				break;
			case 6 : 
				this.spDef = (int)(this.baseSpDef * (8.0/2));
				break;
		}
	}
	
	public void changeSpeed(int change)
	{
		this.speedModifier += change;
		if(this.speedModifier > 6)
		{
			this.speedModifier = 6;
		}
		if(this.speedModifier < -6)
		{
			this.speedModifier = -6;
		}
		switch(this.speedModifier) 
		{
			case -6 :
				this.speed = (int)(this.baseSpeed * (2.0/8));
				break;
			case -5 :
				this.speed = (int)(this.baseSpeed * (2.0/7));
				break;
			case -4 : 
				this.speed = (int)(this.baseSpeed * (2.0/6));
				break;
			case -3 :
				this.speed = (int)(this.baseSpeed * (2.0/5));
				break;
			case -2 :
				this.speed = (int)(this.baseSpeed * (2.0/4));
				break;
			case -1 : 
				this.speed = (int)(this.baseSpeed * (2.0/3));
				break;
			case 0 :
				this.speed = (int)(this.baseSpeed * (2.0/2));
				break;
			case 1 :
				this.speed = (int)(this.baseSpeed * (3.0/2));
				break;
			case 2 :
				this.speed = (int)(this.baseSpeed * (4.0/2));
				break;
			case 3 : 
				this.speed = (int)(this.baseSpeed * (5.0/2));
				break;
			case 4 :
				this.speed = (int)(this.baseSpeed * (6.0/2));
				break;
			case 5 :
				this.speed = (int)(this.baseSpeed * (7.0/2));
				break;
			case 6 : 
				this.speed = (int)(this.baseSpeed * (8.0/2));
				break;
		}
	}
	
	public void changeHP(int damage)
	{
		int newHP = this.hp - damage;
		if(damage >= this.hp)
			this.hp = 0;
		else
			this.hp = newHP;
	}
	
	public void changeWeight(double newWeight){ this.weight = newWeight;}
	
	public void resetHP() { this.hp = this.baseHp; }
	public void resetAtk() { this.atkModifier = 0; this.atk = this.baseAtk; }
	public void resetDef() { this.defModifier = 0; this.def = this.baseDef; }
	public void resetSpAtk() { this.spAtkModifier = 0; this.spAtk = this.baseSpAtk; }
	public void resetSpDef() { this.spDefModifier = 0; this.spDef = this.baseSpDef; }
	public void resetSpeed() { this.speedModifier = 0; this.speed = this.baseSpeed; }
	
	
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
	public int getBaseHP() {return this.baseHp;}
	public int getAtk(){return this.atk;}
	public int getDef(){return this.def;}
	public int getSpAtk(){return this.spAtk;}
	public int getSpDef(){return this.spDef;}
	public int getSpeed(){return this.speed;}
	public double getWeight(){return this.weight;}
	public Type getType1(){return this.typeOne;}
	public Type getType2(){return this.typeTwo;}
	public Gender getGender(){return this.gender;}
	public int getAtkModifier(){return this.atkModifier;}
	public int getDefModifier(){return this.defModifier;}
	public int getSpAtkModifier(){return this.spAtkModifier;}
	public int getSpDefModifier(){return this.spDefModifier;}
	public int getSpeedModifier(){return this.speedModifier;}
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
