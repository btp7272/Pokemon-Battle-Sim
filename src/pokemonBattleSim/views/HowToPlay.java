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
		textArea.setText("When you are about to start a game, a window called a Team Builder will pop up.\nIn the team builder you will be able to construct the team of 6 Pokémon that you\nwill bring into the battle. Use the drop down boxes and text boxes to\nselect and customize your Pokémon. When you have finished your team, \nclick the \"Finalize\" button in the bottom right corner.\n\nNote: \nYou can only select from moves, items, and abilities that have been implemented\nYou cannot have two or more of the same Pokémon on your team \nA Pokémon cannot have two of the same move\nMega Evolution is yet to be implemented, though all mega evolutions are accessible\nCorrectness of moves is not checked for. i.e.: for now any Pokémon can learn any move\nA Pokémon with multiple forms may not have a model accompanied with it");
		textArea.setEditable(false);
		textArea.setBounds(10, 41, 575, 179);
		HTP.getContentPane().add(textArea);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setText("Pokémon Rush is played in real time. Unlike the turn-based format in the \nmain-series games, a Pokémon can attack whenever it is not already performing \nan action. In order to register an attack or switch, simply press one of the \nlabeled buttons on the lower half of your screen during a battle. If you want \nto register a series of actions, simply click them in sequence and they \nwill automatically execute in that order as soon as possible.\n\nThere is a log in the middle of the two active Pokémon that displays the last seven\nevents that have occurred. Use this as a reference to aid you in understanding the\ncurrent battle situation.");
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
		textArea_2.setText("Pokémon Rush is a spin on Smogon's competitive Pokémon rule set geared \ntoward competitive, fast-paced play that rewards skill and good \ndecision making by means of mechanical changes. The following \nis a list of how the mechanics of Pokémon Rush differ from that \nof a main-series title.\n\n----------------------\n\nReal-Time Format:\nPokémon Rush is not played in a turn-based format. Instead,\na Pokémon will be able to attack whenever it is not already performing\nand action. Though it has not yet been implemented, a Pokémon will\nhave three stages to its attack: start up, execution, and cool down.\nThese three stages will be effected by the Pokémon’s speed, the accuracy \nof the move, and the priority of the move.\n\n----------------------\n\nRandom Number Generation (RNG) Pseudo-Removal:\nRNG is the mechanic responsible for all the luck and \"hax\" that often\noccurs in gameplay. It is what decides if a Pokémon can't move due to paralysis\nor if a Pokémon misses a move. In the interest of competitive gameplay,\nthe majority of RNG has been removed from Pokémon RUSH. Moves\nno longer miss, secondary effects of moves always activate, and\nthere are no critical hits. However, in the interest of making\nsure gameplay isn't redundant, some RNG was kept such as damage\nrolls and the number of times a multi-hit move will hit.\n\n----------------------\n\nStatus Effects:\nMajor status effects and are no longer binary or permanent. Instead of \nreceiving the full debuff from a status effect once a Pokémon\nis inflicted with it, a Pokémon receives a fraction of the full debuff\ndepending on the degree (or severity) of the status effect. Also,\nthe degree of the status will heal over time and the inflicted Pokémon\nwill become healthy again. This degree of the status diminishes both on\nthe field and on the bench. \nFor example,\na burned Pokémon in a main-series title loses 1/8th its maximum HP\nevery turn and its attack stat is halved. In Pokémon Rush, a Pokémon\nmay be burned with a degree of 40/100. This means that said \nPokémon would lose 40% of 1/8th of its HP over a small period of\ntime and its attack stat would lose 40% of half its original attack.\nEvery time the Pokémon is hurt by Burn, the severity decreases by\n10%\n \nBelow is an exhaustive list of the status effects that have been \ndrastically changed thus far and what they do:\n\nNote: a degree is a percentage value. E.g. a degree of 40 means the\nseverity of a condition is 40% of the maximum debuff.\n\nBurn: Pokémon loses 1/8th its maximum HP multiplied by its \ndegree over a period of time and loses half of its attack stat multiplied\nby its degree.\n\nParalysis: Pokémon loses 3/4th its maximum speed multiplied by its \ndegree over a period of time and is fully immobilized if the degree\nis greater than or equal to 70.\n\nFreeze: Pokémon is immobilized if the degree is greater than 50.\n\nPoison: Pokémon loses 1/8th its maximum HP multiplied by its \ndegree over a period of time.\n\nToxic Poison: Toxic Poison is the only status to get worse over time\nand has its degree reset when it is pulled out of the battle. The\ndegree of the status increases over time and the Pokémon will lose\n1/2 its max HP times the degree.\n\nConfusion: A Pokémon will always hit itself in confusion if the degree\nis 65 or more. Otherwise the Pokémon will be unable to attack until\nthe degree has reached 0. Confusion is the fastest self-healing\nstatus.\n\n----------------------\n\nSecondary Effects of Moves:\nSecondary effects of moves will always active. For example,\nScald, instead of having a 30% chance to burn, will always burn\nadding to the degree of the status by 30 every time. Note that one\nPokémon cannot have more than one major status effect at one time.\nEffects that increase or lower a stat have yet to be implemented,\nhowever expect some in the next release.");
		textArea_2.setEditable(false);
		textArea_2.setBounds(21, 492, 575, 179);
		HTP.getContentPane().add(textArea_2);
	}
}
