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
		byte [] b = IP.getBytes();
		Socket Server = null;
		try 
        {
           Server = new Socket(InetAddress.getByAddress(b), 6943);
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

	public static ServerSocket CreateServer()
	{
		ServerSocket Server = null;
		try 
        {
           Server = new ServerSocket(6943);
        }
        catch (IOException e) 
        {
           System.out.println(e);
        }
		return Server;
	}
	
	public static String getTestConnection(Socket read) throws IOException, ClassNotFoundException
	{
		ServerSocket Test = Recieve.CreateServer();
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