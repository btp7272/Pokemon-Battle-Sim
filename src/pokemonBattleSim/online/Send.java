package pokemonBattleSim.online;
import pokemonBattleSim.types.*;
import pokemonBattleSim.views.Connect;
import pokemonBattleSim.online.Recieve;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Send 
{
	static Socket opponent = null;  
    static ObjectOutputStream out = null;
    public static boolean Online = false;
    static ObjectOutputStream test = null;
    static Socket testSocket = null;
    static Socket socket = null;
    public static String IPAddress;
    
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
            opponent = new Socket(ip, 6943);
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
	
	public static boolean testConnection(String ip) throws IOException
	{
		instructionPacket s = new instructionPacket("TEST1",null);
		try 
		{
			Socket testSocket = new Socket(ip, 6943);
		}
		catch (IOException e) 
		{
			System.err.println(e);
		}
		try 
		{
			ObjectOutputStream test = new ObjectOutputStream(testSocket.getOutputStream());
		} 
		catch (IOException e) 
		{
			System.err.println(e);
		}
		test.writeObject(s);
		test.flush();
		return true;
	}
	
	public static boolean testConnectionHandshake(String ip) throws IOException
	{
		instructionPacket s = new instructionPacket("TEST1",null);
		try 
		{
			Socket testSocket = new Socket(ip, 6943);
		}
		catch (IOException e) 
		{
			System.err.println(e);
		}
		try 
		{
			ObjectOutputStream test = new ObjectOutputStream(testSocket.getOutputStream());
		} 
		catch (IOException e) 
		{
			System.err.println(e);
		}
		test.writeObject(s);
		test.flush();
		return true;
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
	public static String getIPAddress()
	{
		return IPAddress;
	}
	public static void setIPAddress() throws IOException
	{
		IPAddress = Connect.IPAddress.getText();
		testConnection(IPAddress);
	}
}
