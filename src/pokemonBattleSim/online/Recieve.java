package pokemonBattleSim.online;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import pokemonBattleSim.types.*;

public class Recieve 
{
	static ServerSocket Server = null;
	static ServerSocket Test = null;
	static Socket socketTest = null;
	static DataInputStream testIn = null;
	static String line;
	static ObjectInputStream input;
	static PrintStream print;
	static Socket read = null;
       
	public static void CloseServer()
	{
		try
		{
			Server.close();
		}
		catch (IOException e) 
        {
	       System.out.println(e);
	    }
	}
	
	public static void CreateServer()
	{
		try 
        {
           Server = new ServerSocket(8000);
        }
        catch (IOException e) 
        {
           System.out.println(e);
        }
	}
	
	public static boolean getTestConnection()
	{
		try
		{
			Test = new ServerSocket(8000);
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
		
		try
		{
			socketTest = Test.accept();
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
		
		try 
		{
			testIn = new DataInputStream(socketTest.getInputStream());
		} 
		catch (IOException e) 
		{
			System.err.println(e);
		}
		
		String s = "";
		try 
		{
			s = testIn.readUTF();
		} 
		catch (IOException e) 
		{
			System.err.println(e);
		}
		if(s == "TEST")
		{
			return true;
		}
		return false;
	}
	
	public static String getIPAddress()
	{
		URL whatismyip = null;
		BufferedReader in = null;
		String ip = null;
		try 
		{
			whatismyip = new URL("http://checkip.amazonaws.com");
		} 
		catch (MalformedURLException e) 
		{
			System.err.println(e);
		}
		try 
		{
			in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
		}
		catch (IOException e) 
		{
			System.err.println(e);
		}

		try 
		{
			ip = in.readLine();
		} 
		catch (IOException e) 
		{
			System.err.println(e);
		}
		return ip;
	}
	
	public static instructionPacket Listen()
	{
		try 
	    {
	       read = Server.accept();
	       input = new ObjectInputStream(read.getInputStream());
	    }   
	    catch (IOException e) 
	    {
	    	System.out.println(e);
	    }
		instructionPacket packet = null;
		try 
		{
			packet = (instructionPacket) input.readObject();
		} 
		catch (IOException e) 
		{
			System.err.println(e);
		} 
		catch (ClassNotFoundException e) 
		{
			System.err.println(e);
		}
		return packet;
	}
}