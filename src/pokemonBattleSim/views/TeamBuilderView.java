package pokemonBattleSim.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pokemonBattleSim.models.BattleModel;
import pokemonBattleSim.models.MoveMap;
import pokemonBattleSim.models.SpeciesMap;
import pokemonBattleSim.models.TeamBuilderModel;
import pokemonBattleSim.types.AbilityContainer;
import pokemonBattleSim.types.IPokemonTrainer;
import pokemonBattleSim.types.ItemContainer;
import pokemonBattleSim.types.Move;
import pokemonBattleSim.types.Nature;
import pokemonBattleSim.types.Pokemon;
import pokemonBattleSim.types.PokemonTrainer;
import pokemonBattleSim.types.StatusContainer;
import pokemonBattleSim.controllers.BattleController;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.awt.event.ActionEvent;


public class TeamBuilderView extends JFrame {

	private JPanel contentPane;
	private JTextField p1_species;
	private JTextField p1_nickname;
	private JTextField p1_hp_iv;
	private JTextField p1_atk_iv;
	private JTextField p1_def_iv;
	private JTextField p1_spatk_iv;
	private JTextField p1_spdef_iv;
	private JTextField p1_speed_iv;
	private JTextField p1_hp_ev;
	private JTextField p1_atk_ev;
	private JTextField p1_def_ev;
	private JTextField p1_spatk_ev;
	private JTextField p1_spdef_ev;
	private JTextField p1_speed_ev;
	private JComboBox p1_ability;
	private JTextField p2_species;
	private JTextField p2_nickname;
	private JTextField p2_hp_iv;
	private JTextField p2_atk_iv;
	private JTextField p2_def_iv;
	private JTextField p2_spatk_iv;
	private JTextField p2_spdef_iv;
	private JTextField p2_speed_iv;
	private JTextField p2_hp_ev;
	private JTextField p2_atk_ev;
	private JTextField p2_def_ev;
	private JTextField p2_spatk_ev;
	private JTextField p2_spdef_ev;
	private JTextField p2_speed_ev;
	private JTextField p3_species;
	private JTextField p3_nickname;
	private JTextField p3_hp_iv;
	private JTextField p3_atk_iv;
	private JTextField p3_def_iv;
	private JTextField p3_spatk_iv;
	private JTextField p3_spdef_iv;
	private JTextField p3_speed_iv;
	private JTextField p3_hp_ev;
	private JTextField p3_atk_ev;
	private JTextField p3_def_ev;
	private JTextField p3_spatk_ev;
	private JTextField p3_spdef_ev;
	private JTextField p3_speed_ev;
	private JTextField p4_species;
	private JTextField p4_nickname;
	private JTextField p4_hp_iv;
	private JTextField p4_atk_iv;
	private JTextField p4_def_iv;
	private JTextField p4_spatk_iv;
	private JTextField p4_spdef_iv;
	private JTextField p4_speed_iv;
	private JTextField p4_hp_ev;
	private JTextField p4_atk_ev;
	private JTextField p4_def_ev;
	private JTextField p4_spatk_ev;
	private JTextField p4_spdef_ev;
	private JTextField p4_speed_ev;
	private JTextField p5_species;
	private JTextField p5_nickname;
	private JTextField p5_hp_iv;
	private JTextField p5_atk_iv;
	private JTextField p5_def_iv;
	private JTextField p5_spatk_iv;
	private JTextField p5_spdef_iv;
	private JTextField p5_speed_iv;
	private JTextField p5_hp_ev;
	private JTextField p5_atk_ev;
	private JTextField p5_def_ev;
	private JTextField p5_spatk_ev;
	private JTextField p5_spdef_ev;
	private JTextField p5_speed_ev;
	private JTextField p6_species;
	private JTextField p6_nickname;
	private JTextField p6_hp_iv;
	private JTextField p6_atk_iv;
	private JTextField p6_def_iv;
	private JTextField p6_spatk_iv;
	private JTextField p6_spdef_iv;
	private JTextField p6_speed_iv;
	private JTextField p6_hp_ev;
	private JTextField p6_atk_ev;
	private JTextField p6_def_ev;
	private JTextField p6_spatk_ev;
	private JTextField p6_spdef_ev;
	private JTextField p6_speed_ev;
	private JButton btnRefresh;
	private JButton btnFinalize;
	private JButton btnCancel;
	public String moves1;
	public String moves2;
	public String moves3;
	public String moves4;
	public String moves5;
	public String moves6;
	TeamBuilderModel model;
	/**
	 * Launch the application.
	 */
	public static void startTeam() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamBuilderView frame = new TeamBuilderView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void onViewNotify()
	{
		model = TeamBuilderModel.getInstance();
		if (model == null) 
			return;
		
		/*
		 * update things
		 */
		/*
	    pokeOne = poke1.getText();
	    pokeTwo = poke2.getText();
	    pokeThree = poke3.getText();
	    pokeFour = poke4.getText();
	    pokeFive = poke5.getText();
	    pokeSix = poke6.getText();
		*/
	    moves1 = model.generateMoves(p1_species.getText());
		/*moves2 = model.generateMoves(pokeTwo);
		moves3 = model.generateMoves(pokeThree);
		moves4 = model.generateMoves(pokeFour);
		moves5 = model.generateMoves(pokeFive);
		moves6 = model.generateMoves(pokeSix);
	    
		abilities1 = model.generateAbilities(pokeOne);
		abilities2 = model.generateAbilities(pokeTwo);
		abilities3 = model.generateAbilities(pokeThree);
		abilities4 = model.generateAbilities(pokeFour);
		abilities5 = model.generateAbilities(pokeFive);
		abilities6 = model.generateAbilities(pokeSix);
		*/
	}
	/**
	 * Create the frame.
	 */
	public TeamBuilderView() {
		String[] poke1move2List = {moves1};
		/*
		moves1 = model.generateMoves(pokeOne);
		moves2 = model.generateMoves(pokeTwo);
		moves3 = model.generateMoves(pokeThree);
		moves4 = model.generateMoves(pokeFour);
		moves5 = model.generateMoves(pokeFive);
		moves6 = model.generateMoves(pokeSix);
		*/
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel pokelabel2 = new JLabel("Pokemon 2");
		pokelabel2.setBounds(220, 5, 100, 25);
		contentPane.add(pokelabel2);
		
		JLabel pokelabel3 = new JLabel("Pokemon 3");
		pokelabel3.setBounds(350, 5, 100, 25);
		contentPane.add(pokelabel3);
		
		JLabel pokelabel4 = new JLabel("Pokemon 4");
		pokelabel4.setBounds(480, 5, 100, 25);
		contentPane.add(pokelabel4);
		
		JLabel pokelabel5 = new JLabel("Pokemon 5");
		pokelabel5.setBounds(610, 5, 100, 25);
		contentPane.add(pokelabel5);
		
		JLabel pokelabel6 = new JLabel("Pokemon 6");
		pokelabel6.setBounds(740, 5, 100, 25);
		contentPane.add(pokelabel6);
		
		JLabel label_6 = new JLabel("Pokemon");
		label_6.setBounds(5, 25, 100, 25);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Nickname");
		label_7.setBounds(5, 55, 100, 25);
		contentPane.add(label_7);
		
		p1_species = new JTextField(30);
		p1_species.setToolTipText("Pokemon");
		p1_species.setBounds(90, 25, 100, 25);
		contentPane.add(p1_species);
		
		p1_nickname = new JTextField(30);
		p1_nickname.setToolTipText("Pokemon");
		p1_nickname.setBounds(90, 55, 100, 25);
		contentPane.add(p1_nickname);
		
		JComboBox p1_move1 = new JComboBox(new Object[]{});
		p1_move1.setBounds(90, 95, 100, 25);
		contentPane.add(p1_move1);
		
		JComboBox p1_move2 = new JComboBox(poke1move2List);
		p1_move2.setBounds(90, 125, 100, 25);
		contentPane.add(p1_move2);
		
		JComboBox p1_move3 = new JComboBox(new Object[]{});
		p1_move3.setBounds(90, 155, 100, 25);
		contentPane.add(p1_move3);
		
		JComboBox p1_move4 = new JComboBox(new Object[]{});
		p1_move4.setBounds(90, 185, 100, 25);
		contentPane.add(p1_move4);
		
		p1_hp_iv = new JTextField(2);
		p1_hp_iv.setText("31");
		p1_hp_iv.setBounds(90, 265, 100, 25);
		contentPane.add(p1_hp_iv);
		
		p1_atk_iv = new JTextField(2);
		p1_atk_iv.setText("31");
		p1_atk_iv.setBounds(90, 290, 100, 25);
		contentPane.add(p1_atk_iv);
		
		p1_def_iv = new JTextField(2);
		p1_def_iv.setText("31");
		p1_def_iv.setBounds(90, 315, 100, 25);
		contentPane.add(p1_def_iv);
		
		p1_spatk_iv = new JTextField(2);
		p1_spatk_iv.setText("31");
		p1_spatk_iv.setBounds(90, 340, 100, 25);
		contentPane.add(p1_spatk_iv);
		
		p1_spdef_iv = new JTextField(2);
		p1_spdef_iv.setText("31");
		p1_spdef_iv.setBounds(90, 365, 100, 25);
		contentPane.add(p1_spdef_iv);
		
		p1_speed_iv = new JTextField(2);
		p1_speed_iv.setText("31");
		p1_speed_iv.setBounds(90, 390, 100, 25);
		contentPane.add(p1_speed_iv);
		
		JLabel pokelabel1 = new JLabel("Pokemon 1");
		pokelabel1.setBounds(90, 5, 100, 25);
		contentPane.add(pokelabel1);
		
		JLabel lblIndividualValuesindividual = new JLabel("Individual Values (Individual Max of 31)");
		lblIndividualValuesindividual.setBounds(90, 251, 261, 14);
		contentPane.add(lblIndividualValuesindividual);
		
		JLabel lblEffortValuesindividual = new JLabel("Effort Values (Individual Max of 252 - Total Max of 510)");
		lblEffortValuesindividual.setBounds(90, 419, 461, 14);
		contentPane.add(lblEffortValuesindividual);
		
		p1_hp_ev = new JTextField(2);
		p1_hp_ev.setText("0");
		p1_hp_ev.setBounds(90, 435, 100, 25);
		contentPane.add(p1_hp_ev);
		
		p1_atk_ev = new JTextField(2);
		p1_atk_ev.setText("0");
		p1_atk_ev.setBounds(90, 460, 100, 25);
		contentPane.add(p1_atk_ev);
		
		p1_def_ev = new JTextField(2);
		p1_def_ev.setText("0");
		p1_def_ev.setBounds(90, 485, 100, 25);
		contentPane.add(p1_def_ev);
		
		p1_spatk_ev = new JTextField(2);
		p1_spatk_ev.setText("0");
		p1_spatk_ev.setBounds(90, 510, 100, 25);
		contentPane.add(p1_spatk_ev);
		
		p1_spdef_ev = new JTextField(2);
		p1_spdef_ev.setText("0");
		p1_spdef_ev.setBounds(90, 535, 100, 25);
		contentPane.add(p1_spdef_ev);
		
		p1_speed_ev = new JTextField(2);
		p1_speed_ev.setText("0");
		p1_speed_ev.setBounds(90, 560, 100, 25);
		contentPane.add(p1_speed_ev);
		
		p1_ability = new JComboBox(new Object[]{});
		p1_ability.setBounds(90, 215, 100, 25);
		contentPane.add(p1_ability);
		
		JLabel lblNewLabel = new JLabel("Move 1");
		lblNewLabel.setBounds(5, 100, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMove = new JLabel("Move 2");
		lblMove.setBounds(5, 130, 46, 14);
		contentPane.add(lblMove);
		
		JLabel lblMove_1 = new JLabel("Move 3");
		lblMove_1.setBounds(5, 160, 46, 14);
		contentPane.add(lblMove_1);
		
		JLabel lblMove_2 = new JLabel("Move 4");
		lblMove_2.setBounds(5, 190, 46, 14);
		contentPane.add(lblMove_2);
		
		JLabel lblAbility = new JLabel("Ability");
		lblAbility.setBounds(5, 220, 46, 14);
		contentPane.add(lblAbility);
		
		JLabel lblHp = new JLabel("HP");
		lblHp.setBounds(5, 270, 46, 14);
		contentPane.add(lblHp);
		
		JLabel lblAttack = new JLabel("Attack");
		lblAttack.setBounds(5, 295, 46, 14);
		contentPane.add(lblAttack);
		
		JLabel lblDefense = new JLabel("Defense");
		lblDefense.setBounds(5, 320, 73, 14);
		contentPane.add(lblDefense);
		
		JLabel lblSpecialAttack = new JLabel("Special Atk");
		lblSpecialAttack.setBounds(5, 345, 85, 14);
		contentPane.add(lblSpecialAttack);
		
		JLabel lblSepcialDefense = new JLabel("Special Def");
		lblSepcialDefense.setBounds(5, 370, 85, 14);
		contentPane.add(lblSepcialDefense);
		
		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setBounds(5, 395, 46, 14);
		contentPane.add(lblSpeed);
		
		JLabel label = new JLabel("Speed");
		label.setBounds(5, 565, 46, 14);
		contentPane.add(label);
		
		JLabel lblSpecialDef = new JLabel("Special Def");
		lblSpecialDef.setBounds(5, 540, 85, 14);
		contentPane.add(lblSpecialDef);
		
		JLabel lblSpecialAtk = new JLabel("Special Atk");
		lblSpecialAtk.setBounds(5, 515, 85, 14);
		contentPane.add(lblSpecialAtk);
		
		JLabel label_3 = new JLabel("Defense");
		label_3.setBounds(5, 490, 85, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Attack");
		label_4.setBounds(5, 465, 46, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("HP");
		label_5.setBounds(5, 440, 46, 14);
		contentPane.add(label_5);
		
		p2_species = new JTextField(30);
		p2_species.setToolTipText("Pokemon");
		p2_species.setBounds(220, 25, 100, 25);
		contentPane.add(p2_species);
		
		p2_nickname = new JTextField(30);
		p2_nickname.setToolTipText("Pokemon");
		p2_nickname.setBounds(220, 55, 100, 25);
		contentPane.add(p2_nickname);
		
		JComboBox p2_move1 = new JComboBox(new Object[]{});
		p2_move1.setBounds(220, 95, 100, 25);
		p2_move1.setModel(new DefaultComboBoxModel(new String[] {moves1}));
		contentPane.add(p2_move1);
		
		JComboBox p2_move2 = new JComboBox(new Object[]{});
		p2_move2.setBounds(220, 125, 100, 25);
		contentPane.add(p2_move2);
		
		JComboBox p2_move3 = new JComboBox(new Object[]{});
		p2_move3.setBounds(220, 155, 100, 25);
		contentPane.add(p2_move3);
		
		JComboBox p2_move4 = new JComboBox(new Object[]{});
		p2_move4.setBounds(220, 185, 100, 25);
		contentPane.add(p2_move4);
		
		JComboBox p2_ability = new JComboBox(new Object[]{});
		p2_ability.setBounds(220, 215, 100, 25);
		contentPane.add(p2_ability);
		
		p2_hp_iv = new JTextField(2);
		p2_hp_iv.setText("31");
		p2_hp_iv.setBounds(220, 265, 100, 25);
		contentPane.add(p2_hp_iv);
		
		p2_atk_iv = new JTextField(2);
		p2_atk_iv.setText("31");
		p2_atk_iv.setBounds(220, 290, 100, 25);
		contentPane.add(p2_atk_iv);
		
		p2_def_iv = new JTextField(2);
		p2_def_iv.setText("31");
		p2_def_iv.setBounds(220, 315, 100, 25);
		contentPane.add(p2_def_iv);
		
		p2_spatk_iv = new JTextField(2);
		p2_spatk_iv.setText("31");
		p2_spatk_iv.setBounds(220, 340, 100, 25);
		contentPane.add(p2_spatk_iv);
		
		p2_spdef_iv = new JTextField(2);
		p2_spdef_iv.setText("31");
		p2_spdef_iv.setBounds(220, 365, 100, 25);
		contentPane.add(p2_spdef_iv);
		
		p2_speed_iv = new JTextField(2);
		p2_speed_iv.setText("31");
		p2_speed_iv.setBounds(220, 390, 100, 25);
		contentPane.add(p2_speed_iv);
		
		p2_hp_ev = new JTextField(2);
		p2_hp_ev.setText("0");
		p2_hp_ev.setBounds(220, 435, 100, 25);
		contentPane.add(p2_hp_ev);
		
		p2_atk_ev = new JTextField(2);
		p2_atk_ev.setText("0");
		p2_atk_ev.setBounds(220, 460, 100, 25);
		contentPane.add(p2_atk_ev);
		
		p2_def_ev = new JTextField(2);
		p2_def_ev.setText("0");
		p2_def_ev.setBounds(220, 485, 100, 25);
		contentPane.add(p2_def_ev);
		
		p2_spatk_ev = new JTextField(2);
		p2_spatk_ev.setText("0");
		p2_spatk_ev.setBounds(220, 510, 100, 25);
		contentPane.add(p2_spatk_ev);
		
		p2_spdef_ev = new JTextField(2);
		p2_spdef_ev.setText("0");
		p2_spdef_ev.setBounds(220, 535, 100, 25);
		contentPane.add(p2_spdef_ev);
		
		p2_speed_ev = new JTextField(2);
		p2_speed_ev.setText("0");
		p2_speed_ev.setBounds(220, 560, 100, 25);
		contentPane.add(p2_speed_ev);
		
		p3_species = new JTextField(30);
		p3_species.setToolTipText("Pokemon");
		p3_species.setBounds(350, 25, 100, 25);
		contentPane.add(p3_species);
		
		p3_nickname = new JTextField(30);
		p3_nickname.setToolTipText("Pokemon");
		p3_nickname.setBounds(350, 55, 100, 25);
		contentPane.add(p3_nickname);
		
		JComboBox p3_move1 = new JComboBox(new Object[]{});
		p3_move1.setBounds(350, 95, 100, 25);
		contentPane.add(p3_move1);
		
		JComboBox p3_move2 = new JComboBox(new Object[]{});
		p3_move2.setBounds(350, 125, 100, 25);
		contentPane.add(p3_move2);
		
		JComboBox p3_move3 = new JComboBox(new Object[]{});
		p3_move3.setBounds(350, 155, 100, 25);
		contentPane.add(p3_move3);
		
		JComboBox p3_move4 = new JComboBox(new Object[]{});
		p3_move4.setBounds(350, 185, 100, 25);
		contentPane.add(p3_move4);
		
		JComboBox p3_ability = new JComboBox(new Object[]{});
		p3_ability.setBounds(350, 215, 100, 25);
		contentPane.add(p3_ability);
		
		p3_hp_iv = new JTextField(2);
		p3_hp_iv.setText("31");
		p3_hp_iv.setBounds(350, 265, 100, 25);
		contentPane.add(p3_hp_iv);
		
		p3_atk_iv = new JTextField(2);
		p3_atk_iv.setText("31");
		p3_atk_iv.setBounds(350, 290, 100, 25);
		contentPane.add(p3_atk_iv);
		
		p3_def_iv = new JTextField(2);
		p3_def_iv.setText("31");
		p3_def_iv.setBounds(350, 315, 100, 25);
		contentPane.add(p3_def_iv);
		
		p3_spatk_iv = new JTextField(2);
		p3_spatk_iv.setText("31");
		p3_spatk_iv.setBounds(350, 340, 100, 25);
		contentPane.add(p3_spatk_iv);
		
		p3_spdef_iv = new JTextField(2);
		p3_spdef_iv.setText("31");
		p3_spdef_iv.setBounds(350, 365, 100, 25);
		contentPane.add(p3_spdef_iv);
		
		p3_speed_iv = new JTextField(2);
		p3_speed_iv.setText("31");
		p3_speed_iv.setBounds(350, 390, 100, 25);
		contentPane.add(p3_speed_iv);
		
		p3_hp_ev = new JTextField(2);
		p3_hp_ev.setText("0");
		p3_hp_ev.setBounds(350, 435, 100, 25);
		contentPane.add(p3_hp_ev);
		
		p3_atk_ev = new JTextField(2);
		p3_atk_ev.setText("0");
		p3_atk_ev.setBounds(350, 460, 100, 25);
		contentPane.add(p3_atk_ev);
		
		p3_def_ev = new JTextField(2);
		p3_def_ev.setText("0");
		p3_def_ev.setBounds(350, 485, 100, 25);
		contentPane.add(p3_def_ev);
		
		p3_spatk_ev = new JTextField(2);
		p3_spatk_ev.setText("0");
		p3_spatk_ev.setBounds(350, 510, 100, 25);
		contentPane.add(p3_spatk_ev);
		
		p3_spdef_ev = new JTextField(2);
		p3_spdef_ev.setText("0");
		p3_spdef_ev.setBounds(350, 535, 100, 25);
		contentPane.add(p3_spdef_ev);
		
		p3_speed_ev = new JTextField(2);
		p3_speed_ev.setText("0");
		p3_speed_ev.setBounds(350, 560, 100, 25);
		contentPane.add(p3_speed_ev);
		
		p4_species = new JTextField(30);
		p4_species.setToolTipText("Pokemon");
		p4_species.setBounds(480, 25, 100, 25);
		contentPane.add(p4_species);
		
		p4_nickname = new JTextField(30);
		p4_nickname.setToolTipText("Pokemon");
		p4_nickname.setBounds(480, 55, 100, 25);
		contentPane.add(p4_nickname);
		
		JComboBox p4_move1 = new JComboBox(new Object[]{});
		p4_move1.setBounds(480, 95, 100, 25);
		contentPane.add(p4_move1);
		
		JComboBox p4_move2 = new JComboBox(new Object[]{});
		p4_move2.setBounds(480, 125, 100, 25);
		contentPane.add(p4_move2);
		
		JComboBox p4_move3 = new JComboBox(new Object[]{});
		p4_move3.setBounds(480, 155, 100, 25);
		contentPane.add(p4_move3);
		
		JComboBox p4_move4 = new JComboBox(new Object[]{});
		p4_move4.setBounds(480, 185, 100, 25);
		contentPane.add(p4_move4);
		
		JComboBox p4_ability = new JComboBox(new Object[]{});
		p4_ability.setBounds(480, 215, 100, 25);
		contentPane.add(p4_ability);
		
		p4_hp_iv = new JTextField(2);
		p4_hp_iv.setText("31");
		p4_hp_iv.setBounds(480, 265, 100, 25);
		contentPane.add(p4_hp_iv);
		
		p4_atk_iv = new JTextField(2);
		p4_atk_iv.setText("31");
		p4_atk_iv.setBounds(480, 290, 100, 25);
		contentPane.add(p4_atk_iv);
		
		p4_def_iv = new JTextField(2);
		p4_def_iv.setText("31");
		p4_def_iv.setBounds(480, 315, 100, 25);
		contentPane.add(p4_def_iv);
		
		p4_spatk_iv = new JTextField(2);
		p4_spatk_iv.setText("31");
		p4_spatk_iv.setBounds(480, 340, 100, 25);
		contentPane.add(p4_spatk_iv);
		
		p4_spdef_iv = new JTextField(2);
		p4_spdef_iv.setText("31");
		p4_spdef_iv.setBounds(480, 365, 100, 25);
		contentPane.add(p4_spdef_iv);
		
		p4_speed_iv = new JTextField(2);
		p4_speed_iv.setText("31");
		p4_speed_iv.setBounds(480, 390, 100, 25);
		contentPane.add(p4_speed_iv);
		
		p4_hp_ev = new JTextField(2);
		p4_hp_ev.setText("0");
		p4_hp_ev.setBounds(480, 435, 100, 25);
		contentPane.add(p4_hp_ev);
		
		p4_atk_ev = new JTextField(2);
		p4_atk_ev.setText("0");
		p4_atk_ev.setBounds(480, 460, 100, 25);
		contentPane.add(p4_atk_ev);
		
		p4_def_ev = new JTextField(2);
		p4_def_ev.setText("0");
		p4_def_ev.setBounds(480, 485, 100, 25);
		contentPane.add(p4_def_ev);
		
		p4_spatk_ev = new JTextField(2);
		p4_spatk_ev.setText("0");
		p4_spatk_ev.setBounds(480, 510, 100, 25);
		contentPane.add(p4_spatk_ev);
		
		p4_spdef_ev = new JTextField(2);
		p4_spdef_ev.setText("0");
		p4_spdef_ev.setBounds(480, 535, 100, 25);
		contentPane.add(p4_spdef_ev);
		
		p4_speed_ev = new JTextField(2);
		p4_speed_ev.setText("0");
		p4_speed_ev.setBounds(480, 560, 100, 25);
		contentPane.add(p4_speed_ev);
		
		p5_species = new JTextField(30);
		p5_species.setToolTipText("Pokemon");
		p5_species.setBounds(610, 25, 100, 25);
		contentPane.add(p5_species);
		
		p5_nickname = new JTextField(30);
		p5_nickname.setToolTipText("Pokemon");
		p5_nickname.setBounds(610, 55, 100, 25);
		contentPane.add(p5_nickname);
		
		JComboBox p5_move1 = new JComboBox(new Object[]{});
		p5_move1.setBounds(610, 95, 100, 25);
		contentPane.add(p5_move1);
		
		JComboBox p5_move2 = new JComboBox(new Object[]{});
		p5_move2.setBounds(610, 125, 100, 25);
		contentPane.add(p5_move2);
		
		JComboBox p5_move3 = new JComboBox(new Object[]{});
		p5_move3.setBounds(610, 155, 100, 25);
		contentPane.add(p5_move3);
		
		JComboBox p5_move4 = new JComboBox(new Object[]{});
		p5_move4.setBounds(610, 185, 100, 25);
		contentPane.add(p5_move4);
		
		JComboBox p5_ability = new JComboBox(new Object[]{});
		p5_ability.setBounds(610, 215, 100, 25);
		contentPane.add(p5_ability);
		
		p5_hp_iv = new JTextField(2);
		p5_hp_iv.setText("31");
		p5_hp_iv.setBounds(610, 265, 100, 25);
		contentPane.add(p5_hp_iv);
		
		p5_atk_iv = new JTextField(2);
		p5_atk_iv.setText("31");
		p5_atk_iv.setBounds(610, 290, 100, 25);
		contentPane.add(p5_atk_iv);
		
		p5_def_iv = new JTextField(2);
		p5_def_iv.setText("31");
		p5_def_iv.setBounds(610, 315, 100, 25);
		contentPane.add(p5_def_iv);
		
		p5_spatk_iv = new JTextField(2);
		p5_spatk_iv.setText("31");
		p5_spatk_iv.setBounds(610, 340, 100, 25);
		contentPane.add(p5_spatk_iv);
		
		p5_spdef_iv = new JTextField(2);
		p5_spdef_iv.setText("31");
		p5_spdef_iv.setBounds(610, 365, 100, 25);
		contentPane.add(p5_spdef_iv);
		
		p5_speed_iv = new JTextField(2);
		p5_speed_iv.setText("31");
		p5_speed_iv.setBounds(610, 390, 100, 25);
		contentPane.add(p5_speed_iv);
		
		p5_hp_ev = new JTextField(2);
		p5_hp_ev.setText("0");
		p5_hp_ev.setBounds(610, 435, 100, 25);
		contentPane.add(p5_hp_ev);
		
		p5_atk_ev = new JTextField(2);
		p5_atk_ev.setText("0");
		p5_atk_ev.setBounds(610, 460, 100, 25);
		contentPane.add(p5_atk_ev);
		
		p5_def_ev = new JTextField(2);
		p5_def_ev.setText("0");
		p5_def_ev.setBounds(610, 485, 100, 25);
		contentPane.add(p5_def_ev);
		
		p5_spatk_ev = new JTextField(2);
		p5_spatk_ev.setText("0");
		p5_spatk_ev.setBounds(610, 510, 100, 25);
		contentPane.add(p5_spatk_ev);
		
		p5_spdef_ev = new JTextField(2);
		p5_spdef_ev.setText("0");
		p5_spdef_ev.setBounds(610, 535, 100, 25);
		contentPane.add(p5_spdef_ev);
		
		p5_speed_ev = new JTextField(2);
		p5_speed_ev.setText("0");
		p5_speed_ev.setBounds(610, 560, 100, 25);
		contentPane.add(p5_speed_ev);
		
		p6_species = new JTextField(30);
		p6_species.setToolTipText("Pokemon");
		p6_species.setBounds(740, 25, 100, 25);
		contentPane.add(p6_species);
		
		p6_nickname = new JTextField(30);
		p6_nickname.setToolTipText("Pokemon");
		p6_nickname.setBounds(740, 55, 100, 25);
		contentPane.add(p6_nickname);
		
		JComboBox p6_move1 = new JComboBox(new Object[]{});
		p6_move1.setBounds(740, 95, 100, 25);
		contentPane.add(p6_move1);
		
		JComboBox p6_move2 = new JComboBox(new Object[]{});
		p6_move2.setBounds(740, 125, 100, 25);
		contentPane.add(p6_move2);
		
		JComboBox p6_move3 = new JComboBox(new Object[]{});
		p6_move3.setBounds(740, 155, 100, 25);
		contentPane.add(p6_move3);
		
		JComboBox p6_move4 = new JComboBox(new Object[]{});
		p6_move4.setBounds(740, 185, 100, 25);
		contentPane.add(p6_move4);
		
		JComboBox p6_ability = new JComboBox(new Object[]{});
		p6_ability.setBounds(740, 215, 100, 25);
		contentPane.add(p6_ability);
		
		p6_hp_iv = new JTextField(2);
		p6_hp_iv.setText("31");
		p6_hp_iv.setBounds(740, 265, 100, 25);
		contentPane.add(p6_hp_iv);
		
		p6_atk_iv = new JTextField(2);
		p6_atk_iv.setText("31");
		p6_atk_iv.setBounds(740, 290, 100, 25);
		contentPane.add(p6_atk_iv);
		
		p6_def_iv = new JTextField(2);
		p6_def_iv.setText("31");
		p6_def_iv.setBounds(740, 315, 100, 25);
		contentPane.add(p6_def_iv);
		
		p6_spatk_iv = new JTextField(2);
		p6_spatk_iv.setText("31");
		p6_spatk_iv.setBounds(740, 340, 100, 25);
		contentPane.add(p6_spatk_iv);
		
		p6_spdef_iv = new JTextField(2);
		p6_spdef_iv.setText("31");
		p6_spdef_iv.setBounds(740, 365, 100, 25);
		contentPane.add(p6_spdef_iv);
		
		p6_speed_iv = new JTextField(2);
		p6_speed_iv.setText("31");
		p6_speed_iv.setBounds(740, 390, 100, 25);
		contentPane.add(p6_speed_iv);
		
		p6_hp_ev = new JTextField(2);
		p6_hp_ev.setText("0");
		p6_hp_ev.setBounds(740, 435, 100, 25);
		contentPane.add(p6_hp_ev);
		
		p6_atk_ev = new JTextField(2);
		p6_atk_ev.setText("0");
		p6_atk_ev.setBounds(740, 460, 100, 25);
		contentPane.add(p6_atk_ev);
		
		p6_def_ev = new JTextField(2);
		p6_def_ev.setText("0");
		p6_def_ev.setBounds(740, 485, 100, 25);
		contentPane.add(p6_def_ev);
		
		p6_spatk_ev = new JTextField(2);
		p6_spatk_ev.setText("0");
		p6_spatk_ev.setBounds(740, 510, 100, 25);
		contentPane.add(p6_spatk_ev);
		
		p6_spdef_ev = new JTextField(2);
		p6_spdef_ev.setText("0");
		p6_spdef_ev.setBounds(740, 535, 100, 25);
		contentPane.add(p6_spdef_ev);
		
		p6_speed_ev = new JTextField(2);
		p6_speed_ev.setText("0");
		p6_speed_ev.setBounds(740, 560, 100, 25);
		contentPane.add(p6_speed_ev);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		onViewNotify();
        	}
        });	
		btnRefresh.setBounds(516, 634, 100, 25);
		contentPane.add(btnRefresh);
		
		btnFinalize = new JButton("Finalize");
		btnFinalize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// This is the main entry point to the program, will use other classes
				Object owner = new Object(); //may need to be static?
				IPokemonTrainer player;
				IPokemonTrainer computer;
				ArrayList<Pokemon> playerTeam = new ArrayList<>();
				ArrayList<Pokemon> computerTeam = new ArrayList<>();
				
				//CREATE CHARIZARD
				Map<Integer,ArrayList<String>> moveMap = new HashMap<>();
				int IVs[] = {31,0,31,31,31,31};
				int EVs[] = {96,0,0,196,0,216};
				
				Move[] moves = {new Move(MoveMap.moveMap.get("Flamethrower")),new Move(MoveMap.moveMap.get("Giga Drain")),new Move(MoveMap.moveMap.get("Focus Blast")),new Move(MoveMap.moveMap.get("Roost"))};
				Pokemon member = new Pokemon(SpeciesMap.speciesMap.get("Mega Charizard Y"),"Charizard",moves,IVs,EVs,100,Nature.Modest, new AbilityContainer("Drought"), new ItemContainer("Choice Specs"));
				//member.addVolatileStatus(new StatusContainer(-1,100,"Confusion",null));
				member.setPlayerID(0);
				member.setBenchPosition(1);
				playerTeam.add(member);
				member = new Pokemon(SpeciesMap.speciesMap.get("Mega Charizard Y"),"Charizard",moves,IVs,EVs,100,Nature.Modest, new AbilityContainer("Drought"), new ItemContainer("Choice Specs"));
				member.setPlayerID(1);
				member.setBenchPosition(1);
				computerTeam.add(member);
				
				//CREATE TYRANITAR
				int IVs2[] = {31,31,31,31,31,31};
				int EVs2[] = {0,252,0,0,4,252};
				Move[] moves2 = {new Move(MoveMap.moveMap.get("Crunch")),new Move(MoveMap.moveMap.get("Bullet Seed")),new Move(MoveMap.moveMap.get("Flamethrower")),new Move(MoveMap.moveMap.get("Earthquake"))};
				member = new Pokemon(SpeciesMap.speciesMap.get("Tyranitar"),"Serene Grace",moves2,IVs2,EVs2,100,Nature.Jolly, new AbilityContainer("Serene Grace"), new ItemContainer("None"));
				//member.setNonVolatileStatus(new StatusContainer(member.getMaxAtk(),100,"Burn",null));
				member.setPlayerID(0);
				member.setBenchPosition(2);
				playerTeam.add(member);
				member = new Pokemon(SpeciesMap.speciesMap.get("Tyranitar"),"Serene Grace",moves2,IVs2,EVs2,100,Nature.Jolly, new AbilityContainer("Serene Grace"), new ItemContainer("None"));
				member.setPlayerID(1);
				member.setBenchPosition(2);
				computerTeam.add(member);
				
				//CREATE SLOWBRO
				int EVs3[] = {248,0,200,0,52,8};
				Move[] moves3 = {new Move(MoveMap.moveMap.get("Shadow Ball")),new Move(MoveMap.moveMap.get("Scald")),new Move(MoveMap.moveMap.get("Psyshock")),new Move(MoveMap.moveMap.get("Slack Off"))};
				member = new Pokemon(SpeciesMap.speciesMap.get("Mega Slowbro"),"LO Sheer Force",moves3,IVs,EVs3,100,Nature.Bold, new AbilityContainer("Sheer Force"), new ItemContainer("Life Orb"));
				member.setPlayerID(0);
				member.setBenchPosition(3);
				playerTeam.add(member);
				member = new Pokemon(SpeciesMap.speciesMap.get("Mega Slowbro"),"LO Sheer Force",moves3,IVs,EVs3,100,Nature.Bold, new AbilityContainer("Sheer Force"), new ItemContainer("Life Orb"));
				member.setPlayerID(1);
				member.setBenchPosition(3);
				computerTeam.add(member);
				
				//CREATE FERROTHRON
				int IVs4[] = {31,31,31,31,31,0};
				int EVs4[] = {248,0,200,0,52,8};
				Move[] moves4 = {new Move(MoveMap.moveMap.get("Thunder Wave")),new Move(MoveMap.moveMap.get("Will-O-Wisp")),new Move(MoveMap.moveMap.get("Toxic")),new Move(MoveMap.moveMap.get("Thunder"))};
				member = new Pokemon(SpeciesMap.speciesMap.get("Ferrothorn"),"Toxic Poisoned",moves4,IVs4,EVs4,100,Nature.Relaxed, new AbilityContainer("Iron Barbs"), new ItemContainer("None"));
				member.setNonVolatileStatus(new StatusContainer(-1,0,"Toxic Poison",null));
				member.setPlayerID(0);
				member.setBenchPosition(4);
				playerTeam.add(member);
				member = new Pokemon(SpeciesMap.speciesMap.get("Ferrothorn"),"Toxic Poisoned",moves4,IVs4,EVs4,100,Nature.Relaxed, new AbilityContainer("Iron Barbs"), new ItemContainer("None"));
				member.setPlayerID(1);
				member.setBenchPosition(4);
				computerTeam.add(member);
				
				//CREATE LATIOS
				int EVs5[] = {0,0,0,252,4,252};
				Move[] moves5 = {new Move(MoveMap.moveMap.get("Draco Meteor")),new Move(MoveMap.moveMap.get("Psyshock")),new Move(MoveMap.moveMap.get("Recover")),new Move(MoveMap.moveMap.get("Defog"))};
				member = new Pokemon(SpeciesMap.speciesMap.get("Latios"),"Paralyzed",moves5,IVs,EVs5,100,Nature.Timid, new AbilityContainer("Contrary"), new ItemContainer("None"));
				member.setNonVolatileStatus(new StatusContainer(member.getMaxSpeed(),100,"Paralysis",null));
				member.setPlayerID(0);
				member.setBenchPosition(5);
				playerTeam.add(member);
				member = new Pokemon(SpeciesMap.speciesMap.get("Latios"),"Paralyzed",moves5,IVs,EVs5,100,Nature.Timid, new AbilityContainer("Contrary"), new ItemContainer("None"));
				member.setPlayerID(1);
				member.setBenchPosition(5);
				computerTeam.add(member);
				
				//CREATE GLISCOR
				int EVs6[] = {244,40,8,0,96,120};
				Move[] moves6 = {new Move(MoveMap.moveMap.get("Swords Dance")),new Move(MoveMap.moveMap.get("Earthquake")),new Move(MoveMap.moveMap.get("Knock Off")),new Move(MoveMap.moveMap.get("Roost"))};
				member = new Pokemon(SpeciesMap.speciesMap.get("Gliscor"),"Poisoned",moves6,IVs2,EVs6,100,Nature.Careful, new AbilityContainer("Mold Breaker"), new ItemContainer("Life Orb"));
				member.setNonVolatileStatus(new StatusContainer(-1,50,"Poison",null));
				member.setPlayerID(0);
				member.setBenchPosition(6);
				playerTeam.add(member);
				member = new Pokemon(SpeciesMap.speciesMap.get("Gliscor"),"Poisoned",moves6,IVs2,EVs6,100,Nature.Careful, new AbilityContainer("Mold Breaker"), new ItemContainer("Life Orb"));
				member.setPlayerID(1);
				member.setBenchPosition(6);
				computerTeam.add(member);
				
				player = new PokemonTrainer(playerTeam);
				computer = new PokemonTrainer(computerTeam);
				
				Timer timer = new Timer();
				try {
					BattleModel.CreateInstance(owner, player, computer);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BattleModel model = BattleModel.getInstance();
				BattleView view = new BattleView(player.getTrainerID());
				BattleController controller = new BattleController(view,model, player.getTrainerID());
				
				view.setVisible(true);
				closeFrame();
			}
		});
		btnFinalize.setBounds(628, 634, 100, 25);
		contentPane.add(btnFinalize);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu.startup();
				closeFrame();
			}
		});
		btnCancel.setBounds(740, 634, 100, 25);
		contentPane.add(btnCancel);
		
		JLabel naturelbl = new JLabel("Nature");
		naturelbl.setBounds(5, 604, 85, 14);
		contentPane.add(naturelbl);
		
		JComboBox p1_nature = new JComboBox(new Object[]{});
		p1_nature.setBounds(90, 600, 100, 25);
		contentPane.add(p1_nature);
		
		JComboBox p2_nature = new JComboBox(new Object[]{});
		p2_nature.setBounds(220, 600, 100, 25);
		contentPane.add(p2_nature);
		
		JComboBox p3_nature = new JComboBox(new Object[]{});
		p3_nature.setBounds(350, 600, 100, 25);
		contentPane.add(p3_nature);
		
		JComboBox p4_nature = new JComboBox(new Object[]{});
		p4_nature.setBounds(480, 600, 100, 25);
		contentPane.add(p4_nature);
		
		JComboBox p5_nature = new JComboBox(new Object[]{});
		p5_nature.setBounds(610, 600, 100, 25);
		contentPane.add(p5_nature);
		
		JComboBox p6_nature = new JComboBox(new Object[]{});
		p6_nature.setBounds(740, 600, 100, 25);
		contentPane.add(p6_nature);
	}
	
	private void closeFrame()
	{
		this.setVisible(false);
	}
}
