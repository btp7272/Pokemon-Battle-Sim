package pokemonBattleSim.views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BattleView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7696970813661473987L;
	
	//private JPanel battlePanel;
	private JPanel pokemonDataPanel;
	private JPanel pokemonDisplayPanel;
	private JPanel moveQueuePanel;
	private JPanel moveListPanel;
	private JPanel teamListPanel;
	
	private BoxLayout battleLayout;
	private GridLayout pokemonDataLayout;
	private GridLayout pokemonDisplayLayout;
	private FlowLayout moveQueueLayout;
	private GridLayout moveListLayout;
	private GridLayout teamListLayout;
	
	private JPanel playerOnePokemonData;
	private JPanel playerTwoPokemonData;
	
	private GridLayout playerOnePokemonDataLayout;
	private GridLayout playerTwoPokemonDataLayout;
	
	private JLabel playerOnePokemonName;
	private JLabel playerTwoPokemonName;
	private JLabel playerOnePokemonHP;
	private JLabel playerTwoPokemonHP;
	
	private JLabel playerOnePokemonDisplayLabel;
	private JLabel playerTwoPokemonDisplayLabel;
	
	private ImageIcon playerOnePokemonDisplayImage;
	private ImageIcon playerTwoPokemonDisplayImage;
	
	private ArrayList<JButton> moveButtons;
	private ArrayList<JButton> pokemonButtons;
	
	
	public BattleView() throws HeadlessException 
	{
		super();
		// Initialize all components
		//battlePanel = 			new JPanel();
		pokemonDataPanel = 		new JPanel();
		pokemonDisplayPanel = 	new JPanel();
		moveQueuePanel = 		new JPanel();
		moveListPanel =			new JPanel();
		teamListPanel =			new JPanel();
		
		battleLayout = 			new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS);
		pokemonDataLayout = 	new GridLayout(1,2);
		pokemonDisplayLayout = 	new GridLayout(1,2);
		moveQueueLayout = 		new FlowLayout();
		moveListLayout = 		new GridLayout (1,6);
		teamListLayout = 		new GridLayout (1,6);
		
		playerOnePokemonData = 	new JPanel();
		playerTwoPokemonData = 	new JPanel();
		
		playerOnePokemonDataLayout = 	new GridLayout(1,2);
		playerTwoPokemonDataLayout = 	new GridLayout(1,2);
		
		playerOnePokemonName = 			new JLabel("Player 1 Pokemon:");
		playerTwoPokemonName = 			new JLabel("Player 2 Pokemon:");
		playerOnePokemonHP =			new JLabel("0 HP");
		playerTwoPokemonHP =			new JLabel("0 HP");
		
		playerOnePokemonDisplayLabel = 	new JLabel();
		playerTwoPokemonDisplayLabel = 	new JLabel();
		
		playerOnePokemonDisplayImage = 	new ImageIcon();
		playerTwoPokemonDisplayImage = 	new ImageIcon();
		
		moveButtons = new ArrayList<>();
		pokemonButtons = new ArrayList<>();
		
		for (int i = 0; i < 6; i++)
		{
			moveButtons.add(new JButton("Move " + i));
			pokemonButtons.add(new JButton("Pokemon "+i));
		}
		
		// set layouts
		this.setLayout(battleLayout);
		pokemonDataPanel.setLayout(pokemonDataLayout);
		pokemonDisplayPanel.setLayout(pokemonDisplayLayout);
		moveQueuePanel.setLayout(moveQueueLayout);
		moveListPanel.setLayout(moveListLayout);
		teamListPanel.setLayout(teamListLayout);
		
		playerOnePokemonData.setLayout(playerOnePokemonDataLayout);
		playerTwoPokemonData.setLayout(playerTwoPokemonDataLayout);
		
		// build hierarchy
		playerOnePokemonData.add(playerOnePokemonName);
		playerOnePokemonData.add(playerOnePokemonHP);
		playerTwoPokemonData.add(playerTwoPokemonName);
		playerTwoPokemonData.add(playerTwoPokemonHP);
		
		pokemonDataPanel.add(playerOnePokemonData);
		pokemonDataPanel.add(playerTwoPokemonData);
		
		playerOnePokemonDisplayLabel.setHorizontalAlignment(JLabel.CENTER);
		playerTwoPokemonDisplayLabel.setHorizontalAlignment(JLabel.CENTER);
		//playerOnePokemonDisplayLabel.setPreferredSize(new Dimension(300,300));
		//playerTwoPokemonDisplayLabel.setPreferredSize(new Dimension(300,300));
		playerOnePokemonDisplayLabel.setIcon(playerOnePokemonDisplayImage);
		playerTwoPokemonDisplayLabel.setIcon(playerTwoPokemonDisplayImage);
		
		pokemonDisplayPanel.add(playerOnePokemonDisplayLabel);
		pokemonDisplayPanel.add(playerTwoPokemonDisplayLabel);
		
		for ( JButton btn : moveButtons)
		{
			moveListPanel.add(btn);
		}
		
		for ( JButton btn : pokemonButtons)
		{
			teamListPanel.add(btn);
		}
		
		this.add(pokemonDataPanel);
		this.add(pokemonDisplayPanel);
		this.add(moveQueuePanel);
		this.add(moveListPanel);
		this.add(teamListPanel);
		
		// set close operation and add the completed panel
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		//this.add(battlePanel);
	}

	public void setPlayerOnePokemonName(String name)
	{
		playerOnePokemonName.setText(name + ": ");
	}
	
	public void setPlayerTwoPokemonName(String name)
	{
		playerTwoPokemonName.setText(name + ": ");
	}
	
	public void setPlayerOnePokemonHP(int hp)
	{
		playerOnePokemonHP.setText(hp + " HP");
	}
	
	public void setPlayerTwoPokemonHP(int hp)
	{
		playerTwoPokemonHP.setText(hp + " HP");
	}
	
	public void setPlayerOnePokemonDisplayImage(String resource)
	{
		playerOnePokemonDisplayImage = new ImageIcon(this.getClass().getResource("/pokemonBattleSim/resources/images/"+resource+".gif"));
		playerOnePokemonDisplayLabel.setIcon(playerOnePokemonDisplayImage);
	}
	
	public void setPlayerTwoPokemonDisplayImage(String resource)
	{
		playerTwoPokemonDisplayImage = new ImageIcon(this.getClass().getResource("/pokemonBattleSim/resources/images/"+resource+".gif"));
		playerTwoPokemonDisplayLabel.setIcon(playerTwoPokemonDisplayImage);
	}
	
	public void setMoveQueueData(ArrayList<String> moves, ActionListener queueButtonListener)
	{
		moveQueuePanel.removeAll();
		for (String move : moves)
		{
			JButton btn = new JButton(move);
			btn.addActionListener(queueButtonListener);
			moveQueuePanel.add(btn);
		}
	}
	
	public void setMoveButtonData (ArrayList<String> moves, ActionListener moveButtonListener)
	{
		moveListPanel.removeAll();
		for (String move : moves)
		{
			JButton btn = new JButton(move);
			btn.addActionListener(moveButtonListener);
			moveListPanel.add(btn);
		}
	}
	
	public void setPokemonButtonData (ArrayList<String> pokemon, ActionListener pokemonButtonListener)
	{
		teamListPanel.removeAll();
		for (String poke : pokemon)
		{
			JButton btn = new JButton(poke);
			btn.addActionListener(pokemonButtonListener);
			teamListPanel.add(btn);
		}
	}
	
	public void displayPopupMessage(String message)
	{
		JOptionPane.showMessageDialog(this, message);
	}
}
