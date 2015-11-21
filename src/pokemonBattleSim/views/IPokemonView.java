package pokemonBattleSim.views;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import pokemonBattleSim.models.QueuedAction;
import pokemonBattleSim.models.IBattleModel;

public interface IPokemonView 
{
	public void onViewNotify ();
	public void setPlayerOnePokemonName(String name);
	public void setPlayerTwoPokemonName(String name);
	public void setPlayerOnePokemonHP(int hp);
	public void setPlayerTwoPokemonHP(int hp);
	public void setPlayerOnePokemonDisplayImage(String resource);
	public void setPlayerTwoPokemonDisplayImage(String resource);
	public void addMoveQueueListener (ActionListener listener);
	public void removeMoveQueueListener (ActionListener listener);
	public void setMoveQueueData(ArrayList<QueuedAction> actions);
	public void addMoveButtonListener (ActionListener listener);
	public void removeMoveButtonListener (ActionListener listener);
	public void setMoveButtonData (ArrayList<String> moves);
	public void addPokemonButtonListener (ActionListener listener);
	public void removePokemonButtonListener (ActionListener listener);
	public void setPokemonButtonData (IBattleModel model);		
	public void displayPopupMessage(String message);
}
