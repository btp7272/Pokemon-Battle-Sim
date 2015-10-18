package pokemonBattleSim.types;

public class Status 
{
	Volatility volatility;
	String name;
	
	public Volatility getVol() {return volatility;}
	public String getName() {return name;}
	
	public void setVol(Volatility vol) {this.volatility = vol;}
	public void setName(String nm){this.name = nm;}
	
	public Status(Volatility vol, String name)
	{
		setVol(vol);
		setName(name);
	}

	
}


