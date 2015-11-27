package pokemonBattleSim.models;

import java.io.*;
import java.net.*;

public class Send {
	Socket opponent = null;  
    DataOutputStream output = null;
    
	public Socket createSocket()
	{
		try {
            opponent = new Socket("opponent", 8000);
            output = new DataOutputStream(opponent.getOutputStream());
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: opponent");
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: opponent");
        }
		return opponent;
	}
	
	public void sendBytes(String s)
	{
		if (opponent!= null && output != null)
		{
			try	
			{
				output.writeBytes(s);
				output.writeBytes("END");
				output.close();
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
