package pokemonBattleSim.online;

import java.io.Serializable;

public class instructionPacket implements Serializable {
	static String IPAddress=null;
	static String instruction=null;
	static Object object=null;
	
	public instructionPacket(String IP, String s, Object o)
	{
		IPAddress = IP;
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
