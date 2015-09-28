/*
 * Bryan Powell 9-27-2015
 * Pokemon constructors and operators
 */

public class Pokemon 
{
	double indexNum;
	String name;
	int hp;
	int atk;
	int def;
	int spAtk;
	int spDef;
	int speed;
	double weight;
	Ability ability = null;
	Move moveOne = null;
	Move moveTwo = null;
	Move moveThree = null;
	Move moveFour = null;
	Type typeOne = null;
	Type typeTwo = null;
	Gender gender = null;
	heldItem item = null;
	
	private void setIndex(double index){ indexNum = index;}
	private void setName(String newName){ name = newName;}
	private void setHp(int health){	hp = health;}
	private void setAtk(int attack){ atk = attack;}
	private void setDef(int defense){ def = defense;}
	private void setSpAtk(int spattack){ spAtk = spattack;}
	private void setSpDef(int spdefense){ spDef = spdefense;}
	private void setSpeed(int newSpeed){ speed = newSpeed;}
	private void setWeight(double newWeight){ weight = newWeight;}
	public void setGender(Gender gen){gender = gen;}
	private void setAbility(Ability newAbility){ ability = newAbility;}
	private void setMove(Move newMove, int moveNum)
	{
		switch(moveNum)
		{
			case 1:
			{
				moveOne = newMove;
				break;
			}
			case 2:
			{
				moveTwo = newMove;
				break;
			}
			case 3:
			{
				moveThree = newMove;
				break;
			}
			case 4:
			{
				moveFour = newMove;
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
				typeOne = newType;
				break;
			}
			case 2:
			{
				typeTwo = newType;
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
	public Pokemon(double indexNum, String name, int hp, int atk, int def, int spAtk, int spDef, int speed)
	{
		this.indexNum = indexNum;
		this.name = name;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.spAtk = spAtk;
		this.spDef = spDef;
		this.speed = speed;
	}
	
}
