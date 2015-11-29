package pokemonBattleSim.online;

public class instructionPacket {
	static String instruction=null;
	static Object object=null;
	
	public instructionPacket(String s, Object o)
	{
		object = o;
		instruction = s;
	}
	
	public static String getInstruction()
	{
		return instruction;
	}
	
	public static Object getObject()
	{
		return object;
	}
}
