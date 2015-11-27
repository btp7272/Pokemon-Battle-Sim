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