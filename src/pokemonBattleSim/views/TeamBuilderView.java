package pokemonBattleSim.views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import pokemonBattleSim.models.*;
import pokemonBattleSim.types.*;

public class TeamBuilderView extends JPanel implements IPokemonView{
	
	public void onViewNotify()
	{
	model = TeamBuilderModel.getInstance();
	if (model == null) 
	return;
	
	/*
	 * update things
	 */

    pokeOne = poke1.getText();
    pokeTwo = poke2.getText();
    pokeThree = poke3.getText();
    pokeFour = poke4.getText();
    pokeFive = poke5.getText();
    pokeSix = poke6.getText();
	
    moves1 = model.generateMoves(pokeOne);
	moves2 = model.generateMoves(pokeTwo);
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
	
	}
	
	public void Finalize()
	{
		
	}
	
	
	
	
	
	
	
	TeamBuilderModel model;
	
	public String pokeOne;
	public String pokeTwo;
	public String pokeThree;
	public String pokeFour;
	public String pokeFive;
	public String pokeSix;
	
	public String moves1;
	public String moves2;
	public String moves3;
	public String moves4;
	public String moves5;
	public String moves6;
	
	public String abilities1;
	public String abilities2;
	public String abilities3;
	public String abilities4;
	public String abilities5;
	public String abilities6;
	
    private JTextField poke1;
    private JTextField poke3;
    private JTextField poke4;
    private JTextField poke5;
    private JTextField poke6;
    private JTextField poke1iv6;
    private JLabel poke3Label;
    private JLabel poke1Label;
    private JLabel poke2Label;
    private JLabel poke4Label;
    private JLabel poke5Label;
    private JLabel poke6Label;
    private JLabel pokemonHeader;
    private JTextField poke2;
    private JComboBox poke1Ability;
    private JComboBox poke1move1;
    private JComboBox poke1move2;
    private JComboBox poke1move3;
    private JComboBox poke2move4;
    private JComboBox poke2move3;
    private JComboBox poke2move2;
    private JComboBox poke2move1;
    private JComboBox poke3move2;
    private JComboBox poke3move3;
    private JComboBox poke3move4;
    private JComboBox poke4move1;
    private JComboBox poke3move1;
    private JComboBox poke4move2;
    private JComboBox poke5move1;
    private JComboBox poke5move2;
    private JComboBox poke6move2;
    private JComboBox poke6move1;
    private JComboBox poke4move4;
    private JComboBox poke6move3;
    private JComboBox poke4move3;
    private JComboBox poke5move3;
    private JComboBox poke6move4;
    private JComboBox poke5move4;
    private JLabel move1Label;
    private JLabel move2Label;
    private JLabel move3Label;
    private JLabel move4Label;
    private JLabel iv1Label;
    private JLabel abilityLabel;
    private JComboBox poke1move4;
    private JComboBox poke2Ability;
    private JComboBox poke3Ability;
    private JComboBox poke4Ability;
    private JComboBox poke5Ability;
    private JComboBox poke6Ability;
    private JLabel iv2Label;
    private JLabel iv3Label;
    private JLabel iv4Label;
    private JLabel iv6Label;
    private JLabel iv5Label;
    private JTextField poke1iv1;
    private JTextField poke1iv3;
    private JTextField poke1iv2;
    private JTextField poke1iv4;
    private JTextField poke1iv5;
    private JLabel ev2Label;
    private JLabel ev1Label;
    private JLabel ev4Label;
    private JLabel ev3Label;
    private JLabel ev5Label;
    private JLabel ev6Label;
    private JPasswordField nickname1;
    private JTextField nickname2;
    private JLabel nicknameHeader;
    private JTextField nickname3;
    private JTextField nickname4;
    private JTextField nickname5;
    private JTextField nickname6;
    private JTextField poke1ev2;
    private JTextField poke1ev4;
    private JTextField poke1ev6;
    private JTextField poke1ev3;
    private JTextField poke1ev1;
    private JTextField poke1ev5;
    private JButton FinalizeButton;
    private JButton RefreshButton;
    private JTextField poke5ev1;
    private JTextField poke2ev1;
    private JTextField poke3ev1;
    private JTextField poke4ev1;
    private JTextField poke2iv1;
    private JTextField poke3iv1;
    private JTextField poke4iv1;
    private JTextField poke5iv1;
    private JTextField poke6iv1;
    private JTextField poke6ev1;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
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
    private JTextField poke2ev6;
    private JTextField poke2ev3;
    private JTextField poke2ev2;
    private JTextField poke2ev4;
    private JTextField poke2ev5;
    private JTextField poke3ev6;
    private JTextField poke3ev3;
    private JTextField poke3ev2;
    private JTextField poke3ev4;
    private JTextField poke3ev5;
    private JTextField poke4ev6;
    private JTextField poke4ev3;
    private JTextField poke4ev2;
    private JTextField poke4ev4;
    private JTextField poke4ev5;
    private JTextField poke5ev6;
    private JTextField poke5ev3;
    private JTextField poke5ev2;
    private JTextField poke5ev4;
    private JTextField poke5ev5;
    private JTextField poke6ev6;
    private JTextField poke6ev3;
    private JTextField poke6ev2;
    private JTextField poke6ev4;
    private JTextField poke6ev5;

    public TeamBuilderView() {
    	
    	//adjust size and set layout
        setPreferredSize (new Dimension(955, 592));
        setLayout (null);
        
        //construct preComponents
        String[] jcomp15Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp16Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp17Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp18Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp19Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp20Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp21Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp22Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp23Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp24Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp25Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp26Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp27Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp28Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp29Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp30Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp31Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp32Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp33Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp34Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp35Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp36Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp37Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp38Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp45Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp46Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp47Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp48Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp49Items = {"Item 1", "Item 2", "Item 3"};
        String[] jcomp50Items = {"Item 1", "Item 2", "Item 3"};
        
        //construct components
        /*
         * Pokemon Names
         */
        {
	        poke1 = new JTextField (30);
	        poke1.setText("1");
	        poke2 = new JTextField (30);
	        poke2.setText("2");
	        poke3 = new JTextField (30);
	        poke3.setText("3");
	        poke4 = new JTextField (30);
	        poke4.setText("4");
	        poke5 = new JTextField (30);
	        poke5.setText("5");
	        poke6 = new JTextField (30);
	        poke6.setText("6");
        }
        
        /*
         * Pokemon NickNames
         */
        {
        	nickname1 = new JPasswordField (5);
            nickname2 = new JTextField (5);
            nickname3 = new JTextField (5);
            nickname4 = new JTextField (5);
            nickname5 = new JTextField (5);
            nickname6 = new JTextField (5);
        }
        
        /*
         * Labels
         */
        {
        	{	//IV labels
        		iv1Label = new JLabel ("IV 1 (max 31)");
	        	iv2Label = new JLabel ("IV 2 (max 31)");
	            iv3Label = new JLabel ("IV 3 (max 31)");
	            iv4Label = new JLabel ("IV 4 (max 31)");
	            iv5Label = new JLabel ("IV 5 (max 31)");
	            iv6Label = new JLabel ("IV 6 (max 31)");
        	}
        	
        	{   //Pokemon Labels
	        	poke1Label = new JLabel ("Pokemon 1");
		        poke2Label = new JLabel ("Pokemon 2");
		        poke3Label = new JLabel ("Pokemon 3");
		        poke4Label = new JLabel ("Pokemon 4");
		        poke5Label = new JLabel ("Pokemon 5");
		        poke6Label = new JLabel ("Pokemon 6");
        	}
        	
        	{	//Move Labels
        		move1Label = new JLabel ("Move 1");
                move2Label = new JLabel ("Move 2");
                move3Label = new JLabel ("Move 3");
                move4Label = new JLabel ("Move 4");
        	}
        	
        	{	//EV Labels
                ev1Label = new JLabel ("EV 1(max 252)");
                ev2Label = new JLabel ("EV 2(max 252)");
                ev3Label = new JLabel ("EV 3(max 252)");
                ev4Label = new JLabel ("EV 4(max 252)");
                ev5Label = new JLabel ("EV 5(max 252)");
                ev6Label = new JLabel ("EV 6(max 252)");
        	}
        	
        	{	//Other Labels
        		abilityLabel = new JLabel ("Ability");
        		pokemonHeader = new JLabel ("Pokemon");
        		nicknameHeader = new JLabel ("Nickname");
        	}
        }
        
        
        /*
         * Abilities
         */
        {
        	poke1Ability = new JComboBox (jcomp15Items);
            poke1Ability.setModel(new DefaultComboBoxModel(new String[] {abilities1}));
            poke2Ability = new JComboBox (jcomp46Items);
            poke2Ability.setModel(new DefaultComboBoxModel(new String[] {abilities2}));
            poke3Ability = new JComboBox (jcomp47Items);
            poke3Ability.setModel(new DefaultComboBoxModel(new String[] {abilities3}));
            poke4Ability = new JComboBox (jcomp48Items);
            poke4Ability.setModel(new DefaultComboBoxModel(new String[] {abilities4}));
            poke5Ability = new JComboBox (jcomp49Items);
            poke5Ability.setModel(new DefaultComboBoxModel(new String[] {abilities5}));
            poke6Ability = new JComboBox (jcomp50Items);
            poke6Ability.setModel(new DefaultComboBoxModel(new String[] {abilities6}));
        }
        
        /*
         * Moves
         */
        {
        	{	//Poke1
        		poke1move1 = new JComboBox (jcomp16Items);
        	    poke1move1.setModel(new DefaultComboBoxModel(new String[] {moves1}));
        	    poke1move2 = new JComboBox (jcomp17Items);
        	    poke1move2.setModel(new DefaultComboBoxModel(new String[] {moves1}));
        	    poke1move3 = new JComboBox (jcomp18Items);
        	    poke1move3.setModel(new DefaultComboBoxModel(new String[] {moves1}));
        	    poke1move4 = new JComboBox (jcomp45Items);
                poke1move4.setModel(new DefaultComboBoxModel(new String[] {moves1}));
        	}
        	
        	{	//Poke2
        		poke2move1 = new JComboBox (jcomp22Items);
                poke2move1.setModel(new DefaultComboBoxModel(new String[] {moves2}));
                poke2move2 = new JComboBox (jcomp21Items);
                poke2move2.setModel(new DefaultComboBoxModel(new String[] {moves2}));
                poke2move3 = new JComboBox (jcomp20Items);
                poke2move3.setModel(new DefaultComboBoxModel(new String[] {moves2}));
                poke2move4 = new JComboBox (jcomp19Items);
                poke2move4.setModel(new DefaultComboBoxModel(new String[] {moves2}));
        	}
        	
        	{	//Poke3
        		poke3move1 = new JComboBox (jcomp27Items);
                poke3move1.setModel(new DefaultComboBoxModel(new String[] {moves3}));
        		poke3move2 = new JComboBox (jcomp23Items);
                poke3move2.setModel(new DefaultComboBoxModel(new String[] {moves3}));
                poke3move3 = new JComboBox (jcomp24Items);
                poke3move3.setModel(new DefaultComboBoxModel(new String[] {moves3}));
                poke3move4 = new JComboBox (jcomp25Items);
                poke3move4.setModel(new DefaultComboBoxModel(new String[] {moves3}));
        	}
        	
        	{	//Poke4
        		poke4move1 = new JComboBox (jcomp26Items);
        		poke4move1.setModel(new DefaultComboBoxModel(new String[] {moves4}));
        		poke4move2 = new JComboBox (jcomp28Items);
                poke4move2.setModel(new DefaultComboBoxModel(new String[] {moves4}));
                poke4move3 = new JComboBox (jcomp35Items);
                poke4move3.setModel(new DefaultComboBoxModel(new String[] {moves4}));
                poke4move4 = new JComboBox (jcomp33Items);
                poke4move4.setModel(new DefaultComboBoxModel(new String[] {moves4}));
        	}
        	
        	{	//Poke5
        		poke5move1 = new JComboBox (jcomp29Items);
                poke5move1.setModel(new DefaultComboBoxModel(new String[] {moves5}));
                poke5move2 = new JComboBox (jcomp30Items);
                poke5move2.setModel(new DefaultComboBoxModel(new String[] {moves5}));
                poke5move3 = new JComboBox (jcomp36Items);
                poke5move3.setModel(new DefaultComboBoxModel(new String[] {moves5}));
                poke5move4 = new JComboBox (jcomp38Items);
                poke5move4.setModel(new DefaultComboBoxModel(new String[] {moves5}));
        	}
        	
        	{	//Poke6
        		poke6move1 = new JComboBox (jcomp32Items);
        	    poke6move1.setModel(new DefaultComboBoxModel(new String[] {moves6}));
        		poke6move2 = new JComboBox (jcomp31Items);
                poke6move2.setModel(new DefaultComboBoxModel(new String[] {moves6}));
                poke6move3 = new JComboBox (jcomp34Items);
                poke6move3.setModel(new DefaultComboBoxModel(new String[] {moves6}));
                poke6move4 = new JComboBox (jcomp37Items);
                poke6move4.setModel(new DefaultComboBoxModel(new String[] {moves6}));
        	}
        }
        
        /*
         * IVs
         */
        {
        	{	//poke1
	        	poke1iv1 = new JTextField (2);
	            poke1iv2 = new JTextField (2);
	            poke1iv3 = new JTextField (2);
	            poke1iv4 = new JTextField (2);
	            poke1iv5 = new JTextField (2);
	            poke1iv6 = new JTextField (2);
        	}
        	
        	{	//poke2
        		
        	}
        	
        	{	//poke3
        		
        	}
        	
        	{	//poke4
        		
        	}
        }
        
        /*
         * EVs
         */
        {
        	{	//poke1
        		poke1ev1 = new JTextField (5);
        		poke1ev2 = new JTextField (5);
        		poke1ev3 = new JTextField (5);
        		poke1ev4 = new JTextField (5);
        		poke1ev5 = new JTextField (5);
        		poke1ev6 = new JTextField (5);
        	}
        	{	//poke2
        		
        	}
        	{	//poke3
        		
        	}
        	{	//poke4
        		
        	}
        	{	//poke5
        		
        	}
        	{	//poke6
        		
        	}
        }
        
        
        
        /*
         * Tooltips
         */
        {
        	poke1.setToolTipText ("Pokemon");
        	poke2.setToolTipText ("Pokemon");
        	poke3.setToolTipText ("Pokemon");
            poke4.setToolTipText ("Pokemon");
            poke5.setToolTipText ("Pokemon");
            poke6.setToolTipText ("Pokemon");
        }
        
        FinalizeButton = new JButton ("Finalize");
        RefreshButton = new JButton ("Refresh");
        RefreshButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });

        //set components properties
        

        

        //add components
        add (poke1);
        add (poke3);
        add (poke4);
        add (poke5);
        add (poke6);
        add (poke1iv6);
        add (poke3Label);
        add (poke1Label);
        add (poke2Label);
        add (poke4Label);
        add (poke5Label);
        add (poke6Label);
        add (pokemonHeader);
        add (poke2);
        add (poke1Ability);
        add (poke1move1);
        add (poke1move2);
        add (poke1move3);
        add (poke2move4);
        add (poke2move3);
        add (poke2move2);
        add (poke2move1);
        add (poke3move2);
        add (poke3move3);
        add (poke3move4);
        add (poke4move1);
        add (poke3move1);
        add (poke4move2);
        add (poke5move1);
        add (poke5move2);
        add (poke6move2);
        add (poke6move1);
        add (poke4move4);
        add (poke6move3);
        add (poke4move3);
        add (poke5move3);
        add (poke6move4);
        add (poke5move4);
        add (move1Label);
        add (move2Label);
        add (move3Label);
        add (move4Label);
        add (iv1Label);
        add (abilityLabel);
        add (poke1move4);
        add (poke2Ability);
        add (poke3Ability);
        add (poke4Ability);
        add (poke5Ability);
        add (poke6Ability);
        add (iv2Label);
        add (iv3Label);
        add (iv4Label);
        add (iv6Label);
        add (iv5Label);
        add (poke1iv1);
        add (poke1iv3);
        add (poke1iv2);
        add (poke1iv4);
        add (poke1iv5);
        add (ev2Label);
        add (ev1Label);
        add (ev4Label);
        add (ev3Label);
        add (ev5Label);
        add (ev6Label);
        add (nickname1);
        add (nickname2);
        add (nicknameHeader);
        add (nickname3);
        add (nickname4);
        add (nickname5);
        add (nickname6);
        add (poke1ev2);
        add (poke1ev4);
        add (poke1ev6);
        add (poke1ev3);
        add (poke1ev1);
        add (poke1ev5);
        add (FinalizeButton);
        add (RefreshButton);

        //set component bounds (only needed by Absolute Positioning)
        poke1.setBounds (90, 25, 100, 25);
        poke3.setBounds (375, 25, 100, 25);
        poke4.setBounds (515, 25, 100, 25);
        poke5.setBounds (660, 25, 100, 25);
        poke6.setBounds (800, 25, 100, 25);
        poke1iv6.setBounds (90, 362, 100, 25);
        poke3Label.setBounds (375, 0, 100, 25);
        poke1Label.setBounds (90, 0, 70, 25);
        poke2Label.setBounds (230, 0, 100, 25);
        poke4Label.setBounds (520, 0, 100, 25);
        poke5Label.setBounds (660, 0, 100, 25);
        poke6Label.setBounds (800, 0, 100, 25);
        pokemonHeader.setBounds (5, 25, 100, 25);
        poke2.setBounds (230, 25, 100, 25);
        poke1Ability.setBounds (90, 215, 100, 25);
        poke1move1.setBounds (90, 95, 100, 25);
        poke1move2.setBounds (90, 125, 100, 25);
        poke1move3.setBounds (90, 155, 100, 25);
        poke2move4.setBounds (230, 185, 100, 25);
        poke2move3.setBounds (230, 155, 100, 25);
        poke2move2.setBounds (230, 125, 100, 25);
        poke2move1.setBounds (230, 95, 100, 25);
        poke3move2.setBounds (375, 125, 100, 25);
        poke3move3.setBounds (375, 155, 100, 25);
        poke3move4.setBounds (375, 185, 100, 25);
        poke4move1.setBounds (515, 95, 100, 25);
        poke3move1.setBounds (375, 95, 100, 25);
        poke4move2.setBounds (515, 125, 100, 25);
        poke5move1.setBounds (660, 95, 100, 25);
        poke5move2.setBounds (660, 125, 100, 25);
        poke6move2.setBounds (800, 125, 100, 25);
        poke6move1.setBounds (800, 95, 100, 25);
        poke4move4.setBounds (515, 185, 100, 25);
        poke6move3.setBounds (800, 155, 100, 25);
        poke4move3.setBounds (515, 155, 100, 25);
        poke5move3.setBounds (660, 155, 100, 25);
        poke6move4.setBounds (800, 185, 100, 25);
        poke5move4.setBounds (660, 185, 100, 25);
        move1Label.setBounds (5, 95, 100, 25);
        move2Label.setBounds (5, 125, 100, 25);
        move3Label.setBounds (5, 155, 100, 25);
        move4Label.setBounds (5, 185, 100, 25);
        iv1Label.setBounds (5, 252, 100, 25);
        abilityLabel.setBounds (5, 215, 100, 25);
        poke1move4.setBounds (90, 185, 100, 25);
        poke2Ability.setBounds (230, 215, 100, 25);
        poke3Ability.setBounds (375, 215, 100, 25);
        poke4Ability.setBounds (515, 215, 100, 25);
        poke5Ability.setBounds (660, 215, 100, 25);
        poke6Ability.setBounds (800, 215, 100, 25);
        iv2Label.setBounds (5, 274, 100, 25);
        iv3Label.setBounds (5, 296, 100, 25);
        iv4Label.setBounds (5, 318, 100, 25);
        iv6Label.setBounds (5, 362, 100, 25);
        iv5Label.setBounds (5, 340, 100, 25);
        poke1iv1.setBounds (90, 252, 100, 25);
        poke1iv3.setBounds (90, 296, 100, 25);
        poke1iv2.setBounds (90, 274, 100, 25);
        poke1iv4.setBounds (90, 318, 100, 25);
        poke1iv5.setBounds (90, 340, 100, 25);
        ev2Label.setBounds (5, 434, 100, 25);
        ev1Label.setBounds (5, 412, 100, 25);
        ev4Label.setBounds (5, 478, 100, 25);
        ev3Label.setBounds (5, 456, 100, 25);
        ev5Label.setBounds (5, 500, 100, 25);
        ev6Label.setBounds (5, 522, 100, 25);
        nickname1.setBounds (90, 55, 100, 25);
        nickname2.setBounds (230, 55, 100, 25);
        nicknameHeader.setBounds (5, 55, 100, 25);
        nickname3.setBounds (375, 55, 100, 25);
        nickname4.setBounds (515, 55, 100, 25);
        nickname5.setBounds (660, 55, 100, 25);
        nickname6.setBounds (800, 55, 100, 25);
        poke1ev2.setBounds (90, 434, 100, 25);
        poke1ev4.setBounds (90, 478, 100, 25);
        poke1ev6.setBounds (90, 522, 100, 25);
        poke1ev3.setBounds (90, 456, 100, 25);
        poke1ev1.setBounds (90, 412, 100, 25);
        poke1ev5.setBounds (90, 500, 100, 25);
        FinalizeButton.setBounds (515, 561, 100, 25);
        RefreshButton.setBounds (375, 561, 100, 25);
        
        JLabel evHeader = new JLabel("Effort Values (max total 510)");
        evHeader.setBounds(52, 400, 195, 14);
        add(evHeader);
        
        JLabel ivHeader = new JLabel("Individual Values");
        ivHeader.setBounds(90, 238, 130, 14);
        add(ivHeader);
        
        poke5ev1 = new JTextField();
        poke5ev1.setBounds(660, 412, 100, 25);
        add(poke5ev1);
        poke5ev1.setColumns(10);
        
        poke2ev1 = new JTextField();
        poke2ev1.setColumns(10);
        poke2ev1.setBounds(230, 412, 100, 25);
        add(poke2ev1);
        
        poke3ev1 = new JTextField();
        poke3ev1.setColumns(10);
        poke3ev1.setBounds(375, 412, 100, 25);
        add(poke3ev1);
        
        poke4ev1 = new JTextField();
        poke4ev1.setColumns(10);
        poke4ev1.setBounds(515, 412, 100, 25);
        add(poke4ev1);
        
        poke2iv1 = new JTextField();
        poke2iv1.setColumns(10);
        poke2iv1.setBounds(230, 252, 100, 25);
        add(poke2iv1);
        
        poke3iv1 = new JTextField();
        poke3iv1.setColumns(10);
        poke3iv1.setBounds(375, 252, 100, 25);
        add(poke3iv1);
        
        poke4iv1 = new JTextField();
        poke4iv1.setColumns(10);
        poke4iv1.setBounds(515, 252, 100, 25);
        add(poke4iv1);
        
        poke5iv1 = new JTextField();
        poke5iv1.setColumns(10);
        poke5iv1.setBounds(660, 252, 100, 25);
        add(poke5iv1);
        
        poke6iv1 = new JTextField();
        poke6iv1.setColumns(10);
        poke6iv1.setBounds(800, 252, 100, 25);
        add(poke6iv1);
        
        poke6ev1 = new JTextField();
        poke6ev1.setColumns(10);
        poke6ev1.setBounds(800, 412, 100, 25);
        add(poke6ev1);
        
        textField_4 = new JTextField(5);
        textField_4.setBounds(230, 362, 100, 25);
        add(textField_4);
        
        textField_5 = new JTextField(5);
        textField_5.setBounds(230, 296, 100, 25);
        add(textField_5);
        
        textField_6 = new JTextField(5);
        textField_6.setBounds(230, 274, 100, 25);
        add(textField_6);
        
        textField_7 = new JTextField(5);
        textField_7.setBounds(230, 318, 100, 25);
        add(textField_7);
        
        textField_8 = new JTextField(5);
        textField_8.setBounds(230, 340, 100, 25);
        add(textField_8);
        
        textField_10 = new JTextField(5);
        textField_10.setBounds(375, 362, 100, 25);
        add(textField_10);
        
        textField_11 = new JTextField(5);
        textField_11.setBounds(375, 296, 100, 25);
        add(textField_11);
        
        textField_12 = new JTextField(5);
        textField_12.setBounds(375, 274, 100, 25);
        add(textField_12);
        
        textField_13 = new JTextField(5);
        textField_13.setBounds(375, 318, 100, 25);
        add(textField_13);
        
        textField_14 = new JTextField(5);
        textField_14.setBounds(375, 340, 100, 25);
        add(textField_14);
        
        textField_15 = new JTextField(5);
        textField_15.setBounds(515, 362, 100, 25);
        add(textField_15);
        
        textField_16 = new JTextField(5);
        textField_16.setBounds(515, 296, 100, 25);
        add(textField_16);
        
        textField_17 = new JTextField(5);
        textField_17.setBounds(515, 274, 100, 25);
        add(textField_17);
        
        textField_18 = new JTextField(5);
        textField_18.setBounds(515, 318, 100, 25);
        add(textField_18);
        
        textField_19 = new JTextField(5);
        textField_19.setBounds(515, 340, 100, 25);
        add(textField_19);
        
        textField_20 = new JTextField(5);
        textField_20.setBounds(660, 362, 100, 25);
        add(textField_20);
        
        textField_21 = new JTextField(5);
        textField_21.setBounds(660, 296, 100, 25);
        add(textField_21);
        
        textField_22 = new JTextField(5);
        textField_22.setBounds(660, 274, 100, 25);
        add(textField_22);
        
        textField_23 = new JTextField(5);
        textField_23.setBounds(660, 318, 100, 25);
        add(textField_23);
        
        textField_24 = new JTextField(5);
        textField_24.setBounds(660, 340, 100, 25);
        add(textField_24);
        
        textField_25 = new JTextField(5);
        textField_25.setBounds(800, 362, 100, 25);
        add(textField_25);
        
        textField_26 = new JTextField(5);
        textField_26.setBounds(800, 296, 100, 25);
        add(textField_26);
        
        textField_27 = new JTextField(5);
        textField_27.setBounds(800, 274, 100, 25);
        add(textField_27);
        
        textField_28 = new JTextField(5);
        textField_28.setBounds(800, 318, 100, 25);
        add(textField_28);
        
        textField_29 = new JTextField(5);
        textField_29.setBounds(800, 340, 100, 25);
        add(textField_29);
        
        poke2ev6 = new JTextField(5);
        poke2ev6.setBounds(230, 522, 100, 25);
        add(poke2ev6);
        
        poke2ev3 = new JTextField(5);
        poke2ev3.setBounds(230, 456, 100, 25);
        add(poke2ev3);
        
        poke2ev2 = new JTextField(5);
        poke2ev2.setBounds(230, 434, 100, 25);
        add(poke2ev2);
        
        poke2ev4 = new JTextField(5);
        poke2ev4.setBounds(230, 478, 100, 25);
        add(poke2ev4);
        
        poke2ev5 = new JTextField(5);
        poke2ev5.setBounds(230, 500, 100, 25);
        add(poke2ev5);
        
        poke3ev6 = new JTextField(5);
        poke3ev6.setBounds(375, 522, 100, 25);
        add(poke3ev6);
        
        poke3ev3 = new JTextField(5);
        poke3ev3.setBounds(375, 456, 100, 25);
        add(poke3ev3);
        
        poke3ev2 = new JTextField(5);
        poke3ev2.setBounds(375, 434, 100, 25);
        add(poke3ev2);
        
        poke3ev4 = new JTextField(5);
        poke3ev4.setBounds(375, 478, 100, 25);
        add(poke3ev4);
        
        poke3ev5 = new JTextField(5);
        poke3ev5.setBounds(375, 500, 100, 25);
        add(poke3ev5);
        
        poke4ev6 = new JTextField(5);
        poke4ev6.setBounds(515, 522, 100, 25);
        add(poke4ev6);
        
        poke4ev3 = new JTextField(5);
        poke4ev3.setBounds(515, 456, 100, 25);
        add(poke4ev3);
        
        poke4ev2 = new JTextField(5);
        poke4ev2.setBounds(515, 434, 100, 25);
        add(poke4ev2);
        
        poke4ev4 = new JTextField(5);
        poke4ev4.setBounds(515, 478, 100, 25);
        add(poke4ev4);
        
        poke4ev5 = new JTextField(5);
        poke4ev5.setBounds(515, 500, 100, 25);
        add(poke4ev5);
        
        poke5ev6 = new JTextField(5);
        poke5ev6.setBounds(660, 522, 100, 25);
        add(poke5ev6);
        
        poke5ev3 = new JTextField(5);
        poke5ev3.setBounds(660, 456, 100, 25);
        add(poke5ev3);
        
        poke5ev2 = new JTextField(5);
        poke5ev2.setBounds(660, 434, 100, 25);
        add(poke5ev2);
        
        poke5ev4 = new JTextField(5);
        poke5ev4.setBounds(660, 478, 100, 25);
        add(poke5ev4);
        
        poke5ev5 = new JTextField(5);
        poke5ev5.setBounds(660, 500, 100, 25);
        add(poke5ev5);
        
        poke6ev6 = new JTextField(5);
        poke6ev6.setBounds(800, 522, 100, 25);
        add(poke6ev6);
        
        poke6ev3 = new JTextField(5);
        poke6ev3.setBounds(800, 456, 100, 25);
        add(poke6ev3);
        
        poke6ev2 = new JTextField(5);
        poke6ev2.setBounds(800, 434, 100, 25);
        add(poke6ev2);
        
        poke6ev4 = new JTextField(5);
        poke6ev4.setBounds(800, 478, 100, 25);
        add(poke6ev4);
        
        poke6ev5 = new JTextField(5);
        poke6ev5.setBounds(800, 500, 100, 25);
        add(poke6ev5);
    }
}
