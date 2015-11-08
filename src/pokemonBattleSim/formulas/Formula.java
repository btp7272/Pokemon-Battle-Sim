package pokemonBattleSim.formulas;
/*
 * Ben Churchill 9-27-2015
 * Formula calculator 
 */
import java.util.*;
import pokemonBattleSim.types.*;
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
			    			
    public static double ability;
    

    /****** Calculates the damage
     * @param pokemon a :: the attacking pokemon
     * @param pokemon b :: the defending pokemon
     * @param move m :: the move being used by pokemon a
     *****/
    public static int calcDamage(IPokemon attacker, IPokemon defender, Move m, IField field)
    {
        double damage;
        double numerator, denomenator;
        
        numerator = ( ( 2 * attacker.getLevel() ) + 10  );
        
        if(m.getCategory() == Attribute.PHYSICAL)
        {
            numerator = numerator * attacker.getAtk() * m.getPower();
            denomenator = 250 * defender.getDef();
        }
            
        else
        {
            numerator = numerator * attacker.getSpAtk() * m.getPower();
            denomenator = 250 * defender.getSpDef();
        }
        
        damage = (numerator / denomenator) + 2;
        damage *= modifier( attacker, defender, m, field );
        return (int)damage;
    }

    /****** Calculates addition factors for calcDamage
     * @param pokemon attacker :: the attacking pokemon
     * @param pokemon defender :: the defending pokemon
     * @param move m :: the move being used by attacker
     *****/
    public static double modifier(IPokemon attacker, IPokemon defender, Move m, IField field )
    {
        Random gen = new Random();
        
        //type is the type effectiveness. Can be 0 or a power between -2 to 2 of 2
        //stab (Same Type Attack Bonus) is a multiplier between 1.0 and 1.5. If the types of the attack and the pokemon are the same then the multiplier is 1.5
        //roll is a random damage rang multiplier between .85 and 1.0
        double stab,roll,type,weather;
        ability = 1;
        
        //Calculate STAB modifier
        if( attacker.getType1() == m.getType() || attacker.getType2() == m.getType() || attacker.getType3() == m.getType() )
            stab = 1.5;
        else
            stab = 1.0;
        
        //Calculate type modifier
        type = 1.0;
        type *= clacEffectiveness(type, m.getType(),defender.getType1());
        type *= clacEffectiveness(type, m.getType(),defender.getType2());
       
        //Calculate damage range
        roll = .85 + (1.0 - .85) * gen.nextDouble();
        
        //Calculate weather modifier
        if(field.getWeather() == Weather.NONE)
        	weather = 1.0;
        else if( m.getType() == Type.WATER && (field.getWeather() == Weather.RAIN || field.getWeather() == Weather.HEAVY_RAIN ))
        	weather = 1.5;
        else if( m.getType() == Type.FIRE && field.getWeather() == Weather.RAIN)
        	weather = 0.5;
        else if( m.getType() == Type.FIRE && field.getWeather() == Weather.HEAVY_RAIN)
        	weather = 0.0;
        else if( m.getType() == Type.FIRE && (field.getWeather() == Weather.SUN || field.getWeather() == Weather.INTENSE_SUN ))
        	weather = 1.5;
        else if( m.getType() == Type.WATER && field.getWeather() == Weather.SUN)
        	weather = 0.5;
        else if( m.getType() == Type.WATER && field.getWeather() == Weather.INTENSE_SUN)
        	weather = 0.0;
        else if( m.getType() == Type.ROCK && field.getWeather() == Weather.SANDSTORM && m.getCategory() == Attribute.SPECIAL)
        	weather = 0.5;
        else
        	weather = 1;
        
        Event.abilityEvent(attacker.getAbility(),EventType.PRE_DAMAGE,attacker,defender,field,attacker,defender,m);
        Event.abilityEvent(defender.getAbility(),EventType.PRE_DAMAGE,defender,attacker,field,attacker,defender,m);
        
        return (stab * type * roll * weather * ability);
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

