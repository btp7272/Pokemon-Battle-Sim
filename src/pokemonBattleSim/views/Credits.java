package pokemonBattleSim.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Credits {

	private JFrame Credits;
	private JTextField txtHttpswwwyoutubecomuserglitchxcity;
	private JTextField txtHttpswwwyoutubecomuserpokeaimmd;
	private JTextField txtHttpswwwyoutubecomusermv;
	private JTextField txtHttpwwwpkparaisocom;
	private JTextField txtAsdffdsa;

	/**
	 * Launch the application.
	 */
	public void NewCredits() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Credits window = new Credits();
					window.Credits.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Credits() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Credits = new JFrame();
		Credits.setTitle("Credits");
		Credits.setBounds(100, 100, 560, 538);
		Credits.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Credits.getContentPane().setLayout(null);
		
		JLabel lblCredits = new JLabel("Credits");
		lblCredits.setBounds(92, 29, 71, 25);
		lblCredits.setFont(new Font("Tahoma", Font.BOLD, 20));
		Credits.getContentPane().add(lblCredits);
		
		JLabel lblNewLabel = new JLabel("Shane Alvarez");
		lblNewLabel.setBounds(82, 59, 123, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Credits.getContentPane().add(lblNewLabel);
		
		JLabel lblBenjaminChurchill = new JLabel("Benjamin Churchill");
		lblBenjaminChurchill.setBounds(65, 83, 171, 19);
		lblBenjaminChurchill.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Credits.getContentPane().add(lblBenjaminChurchill);
		
		JLabel lblBryanPowell = new JLabel("Bryan Powell");
		lblBryanPowell.setBounds(87, 107, 102, 19);
		lblBryanPowell.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Credits.getContentPane().add(lblBryanPowell);
		
		JLabel lblNewLabel_1 = new JLabel("Jacob Valdez");
		lblNewLabel_1.setBounds(86, 131, 150, 19);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Credits.getContentPane().add(lblNewLabel_1);
		
		JLabel lblSpecialThanks = new JLabel("Special Thanks");
		lblSpecialThanks.setBounds(81, 184, 133, 15);
		lblSpecialThanks.setFont(new Font("Tahoma", Font.BOLD, 12));
		Credits.getContentPane().add(lblSpecialThanks);
		
		JTextField lblBulbapediabulbagardennet = new JTextField("bulbapedia.bulbagarden.net/wiki/Main_Page");
		lblBulbapediabulbagardennet.setHorizontalAlignment(SwingConstants.CENTER);
		lblBulbapediabulbagardennet.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBulbapediabulbagardennet.setBounds(10, 260, 243, 25);
		Credits.getContentPane().add(lblBulbapediabulbagardennet);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu.startup();
				Credits.setVisible(false);
			}
		});
		btnNewButton.setBounds(445, 465, 89, 23);
		Credits.getContentPane().add(btnNewButton);
		
		txtHttpswwwyoutubecomuserglitchxcity = new JTextField();
		txtHttpswwwyoutubecomuserglitchxcity.setHorizontalAlignment(SwingConstants.CENTER);
		txtHttpswwwyoutubecomuserglitchxcity.setText("https://www.youtube.com/user/GlitchxCity");
		txtHttpswwwyoutubecomuserglitchxcity.setBounds(274, 260, 243, 25);
		Credits.getContentPane().add(txtHttpswwwyoutubecomuserglitchxcity);
		txtHttpswwwyoutubecomuserglitchxcity.setColumns(10);
		
		txtHttpswwwyoutubecomuserpokeaimmd = new JTextField();
		txtHttpswwwyoutubecomuserpokeaimmd.setHorizontalAlignment(SwingConstants.CENTER);
		txtHttpswwwyoutubecomuserpokeaimmd.setText("https://www.youtube.com/user/pokeaimMD");
		txtHttpswwwyoutubecomuserpokeaimmd.setBounds(274, 346, 243, 25);
		Credits.getContentPane().add(txtHttpswwwyoutubecomuserpokeaimmd);
		txtHttpswwwyoutubecomuserpokeaimmd.setColumns(10);
		
		txtHttpswwwyoutubecomusermv = new JTextField();
		txtHttpswwwyoutubecomusermv.setHorizontalAlignment(SwingConstants.CENTER);
		txtHttpswwwyoutubecomusermv.setText("https://www.youtube.com/user/3MV33");
		txtHttpswwwyoutubecomusermv.setBounds(274, 407, 243, 25);
		Credits.getContentPane().add(txtHttpswwwyoutubecomusermv);
		txtHttpswwwyoutubecomusermv.setColumns(10);
		
		txtHttpwwwpkparaisocom = new JTextField();
		txtHttpwwwpkparaisocom.setHorizontalAlignment(SwingConstants.CENTER);
		txtHttpwwwpkparaisocom.setText("http://www.pkparaiso.com/");
		txtHttpwwwpkparaisocom.setBounds(10, 400, 243, 25);
		Credits.getContentPane().add(txtHttpwwwpkparaisocom);
		txtHttpwwwpkparaisocom.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pok\u00E9mon Models:");
		lblNewLabel_2.setBounds(78, 350, 175, 14);
		Credits.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gameplay Input:");
		lblNewLabel_3.setToolTipText("");
		lblNewLabel_3.setBounds(340, 296, 102, 14);
		Credits.getContentPane().add(lblNewLabel_3);
		
		JLabel lblMusic = new JLabel("Music:");
		lblMusic.setBounds(371, 210, 102, 14);
		Credits.getContentPane().add(lblMusic);
		
		JLabel lblMechanicsInformation = new JLabel("Battle Mechanics Information:");
		lblMechanicsInformation.setBounds(53, 210, 188, 14);
		Credits.getContentPane().add(lblMechanicsInformation);
		
		JLabel lblPkparaisocom = new JLabel("pkparaiso.com");
		lblPkparaisocom.setBounds(10, 375, 123, 14);
		Credits.getContentPane().add(lblPkparaisocom);
		
		JLabel lblmv = new JLabel("3MV33");
		lblmv.setBounds(274, 382, 123, 14);
		Credits.getContentPane().add(lblmv);
		
		JLabel lblPokeaimmd = new JLabel("PokeaimMD");
		lblPokeaimmd.setBounds(274, 321, 123, 14);
		Credits.getContentPane().add(lblPokeaimmd);
		
		JLabel lblGlitchxcity = new JLabel("GlitchxCity");
		lblGlitchxcity.setBounds(274, 235, 102, 14);
		Credits.getContentPane().add(lblGlitchxcity);
		
		JLabel lblNewLabel_4 = new JLabel("Bulbapedia");
		lblNewLabel_4.setBounds(10, 235, 179, 14);
		Credits.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Smogon University");
		lblNewLabel_5.setBounds(10, 296, 153, 14);
		Credits.getContentPane().add(lblNewLabel_5);
		
		txtAsdffdsa = new JTextField();
		txtAsdffdsa.setHorizontalAlignment(SwingConstants.CENTER);
		txtAsdffdsa.setText("http://www.smogon.com/");
		txtAsdffdsa.setBounds(10, 314, 243, 25);
		Credits.getContentPane().add(txtAsdffdsa);
		txtAsdffdsa.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("This is a non-profit fan-made game.");
		lblNewLabel_6.setBounds(274, 38, 270, 14);
		Credits.getContentPane().add(lblNewLabel_6);
		
		JLabel lblAsdf = new JLabel("All intelectual properties are owned by");
		lblAsdf.setBounds(274, 63, 270, 14);
		Credits.getContentPane().add(lblAsdf);
		
		JLabel lblNewLabel_7 = new JLabel("Nintendo, Game Freak, and Creatures Inc.");
		lblNewLabel_7.setBounds(274, 87, 270, 14);
		Credits.getContentPane().add(lblNewLabel_7);
		
		JLabel lblPleaseSupportThe = new JLabel("Please support the officail release.");
		lblPleaseSupportThe.setBounds(274, 111, 270, 14);
		Credits.getContentPane().add(lblPleaseSupportThe);
	}
}
