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

public class Credits {

	private JFrame Credits;

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
		Credits.setBounds(100, 100, 279, 312);
		Credits.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Credits.getContentPane().setLayout(null);
		
		JLabel lblCredits = new JLabel("Credits");
		lblCredits.setBounds(88, 28, 71, 25);
		lblCredits.setFont(new Font("Tahoma", Font.BOLD, 20));
		Credits.getContentPane().add(lblCredits);
		
		JLabel lblNewLabel = new JLabel("Shane Alvarez");
		lblNewLabel.setBounds(78, 58, 92, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Credits.getContentPane().add(lblNewLabel);
		
		JLabel lblBenjaminChurchill = new JLabel("Benjamin Churchill");
		lblBenjaminChurchill.setBounds(61, 82, 171, 19);
		lblBenjaminChurchill.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Credits.getContentPane().add(lblBenjaminChurchill);
		
		JLabel lblBryanPowell = new JLabel("Bryan Powell");
		lblBryanPowell.setBounds(83, 106, 81, 19);
		lblBryanPowell.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Credits.getContentPane().add(lblBryanPowell);
		
		JLabel lblNewLabel_1 = new JLabel("Jacob Valdez");
		lblNewLabel_1.setBounds(82, 130, 84, 19);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Credits.getContentPane().add(lblNewLabel_1);
		
		JLabel lblSpecialThanks = new JLabel("Special Thanks");
		lblSpecialThanks.setBounds(79, 184, 89, 15);
		lblSpecialThanks.setFont(new Font("Tahoma", Font.BOLD, 12));
		Credits.getContentPane().add(lblSpecialThanks);
		
		JLabel lblBulbapediabulbagardennet = new JLabel("bulbapedia.bulbagarden.net");
		lblBulbapediabulbagardennet.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBulbapediabulbagardennet.setBounds(56, 204, 186, 14);
		Credits.getContentPane().add(lblBulbapediabulbagardennet);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu.startup();
				Credits.setVisible(false);
			}
		});
		btnNewButton.setBounds(164, 239, 89, 23);
		Credits.getContentPane().add(btnNewButton);
	}
}
