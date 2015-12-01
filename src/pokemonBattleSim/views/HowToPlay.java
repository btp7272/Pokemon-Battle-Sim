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
import javax.swing.JScrollPane;
import java.awt.TextArea;

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
		HTP.setBounds(100, 100, 709, 750);
		HTP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HTP.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu.startup();
				HTP.setVisible(false);
			}
		});
		btnNewButton.setBounds(614, 699, 89, 23);
		HTP.getContentPane().add(btnNewButton);
		
		JLabel lblBuildingYour = new JLabel("Building Your Team");
		lblBuildingYour.setBounds(25, 19, 122, 16);
		HTP.getContentPane().add(lblBuildingYour);
		
		TextArea textArea = new TextArea();
		textArea.setText("When you are about to start a game, a window called a Team Builder will pop up. \nIn the team builder you will be able to construct the team of 6 Pokemon that you \nwill bring into the battle. Use the drop down boxes and text boxes to\nselect and customize your Pokemon. When you have finised your team, \nclick the \"Finalize\" button in the bottom right corner.\n\nNote: \nYou can only select from moves, items, and abilities that have been implemented\nYou cannot have two or more of the same Pokemon on your team \nA Pokemon cannot have two of the same move\nMega Evolution is yet to be implemented, though all mega evolutions are accessable\nCorrectness of moves is not checked for. i.e.: for now any Pokemon can learn any move\nA Pokemon with multiple forms may not have a model accompanied with it\n");
		textArea.setEditable(false);
		textArea.setBounds(10, 41, 544, 179);
		HTP.getContentPane().add(textArea);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setText("Pokemon Rush is played in real time. Unlike the turn-based format in the \nmain-series games, a Pokemon can attack whenever it is not already performing an \naction. In order to register an attack or switch, simply press one of the labeled buttons \non the lower half of your screen during a battle. If you want to register a series of \nactions,");
		textArea_1.setEditable(false);
		textArea_1.setBounds(10, 248, 544, 179);
		HTP.getContentPane().add(textArea_1);
		
		JLabel lblGamePlayattacking = new JLabel("Game Play (Attacking and Switching)");
		lblGamePlayattacking.setBounds(25, 226, 320, 16);
		HTP.getContentPane().add(lblGamePlayattacking);
	}
}
