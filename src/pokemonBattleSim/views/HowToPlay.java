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

		HTP.setTitle("How To Play");
		HTP.setBounds(100, 100, 600, 799);

		HTP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu.startup();
				HTP.setVisible(false);
			}
		});
		HTP.getContentPane().setLayout(null);

		btnNewButton.setBounds(255, 705, 89, 23);
		HTP.getContentPane().add(btnNewButton);
		
		JLabel lblBuildingYour = new JLabel("Building Your Team");
		lblBuildingYour.setBounds(21, 23, 122, 16);
		HTP.getContentPane().add(lblBuildingYour);
		
		TextArea textArea = new TextArea();
		textArea.setText("When you are about to start a game, a window called a Team Builder will pop up.\r\nIn the team builder you will be able to construct the team of 6 Pok\u00E9mon that you\r\nwill bring into the battle. Use the drop down boxes and text boxes to\r\nselect and customize your Pok\u00E9mon. When you have finished your team, \r\nclick the \"Finalize\" button in the bottom right corner.\r\n\r\nNote: \r\nYou can only select from moves, items, and abilities that have been implemented\r\nYou cannot have two or more of the same Pok\uFF83\uFF69mon on your team \r\nA Pok\u00E9mon cannot have two of the same move\r\nMega Evolution is yet to be implemented, though all mega evolutions are accessible\r\nCorrectness of moves is not checked for. i.e.: for now any Pok\uFF83\uFF69mon can learn any move\r\nA Pok\uFF83\uFF69mon with multiple forms may not have a model accompanied with it");
		textArea.setEditable(false);
		textArea.setBounds(10, 41, 575, 179);
		HTP.getContentPane().add(textArea);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setText("Pok\u00E9mon Rush is played in real time. Unlike the turn-based format in the \r\nmain-series games, a Pok\uFF83\uFF69mon can attack whenever it is not already performing \r\nan action. In order to register an attack or switch, simply press one of the \r\nlabeled buttons on the lower half of your screen during a battle. If you want \r\nto register a series of actions, simply click them in sequence and they \r\nwill automatically execute in that order as soon as possible.\r\n\r\nThere is a log in the middle of the two active Pok\uFF83\uFF69mon that displays the last seven\r\nevents that have occurred. Use this as a reference to aid you in understanding the\r\ncurrent battle situation.");
		textArea_1.setEditable(false);
		textArea_1.setBounds(10, 272, 575, 179);
		HTP.getContentPane().add(textArea_1);
		
		JLabel lblGamePlayattacking = new JLabel("Game Play (Attacking and Switching)");
		lblGamePlayattacking.setBounds(21, 250, 277, 16);
		HTP.getContentPane().add(lblGamePlayattacking);
		
		JLabel lblMechanics = new JLabel("Vision & Mechanics");
		lblMechanics.setBounds(21, 470, 277, 16);
		HTP.getContentPane().add(lblMechanics);
		
		TextArea textArea_2 = new TextArea();
		textArea_2.setText("Pok\u00E9mon Rush is a spin on Smogon's competitive Pok\u00E9mon rule set geared \r\ntoward competitive, fast-paced play that rewards skill and good \r\ndecision making by means of mechanical changes. The following \r\nis a list of how the mechanics of Pok\u00E9mon Rush differ from that \r\nof a main-series title.\r\n\r\n----------------------\r\n\r\nReal-Time Format:\r\nPok\u00E9mon Rush is not played in a turn-based format. Instead,\r\na Pok\u00E9mon will be able to attack whenever it is not already performing\r\nand action. Though it has not yet been implemented, a Pok\u00E9mon will\r\nhave three stages to its attack: start up, execution, and cool down.\r\nThese three stages will be effected by the Pok\u00E9mon\u7AB6\u51B1 speed, the accuracy \r\nof the move, and the priority of the move.\r\n\r\n----------------------\r\n\r\nRandom Number Generation (RNG) Pseudo-Removal:\r\nRNG is the mechanic responsible for all the luck and \"hax\" that often\r\noccurs in gameplay. It is what decides if a Pok\uFF83\uFF69mon can't move due to paralysis\r\nor if a Pok\uFF83\uFF69mon misses a move. In the interest of competitive gameplay,\r\nthe majority of RNG has been removed from Pok\uFF83\uFF69mon RUSH. Moves\r\nno longer miss, secondary effects of moves always activate, and\r\nthere are no critical hits. However, in the interest of making\r\nsure gameplay isn't redundant, some RNG was kept such as damage\r\nrolls and the number of times a multi-hit move will hit.\r\n\r\n----------------------\r\n\r\nStatus Effects:\r\nMajor status effects and are no longer binary or permanent. Instead of \r\nreceiving the full debuff from a status effect once a Pok\uFF83\uFF69mon\r\nis inflicted with it, a Pok\uFF83\uFF69mon receives a fraction of the full debuff\r\ndepending on the degree (or severity) of the status effect. Also,\r\nthe degree of the status will heal over time and the inflicted Pok\uFF83\uFF69mon\r\nwill become healthy again. This degree of the status diminishes both on\r\nthe field and on the bench. \r\nFor example,\r\na burned Pok\uFF83\uFF69mon in a main-series title loses 1/8th its maximum HP\r\nevery turn and its attack stat is halved. In Pok\uFF83\uFF69mon Rush, a Pok\uFF83\uFF69mon\r\nmay be burned with a degree of 40/100. This means that said \r\nPok\uFF83\uFF69mon would lose 40% of 1/8th of its HP over a small period of\r\ntime and its attack stat would lose 40% of half its original attack.\r\nEvery time the Pok\uFF83\uFF69mon is hurt by Burn, the severity decreases by\r\n10%\r\n \r\nBelow is an exhaustive list of the status effects that have been \r\ndrastically changed thus far and what they do:\r\n\r\nNote: a degree is a percentage value. E.g. a degree of 40 means the\r\nseverity of a condition is 40% of the maximum debuff.\r\n\r\nBurn: Pok\uFF83\uFF69mon loses 1/8th its maximum HP multiplied by its \r\ndegree over a period of time and loses half of its attack stat multiplied\r\nby its degree.\r\n\r\nParalysis: Pok\uFF83\uFF69mon loses 3/4th its maximum speed multiplied by its \r\ndegree over a period of time and is fully immobilized if the degree\r\nis greater than or equal to 70.\r\n\r\nFreeze: Pok\uFF83\uFF69mon is immobilized if the degree is greater than 50.\r\n\r\nPoison: Pok\uFF83\uFF69mon loses 1/8th its maximum HP multiplied by its \r\ndegree over a period of time.\r\n\r\nToxic Poison: Toxic Poison is the only status to get worse over time\r\nand has its degree reset when it is pulled out of the battle. The\r\ndegree of the status increases over time and the Pok\uFF83\uFF69mon will lose\r\n1/2 its max HP times the degree.\r\n\r\nConfusion: A Pok\uFF83\uFF69mon will always hit itself in confusion if the degree\r\nis 65 or more. Otherwise the Pok\uFF83\uFF69mon will be unable to attack until\r\nthe degree has reached 0. Confusion is the fastest self-healing\r\nstatus.\r\n\r\n----------------------\r\n\r\nSecondary Effects of Moves:\r\nSecondary effects of moves will always active. For example,\r\nScald, instead of having a 30% chance to burn, will always burn\r\nadding to the degree of the status by 30 every time. Note that one\r\nPok\uFF83\uFF69mon cannot have more than one major status effect at one time.\r\nEffects that increase or lower a stat have yet to be implemented,\r\nhowever expect some in the next release.");
		textArea_2.setEditable(false);
		textArea_2.setBounds(10, 493, 575, 179);
		HTP.getContentPane().add(textArea_2);
	}
}
