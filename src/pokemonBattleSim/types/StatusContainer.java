package pokemonBattleSim.types;

public class StatusContainer 
{
	private boolean active, degreeReset;
	private int originalStat, degree;
	private String name;
	private Move forcedMove;
	
	public StatusContainer(boolean act, int orgStat, int deg, String nm, Move forced)
	{
		active = act;
		originalStat = orgStat; //set to -1 is never used
		degree = deg;			//set to -1 is never used
		name = nm;
		degreeReset = false;
		forcedMove = forced;
	}
	
	public void setActiveStatus(boolean set){ this.active = set; }
	public void setOriginalStat(int stat){ this.originalStat = stat; }
	public void setDegree(int deg){ this.degree = deg; }
	
	public void addToDegree(int deg, boolean resetable) 
	{ 
		this.degree += deg; 
		if(this.degree > 100 && resetable)
		{
			this.degree %= 100;
			this.degreeReset = true;
		}
		else if(this.degree > 100 && !resetable)
		{
			this.degree = 100;
		}
	}
	
	public void setName(String nm){ this.name = nm; }
	
	public boolean getActiveStatus(){ return this.active; }
	public int getOriginalStat(){ return this.originalStat; }
	public int getDegree(){ return this.degree; }
	public String getName(){ return this.name; }
	public boolean getDegreeResetStatus(){ return this.degreeReset; }
	public Move getForcedMove(){ return this.forcedMove; }
}
