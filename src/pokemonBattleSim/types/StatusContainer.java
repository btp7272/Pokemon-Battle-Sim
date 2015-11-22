package pokemonBattleSim.types;

public class StatusContainer 
{
	private boolean active;
	private int originalStat, degree;
	private String name;
	
	public StatusContainer(boolean act, int orgStat, int deg, String nm)
	{
		active = act;
		originalStat = orgStat; //set to -1 is never used
		degree = deg;			//set to -1 is never used
		name = nm;
	}
	
	public void setActiveStatus(boolean set){ active = set; }
	public void setOriginalStat(int stat){ originalStat = stat; }
	public void setDegree(int deg){ degree = degree; }
	public void addToDegree(int deg) { degree += deg; if(degree > 100) degree %= 100; }
	public void setName(String nm){ name = nm; }
	
	public boolean getActiveStatus(){ return active; }
	public int getOriginalStat(){ return originalStat; }
	public int getDegree(){ return degree; }
	public String getName(){ return name; }
}
