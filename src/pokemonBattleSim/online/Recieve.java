package pokemonBattleSim.online;
import java.io.*;
import java.net.*;
import pokemonBattleSim.types.*;

public class Recieve 
{
	ServerSocket Server = null;
	static ServerSocket Test = null;
	static Socket socketTest = null;
	static DataInputStream testIn = null;
	String line;
	ObjectInputStream input;
	PrintStream print;
	Socket read = null;
       
	public void CreateServer()
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
			s = testIn.readLine();
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
	
	public String getIPAddress()
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
	
	public Pokemon listen()
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
		Pokemon p = null;
		try 
		{
			p = (Pokemon) input.readObject();
		} 
		catch (IOException e) 
		{
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
		return p;
	}
}