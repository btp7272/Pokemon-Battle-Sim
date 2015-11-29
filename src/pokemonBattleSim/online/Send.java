package pokemonBattleSim.online;
import pokemonBattleSim.types.*;
import pokemonBattleSim.online.Recieve;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Send 
{
	static Socket opponent = null;  
    static ObjectOutputStream out = null;
    public static boolean Online = false;
    DataOutputStream test = null;
    Socket testSocket = null;
    Socket socket = null;
    
    public static void closeSocket()
    {
    	try
    	{
    		opponent.close();
    		out.close();
    	}
    	catch (UnknownHostException e) 
		{
            System.err.println("Don't know about host: opponent");
        } 
		catch (IOException e) 
		{
            System.err.println("Couldn't get I/O for the connection to: opponent");
        }
    }
    
	public static Socket createSocket(String ip)
	{
		try 
		{
            opponent = new Socket(ip, 8000);
            out = new ObjectOutputStream(opponent.getOutputStream());
        } 
		catch (UnknownHostException e) 
		{
            System.err.println("Don't know about host: opponent");
        } 
		catch (IOException e) 
		{
            System.err.println("Couldn't get I/O for the connection to: opponent");
        }
		return opponent;
	}
	
	public boolean testConnection(String ip) throws IOException
	{
		String s = "TEST";
		try 
		{
			Socket testSocket = new Socket(ip, 8000);
		}
		catch (IOException e) 
		{
			System.err.println(e);
		}
		try 
		{
			DataOutputStream test = new DataOutputStream(testSocket.getOutputStream());
		} 
		catch (IOException e) 
		{
			System.err.println(e);
		}
		test.writeBytes(s);
		test.flush();
		return Recieve.getTestConnection();
	}
	
	public static void sendPacket(String s, Object o)
	{
		instructionPacket packet = new instructionPacket(s,o);
		try
		{
			out.writeObject(packet);
			out.flush();
		}
		catch (IOException e) 
		{
			System.err.println(e);
		}
	}
}
