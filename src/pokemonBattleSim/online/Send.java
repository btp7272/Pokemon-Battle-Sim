package pokemonBattleSim.online;
import pokemonBattleSim.types.*;
import pokemonBattleSim.views.Connect;
import pokemonBattleSim.online.Recieve;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Send implements Serializable
{  
    public static boolean Online = false;
    static Socket sock;
    public static String IPAddress;
    
	public static Socket createSocket(String ip)
	{
		byte [] b = ip.getBytes();
		try 
		{
            sock = new Socket(InetAddress.getByName(ip), 6943);
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
		String s = "TEST";
		System.out.println("Online Test 1");
		//instructionPacket s = new instructionPacket(IP,"TEST",null);
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeBytes(s);
		out.flush();
		out.close();
		socket.close();
	}
	
	public static void testConnectionHandshake(String IP) throws IOException
	{
		Recieve.IP = IP;
		Socket socket = createSocket(IP);
		String s = "TEST1";
		System.out.println("Online Handshake");
		//instructionPacket s = new instructionPacket(IP,"TEST1",null);
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeBytes(s);;
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
