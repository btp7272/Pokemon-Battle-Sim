package pokemonBattleSim.views;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BattleView extends JFrame {
	
	private JLabel firstPokemonNameLabel = new JLabel("First Pokemon: ");
	private JTextField firstPokemonName = new JTextField(10);
	private JLabel secondPokemonNameLabel = new JLabel("Second Pokemon: ");
	private JTextField secondPokemonName = new JTextField(10);
	private JLabel moveToUseLabel = new JLabel("Move: ");
	private JTextField moveToUse = new JTextField(10);
	private JButton moveButton = new JButton("Use Move");
	
	public BattleView() throws HeadlessException 
	{
		// temporary panel, must populate with UI elements before swapping it
		JPanel battlePanel = new JPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(175,220);
		
		battlePanel.add(firstPokemonNameLabel);
		battlePanel.add(firstPokemonName);
		battlePanel.add(secondPokemonNameLabel);
		battlePanel.add(secondPokemonName);
		battlePanel.add(moveToUseLabel);
		battlePanel.add(moveToUse);
		battlePanel.add(moveButton);
		
		this.add(battlePanel);
		
	}
	
	public BattleView(GraphicsConfiguration arg0) 
	{
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public BattleView(String arg0) throws HeadlessException 
	{
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public BattleView(String arg0, GraphicsConfiguration arg1) 
	{
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public String getFirstPokemonName()
	{
		return firstPokemonName.getText();
	}
	
	public String getSecondPokemonName()
	{
		return secondPokemonName.getText();
	}
	
	public String getMoveToUse()
	{
		return moveToUse.getText();
	}
	
	public void addMoveButtonListener(ActionListener listenerForMoveButton)
	{
		moveButton.addActionListener(listenerForMoveButton);
	}
	
	public void displayPopupMessage(String message)
	{
		JOptionPane.showMessageDialog(this, message);
	}
}
