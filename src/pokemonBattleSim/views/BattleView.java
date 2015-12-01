package pokemonBattleSim.views;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.TextArea;
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
import pokemonBattleSim.models.MoveMap;
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
	private JPanel musicPlayerPanel;
	private JPanel pokemonDataPanel;
	private JPanel pokemonDisplayPanel;
	private JPanel moveQueuePanel;
	private JPanel moveListPanel;
	private JPanel teamListPanel;
	
	private BoxLayout battleLayout;
	private GridLayout musicPlayerLayout;
	private GridLayout pokemonDataLayout;
	private GridLayout pokemonDisplayLayout;
	private FlowLayout moveQueueLayout;
	private GridLayout moveListLayout;
	private GridLayout teamListLayout;
	
	private JButton musicPlayerStopButton;
	
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
	private TextArea logArea;
	
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
		musicPlayerPanel = 		new JPanel();
		pokemonDataPanel = 		new JPanel();
		pokemonDisplayPanel = 	new JPanel();
		moveQueuePanel = 		new JPanel();
		moveListPanel =			new JPanel();
		teamListPanel =			new JPanel();
		
		battleLayout = 			new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS);
		musicPlayerLayout =		new GridLayout(1,2);
		pokemonDataLayout = 	new GridLayout(1,2);
		pokemonDisplayLayout = 	new GridLayout(1,2);
		moveQueueLayout = 		new FlowLayout();
		moveListLayout = 		new GridLayout (1,6);
		teamListLayout = 		new GridLayout (1,6);
		
		playerOnePokemonData = 	new JPanel();
		playerTwoPokemonData = 	new JPanel();
		
		playerOnePokemonDataLayout = 	new GridLayout(1,2);
		playerTwoPokemonDataLayout = 	new GridLayout(1,3);
		
		playerOnePokemonName = 			new JLabel("Player 1 Pokemon:");
		playerTwoPokemonName = 			new JLabel("Player 2 Pokemon:");
		playerOnePokemonHP =			new JLabel("0 HP");
		playerTwoPokemonHP =			new JLabel("0 HP");
		
		playerOnePokemonDisplayLabel = 	new JLabel();
		playerTwoPokemonDisplayLabel = 	new JLabel();
		logArea = new TextArea();
		Font logfont = new Font("Verdana", Font.BOLD, 10);
		logArea.setFont(logfont);
		
		playerOnePokemonDisplayImage = 	new ImageIcon();
		playerTwoPokemonDisplayImage = 	new ImageIcon();
		
		moveButtons = new ArrayList<>();
		pokemonButtons = new ArrayList<>();
		
		for (int i = 0; i < 6; i++)
		{
			moveButtons.add(new JButton("Move " + i));
			pokemonButtons.add(new JButton("Pokemon "+i));
		}
		
		musicPlayerStopButton = new JButton("Stop Music");
		
		// IMPORTANT: this uses a lambda expression to handle the event.
		// Essentially, this replaces creating a new class or anonymous object to handle the event.
		// This lambda expression is for ActionListener, which takes and ActionEvent e (arbitrarily named)
		// The syntax for lambda expressions [parameter names] -> { any code }
		musicPlayerStopButton.addActionListener(e -> 
		{
			if(AudioPlayer.musicBool == 0)
			{
				AudioPlayer.stopper = 1;
				System.out.println("Playback forcefully stopped.");
				musicPlayerStopButton.setText("New Song");
				AudioPlayer.musicBool = 1;
			}
			else
			{
				StartMusic();
				musicPlayerStopButton.setText("Stop Music");
				AudioPlayer.musicBool = 0;
			}
		});
		
		// set layouts
		this.setLayout(battleLayout);
		musicPlayerPanel.setLayout(musicPlayerLayout);
		pokemonDataPanel.setLayout(pokemonDataLayout);
		pokemonDisplayPanel.setLayout(pokemonDisplayLayout);
		moveQueuePanel.setLayout(moveQueueLayout);
		moveListPanel.setLayout(moveListLayout);
		teamListPanel.setLayout(teamListLayout);
		
		playerOnePokemonData.setLayout(playerOnePokemonDataLayout);
		playerTwoPokemonData.setLayout(playerTwoPokemonDataLayout);
		
		// build hierarchy
		musicPlayerPanel.add(musicPlayerStopButton);
		
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
		pokemonDisplayPanel.add(logArea);
		pokemonDisplayPanel.add(playerTwoPokemonDisplayLabel);
		
		for ( JButton btn : moveButtons)
		{
			moveListPanel.add(btn);
		}
		
		for ( JButton btn : pokemonButtons)
		{
			teamListPanel.add(btn);
		}
		
		this.add(musicPlayerPanel);
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
		        AudioPlayer.musicBool = 0;
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
		this.setLogAreaData(model.getLogData(), 7);
		
		if (model.isGameover()) 	
		{
			String message = "";
			if (model.getPlayerAvailablePokemon(playerID).contains(true))
				message = "Game Over\nYOU WIN!!";
			else
				message = "Game Over\nLOSER!!";
			this.displayPopupMessage(message);
			this.setVisible(false);
		}
		repaint();
	}
	
	public void StartMusic()
	{
	new Thread() {
		@Override
		public void run() {
			AudioPlayer player = new AudioPlayer();
			Random ran = new Random(); 
	        int songID = ran.nextInt(12);
	        AudioPlayer.stopper = 0;
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
	
	public void addMusicPlayerStopButtonListener(ActionListener listener)
	{
		musicPlayerStopButton.addActionListener(listener);
	}
	
	public void setLogAreaData (Iterable<String> messages, int numMessages)
	{
		String text = "";
		for (String logItem : messages)
		{
			text += logItem;
			if (--numMessages <= 0)
				break;
		}
		logArea.setText(text);
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
		if(resource.contains("Mega ") && ( resource.contains(" Y") || resource.contains(" X") ))
		{
			int endIndex;
			boolean yNotX;
			if(resource.contains(" Y"))
			{
				endIndex = resource.indexOf(" Y");
				yNotX = true;
			}
			else
			{
				endIndex = resource.indexOf(" X");
				yNotX = false;
			}
			resource = resource.substring(5,endIndex);
			resource = resource.concat("-mega");
			if(yNotX)
				resource = resource.concat("-y");
			else
				resource = resource.concat("-x");
		}
		else if(resource.contains("Mega "))
		{
			resource = resource.substring(5);
			resource = resource.concat("-mega");
		}
		else if(resource.contains("Primal "))
		{
			resource = resource.substring(7);
			resource = resource.concat("-primal");
		}
		playerOnePokemonDisplayImage = new ImageIcon(this.getClass().getResource("/pokemonBattleSim/resources/images/"+resource+".gif"));
		playerOnePokemonDisplayLabel.setIcon(playerOnePokemonDisplayImage);
	}
	
	public void setPlayerTwoPokemonDisplayImage(String resource)
	{
		//resource = "Pikachu";
		if(resource.contains("Mega ") && ( resource.contains(" Y") || resource.contains(" X") ))
		{
			int endIndex;
			boolean yNotX;
			if(resource.contains(" Y"))
			{
				endIndex = resource.indexOf(" Y");
				yNotX = true;
			}
			else
			{
				endIndex = resource.indexOf(" X");
				yNotX = false;
			}
			resource = resource.substring(5,endIndex);
			resource = resource.concat("-mega");
			if(yNotX)
				resource = resource.concat("-y");
			else
				resource = resource.concat("-x");
		}
		else if(resource.contains("Mega "))
		{
			resource = resource.substring(5);
			resource = resource.concat("-mega");
		}
		else if(resource.contains("Primal "))
		{
			resource = resource.substring(7);
			resource = resource.concat("-primal");
		}
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
			//System.out.println(MoveMap.moveMap.get(move).getType());
			JButton btn = new JButton(move);
			for (ActionListener listener : moveButtonListeners)
				btn.addActionListener(listener);
				//have type determine button color
				//btn.setBackground(Color.red);
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
