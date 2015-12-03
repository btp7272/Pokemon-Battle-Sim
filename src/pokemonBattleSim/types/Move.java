package pokemonBattleSim.types;

public class Move 
{
	/*
	 * Constructor for move objects, ecludes their runable methods.
	 */
	private String name;
	private Type type = null;
	private Attribute category = null;
	private int pp;
	private int power;
	private double accuracy;
	private MoveEffectContainer effect;
	
	
	public void setName(String name){this.name = name;}
	public void setType(Type type){this.type = type;}
	public void setCategory(Attribute category){this.category = category;}
	public void setPP(int pp){this.pp = pp;}
	public void setPower(int power){this.power = power;}
	public void setAccuracy(double accuracy){this.accuracy = accuracy;}
	public void setMoveEffectContainer(MoveEffectContainer mec){this.effect = mec;}
	
	public String getName(){return this.name;}
	public Type getType(){return this.type;}
	public Attribute getCategory(){return this.category;}
	public int getPP(){return this.pp;}
	public int getPower(){return this.power;}
	public double getAccuracy(){return this.accuracy;}
	public MoveEffectContainer getMoveEffectContainer(){return this.effect;}
	
	
	public Move(){}
	public Move(String name, Type type, Attribute category, int pp, int power, double accuracy)
	{
		this.name = name;
		this.type = type;
		this.category = category;
		this.pp = pp;
		this.power = power;
		this.accuracy = accuracy/100;
		this.effect = new MoveEffectContainer(name);
	}
	
	public Move(Move toCopy)
	{
		this.name = toCopy.getName();
		this.type = toCopy.getType();
		this.category = toCopy.getCategory();
		this.pp = toCopy.getPP();
		this.power = toCopy.getPower();
		this.accuracy = toCopy.getAccuracy();
		this.effect = new MoveEffectContainer(toCopy.getName());
	}
}
