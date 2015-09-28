/*
 * Ben Churchill 9-27-2015
 * Formula calculator 
 */
import java.util.*;
import java.lang.*;
public class Formula
{
	/****** Keeps track of type interactions :: [attacking type][defending type] ******/
	static double[][] effectiveness = new double[][]{
			  //  			   0    1    2    3    4    5    6    7    8    9    10   11   12   13   14   15   16   17
			  /*Normal*/  	{ 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 0.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 },
			  /*Fighting*/  { 2.0, 1.0, 0.5, 0.5, 1.0, 2.0, 0.5, 0.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 2.0, 0.5 },
			  /*Flying*/  	{ 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 0.5, 1.0, 2.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0 },
			  /*Poison*/  	{ 1.0, 1.0, 1.0, 0.5, 0.5, 0.5, 1.0, 0.5, 0.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 },
			  /*Ground*/  	{ 1.0, 1.0, 0.0, 2.0, 1.0, 2.0, 0.5, 1.0, 2.0, 2.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0 },
			  /*Rock*/  	{ 1.0, 0.5, 2.0, 1.0, 0.5, 1.0, 2.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0 },
			  /*Bug*/  		{ 1.0, 0.5, 0.5, 0.5, 1.0, 1.0, 1.0, 0.5, 0.5, 0.5, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 2.0, 0.5 },
			  /*Ghost*/  	{ 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 1.0 },
			  /*Steel*/  	{ 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 0.5, 0.5, 1.0, 0.5, 1.0, 2.0, 1.0, 1.0, 2.0 },
			  /*Fire*/  	{ 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 2.0, 0.5, 0.5, 2.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0 },
			  /*Water*/  	{ 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0 },
			  /*Grass*/  	{ 1.0, 1.0, 0.5, 0.5, 2.0, 2.0, 0.5, 1.0, 0.5, 0.5, 2.0, 0.5, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0 },
			  /*Electric*/  { 1.0, 1.0, 2.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 0.5, 1.0, 1.0 },
			  /*Psychic*/   { 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 0.0, 1.0 },
			  /*Ice*/  	    { 1.0, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 0.5, 0.5, 2.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0 },
			  /*Dragon*/  	{ 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.0 },
			  /*Dark*/ 		{ 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 0.5 },
			  /*Fairy*/  	{ 1.0, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 0.5, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 1.0 }
			    			};
    

    /****** Calculates the damage
     * @param pokemon a :: the attacking pokemon
     * @param pokemon b :: the defending pokemon
     * @param move m :: the move being used by pokemon a
     *****/
    public static int calcDamage(Pokemon a, Pokemon b, Move m)
    {
        int damage;
        
        if(m.getCategory() == Attribute.PHYSICAL)
        {
            return ( ( 21 / 25 ) * ( a.getAtk() / b.getDef() ) * m.getPower() + 2 ) * modifier(a,b,m);
        }
            
        else
        {
            return ( ( 21 / 25 ) * ( a.getSpAtk() / b.getSpDef() ) * m.getPower() + 2 ) * modifier(a,b,m);
        }
    }

    /****** Calculates addition factors for calcDamage
     * @param pokemon a :: the attacking pokemon
     * @param pokemon b :: the defending pokemon
     * @param move m :: the move being used by pokemon a
     *****/
    public static double modifier(Pokemon a, Pokemon b, Move m )
    {
        Random gen = new Random();
        
        //type is the type effectiveness. Can be 0 or a power between -2 to 2 of 2
        //stab (Same Type Attack Bonus) is a multiplier between 1.0 and 1.5. If the types of the attack and the pokemon are the same then the multiplier is 1.5
        //roll is a random damage rang multiplier between .85 and 1.0
        double stab,roll,type;

        
        //Calculate STAB modifier
        if( a.getType1() == m.getType() || a.getType2() == m.getType() )
            stab = 1.5;
        else
            stab = 1.0;
        
        //Calculate type modifier
        type = 1.0;
        type *= effectiveness[m.getType().getMask()][b.getType1().getMask()];
        type *= effectiveness[m.getType().getMask()][b.getType2().getMask()];
        
        //Calculate damage range
        roll = .85 + (1.0 - .85) * gen.nextDouble();
        
        return (stab * type * roll);
    }
    
    
} // end class

