package pokemonBattleSim.online;
import pokemonBattleSim.types.*;
import pokemonBattleSim.views.Connect;
import pokemonBattleSim.online.Recieve;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Send 
{  
    public static boolean Online = false;
    static Socket sock;
    public static String IPAddress;
    
	public static Socket createSocket(String ip)
	{
		try 
		{
            sock = new Socket(ip, 6943);
        } 
		catch (UnknownHostException e) 
		{
            System.err.println("Don't know about host: opponent");
        } 
		catch (IOException e) 
		{
            System.err.println("Couldn't get I/O for the connection to: opponent");
        }
		return sock;
	}
	
	public static void testConnection(String IP) throws IOException
	{
		Recieve.IP = IP;
		Socket socket = createSocket(IP);
		instructionPacket s = new instructionPacket(IP,"TEST",null);
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(s);
		out.flush();
		out.close();
		socket.close();
	}
	
	public static void testConnectionHandshake(String IP) throws IOException
	{
		Recieve.IP = IP;
		Socket socket = createSocket(IP);
		instructionPacket s = new instructionPacket(IP,"TEST1",null);
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(s);
		out.flush();
		out.close();
		socket.close();
	}
	
	public static void sendPacket(String IP, String s, Object o) throws IOException
	{
		Socket socket = createSocket(IP);
		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
		instructionPacket packet = new instructionPacket(IP,s,o);
		try
		{
			out.writeObject(packet);
			out.flush();
			out.close();
			socket.close();
		}
		catch (IOException e) 
		{
			System.err.println(e);
		}
	}
	public static String getIPAddress()
	{
		return IPAddress;
	}
}
