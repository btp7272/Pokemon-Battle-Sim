package pokemonBattleSim.online;

import pokemonBattleSim.online.Recieve;
import java.io.*;
import java.net.*;

public class Send 
{
	Socket opponent = null;  
    ObjectOutputStream out = null;
    DataOutputStream test = null;
    Socket testSocket = null;
    Socket socket = null;
    
	public Socket createSocket()
	{
		try {
            opponent = new Socket("opponent", 8000);
            out = new ObjectOutputStream(opponent.getOutputStream());
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: opponent");
        } catch (IOException e) {
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
			DataOutputStream test = new DataOutputStream(socket.getOutputStream());
		} 
		catch (IOException e) 
		{
			System.err.println(e);
		}
		test.writeBytes(s);
		test.flush();
		return Recieve.getTestConnection();
	}
	
	public void outBytes(String s)
	{
		if (opponent!= null && out != null)
		{
			try	
			{
				out.writeBytes(s);
				out.writeBytes("END");
				out.close();
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
}
