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

public class HowToPlay 
{
	private JFrame HTP;
	
	/**
	 * Launch the application.
	 */
	public void NewHTP() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HowToPlay window = new HowToPlay();
					window.HTP.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HowToPlay() {
		initialize();
	}
	
	private void initialize() {
		HTP = new JFrame();
		HTP.setTitle("How To Play");
		HTP.setBounds(100, 100, 560, 450);
		HTP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HTP.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu.startup();
				HTP.setVisible(false);
			}
		});
		btnNewButton.setBounds(465, 399, 89, 23);
		HTP.getContentPane().add(btnNewButton);
	}
	
}
