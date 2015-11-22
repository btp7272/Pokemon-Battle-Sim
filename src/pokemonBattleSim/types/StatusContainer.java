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
	
	public void setActiveStatus(boolean set){ active = set; }
	public void setOriginalStat(int stat){ originalStat = stat; }
	public void setDegree(int deg){ degree = degree; }
	
	public void addToDegree(int deg) 
	{ 
		degree += deg; 
		if(degree > 100)
		{
			degree %= 100;
			degreeReset = true;
		}
	}
	
	public void setName(String nm){ name = nm; }
	
	public boolean getActiveStatus(){ return active; }
	public int getOriginalStat(){ return originalStat; }
	public int getDegree(){ return degree; }
	public String getName(){ return name; }
	public boolean getDegreeResetStatus(){ return degreeReset; }
	public Move getForcedMove(){ return forcedMove; }
}
