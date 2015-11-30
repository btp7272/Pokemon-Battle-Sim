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
	static ObjectInputStream testIn = null;
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
           Server = new ServerSocket(6943);
        }
        catch (IOException e) 
        {
           System.out.println(e);
        }
	}
	
	public static String getTestConnection() throws IOException, ClassNotFoundException
	{
		try
		{
			Test = new ServerSocket(6943);
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
			testIn = new ObjectInputStream(socketTest.getInputStream());
		} 
		catch (IOException e) 
		{
			System.err.println(e);
		}
		
		instructionPacket s = null;
		try 
		{
			s = (instructionPacket)testIn.readObject();
		} 
		catch (IOException e) 
		{
			System.err.println(e);
		}
		if(s.getInstruction().equals("TEST"))
		{
			Send.testConnectionHandshake(Test.getInetAddress().getHostAddress());
			return "Test 1 Valid";
		}
		else if(s.getInstruction().equals("Test1"))
		{
			return "HandShake Complete";
		}
		return "Inconclusive";
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