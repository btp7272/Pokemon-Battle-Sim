package pokemonBattleSim.online;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import pokemonBattleSim.types.*;
import pokemonBattleSim.models.*;

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
	
	public void Listen()
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
		String s = null;
		try 
		{
			s = (String) input.readObject();
		} 
		catch (IOException e) 
		{
			System.err.println(e);
		} 
		catch (ClassNotFoundException e) 
		{
			System.err.println(e);
		}
		
		switch(s){
			case "Pokemon":
				recievePokemon();
				break;
			case "Team":
				recieveTeam();
				break;
			case "Move":
				recieveMove();
				break;
			case "Game Over":
				recieveGameOver();
				break;
		}
	}
	
	public Pokemon recievePokemon()
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
		} 
		catch (ClassNotFoundException e) 
		{
			System.err.println(e);
		}
		return p;
	}
	
	public ArrayList<Pokemon> recieveTeam()
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
		ArrayList<Pokemon> team = null;
		try 
		{
			team = (ArrayList<Pokemon>) input.readObject();
		} 
		catch (IOException e) 
		{
			System.err.println(e);
		} 
		catch (ClassNotFoundException e) 
		{
			System.err.println(e);
		}
		return team;
	}
	
	public Move recieveMove()
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
		Move m = null;
		try 
		{
			m = (Move) input.readObject();
		} 
		catch (IOException e) 
		{
			System.err.println(e);
		} 
		catch (ClassNotFoundException e) 
		{
			System.err.println(e);
		}
		return m;
	}
	
	public boolean recieveGameOver()
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
		boolean b = false;
		try 
		{
			b = (boolean) input.readObject();
		} 
		catch (IOException e) 
		{
			System.err.println(e);
		} 
		catch (ClassNotFoundException e) 
		{
			System.err.println(e);
		}
		return b;
	}
}