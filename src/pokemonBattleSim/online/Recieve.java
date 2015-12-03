package pokemonBattleSim.online;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import pokemonBattleSim.types.*;

public class Recieve 
{
	static Socket read = null;
	static ObjectInputStream input;
	static String line;
	static PrintStream print;
	public static String IP = null;
	
	public static void closeObjectStream()
	{
		try
		{
			input.close();
		}
		catch (IOException e) 
        {
	       System.out.println(e);
	    }
	}
	
	public static void closeSocket(Socket Server)
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

	public static Socket createSocket(String IP)
	{
		Socket Server = null;
		try 
        {
           Server = new Socket(IP, 6943);
        }
        catch (IOException e) 
        {
           System.out.println(e);
        }
		return Server;
	}
	
	public static void CloseServer(ServerSocket Server)
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

	public static ServerSocket CreateServer() throws IOException
	{
		return new ServerSocket(6943);
	}
	
	/*
	 * Receive a test connection, Listens for a new incoming packet, accepts it
	 * if it's a first incoming test, sends a reply handshake
	 * if it's a handshake, returns valid to start interactions.
	 */
	public static String getTestConnection(ServerSocket Test, Socket read) throws IOException, ClassNotFoundException
	{
		try
		{
			while(read == null)
			read = Test.accept();
			Test.close();
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
		DataInputStream inpu=null;
		try 
		{
			inpu = new DataInputStream(read.getInputStream());
		} 
		catch (IOException e) 
		{
			System.err.println(e);
		}
		
		String s = null;
		try 
		{
			s = (String)inpu.readUTF();
			closeObjectStream();
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
		if(s.equals("TEST"))
		{
			Send.testConnectionHandshake(IP = Test.getInetAddress().getHostAddress());
			System.out.println("Test 1 Valid");
			return "Test 1 Valid";
		}
		else if(s.equals("TEST1"))
		{
			System.out.println("HandShake Complete");
			return "HandShake Complete";
		}
		System.out.println("Inconclusive");
		return "Inconclusive";
	}
	
	/*
	 * Retrieve IP Address from webiste to display on hosting page
	 */
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
	
	/*
	 * Listen for a connection and return the packet.
	 */
	public static instructionPacket Listen(ServerSocket Server, Socket read)
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
			closeObjectStream();
			read.close();
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