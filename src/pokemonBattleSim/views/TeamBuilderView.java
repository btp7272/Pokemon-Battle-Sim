package pokemonBattleSim.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pokemonBattleSim.models.TeamBuilderModel;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeamBuilderView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JComboBox comboBox_4;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_47;
	private JTextField textField_48;
	private JTextField textField_49;
	private JTextField textField_50;
	private JTextField textField_51;
	private JTextField textField_52;
	private JTextField textField_53;
	private JTextField textField_54;
	private JTextField textField_55;
	private JTextField textField_56;
	private JTextField textField_57;
	private JTextField textField_58;
	private JTextField textField_59;
	private JTextField textField_60;
	private JTextField textField_61;
	private JTextField textField_62;
	private JTextField textField_63;
	private JTextField textField_64;
	private JTextField textField_65;
	private JTextField textField_66;
	private JTextField textField_67;
	private JTextField textField_68;
	private JTextField textField_69;
	private JTextField textField_70;
	private JTextField textField_71;
	private JTextField textField_72;
	private JTextField textField_73;
	private JTextField textField_74;
	private JTextField textField_75;
	private JTextField textField_76;
	private JTextField textField_77;
	private JTextField textField_78;
	private JTextField textField_79;
	private JTextField textField_80;
	private JTextField textField_81;
	private JTextField textField_82;
	private JTextField textField_83;
	private JButton btnRefresh;
	private JButton btnFinalize;
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
	    moves1 = model.generateMoves(textField.getText());
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
		
		textField = new JTextField(30);
		textField.setToolTipText("Pokemon");
		textField.setBounds(90, 25, 100, 25);
		contentPane.add(textField);
		
		textField_1 = new JTextField(30);
		textField_1.setToolTipText("Pokemon");
		textField_1.setBounds(90, 55, 100, 25);
		contentPane.add(textField_1);
		
		JComboBox comboBox = new JComboBox(new Object[]{});
		comboBox.setBounds(90, 95, 100, 25);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(poke1move2List);
		comboBox_1.setBounds(90, 125, 100, 25);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox(new Object[]{});
		comboBox_2.setBounds(90, 155, 100, 25);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox(new Object[]{});
		comboBox_3.setBounds(90, 185, 100, 25);
		contentPane.add(comboBox_3);
		
		textField_2 = new JTextField(2);
		textField_2.setText("31");
		textField_2.setBounds(90, 265, 100, 25);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField(2);
		textField_3.setText("31");
		textField_3.setBounds(90, 290, 100, 25);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField(2);
		textField_4.setText("31");
		textField_4.setBounds(90, 315, 100, 25);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField(2);
		textField_5.setText("31");
		textField_5.setBounds(90, 340, 100, 25);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField(2);
		textField_6.setText("31");
		textField_6.setBounds(90, 365, 100, 25);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField(2);
		textField_7.setText("31");
		textField_7.setBounds(90, 390, 100, 25);
		contentPane.add(textField_7);
		
		JLabel pokelabel1 = new JLabel("Pokemon 1");
		pokelabel1.setBounds(90, 5, 100, 25);
		contentPane.add(pokelabel1);
		
		JLabel lblIndividualValuesindividual = new JLabel("Individual Values (Individual Max of 31)");
		lblIndividualValuesindividual.setBounds(90, 251, 261, 14);
		contentPane.add(lblIndividualValuesindividual);
		
		JLabel lblEffortValuesindividual = new JLabel("Effort Values (Individual Max of 252 - Total Max of 510)");
		lblEffortValuesindividual.setBounds(90, 419, 280, 14);
		contentPane.add(lblEffortValuesindividual);
		
		textField_8 = new JTextField(2);
		textField_8.setText("0");
		textField_8.setBounds(90, 435, 100, 25);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField(2);
		textField_9.setText("0");
		textField_9.setBounds(90, 460, 100, 25);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField(2);
		textField_10.setText("0");
		textField_10.setBounds(90, 485, 100, 25);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField(2);
		textField_11.setText("0");
		textField_11.setBounds(90, 510, 100, 25);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField(2);
		textField_12.setText("0");
		textField_12.setBounds(90, 535, 100, 25);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField(2);
		textField_13.setText("0");
		textField_13.setBounds(90, 560, 100, 25);
		contentPane.add(textField_13);
		
		comboBox_4 = new JComboBox(new Object[]{});
		comboBox_4.setBounds(90, 215, 100, 25);
		contentPane.add(comboBox_4);
		
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
		lblDefense.setBounds(5, 320, 46, 14);
		contentPane.add(lblDefense);
		
		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setBounds(5, 345, 46, 14);
		contentPane.add(lblSpeed);
		
		JLabel lblSepcialAttack = new JLabel("Sepcial Attack");
		lblSepcialAttack.setBounds(5, 370, 85, 14);
		contentPane.add(lblSepcialAttack);
		
		JLabel lblSpecialDefense = new JLabel("Special Defense");
		lblSpecialDefense.setBounds(5, 395, 46, 14);
		contentPane.add(lblSpecialDefense);
		
		JLabel label = new JLabel("Special Defense");
		label.setBounds(5, 565, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Sepcial Attack");
		label_1.setBounds(5, 540, 85, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Speed");
		label_2.setBounds(5, 515, 46, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Defense");
		label_3.setBounds(5, 490, 46, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Attack");
		label_4.setBounds(5, 465, 46, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("HP");
		label_5.setBounds(5, 440, 46, 14);
		contentPane.add(label_5);
		
		textField_14 = new JTextField(30);
		textField_14.setToolTipText("Pokemon");
		textField_14.setBounds(220, 25, 100, 25);
		contentPane.add(textField_14);
		
		textField_15 = new JTextField(30);
		textField_15.setToolTipText("Pokemon");
		textField_15.setBounds(220, 55, 100, 25);
		contentPane.add(textField_15);
		
		JComboBox comboBox_5 = new JComboBox(new Object[]{});
		comboBox_5.setBounds(220, 95, 100, 25);
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {moves1}));
		contentPane.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox(new Object[]{});
		comboBox_6.setBounds(220, 125, 100, 25);
		contentPane.add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox(new Object[]{});
		comboBox_7.setBounds(220, 155, 100, 25);
		contentPane.add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox(new Object[]{});
		comboBox_8.setBounds(220, 185, 100, 25);
		contentPane.add(comboBox_8);
		
		JComboBox comboBox_9 = new JComboBox(new Object[]{});
		comboBox_9.setBounds(220, 215, 100, 25);
		contentPane.add(comboBox_9);
		
		textField_16 = new JTextField(2);
		textField_16.setText("31");
		textField_16.setBounds(220, 265, 100, 25);
		contentPane.add(textField_16);
		
		textField_17 = new JTextField(2);
		textField_17.setText("31");
		textField_17.setBounds(220, 290, 100, 25);
		contentPane.add(textField_17);
		
		textField_18 = new JTextField(2);
		textField_18.setText("31");
		textField_18.setBounds(220, 315, 100, 25);
		contentPane.add(textField_18);
		
		textField_19 = new JTextField(2);
		textField_19.setText("31");
		textField_19.setBounds(220, 340, 100, 25);
		contentPane.add(textField_19);
		
		textField_20 = new JTextField(2);
		textField_20.setText("31");
		textField_20.setBounds(220, 365, 100, 25);
		contentPane.add(textField_20);
		
		textField_21 = new JTextField(2);
		textField_21.setText("31");
		textField_21.setBounds(220, 390, 100, 25);
		contentPane.add(textField_21);
		
		textField_22 = new JTextField(2);
		textField_22.setText("0");
		textField_22.setBounds(220, 435, 100, 25);
		contentPane.add(textField_22);
		
		textField_23 = new JTextField(2);
		textField_23.setText("0");
		textField_23.setBounds(220, 460, 100, 25);
		contentPane.add(textField_23);
		
		textField_24 = new JTextField(2);
		textField_24.setText("0");
		textField_24.setBounds(220, 485, 100, 25);
		contentPane.add(textField_24);
		
		textField_25 = new JTextField(2);
		textField_25.setText("0");
		textField_25.setBounds(220, 510, 100, 25);
		contentPane.add(textField_25);
		
		textField_26 = new JTextField(2);
		textField_26.setText("0");
		textField_26.setBounds(220, 535, 100, 25);
		contentPane.add(textField_26);
		
		textField_27 = new JTextField(2);
		textField_27.setText("0");
		textField_27.setBounds(220, 560, 100, 25);
		contentPane.add(textField_27);
		
		textField_28 = new JTextField(30);
		textField_28.setToolTipText("Pokemon");
		textField_28.setBounds(350, 25, 100, 25);
		contentPane.add(textField_28);
		
		textField_29 = new JTextField(30);
		textField_29.setToolTipText("Pokemon");
		textField_29.setBounds(350, 55, 100, 25);
		contentPane.add(textField_29);
		
		JComboBox comboBox_10 = new JComboBox(new Object[]{});
		comboBox_10.setBounds(350, 95, 100, 25);
		contentPane.add(comboBox_10);
		
		JComboBox comboBox_11 = new JComboBox(new Object[]{});
		comboBox_11.setBounds(350, 125, 100, 25);
		contentPane.add(comboBox_11);
		
		JComboBox comboBox_12 = new JComboBox(new Object[]{});
		comboBox_12.setBounds(350, 155, 100, 25);
		contentPane.add(comboBox_12);
		
		JComboBox comboBox_13 = new JComboBox(new Object[]{});
		comboBox_13.setBounds(350, 185, 100, 25);
		contentPane.add(comboBox_13);
		
		JComboBox comboBox_14 = new JComboBox(new Object[]{});
		comboBox_14.setBounds(350, 215, 100, 25);
		contentPane.add(comboBox_14);
		
		textField_30 = new JTextField(2);
		textField_30.setText("31");
		textField_30.setBounds(350, 265, 100, 25);
		contentPane.add(textField_30);
		
		textField_31 = new JTextField(2);
		textField_31.setText("31");
		textField_31.setBounds(350, 290, 100, 25);
		contentPane.add(textField_31);
		
		textField_32 = new JTextField(2);
		textField_32.setText("31");
		textField_32.setBounds(350, 315, 100, 25);
		contentPane.add(textField_32);
		
		textField_33 = new JTextField(2);
		textField_33.setText("31");
		textField_33.setBounds(350, 340, 100, 25);
		contentPane.add(textField_33);
		
		textField_34 = new JTextField(2);
		textField_34.setText("31");
		textField_34.setBounds(350, 365, 100, 25);
		contentPane.add(textField_34);
		
		textField_35 = new JTextField(2);
		textField_35.setText("31");
		textField_35.setBounds(350, 390, 100, 25);
		contentPane.add(textField_35);
		
		textField_36 = new JTextField(2);
		textField_36.setText("0");
		textField_36.setBounds(350, 435, 100, 25);
		contentPane.add(textField_36);
		
		textField_37 = new JTextField(2);
		textField_37.setText("0");
		textField_37.setBounds(350, 460, 100, 25);
		contentPane.add(textField_37);
		
		textField_38 = new JTextField(2);
		textField_38.setText("0");
		textField_38.setBounds(350, 485, 100, 25);
		contentPane.add(textField_38);
		
		textField_39 = new JTextField(2);
		textField_39.setText("0");
		textField_39.setBounds(350, 510, 100, 25);
		contentPane.add(textField_39);
		
		textField_40 = new JTextField(2);
		textField_40.setText("0");
		textField_40.setBounds(350, 535, 100, 25);
		contentPane.add(textField_40);
		
		textField_41 = new JTextField(2);
		textField_41.setText("0");
		textField_41.setBounds(350, 560, 100, 25);
		contentPane.add(textField_41);
		
		textField_42 = new JTextField(30);
		textField_42.setToolTipText("Pokemon");
		textField_42.setBounds(480, 25, 100, 25);
		contentPane.add(textField_42);
		
		textField_43 = new JTextField(30);
		textField_43.setToolTipText("Pokemon");
		textField_43.setBounds(480, 55, 100, 25);
		contentPane.add(textField_43);
		
		JComboBox comboBox_15 = new JComboBox(new Object[]{});
		comboBox_15.setBounds(480, 95, 100, 25);
		contentPane.add(comboBox_15);
		
		JComboBox comboBox_16 = new JComboBox(new Object[]{});
		comboBox_16.setBounds(480, 125, 100, 25);
		contentPane.add(comboBox_16);
		
		JComboBox comboBox_17 = new JComboBox(new Object[]{});
		comboBox_17.setBounds(480, 155, 100, 25);
		contentPane.add(comboBox_17);
		
		JComboBox comboBox_18 = new JComboBox(new Object[]{});
		comboBox_18.setBounds(480, 185, 100, 25);
		contentPane.add(comboBox_18);
		
		JComboBox comboBox_19 = new JComboBox(new Object[]{});
		comboBox_19.setBounds(480, 215, 100, 25);
		contentPane.add(comboBox_19);
		
		textField_44 = new JTextField(2);
		textField_44.setText("31");
		textField_44.setBounds(480, 265, 100, 25);
		contentPane.add(textField_44);
		
		textField_45 = new JTextField(2);
		textField_45.setText("31");
		textField_45.setBounds(480, 290, 100, 25);
		contentPane.add(textField_45);
		
		textField_46 = new JTextField(2);
		textField_46.setText("31");
		textField_46.setBounds(480, 315, 100, 25);
		contentPane.add(textField_46);
		
		textField_47 = new JTextField(2);
		textField_47.setText("31");
		textField_47.setBounds(480, 340, 100, 25);
		contentPane.add(textField_47);
		
		textField_48 = new JTextField(2);
		textField_48.setText("31");
		textField_48.setBounds(480, 365, 100, 25);
		contentPane.add(textField_48);
		
		textField_49 = new JTextField(2);
		textField_49.setText("31");
		textField_49.setBounds(480, 390, 100, 25);
		contentPane.add(textField_49);
		
		textField_50 = new JTextField(2);
		textField_50.setText("0");
		textField_50.setBounds(480, 435, 100, 25);
		contentPane.add(textField_50);
		
		textField_51 = new JTextField(2);
		textField_51.setText("0");
		textField_51.setBounds(480, 460, 100, 25);
		contentPane.add(textField_51);
		
		textField_52 = new JTextField(2);
		textField_52.setText("0");
		textField_52.setBounds(480, 485, 100, 25);
		contentPane.add(textField_52);
		
		textField_53 = new JTextField(2);
		textField_53.setText("0");
		textField_53.setBounds(480, 510, 100, 25);
		contentPane.add(textField_53);
		
		textField_54 = new JTextField(2);
		textField_54.setText("0");
		textField_54.setBounds(480, 535, 100, 25);
		contentPane.add(textField_54);
		
		textField_55 = new JTextField(2);
		textField_55.setText("0");
		textField_55.setBounds(480, 560, 100, 25);
		contentPane.add(textField_55);
		
		textField_56 = new JTextField(30);
		textField_56.setToolTipText("Pokemon");
		textField_56.setBounds(610, 25, 100, 25);
		contentPane.add(textField_56);
		
		textField_57 = new JTextField(30);
		textField_57.setToolTipText("Pokemon");
		textField_57.setBounds(610, 55, 100, 25);
		contentPane.add(textField_57);
		
		JComboBox comboBox_20 = new JComboBox(new Object[]{});
		comboBox_20.setBounds(610, 95, 100, 25);
		contentPane.add(comboBox_20);
		
		JComboBox comboBox_21 = new JComboBox(new Object[]{});
		comboBox_21.setBounds(610, 125, 100, 25);
		contentPane.add(comboBox_21);
		
		JComboBox comboBox_22 = new JComboBox(new Object[]{});
		comboBox_22.setBounds(610, 155, 100, 25);
		contentPane.add(comboBox_22);
		
		JComboBox comboBox_23 = new JComboBox(new Object[]{});
		comboBox_23.setBounds(610, 185, 100, 25);
		contentPane.add(comboBox_23);
		
		JComboBox comboBox_24 = new JComboBox(new Object[]{});
		comboBox_24.setBounds(610, 215, 100, 25);
		contentPane.add(comboBox_24);
		
		textField_58 = new JTextField(2);
		textField_58.setText("31");
		textField_58.setBounds(610, 265, 100, 25);
		contentPane.add(textField_58);
		
		textField_59 = new JTextField(2);
		textField_59.setText("31");
		textField_59.setBounds(610, 290, 100, 25);
		contentPane.add(textField_59);
		
		textField_60 = new JTextField(2);
		textField_60.setText("31");
		textField_60.setBounds(610, 315, 100, 25);
		contentPane.add(textField_60);
		
		textField_61 = new JTextField(2);
		textField_61.setText("31");
		textField_61.setBounds(610, 340, 100, 25);
		contentPane.add(textField_61);
		
		textField_62 = new JTextField(2);
		textField_62.setText("31");
		textField_62.setBounds(610, 365, 100, 25);
		contentPane.add(textField_62);
		
		textField_63 = new JTextField(2);
		textField_63.setText("31");
		textField_63.setBounds(610, 390, 100, 25);
		contentPane.add(textField_63);
		
		textField_64 = new JTextField(2);
		textField_64.setText("0");
		textField_64.setBounds(610, 435, 100, 25);
		contentPane.add(textField_64);
		
		textField_65 = new JTextField(2);
		textField_65.setText("0");
		textField_65.setBounds(610, 460, 100, 25);
		contentPane.add(textField_65);
		
		textField_66 = new JTextField(2);
		textField_66.setText("0");
		textField_66.setBounds(610, 485, 100, 25);
		contentPane.add(textField_66);
		
		textField_67 = new JTextField(2);
		textField_67.setText("0");
		textField_67.setBounds(610, 510, 100, 25);
		contentPane.add(textField_67);
		
		textField_68 = new JTextField(2);
		textField_68.setText("0");
		textField_68.setBounds(610, 535, 100, 25);
		contentPane.add(textField_68);
		
		textField_69 = new JTextField(2);
		textField_69.setText("0");
		textField_69.setBounds(610, 560, 100, 25);
		contentPane.add(textField_69);
		
		textField_70 = new JTextField(30);
		textField_70.setToolTipText("Pokemon");
		textField_70.setBounds(740, 25, 100, 25);
		contentPane.add(textField_70);
		
		textField_71 = new JTextField(30);
		textField_71.setToolTipText("Pokemon");
		textField_71.setBounds(740, 55, 100, 25);
		contentPane.add(textField_71);
		
		JComboBox comboBox_25 = new JComboBox(new Object[]{});
		comboBox_25.setBounds(740, 95, 100, 25);
		contentPane.add(comboBox_25);
		
		JComboBox comboBox_26 = new JComboBox(new Object[]{});
		comboBox_26.setBounds(740, 125, 100, 25);
		contentPane.add(comboBox_26);
		
		JComboBox comboBox_27 = new JComboBox(new Object[]{});
		comboBox_27.setBounds(740, 155, 100, 25);
		contentPane.add(comboBox_27);
		
		JComboBox comboBox_28 = new JComboBox(new Object[]{});
		comboBox_28.setBounds(740, 185, 100, 25);
		contentPane.add(comboBox_28);
		
		JComboBox comboBox_29 = new JComboBox(new Object[]{});
		comboBox_29.setBounds(740, 215, 100, 25);
		contentPane.add(comboBox_29);
		
		textField_72 = new JTextField(2);
		textField_72.setText("31");
		textField_72.setBounds(740, 265, 100, 25);
		contentPane.add(textField_72);
		
		textField_73 = new JTextField(2);
		textField_73.setText("31");
		textField_73.setBounds(740, 290, 100, 25);
		contentPane.add(textField_73);
		
		textField_74 = new JTextField(2);
		textField_74.setText("31");
		textField_74.setBounds(740, 315, 100, 25);
		contentPane.add(textField_74);
		
		textField_75 = new JTextField(2);
		textField_75.setText("31");
		textField_75.setBounds(740, 340, 100, 25);
		contentPane.add(textField_75);
		
		textField_76 = new JTextField(2);
		textField_76.setText("31");
		textField_76.setBounds(740, 365, 100, 25);
		contentPane.add(textField_76);
		
		textField_77 = new JTextField(2);
		textField_77.setText("31");
		textField_77.setBounds(740, 390, 100, 25);
		contentPane.add(textField_77);
		
		textField_78 = new JTextField(2);
		textField_78.setText("0");
		textField_78.setBounds(740, 435, 100, 25);
		contentPane.add(textField_78);
		
		textField_79 = new JTextField(2);
		textField_79.setText("0");
		textField_79.setBounds(740, 460, 100, 25);
		contentPane.add(textField_79);
		
		textField_80 = new JTextField(2);
		textField_80.setText("0");
		textField_80.setBounds(740, 485, 100, 25);
		contentPane.add(textField_80);
		
		textField_81 = new JTextField(2);
		textField_81.setText("0");
		textField_81.setBounds(740, 510, 100, 25);
		contentPane.add(textField_81);
		
		textField_82 = new JTextField(2);
		textField_82.setText("0");
		textField_82.setBounds(740, 535, 100, 25);
		contentPane.add(textField_82);
		
		textField_83 = new JTextField(2);
		textField_83.setText("0");
		textField_83.setBounds(740, 560, 100, 25);
		contentPane.add(textField_83);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		onViewNotify();
        	}
        });	
		btnRefresh.setBounds(350, 614, 100, 25);
		contentPane.add(btnRefresh);
		
		btnFinalize = new JButton("Finalize");
		btnFinalize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFinalize.setBounds(480, 614, 100, 25);
		contentPane.add(btnFinalize);
	}
}
