package pokemonBattleSim.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pokemonBattleSim.models.BattleModel;
import pokemonBattleSim.models.MoveMap;
import pokemonBattleSim.models.MoveEffectMap;
import pokemonBattleSim.models.SpeciesMap;
import pokemonBattleSim.models.AbilityMap;
import pokemonBattleSim.models.ItemMap;
import pokemonBattleSim.models.TeamBuilderModel;
import pokemonBattleSim.types.AbilityContainer;
import pokemonBattleSim.types.IPokemonTrainer;
import pokemonBattleSim.types.ItemContainer;
import pokemonBattleSim.types.Move;
import pokemonBattleSim.types.Nature;
import pokemonBattleSim.types.Pokemon;
import pokemonBattleSim.types.PokemonTrainer;
import pokemonBattleSim.types.Species;
import pokemonBattleSim.types.StatusContainer;
import pokemonBattleSim.controllers.AIController;
import pokemonBattleSim.controllers.BattleController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import pokemonBattleSim.types.Gender;


public class TeamBuilderView extends JFrame {

	private JPanel contentPane;
	private JComboBox p1_species;
	private JTextField p1_nickname;
	private JSpinner p1_hp_iv;
	private JSpinner p1_atk_iv;
	private JSpinner p1_def_iv;
	private JSpinner p1_spatk_iv;
	private JSpinner p1_spdef_iv;
	private JSpinner p1_speed_iv;
	private JSpinner p1_hp_ev;
	private JSpinner p1_atk_ev;
	private JSpinner p1_def_ev;
	private JSpinner p1_spatk_ev;
	private JSpinner p1_spdef_ev;
	private JSpinner p1_speed_ev;
	private JComboBox p1_ability;
	private JComboBox p2_species;
	private JTextField p2_nickname;
	private JSpinner p2_hp_iv;
	private JSpinner p2_atk_iv;
	private JSpinner p2_def_iv;
	private JSpinner p2_spatk_iv;
	private JSpinner p2_spdef_iv;
	private JSpinner p2_speed_iv;
	private JSpinner p2_hp_ev;
	private JSpinner p2_atk_ev;
	private JSpinner p2_def_ev;
	private JSpinner p2_spatk_ev;
	private JSpinner p2_spdef_ev;
	private JSpinner p2_speed_ev;
	private JComboBox p3_species;
	private JTextField p3_nickname;
	private JSpinner p3_hp_iv;
	private JSpinner p3_atk_iv;
	private JSpinner p3_def_iv;
	private JSpinner p3_spatk_iv;
	private JSpinner p3_spdef_iv;
	private JSpinner p3_speed_iv;
	private JSpinner p3_hp_ev;
	private JSpinner p3_atk_ev;
	private JSpinner p3_def_ev;
	private JSpinner p3_spatk_ev;
	private JSpinner p3_spdef_ev;
	private JSpinner p3_speed_ev;
	private JComboBox p4_species;
	private JTextField p4_nickname;
	private JSpinner p4_hp_iv;
	private JSpinner p4_atk_iv;
	private JSpinner p4_def_iv;
	private JSpinner p4_spatk_iv;
	private JSpinner p4_spdef_iv;
	private JSpinner p4_speed_iv;
	private JSpinner p4_hp_ev;
	private JSpinner p4_atk_ev;
	private JSpinner p4_def_ev;
	private JSpinner p4_spatk_ev;
	private JSpinner p4_spdef_ev;
	private JSpinner p4_speed_ev;
	private JComboBox p5_species;
	private JTextField p5_nickname;
	private JSpinner p5_hp_iv;
	private JSpinner p5_atk_iv;
	private JSpinner p5_def_iv;
	private JSpinner p5_spatk_iv;
	private JSpinner p5_spdef_iv;
	private JSpinner p5_speed_iv;
	private JSpinner p5_hp_ev;
	private JSpinner p5_atk_ev;
	private JSpinner p5_def_ev;
	private JSpinner p5_spatk_ev;
	private JSpinner p5_spdef_ev;
	private JSpinner p5_speed_ev;
	private JComboBox p6_species;
	private JTextField p6_nickname;
	private JSpinner p6_hp_iv;
	private JSpinner p6_atk_iv;
	private JSpinner p6_def_iv;
	private JSpinner p6_spatk_iv;
	private JSpinner p6_spdef_iv;
	private JSpinner p6_speed_iv;
	private JSpinner p6_hp_ev;
	private JSpinner p6_atk_ev;
	private JSpinner p6_def_ev;
	private JSpinner p6_spatk_ev;
	private JSpinner p6_spdef_ev;
	private JSpinner p6_speed_ev;
	private JButton btnTest;
	private JButton btnCancel;
	private JButton btnFinalize;
	public String moves1;
	public String moves2;
	public String moves3;
	public String moves4;
	public String moves5;
	public String moves6;
	TeamBuilderModel model;
	private JLabel lblItem;
	private JComboBox p1_item;
	private JComboBox p2_item;
	private JComboBox p3_item;
	private JComboBox p4_item;
	private JComboBox p5_item;
	private JComboBox p6_item;
	private JComboBox p1_move1;
	private JComboBox p1_move2;
	private JComboBox p1_move3;
	private JComboBox p1_move4;
	private JComboBox p2_move1;
	private JComboBox p2_move2;
	private JComboBox p2_move3;
	private JComboBox p2_move4;
	private JComboBox p3_move1;
	private JComboBox p3_move2;
	private JComboBox p3_move3;
	private JComboBox p3_move4;
	private JComboBox p4_move1;
	private JComboBox p4_move2;
	private JComboBox p4_move3;
	private JComboBox p4_move4;
	private JComboBox p5_move1;
	private JComboBox p5_move2;
	private JComboBox p5_move3;
	private JComboBox p5_move4;
	private JComboBox p6_move1;
	private JComboBox p6_move2;
	private JComboBox p6_move3;
	private JComboBox p6_move4;
	private JComboBox p2_ability;
	private JComboBox p3_ability;
	private JComboBox p4_ability;
	private JComboBox p5_ability;
	private JComboBox p6_ability;
	private JSpinner p1_level;
	private JSpinner p2_level;
	private JSpinner p3_level;
	private JSpinner p4_level;
	private JSpinner p5_level;
	private JSpinner p6_level;
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
	/**
	 * Create the frame.
	 */
	public TeamBuilderView() {
	
		String[] speciesList = new String[SpeciesMap.speciesMap.size()];
		int i = 0;
		for(String poke : SpeciesMap.speciesMap.keySet())
		{
			speciesList[i] = poke;
			i++;
		}
		Arrays.sort(speciesList);
		
		String[] abilityList = new String[AbilityMap.abilityMap.size()];
		i = 0;
		for(String abil : AbilityMap.abilityMap.keySet())
		{
			abilityList[i] = abil;
			i++;
		}
		Arrays.sort(abilityList);
		
		String[] itemList = new String[ItemMap.itemMap.size()];
		i = 0;
		for(String item : ItemMap.itemMap.keySet())
		{
			itemList[i] = item;
			i++;
		}
		Arrays.sort(itemList);
		
		String[] moveList = new String[MoveEffectMap.effectMap.size()];
		i = 0;
		for(String move : MoveEffectMap.effectMap.keySet())
		{
			moveList[i] = move;
			i++;
		}
		Arrays.sort(moveList);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 816);
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
		
		p1_species = new JComboBox(new Object[]{});
		p1_species.setModel(new DefaultComboBoxModel(speciesList));
		p1_species.setBounds(90, 25, 100, 25);
		contentPane.add(p1_species);
		
		p1_nickname = new JTextField(30);
		p1_nickname.setToolTipText("Pokemon");
		p1_nickname.setBounds(90, 55, 100, 25);
		contentPane.add(p1_nickname);
		
		p1_move1 = new JComboBox(new Object[]{});
		p1_move1.setModel(new DefaultComboBoxModel(moveList));
		p1_move1.setBounds(90, 95, 100, 25);
		contentPane.add(p1_move1);
		
		p1_move2 = new JComboBox(new Object[]{});
		p1_move2.setModel(new DefaultComboBoxModel(moveList));
		p1_move2.setBounds(90, 125, 100, 25);
		contentPane.add(p1_move2);
		
		p1_move3 = new JComboBox(new Object[]{});
		p1_move3.setModel(new DefaultComboBoxModel(moveList));
		p1_move3.setBounds(90, 155, 100, 25);
		contentPane.add(p1_move3);
		
		p1_move4 = new JComboBox(new Object[]{});
		p1_move4.setModel(new DefaultComboBoxModel(moveList));
		p1_move4.setBounds(90, 185, 100, 25);
		contentPane.add(p1_move4);
		
		p1_hp_iv = new JSpinner();
		p1_hp_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p1_hp_iv.setBounds(90, 317, 100, 25);
		contentPane.add(p1_hp_iv);
		
		p1_atk_iv = new JSpinner();
		p1_atk_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p1_atk_iv.setBounds(90, 342, 100, 25);
		contentPane.add(p1_atk_iv);
		
		p1_def_iv = new JSpinner();
		p1_def_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p1_def_iv.setBounds(90, 367, 100, 25);
		contentPane.add(p1_def_iv);
		
		p1_spatk_iv = new JSpinner();
		p1_spatk_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p1_spatk_iv.setBounds(90, 392, 100, 25);
		contentPane.add(p1_spatk_iv);
		
		p1_spdef_iv = new JSpinner();
		p1_spdef_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p1_spdef_iv.setBounds(90, 417, 100, 25);
		contentPane.add(p1_spdef_iv);
		
		p1_speed_iv = new JSpinner();
		p1_speed_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p1_speed_iv.setBounds(90, 442, 100, 25);
		contentPane.add(p1_speed_iv);
		
		JLabel pokelabel1 = new JLabel("Pokemon 1");
		pokelabel1.setBounds(90, 5, 100, 25);
		contentPane.add(pokelabel1);
		
		JLabel lblIndividualValuesindividual = new JLabel("Individual Values (Individual Max of 31)");
		lblIndividualValuesindividual.setBounds(90, 291, 261, 14);
		contentPane.add(lblIndividualValuesindividual);
		
		JLabel lblEffortValuesindividual = new JLabel("Effort Values (Individual Max of 252 - Max of 510)");
		lblEffortValuesindividual.setBounds(90, 471, 461, 14);
		contentPane.add(lblEffortValuesindividual);
		
		p1_hp_ev = new JSpinner();
		p1_hp_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p1_hp_ev.setBounds(90, 487, 100, 25);
		contentPane.add(p1_hp_ev);
		
		p1_atk_ev = new JSpinner();
		p1_atk_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p1_atk_ev.setBounds(90, 512, 100, 25);
		contentPane.add(p1_atk_ev);
		
		p1_def_ev = new JSpinner();
		p1_def_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p1_def_ev.setBounds(90, 537, 100, 25);
		contentPane.add(p1_def_ev);
		
		p1_spatk_ev = new JSpinner();
		p1_spatk_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p1_spatk_ev.setBounds(90, 562, 100, 25);
		contentPane.add(p1_spatk_ev);
		
		p1_spdef_ev = new JSpinner();
		p1_spdef_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p1_spdef_ev.setBounds(90, 587, 100, 25);
		contentPane.add(p1_spdef_ev);
		
		p1_speed_ev = new JSpinner();
		p1_speed_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p1_speed_ev.setBounds(90, 612, 100, 25);
		contentPane.add(p1_speed_ev);
		
		p1_ability = new JComboBox(new Object[]{});
		p1_ability.setModel(new DefaultComboBoxModel(abilityList));
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
		lblHp.setBounds(5, 322, 46, 14);
		contentPane.add(lblHp);
		
		JLabel lblAttack = new JLabel("Attack");
		lblAttack.setBounds(5, 347, 46, 14);
		contentPane.add(lblAttack);
		
		JLabel lblDefense = new JLabel("Defense");
		lblDefense.setBounds(5, 372, 73, 14);
		contentPane.add(lblDefense);
		
		JLabel lblSpecialAttack = new JLabel("Special Atk");
		lblSpecialAttack.setBounds(5, 397, 85, 14);
		contentPane.add(lblSpecialAttack);
		
		JLabel lblSepcialDefense = new JLabel("Special Def");
		lblSepcialDefense.setBounds(5, 422, 85, 14);
		contentPane.add(lblSepcialDefense);
		
		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setBounds(5, 447, 46, 14);
		contentPane.add(lblSpeed);
		
		JLabel label = new JLabel("Speed");
		label.setBounds(5, 617, 46, 14);
		contentPane.add(label);
		
		JLabel lblSpecialDef = new JLabel("Special Def");
		lblSpecialDef.setBounds(5, 592, 85, 14);
		contentPane.add(lblSpecialDef);
		
		JLabel lblSpecialAtk = new JLabel("Special Atk");
		lblSpecialAtk.setBounds(5, 567, 85, 14);
		contentPane.add(lblSpecialAtk);
		
		JLabel label_3 = new JLabel("Defense");
		label_3.setBounds(5, 542, 85, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Attack");
		label_4.setBounds(5, 517, 46, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("HP");
		label_5.setBounds(5, 492, 46, 14);
		contentPane.add(label_5);
		
		p2_species = new JComboBox(new Object[]{});
		p2_species.setModel(new DefaultComboBoxModel(speciesList));
		p2_species.setToolTipText("Pokemon");
		p2_species.setBounds(220, 25, 100, 25);
		contentPane.add(p2_species);
		
		p2_nickname = new JTextField(30);
		p2_nickname.setToolTipText("Pokemon");
		p2_nickname.setBounds(220, 55, 100, 25);
		contentPane.add(p2_nickname);
		
		p2_move1 = new JComboBox(new Object[]{});
		p2_move1.setBounds(220, 95, 100, 25);
		p2_move1.setModel(new DefaultComboBoxModel(moveList));
		contentPane.add(p2_move1);
		
		p2_move2 = new JComboBox(new Object[]{});
		p2_move2.setBounds(220, 125, 100, 25);
		p2_move2.setModel(new DefaultComboBoxModel(moveList));
		contentPane.add(p2_move2);
		
		p2_move3 = new JComboBox(new Object[]{});
		p2_move3.setBounds(220, 155, 100, 25);
		p2_move3.setModel(new DefaultComboBoxModel(moveList));
		contentPane.add(p2_move3);
		
		p2_move4 = new JComboBox(new Object[]{});
		p2_move4.setBounds(220, 185, 100, 25);
		p2_move4.setModel(new DefaultComboBoxModel(moveList));
		contentPane.add(p2_move4);
		
		p2_ability = new JComboBox(new Object[]{});
		p2_ability.setModel(new DefaultComboBoxModel(abilityList));
		p2_ability.setBounds(220, 215, 100, 25);
		contentPane.add(p2_ability);
		
		p2_hp_iv = new JSpinner();
		p2_hp_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p2_hp_iv.setBounds(220, 317, 100, 25);
		contentPane.add(p2_hp_iv);
		
		p2_atk_iv = new JSpinner();
		p2_atk_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p2_atk_iv.setBounds(220, 342, 100, 25);
		contentPane.add(p2_atk_iv);
		
		p2_def_iv = new JSpinner();
		p2_def_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p2_def_iv.setBounds(220, 367, 100, 25);
		contentPane.add(p2_def_iv);
		
		p2_spatk_iv = new JSpinner();
		p2_spatk_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p2_spatk_iv.setBounds(220, 392, 100, 25);
		contentPane.add(p2_spatk_iv);
		
		p2_spdef_iv = new JSpinner();
		p2_spdef_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p2_spdef_iv.setBounds(220, 417, 100, 25);
		contentPane.add(p2_spdef_iv);
		
		p2_speed_iv = new JSpinner();
		p2_speed_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p2_speed_iv.setBounds(220, 442, 100, 25);
		contentPane.add(p2_speed_iv);
		
		p2_hp_ev = new JSpinner();
		p2_hp_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p2_hp_ev.setBounds(220, 487, 100, 25);
		contentPane.add(p2_hp_ev);
		
		p2_atk_ev = new JSpinner();
		p2_atk_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p2_atk_ev.setBounds(220, 512, 100, 25);
		contentPane.add(p2_atk_ev);
		
		p2_def_ev = new JSpinner();
		p2_def_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p2_def_ev.setBounds(220, 537, 100, 25);
		contentPane.add(p2_def_ev);
		
		p2_spatk_ev = new JSpinner();
		p2_spatk_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p2_spatk_ev.setBounds(220, 562, 100, 25);
		contentPane.add(p2_spatk_ev);
		
		p2_spdef_ev = new JSpinner();
		p2_spdef_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p2_spdef_ev.setBounds(220, 587, 100, 25);
		contentPane.add(p2_spdef_ev);
		
		p2_speed_ev = new JSpinner();
		p2_speed_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p2_speed_ev.setBounds(220, 612, 100, 25);
		contentPane.add(p2_speed_ev);
		
		p3_species = new JComboBox(new Object[]{});
		p3_species.setModel(new DefaultComboBoxModel(speciesList));
		p3_species.setToolTipText("Pokemon");
		p3_species.setBounds(350, 25, 100, 25);
		contentPane.add(p3_species);
		
		p3_nickname = new JTextField(30);
		p3_nickname.setToolTipText("Pokemon");
		p3_nickname.setBounds(350, 55, 100, 25);
		contentPane.add(p3_nickname);
		
		p3_move1 = new JComboBox(new Object[]{});
		p3_move1.setModel(new DefaultComboBoxModel(moveList));
		p3_move1.setBounds(350, 95, 100, 25);
		contentPane.add(p3_move1);
		
		p3_move2 = new JComboBox(new Object[]{});
		p3_move2.setModel(new DefaultComboBoxModel(moveList));
		p3_move2.setBounds(350, 125, 100, 25);
		contentPane.add(p3_move2);
		
		p3_move3 = new JComboBox(new Object[]{});
		p3_move3.setModel(new DefaultComboBoxModel(moveList));
		p3_move3.setBounds(350, 155, 100, 25);
		contentPane.add(p3_move3);
		
		p3_move4 = new JComboBox(new Object[]{});
		p3_move4.setModel(new DefaultComboBoxModel(moveList));
		p3_move4.setBounds(350, 185, 100, 25);
		contentPane.add(p3_move4);
		
		p3_ability = new JComboBox(new Object[]{});
		p3_ability.setModel(new DefaultComboBoxModel(abilityList));
		p3_ability.setBounds(350, 215, 100, 25);
		contentPane.add(p3_ability);
		
		p3_hp_iv = new JSpinner();
		p3_hp_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p3_hp_iv.setBounds(350, 317, 100, 25);
		contentPane.add(p3_hp_iv);
		
		p3_atk_iv = new JSpinner();
		p3_atk_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p3_atk_iv.setBounds(350, 342, 100, 25);
		contentPane.add(p3_atk_iv);
		
		p3_def_iv = new JSpinner();
		p3_def_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p3_def_iv.setBounds(350, 367, 100, 25);
		contentPane.add(p3_def_iv);
		
		p3_spatk_iv = new JSpinner();
		p3_spatk_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p3_spatk_iv.setBounds(350, 392, 100, 25);
		contentPane.add(p3_spatk_iv);
		
		p3_spdef_iv = new JSpinner();
		p3_spdef_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p3_spdef_iv.setBounds(350, 417, 100, 25);
		contentPane.add(p3_spdef_iv);
		
		p3_speed_iv = new JSpinner();
		p3_speed_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p3_speed_iv.setBounds(350, 442, 100, 25);
		contentPane.add(p3_speed_iv);
		
		p3_hp_ev = new JSpinner();
		p3_hp_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p3_hp_ev.setBounds(350, 487, 100, 25);
		contentPane.add(p3_hp_ev);
		
		p3_atk_ev = new JSpinner();
		p3_atk_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p3_atk_ev.setBounds(350, 512, 100, 25);
		contentPane.add(p3_atk_ev);
		
		p3_def_ev = new JSpinner();
		p3_def_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p3_def_ev.setBounds(350, 537, 100, 25);
		contentPane.add(p3_def_ev);
		
		p3_spatk_ev = new JSpinner();
		p3_spatk_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p3_spatk_ev.setBounds(350, 562, 100, 25);
		contentPane.add(p3_spatk_ev);
		
		p3_spdef_ev = new JSpinner();
		p3_spdef_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p3_spdef_ev.setBounds(350, 587, 100, 25);
		contentPane.add(p3_spdef_ev);
		
		p3_speed_ev = new JSpinner();
		p3_speed_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p3_speed_ev.setBounds(350, 612, 100, 25);
		contentPane.add(p3_speed_ev);
		
		p4_species = new JComboBox(new Object[]{});
		p4_species.setModel(new DefaultComboBoxModel(speciesList));
		p4_species.setToolTipText("Pokemon");
		p4_species.setBounds(480, 25, 100, 25);
		contentPane.add(p4_species);
		
		p4_nickname = new JTextField(30);
		p4_nickname.setToolTipText("Pokemon");
		p4_nickname.setBounds(480, 55, 100, 25);
		contentPane.add(p4_nickname);
		
		p4_move1 = new JComboBox(new Object[]{});
		p4_move1.setModel(new DefaultComboBoxModel(moveList));
		p4_move1.setBounds(480, 95, 100, 25);
		contentPane.add(p4_move1);
		
		p4_move2 = new JComboBox(new Object[]{});
		p4_move2.setModel(new DefaultComboBoxModel(moveList));
		p4_move2.setBounds(480, 125, 100, 25);
		contentPane.add(p4_move2);
		
		p4_move3 = new JComboBox(new Object[]{});
		p4_move3.setModel(new DefaultComboBoxModel(moveList));
		p4_move3.setBounds(480, 155, 100, 25);
		contentPane.add(p4_move3);
		
		p4_move4 = new JComboBox(new Object[]{});
		p4_move4.setModel(new DefaultComboBoxModel(moveList));
		p4_move4.setBounds(480, 185, 100, 25);
		contentPane.add(p4_move4);
		
		p4_ability = new JComboBox(new Object[]{});
		p4_ability.setModel(new DefaultComboBoxModel(abilityList));
		p4_ability.setBounds(480, 215, 100, 25);
		contentPane.add(p4_ability);
		
		p4_hp_iv = new JSpinner();
		p4_hp_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p4_hp_iv.setBounds(480, 317, 100, 25);
		contentPane.add(p4_hp_iv);
		
		p4_atk_iv = new JSpinner();
		p4_atk_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p4_atk_iv.setBounds(480, 342, 100, 25);
		contentPane.add(p4_atk_iv);
		
		p4_def_iv = new JSpinner();
		p4_def_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p4_def_iv.setBounds(480, 367, 100, 25);
		contentPane.add(p4_def_iv);
		
		p4_spatk_iv = new JSpinner();
		p4_spatk_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p4_spatk_iv.setBounds(480, 392, 100, 25);
		contentPane.add(p4_spatk_iv);
		
		p4_spdef_iv = new JSpinner();
		p4_spdef_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p4_spdef_iv.setBounds(480, 417, 100, 25);
		contentPane.add(p4_spdef_iv);
		
		p4_speed_iv = new JSpinner();
		p4_speed_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p4_speed_iv.setBounds(480, 442, 100, 25);
		contentPane.add(p4_speed_iv);
		
		p4_hp_ev = new JSpinner();
		p4_hp_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p4_hp_ev.setBounds(480, 487, 100, 25);
		contentPane.add(p4_hp_ev);
		
		p4_atk_ev = new JSpinner();
		p4_atk_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p4_atk_ev.setBounds(480, 512, 100, 25);
		contentPane.add(p4_atk_ev);
		
		p4_def_ev = new JSpinner();
		p4_def_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p4_def_ev.setBounds(480, 537, 100, 25);
		contentPane.add(p4_def_ev);
		
		p4_spatk_ev = new JSpinner();
		p4_spatk_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p4_spatk_ev.setBounds(480, 562, 100, 25);
		contentPane.add(p4_spatk_ev);
		
		p4_spdef_ev = new JSpinner();
		p4_spdef_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p4_spdef_ev.setBounds(480, 587, 100, 25);
		contentPane.add(p4_spdef_ev);
		
		p4_speed_ev = new JSpinner();
		p4_speed_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p4_speed_ev.setBounds(480, 612, 100, 25);
		contentPane.add(p4_speed_ev);
		
		p5_species = new JComboBox(new Object[]{});
		p5_species.setModel(new DefaultComboBoxModel(speciesList));
		p5_species.setToolTipText("Pokemon");
		p5_species.setBounds(610, 25, 100, 25);
		contentPane.add(p5_species);
		
		p5_nickname = new JTextField(30);
		p5_nickname.setToolTipText("Pokemon");
		p5_nickname.setBounds(610, 55, 100, 25);
		contentPane.add(p5_nickname);
		
		p5_move1 = new JComboBox(new Object[]{});
		p5_move1.setModel(new DefaultComboBoxModel(moveList));
		p5_move1.setBounds(610, 95, 100, 25);
		contentPane.add(p5_move1);
		
		p5_move2 = new JComboBox(new Object[]{});
		p5_move2.setModel(new DefaultComboBoxModel(moveList));
		p5_move2.setBounds(610, 125, 100, 25);
		contentPane.add(p5_move2);
		
		p5_move3 = new JComboBox(new Object[]{});
		p5_move3.setModel(new DefaultComboBoxModel(moveList));
		p5_move3.setBounds(610, 155, 100, 25);
		contentPane.add(p5_move3);
		
		p5_move4 = new JComboBox(new Object[]{});
		p5_move4.setModel(new DefaultComboBoxModel(moveList));
		p5_move4.setBounds(610, 185, 100, 25);
		contentPane.add(p5_move4);
		
		p5_ability = new JComboBox(new Object[]{});
		p5_ability.setModel(new DefaultComboBoxModel(abilityList));
		p5_ability.setBounds(610, 215, 100, 25);
		contentPane.add(p5_ability);
		
		p5_hp_iv = new JSpinner();
		p5_hp_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p5_hp_iv.setBounds(610, 317, 100, 25);
		contentPane.add(p5_hp_iv);
		
		p5_atk_iv = new JSpinner();
		p5_atk_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p5_atk_iv.setBounds(610, 342, 100, 25);
		contentPane.add(p5_atk_iv);
		
		p5_def_iv = new JSpinner();
		p5_def_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p5_def_iv.setBounds(610, 367, 100, 25);
		contentPane.add(p5_def_iv);
		
		p5_spatk_iv = new JSpinner();
		p5_spatk_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p5_spatk_iv.setBounds(610, 392, 100, 25);
		contentPane.add(p5_spatk_iv);
		
		p5_spdef_iv = new JSpinner();
		p5_spdef_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p5_spdef_iv.setBounds(610, 417, 100, 25);
		contentPane.add(p5_spdef_iv);
		
		p5_speed_iv = new JSpinner();
		p5_speed_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p5_speed_iv.setBounds(610, 442, 100, 25);
		contentPane.add(p5_speed_iv);
		
		p5_hp_ev = new JSpinner();
		p5_hp_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p5_hp_ev.setBounds(610, 487, 100, 25);
		contentPane.add(p5_hp_ev);
		
		p5_atk_ev = new JSpinner();
		p5_atk_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p5_atk_ev.setBounds(610, 512, 100, 25);
		contentPane.add(p5_atk_ev);
		
		p5_def_ev = new JSpinner();
		p5_def_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p5_def_ev.setBounds(610, 537, 100, 25);
		contentPane.add(p5_def_ev);
		
		p5_spatk_ev = new JSpinner();
		p5_spatk_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p5_spatk_ev.setBounds(610, 562, 100, 25);
		contentPane.add(p5_spatk_ev);
		
		p5_spdef_ev = new JSpinner();
		p5_spdef_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p5_spdef_ev.setBounds(610, 587, 100, 25);
		contentPane.add(p5_spdef_ev);
		
		p5_speed_ev = new JSpinner();
		p5_speed_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p5_speed_ev.setBounds(610, 612, 100, 25);
		contentPane.add(p5_speed_ev);
		
		p6_species = new JComboBox(new Object[]{});
		p6_species.setModel(new DefaultComboBoxModel(speciesList));
		p6_species.setToolTipText("Pokemon");
		p6_species.setBounds(740, 25, 100, 25);
		contentPane.add(p6_species);
		
		p6_nickname = new JTextField(30);
		p6_nickname.setToolTipText("Pokemon");
		p6_nickname.setBounds(740, 55, 100, 25);
		contentPane.add(p6_nickname);
		
		p6_move1 = new JComboBox(new Object[]{});
		p6_move1.setModel(new DefaultComboBoxModel(moveList));
		p6_move1.setBounds(740, 95, 100, 25);
		contentPane.add(p6_move1);
		
		p6_move2 = new JComboBox(new Object[]{});
		p6_move2.setModel(new DefaultComboBoxModel(moveList));
		p6_move2.setBounds(740, 125, 100, 25);
		contentPane.add(p6_move2);
		
		p6_move3 = new JComboBox(new Object[]{});
		p6_move3.setModel(new DefaultComboBoxModel(moveList));
		p6_move3.setBounds(740, 155, 100, 25);
		contentPane.add(p6_move3);
		
		p6_move4 = new JComboBox(new Object[]{});
		p6_move4.setModel(new DefaultComboBoxModel(moveList));
		p6_move4.setBounds(740, 185, 100, 25);
		contentPane.add(p6_move4);
		
		p6_ability = new JComboBox(new Object[]{});
		p6_ability.setModel(new DefaultComboBoxModel(abilityList));
		p6_ability.setBounds(740, 215, 100, 25);
		contentPane.add(p6_ability);
		
		p6_hp_iv = new JSpinner();
		p6_hp_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p6_hp_iv.setBounds(740, 317, 100, 25);
		contentPane.add(p6_hp_iv);
		
		p6_atk_iv = new JSpinner();
		p6_atk_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p6_atk_iv.setBounds(740, 342, 100, 25);
		contentPane.add(p6_atk_iv);
		
		p6_def_iv = new JSpinner();
		p6_def_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p6_def_iv.setBounds(740, 367, 100, 25);
		contentPane.add(p6_def_iv);
		
		p6_spatk_iv = new JSpinner();
		p6_spatk_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p6_spatk_iv.setBounds(740, 392, 100, 25);
		contentPane.add(p6_spatk_iv);
		
		p6_spdef_iv = new JSpinner();
		p6_spdef_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p6_spdef_iv.setBounds(740, 417, 100, 25);
		contentPane.add(p6_spdef_iv);
		
		p6_speed_iv = new JSpinner();
		p6_speed_iv.setModel(new SpinnerNumberModel(31, 0, 31, 31));
		p6_speed_iv.setBounds(740, 442, 100, 25);
		contentPane.add(p6_speed_iv);
		
		p6_hp_ev = new JSpinner();
		p6_hp_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p6_hp_ev.setBounds(740, 487, 100, 25);
		contentPane.add(p6_hp_ev);
		
		p6_atk_ev = new JSpinner();
		p6_atk_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p6_atk_ev.setBounds(740, 512, 100, 25);
		contentPane.add(p6_atk_ev);
		
		p6_def_ev = new JSpinner();
		p6_def_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p6_def_ev.setBounds(740, 537, 100, 25);
		contentPane.add(p6_def_ev);
		
		p6_spatk_ev = new JSpinner();
		p6_spatk_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p6_spatk_ev.setBounds(740, 562, 100, 25);
		contentPane.add(p6_spatk_ev);
		
		p6_spdef_ev = new JSpinner();
		p6_spdef_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p6_spdef_ev.setBounds(740, 587, 100, 25);
		contentPane.add(p6_spdef_ev);
		
		p6_speed_ev = new JSpinner();
		p6_speed_ev.setModel(new SpinnerNumberModel(0, 0, 252, 4));
		p6_speed_ev.setBounds(740, 612, 100, 25);
		contentPane.add(p6_speed_ev);
		
		JLabel naturelbl = new JLabel("Nature");
		naturelbl.setBounds(5, 656, 85, 14);
		contentPane.add(naturelbl);
		
		JComboBox p1_nature = new JComboBox(new Object[]{});
		p1_nature.setModel(new DefaultComboBoxModel(Nature.values()));
		p1_nature.setBounds(90, 652, 100, 25);
		contentPane.add(p1_nature);
		
		JComboBox p2_nature = new JComboBox(new Object[]{});
		p2_nature.setModel(new DefaultComboBoxModel(Nature.values()));
		p2_nature.setBounds(220, 652, 100, 25);
		contentPane.add(p2_nature);
		
		JComboBox p3_nature = new JComboBox(new Object[]{});
		p3_nature.setModel(new DefaultComboBoxModel(Nature.values()));
		p3_nature.setBounds(350, 652, 100, 25);
		contentPane.add(p3_nature);
		
		JComboBox p4_nature = new JComboBox(new Object[]{});
		p4_nature.setModel(new DefaultComboBoxModel(Nature.values()));
		p4_nature.setBounds(480, 652, 100, 25);
		contentPane.add(p4_nature);
		
		JComboBox p5_nature = new JComboBox(new Object[]{});
		p5_nature.setModel(new DefaultComboBoxModel(Nature.values()));
		p5_nature.setBounds(610, 652, 100, 25);
		contentPane.add(p5_nature);
		
		JComboBox p6_nature = new JComboBox(new Object[]{});
		p6_nature.setModel(new DefaultComboBoxModel(Nature.values()));
		p6_nature.setBounds(740, 652, 100, 25);
		contentPane.add(p6_nature);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setBounds(5, 682, 85, 14);
		contentPane.add(lblLevel);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(5, 708, 85, 14);
		contentPane.add(lblGender);
		
		p1_level = new JSpinner();
		p1_level.setModel(new SpinnerNumberModel(100, 1, 100, 50));
		p1_level.setBounds(90, 676, 100, 25);
		contentPane.add(p1_level);
		
		p2_level = new JSpinner();
		p2_level.setModel(new SpinnerNumberModel(100, 1, 100, 50));
		p2_level.setBounds(220, 676, 100, 25);
		contentPane.add(p2_level);
		
		p3_level = new JSpinner();
		p3_level.setModel(new SpinnerNumberModel(100, 1, 100, 50));
		p3_level.setBounds(350, 676, 100, 25);
		contentPane.add(p3_level);
		
		p4_level = new JSpinner();
		p4_level.setModel(new SpinnerNumberModel(100, 1, 100, 50));
		p4_level.setBounds(480, 676, 100, 25);
		contentPane.add(p4_level);
		
		p5_level = new JSpinner();
		p5_level.setModel(new SpinnerNumberModel(100, 1, 100, 50));
		p5_level.setBounds(610, 676, 100, 25);
		contentPane.add(p5_level);
		
		p6_level = new JSpinner();
		p6_level.setModel(new SpinnerNumberModel(100, 1, 100, 50));
		p6_level.setBounds(740, 676, 100, 25);
		contentPane.add(p6_level);
		
		JComboBox p1_gender = new JComboBox(new Object[]{});
		p1_gender.setModel(new DefaultComboBoxModel(Gender.values()));
		p1_gender.setBounds(90, 703, 100, 25);
		contentPane.add(p1_gender);
		
		JComboBox p2_gender = new JComboBox(new Object[]{});
		p2_gender.setModel(new DefaultComboBoxModel(Gender.values()));
		p2_gender.setBounds(220, 703, 100, 25);
		contentPane.add(p2_gender);
		
		JComboBox p3_gender = new JComboBox(new Object[]{});
		p3_gender.setModel(new DefaultComboBoxModel(Gender.values()));
		p3_gender.setBounds(350, 703, 100, 25);
		contentPane.add(p3_gender);
		
		JComboBox p4_gender = new JComboBox(new Object[]{});
		p4_gender.setModel(new DefaultComboBoxModel(Gender.values()));
		p4_gender.setBounds(480, 703, 100, 25);
		contentPane.add(p4_gender);
		
		JComboBox p5_gender = new JComboBox(new Object[]{});
		p5_gender.setModel(new DefaultComboBoxModel(Gender.values()));
		p5_gender.setBounds(610, 703, 100, 25);
		contentPane.add(p5_gender);
		
		JComboBox p6_gender = new JComboBox(new Object[]{});
		p6_gender.setModel(new DefaultComboBoxModel(Gender.values()));
		p6_gender.setBounds(740, 703, 100, 25);
		contentPane.add(p6_gender);
		
		lblItem = new JLabel("Item");
		lblItem.setBounds(5, 246, 46, 14);
		contentPane.add(lblItem);
		
		p1_item = new JComboBox(new Object[]{});
		p1_item.setModel(new DefaultComboBoxModel(itemList));
		p1_item.setBounds(90, 242, 100, 25);
		contentPane.add(p1_item);
		
		p2_item = new JComboBox(new Object[]{});
		p2_item.setModel(new DefaultComboBoxModel(itemList));
		p2_item.setBounds(220, 241, 100, 25);
		contentPane.add(p2_item);
		
		p3_item = new JComboBox(new Object[]{});
		p3_item.setModel(new DefaultComboBoxModel(itemList));
		p3_item.setBounds(350, 241, 100, 25);
		contentPane.add(p3_item);
		
		p4_item = new JComboBox(new Object[]{});
		p4_item.setModel(new DefaultComboBoxModel(itemList));
		p4_item.setBounds(480, 241, 100, 25);
		contentPane.add(p4_item);
		
		p5_item = new JComboBox(new Object[]{});
		p5_item.setModel(new DefaultComboBoxModel(itemList));
		p5_item.setBounds(610, 241, 100, 25);
		contentPane.add(p5_item);
		
		p6_item = new JComboBox(new Object[]{});
		p6_item.setModel(new DefaultComboBoxModel(itemList));
		p6_item.setBounds(740, 241, 100, 25);
		contentPane.add(p6_item);
		
		btnFinalize = new JButton("Finalize");
		btnFinalize.setSize(100, 25);
		btnFinalize.setLocation(630, 740);
		btnFinalize.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		if(!testValidity())
        			return;
        		// This is the main entry point to the program, will use other classes
				Object owner = new Object(); //may need to be static?
				IPokemonTrainer player;
				IPokemonTrainer computer;
				ArrayList<Pokemon> playerTeam = new ArrayList<>();
				ArrayList<Pokemon> computerTeam = new ArrayList<>();
				
				//Variables used to create the pokemon
				int IVs[] = new int[6];
				int EVs[] = new int[6];
				Move moves[] = new Move[4];
				Pokemon member;
				String species, nickname;
				int level;
				Nature nature;
				Gender gender;
				String ability, item;
				
				/**
				 * Create player team
				 */
				
				//Create 1st Pokemon
				IVs[0] = (int)p1_hp_iv.getModel().getValue();
				IVs[1] = (int)p1_atk_iv.getModel().getValue();
				IVs[2] = (int)p1_def_iv.getModel().getValue();
				IVs[3] = (int)p1_spatk_iv.getModel().getValue();
				IVs[4] = (int)p1_spdef_iv.getModel().getValue();
				IVs[5] = (int)p1_speed_iv.getModel().getValue();
				
				EVs[0] = (int)p1_hp_ev.getModel().getValue();
				EVs[1] = (int)p1_atk_ev.getModel().getValue();
				EVs[2] = (int)p1_def_ev.getModel().getValue();
				EVs[3] = (int)p1_spatk_ev.getModel().getValue();
				EVs[4] = (int)p1_spdef_ev.getModel().getValue();
				EVs[5] = (int)p1_speed_ev.getModel().getValue();
				
				moves[0] = new Move(MoveMap.moveMap.get((String)p1_move1.getSelectedItem()));
				moves[1] = new Move(MoveMap.moveMap.get((String)p1_move2.getSelectedItem()));
				moves[2] = new Move(MoveMap.moveMap.get((String)p1_move3.getSelectedItem()));
				moves[3] = new Move(MoveMap.moveMap.get((String)p1_move4.getSelectedItem()));
				
				species = p1_species.getSelectedItem().toString();
				nickname = p1_nickname.getText();
				item = (String)p1_item.getSelectedItem();
				ability = (String)p1_ability.getSelectedItem();
				level = (int)p1_level.getModel().getValue();
				nature = (Nature)p1_nature.getSelectedItem();
				gender = (Gender)p1_gender.getSelectedItem();
				
				member = new Pokemon(SpeciesMap.speciesMap.get(species),nickname,moves,IVs,EVs,level,nature, new AbilityContainer(ability), new ItemContainer(item));
				member.setPlayerID(0);
				member.setBenchPosition(0);
				member.setGender(gender);
				playerTeam.add(member);
				
				//Create 2nd Pokemon
				IVs[0] = (int)p2_hp_iv.getModel().getValue();
				IVs[1] = (int)p2_atk_iv.getModel().getValue();
				IVs[2] = (int)p2_def_iv.getModel().getValue();
				IVs[3] = (int)p2_spatk_iv.getModel().getValue();
				IVs[4] = (int)p2_spdef_iv.getModel().getValue();
				IVs[5] = (int)p2_speed_iv.getModel().getValue();
				
				EVs[0] = (int)p2_hp_ev.getModel().getValue();
				EVs[1] = (int)p2_atk_ev.getModel().getValue();
				EVs[2] = (int)p2_def_ev.getModel().getValue();
				EVs[3] = (int)p2_spatk_ev.getModel().getValue();
				EVs[4] = (int)p2_spdef_ev.getModel().getValue();
				EVs[5] = (int)p2_speed_ev.getModel().getValue();
				
				moves[0] = new Move(MoveMap.moveMap.get((String)p2_move1.getSelectedItem()));
				moves[1] = new Move(MoveMap.moveMap.get((String)p2_move2.getSelectedItem()));
				moves[2] = new Move(MoveMap.moveMap.get((String)p2_move3.getSelectedItem()));
				moves[3] = new Move(MoveMap.moveMap.get((String)p2_move4.getSelectedItem()));
				
				species = (String)p2_species.getSelectedItem();
				nickname = p2_nickname.getText();
				item = (String)p2_item.getSelectedItem();
				ability = (String)p2_ability.getSelectedItem();
				level = (int)p2_level.getModel().getValue();
				nature = (Nature)p2_nature.getSelectedItem();
				gender = (Gender)p2_gender.getSelectedItem();
				
				member = new Pokemon(SpeciesMap.speciesMap.get(species),nickname,moves,IVs,EVs,level,nature, new AbilityContainer(ability), new ItemContainer(item));
				member.setPlayerID(0);
				member.setBenchPosition(1);
				member.setGender(gender);
				playerTeam.add(member);
				
				//Create 3rd Pokemon
				IVs[0] = (int)p3_hp_iv.getModel().getValue();
				IVs[1] = (int)p3_atk_iv.getModel().getValue();
				IVs[2] = (int)p3_def_iv.getModel().getValue();
				IVs[3] = (int)p3_spatk_iv.getModel().getValue();
				IVs[4] = (int)p3_spdef_iv.getModel().getValue();
				IVs[5] = (int)p3_speed_iv.getModel().getValue();
				
				EVs[0] = (int)p3_hp_ev.getModel().getValue();
				EVs[1] = (int)p3_atk_ev.getModel().getValue();
				EVs[2] = (int)p3_def_ev.getModel().getValue();
				EVs[3] = (int)p3_spatk_ev.getModel().getValue();
				EVs[4] = (int)p3_spdef_ev.getModel().getValue();
				EVs[5] = (int)p3_speed_ev.getModel().getValue();
				
				moves[0] = new Move(MoveMap.moveMap.get((String)p3_move1.getSelectedItem()));
				moves[1] = new Move(MoveMap.moveMap.get((String)p3_move2.getSelectedItem()));
				moves[2] = new Move(MoveMap.moveMap.get((String)p3_move3.getSelectedItem()));
				moves[3] = new Move(MoveMap.moveMap.get((String)p3_move4.getSelectedItem()));
				
				species = (String)p3_species.getSelectedItem();
				nickname = p3_nickname.getText();
				item = (String)p3_item.getSelectedItem();
				ability = (String)p3_ability.getSelectedItem();
				level = (int)p3_level.getModel().getValue();
				nature = (Nature)p3_nature.getSelectedItem();
				gender = (Gender)p3_gender.getSelectedItem();
				
				member = new Pokemon(SpeciesMap.speciesMap.get(species),nickname,moves,IVs,EVs,level,nature, new AbilityContainer(ability), new ItemContainer(item));
				member.setPlayerID(0);
				member.setBenchPosition(2);
				member.setGender(gender);
				playerTeam.add(member);
				
				//Create 4th Pokemon
				IVs[0] = (int)p4_hp_iv.getModel().getValue();
				IVs[1] = (int)p4_atk_iv.getModel().getValue();
				IVs[2] = (int)p4_def_iv.getModel().getValue();
				IVs[3] = (int)p4_spatk_iv.getModel().getValue();
				IVs[4] = (int)p4_spdef_iv.getModel().getValue();
				IVs[5] = (int)p4_speed_iv.getModel().getValue();
				
				EVs[0] = (int)p4_hp_ev.getModel().getValue();
				EVs[1] = (int)p4_atk_ev.getModel().getValue();
				EVs[2] = (int)p4_def_ev.getModel().getValue();
				EVs[3] = (int)p4_spatk_ev.getModel().getValue();
				EVs[4] = (int)p4_spdef_ev.getModel().getValue();
				EVs[5] = (int)p4_speed_ev.getModel().getValue();
				
				moves[0] = new Move(MoveMap.moveMap.get((String)p4_move1.getSelectedItem()));
				moves[1] = new Move(MoveMap.moveMap.get((String)p4_move2.getSelectedItem()));
				moves[2] = new Move(MoveMap.moveMap.get((String)p4_move3.getSelectedItem()));
				moves[3] = new Move(MoveMap.moveMap.get((String)p4_move4.getSelectedItem()));
				
				species = (String)p4_species.getSelectedItem();
				nickname = p4_nickname.getText();
				item = (String)p4_item.getSelectedItem();
				ability = (String)p4_ability.getSelectedItem();
				level = (int)p4_level.getModel().getValue();
				nature = (Nature)p4_nature.getSelectedItem();
				gender = (Gender)p4_gender.getSelectedItem();
				
				member = new Pokemon(SpeciesMap.speciesMap.get(species),nickname,moves,IVs,EVs,level,nature, new AbilityContainer(ability), new ItemContainer(item));
				member.setPlayerID(0);
				member.setBenchPosition(3);
				member.setGender(gender);
				playerTeam.add(member);
				
				//Create 5th Pokemon
				IVs[0] = (int)p5_hp_iv.getModel().getValue();
				IVs[1] = (int)p5_atk_iv.getModel().getValue();
				IVs[2] = (int)p5_def_iv.getModel().getValue();
				IVs[3] = (int)p5_spatk_iv.getModel().getValue();
				IVs[4] = (int)p5_spdef_iv.getModel().getValue();
				IVs[5] = (int)p5_speed_iv.getModel().getValue();
				
				EVs[0] = (int)p5_hp_ev.getModel().getValue();
				EVs[1] = (int)p5_atk_ev.getModel().getValue();
				EVs[2] = (int)p5_def_ev.getModel().getValue();
				EVs[3] = (int)p5_spatk_ev.getModel().getValue();
				EVs[4] = (int)p5_spdef_ev.getModel().getValue();
				EVs[5] = (int)p5_speed_ev.getModel().getValue();
				
				moves[0] = new Move(MoveMap.moveMap.get((String)p5_move1.getSelectedItem()));
				moves[1] = new Move(MoveMap.moveMap.get((String)p5_move2.getSelectedItem()));
				moves[2] = new Move(MoveMap.moveMap.get((String)p5_move3.getSelectedItem()));
				moves[3] = new Move(MoveMap.moveMap.get((String)p5_move4.getSelectedItem()));
				
				species = (String)p5_species.getSelectedItem();
				nickname = p5_nickname.getText();
				item = (String)p5_item.getSelectedItem();
				ability = (String)p5_ability.getSelectedItem();
				level = (int)p5_level.getModel().getValue();
				nature = (Nature)p5_nature.getSelectedItem();
				gender = (Gender)p5_gender.getSelectedItem();
				
				member = new Pokemon(SpeciesMap.speciesMap.get(species),nickname,moves,IVs,EVs,level,nature, new AbilityContainer(ability), new ItemContainer(item));
				member.setPlayerID(0);
				member.setGender(gender);
				member.setBenchPosition(4);
				playerTeam.add(member);
				
				//Create 6th Pokemon
				IVs[0] = (int)p6_hp_iv.getModel().getValue();
				IVs[1] = (int)p6_atk_iv.getModel().getValue();
				IVs[2] = (int)p6_def_iv.getModel().getValue();
				IVs[3] = (int)p6_spatk_iv.getModel().getValue();
				IVs[4] = (int)p6_spdef_iv.getModel().getValue();
				IVs[5] = (int)p6_speed_iv.getModel().getValue();
				
				EVs[0] = (int)p6_hp_ev.getModel().getValue();
				EVs[1] = (int)p6_atk_ev.getModel().getValue();
				EVs[2] = (int)p6_def_ev.getModel().getValue();
				EVs[3] = (int)p6_spatk_ev.getModel().getValue();
				EVs[4] = (int)p6_spdef_ev.getModel().getValue();
				EVs[5] = (int)p6_speed_ev.getModel().getValue();
				
				moves[0] = new Move(MoveMap.moveMap.get((String)p6_move1.getSelectedItem()));
				moves[1] = new Move(MoveMap.moveMap.get((String)p6_move2.getSelectedItem()));
				moves[2] = new Move(MoveMap.moveMap.get((String)p6_move3.getSelectedItem()));
				moves[3] = new Move(MoveMap.moveMap.get((String)p6_move4.getSelectedItem()));
				
				species = (String)p6_species.getSelectedItem();
				nickname = p6_nickname.getText();
				item = (String)p6_item.getSelectedItem();
				ability = (String)p6_ability.getSelectedItem();
				level = (int)p6_level.getModel().getValue();
				nature = (Nature)p6_nature.getSelectedItem();
				gender = (Gender)p6_gender.getSelectedItem();
				
				member = new Pokemon(SpeciesMap.speciesMap.get(species),nickname,moves,IVs,EVs,level,nature, new AbilityContainer(ability), new ItemContainer(item));
				member.setPlayerID(0);
				member.setGender(gender);
				member.setBenchPosition(5);
				playerTeam.add(member);
				
				/**
				 * Create computer team (Red's Team)
				 */
				//Espeon
				IVs[0] = 31;
				IVs[1] = 0;
				IVs[2] = 31;
				IVs[3] = 31;
				IVs[4] = 31;
				IVs[5] = 31;
				
				EVs[0] = 4;
				EVs[1] = 0;
				EVs[2] = 0;
				EVs[3] = 252;
				EVs[4] = 0;
				EVs[5] = 252;
				
				moves[0] = new Move(MoveMap.moveMap.get("Sunny Day"));
				moves[1] = new Move(MoveMap.moveMap.get("Morning Sun"));
				moves[2] = new Move(MoveMap.moveMap.get("Flamethrower"));
				moves[3] = new Move(MoveMap.moveMap.get("Psyshock"));
				
				species = "Espeon";
				nickname = "Espeon";
				item = "Heat Rock";
				ability = "Magic Bounce";
				level = 100;
				nature = Nature.Timid;
				
				member = new Pokemon(SpeciesMap.speciesMap.get(species),nickname,moves,IVs,EVs,level,nature, new AbilityContainer(ability), new ItemContainer(item));
				member.setPlayerID(1);
				member.setBenchPosition(0);
				member.setGender(Gender.FEMALE);
				computerTeam.add(member);
				
				//Snorlax
				IVs[0] = 31;
				IVs[1] = 31;
				IVs[2] = 31;
				IVs[3] = 31;
				IVs[4] = 31;
				IVs[5] = 31;
				
				EVs[0] = 208;
				EVs[1] = 0;
				EVs[2] = 124;
				EVs[3] = 0;
				EVs[4] = 0;
				EVs[5] = 176;
				
				moves[0] = new Move(MoveMap.moveMap.get("Sleep Talk"));
				moves[1] = new Move(MoveMap.moveMap.get("Rest"));
				moves[2] = new Move(MoveMap.moveMap.get("Whirlwind"));
				moves[3] = new Move(MoveMap.moveMap.get("Return"));
				
				species = "Snorlax";
				nickname = "Snorlax";
				item = "Leftovers";
				ability = "Thick Fat";
				level = 100;
				nature = Nature.Careful;
				
				member = new Pokemon(SpeciesMap.speciesMap.get(species),nickname,moves,IVs,EVs,level,nature, new AbilityContainer(ability), new ItemContainer(item));
				member.setPlayerID(1);
				member.setBenchPosition(1);
				member.setGender(Gender.MALE);
				computerTeam.add(member);
				
				//Blastoise
				IVs[0] = 31;
				IVs[1] = 0;
				IVs[2] = 31;
				IVs[3] = 31;
				IVs[4] = 31;
				IVs[5] = 31;
				
				EVs[0] = 252;
				EVs[1] = 0;
				EVs[2] = 252;
				EVs[3] = 4;
				EVs[4] = 0;
				EVs[5] = 0;
				
				moves[0] = new Move(MoveMap.moveMap.get("Toxic"));
				moves[1] = new Move(MoveMap.moveMap.get("Roar"));
				moves[2] = new Move(MoveMap.moveMap.get("Rapid Spin"));
				moves[3] = new Move(MoveMap.moveMap.get("Scald"));
				
				species = "Blastoise";
				nickname = "Blastoise";
				item = "Leftovers";
				ability = "Rain Dish";
				level = 100;
				nature = Nature.Bold;
				
				member = new Pokemon(SpeciesMap.speciesMap.get(species),nickname,moves,IVs,EVs,level,nature, new AbilityContainer(ability), new ItemContainer(item));
				member.setPlayerID(1);
				member.setBenchPosition(2);
				member.setGender(Gender.MALE);
				computerTeam.add(member);
				
				//Charizard
				IVs[0] = 31;
				IVs[1] = 0;
				IVs[2] = 31;
				IVs[3] = 31;
				IVs[4] = 31;
				IVs[5] = 31;
				
				EVs[0] = 4;
				EVs[1] = 0;
				EVs[2] = 0;
				EVs[3] = 252;
				EVs[4] = 0;
				EVs[5] = 252;
				
				moves[0] = new Move(MoveMap.moveMap.get("Focus Blast"));
				moves[1] = new Move(MoveMap.moveMap.get("Fire Blast"));
				moves[2] = new Move(MoveMap.moveMap.get("Solar Beam"));
				moves[3] = new Move(MoveMap.moveMap.get("Ice Beam"));
				
				species = "Mega Charizard Y";
				nickname = "Charizard";
				item = "Charizardite-Y";
				ability = "Drought";
				level = 100;
				nature = Nature.Timid;
				
				member = new Pokemon(SpeciesMap.speciesMap.get(species),nickname,moves,IVs,EVs,level,nature, new AbilityContainer(ability), new ItemContainer(item));
				member.setPlayerID(1);
				member.setBenchPosition(3);
				member.setGender(Gender.FEMALE);
				computerTeam.add(member);
				
				//Venusaur
				IVs[0] = 31;
				IVs[1] = 31;
				IVs[2] = 31;
				IVs[3] = 31;
				IVs[4] = 31;
				IVs[5] = 31;
				
				EVs[0] = 140;
				EVs[1] = 252;
				EVs[2] = 0;
				EVs[3] = 0;
				EVs[4] = 0;
				EVs[5] = 116;
				
				moves[0] = new Move(MoveMap.moveMap.get("Sleep Powder"));
				moves[1] = new Move(MoveMap.moveMap.get("Swords Dance"));
				moves[2] = new Move(MoveMap.moveMap.get("Seed Bomb"));
				moves[3] = new Move(MoveMap.moveMap.get("Earthquake"));
				
				species = "Venusaur";
				nickname = "Venusaur";
				item = "Black Sludge";
				ability = "Chlorophyll";
				level = 100;
				nature = Nature.Adamant;
				
				member = new Pokemon(SpeciesMap.speciesMap.get(species),nickname,moves,IVs,EVs,level,nature, new AbilityContainer(ability), new ItemContainer(item));
				member.setPlayerID(1);
				member.setBenchPosition(4);
				member.setGender(Gender.FEMALE);
				computerTeam.add(member);
				
				//Pikachu
				IVs[0] = 31;
				IVs[1] = 31;
				IVs[2] = 31;
				IVs[3] = 31;
				IVs[4] = 31;
				IVs[5] = 31;
				
				EVs[0] = 0;
				EVs[1] = 4;
				EVs[2] = 0;
				EVs[3] = 252;
				EVs[4] = 0;
				EVs[5] = 252;
				
				moves[0] = new Move(MoveMap.moveMap.get("Substitute"));
				moves[1] = new Move(MoveMap.moveMap.get("Thunderbolt"));
				moves[2] = new Move(MoveMap.moveMap.get("Encore"));
				moves[3] = new Move(MoveMap.moveMap.get("Icicle Crash"));
				
				species = "Pikachu";
				nickname = "Axe";
				item = "Light Ball";
				ability = "Lightningrod";
				level = 100;
				nature = Nature.Timid;
				
				member = new Pokemon(SpeciesMap.speciesMap.get(species),nickname,moves,IVs,EVs,level,nature, new AbilityContainer(ability), new ItemContainer(item));
				member.setPlayerID(1);
				member.setBenchPosition(5);
				member.setGender(Gender.MALE);
				computerTeam.add(member);
				
				/**
				 * Start the battle
				 */
				
				player = new PokemonTrainer(playerTeam);
				computer = new PokemonTrainer(computerTeam);
				
				Timer timer = new Timer();
				try {
					BattleModel.CreateInstance(owner, player, computer);
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				BattleModel model = BattleModel.getInstance();
				BattleView view = new BattleView(player.getTrainerID());
				BattleController controller = new BattleController(view, model, player.getTrainerID());
				AIController AIcontroller = new AIController(model, computer.getTrainerID());
				view.setVisible(true);
				closeFrame();
				System.out.println(player.getTrainerID());
				System.out.println(computer.getTrainerID());
        	}
        });
		contentPane.add(btnFinalize);
		
		
		
		
		btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
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
				
				Move[] moves = {new Move(MoveMap.moveMap.get("Bullet Seed")),new Move(MoveMap.moveMap.get("Giga Drain")),new Move(MoveMap.moveMap.get("Thunder Wave")),new Move(MoveMap.moveMap.get("Roost"))};
				Pokemon member = new Pokemon(SpeciesMap.speciesMap.get("Mega Charizard Y"),"Charizard",moves,IVs,EVs,100,Nature.Modest, new AbilityContainer("Drought"), new ItemContainer("None"));
				member.addVolatileStatus(new StatusContainer(-1,-1,"Taunt",member.getMove(2)));
				member.setPlayerID(0);
				member.setBenchPosition(1);
				playerTeam.add(member);
				
				member = new Pokemon(SpeciesMap.speciesMap.get("Mew"),"Meow",moves,IVs,EVs,100,Nature.Bold, new AbilityContainer("Sand Stream"), new ItemContainer("None"));
				member.setPlayerID(1);
				member.setBenchPosition(1);
				computerTeam.add(member);
				
				//CREATE TYRANITAR
				int IVs2[] = {31,31,31,31,31,31};
				int EVs2[] = {0,252,0,0,4,252};
				Move[] moves2 = {new Move(MoveMap.moveMap.get("Crunch")),new Move(MoveMap.moveMap.get("Flamethrower")),new Move(MoveMap.moveMap.get("Scald")),new Move(MoveMap.moveMap.get("Earthquake"))};
				member = new Pokemon(SpeciesMap.speciesMap.get("Tyranitar"),"Serene Grace",moves2,IVs2,EVs2,100,Nature.Jolly, new AbilityContainer("Drizzle"), new ItemContainer("None"));
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
				member = new Pokemon(SpeciesMap.speciesMap.get("Mega Slowbro"),"LO Sheer Force",moves3,IVs,EVs3,100,Nature.Bold, new AbilityContainer("Drizzle"), new ItemContainer("Life Orb"));
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
				member = new Pokemon(SpeciesMap.speciesMap.get("Ferrothorn"),"Toxic Poisoned",moves4,IVs4,EVs4,100,Nature.Relaxed, new AbilityContainer("Iron Barbs"), new ItemContainer("Assault Vest"));
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
				//AIController AIcontroller = new AIController(model, computer.getTrainerID());
				
				view.setVisible(true);
				closeFrame();
			}
		});
		btnTest.setBounds(90, 740, 100, 25);
		contentPane.add(btnTest);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu.startup();
				closeFrame();
			}
		});
		btnCancel.setBounds(740, 740, 100, 25);
		contentPane.add(btnCancel);
	}
	
	private void closeFrame()
	{
		this.setVisible(false);
	}
	/*
	 * Check Pokemone names for validity, check for doubles
	 */
	public boolean checkPokemon()
	{
		if(SpeciesMap.speciesMap.get(p1_species.getSelectedItem()) == null)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 1 is not a valid Pokemon");
			return false;
		}
		else if(SpeciesMap.speciesMap.get(p2_species.getSelectedItem()) == null)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 2 is not a valid Pokemon");
			return false;
		}
		else if(SpeciesMap.speciesMap.get(p3_species.getSelectedItem()) == null)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 3 is not a valid Pokemon");
			return false;
		}
		else if(SpeciesMap.speciesMap.get(p4_species.getSelectedItem()) == null)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 4 is not a valid Pokemon");
			return false;
		}
		else if(SpeciesMap.speciesMap.get(p5_species.getSelectedItem()) == null)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 5 is not a valid Pokemon");
			return false;
		}
		else if(SpeciesMap.speciesMap.get(p6_species.getSelectedItem()) == null)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 6 is not a valid Pokemon");
			return false;
		}
		else if(p1_species.getSelectedItem().equals(p2_species.getSelectedItem())  ||
				p1_species.getSelectedItem().equals(p3_species.getSelectedItem())  ||
				p1_species.getSelectedItem().equals(p4_species.getSelectedItem())  ||
				p1_species.getSelectedItem().equals(p5_species.getSelectedItem())  ||
				p1_species.getSelectedItem().equals(p6_species.getSelectedItem())  ||
				p2_species.getSelectedItem().equals(p3_species.getSelectedItem())  ||
				p2_species.getSelectedItem().equals(p4_species.getSelectedItem())  ||
				p2_species.getSelectedItem().equals(p5_species.getSelectedItem())  ||
				p2_species.getSelectedItem().equals(p6_species.getSelectedItem())  ||
				p3_species.getSelectedItem().equals(p4_species.getSelectedItem())  ||
				p3_species.getSelectedItem().equals(p5_species.getSelectedItem())  ||
				p3_species.getSelectedItem().equals(p6_species.getSelectedItem())  ||
				p4_species.getSelectedItem().equals(p5_species.getSelectedItem())  ||
				p4_species.getSelectedItem().equals(p6_species.getSelectedItem())  ||
				p5_species.getSelectedItem().equals(p6_species.getSelectedItem())
				)
		{
			JOptionPane.showMessageDialog(null, "You cannot have two of the same Pokemon on your team");
			return false;
		}
		else
			return true;
	}
	
	/*
	 * Check Move validity
	 */
	public boolean checkMoves()
	{
		if (	
				p1_move1.getSelectedItem().equals(p1_move2.getSelectedItem())  ||
				p1_move1.getSelectedItem().equals(p1_move3.getSelectedItem())  ||
				p1_move1.getSelectedItem().equals(p1_move4.getSelectedItem())  ||
				p1_move2.getSelectedItem().equals(p1_move3.getSelectedItem())  ||
				p1_move2.getSelectedItem().equals(p1_move4.getSelectedItem())  ||
				p1_move3.getSelectedItem().equals(p1_move4.getSelectedItem())
			)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 1 may not have two of the same moves");
			return false;
		}
		else if 
			(	
				p2_move1.getSelectedItem().equals(p2_move2.getSelectedItem())  ||
				p2_move1.getSelectedItem().equals(p2_move3.getSelectedItem())  ||
				p2_move1.getSelectedItem().equals(p2_move4.getSelectedItem())  ||
				p2_move2.getSelectedItem().equals(p2_move3.getSelectedItem())  ||
				p2_move2.getSelectedItem().equals(p2_move4.getSelectedItem())  ||
				p2_move3.getSelectedItem().equals(p2_move4.getSelectedItem())
			)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 2 may not have two of the same moves");
			return false;
		}
		else if 
			(	
				p3_move1.getSelectedItem().equals(p3_move2.getSelectedItem())  ||
				p3_move1.getSelectedItem().equals(p3_move3.getSelectedItem())  ||
				p3_move1.getSelectedItem().equals(p3_move4.getSelectedItem())  ||
				p3_move2.getSelectedItem().equals(p3_move3.getSelectedItem())  ||
				p3_move2.getSelectedItem().equals(p3_move4.getSelectedItem())  ||
				p3_move3.getSelectedItem().equals(p3_move4.getSelectedItem())
			)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 3 may not have two of the same moves");
			return false;
		}
		else if 
			(	
				p4_move1.getSelectedItem().equals(p4_move2.getSelectedItem())  ||
				p4_move1.getSelectedItem().equals(p4_move3.getSelectedItem())  ||
				p4_move1.getSelectedItem().equals(p4_move4.getSelectedItem())  ||
				p4_move2.getSelectedItem().equals(p4_move3.getSelectedItem())  ||
				p4_move2.getSelectedItem().equals(p4_move4.getSelectedItem())  ||
				p4_move3.getSelectedItem().equals(p4_move4.getSelectedItem())
			)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 4 may not have two of the same moves");
			return false;
		}
		else if 
			(	
				p5_move1.getSelectedItem().equals(p5_move2.getSelectedItem())  ||
				p5_move1.getSelectedItem().equals(p5_move3.getSelectedItem())  ||
				p5_move1.getSelectedItem().equals(p5_move4.getSelectedItem())  ||
				p5_move2.getSelectedItem().equals(p5_move3.getSelectedItem())  ||
				p5_move2.getSelectedItem().equals(p5_move4.getSelectedItem())  ||
				p5_move3.getSelectedItem().equals(p5_move4.getSelectedItem())
			)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 5 may not have two of the same moves");
			return false;
		}
		else if 
			(	
				p6_move1.getSelectedItem().equals(p6_move2.getSelectedItem())  ||
				p6_move1.getSelectedItem().equals(p6_move3.getSelectedItem())  ||
				p6_move1.getSelectedItem().equals(p6_move4.getSelectedItem())  ||
				p6_move2.getSelectedItem().equals(p6_move3.getSelectedItem())  ||
				p6_move2.getSelectedItem().equals(p6_move4.getSelectedItem())  ||
				p6_move3.getSelectedItem().equals(p6_move4.getSelectedItem())
			)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 6 may not have two of the same moves");
			return false;
		}
		else
			return true;
	}
	/*
	 * Check IV and EV value functions 
	 */
	public boolean checkSums()
	{
		//Calculate IV validity
		if (	
				(int)p1_hp_iv.getModel().getValue() > 31  ||
				(int)p1_atk_iv.getModel().getValue() > 31  ||
				(int)p1_def_iv.getModel().getValue() > 31  ||
				(int)p1_spatk_iv.getModel().getValue() > 31  ||
				(int)p1_spdef_iv.getModel().getValue() > 31  ||
				(int)p1_speed_iv.getModel().getValue() > 31  
			)
		{
			JOptionPane.showMessageDialog(null, "The value of an IV for Pokemon 1 is over 31");
			return false;
		}
		else if(
				(int)p1_hp_iv.getModel().getValue() < 0  ||
				(int)p1_atk_iv.getModel().getValue() < 0  ||
				(int)p1_def_iv.getModel().getValue() < 0  ||
				(int)p1_spatk_iv.getModel().getValue() < 0  ||
				(int)p1_spdef_iv.getModel().getValue() < 0  ||
				(int)p1_speed_iv.getModel().getValue() < 0
			)
		{
			JOptionPane.showMessageDialog(null, "The value of an IV for Pokemon 1 is less than 0");
			return false;
		}
		else if(
				(int)p2_hp_iv.getModel().getValue() > 31  ||
				(int)p2_atk_iv.getModel().getValue() > 31  ||
				(int)p2_def_iv.getModel().getValue() > 31  ||
				(int)p2_spatk_iv.getModel().getValue() > 31  ||
				(int)p2_spdef_iv.getModel().getValue() > 31  ||
				(int)p2_speed_iv.getModel().getValue() > 31  
			)
			{
				JOptionPane.showMessageDialog(null, "The value of an IV for Pokemon 2 is over 31");
				return false;
			}
			else if(
				(int)p2_hp_iv.getModel().getValue() < 0  ||
				(int)p2_atk_iv.getModel().getValue() < 0  ||
				(int)p2_def_iv.getModel().getValue() < 0  ||
				(int)p2_spatk_iv.getModel().getValue() < 0  ||
				(int)p2_spdef_iv.getModel().getValue() < 0  ||
				(int)p2_speed_iv.getModel().getValue() < 0   
			)
		{
			JOptionPane.showMessageDialog(null, "The value of an IV for Pokemon 2 is less than 0");
			return false;
		}
		else if(
				(int)p3_hp_iv.getModel().getValue() > 31  ||
				(int)p3_atk_iv.getModel().getValue() > 31  ||
				(int)p3_def_iv.getModel().getValue() > 31  ||
				(int)p3_spatk_iv.getModel().getValue() > 31  ||
				(int)p3_spdef_iv.getModel().getValue() > 31  ||
				(int)p3_speed_iv.getModel().getValue() > 31  
				)
		{
			JOptionPane.showMessageDialog(null, "The value of an IV for Pokemon 3 is over 31");
			return false;
		}
		else if(
				(int)p3_hp_iv.getModel().getValue() < 0  ||
				(int)p3_atk_iv.getModel().getValue() < 0  ||
				(int)p3_def_iv.getModel().getValue() < 0  ||
				(int)p3_spatk_iv.getModel().getValue() < 0  ||
				(int)p3_spdef_iv.getModel().getValue() < 0  ||
				(int)p3_speed_iv.getModel().getValue() < 0
			)
		{
			JOptionPane.showMessageDialog(null, "The value of an IV for Pokemon 3 is less than 0");
			return false;
		}
		else if(
				(int)p4_hp_iv.getModel().getValue() > 31  ||
				(int)p4_atk_iv.getModel().getValue() > 31  ||
				(int)p4_def_iv.getModel().getValue() > 31  ||
				(int)p4_spatk_iv.getModel().getValue() > 31  ||
				(int)p4_spdef_iv.getModel().getValue() > 31  ||
				(int)p4_speed_iv.getModel().getValue() > 31  
			)
		{
			JOptionPane.showMessageDialog(null, "The value of an IV for Pokemon 4 is over 31");
			return false;
		}
		else if(
				(int)p4_hp_iv.getModel().getValue() < 0  ||
				(int)p4_atk_iv.getModel().getValue() < 0  ||
				(int)p4_def_iv.getModel().getValue() < 0  ||
				(int)p4_spatk_iv.getModel().getValue() < 0  ||
				(int)p4_spdef_iv.getModel().getValue() < 0  ||
				(int)p4_speed_iv.getModel().getValue() < 0
			)
		{
			JOptionPane.showMessageDialog(null, "The value of an IV for Pokemon 4 is less than 0");
			return false;
		}
		else if(
				(int)p5_hp_iv.getModel().getValue() > 31  ||
				(int)p5_atk_iv.getModel().getValue() > 31  ||
				(int)p5_def_iv.getModel().getValue() > 31  ||
				(int)p5_spatk_iv.getModel().getValue() > 31  ||
				(int)p5_spdef_iv.getModel().getValue() > 31  ||
				(int)p5_speed_iv.getModel().getValue() > 31  
			)
		{
			JOptionPane.showMessageDialog(null, "The value of an IV for Pokemon 5 is over 31");
			return false;
		}
		else if(
				(int)p5_hp_iv.getModel().getValue() < 0  ||
				(int)p5_atk_iv.getModel().getValue() < 0  ||
				(int)p5_def_iv.getModel().getValue() < 0  ||
				(int)p5_spatk_iv.getModel().getValue() < 0  ||
				(int)p5_spdef_iv.getModel().getValue() < 0  ||
				(int)p5_speed_iv.getModel().getValue() < 0
			)
		{
			JOptionPane.showMessageDialog(null, "The value of an IV for Pokemon 5 is less than 0");
			return false;
		}
		else if(
				(int)p6_hp_iv.getModel().getValue() > 31  ||
				(int)p6_atk_iv.getModel().getValue() > 31  ||
				(int)p6_def_iv.getModel().getValue() > 31  ||
				(int)p6_spatk_iv.getModel().getValue() > 31  ||
				(int)p6_spdef_iv.getModel().getValue() > 31  ||
				(int)p6_speed_iv.getModel().getValue() > 31  
			)
		{
			JOptionPane.showMessageDialog(null, "The value of an IV for Pokemon 6 is over 31");
			return false;
		}
		else if(
				(int)p6_hp_iv.getModel().getValue() < 0  ||
				(int)p6_atk_iv.getModel().getValue() < 0  ||
				(int)p6_def_iv.getModel().getValue() < 0  ||
				(int)p6_spatk_iv.getModel().getValue() < 0  ||
				(int)p6_spdef_iv.getModel().getValue() < 0  ||
				(int)p6_speed_iv.getModel().getValue() < 0
			)
		{
			JOptionPane.showMessageDialog(null, "The value of an IV for Pokemon 6 is less than 0");
			return false;
		}
		//Calculate EV Validity
		else if(
				(int)p1_hp_ev.getModel().getValue() > 252  ||
				(int)p1_atk_ev.getModel().getValue() > 252  ||
				(int)p1_def_ev.getModel().getValue() > 252  ||
				(int)p1_spatk_ev.getModel().getValue() > 252  ||
				(int)p1_spdef_ev.getModel().getValue() > 252  ||
				(int)p1_speed_ev.getModel().getValue() > 252  
				)
		{
			JOptionPane.showMessageDialog(null, "An Effort Value for Pokemon 1 is over 252");
			return false;
		}
		else if(
				(int)p1_hp_ev.getModel().getValue() < 0    ||
				(int)p1_atk_ev.getModel().getValue() < 0    ||
				(int)p1_def_ev.getModel().getValue() < 0    ||
				(int)p1_spatk_ev.getModel().getValue() < 0    ||
				(int)p1_spdef_ev.getModel().getValue() < 0    ||
				(int)p1_speed_ev.getModel().getValue() < 0    
			)
		{
			JOptionPane.showMessageDialog(null, "An Effort Value for Pokemon 1 is less than 0");
			return false;
		}
		else if(
				(int)p1_hp_ev.getModel().getValue() +
				(int)p1_atk_ev.getModel().getValue() +
				(int)p1_def_ev.getModel().getValue() +
				(int)p1_spatk_ev.getModel().getValue() +
				(int)p1_spdef_ev.getModel().getValue() +
				(int)p1_speed_ev.getModel().getValue() > 510
				)
		{
			JOptionPane.showMessageDialog(null, "Effort Values for Pokemone 1 add up to a value over 510");
			return false;
		}
		else if(
				(int)p2_hp_ev.getModel().getValue() > 252  ||
				(int)p2_atk_ev.getModel().getValue() > 252  ||
				(int)p2_def_ev.getModel().getValue() > 252  ||
				(int)p2_spatk_ev.getModel().getValue() > 252  ||
				(int)p2_spdef_ev.getModel().getValue() > 252  ||
				(int)p2_speed_ev.getModel().getValue() > 252  
			)
		{
			JOptionPane.showMessageDialog(null, "An Effort Value for Pokemon 2 is over 252");
			return false;
		}
		else if(
				(int)p2_hp_ev.getModel().getValue() < 0    ||
				(int)p2_atk_ev.getModel().getValue() < 0    ||
				(int)p2_def_ev.getModel().getValue() < 0    ||
				(int)p2_spatk_ev.getModel().getValue() < 0    ||
				(int)p2_spdef_ev.getModel().getValue() < 0    ||
				(int)p2_speed_ev.getModel().getValue() < 0    
				)
		{
			JOptionPane.showMessageDialog(null, "An Effort Value for Pokemon 2 is less than 0");
			return false;
		}
		else if(
				(int)p2_hp_ev.getModel().getValue() +
				(int)p2_atk_ev.getModel().getValue() +
				(int)p2_def_ev.getModel().getValue() +
				(int)p2_spatk_ev.getModel().getValue() +
				(int)p2_spdef_ev.getModel().getValue() +
				(int)p2_speed_ev.getModel().getValue() > 510
			)
		{
			JOptionPane.showMessageDialog(null, "Effort Values for Pokemone 2 add up to a value over 510");
			return false;
		}
		else if(
				(int)p3_hp_ev.getModel().getValue() > 252  ||
				(int)p3_atk_ev.getModel().getValue() > 252  ||
				(int)p3_def_ev.getModel().getValue() > 252  ||
				(int)p3_spatk_ev.getModel().getValue() > 252  ||
				(int)p3_spdef_ev.getModel().getValue() > 252  ||
				(int)p3_speed_ev.getModel().getValue() > 252  
			)
		{
			JOptionPane.showMessageDialog(null, "An Effort Value for Pokemon 3 is over 252");
			return false;
		}
		else if(
				(int)p3_hp_ev.getModel().getValue() < 0    ||
				(int)p3_atk_ev.getModel().getValue() < 0    ||
				(int)p3_def_ev.getModel().getValue() < 0    ||
				(int)p3_spatk_ev.getModel().getValue() < 0    ||
				(int)p3_spdef_ev.getModel().getValue() < 0    ||
				(int)p3_speed_ev.getModel().getValue() < 0    
				)
		{
			JOptionPane.showMessageDialog(null, "An Effort Value for Pokemon 3 is less than 0");
			return false;
		}
		else if(
				(int)p3_hp_ev.getModel().getValue() +
				(int)p3_atk_ev.getModel().getValue() +
				(int)p3_def_ev.getModel().getValue() +
				(int)p3_spatk_ev.getModel().getValue() +
				(int)p3_spdef_ev.getModel().getValue() +
				(int)p3_speed_ev.getModel().getValue() > 510
				)
		{
			JOptionPane.showMessageDialog(null, "Effort Values for Pokemone 3 add up to a value over 510");
			return false;
		}
		else if(
				(int)p4_hp_ev.getModel().getValue() > 252  ||
				(int)p4_atk_ev.getModel().getValue() > 252  ||
				(int)p4_def_ev.getModel().getValue() > 252  ||
				(int)p4_spatk_ev.getModel().getValue() > 252  ||
				(int)p4_spdef_ev.getModel().getValue() > 252  ||
				(int)p4_speed_ev.getModel().getValue() > 252  
			)
		{
			JOptionPane.showMessageDialog(null, "An Effort Value for Pokemon 4 is over 252");
			return false;
		}
		else if(
				(int)p4_hp_ev.getModel().getValue() < 0    ||
				(int)p4_atk_ev.getModel().getValue() < 0    ||
				(int)p4_def_ev.getModel().getValue() < 0    ||
				(int)p4_spatk_ev.getModel().getValue() < 0    ||
				(int)p4_spdef_ev.getModel().getValue() < 0    ||
				(int)p4_speed_ev.getModel().getValue() < 0    
				)
		{
			JOptionPane.showMessageDialog(null, "An Effort Value for Pokemon 4 is less than 0");
			return false;
		}
		else if(
				(int)p4_hp_ev.getModel().getValue() +
				(int)p4_atk_ev.getModel().getValue() +
				(int)p4_def_ev.getModel().getValue() +
				(int)p4_spatk_ev.getModel().getValue() +
				(int)p4_spdef_ev.getModel().getValue() +
				(int)p4_speed_ev.getModel().getValue() > 510
				)
		{
			JOptionPane.showMessageDialog(null, "Effort Values for Pokemone 4 add up to a value over 510");
			return false;
		}
		else if(
				(int)p5_hp_ev.getModel().getValue() > 252  ||
				(int)p5_atk_ev.getModel().getValue() > 252  ||
				(int)p5_def_ev.getModel().getValue() > 252  ||
				(int)p5_spatk_ev.getModel().getValue() > 252  ||
				(int)p5_spdef_ev.getModel().getValue() > 252  ||
				(int)p5_speed_ev.getModel().getValue() > 252  
			)
		{
			JOptionPane.showMessageDialog(null, "An Effort Value for Pokemon 5 is over 252");
			return false;
		}
		else if(
				(int)p5_hp_ev.getModel().getValue() < 0    ||
				(int)p5_atk_ev.getModel().getValue() < 0    ||
				(int)p5_def_ev.getModel().getValue() < 0    ||
				(int)p5_spatk_ev.getModel().getValue() < 0    ||
				(int)p5_spdef_ev.getModel().getValue() < 0    ||
				(int)p5_speed_ev.getModel().getValue() < 0    
				)
		{
			JOptionPane.showMessageDialog(null, "An Effort Value for Pokemon 5 is less than 0");
			return false;
		}
		else if(
				(int)p5_hp_ev.getModel().getValue() +
				(int)p5_atk_ev.getModel().getValue() +
				(int)p5_def_ev.getModel().getValue() +
				(int)p5_spatk_ev.getModel().getValue() +
				(int)p5_spdef_ev.getModel().getValue() +
				(int)p5_speed_ev.getModel().getValue() > 510
				)
		{
			JOptionPane.showMessageDialog(null, "Effort Values for Pokemone 5 add up to a value over 510");
			return false;
		}
		else if(
				(int)p6_hp_ev.getModel().getValue() > 252  ||
				(int)p6_atk_ev.getModel().getValue() > 252  ||
				(int)p6_def_ev.getModel().getValue() > 252  ||
				(int)p6_spatk_ev.getModel().getValue() > 252  ||
				(int)p6_spdef_ev.getModel().getValue() > 252  ||
				(int)p6_speed_ev.getModel().getValue() > 252  
				)
			{
				JOptionPane.showMessageDialog(null, "An Effort Value for Pokemon 6 is over 252");
				return false;
			}
			else if(
				(int)p6_hp_ev.getModel().getValue() < 0    ||
				(int)p6_atk_ev.getModel().getValue() < 0    ||
				(int)p6_def_ev.getModel().getValue() < 0    ||
				(int)p6_spatk_ev.getModel().getValue() < 0    ||
				(int)p6_spdef_ev.getModel().getValue() < 0    ||
				(int)p6_speed_ev.getModel().getValue() < 0    
					)
			{
				JOptionPane.showMessageDialog(null, "An Effort Value for Pokemon 6 is less than 0");
				return false;
			}
			else if(
				(int)p6_hp_ev.getModel().getValue() +
				(int)p6_atk_ev.getModel().getValue() +
				(int)p6_def_ev.getModel().getValue() +
				(int)p6_spatk_ev.getModel().getValue() +
				(int)p6_spdef_ev.getModel().getValue() +
				(int)p6_speed_ev.getModel().getValue() > 510
				)
		{
			JOptionPane.showMessageDialog(null, "Effort Values for Pokemone 6 add up to a value over 510");
			return false;
		}
			else if((int)p1_level.getModel().getValue() < 1 || (int)p1_level.getModel().getValue() > 100)
			{
				JOptionPane.showMessageDialog(null, "Pokemon 1 must be between levels 1 and 100");
				return false;
			}
			else if((int)p2_level.getModel().getValue() < 1 || (int)p2_level.getModel().getValue() > 100)
			{
				JOptionPane.showMessageDialog(null, "Pokemon 2 must be between levels 1 and 100");
				return false;
			}
			else if((int)p3_level.getModel().getValue() < 1 || (int)p3_level.getModel().getValue() > 100)
			{
				JOptionPane.showMessageDialog(null, "Pokemon 3 must be between levels 1 and 100");
				return false;
			}
			else if((int)p4_level.getModel().getValue() < 1 || (int)p4_level.getModel().getValue() > 100)
			{
				JOptionPane.showMessageDialog(null, "Pokemon 4 must be between levels 1 and 100");
				return false;
			}
			else if((int)p5_level.getModel().getValue() < 1 || (int)p5_level.getModel().getValue() > 100)
			{
				JOptionPane.showMessageDialog(null, "Pokemon 5 must be between levels 1 and 100");
				return false;
			}
			else if((int)p6_level.getModel().getValue() < 1 || (int)p6_level.getModel().getValue() > 100)
			{
				JOptionPane.showMessageDialog(null, "Pokemon 6 must be between levels 1 and 100");
				return false;
			}
		else
			return true;
	}
	public boolean testValidity()
	{
		if(checkPokemon())
		{
			if(checkMoves())
			{
				if(checkSums())
				{
					return true;
				}
			}
			
		}
		return false;
	}
}
