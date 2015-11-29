package pokemonBattleSim.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import pokemonBattleSim.online.Send;

import java.awt.Font;

public class MainMenu {
	private JFrame frmPokemonBattleSim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frmPokemonBattleSim.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmPokemonBattleSim = new JFrame();
		frmPokemonBattleSim.setTitle("Pokemon Battle Sim");
		frmPokemonBattleSim.setBounds(100, 100, 399, 430);
		frmPokemonBattleSim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokemonBattleSim.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Play VS AI");
		btnNewButton.setBounds(86, 80, 204, 65);
		btnNewButton.setIcon(null);
		frmPokemonBattleSim.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Host Online");
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Send.Online = true;
				IPAddress na = new IPAddress();
				na.NewAddress();
				frmPokemonBattleSim.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(86, 156, 204, 65);
		btnNewButton_2.setIcon(null);
		frmPokemonBattleSim.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Connect Online");
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Send.Online = true;
				Connect nc = new Connect();
				nc.NewConnection();
				frmPokemonBattleSim.setVisible(false);
			}
		});
		btnNewButton_3.setIcon(null);
		btnNewButton_3.setBounds(86, 232, 204, 65);
		frmPokemonBattleSim.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Credits");
		btnNewButton_4.setBounds(86, 308, 204, 65);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_4.setIcon(null);
		frmPokemonBattleSim.getContentPane().add(btnNewButton_4);
		
		JLabel lblPokemonBattleSim = new JLabel("Pokemon Battle Sim");
		lblPokemonBattleSim.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPokemonBattleSim.setBounds(59, 25, 302, 37);
		frmPokemonBattleSim.getContentPane().add(lblPokemonBattleSim);
	}
}
