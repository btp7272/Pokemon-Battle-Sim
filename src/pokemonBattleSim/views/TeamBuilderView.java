package pokemonBattleSim.views;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
import pokemonBattleSim.models.*;
import pokemonBattleSim.types.*;

public class TeamBuilderView extends JFrame {//implements IView{
	
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
		//Update
		onViewNotify();
		//Check IV and EVs
		if(checkSums())
			return;
		//check Moves
		if(checkMoves())
			return;
		//check Pokemon names and for doubles
		if(checkPokemon())
			return;
		
		ArrayList<Pokemon> team = model.buildTeam (
				new Pokemon(SpeciesMap.speciesMap.get(poke1.getText()), nickname1.getText(), 
						new Move[]{new Move(MoveMap.moveMap.get(poke1move1.getToolTipText())), new Move(MoveMap.moveMap.get(poke1move2.getToolTipText())), new Move(MoveMap.moveMap.get(poke1move3.getToolTipText())), new Move(MoveMap.moveMap.get(poke1move4.getToolTipText()))}, 
						new int[] {Integer.parseInt(poke1iv1.getText()), Integer.parseInt(poke1iv2.getText()), Integer.parseInt(poke1iv3.getText()), Integer.parseInt(poke1iv4.getText()), Integer.parseInt(poke1iv5.getText()), Integer.parseInt(poke1iv6.getText()) },
						new int[] {Integer.parseInt(poke1ev1.getText()), Integer.parseInt(poke1ev2.getText()), Integer.parseInt(poke1ev3.getText()), Integer.parseInt(poke1ev4.getText()), Integer.parseInt(poke1ev5.getText()), Integer.parseInt(poke1ev6.getText()) },
						100, Nature.Timid, new AbilityContainer("None"), new ItemContainer("None")), 
				new Pokemon(SpeciesMap.speciesMap.get(poke2.getText()), nickname2.getText(), 
						new Move[]{new Move(MoveMap.moveMap.get(poke2move1.getToolTipText())), new Move(MoveMap.moveMap.get(poke2move2.getToolTipText())), new Move(MoveMap.moveMap.get(poke2move3.getToolTipText())), new Move(MoveMap.moveMap.get(poke2move4.getToolTipText()))}, 
						new int[] {Integer.parseInt(poke2iv1.getText()), Integer.parseInt(poke2iv2.getText()), Integer.parseInt(poke2iv3.getText()), Integer.parseInt(poke2iv4.getText()), Integer.parseInt(poke2iv5.getText()), Integer.parseInt(poke2iv6.getText()) },
						new int[] {Integer.parseInt(poke2ev1.getText()), Integer.parseInt(poke2ev2.getText()), Integer.parseInt(poke2ev3.getText()), Integer.parseInt(poke2ev4.getText()), Integer.parseInt(poke2ev5.getText()), Integer.parseInt(poke2ev6.getText()) },
						100, Nature.Timid, new AbilityContainer("None"), new ItemContainer("None")), 
				new Pokemon(SpeciesMap.speciesMap.get(poke3.getText()), nickname3.getText(), 
						new Move[]{new Move(MoveMap.moveMap.get(poke3move1.getToolTipText())), new Move(MoveMap.moveMap.get(poke3move2.getToolTipText())), new Move(MoveMap.moveMap.get(poke3move3.getToolTipText())), new Move(MoveMap.moveMap.get(poke3move4.getToolTipText()))}, 
						new int[] {Integer.parseInt(poke3iv1.getText()), Integer.parseInt(poke3iv2.getText()), Integer.parseInt(poke3iv3.getText()), Integer.parseInt(poke3iv4.getText()), Integer.parseInt(poke3iv5.getText()), Integer.parseInt(poke3iv6.getText()) },
						new int[] {Integer.parseInt(poke3ev1.getText()), Integer.parseInt(poke3ev2.getText()), Integer.parseInt(poke3ev3.getText()), Integer.parseInt(poke3ev4.getText()), Integer.parseInt(poke3ev5.getText()), Integer.parseInt(poke3ev6.getText()) },
						100, Nature.Timid, new AbilityContainer("None"), new ItemContainer("None")), 
				new Pokemon(SpeciesMap.speciesMap.get(poke4.getText()), nickname4.getText(), 
						new Move[]{new Move(MoveMap.moveMap.get(poke4move1.getToolTipText())), new Move(MoveMap.moveMap.get(poke4move2.getToolTipText())), new Move(MoveMap.moveMap.get(poke4move3.getToolTipText())), new Move(MoveMap.moveMap.get(poke4move4.getToolTipText()))}, 
						new int[] {Integer.parseInt(poke4iv1.getText()), Integer.parseInt(poke4iv2.getText()), Integer.parseInt(poke4iv3.getText()), Integer.parseInt(poke4iv4.getText()), Integer.parseInt(poke4iv5.getText()), Integer.parseInt(poke4iv6.getText()) },
						new int[] {Integer.parseInt(poke4ev1.getText()), Integer.parseInt(poke4ev2.getText()), Integer.parseInt(poke4ev3.getText()), Integer.parseInt(poke4ev4.getText()), Integer.parseInt(poke4ev5.getText()), Integer.parseInt(poke4ev6.getText()) },
						100, Nature.Timid, new AbilityContainer("None"), new ItemContainer("None")), 
				new Pokemon(SpeciesMap.speciesMap.get(poke5.getText()), nickname5.getText(), 
						new Move[]{new Move(MoveMap.moveMap.get(poke5move1.getToolTipText())), new Move(MoveMap.moveMap.get(poke5move2.getToolTipText())), new Move(MoveMap.moveMap.get(poke5move3.getToolTipText())), new Move(MoveMap.moveMap.get(poke5move4.getToolTipText()))}, 
						new int[] {Integer.parseInt(poke5iv1.getText()), Integer.parseInt(poke5iv2.getText()), Integer.parseInt(poke5iv3.getText()), Integer.parseInt(poke5iv4.getText()), Integer.parseInt(poke5iv5.getText()), Integer.parseInt(poke5iv6.getText()) },
						new int[] {Integer.parseInt(poke5ev1.getText()), Integer.parseInt(poke5ev2.getText()), Integer.parseInt(poke5ev3.getText()), Integer.parseInt(poke5ev4.getText()), Integer.parseInt(poke5ev5.getText()), Integer.parseInt(poke5ev6.getText()) },
						100, Nature.Timid, new AbilityContainer("None"), new ItemContainer("None")), 
				new Pokemon(SpeciesMap.speciesMap.get(poke6.getText()), nickname6.getText(), 
						new Move[]{new Move(MoveMap.moveMap.get(poke1move1.getToolTipText())), new Move(MoveMap.moveMap.get(poke1move2.getToolTipText())), new Move(MoveMap.moveMap.get(poke1move3.getToolTipText())), new Move(MoveMap.moveMap.get(poke1move4.getToolTipText()))}, 
						new int[] {Integer.parseInt(poke1iv1.getText()), Integer.parseInt(poke1iv2.getText()), Integer.parseInt(poke1iv3.getText()), Integer.parseInt(poke1iv4.getText()), Integer.parseInt(poke1iv5.getText()), Integer.parseInt(poke1iv6.getText()) },
						new int[] {Integer.parseInt(poke1ev1.getText()), Integer.parseInt(poke1ev2.getText()), Integer.parseInt(poke1ev3.getText()), Integer.parseInt(poke1ev4.getText()), Integer.parseInt(poke1ev5.getText()), Integer.parseInt(poke1ev6.getText()) },
						100, Nature.Timid, new AbilityContainer("None"), new ItemContainer("None"))
				);
	}
	
	
	/*
	 * Check Pokemone names for validity, check for doubles
	 */
	public boolean checkPokemon()
	{
		if(SpeciesMap.speciesMap.get(poke1.getText()) == null)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 1 is not a valid Pokemon");
			return true;
		}
		else if(SpeciesMap.speciesMap.get(poke2.getText()) == null)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 2 is not a valid Pokemon");
			return true;
		}
		else if(SpeciesMap.speciesMap.get(poke3.getText()) == null)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 3 is not a valid Pokemon");
			return true;
		}
		else if(SpeciesMap.speciesMap.get(poke4.getText()) == null)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 4 is not a valid Pokemon");
			return true;
		}
		else if(SpeciesMap.speciesMap.get(poke5.getText()) == null)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 5 is not a valid Pokemon");
			return true;
		}
		else if(SpeciesMap.speciesMap.get(poke6.getText()) == null)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 6 is not a valid Pokemon");
			return true;
		}
		else if(poke1.getText().equals(poke2.getText())  ||
				poke1.getText().equals(poke3.getText())  ||
				poke1.getText().equals(poke4.getText())  ||
				poke1.getText().equals(poke5.getText())  ||
				poke1.getText().equals(poke6.getText())  ||
				poke2.getText().equals(poke3.getText())  ||
				poke2.getText().equals(poke4.getText())  ||
				poke2.getText().equals(poke5.getText())  ||
				poke2.getText().equals(poke6.getText())  ||
				poke3.getText().equals(poke4.getText())  ||
				poke3.getText().equals(poke5.getText())  ||
				poke3.getText().equals(poke6.getText())  ||
				poke4.getText().equals(poke5.getText())  ||
				poke4.getText().equals(poke6.getText())  ||
				poke5.getText().equals(poke6.getText())
				)
		{
			JOptionPane.showMessageDialog(null, "You ccannot have two of the same Pokemon on your team");
			return true;
		}
		else
			return false;
	}
	/*
	 * Check Move validity
	 */
	public boolean checkMoves()
	{
		if (	poke1move1.equals(poke1move2)  ||
				poke1move1.equals(poke1move3)  ||
				poke1move1.equals(poke1move4)  ||
				poke1move2.equals(poke1move3)  ||
				poke1move2.equals(poke1move4)  ||
				poke1move3.equals(poke1move4)
			)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 1 may not have two of the same moves");
			return true;
		}
		else if 
			(	poke2move1.equals(poke2move2)  ||
				poke2move1.equals(poke2move3)  ||
				poke2move1.equals(poke2move4)  ||
				poke2move2.equals(poke2move3)  ||
				poke2move2.equals(poke2move4)  ||
				poke2move3.equals(poke2move4)
			)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 2 may not have two of the same moves");
			return true;
		}
		else if 
			(	poke3move1.equals(poke3move2)  ||
				poke3move1.equals(poke3move3)  ||
				poke3move1.equals(poke3move4)  ||
				poke3move2.equals(poke3move3)  ||
				poke3move2.equals(poke3move4)  ||
				poke3move3.equals(poke3move4)
			)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 3 may not have two of the same moves");
			return true;
		}
		else if 
			(	poke4move1.equals(poke4move2)  ||
				poke4move1.equals(poke4move3)  ||
				poke4move1.equals(poke4move4)  ||
				poke4move2.equals(poke4move3)  ||
				poke4move2.equals(poke4move4)  ||
				poke4move3.equals(poke4move4)
			)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 4 may not have two of the same moves");
			return true;
		}
		else if 
			(	poke5move1.equals(poke5move2)  ||
				poke5move1.equals(poke5move3)  ||
				poke5move1.equals(poke5move4)  ||
				poke5move2.equals(poke5move3)  ||
				poke5move2.equals(poke5move4)  ||
				poke5move3.equals(poke5move4)
			)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 5 may not have two of the same moves");
			return true;
		}
		else if 
			(	poke6move1.equals(poke6move2)  ||
				poke6move1.equals(poke6move3)  ||
				poke6move1.equals(poke6move4)  ||
				poke6move2.equals(poke6move3)  ||
				poke6move2.equals(poke6move4)  ||
				poke6move3.equals(poke6move4)
			)
		{
			JOptionPane.showMessageDialog(null, "Pokemon 1 may not have two of the same moves");
			return true;
		}
		else
			return false;
	}
	/*
	 * Check IV and EV value functions 
	 */
	public boolean checkSums()
	{
		//Calculate IV validity
		if (	Integer.parseInt(poke1iv1.getText()) > 31  ||
				Integer.parseInt(poke1iv2.getText()) > 31  ||
				Integer.parseInt(poke1iv3.getText()) > 31  ||
				Integer.parseInt(poke1iv4.getText()) > 31  ||
				Integer.parseInt(poke1iv5.getText()) > 31  ||
				Integer.parseInt(poke1iv6.getText()) > 31  ||
				Integer.parseInt(poke1iv1.getText()) < 0   ||
				Integer.parseInt(poke1iv1.getText()) < 0   ||
				Integer.parseInt(poke1iv2.getText()) < 0   ||
				Integer.parseInt(poke1iv3.getText()) < 0   ||
				Integer.parseInt(poke1iv4.getText()) < 0   ||
				Integer.parseInt(poke1iv5.getText()) < 0   
			)
		{
			JOptionPane.showMessageDialog(null, "Individual Values for Pokemon 1 are invalid");
			return true;
		}
		else if(Integer.parseInt(poke2iv1.getText()) > 31  ||
				Integer.parseInt(poke2iv2.getText()) > 31  ||
				Integer.parseInt(poke2iv3.getText()) > 31  ||
				Integer.parseInt(poke2iv4.getText()) > 31  ||
				Integer.parseInt(poke2iv5.getText()) > 31  ||
				Integer.parseInt(poke2iv6.getText()) > 31  ||
				Integer.parseInt(poke2iv1.getText()) < 0   ||
				Integer.parseInt(poke2iv1.getText()) < 0   ||
				Integer.parseInt(poke2iv2.getText()) < 0   ||
				Integer.parseInt(poke2iv3.getText()) < 0   ||
				Integer.parseInt(poke2iv4.getText()) < 0   ||
				Integer.parseInt(poke2iv5.getText()) < 0   
			)
		{
			JOptionPane.showMessageDialog(null, "Individual Values for Pokemon 2 are invalid");
			return true;
		}
		else if(Integer.parseInt(poke3iv1.getText()) > 31  ||
				Integer.parseInt(poke3iv2.getText()) > 31  ||
				Integer.parseInt(poke3iv3.getText()) > 31  ||
				Integer.parseInt(poke3iv4.getText()) > 31  ||
				Integer.parseInt(poke3iv5.getText()) > 31  ||
				Integer.parseInt(poke3iv6.getText()) > 31  ||
				Integer.parseInt(poke3iv1.getText()) < 0   ||
				Integer.parseInt(poke3iv1.getText()) < 0   ||
				Integer.parseInt(poke3iv2.getText()) < 0   ||
				Integer.parseInt(poke3iv3.getText()) < 0   ||
				Integer.parseInt(poke3iv4.getText()) < 0   ||
				Integer.parseInt(poke3iv5.getText()) < 0   
			)
		{
			JOptionPane.showMessageDialog(null, "Individual Values for Pokemon 3 are invalid");
			return true;
		}
		else if(Integer.parseInt(poke4iv1.getText()) > 31  ||
				Integer.parseInt(poke4iv2.getText()) > 31  ||
				Integer.parseInt(poke4iv3.getText()) > 31  ||
				Integer.parseInt(poke4iv4.getText()) > 31  ||
				Integer.parseInt(poke4iv5.getText()) > 31  ||
				Integer.parseInt(poke4iv6.getText()) > 31  ||
				Integer.parseInt(poke4iv1.getText()) < 0   ||
				Integer.parseInt(poke4iv1.getText()) < 0   ||
				Integer.parseInt(poke4iv2.getText()) < 0   ||
				Integer.parseInt(poke4iv3.getText()) < 0   ||
				Integer.parseInt(poke4iv4.getText()) < 0   ||
				Integer.parseInt(poke4iv5.getText()) < 0   
			)
		{
			JOptionPane.showMessageDialog(null, "Individual Values for Pokemon 4 are invalid");
			return true;
		}
		else if(Integer.parseInt(poke5iv1.getText()) > 31  ||
				Integer.parseInt(poke5iv2.getText()) > 31  ||
				Integer.parseInt(poke5iv3.getText()) > 31  ||
				Integer.parseInt(poke5iv4.getText()) > 31  ||
				Integer.parseInt(poke5iv5.getText()) > 31  ||
				Integer.parseInt(poke5iv6.getText()) > 31  ||
				Integer.parseInt(poke5iv1.getText()) < 0   ||
				Integer.parseInt(poke5iv1.getText()) < 0   ||
				Integer.parseInt(poke5iv2.getText()) < 0   ||
				Integer.parseInt(poke5iv3.getText()) < 0   ||
				Integer.parseInt(poke5iv4.getText()) < 0   ||
				Integer.parseInt(poke5iv5.getText()) < 0   
			)
		{
			JOptionPane.showMessageDialog(null, "Individual Values for Pokemon 5 are invalid");
			return true;
		}
		else if(Integer.parseInt(poke6iv1.getText()) > 31  ||
				Integer.parseInt(poke6iv2.getText()) > 31  ||
				Integer.parseInt(poke6iv3.getText()) > 31  ||
				Integer.parseInt(poke6iv4.getText()) > 31  ||
				Integer.parseInt(poke6iv5.getText()) > 31  ||
				Integer.parseInt(poke6iv6.getText()) > 31  ||
				Integer.parseInt(poke6iv1.getText()) < 0   ||
				Integer.parseInt(poke6iv1.getText()) < 0   ||
				Integer.parseInt(poke6iv2.getText()) < 0   ||
				Integer.parseInt(poke6iv3.getText()) < 0   ||
				Integer.parseInt(poke6iv4.getText()) < 0   ||
				Integer.parseInt(poke6iv5.getText()) < 0   
			)
		{
			JOptionPane.showMessageDialog(null, "Individual Values for Pokemon 6 are invalid");
			return true;
		}
		//Calculate EV Validity
		else if(Integer.parseInt(poke1ev1.getText()) > 252  ||
				Integer.parseInt(poke1ev2.getText()) > 252  ||
				Integer.parseInt(poke1ev3.getText()) > 252  ||
				Integer.parseInt(poke1ev4.getText()) > 252  ||
				Integer.parseInt(poke1ev5.getText()) > 252  ||
				Integer.parseInt(poke1ev6.getText()) > 252  ||
				Integer.parseInt(poke1ev1.getText()) < 0    ||
				Integer.parseInt(poke1ev2.getText()) < 0    ||
				Integer.parseInt(poke1ev3.getText()) < 0    ||
				Integer.parseInt(poke1ev4.getText()) < 0    ||
				Integer.parseInt(poke1ev5.getText()) < 0    ||
				Integer.parseInt(poke1ev6.getText()) < 0    ||
				Integer.parseInt(poke1ev1.getText()) +
				Integer.parseInt(poke1ev2.getText()) +
				Integer.parseInt(poke1ev3.getText()) +
				Integer.parseInt(poke1ev4.getText()) +
				Integer.parseInt(poke1ev5.getText()) +
				Integer.parseInt(poke1ev6.getText()) > 510
				)
		{
			JOptionPane.showMessageDialog(null, "Effort Values for Pokemone 1 are invalid");
			return true;
		}
		else if(Integer.parseInt(poke2ev1.getText()) > 252  ||
				Integer.parseInt(poke2ev2.getText()) > 252  ||
				Integer.parseInt(poke2ev3.getText()) > 252  ||
				Integer.parseInt(poke2ev4.getText()) > 252  ||
				Integer.parseInt(poke2ev5.getText()) > 252  ||
				Integer.parseInt(poke2ev6.getText()) > 252  ||
				Integer.parseInt(poke2ev1.getText()) < 0    ||
				Integer.parseInt(poke2ev2.getText()) < 0    ||
				Integer.parseInt(poke2ev3.getText()) < 0    ||
				Integer.parseInt(poke2ev4.getText()) < 0    ||
				Integer.parseInt(poke2ev5.getText()) < 0    ||
				Integer.parseInt(poke2ev6.getText()) < 0    ||
				Integer.parseInt(poke2ev1.getText()) +
				Integer.parseInt(poke2ev2.getText()) +
				Integer.parseInt(poke2ev3.getText()) +
				Integer.parseInt(poke2ev4.getText()) +
				Integer.parseInt(poke2ev5.getText()) +
				Integer.parseInt(poke2ev6.getText()) > 510
				)
		{
			JOptionPane.showMessageDialog(null, "Effort Values for Pokemone 2 are invalid");
			return true;
		}
		else if(Integer.parseInt(poke3ev1.getText()) > 252  ||
				Integer.parseInt(poke3ev2.getText()) > 252  ||
				Integer.parseInt(poke3ev3.getText()) > 252  ||
				Integer.parseInt(poke3ev4.getText()) > 252  ||
				Integer.parseInt(poke3ev5.getText()) > 252  ||
				Integer.parseInt(poke3ev6.getText()) > 252  ||
				Integer.parseInt(poke3ev1.getText()) < 0    ||
				Integer.parseInt(poke3ev2.getText()) < 0    ||
				Integer.parseInt(poke3ev3.getText()) < 0    ||
				Integer.parseInt(poke3ev4.getText()) < 0    ||
				Integer.parseInt(poke3ev5.getText()) < 0    ||
				Integer.parseInt(poke3ev6.getText()) < 0    ||
				Integer.parseInt(poke3ev1.getText()) +
				Integer.parseInt(poke3ev2.getText()) +
				Integer.parseInt(poke3ev3.getText()) +
				Integer.parseInt(poke3ev4.getText()) +
				Integer.parseInt(poke3ev5.getText()) +
				Integer.parseInt(poke3ev6.getText()) > 510
				)
		{
			JOptionPane.showMessageDialog(null, "Effort Values for Pokemone 3 are invalid");
			return true;
		}
		else if(Integer.parseInt(poke4ev1.getText()) > 252  ||
				Integer.parseInt(poke4ev2.getText()) > 252  ||
				Integer.parseInt(poke4ev3.getText()) > 252  ||
				Integer.parseInt(poke4ev4.getText()) > 252  ||
				Integer.parseInt(poke4ev5.getText()) > 252  ||
				Integer.parseInt(poke4ev6.getText()) > 252  ||
				Integer.parseInt(poke4ev1.getText()) < 0    ||
				Integer.parseInt(poke4ev2.getText()) < 0    ||
				Integer.parseInt(poke4ev3.getText()) < 0    ||
				Integer.parseInt(poke4ev4.getText()) < 0    ||
				Integer.parseInt(poke4ev5.getText()) < 0    ||
				Integer.parseInt(poke4ev6.getText()) < 0    ||
				Integer.parseInt(poke4ev1.getText()) +
				Integer.parseInt(poke4ev2.getText()) +
				Integer.parseInt(poke4ev3.getText()) +
				Integer.parseInt(poke4ev4.getText()) +
				Integer.parseInt(poke4ev5.getText()) +
				Integer.parseInt(poke4ev6.getText()) > 510
				)
		{
			JOptionPane.showMessageDialog(null, "Effort Values for Pokemone 4 are invalid");
			return true;
		}
		else if(Integer.parseInt(poke5ev1.getText()) > 252  ||
				Integer.parseInt(poke5ev2.getText()) > 252  ||
				Integer.parseInt(poke5ev3.getText()) > 252  ||
				Integer.parseInt(poke5ev4.getText()) > 252  ||
				Integer.parseInt(poke5ev5.getText()) > 252  ||
				Integer.parseInt(poke5ev6.getText()) > 252  ||
				Integer.parseInt(poke5ev1.getText()) < 0    ||
				Integer.parseInt(poke5ev2.getText()) < 0    ||
				Integer.parseInt(poke5ev3.getText()) < 0    ||
				Integer.parseInt(poke5ev4.getText()) < 0    ||
				Integer.parseInt(poke5ev5.getText()) < 0    ||
				Integer.parseInt(poke5ev6.getText()) < 0    ||
				Integer.parseInt(poke5ev1.getText()) +
				Integer.parseInt(poke5ev2.getText()) +
				Integer.parseInt(poke5ev3.getText()) +
				Integer.parseInt(poke5ev4.getText()) +
				Integer.parseInt(poke5ev5.getText()) +
				Integer.parseInt(poke5ev6.getText()) > 510
				)
		{
			JOptionPane.showMessageDialog(null, "Effort Values for Pokemone 5 are invalid");
			return true;
		}
		else if(Integer.parseInt(poke6ev1.getText()) > 252  ||
				Integer.parseInt(poke6ev2.getText()) > 252  ||
				Integer.parseInt(poke6ev3.getText()) > 252  ||
				Integer.parseInt(poke6ev4.getText()) > 252  ||
				Integer.parseInt(poke6ev5.getText()) > 252  ||
				Integer.parseInt(poke6ev6.getText()) > 252  ||
				Integer.parseInt(poke6ev1.getText()) < 0    ||
				Integer.parseInt(poke6ev2.getText()) < 0    ||
				Integer.parseInt(poke6ev3.getText()) < 0    ||
				Integer.parseInt(poke6ev4.getText()) < 0    ||
				Integer.parseInt(poke6ev5.getText()) < 0    ||
				Integer.parseInt(poke6ev6.getText()) < 0    ||
				Integer.parseInt(poke6ev1.getText()) +
				Integer.parseInt(poke6ev2.getText()) +
				Integer.parseInt(poke6ev3.getText()) +
				Integer.parseInt(poke6ev4.getText()) +
				Integer.parseInt(poke6ev5.getText()) +
				Integer.parseInt(poke6ev6.getText()) > 510
				)
		{
			JOptionPane.showMessageDialog(null, "Effort Values for Pokemone 6 are invalid");
			return true;
		}
		else
			return false;
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
    private JTextField poke2;
    private JTextField poke3;
    private JTextField poke4;
    private JTextField poke5;
    private JTextField poke6;
    
    private JTextField nickname1;
    private JTextField nickname2;
    private JTextField nickname3;
    private JTextField nickname4;
    private JTextField nickname5;
    private JTextField nickname6;
    
    private JLabel poke1Label;
    private JLabel poke2Label;
    private JLabel poke3Label;
    private JLabel poke4Label;
    private JLabel poke5Label;
    private JLabel poke6Label;
    
    private JLabel pokemonHeader;
    private JLabel nicknameHeader;
    
    private JButton FinalizeButton;
    private JButton RefreshButton;
    
    private JLabel abilityLabel;
    
    private JComboBox poke1move1;
    private JComboBox poke1move2;
    private JComboBox poke1move3;
    private JComboBox poke1move4;
    
    private JComboBox poke2move1;
    private JComboBox poke2move2;
    private JComboBox poke2move3;
    private JComboBox poke2move4;
    
    private JComboBox poke3move1;
    private JComboBox poke3move2;
    private JComboBox poke3move3;
    private JComboBox poke3move4;
    
    private JComboBox poke4move1;
    private JComboBox poke4move2;
    private JComboBox poke4move3;
    private JComboBox poke4move4;
    
    private JComboBox poke5move1;
    private JComboBox poke5move2;
    private JComboBox poke5move3;
    private JComboBox poke5move4;
    
    private JComboBox poke6move1;
    private JComboBox poke6move2;
    private JComboBox poke6move3;
    private JComboBox poke6move4;
    
    private JLabel move1Label;
    private JLabel move2Label;
    private JLabel move3Label;
    private JLabel move4Label;
    
    private JComboBox poke1Ability;
    private JComboBox poke2Ability;
    private JComboBox poke3Ability;
    private JComboBox poke4Ability;
    private JComboBox poke5Ability;
    private JComboBox poke6Ability;
    
    private JLabel iv1Label;
    private JLabel iv2Label;
    private JLabel iv3Label;
    private JLabel iv4Label;
    private JLabel iv5Label;
    private JLabel iv6Label;
    
    private JLabel ev1Label;
    private JLabel ev2Label;
    private JLabel ev3Label;
    private JLabel ev4Label;
    private JLabel ev5Label;
    private JLabel ev6Label;
    
    /*
     * Pokemon IVs
     */    
    private JTextField poke1iv1;
    private JTextField poke1iv2;
    private JTextField poke1iv3;
    private JTextField poke1iv4;
    private JTextField poke1iv5;
    private JTextField poke1iv6;
    
    private JTextField poke2iv1;
    private JTextField poke2iv2;
    private JTextField poke2iv3;
    private JTextField poke2iv4;
    private JTextField poke2iv5;
    private JTextField poke2iv6;
    
    private JTextField poke3iv1;
    private JTextField poke3iv2;
    private JTextField poke3iv3;
    private JTextField poke3iv4;
    private JTextField poke3iv5;
    private JTextField poke3iv6;
    
    private JTextField poke4iv1;
    private JTextField poke4iv2;
    private JTextField poke4iv3;
    private JTextField poke4iv4;
    private JTextField poke4iv5;
    private JTextField poke4iv6;
    
    private JTextField poke5iv1;
    private JTextField poke5iv2;
    private JTextField poke5iv3;
    private JTextField poke5iv4;
    private JTextField poke5iv5;
    private JTextField poke5iv6;
    
    private JTextField poke6iv1;
    private JTextField poke6iv2;
    private JTextField poke6iv3;
    private JTextField poke6iv4;
    private JTextField poke6iv5;
    private JTextField poke6iv6;
	
    /*
     * Pokemon EVs
     */
    private JTextField poke1ev1;
    private JTextField poke1ev2;
    private JTextField poke1ev3;
    private JTextField poke1ev4;
    private JTextField poke1ev5;
    private JTextField poke1ev6;
    
    private JTextField poke2ev1;
    private JTextField poke2ev2;
    private JTextField poke2ev3;
    private JTextField poke2ev4;
    private JTextField poke2ev5;
    private JTextField poke2ev6;
    
    private JTextField poke3ev1;
    private JTextField poke3ev2;
    private JTextField poke3ev3;
    private JTextField poke3ev4;
    private JTextField poke3ev5;
    private JTextField poke3ev6;
    
    private JTextField poke4ev1;
    private JTextField poke4ev2;
    private JTextField poke4ev3;
    private JTextField poke4ev4;
    private JTextField poke4ev5;
    private JTextField poke4ev6;
       
    private JTextField poke5ev1;
    private JTextField poke5ev2;
    private JTextField poke5ev3;
    private JTextField poke5ev4;
    private JTextField poke5ev5;
    private JTextField poke5ev6;
    
    private JTextField poke6ev1;
    private JTextField poke6ev2;
    private JTextField poke6ev3;
    private JTextField poke6ev4;
    private JTextField poke6ev5;
    private JTextField poke6ev6;

    public TeamBuilderView() {
    	
    	//adjust size and set layout
        setPreferredSize (new Dimension(955, 592));
        setLayout (null);
        
        //construct preComponents
        String[] poke1move1List = {moves1};
        String[] poke1move2List = {moves1};
        String[] poke1move3List = {moves1};
        String[] poke1move4List = {moves1};
        
        String[] poke2move1List = {moves2};
        String[] poke2move2List = {moves2};
        String[] poke2move3List = {moves2};
        String[] poke2move4List = {moves2};
        
        String[] poke3move1List = {moves3};
        String[] poke3move2List = {moves3};
        String[] poke3move3List = {moves3};
        String[] poke3move4List = {moves3};
        
        String[] poke4move1List = {moves4};
        String[] poke4move2List = {moves4};
        String[] poke4move3List = {moves4};
        String[] poke4move4List = {moves4};
        
        String[] poke5move1List = {moves5};
        String[] poke5move2List = {moves5};
        String[] poke5move3List = {moves5};
        String[] poke5move4List = {moves5};
        
        String[] poke6move1List = {moves6};
        String[] poke6move2List = {moves6};
        String[] poke6move3List = {moves6};
        String[] poke6move4List = {moves6};
        
        
        String[] poke1AbilityList = {abilities1};
        String[] poke2AbilityList = {abilities2};
        String[] poke3AbilityList = {abilities3};
        String[] poke4AbilityList = {abilities4};
        String[] poke5AbilityList = {abilities5};
        String[] poke6AbilityList = {abilities6};
        
        //construct components
        /*
         * Pokemon Names
         */
        {
	        poke1 = new JTextField (30);
	        poke2 = new JTextField (30);
	        poke3 = new JTextField (30);
	        poke4 = new JTextField (30);
	        poke5 = new JTextField (30);
	        poke6 = new JTextField (30);
        }
        
        /*
         * Pokemon NickNames
         */
        {
        	nickname1 = new JTextField (30);
            nickname2 = new JTextField (30);
            nickname3 = new JTextField (30);
            nickname4 = new JTextField (30);
            nickname5 = new JTextField (30);
            nickname6 = new JTextField (30);
        }
        
        /*
         * Labels
         */
        {
        	{	//IV labels
        		iv1Label = new JLabel ("HP");
	        	iv2Label = new JLabel ("Attack");
	            iv3Label = new JLabel ("Defense");
	            iv4Label = new JLabel ("Sp. Attack");
	            iv5Label = new JLabel ("Sp. Defense");
	            iv6Label = new JLabel ("Speed");
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
                ev1Label = new JLabel ("HP");
                ev2Label = new JLabel ("Attack");
                ev3Label = new JLabel ("Defense");
                ev4Label = new JLabel ("Sp. Attack");
                ev5Label = new JLabel ("Sp. Defense");
                ev6Label = new JLabel ("Speed");
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
        	poke1Ability = new JComboBox (poke1AbilityList);
            poke1Ability.setModel(new DefaultComboBoxModel(new String[] {abilities1}));
            poke2Ability = new JComboBox (poke2AbilityList);
            poke2Ability.setModel(new DefaultComboBoxModel(new String[] {abilities2}));
            poke3Ability = new JComboBox (poke3AbilityList);
            poke3Ability.setModel(new DefaultComboBoxModel(new String[] {abilities3}));
            poke4Ability = new JComboBox (poke4AbilityList);
            poke4Ability.setModel(new DefaultComboBoxModel(new String[] {abilities4}));
            poke5Ability = new JComboBox (poke5AbilityList);
            poke5Ability.setModel(new DefaultComboBoxModel(new String[] {abilities5}));
            poke6Ability = new JComboBox (poke6AbilityList);
            poke6Ability.setModel(new DefaultComboBoxModel(new String[] {abilities6}));
        }
        
        /*
         * Moves
         */
        {
        	{	//Poke1
        		poke1move1 = new JComboBox (poke1move1List);
        	    poke1move1.setModel(new DefaultComboBoxModel(new String[] {moves1}));
        	    poke1move2 = new JComboBox (poke1move2List);
        	    poke1move2.setModel(new DefaultComboBoxModel(new String[] {moves1}));
        	    poke1move3 = new JComboBox (poke1move3List);
        	    poke1move3.setModel(new DefaultComboBoxModel(new String[] {moves1}));
        	    poke1move4 = new JComboBox (poke1move4List);
                poke1move4.setModel(new DefaultComboBoxModel(new String[] {moves1}));
        	}
        	
        	{	//Poke2
        		poke2move1 = new JComboBox (poke2move1List);
                poke2move1.setModel(new DefaultComboBoxModel(new String[] {moves2}));
                poke2move2 = new JComboBox (poke2move2List);
                poke2move2.setModel(new DefaultComboBoxModel(new String[] {moves2}));
                poke2move3 = new JComboBox (poke2move3List);
                poke2move3.setModel(new DefaultComboBoxModel(new String[] {moves2}));
                poke2move4 = new JComboBox (poke2move4List);
                poke2move4.setModel(new DefaultComboBoxModel(new String[] {moves2}));
        	}
        	
        	{	//Poke3
        		poke3move1 = new JComboBox (poke3move1List);
                poke3move1.setModel(new DefaultComboBoxModel(new String[] {moves3}));
        		poke3move2 = new JComboBox (poke3move2List);
                poke3move2.setModel(new DefaultComboBoxModel(new String[] {moves3}));
                poke3move3 = new JComboBox (poke3move3List);
                poke3move3.setModel(new DefaultComboBoxModel(new String[] {moves3}));
                poke3move4 = new JComboBox (poke3move4List);
                poke3move4.setModel(new DefaultComboBoxModel(new String[] {moves3}));
        	}
        	
        	{	//Poke4
        		poke4move1 = new JComboBox (poke4move1List);
        		poke4move1.setModel(new DefaultComboBoxModel(new String[] {moves4}));
        		poke4move2 = new JComboBox (poke4move2List);
                poke4move2.setModel(new DefaultComboBoxModel(new String[] {moves4}));
                poke4move3 = new JComboBox (poke4move3List);
                poke4move3.setModel(new DefaultComboBoxModel(new String[] {moves4}));
                poke4move4 = new JComboBox (poke4move4List);
                poke4move4.setModel(new DefaultComboBoxModel(new String[] {moves4}));
        	}
        	
        	{	//Poke5
        		poke5move1 = new JComboBox (poke5move1List);
                poke5move1.setModel(new DefaultComboBoxModel(new String[] {moves5}));
                poke5move2 = new JComboBox (poke5move2List);
                poke5move2.setModel(new DefaultComboBoxModel(new String[] {moves5}));
                poke5move3 = new JComboBox (poke5move3List);
                poke5move3.setModel(new DefaultComboBoxModel(new String[] {moves5}));
                poke5move4 = new JComboBox (poke5move4List);
                poke5move4.setModel(new DefaultComboBoxModel(new String[] {moves5}));
        	}
        	
        	{	//Poke6
        		poke6move1 = new JComboBox (poke6move1List);
        	    poke6move1.setModel(new DefaultComboBoxModel(new String[] {moves6}));
        		poke6move2 = new JComboBox (poke6move2List);
                poke6move2.setModel(new DefaultComboBoxModel(new String[] {moves6}));
                poke6move3 = new JComboBox (poke6move3List);
                poke6move3.setModel(new DefaultComboBoxModel(new String[] {moves6}));
                poke6move4 = new JComboBox (poke6move4List);
                poke6move4.setModel(new DefaultComboBoxModel(new String[] {moves6}));
        	}
        }
        
        /*
         * IVs
         */
        {
        	{	//poke1
	        	poke1iv1 = new JTextField(2);
	            poke1iv2 = new JTextField(2);
	            poke1iv3 = new JTextField(2);
	            poke1iv4 = new JTextField(2);
	            poke1iv5 = new JTextField(2);
	            poke1iv6 = new JTextField(2);
        	}
        	
        	{	//poke2
    	        poke2iv1 = new JTextField(2);
    	        poke2iv2 = new JTextField(2);
    	        poke2iv3 = new JTextField(2);
    	        poke2iv4 = new JTextField(2);
    	        poke2iv5 = new JTextField(2);
    	        poke2iv6 = new JTextField(2);
        	}
        	
        	{	//poke3
        		poke3iv1 = new JTextField(2);
        		poke3iv2 = new JTextField(2);
        		poke3iv3 = new JTextField(2);
                poke3iv4 = new JTextField(2);
                poke3iv5 = new JTextField(2);
                poke3iv6 = new JTextField(2);
        	}
        	
        	{	//poke4
        		poke4iv1 = new JTextField(2);
        		poke4iv2 = new JTextField(2);
        		poke4iv3 = new JTextField(2);
        		poke4iv4 = new JTextField(2);
        		poke4iv5 = new JTextField(2);
                poke4iv6 = new JTextField(2);
        	}
        	
        	{	//poke5
        		poke5iv1 = new JTextField(2);
        		poke5iv2 = new JTextField(2);
        		poke5iv3 = new JTextField(2);
                poke5iv4 = new JTextField(2);
                poke5iv5 = new JTextField(2);
                poke5iv6 = new JTextField(2);
        	}
        	
        	{	//poke6
        		poke6iv1 = new JTextField(2);
        		poke6iv2 = new JTextField(2);
                poke6iv3 = new JTextField(2);
                poke6iv4 = new JTextField(2);
                poke6iv5 = new JTextField(2);
                poke6iv6 = new JTextField(2);
        	}
        }
        
        /*
         * EVs
         */
        {
        	{	//poke1
        		poke1ev1 = new JTextField(3);
        		poke1ev2 = new JTextField(3);
        		poke1ev3 = new JTextField(3);
        		poke1ev4 = new JTextField(3);
        		poke1ev5 = new JTextField(3);
        		poke1ev6 = new JTextField(3);
        	}
        	
        	{	//poke2
        		poke2ev1 = new JTextField(3);
        		poke2ev2 = new JTextField(3);
                poke2ev3 = new JTextField(3);
                poke2ev4 = new JTextField(3);
                poke2ev5 = new JTextField(3);
                poke2ev6 = new JTextField(3);
        	}
        	
        	{	//poke3
    	        poke3ev1 = new JTextField(3);
    	        poke3ev2 = new JTextField(3);
    	        poke3ev3 = new JTextField(3);
    	        poke3ev4 = new JTextField(3);
    	        poke3ev5 = new JTextField(3);
                poke3ev6 = new JTextField(3);
        	}
        	
        	{	//poke4
        		poke4ev1 = new JTextField(3);
        		poke4ev2 = new JTextField(3);
                poke4ev3 = new JTextField(3);
                poke4ev4 = new JTextField(3);
                poke4ev5 = new JTextField(3);
                poke4ev6 = new JTextField(3);
        	}
        	
        	{	//poke5
        		poke5ev1 = new JTextField(3);
        		poke5ev2 = new JTextField(3);
                poke5ev3 = new JTextField(3);
                poke5ev4 = new JTextField(3);
                poke5ev5 = new JTextField(3);
                poke5ev6 = new JTextField(3);
        	}
        	
        	{	//poke6
        		poke6ev1 = new JTextField(3);
        		poke6ev2 = new JTextField(3);
        		poke6ev3 = new JTextField(3);
        		poke6ev4 = new JTextField(3);
        		poke6ev5 = new JTextField(3);
        		poke6ev6 = new JTextField(3);
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
        
        /*
         * Buttons
         */
        {
        	FinalizeButton = new JButton ("Finalize");
        	FinalizeButton.addActionListener(new ActionListener()
        	{
        		public void actionPerformed(ActionEvent e)
        		{
        			Finalize();
        		}
        	});
        	
            RefreshButton = new JButton ("Refresh");
            RefreshButton.addActionListener(new ActionListener()
            {
            	public void actionPerformed(ActionEvent e)
            	{
            		onViewNotify();
            	}
            });	
        }

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
        add(poke4ev1);
        add(poke5ev1);
        add(poke2ev1);
        add(poke3ev1);
        add(poke2iv1);
        add(poke3iv1);
        add(poke4iv1);
        add(poke5iv1);
        add(poke6iv1);
        add(poke2iv2);
        add(poke2iv4);
        add(poke2iv5);
        add(poke3iv6);
        add(poke3iv3);
        add(poke3iv2);
        add(poke3iv4);
        add(poke3iv5);
        add(poke4iv6);
        add(poke4iv3);
        add(poke4iv2);
        add(poke4iv4);
        add(poke4iv5);
        add(poke5iv6);
        add(poke5iv3);
        add(poke5iv2);
        add(poke5iv4);
        add(poke5iv5);
        add(poke6iv6);
        add(poke6iv3);
        add(poke6iv2);
        add(poke6iv4);
        add(poke6iv5);
        add(poke2ev6);
        add(poke2ev3);
        add(poke2ev2);
        add(poke2ev4);
        add(poke2ev5);
        add(poke3ev6);
        add(poke3ev3);
        add(poke3ev2);
        add(poke3ev4);
        add(poke3ev5);
        add(poke4ev6);
        add(poke4ev3);
        add(poke4ev2);
        add(poke4ev4);
        add(poke4ev5);
        add(poke5ev6);
        add(poke5ev3);
        add(poke5ev2);
        add(poke5ev4);
        add(poke5ev5);
        add(poke6ev6);
        add(poke6ev3);
        add(poke6ev2);
        add(poke6ev4);
        add(poke6ev5);
        add(poke6ev1);
        add(poke2iv6);
        add(poke2iv3);
        
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
        poke2ev1.setBounds(230, 412, 100, 25);
        poke5ev1.setBounds(660, 412, 100, 25);
        poke3ev1.setBounds(375, 412, 100, 25);
        poke4ev1.setBounds(515, 412, 100, 25);
        poke2iv1.setBounds(230, 252, 100, 25);
        poke3iv1.setBounds(375, 252, 100, 25);
        poke4iv1.setBounds(515, 252, 100, 25);
        poke5iv1.setBounds(660, 252, 100, 25);
        poke6iv1.setBounds(800, 252, 100, 25);
        poke2iv3.setBounds(230, 296, 100, 25);
        poke2iv2.setBounds(230, 274, 100, 25);
        poke2iv4.setBounds(230, 318, 100, 25);
        poke2iv5.setBounds(230, 340, 100, 25);
        poke3iv6.setBounds(375, 362, 100, 25);
        poke3iv3.setBounds(375, 296, 100, 25);
        poke3iv2.setBounds(375, 274, 100, 25);
        poke3iv4.setBounds(375, 318, 100, 25);
        poke3iv5.setBounds(375, 340, 100, 25);
        poke4iv6.setBounds(515, 362, 100, 25);
        poke4iv3.setBounds(515, 296, 100, 25);
        poke4iv2.setBounds(515, 274, 100, 25);
        poke4iv4.setBounds(515, 318, 100, 25);
        poke4iv5.setBounds(515, 340, 100, 25);
        poke5iv6.setBounds(660, 362, 100, 25);
        poke5iv3.setBounds(660, 296, 100, 25);
        poke5iv2.setBounds(660, 274, 100, 25);
        poke5iv4.setBounds(660, 318, 100, 25);
        poke5iv5.setBounds(660, 340, 100, 25);
        poke6iv6.setBounds(800, 362, 100, 25);
        poke6iv3.setBounds(800, 296, 100, 25);
        poke6iv2.setBounds(800, 274, 100, 25);
        poke6iv4.setBounds(800, 318, 100, 25);
        poke6iv5.setBounds(800, 340, 100, 25);
        poke2ev6.setBounds(230, 522, 100, 25);
        poke2ev3.setBounds(230, 456, 100, 25);
        poke2ev2.setBounds(230, 434, 100, 25);
        poke2ev4.setBounds(230, 478, 100, 25);
        poke2ev5.setBounds(230, 500, 100, 25);
        poke3ev6.setBounds(375, 522, 100, 25);
        poke3ev3.setBounds(375, 456, 100, 25);
        poke3ev2.setBounds(375, 434, 100, 25);
        poke3ev4.setBounds(375, 478, 100, 25);
        poke3ev5.setBounds(375, 500, 100, 25);
        poke4ev6.setBounds(515, 522, 100, 25);
        poke6ev5.setBounds(800, 500, 100, 25);
        poke6ev4.setBounds(800, 478, 100, 25);
        poke6ev2.setBounds(800, 434, 100, 25);
        poke6ev3.setBounds(800, 456, 100, 25);
        poke6ev6.setBounds(800, 522, 100, 25);
        poke5ev5.setBounds(660, 500, 100, 25);
        poke5ev4.setBounds(660, 478, 100, 25);
        poke5ev2.setBounds(660, 434, 100, 25);
        poke5ev3.setBounds(660, 456, 100, 25);
        poke5ev6.setBounds(660, 522, 100, 25);
        poke4ev5.setBounds(515, 500, 100, 25);
        poke4ev4.setBounds(515, 478, 100, 25);
        poke4ev2.setBounds(515, 434, 100, 25);
        poke4ev3.setBounds(515, 456, 100, 25);
        poke6ev1.setBounds(800, 412, 100, 25);
        poke2iv6.setBounds(230, 362, 100, 25);
        
        JLabel evHeader = new JLabel("Effort Values (Individual Max of 252 - Total Max of510)");
        evHeader.setBounds(90, 398, 280, 14);
        add(evHeader);
        
        JLabel ivHeader = new JLabel("Individual Values (Individual Max of 31)");
        ivHeader.setBounds(90, 238, 240, 14);
        add(ivHeader);
    }
}
