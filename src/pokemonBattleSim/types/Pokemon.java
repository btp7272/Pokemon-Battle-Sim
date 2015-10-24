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
	public void setHp(int health, int IV, int EV, int level){ this.hp = Formula.calcHP(health,IV,EV,level); this.baseHp = this.hp;}
	public void setAtk(int attack, int IV, int EV, int level){ this.atk = Formula.calcStat(attack,IV,EV,level); this.baseAtk = this.atk;}
	public void setDef(int defense, int IV, int EV, int level){ this.def = Formula.calcStat(defense,IV,EV,level); this.baseDef = this.def;}
	public void setSpAtk(int spattack, int IV, int EV, int level){ this.spAtk = Formula.calcStat(spattack,IV,EV,level); this.baseSpAtk = this.spAtk;}
	public void setSpDef(int spdefense, int IV, int EV, int level){ this.spDef = Formula.calcStat(spdefense,IV,EV,level); this.baseSpDef = this.spDef;}
	public void setSpeed(int newSpeed, int IV, int EV, int level){ this.speed = Formula.calcStat(newSpeed,IV,EV,level); this.baseSpeed = this.speed;}
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
	public int getBaseAtk() {return this.baseAtk;}
	public int getDef(){return this.def;}
	public int getBaseDef() {return this.baseDef;}
	public int getSpAtk(){return this.spAtk;}
	public int getBaseSpAtk() {return this.baseSpAtk;}
	public int getSpDef(){return this.spDef;}
	public int getBaseSpDef() {return this.baseSpDef;}
	public int getSpeed() {return this.speed;}
	public int getBaseSpeed() {return this.baseSpeed;}
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
	 * Full constructor for duel-type Pokemon. This is for the map. It is
	 * never used to create the pokemon the users play with. This constructor passes the
	 * base statistic of the pokemon before the actual stat is calculate, which
	 * will be done in the copy constructor.
	 */
	public Pokemon(double indexNum, String name, int hp, int atk, int def, int spAtk, int spDef, int speed, Type typeOne, Type typeTwo)
	{
		setIndex(indexNum);
		setName(name);
		this.baseHp = hp;
		this.baseAtk = atk;
		this.baseDef = def;
		this.baseSpAtk = spAtk;
		this.baseSpDef = spDef;
		this.baseSpeed = speed;
		setType(typeOne,1);
		setType(typeTwo,2);
	}
	
	/*
	 * Full constructor for single-type Pokemon. This is for the map. It is never used
	 * to create the pokemon the users play with. This constructor passes the
	 * base statistic of the pokemon before the actual stat is calculated, which
	 * will be done in the copy constructor
	 */
	public Pokemon(double indexNum, String name, int hp, int atk, int def, int spAtk, int spDef, int speed, Type typeOne)
	{
		setIndex(indexNum);
		setName(name);
		this.baseHp = hp;
		this.baseAtk = atk;
		this.baseDef = def;
		this.baseSpAtk = spAtk;
		this.baseSpDef = spDef;
		this.baseSpeed = speed;
		setType(typeOne,1);
		setType(null,2);
	}
	
	
	/*
	 * Copy constructor. In this constructor the stats are set to the calculated,
	 * final stat of the pokemon. The base stat is used to keep this value unmodified
	 * in the event it is needed after said stat is modified.
	 *  @exeption: IV and EV arrays must be size 6
	 *  @exeption: level must be between 1 and 100
	 *  @parameter: a = pokemon initialized by a full constructor
	 *  @parameter: IVs = the IVs for each stat in order they appear in this document
	 *  @parameter: EVs = the EVs for each stat in order they appear in this document
	 */
	public Pokemon(Pokemon a, Move move1, Move move2, Move move3, Move move4, int[] IVs, int[] EVs, int level, Nature nature)
	{
		if(IVs.length != 6 || EVs.length != 6)
			throw new ArrayIndexOutOfBoundsException("There must be 6 values for both IVs and EVs");
		if(level < 1 || level > 100)
			throw new IllegalArgumentException("Invalid level");
		this.indexNum = a.getIndex();
		this.name = a.getName();
		this.setHp(a.getBaseHP(),IVs[0],EVs[0],level);
		this.setAtk(a.getBaseAtk(),IVs[1],EVs[1],level);
		this.setDef(a.getBaseDef(),IVs[2],EVs[2],level);
		this.setSpAtk(a.getBaseSpAtk(),IVs[3],EVs[3],level);
		this.setSpDef(a.getBaseSpDef(),IVs[4],EVs[4],level);
		this.setSpeed(a.getBaseSpeed(),IVs[5],EVs[5],level);
		
		
		/*
		 * Attack = 0 
		 * Defense = 1
		 * Special Attack = 2
		 * Special Defense = 3
		 * Speed = 4
		 */
		switch(nature.getType(nature.getIncrease()))
		{
			case 0:
				this.baseAtk *= 1.1;
				this.atk = baseAtk;
				break;
			case 1:
				this.baseDef *= 1.1;
				this.atk = baseDef;
				break;
			case 2:
				this.baseSpAtk *= 1.1;
				this.atk = baseSpAtk;
				break;
			case 3:
				this.baseSpDef *= 1.1;
				this.atk = baseSpDef;
				break;
			case 4:
				this.baseSpeed *= 1.1;
				this.atk = baseSpeed;
				break;
		}
		
		switch(nature.getType(nature.getDecrease()))
		{
			case 0:
				this.baseAtk *= .9;
				this.atk = baseAtk;
				break;
			case 1:
				this.baseDef *= .9;
				this.atk = baseDef;
				break;
			case 2:
				this.baseSpAtk *= .9;
				this.atk = baseSpAtk;
				break;
			case 3:
				this.baseSpDef *= .9;
				this.atk = baseSpDef;
				break;
			case 4:
				this.baseSpeed *= .9;
				this.atk = baseSpeed;
				break;
		}
		
		setMove(move1,1);
		setMove(move2,2);
		setMove(move3,3);
		setMove(move4,4);
	}
	
}
