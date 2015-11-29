package pokemonBattleSim.online;

public class instructionPacket {
	static String instruction=null;
	static Object object=null;
	
	public instructionPacket(String s, Object o)
	{
		object = o;
		instruction = s;
	}
	
	public String getInstruction()
	{
		return this.instruction;
	}
	
	public Object getObject()
	{
		return this.object;
	}
}
