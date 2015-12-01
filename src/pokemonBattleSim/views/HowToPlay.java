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
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		HTP.setTitle("Pokémon Rush");
		HTP.setBounds(100, 100, 620, 508);
		HTP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu.startup();
				HTP.setVisible(false);
			}
		});
		
		JTextPane txtpnHe = new JTextPane();
		txtpnHe.setText("To begin a game against the computer, press the \"Play VS AI\" button. "+
		"This will open up the Team Builder, where you can select your team of six Pok\u00E9mon.\n\n"+
		"You can give each Pok\u00E9mon four moves, one ability, and one held item per team member.\n\n"+
		"Be careful, you cannot have any of the same two pokemon on your team, and no pokemon can learn the same move twice.\n\n"+
		"After this, you have the option of changing your Individual Values and Effort Values, which are used when determining stats. The most common setup is already input by default.\n\n"+
		"In addition, you have the options to choose each team member's nature and gender, and you can choose between level 50 or 100.\n\n"+
		"\tWhen you are finished, press the \"Finalize\" button to begin your game.\n\n\n"+
		"If you are going to host an online game, press the \"Host Online\" button. This will display your IP Address for another player to connect, and wait for a connection.\n"+
		"If you are going to connect to an online game, press the \"Connect Online\" button, and type in the IP Address retrieved by the Hosting page from another player, and press \"Connect to Host.\"\n\n"+
		"\t   After your game finishes, you will be returned to the main menu.\n\n\n"+
		"Don't forget to view our Credits page where you can find the sources for all of our information and music!");
		GroupLayout groupLayout = new GroupLayout(HTP.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnHe, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtpnHe, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
		);
		HTP.getContentPane().setLayout(groupLayout);
	}
}
