package pokemonBattleSim.models;

import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

import pokemonBattleSim.formulas.Formula;
import pokemonBattleSim.types.Attribute;
import pokemonBattleSim.types.Event;
import pokemonBattleSim.types.EventType;
import pokemonBattleSim.types.IAbility;
import pokemonBattleSim.types.IField;
import pokemonBattleSim.types.IPokemon;
import pokemonBattleSim.types.Move;
import pokemonBattleSim.types.Type;
import pokemonBattleSim.types.Weather;
import pokemonBattleSim.types.AbilityContainer;

public class AbilityMap
{
	public static Map < String, IAbility > abilityMap = new HashMap<>();
	public static int[] statChangeQueue = new int[5];
	private static IBattleModel model = BattleModel.getInstance();
	
	public enum Stat
	{
		ATTACK(0),
		DEFENSE(1),
		SPECIAL_ATTACK(2),
		SPECIAL_DEFENSE(3),
		SPEED(4);
		
		private final int mask;
		Stat(int mask)
		{
			this.mask = mask;
		}
		public int getMask()
		{
			return this.mask;
		}
	}
	
	static
	{
			abilityMap.put("Intimidate", new IAbility()
			{
				   EventType trigger = EventType.ENTRY;
				   String name = "Intimidate";
				   String description = "Lowers the foe's Attack by 1 stage.";
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed)
				   { 
					   System.out.println(wielder.getNickName() + "'s Intimidate");
					   statChangeQueue[Stat.ATTACK.getMask()] = -1;
					   if(Event.abilityEvent(EventType.STATISTIC_CHANGE,opponent,wielder,field,attacker,defender,moveUsed))
					   {
						   statChangeQueue[Stat.ATTACK.getMask()] = 0;
						   return 1;
					   }
					   else
					   {
						   opponent.changeAtk(statChangeQueue[Stat.ATTACK.getMask()]);
						   statChangeQueue[Stat.ATTACK.getMask()] = 0;
						   return 1;
					   }
				   }
			});
			
			abilityMap.put("Simple", new IAbility()
			{
				   EventType trigger = EventType.STATISTIC_CHANGE;
				   String name = "Simple";
				   String description = "Doubles the effect of stat boosts and drops.";
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				   { 
					   System.out.println(wielder.getNickName() + "'s Simple");
					   if(statChangeQueue[Stat.ATTACK.getMask()] != 0)
						   wielder.changeAtk(2 * statChangeQueue[Stat.ATTACK.getMask()]);
					   if(statChangeQueue[Stat.DEFENSE.getMask()] != 0)
						   wielder.changeDef(2 * statChangeQueue[Stat.DEFENSE.getMask()]);
					   if(statChangeQueue[Stat.SPECIAL_ATTACK.getMask()] != 0)
						   wielder.changeSpAtk(2 * statChangeQueue[Stat.SPECIAL_ATTACK.getMask()]);
					   if(statChangeQueue[Stat.SPECIAL_DEFENSE.getMask()] != 0)
						   wielder.changeSpDef(2 * statChangeQueue[Stat.SPECIAL_DEFENSE.getMask()]);
					   if(statChangeQueue[Stat.SPEED.getMask()] != 0)
						   wielder.changeSpeed(2 * statChangeQueue[Stat.SPEED.getMask()]);
					   return 1;
				   }
			});
			
			abilityMap.put("Clear Body", new IAbility()
			{
				   EventType trigger = EventType.STATISTIC_CHANGE;
				   String name = "Clear Body";
				   String description = "Stops the enemy from lowering this IPokemon's stats.";
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				   { 
					   boolean negativeAttempt = false;
					   
					   if(statChangeQueue[Stat.ATTACK.getMask()] > -1)
						   wielder.changeAtk(statChangeQueue[Stat.ATTACK.getMask()]);
					   else
						   negativeAttempt = true;
					   if(statChangeQueue[Stat.DEFENSE.getMask()] > -1)
						   wielder.changeDef(statChangeQueue[Stat.DEFENSE.getMask()]);
					   else
						   negativeAttempt = true;
					   if(statChangeQueue[Stat.SPECIAL_ATTACK.getMask()] > -1)
						   wielder.changeSpAtk(statChangeQueue[Stat.SPECIAL_ATTACK.getMask()]);
					   else
						   negativeAttempt = true;
					   if(statChangeQueue[Stat.SPECIAL_DEFENSE.getMask()] > -1)
						   wielder.changeSpDef(statChangeQueue[Stat.SPECIAL_DEFENSE.getMask()]);
					   else
						   negativeAttempt = true;
					   if(statChangeQueue[Stat.SPEED.getMask()] > -1)
						   wielder.changeSpeed(statChangeQueue[Stat.SPEED.getMask()]);
					   else
						   negativeAttempt = true;
					   
					   if(negativeAttempt)
					   {
						   System.out.println(wielder.getNickName() + "'s Clear Body");
						   System.out.println(opponent.getNickName() + "'s Clear Body prevented negative stat changes");
					   }
					   return 1;
				   }
			});
			
			abilityMap.put("Contrary", new IAbility()
			{
				   EventType trigger = EventType.STATISTIC_CHANGE;
				   String name = "Contrary";
				   String description = "The wielder's stat changes are reversed.";
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				   { 
					   System.out.println(wielder.getNickName() + "'s Contrary");
					   if(statChangeQueue[Stat.ATTACK.getMask()] != 0)
						   wielder.changeAtk(- statChangeQueue[Stat.ATTACK.getMask()]);
					   if(statChangeQueue[Stat.DEFENSE.getMask()] != 0)
						   wielder.changeDef(- statChangeQueue[Stat.DEFENSE.getMask()]);
					   if(statChangeQueue[Stat.SPECIAL_ATTACK.getMask()] != 0)
						   wielder.changeSpAtk(- statChangeQueue[Stat.SPECIAL_ATTACK.getMask()]);
					   if(statChangeQueue[Stat.SPECIAL_DEFENSE.getMask()] != 0)
						   wielder.changeSpDef(- statChangeQueue[Stat.SPECIAL_DEFENSE.getMask()]);
					   if(statChangeQueue[Stat.SPEED.getMask()] != 0)
						   wielder.changeSpeed(- statChangeQueue[Stat.SPEED.getMask()]);
					   return 1;
				   }
			});
			
			abilityMap.put("Drizzle", new IAbility()
			{
				 EventType trigger = EventType.ENTRY;
				 String name = "Drizzle";
				 String description = "Summons rain.";
				 public EventType getEventTrigger(){return trigger;}
				 public String getName(){return name;}
				 public String getDescription(){return description;}
				 public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				 { 
					 if(field.getWeather() == Weather.HEAVY_RAIN)
						 return 1;
					 else if(field.getWeather() == Weather.RAIN)
						 return 1;
					 else if(field.getWeather() == Weather.HEAVY_RAIN_NO_EFFECT)
						 return 1;
					 else if(field.getWeather() == Weather.RAIN_NO_EFFECT)
						 return 1;
			   		 else if(field.getWeather() == Weather.INTENSE_SUN)
			   			 return 1;
			   		 else if(field.getWeather() == Weather.INTENSE_SUN_NO_EFFECT)
			   			 return 1;
					 
					 System.out.println(wielder.getNickName() + "'s Drizzle");
					 if(opponent.getAbility().getName().equals("Cloud Nine"))
						 field.setWeather(Weather.RAIN_NO_EFFECT);
					 else
						 field.setWeather(Weather.RAIN);
					 return 1;
				   }
			});
			
			abilityMap.put("Drought", new IAbility()
			{
				   String name = "Drought";
				   String description = "Summons sun.";
				   EventType trigger = EventType.ENTRY;
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				   { 
					   if(field.getWeather() == Weather.HEAVY_RAIN)
						   return 1;
					   else if(field.getWeather() == Weather.SUN)
						   return 1;
					   else if(field.getWeather() == Weather.HEAVY_RAIN_NO_EFFECT)
						   return 1;
					   else if(field.getWeather() == Weather.SUN_NO_EFFECT)
						   return 1;
					   else if(field.getWeather() == Weather.INTENSE_SUN)
						   return 1;
					   else if(field.getWeather() == Weather.INTENSE_SUN_NO_EFFECT)
						   return 1;
					   
					   System.out.println(wielder.getNickName() + "'s Drought");
					   if(opponent.getAbility().getName().equals("Cloud Nine"))
							 field.setWeather(Weather.SUN_NO_EFFECT);
						 else
							 field.setWeather(Weather.SUN);
					   return 1;
				   }
			});
			
			abilityMap.put("Desolate Land", new IAbility()
			{
				   String name = "Desolate Land";
				   String description = "Summons Heavy Sun until IPokemon leaves battle. Water-type moves and weather changing moves/abilities fail, except for Primordial Sea and Delta Stream.";
				   EventType trigger = EventType.ENTRY;
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				   { 
					   if(field.getWeather() == Weather.INTENSE_SUN)
						   return 1;
					   else if(field.getWeather() == Weather.INTENSE_SUN_NO_EFFECT)
						   return 1;
					   
					   System.out.println(wielder.getNickName() + "'s Desolate Land");
					   if(opponent.getAbility().getName().equals("Cloud Nine"))
							 field.setWeather(Weather.INTENSE_SUN_NO_EFFECT);
						 else
							 field.setWeather(Weather.INTENSE_SUN);
					   return 1;
				   }
			});
			
			abilityMap.put("Primordial Sea", new IAbility()
			{
				   String name = "Desolate Land";
				   String description = "Summons Heavy Rain until IPokemon leaves battle. Fire-type moves and weather changing moves/abilities fail, except for Desolate Land and Delta Stream.";
				   EventType trigger = EventType.ENTRY;
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				   { 
					   if(field.getWeather() == Weather.HEAVY_RAIN)
						   return 1;
					   else if(field.getWeather() == Weather.HEAVY_RAIN_NO_EFFECT)
						   return 1;
					   
					   System.out.println(wielder.getNickName() + "'s Primordial Sea");
					   if(opponent.getAbility().getName().equals("Cloud Nine"))
							 field.setWeather(Weather.HEAVY_RAIN_NO_EFFECT);
						 else
							 field.setWeather(Weather.HEAVY_RAIN);
					   return 1;
				   }
			});
			
			abilityMap.put("Sand Stream", new IAbility()
			{
				   String name = "Sand Stream";
				   String description = "Summons Sandstorm.";
				   EventType trigger = EventType.ENTRY;
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				   { 
					   if(field.getWeather() == Weather.HEAVY_RAIN)
						   return 1;
					   else if(field.getWeather() == Weather.HEAVY_RAIN_NO_EFFECT)
						   return 1;
					   else if(field.getWeather() == Weather.INTENSE_SUN)
						   return 1;
					   else if(field.getWeather() == Weather.INTENSE_SUN_NO_EFFECT)
						   return 1;
					   else if(field.getWeather() == Weather.SANDSTORM)
						   return 1;
					   else if(field.getWeather() == Weather.SANDSTORM_NO_EFFECT)
						   return 1;
					   
					   System.out.println(wielder.getNickName() + "'s Sand Stream");
					   if(opponent.getAbility().getName().equals("Cloud Nine"))
							 field.setWeather(Weather.SANDSTORM_NO_EFFECT);
						 else
							 field.setWeather(Weather.SANDSTORM);
					   return 1;
				   }
			});
			
			abilityMap.put("Mummy", new IAbility()
			{
				   String name = "Mummy";
				   String description = "The opponent's ability becomes Mummy when it hits the wielder with a contact move.";
				   EventType trigger = EventType.POST_ATTACK;
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				   { 
					   if(moveUsed.getCategory().getMask() == Attribute.PHYSICAL.getMask())
					   {
						   System.out.println(wielder.getNickName() + "'s Mummy");
						   opponent.setAbility(new AbilityContainer("Mummy"));
						   System.out.println(opponent.getNickName() + "'s Mummy");
					   }
					   return 1;
				   }
			});
			
			abilityMap.put("Iron Barbs", new IAbility()
			{
				   String name = "Iron Barbs";
				   String description = "Deals 1/8 recoil damage when the opponent makes contact.";
				   EventType trigger = EventType.POST_ATTACK;
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				   { 
					   if(moveUsed.getCategory().getMask() == Attribute.PHYSICAL.getMask())
					   {
						   System.out.println(wielder.getNickName() + "'s Iron Barbs");
					   }
					   return 1;
				   }
			});
			
			abilityMap.put("Unaware", new IAbility()
			{
				   String name = "Unaware";
				   String description = "Ignores stat boosts and debuffs on other IPokemon.";
				   EventType trigger = EventType.PRE_DAMAGE;
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				   { 
					   if(wielder == defender)
					   {
						   if(moveUsed.getCategory().getMask() == Attribute.PHYSICAL.getMask())
							   Formula.ability *= 1 / ((double)opponent.getAtk() / opponent.getMaxAtk());
						   else
							   Formula.ability *= 1 / ((double)opponent.getSpAtk() / opponent.getMaxSpAtk());
						   return 1;
					   }
					   else
					   {
						   if(moveUsed.getCategory().getMask() == Attribute.PHYSICAL.getMask())
							   Formula.ability *= 1 / ((double)opponent.getDef() / opponent.getMaxDef());
						   else
							   Formula.ability *= 1 / ((double)opponent.getSpDef() / opponent.getMaxSpDef());
						   return 1;
					   }
				   }
			});
			
			abilityMap.put("Levitate", new IAbility()
			{
				   String name = "Levitate";
				   String description = "This Pokemon is immune to Ground-type moves..";
				   EventType trigger = EventType.PRE_DAMAGE;
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				   { 
					   if(moveUsed.getType() == Type.GROUND && wielder == defender)
					   {
						   System.out.println(wielder.getNickName()+" 's Levitate");
						   Formula.ability *= 0; 
					   }
					   return 1;
				   }
			});
			
			abilityMap.put("Cloud Nine", new IAbility()
			{
				   String name = "Cloud Nine";
				   String description = "Blocks the effects of weather.";
				   EventType trigger = EventType.ENTRY;
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				   { 
					   System.out.println(wielder.getNickName() + "'s Cloud Nine");
					   if(field.getWeather() == Weather.NONE)
						   return 1;
					   
					   else if(field.getWeather() == Weather.RAIN)
						   field.setWeather(Weather.RAIN_NO_EFFECT);
					   else if(field.getWeather() == Weather.HEAVY_RAIN)
						   field.setWeather(Weather.HEAVY_RAIN_NO_EFFECT);
					   else if(field.getWeather() == Weather.SUN)
						   field.setWeather(Weather.SUN_NO_EFFECT);
					   else if(field.getWeather() == Weather.INTENSE_SUN)
						   field.setWeather(Weather.INTENSE_SUN_NO_EFFECT);
					   else if(field.getWeather() == Weather.HAIL)
						   field.setWeather(Weather.HAIL_NO_EFFECT);
					   else if (field.getWeather() == Weather.SANDSTORM)
						   field.setWeather(Weather.SANDSTORM_NO_EFFECT);
					   System.out.println("The effects of weather dissapeared");
					   return 1;
				   }
			});
			
			abilityMap.put("Defeatist", new IAbility()
			{
				   String name = "Defeatist";
				   String description = "Halves the wielder's Attack and Special Attack if its HP drops below 50%.";
				   EventType trigger = EventType.HP_CHANGE;
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				   { 
					   if( wielder.getAbility().getActiveStatus() == false && wielder.getHP() < (wielder.getMaxHP() / 2) )
					   {
						   wielder.getAbility().setOriginalStats(wielder);
						   wielder.setMaxAtk(wielder.getMaxAtk() / 2);
						   wielder.setMaxSpAtk(wielder.getMaxSpAtk() / 2);
						   wielder.getAbility().setActiveStatus(true);
						   return 1;
					   }
					   
					   if( wielder.getAbility().getActiveStatus() == true && wielder.getHP() >= (wielder.getMaxHP() / 2) )
					   {
						   wielder.setMaxAtk(wielder.getAbility().getOriginalStat(Stat.ATTACK.getMask()));
						   wielder.setMaxAtk(wielder.getAbility().getOriginalStat(Stat.SPECIAL_ATTACK.getMask()));
						   wielder.getAbility().setActiveStatus(false);
						   return 1;
					   }
					   return 1;
				   }
			});
			
			abilityMap.put("Mold Breaker", new IAbility()
			{
				   String name = "Mold Breaker";
				   String description = "Abilities that hinder attacks are nullified.";
				   EventType trigger = EventType.PRE_ATTACK;
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   private double modifier(IPokemon attacker, IPokemon defender, Move moveUsed, IField field )
				   {
					   Random gen = new Random();
				        
				        //type is the type effectiveness. Can be 0 or a power between -2 to 2 of 2
				        //stab (Same Type Attack Bonus) is a multiplier between 1.0 and 1.5. If the types of the attack and the pokemon are the same then the multiplier is 1.5
				        //roll is a random damage rang multiplier between .85 and 1.0
				        double stab,roll,type,weather;
				        
				        //Calculate STAB modifier
				        if( attacker.getType1() == moveUsed.getType() || attacker.getType2() == moveUsed.getType() || attacker.getType3() == moveUsed.getType() )
				            stab = 1.5;
				        else
				            stab = 1.0;
				        
				        //Calculate type modifier
				        type = 1.0;
				        type *= Formula.clacEffectiveness(type, moveUsed.getType(),defender.getType1());
				        type *= Formula.clacEffectiveness(type, moveUsed.getType(),defender.getType2());
				       
				        //Calculate damage range
				        roll = .85 + (1.0 - .85) * gen.nextDouble();
				        
				        //Calculate weather modifier
				        if(field.getWeather() == Weather.NONE)
				        	weather = 1.0;
				        else if( moveUsed.getType() == Type.WATER && (field.getWeather() == Weather.RAIN || field.getWeather() == Weather.HEAVY_RAIN ))
				        	weather = 1.5;
				        else if( moveUsed.getType() == Type.FIRE && field.getWeather() == Weather.RAIN)
				        	weather = 0.5;
				        else if( moveUsed.getType() == Type.FIRE && field.getWeather() == Weather.HEAVY_RAIN)
				        	weather = 0.0;
				        else if( moveUsed.getType() == Type.FIRE && (field.getWeather() == Weather.SUN || field.getWeather() == Weather.INTENSE_SUN ))
				        	weather = 1.5;
				        else if( moveUsed.getType() == Type.WATER && field.getWeather() == Weather.SUN)
				        	weather = 0.5;
				        else if( moveUsed.getType() == Type.WATER && field.getWeather() == Weather.INTENSE_SUN)
				        	weather = 0.0;
				        else if( moveUsed.getType() == Type.ROCK && field.getWeather() == Weather.SANDSTORM && moveUsed.getCategory() == Attribute.SPECIAL)
				        	weather = 0.5;
				        else
				        	weather = 1;
				        				        
				        return (stab * type * roll * weather);
				   }
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				   { 
					   double damage;
				       double numerator, denomenator;
				       numerator = ( ( 2 * attacker.getLevel() ) + 10  );
				        
				       if(moveUsed.getCategory() == Attribute.PHYSICAL)
				       {
				           numerator = numerator * attacker.getAtk() * moveUsed.getPower();
				           denomenator = 250 * defender.getDef();
				       }
				           
				       else if(moveUsed.getCategory() == Attribute.SPECIAL)
				       {
			            numerator = numerator * attacker.getSpAtk() * moveUsed.getPower();
			            denomenator = 250 * defender.getSpDef();
				       }
				       
				       else
				       {
				    	   numerator = -2;
				    	   denomenator = 1;
				       }
			           damage = (numerator / denomenator) + 2;
				       damage *= modifier( attacker, defender, moveUsed, field );
				       
				       defender.changeHP((int)damage);
				       if(defender.getHP() == 0)
				    	   Event.abilityEvent(EventType.KO,opponent,wielder,field,attacker,defender,moveUsed);
				       
				       //Move Event
				       
				       //for phasing move, include hazard damage
				       
					   return 1;
				   }
			});
			
			abilityMap.put("Aftermath", new IAbility()
			{
				   String name = "Aftermath";
				   String description = "Deals 25% damage when KOed by contact damage.";
				   EventType trigger = EventType.KO;
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				   { 
					   if(moveUsed.getCategory() == Attribute.PHYSICAL)
						   attacker.changeHP(attacker.getMaxHP() / 4);
					   return 1;
				   }
			});
			
			abilityMap.put("Regenerator", new IAbility()
			{
				   String name = "Regenerator";
				   String description = "Wielder heals 1/3 of its maximum HP on switching out.";
				   EventType trigger = EventType.EXIT;
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				   { 
					   wielder.changeHP(- wielder.getMaxHP() / 3);
					   return 1;
				   }
			});
			
			abilityMap.put("Speed Boost", new IAbility()
			{
				   String name = "Speed Boost";
				   String description = "Speed raises over time.";
				   EventType trigger = EventType.ENTRY;
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				   { 
					   Timer timer = new Timer();
					   class SetTimer extends TimerTask
					   {
						   @Override
						   public void run()
						   {
							   if(!model.getPlayerPokemonSpeciesName(wielder.getPlayerID()).equals(wielder.getSpeciesName()))
							   {
								   timer.cancel();
								   return;
							   }
							   if(wielder.getSpeedModifier() != 6)
								   wielder.changeSpeed(1);
						   }
					   }
					   TimerTask task = new SetTimer();
					   timer.schedule(task, 10000, 10000);
					   return 1;
				   }
			});
			
			abilityMap.put("Solid Rock", new IAbility()
			{
				   String name = "Solid Rock";
				   String description = "Reduces damage from super effective hits by 1/4.";
				   EventType trigger = EventType.PRE_DAMAGE;
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				   { 
					   if(Formula.isSuperEffective(wielder, moveUsed))
					   {
						   Formula.ability *= ( 3.0 / 4);
						   System.out.println(wielder.getNickName()+"'s Solid Rock!");
					   }
						   
					   return 1;
				   }
			});
			
			abilityMap.put("Skill Link", new IAbility()
			{
				   String name = "Skill Link";
				   String description = "Multi-hit moves will always hit the maximum number of times.";
				   EventType trigger = EventType.PRE_ATTACK;
				   public EventType getEventTrigger(){return trigger;}
				   public String getName(){return name;}
				   public String getDescription(){return description;}
				   public double run (IPokemon wielder, IPokemon opponent, IField field, IPokemon attacker, IPokemon defender, Move moveUsed) 
				   { 
					   if(moveUsed.getName().equals("Bullet Seed")
						   || moveUsed.getName().equals("Arm Thrust")	
						   || moveUsed.getName().equals("Barrage")	
						   || moveUsed.getName().equals("Bone Rush")	
						   || moveUsed.getName().equals("Comet Punch")	
						   || moveUsed.getName().equals("Double Slap")
						   || moveUsed.getName().equals("Fury Attack")	
						   || moveUsed.getName().equals("Fury Swipes")
						   || moveUsed.getName().equals("Icicle Spear")	
						   || moveUsed.getName().equals("Pin Missile")
						   || moveUsed.getName().equals("Rock Blast")
						   || moveUsed.getName().equals("Spike Cannon")	
						   || moveUsed.getName().equals("Tail Slap")
						   || moveUsed.getName().equals("Water Shuriken"))
					   {
						    if(Event.abilityEvent(EventType.PRE_ATTACK, defender, attacker, field, attacker, defender, moveUsed))
							{
								//run method automatically executed
							}
							else
							{
								int damage;
								for(int i = 0; i < 5; i++)
								{
									damage = Formula.calcDamage(attacker, defender, moveUsed, field);
									defender.changeHP(damage);
									//check for ability even of the defender
									Event.abilityEvent(EventType.HP_CHANGE, defender, attacker, field, attacker, defender, moveUsed);
									//check for ability event of the defender
									Event.statusVolatileEvent(attacker, EventType.POST_ATTACK, moveUsed);
									Event.abilityEvent(EventType.POST_ATTACK, defender, attacker, field, attacker, defender, moveUsed);
									Event.itemEffectEvent(attacker, EventType.POST_ATTACK, moveUsed);
									Event.itemEffectEvent(defender, EventType.POST_ATTACK, moveUsed);
								}
								System.out.println("It hit 5 times!");
							}
					   }
					   
					   else
					   {
						   	//check for move event of the attacker
							if(Event.moveEffectEvent(attacker, EventType.PRE_ATTACK, moveUsed))
							{
								//run method automatically executed
							}
							else
							{
								int damage = Formula.calcDamage(attacker, defender, moveUsed, field);
								damage = defender.changeHP(damage);
								//check for ability even of the defender
								Event.abilityEvent(EventType.HP_CHANGE, defender, attacker, field, attacker, defender, moveUsed);
								//check for ability event of the defender
								Event.statusVolatileEvent(attacker, EventType.POST_ATTACK, moveUsed);
								Event.abilityEvent(EventType.POST_ATTACK, defender, attacker, field, attacker, defender, moveUsed);
								moveUsed.getMoveEffectContainer().updateMoveEffectContainer(attacker, damage);
								Event.moveEffectEvent(attacker, EventType.POST_ATTACK, moveUsed);
							}
					   }
						   
					   return 1;
				   }
			});
	}
}
