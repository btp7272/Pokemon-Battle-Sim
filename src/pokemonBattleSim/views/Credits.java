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
	private JTextField txtTwittercomjoeypokeaim;
	private JTextField txtTwittercomglitchxcity;
	private JTextField txtTwittercommv;
	private JTextField txtTwittercomsirskaro;
	private JTextField txtPokemonrushfeedbackgmailcom;

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
		Credits.setTitle("Pokémon Rush");
		Credits.setBounds(100, 100, 520, 560);
		Credits.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Credits.getContentPane().setLayout(null);
		
		JLabel lblCredits = new JLabel("Credits");
		lblCredits.setBounds(204, 6, 71, 25);
		lblCredits.setFont(new Font("Tahoma", Font.BOLD, 20));
		Credits.getContentPane().add(lblCredits);
		
		JLabel lblNewLabel = new JLabel("Shane Alvarez");
		lblNewLabel.setBounds(10, 35, 123, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Credits.getContentPane().add(lblNewLabel);
		
		JLabel lblBenjaminChurchill = new JLabel("Benjamin Churchill");
		lblBenjaminChurchill.setBounds(126, 35, 171, 19);
		lblBenjaminChurchill.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Credits.getContentPane().add(lblBenjaminChurchill);
		
		JLabel lblBryanPowell = new JLabel("Bryan Powell");
		lblBryanPowell.setBounds(10, 108, 102, 19);
		lblBryanPowell.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Credits.getContentPane().add(lblBryanPowell);
		
		JLabel lblNewLabel_1 = new JLabel("Jacob Valdez");
		lblNewLabel_1.setBounds(125, 108, 150, 19);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Credits.getContentPane().add(lblNewLabel_1);
		
		JLabel lblSpecialThanks = new JLabel("Special Thanks");
		lblSpecialThanks.setBounds(207, 183, 133, 15);
		lblSpecialThanks.setFont(new Font("Tahoma", Font.BOLD, 12));
		Credits.getContentPane().add(lblSpecialThanks);
		
		JTextField lblBulbapediabulbagardennet = new JTextField("bulbapedia.bulbagarden.net/wiki/Main_Page");
		lblBulbapediabulbagardennet.setEditable(false);
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
		btnNewButton.setBounds(89, 465, 89, 23);
		Credits.getContentPane().add(btnNewButton);
		
		txtHttpswwwyoutubecomuserglitchxcity = new JTextField();
		txtHttpswwwyoutubecomuserglitchxcity.setEditable(false);
		txtHttpswwwyoutubecomuserglitchxcity.setHorizontalAlignment(SwingConstants.CENTER);
		txtHttpswwwyoutubecomuserglitchxcity.setText("youtube.com/user/GlitchxCity");
		txtHttpswwwyoutubecomuserglitchxcity.setBounds(274, 260, 243, 25);
		Credits.getContentPane().add(txtHttpswwwyoutubecomuserglitchxcity);
		txtHttpswwwyoutubecomuserglitchxcity.setColumns(10);
		
		txtHttpswwwyoutubecomuserpokeaimmd = new JTextField();
		txtHttpswwwyoutubecomuserpokeaimmd.setEditable(false);
		txtHttpswwwyoutubecomuserpokeaimmd.setHorizontalAlignment(SwingConstants.CENTER);
		txtHttpswwwyoutubecomuserpokeaimmd.setText("youtube.com/user/pokeaimMD");
		txtHttpswwwyoutubecomuserpokeaimmd.setBounds(274, 373, 243, 25);
		Credits.getContentPane().add(txtHttpswwwyoutubecomuserpokeaimmd);
		txtHttpswwwyoutubecomuserpokeaimmd.setColumns(10);
		
		txtHttpswwwyoutubecomusermv = new JTextField();
		txtHttpswwwyoutubecomusermv.setEditable(false);
		txtHttpswwwyoutubecomusermv.setHorizontalAlignment(SwingConstants.CENTER);
		txtHttpswwwyoutubecomusermv.setText("youtube.com/user/3MV33");
		txtHttpswwwyoutubecomusermv.setBounds(274, 462, 243, 25);
		Credits.getContentPane().add(txtHttpswwwyoutubecomusermv);
		txtHttpswwwyoutubecomusermv.setColumns(10);
		
		txtHttpwwwpkparaisocom = new JTextField();
		txtHttpwwwpkparaisocom.setEditable(false);
		txtHttpwwwpkparaisocom.setHorizontalAlignment(SwingConstants.CENTER);
		txtHttpwwwpkparaisocom.setText("pkparaiso.com");
		txtHttpwwwpkparaisocom.setBounds(10, 404, 243, 25);
		Credits.getContentPane().add(txtHttpwwwpkparaisocom);
		txtHttpwwwpkparaisocom.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pok\u00E9mon Models:");
		lblNewLabel_2.setBounds(78, 352, 175, 14);
		Credits.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gameplay Input:");
		lblNewLabel_3.setToolTipText("");
		lblNewLabel_3.setBounds(340, 323, 102, 14);
		Credits.getContentPane().add(lblNewLabel_3);
		
		JLabel lblMusic = new JLabel("Music:");
		lblMusic.setBounds(371, 210, 102, 14);
		Credits.getContentPane().add(lblMusic);
		
		JLabel lblMechanicsInformation = new JLabel("Battle Mechanics Information:");
		lblMechanicsInformation.setBounds(53, 210, 188, 14);
		Credits.getContentPane().add(lblMechanicsInformation);
		
		JLabel lblPkparaisocom = new JLabel("pkparaiso.com");
		lblPkparaisocom.setBounds(10, 378, 123, 14);
		Credits.getContentPane().add(lblPkparaisocom);
		
		JLabel lblmv = new JLabel("3MV33");
		lblmv.setBounds(274, 436, 123, 14);
		Credits.getContentPane().add(lblmv);
		
		JLabel lblPokeaimmd = new JLabel("PokeaimMD");
		lblPokeaimmd.setBounds(274, 349, 123, 14);
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
		txtAsdffdsa.setEditable(false);
		txtAsdffdsa.setHorizontalAlignment(SwingConstants.CENTER);
		txtAsdffdsa.setText("smogon.com");
		txtAsdffdsa.setBounds(10, 315, 243, 25);
		Credits.getContentPane().add(txtAsdffdsa);
		txtAsdffdsa.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("This is a non-profit fan-made game.");
		lblNewLabel_6.setBounds(274, 38, 270, 14);
		Credits.getContentPane().add(lblNewLabel_6);
		
		JLabel lblAsdf = new JLabel("Intelectual property of ");
		lblAsdf.setBounds(274, 63, 270, 14);
		Credits.getContentPane().add(lblAsdf);
		
		JLabel lblNewLabel_7 = new JLabel("Pok\u00E9mon\u2122 is owned by Nintendo,");
		lblNewLabel_7.setBounds(274, 87, 270, 14);
		Credits.getContentPane().add(lblNewLabel_7);
		
		JLabel lblPleaseSupportThe = new JLabel("Game Freak, and Creatures Inc.");
		lblPleaseSupportThe.setBounds(274, 111, 270, 14);
		Credits.getContentPane().add(lblPleaseSupportThe);
		
		JLabel lblNewLabel_8 = new JLabel("Please support the officail release.");
		lblNewLabel_8.setBounds(274, 135, 270, 14);
		Credits.getContentPane().add(lblNewLabel_8);
		
		txtTwittercomjoeypokeaim = new JTextField();
		txtTwittercomjoeypokeaim.setText("twitter.com/JoeyPokeaim");
		txtTwittercomjoeypokeaim.setHorizontalAlignment(SwingConstants.CENTER);
		txtTwittercomjoeypokeaim.setEditable(false);
		txtTwittercomjoeypokeaim.setColumns(10);
		txtTwittercomjoeypokeaim.setBounds(274, 399, 243, 25);
		Credits.getContentPane().add(txtTwittercomjoeypokeaim);
		
		txtTwittercomglitchxcity = new JTextField();
		txtTwittercomglitchxcity.setText("twitter.com/GlitchxCity");
		txtTwittercomglitchxcity.setHorizontalAlignment(SwingConstants.CENTER);
		txtTwittercomglitchxcity.setEditable(false);
		txtTwittercomglitchxcity.setColumns(10);
		txtTwittercomglitchxcity.setBounds(274, 286, 243, 25);
		Credits.getContentPane().add(txtTwittercomglitchxcity);
		
		txtTwittercommv = new JTextField();
		txtTwittercommv.setText("twitter.com/3MV33");
		txtTwittercommv.setHorizontalAlignment(SwingConstants.CENTER);
		txtTwittercommv.setEditable(false);
		txtTwittercommv.setColumns(10);
		txtTwittercommv.setBounds(274, 485, 243, 25);
		Credits.getContentPane().add(txtTwittercommv);
		
		txtTwittercomsirskaro = new JTextField();
		txtTwittercomsirskaro.setText("twitter.com/SirSkaro");
		txtTwittercomsirskaro.setHorizontalAlignment(SwingConstants.CENTER);
		txtTwittercomsirskaro.setEditable(false);
		txtTwittercomsirskaro.setColumns(10);
		txtTwittercomsirskaro.setBounds(124, 57, 141, 25);
		Credits.getContentPane().add(txtTwittercomsirskaro);
		
		JLabel lblFeedback = new JLabel("Feedback");
		lblFeedback.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFeedback.setBounds(103, 139, 111, 15);
		Credits.getContentPane().add(lblFeedback);
		
		txtPokemonrushfeedbackgmailcom = new JTextField();
		txtPokemonrushfeedbackgmailcom.setText("pokemonrushfeedback@gmail.com");
		txtPokemonrushfeedbackgmailcom.setHorizontalAlignment(SwingConstants.CENTER);
		txtPokemonrushfeedbackgmailcom.setEditable(false);
		txtPokemonrushfeedbackgmailcom.setColumns(10);
		txtPokemonrushfeedbackgmailcom.setBounds(6, 152, 247, 25);
		Credits.getContentPane().add(txtPokemonrushfeedbackgmailcom);
	}
}
