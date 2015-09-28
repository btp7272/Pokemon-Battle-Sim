import java.util.*;
import java.lang.*;
public class Formula
{
    

    /****** Calculates the damage
     * @param pokemon a :: the attacking pokemon
     * @param pokemon b :: the defending pokemon
     * @param move m :: the move being used by pokemon a
     *****/
    public static int calcDamage(Pokemon a, Pokemon b, Move m)
    {
        int damage;
        
        if(m.getCategory() == PHYSICAL)
        {
            return ( ( 21 / 25 ) * ( a.getAtk() / b.getDef() ) * m.getBase() + 2 ) * modifier(a,b,m);
        }
            
        else
        {
            return ( ( 21 / 25 ) * ( a.getAtk() / b.getDef() ) * m.getBase() + 2 ) * modifier(a,b,m);
        }
    }

    /****** Calculates addition factors for calcDamage
     * @param pokemon a :: the attacking pokemon
     * @param pokemon b :: the defending pokemon
     * @param move m :: the move being used by pokemon a
     *****/
    public static int modifier(Pokemon a, Pokemon b, Move m )
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
        type *= dmgTypeMult(a.getType1, m.getType());
        type *= dmgTypeMult(a.getType2, m.getType());
        
        
        //Calculate damage range
        roll = .85 + (1.0 - .85) * gen.nextDouble();
        
        return (int)(stab * type * roll);
    }
    
} // end class

