package pokemonBattleSim.views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
//import java.util.ArrayList;
//import java.util.Timer;
//import java.util.TimerTask;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pokemonBattleSim.models.BattleModel;
import pokemonBattleSim.models.IBattleModel;
import pokemonBattleSim.models.QueuedAction;
import pokemonBattleSim.musicPlayer.AudioPlayer;

public class BattleView extends JFrame implements IView{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7696970813661473987L;
	
	private int playerID;
	private ArrayList<ActionListener> queueButtonListeners;
	private ArrayList<ActionListener> moveButtonListeners;
	private ArrayList<ActionListener> pokemonButtonListeners;
	
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
	
	
	public BattleView(int playerID) throws HeadlessException 
	{
		super();
		this.playerID = playerID;
		this.moveButtonListeners = new ArrayList<>();
		this.queueButtonListeners = new ArrayList<>();
		this.pokemonButtonListeners = new ArrayList<>();
		
		
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
		BattleModel.getInstance().registerView(this);
		onViewNotify();
		new Thread() {
			@Override
			public void run() {
				AudioPlayer player = new AudioPlayer();
				Random ran = new Random(); 
		        int songID = ran.nextInt(12);
		        String resource;
		        if (songID == 0)
		        	resource = this.getClass().getResource("/pokemonBattleSim/resources/soundtrack/DiamondAndPearlCyrusBattleCut.wav").getFile();
		        else if (songID == 1)
		        	resource = this.getClass().getResource("/pokemonBattleSim/resources/soundtrack/HoennBattleFrontierBrainV2.wav").getFile();
		        else if (songID == 2)
		        	resource = this.getClass().getResource("/pokemonBattleSim/resources/soundtrack/HoennWeatherTrioV2Cut.wav").getFile();
		        else if (songID == 3)
		        	resource = this.getClass().getResource("/pokemonBattleSim/resources/soundtrack/MtPyreSummit.wav").getFile();
		        else if (songID == 4)
		        	resource = this.getClass().getResource("/pokemonBattleSim/resources/soundtrack/MysteryDungeonAegisCave.wav").getFile();
		        else if (songID == 5)
		        	resource = this.getClass().getResource("/pokemonBattleSim/resources/soundtrack/MysteryDungeonHiddenHighland.wav").getFile();
		        else if (songID == 6)
		        	resource = this.getClass().getResource("/pokemonBattleSim/resources/soundtrack/ShoalCaveV2.wav").getFile();
		        else if (songID == 7)
		        	resource = this.getClass().getResource("/pokemonBattleSim/resources/soundtrack/SilphCo.wav").getFile();
		        else if (songID == 8)
		        	resource = this.getClass().getResource("/pokemonBattleSim/resources/soundtrack/TeamMagmaAndAquaBossBattleV2.wav").getFile();
		        else if (songID == 9)
		        	resource = this.getClass().getResource("/pokemonBattleSim/resources/soundtrack/TeamPlasma.wav").getFile();
		        else if (songID == 10)
		        	resource = this.getClass().getResource("/pokemonBattleSim/resources/soundtrack/XAndYKantoWildBattleCut.wav").getFile();
		        else //songID is 11
		        	resource = this.getClass().getResource("/pokemonBattleSim/resources/soundtrack/XAndYSnowbelleCity.wav").getFile();
				System.out.println(resource);
				player.play(resource);
			}
		}.start();
	}

	@Override
	public void onViewNotify()
	{
		IBattleModel model = BattleModel.getInstance();
		if (model == null) 
		{
			return;
		}
		
		//displayPopupMessage("Updating");
		this.setPlayerOnePokemonName(model.getPlayerPokemonName(playerID));
		this.setPlayerTwoPokemonName(model.getOpponentPokemonName(playerID));
		this.setPlayerOnePokemonHP(model.getPlayerPokemonHP(playerID));
		this.setPlayerTwoPokemonHP(model.getOpponentPokemonHP(playerID));
		this.setPlayerOnePokemonDisplayImage(model.getPlayerPokemonSpeciesName(playerID));
		this.setPlayerTwoPokemonDisplayImage(model.getOpponentPokemonSpeciesName(playerID));
		this.setMoveQueueData(model.getTasks(playerID));
		this.setMoveButtonData(model.getMoveData(playerID));
		this.setPokemonButtonData(model);
		repaint();
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
		//resource = "Pikachu";
		playerOnePokemonDisplayImage = new ImageIcon(this.getClass().getResource("/pokemonBattleSim/resources/images/"+resource+".gif"));
		playerOnePokemonDisplayLabel.setIcon(playerOnePokemonDisplayImage);
	}
	
	public void setPlayerTwoPokemonDisplayImage(String resource)
	{
		//resource = "Pikachu";
		playerTwoPokemonDisplayImage = new ImageIcon(this.getClass().getResource("/pokemonBattleSim/resources/images/"+resource+".gif"));
		playerTwoPokemonDisplayLabel.setIcon(playerTwoPokemonDisplayImage);
	}
	
	public void addMoveQueueListener (ActionListener listener)
	{
		if (listener == null) return;
		if (queueButtonListeners.contains(listener)) return;
		
		queueButtonListeners.add(listener);
	}
	
	public void removeMoveQueueListener (ActionListener listener)
	{
		if (listener == null) return;
		
		queueButtonListeners.remove(listener);
	}
	
	public void setMoveQueueData(ArrayList<QueuedAction> actions)
	{
		moveQueuePanel.removeAll();
		for (QueuedAction action : actions)
		{
			JButton btn = new JButton(action.name);
			for (ActionListener listener : queueButtonListeners)
			{
				//System.out.println("Adding listener");
				btn.addActionListener(listener);
			}
			moveQueuePanel.add(btn);
		}
		moveQueuePanel.validate();
	}
	
	public void addMoveButtonListener (ActionListener listener)
	{
		if (listener == null) return;
		if (moveButtonListeners.contains(listener)) return;
		
		moveButtonListeners.add(listener);
	}
	
	public void removeMoveButtonListener (ActionListener listener)
	{
		if (listener == null) return;
		
		moveButtonListeners.remove(listener);
	}
	
	public void setMoveButtonData (ArrayList<String> moves)
	{
		moveListPanel.removeAll();
		for (String move : moves)
		{
			JButton btn = new JButton(move);
			for (ActionListener listener : moveButtonListeners)
				btn.addActionListener(listener);
			moveListPanel.add(btn);
		}
		moveListPanel.validate();
	}
	
	public void addPokemonButtonListener (ActionListener listener)
	{
		if (listener == null) return;
		if (pokemonButtonListeners.contains(listener)) return;
		
		pokemonButtonListeners.add(listener);
	}
	
	public void removePokemonButtonListener (ActionListener listener)
	{
		if (listener == null) return;
		
		pokemonButtonListeners.remove(listener);
	}
	
	public void setPokemonButtonData (IBattleModel model)
	{
		teamListPanel.removeAll();
		int counter = 1;
		ArrayList<Boolean> availablePokemon =  model.getPlayerAvailablePokemon(playerID);
		for (int i = 0; i < 6; i++)
		{
			JButton btn = new JButton((counter++) + ": " +model.getPlayerPokemonName(playerID, i));
			btn.setEnabled(availablePokemon.get(i));
			for (ActionListener listener : pokemonButtonListeners)
				btn.addActionListener(listener);
			teamListPanel.add(btn);
		}
		teamListPanel.validate();
	}
	
	public void displayPopupMessage(String message)
	{
		JOptionPane.showMessageDialog(this, message);
	}

}
