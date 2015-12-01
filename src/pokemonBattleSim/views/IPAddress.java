package pokemonBattleSim.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import pokemonBattleSim.online.*;
import pokemonBattleSim.types.IPokemon;

import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class IPAddress {

	private JFrame frmHello;

	/**
	 * Launch the application.
	 */
	public void NewAddress() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IPAddress window = new IPAddress();
					window.frmHello.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IPAddress() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHello = new JFrame();
		frmHello.setTitle("Pokémon Rush");
		frmHello.setBounds(100, 100, 313, 141);
		frmHello.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHello.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your IP Address: "+Recieve.getIPAddress());
		lblNewLabel.setBounds(63, 11, 218, 37);
		frmHello.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				MainMenu.startup();
				frmHello.setVisible(false);
			}
		});
		btnNewButton.setBounds(192, 59, 89, 23);
		frmHello.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Waiting for connection...");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				TeamBuilderView.startTeam();
			}
		});
		Socket socket = Recieve.createSocket(Recieve.IP);
		Timer timer = new Timer();
	    class SetTimer extends TimerTask
	    {
	 	    @Override
	 	    public void run()
	 	    {
	 		    try 
	 		    {
					if(Recieve.getTestConnection(socket).equals("Test 1 Valid"))
					{
						btnNewButton_1.setText("Connection Recieved!");
						btnNewButton_1.setEnabled(true);
						socket.close();
					}
				} 
	 		    catch (ClassNotFoundException e) 
	 		    {
					System.err.println(e);
				} 
	 		    catch (IOException e) 
	 		    {
					System.err.println(e);
				}
	 	    }
	    }
	    TimerTask task = new SetTimer();
	    timer.schedule(task, 100, 1000);
	    
		btnNewButton_1.setBounds(10, 59, 172, 23);
		frmHello.getContentPane().add(btnNewButton_1);
	}
}
