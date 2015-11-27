package pokemonBattleSim.online;
import java.io.*;
import java.net.*;

public class Recieve 
{
	ServerSocket Server = null;
	String line;
	DataInputStream input;
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
	
	public boolean recieveConnection()
	{
		
		return false;
	}
	
	public static boolean getTestConnection()
	{
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
	
	public void listen()
	{
		try 
	    {
	       read = Server.accept();
	       input = new DataInputStream(read.getInputStream());
	       print = new PrintStream(read.getOutputStream());
	
	       while (true) {
	         line = input.readLine();
	         print.println(line); 
	       }
	    }   
	    catch (IOException e) 
	    {
	    	System.out.println(e);
	    }
	}
}