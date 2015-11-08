/*
 * Bryan Powell 9-27-2015

 * Pokemon constructors and operators
 */
package pokemonBattleSim.types;
import pokemonBattleSim.formulas.Formula;


public class Pokemon implements IPokemon
{
	private String speciesName, nickName;
	private int hp, maxHp;
	private int atkModifier = 0, defModifier = 0, spDefModifier = 0, spAtkModifier = 0, speedModifier = 0;
	private int atk, maxAtk;
	private int def, maxDef;
	private int spAtk, maxSpAtk;
	private int spDef, maxSpDef;
	private int speed, maxSpeed;
	private int level;
	private double weight, baseWeight;
	private IAbility ability, baseAbility;
	private Move moveOne, moveTwo, moveThree, moveFour;
	private Type typeOne, baseTypeOne, typeTwo, baseTypeTwo, typeThree = null;
	private Gender gender;
	//heldItem item = null;
	
	/*
	 * Initial constructor. In this constructor the stats are set to the calculated,
	 * final stat of the pokemon. The max stat is used to keep this value unmodified
	 * in the event it is needed after said stat is modified.
	 *  @exeption: IV and EV arrays must be size 6
	 *  @exeption: level must be between 1 and 100
	 *  @parameter: a = pokemon initialized by a full constructor
	 *  @parameter: IVs = the IVs for each stat in order they appear in this document
	 *  @parameter: An IV is a number between 0 and 31. This is like a gene that determines how strong a trait is
	 *  @parameter: EVs = the EVs for each stat in order they appear in this document
	 *  @parameter: An EV is a number between 0 and 252. This is like skill resultant of training. A pokemon is only allowed a total of 510 EVs
	 */
	public Pokemon(Species a, String nickname, Move[] moves, int[] IVs, int[] EVs, int level, Nature nature, IAbility abil)
	{
		if(IVs.length != 6 || EVs.length != 6)
			throw new ArrayIndexOutOfBoundsException("There must be 6 values for both IVs and EVs");
		if(level < 1 || level > 100)
			throw new IllegalArgumentException("Invalid level");
		this.speciesName = a.getName();
		this.nickName = nickname;
		this.setHp(a.getBaseHP(),IVs[0],EVs[0],level);
		this.setAtk(a.getBaseAtk(),IVs[1],EVs[1],level);
		this.setDef(a.getBaseDef(),IVs[2],EVs[2],level);
		this.setSpAtk(a.getBaseSpAtk(),IVs[3],EVs[3],level);
		this.setSpDef(a.getBaseSpDef(),IVs[4],EVs[4],level);
		this.setSpeed(a.getBaseSpeed(),IVs[5],EVs[5],level);
		this.setLevel(level);
		this.setType(a.getType1(), 1);
		this.setType(a.getType2(), 2);
		this.weight = this.baseWeight = a.getWeight();
		this.ability = this.baseAbility = abil;
		
		
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
				this.maxAtk *= 1.1;
				this.atk = maxAtk;
				break;
			case 1:
				this.maxDef *= 1.1;
				this.atk = maxDef;
				break;
			case 2:
				this.maxSpAtk *= 1.1;
				this.atk = maxSpAtk;
				break;
			case 3:
				this.maxSpDef *= 1.1;
				this.atk = maxSpDef;
				break;
			case 4:
				this.maxSpeed *= 1.1;
				this.atk = maxSpeed;
				break;
		}
		
		switch(nature.getType(nature.getDecrease()))
		{
			case 0:
				this.maxAtk *= .9;
				this.atk = maxAtk;
				break;
			case 1:
				this.maxDef *= .9;
				this.atk = maxDef;
				break;
			case 2:
				this.maxSpAtk *= .9;
				this.atk = maxSpAtk;
				break;
			case 3:
				this.maxSpDef *= .9;
				this.atk = maxSpDef;
				break;
			case 4:
				this.maxSpeed *= .9;
				this.atk = maxSpeed;
				break;
		}
		
		//Right now, we allow for 4 moves.
		for(int i = 0; i < moves.length; i++)
			setMove(moves[i],i+1);
	}

	public void setHp(int health, int IV, int EV, int level){ this.hp = Formula.calcHP(health,IV,EV,level); this.maxHp = this.hp;}
	public void setAtk(int attack, int IV, int EV, int level){ this.atk = Formula.calcStat(attack,IV,EV,level); this.maxAtk = this.atk;}
	public void setDef(int defense, int IV, int EV, int level){ this.def = Formula.calcStat(defense,IV,EV,level); this.maxDef = this.def;}
	public void setSpAtk(int spattack, int IV, int EV, int level){ this.spAtk = Formula.calcStat(spattack,IV,EV,level); this.maxSpAtk = this.spAtk;}
	public void setSpDef(int spdefense, int IV, int EV, int level){ this.spDef = Formula.calcStat(spdefense,IV,EV,level); this.maxSpDef = this.spDef;}
	public void setSpeed(int newSpeed, int IV, int EV, int level){ this.speed = Formula.calcStat(newSpeed,IV,EV,level); this.maxSpeed = this.speed;}
	public void setWeight(double newWeight){ this.weight = newWeight; this.baseWeight = newWeight;}
	public void setGender(Gender gen){this.gender = gen;}
	public void setLevel(int lev){this.level = lev;}
	public void setAtkModifier(int mod){ changeAtk(mod - this.atkModifier);}
	public void setDefModifier(int mod){ changeAtk(mod - this.defModifier);}
	public void setSpAtkModifier(int mod){ changeAtk(mod - this.spAtkModifier);}
	public void setSpDefModifier(int mod){ changeAtk(mod - this.spDefModifier);}
	public void setSpeedModifier(int mod){ changeAtk(mod - this.speedModifier);}
	public void setAbility(IAbility abil){ this.ability = abil;}
	
	public void changeAtkNoModifier(double multiplier, boolean wasOdd)
	{
		this.atk *= multiplier;
		if(wasOdd && multiplier > 1)
			this.atk += 1;
	}
	public void changeSpAtkNoModifier(double multiplier, boolean wasOdd)
	{
		this.spAtk *= multiplier;
		if(wasOdd && multiplier > 1)
			this.atk += 1;
	}
	
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
				this.atk = (int)(this.maxAtk * (2.0/8));
				break;
			case -5 :
				this.atk = (int)(this.maxAtk * (2.0/7));
				break;
			case -4 : 
				this.atk = (int)(this.maxAtk * (2.0/6));
				break;
			case -3 :
				this.atk = (int)(this.maxAtk * (2.0/5));
				break;
			case -2 :
				this.atk = (int)(this.maxAtk * (2.0/4));
				break;
			case -1 : 
				this.atk = (int)(this.maxAtk * (2.0/3));
				break;
			case 0 :
				this.atk = (int)(this.maxAtk * (2.0/2));
				break;
			case 1 :
				this.atk = (int)(this.maxAtk * (3.0/2));
				break;
			case 2 :
				this.atk = (int)(this.maxAtk * (4.0/2));
				break;
			case 3 : 
				this.atk = (int)(this.maxAtk * (5.0/2));
				break;
			case 4 :
				this.atk = (int)(this.maxAtk * (6.0/2));
				break;
			case 5 :
				this.atk = (int)(this.maxAtk * (7.0/2));
				break;
			case 6 : 
				this.atk = (int)(this.maxAtk * (8.0/2));
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
				this.def = (int)(this.maxDef * (2.0/8));
				break;
			case -5 :
				this.def = (int)(this.maxDef * (2.0/7));
				break;
			case -4 : 
				this.def = (int)(this.maxDef * (2.0/6));
				break;
			case -3 :
				this.def = (int)(this.maxDef * (2.0/5));
				break;
			case -2 :
				this.def = (int)(this.maxDef * (2.0/4));
				break;
			case -1 : 
				this.def = (int)(this.maxDef * (2.0/3));
				break;
			case 0 :
				this.def = (int)(this.maxDef * (2.0/2));
				break;
			case 1 :
				this.def = (int)(this.maxDef * (3.0/2));
				break;
			case 2 :
				this.def = (int)(this.maxDef * (4.0/2));
				break;
			case 3 : 
				this.def = (int)(this.maxDef * (5.0/2));
				break;
			case 4 :
				this.def = (int)(this.maxDef * (6.0/2));
				break;
			case 5 :
				this.def = (int)(this.maxDef * (7.0/2));
				break;
			case 6 : 
				this.def = (int)(this.maxDef * (8.0/2));
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
				this.spAtk = (int)(this.maxSpAtk * (2.0/8));
				break;
			case -5 :
				this.spAtk = (int)(this.maxSpAtk * (2.0/7));
				break;
			case -4 : 
				this.spAtk = (int)(this.maxSpAtk * (2.0/6));
				break;
			case -3 :
				this.spAtk = (int)(this.maxSpAtk * (2.0/5));
				break;
			case -2 :
				this.spAtk = (int)(this.maxSpAtk * (2.0/4));
				break;
			case -1 : 
				this.spAtk = (int)(this.maxSpAtk * (2.0/3));
				break;
			case 0 :
				this.spAtk = (int)(this.maxSpAtk * (2.0/2));
				break;
			case 1 :
				this.spAtk = (int)(this.maxSpAtk * (3.0/2));
				break;
			case 2 :
				this.spAtk = (int)(this.maxSpAtk * (4.0/2));
				break;
			case 3 : 
				this.spAtk = (int)(this.maxSpAtk * (5.0/2));
				break;
			case 4 :
				this.spAtk = (int)(this.maxSpAtk * (6.0/2));
				break;
			case 5 :
				this.spAtk = (int)(this.maxSpAtk * (7.0/2));
				break;
			case 6 : 
				this.spAtk = (int)(this.maxSpAtk * (8.0/2));
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
				this.spDef = (int)(this.maxSpDef * (2.0/8));
				break;
			case -5 :
				this.spDef = (int)(this.maxSpDef * (2.0/7));
				break;
			case -4 : 
				this.spDef = (int)(this.maxSpDef * (2.0/6));
				break;
			case -3 :
				this.spDef = (int)(this.maxSpDef * (2.0/5));
				break;
			case -2 :
				this.spDef = (int)(this.maxSpDef * (2.0/4));
				break;
			case -1 : 
				this.spDef = (int)(this.maxSpDef * (2.0/3));
				break;
			case 0 :
				this.spDef = (int)(this.maxSpDef * (2.0/2));
				break;
			case 1 :
				this.spDef = (int)(this.maxSpDef * (3.0/2));
				break;
			case 2 :
				this.spDef = (int)(this.maxSpDef * (4.0/2));
				break;
			case 3 : 
				this.spDef = (int)(this.maxSpDef * (5.0/2));
				break;
			case 4 :
				this.spDef = (int)(this.maxSpDef * (6.0/2));
				break;
			case 5 :
				this.spDef = (int)(this.maxSpDef * (7.0/2));
				break;
			case 6 : 
				this.spDef = (int)(this.maxSpDef * (8.0/2));
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
				this.speed = (int)(this.maxSpeed * (2.0/8));
				break;
			case -5 :
				this.speed = (int)(this.maxSpeed * (2.0/7));
				break;
			case -4 : 
				this.speed = (int)(this.maxSpeed * (2.0/6));
				break;
			case -3 :
				this.speed = (int)(this.maxSpeed * (2.0/5));
				break;
			case -2 :
				this.speed = (int)(this.maxSpeed * (2.0/4));
				break;
			case -1 : 
				this.speed = (int)(this.maxSpeed * (2.0/3));
				break;
			case 0 :
				this.speed = (int)(this.maxSpeed * (2.0/2));
				break;
			case 1 :
				this.speed = (int)(this.maxSpeed * (3.0/2));
				break;
			case 2 :
				this.speed = (int)(this.maxSpeed * (4.0/2));
				break;
			case 3 : 
				this.speed = (int)(this.maxSpeed * (5.0/2));
				break;
			case 4 :
				this.speed = (int)(this.maxSpeed * (6.0/2));
				break;
			case 5 :
				this.speed = (int)(this.maxSpeed * (7.0/2));
				break;
			case 6 : 
				this.speed = (int)(this.maxSpeed * (8.0/2));
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
	
	
	public void resetHP() { this.hp = this.maxHp; }
	public void resetAtk() { this.atkModifier = 0; this.atk = this.maxAtk; }
	public void resetDef() { this.defModifier = 0; this.def = this.maxDef; }
	public void resetSpAtk() { this.spAtkModifier = 0; this.spAtk = this.maxSpAtk; }
	public void resetSpDef() { this.spDefModifier = 0; this.spDef = this.maxSpDef; }
	public void resetSpeed() { this.speedModifier = 0; this.speed = this.maxSpeed; }
	
	
	public void setMove(Move newMove, int moveNum)
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
	
	public void setType(Type newType, int typeNum)
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
			case 3:
			{
				this.typeThree = newType;
				break;
			}
			default:
			{
				System.err.println("Incorrect type number");
				break;
			}
		}
	}

	public String getSpeciesName(){ return this.speciesName;}
	public String getNickName(){ return this.nickName;}
	public int getHP(){return this.hp;}
	public int getMaxHP() {return this.maxHp;}
	public int getAtk(){return this.atk;}
	public int getMaxAtk() {return this.maxAtk;}
	public int getDef(){return this.def;}
	public int getMaxDef() {return this.maxDef;}
	public int getSpAtk(){return this.spAtk;}
	public int getMaxSpAtk() {return this.maxSpAtk;}
	public int getSpDef(){return this.spDef;}
	public int getMaxSpDef() {return this.maxSpDef;}
	public int getSpeed() {return this.speed;}
	public int getMaxSpeed() {return this.maxSpeed;}
	public double getWeight(){return this.weight;}
	public Type getType1(){return this.typeOne;}
	public Type getType2(){return this.typeTwo;}
	public Type getType3(){return this.typeThree;}
	public Gender getGender(){return this.gender;}
	public int getAtkModifier(){return this.atkModifier;}
	public int getDefModifier(){return this.defModifier;}
	public int getSpAtkModifier(){return this.spAtkModifier;}
	public int getSpDefModifier(){return this.spDefModifier;}
	public int getSpeedModifier(){return this.speedModifier;}
	public int getLevel(){return this.level;}
	public IAbility getAbility(){return this.ability;}
	public IAbility getBaseAbility(){return this.baseAbility;}
	
	
	
	/*
	 * Basic Constructors for Pokemon Objects
	 */
	public Pokemon(){} 
	
	
	
	
	
}
