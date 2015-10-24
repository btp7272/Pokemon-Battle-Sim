package pokemonBattleSim.formulas;
/*
 * Ben Churchill 9-27-2015
 * Formula calculator 
 */
import java.util.*;
import pokemonBattleSim.types.Type;
import pokemonBattleSim.types.Pokemon;
import pokemonBattleSim.types.Attribute;
import pokemonBattleSim.types.Move;
import java.lang.Math;

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
        double damage;
        
        if(m.getCategory() == Attribute.PHYSICAL)
        {
            double numerator, denomenator;
            numerator = ( ( 2 * a.getLevel() ) + 10  );
            numerator = numerator * a.getAtk() * m.getPower();
            denomenator = 250 * b.getDef();
            damage = (numerator / denomenator) + 2;
            damage *= modifier( a, b, m );
            return (int)damage;
        }
            
        else
        {
        	double numerator, denomenator;
            numerator = ( ( 2 * a.getLevel() ) + 10  );
            numerator = numerator * a.getSpAtk() * m.getPower();
            denomenator = 250 * b.getSpDef();
            damage = (numerator / denomenator) + 2;
            damage *= modifier( a, b, m );
            return (int)damage;
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
        type *= clacEffectiveness(type, m.getType(),b.getType1());
        type *= clacEffectiveness(type, m.getType(),b.getType2());
       
        //Calculate damage range
        roll = .85 + (1.0 - .85) * gen.nextDouble();
        
        return (stab * type * roll);
    }
    
    //Calculates the type modifier
    public static double clacEffectiveness(double curModifier, Type atkType, Type defType)
    {
    	curModifier *= 1;//effectiveness[atkType.getMask()][defType.getMask()];
    	return curModifier;
    }
    
    //Calculates the max HP of a pokemon (assumes all IVs are 31 and level is 100)
    public static int calcHP(int baseHP, int IV, int EV, int level)
    {
    	int result;
    	int numerator =  2 * baseHP + IV + (EV / 4);
    	numerator *= level;
    	result = numerator/100 + level + 10;
    	return result;
    }
    
    //Calculates all other max stats (assumes all IVs are 31 and level is 100)
    public static int calcStat(int baseStat, int IV, int EV, int level)
    {
    	int result;
    	int numerator =  (2 * baseStat) + IV + (EV / 4);
    	numerator *= level;
    	result = numerator/100 + 5;
    	return result;
    }
    
} // end class

