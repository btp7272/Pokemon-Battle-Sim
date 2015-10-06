package pokemonBattleSim.types;

public class Move 
{
	public String name;
	public Type type = null;
	public Attribute category = null;
	public Contest contest = null;
	public int pp;
	public int power;
	public double accuracy;
	
	
	private void setName(String name){this.name = name;}
	private void setType(Type yype){this.type = type;}
	private void setCategory(Attribute category){this.category = category;}
	private void setContest(Contest contest){this.contest = contest;}
	private void setPP(int pp){this.pp = pp;}
	private void setPower(int power){this.power = power;}
	private void setAccuracy(double accuracy){this.accuracy = accuracy;}
	
	public String getName(){return this.name;}
	public Type getType(){return this.type;}
	public Attribute getCategory(){return this.category;}
	public Contest getContest(){return this.contest;}
	public int getPP(){return this.pp;}
	public int getPower(){return this.power;}
	public double getAccuracy(){return this.accuracy;}
	
	
	public Move(){}
	public Move(String name, Type type, Attribute category, Contest contest, int pp, int power, double accuracy)
	{
		this.name = name;
		this.type = type;
		this.category = category;
		this.contest = contest;
		this.pp = pp;
		this.power = power;
		this.accuracy = accuracy/100;
	}
}