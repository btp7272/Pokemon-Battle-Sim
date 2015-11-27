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
			  /*0Normal*/  	{ 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 0.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 },
			  /*1Fighting*/ { 2.0, 1.0, 0.5, 0.5, 1.0, 2.0, 0.5, 0.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 2.0, 0.5 },
			  /*2Flying*/  	{ 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 0.5, 1.0, 2.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0 },
			  /*3Poison*/  	{ 1.0, 1.0, 1.0, 0.5, 0.5, 0.5, 1.0, 0.5, 0.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 },
			  /*4Ground*/  	{ 1.0, 1.0, 0.0, 2.0, 1.0, 2.0, 0.5, 1.0, 2.0, 2.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0 },
			  /*5Rock*/  	{ 1.0, 0.5, 2.0, 1.0, 0.5, 1.0, 2.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0 },
			  /*6Bug*/  	{ 1.0, 0.5, 0.5, 0.5, 1.0, 1.0, 1.0, 0.5, 0.5, 0.5, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 2.0, 0.5 },
			  /*7Ghost*/  	{ 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 1.0 },
			  /*8Steel*/  	{ 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 0.5, 0.5, 1.0, 0.5, 1.0, 2.0, 1.0, 1.0, 2.0 },
			  /*9Fire*/  	{ 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 2.0, 0.5, 0.5, 2.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0 },
			  /*10Water*/  	{ 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0 },
			  /*11Grass*/  	{ 1.0, 1.0, 0.5, 0.5, 2.0, 2.0, 0.5, 1.0, 0.5, 0.5, 2.0, 0.5, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0 },
			  /*12Electric*/{ 1.0, 1.0, 2.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 0.5, 1.0, 1.0 },
			  /*13Psychic*/ { 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 0.0, 1.0 },
			  /*14Ice*/     { 1.0, 1.0, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 0.5, 0.5, 2.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0 },
			  /*15Dragon*/  { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.0 },
			  /*16Dark*/ 	{ 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 0.5 },
			  /*17Fairy*/  	{ 1.0, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 0.5, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 1.0 }
			    			};
			    			
	static double[] priorityOperand = new double[]{ 5.0, 4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5 , 1, 1.0/2, 1.0/3, 1.0/4, 1.0/5, 1.0/6, 1.0/7, 1.0/8};
			    			
    public static double ability, item;
    public static int priority;
    

    /****** Calculates the damage
     * @param pokemon a :: the attacking pokemon
     * @param pokemon b :: the defending pokemon
     * @param move m :: the move being used by pokemon a
     *****/
    public static int calcDamage(IPokemon attacker, IPokemon defender, Move m, IField field)
    {
    	if(m.getCategory() == Attribute.STATUS)
    		return 0;
    	
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
        item = 1;
        
        //Calculate STAB modifier
        if( attacker.getType1() == m.getType() || attacker.getType2() == m.getType() || attacker.getType3() == m.getType() )
            stab = 1.5;
        else
            stab = 1.0;
        
        //Calculate type modifier
        type = 1.0;
        if(defender.getType1() != null)
        	type = clacEffectiveness(type, m.getType(),defender.getType1());
        if(defender.getType2() != null)
        	type = clacEffectiveness(type, m.getType(),defender.getType2());
        if(defender.getType3() != null)
        	type = clacEffectiveness(type, m.getType(),defender.getType3());
       
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
        
        //Calculate Ability modifier
        Event.abilityEvent(EventType.PRE_DAMAGE,attacker,defender,field,attacker,defender,m);
        Event.abilityEvent(EventType.PRE_DAMAGE,defender,attacker,field,attacker,defender,m);
        Event.itemPrimaryEffectEvent(attacker, EventType.PRE_DAMAGE, m);
        Event.itemSecondaryEffectEvent(attacker, EventType.PRE_DAMAGE, m);
        Event.itemPrimaryEffectEvent(defender, EventType.PRE_DAMAGE, m);
        Event.itemSecondaryEffectEvent(defender, EventType.PRE_DAMAGE, m);
        
        return (stab * type * roll * weather * ability * item);
    }
    
    //Calculates the type modifier
    public static double clacEffectiveness(double curModifier, Type atkType, Type defType)
    {
    	curModifier *= effectiveness[atkType.getMask()][defType.getMask()];
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
    	double result;
    	double numerator =  (2 * baseStat) + IV + Math.floor((EV / 4));
    	numerator *= level;
    	result = Math.floor(numerator/100) + 5;
    	return (int)result;
    }
    
    //Calculates the amount of time the start up of a move takes (in millisecons)
    public static int calcStartUp(IPokemon attacker, Move move)
    {
    	double result = move.getAccuracy() * attacker.getSpeed();
    	result *= 35;
    	return (int)result;
    }
    
    //Calculates the amount of time the execution of a move takes (in millisecons)
    public static int calcExecution(IPokemon attacker, Move move)
    {
    	double result = move.getPower() * priorityOperand[priority + 6];
    	result *= 35;
    	return (int)result;
    }
    
    //Calculates the amount of time the execution of a move takes (in millisecons)
    public static int calcCoolDown(int executionTime)
    {
    	return executionTime / 3;
    }
    
    public static boolean isSuperEffective(IPokemon defender, Move moveUsed)
    {
       if(defender.getType3() != null && defender.getType2() != null)
	   {
		   if(Formula.clacEffectiveness(1, moveUsed.getType(), defender.getType1())
				   * Formula.clacEffectiveness(1, moveUsed.getType(), defender.getType2()) 
				   * Formula.clacEffectiveness(1, moveUsed.getType(), defender.getType2()) > 1.0)
		   {
			   return true;
		   }
	   }
	   else if(defender.getType2() != null)
	   {
		   if(Formula.clacEffectiveness(1, moveUsed.getType(), defender.getType1())
				   + Formula.clacEffectiveness(1, moveUsed.getType(), defender.getType2()) > 1.0)
		   {
			   return true;
		   }
	   }
	   else if(Formula.clacEffectiveness(1, moveUsed.getType(), defender.getType1()) > 1.0)
	   {
		   return true;
	   }
    	
       return false;
    }
    
} // end class

