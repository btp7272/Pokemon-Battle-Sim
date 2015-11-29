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
    DataOutputStream test = null;
    Socket testSocket = null;
    Socket socket = null;
    
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
	
	public static void sendData(String s, Object o)
	{
		switch(s){
		case "Pokemon":
			sendString("Pokemon");
			sendPokemon((Pokemon) o);
			break;
		case "Team":
			sendString("Team");
			sendTeam((ArrayList<Pokemon>) o);
			break;
		case "Move":
			sendString("Move");
			sendMove((Move) o);
			break;
		case "Game Over":
			sendString("Game Over");
			sendGameOver((boolean) o);
			break;
		case "String":
			sendString("String");
			sendString((String) o);
			break;
		}
	}
	
	public static void sendString(String s)
	{
		try 
		{
			out.writeBytes(s);
			out.flush();
		}
		catch (IOException e) 
		{
			System.err.println(e);
		}
	}
	
	public static void sendPokemon(Pokemon p)
	{
		try	
		{
			out.writeObject(p);
			out.writeBytes("END");
			out.flush();
		}
	    catch (UnknownHostException e) 
	    {
	    	System.err.println("Trying to connect to unknown host: " + e);
	    } 
	    catch (IOException e) 
	    {
	        System.err.println("IOException:  " + e);
	    }
	}
	
	public static void sendTeam(ArrayList<Pokemon> p)
	{
		try	
		{
			out.writeObject(p);
			out.writeBytes("END");
			out.flush();
		}
	    catch (UnknownHostException e) 
	    {
	    	System.err.println("Trying to connect to unknown host: " + e);
	    } 
	    catch (IOException e) 
	    {
	        System.err.println("IOException:  " + e);
	    }
	}
	
	public static void sendGameOver(Boolean b)
	{
		try	
		{
			out.writeObject(b);
			out.writeBytes("END");
			out.flush();
		}
	    catch (UnknownHostException e) 
	    {
	    	System.err.println("Trying to connect to unknown host: " + e);
	    } 
	    catch (IOException e) 
	    {
	        System.err.println("IOException:  " + e);
	    }
	}
	
	public static void sendMove(Move m)
	{
		try	
		{
			out.writeObject(m);
			out.writeBytes("END");
			out.flush();
		}
	    catch (UnknownHostException e) 
	    {
	    	System.err.println("Trying to connect to unknown host: " + e);
	    } 
	    catch (IOException e) 
	    {
	        System.err.println("IOException:  " + e);
	    }
	}
}
