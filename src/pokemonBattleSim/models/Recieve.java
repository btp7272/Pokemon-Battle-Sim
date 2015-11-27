package pokemonBattleSim.models;
import java.io.*;
import java.net.*;

public class Recieve {
	public void Listen(){
		ServerSocket Host;
	    try {
	       Host = new ServerSocket(8000);
	        }
	        catch (IOException e) {
	           System.out.println(e);
	        }
	}
}