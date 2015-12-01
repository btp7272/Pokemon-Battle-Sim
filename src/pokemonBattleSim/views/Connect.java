package pokemonBattleSim.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import pokemonBattleSim.online.*;

public class Connect {

	private JFrame frmConnect;
	public static JTextField IPAddress;
	private JButton btnNewButton;
	private JButton btnCancel;
	private JButton btnBuildYourTeam;
	private JLabel lblConnectionSuccessful;

	/**
	 * Launch the application.
	 */
	public void NewConnection() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connect window = new Connect();
					window.frmConnect.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Connect() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConnect = new JFrame();
		frmConnect.setTitle("Connect");
		frmConnect.setBounds(100, 100, 506, 137);
		frmConnect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{118, 147, 124, 65, 0};
		gridBagLayout.rowHeights = new int[]{38, 23, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmConnect.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblHostIpAddress = new JLabel("  Host IP Address");
		lblHostIpAddress.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblHostIpAddress = new GridBagConstraints();
		gbc_lblHostIpAddress.anchor = GridBagConstraints.WEST;
		gbc_lblHostIpAddress.fill = GridBagConstraints.VERTICAL;
		gbc_lblHostIpAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblHostIpAddress.gridx = 0;
		gbc_lblHostIpAddress.gridy = 1;
		frmConnect.getContentPane().add(lblHostIpAddress, gbc_lblHostIpAddress);
		
		IPAddress = new JTextField();
		GridBagConstraints gbc_IPAddress = new GridBagConstraints();
		gbc_IPAddress.fill = GridBagConstraints.BOTH;
		gbc_IPAddress.insets = new Insets(0, 0, 5, 5);
		gbc_IPAddress.gridx = 1;
		gbc_IPAddress.gridy = 1;
		frmConnect.getContentPane().add(IPAddress, gbc_IPAddress);
		IPAddress.setColumns(10);
		
		btnNewButton = new JButton("Connect to Host");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					Send.IPAddress = IPAddress.getText();
					Send.testConnection(IPAddress.getText());
					ServerSocket server = Recieve.CreateServer();
					Timer timer = new Timer();
					Socket socket = Recieve.createSocket(IPAddress.getText());
				    class SetTimer extends TimerTask
				    {
				 	    @Override
				 	    public void run()
				 	    {
				 	    	while(true)
				 	    	{
					 		    try 
					 		    {
									if(Recieve.getTestConnection(server,socket).equals("HandShake Complete"))
									{
										btnBuildYourTeam.setVisible(true);
										lblConnectionSuccessful.setVisible(true);
										server.close();
										socket.close();
										break;
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
				    }
				    TimerTask task = new SetTimer();
				    timer.schedule(task, 0, 5);
					
				} 
				catch (IOException e) 
				{
					System.err.println(e);
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 1;
		frmConnect.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu.startup();
				frmConnect.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 0);
		gbc_btnCancel.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCancel.gridx = 3;
		gbc_btnCancel.gridy = 1;
		frmConnect.getContentPane().add(btnCancel, gbc_btnCancel);
		
		btnBuildYourTeam = new JButton("Build your team");
		btnBuildYourTeam.setVisible(false);
		btnBuildYourTeam.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				TeamBuilderView.startTeam();
			}
		});
		
		lblConnectionSuccessful = new JLabel("Connection Successful!");
		lblConnectionSuccessful.setVisible(false);
		GridBagConstraints gbc_lblConnectionSuccessful = new GridBagConstraints();
		gbc_lblConnectionSuccessful.anchor = GridBagConstraints.EAST;
		gbc_lblConnectionSuccessful.insets = new Insets(0, 0, 0, 5);
		gbc_lblConnectionSuccessful.gridx = 1;
		gbc_lblConnectionSuccessful.gridy = 2;
		frmConnect.getContentPane().add(lblConnectionSuccessful, gbc_lblConnectionSuccessful);
	    
		GridBagConstraints gbc_btnBuildYourTeam = new GridBagConstraints();
		gbc_btnBuildYourTeam.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuildYourTeam.gridx = 2;
		gbc_btnBuildYourTeam.gridy = 2;
		frmConnect.getContentPane().add(btnBuildYourTeam, gbc_btnBuildYourTeam);
	}

}
