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
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import pokemonBattleSim.musicPlayer.AudioPlayer;
import pokemonBattleSim.online.Send;

import java.awt.Font;

public class MainMenu extends JFrame {
	private JFrame frmPokemonBattleSim;

	/**
	 * Launch the application.
	 */
	public static void startup() {
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
	public void StartMainMusic()
	{
	new Thread() {
		@Override
		public void run() {
			AudioPlayer player = new AudioPlayer();
	        String resource;
	        resource = this.getClass().getResource("/pokemonBattleSim/resources/soundtrack/JohtoRoute47.wav").getFile();
			System.out.println(resource);
			player.play(resource);
		}
	}.start();
	}
	
	private void initialize() {
		
		frmPokemonBattleSim = new JFrame();
		frmPokemonBattleSim.setTitle("Pok\u00E9mon Rush");
		frmPokemonBattleSim.setBounds(100, 100, 399, 522);
		frmPokemonBattleSim.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokemonBattleSim.getContentPane().setLayout(null);
		if(AudioPlayer.musicBool == 0)
		{
			StartMainMusic();
			AudioPlayer.musicBool = 1;
		}
		JButton btnNewButton_1 = new JButton("Stop Music");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if (AudioPlayer.musicBool == 1)
			{
				AudioPlayer.stopper = 1;
				System.out.println("Playback forcefully stopped.");
				btnNewButton_1.setText("Restart Music");
				AudioPlayer.musicBool = 0;
			}
			else
			{
				AudioPlayer.stopper = 0;
				AudioPlayer.musicBool = 1;
				btnNewButton_1.setText("Stop Music");
				StartMainMusic();		
			}	
		}
		});
		btnNewButton_1.setBounds(86, 11, 204, 23);
		frmPokemonBattleSim.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Play VS AI");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				AudioPlayer.stopper = 1;
				try {
					Thread.sleep(500);
				}catch (InterruptedException f){
					f.printStackTrace();
				}
				System.out.println("Playback forcefully stopped.");
				btnNewButton_1.setText("Restart Music");
				AudioPlayer.musicBool = 0;
				Send.Online = false;
				TeamBuilderView.startTeam();
				frmPokemonBattleSim.setVisible(false);
			}
		});
		btnNewButton.setBounds(86, 100, 204, 65);
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
		btnNewButton_2.setBounds(86, 176, 204, 65);
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
		btnNewButton_3.setBounds(86, 252, 204, 65);
		frmPokemonBattleSim.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Credits");
		btnNewButton_4.setBounds(86, 406, 204, 65);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Credits ncrd = new Credits();
				ncrd.NewCredits();
				frmPokemonBattleSim.setVisible(false);
			}
		});
		btnNewButton_4.setIcon(null);
		frmPokemonBattleSim.getContentPane().add(btnNewButton_4);
		
		JLabel lblPokemonBattleSim = new JLabel("Pok\u00E9mon Rush");
		lblPokemonBattleSim.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPokemonBattleSim.setBounds(86, 45, 287, 37);
		frmPokemonBattleSim.getContentPane().add(lblPokemonBattleSim);
		
		JButton btnHowToPlay = new JButton("How To Play");
		btnHowToPlay.setBounds(86, 329, 204, 65);
		btnHowToPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HowToPlay htp = new HowToPlay();
				htp.NewHTP();
				frmPokemonBattleSim.setVisible(false);
			}
		});
		frmPokemonBattleSim.getContentPane().add(btnHowToPlay);
	}
}
