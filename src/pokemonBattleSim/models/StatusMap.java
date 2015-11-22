package pokemonBattleSim.models;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import pokemonBattleSim.formulas.Formula;
import pokemonBattleSim.types.*;

public class StatusMap 
{
	private static IBattleModel model = BattleModel.getInstance();
	public static Map < String, IStatus > statusMap;
	
	static
	{
		statusMap.put("Healthy", new IStatus()
		{
				EventType trigger = EventType.NONE;
				String name = "Healthy";
				private String description = "No status conditions";
				private int degree = -1;
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public int getDegree(){return degree;}
				public void setDegree(int deg)
				{
					//not applicable
				}
				public double run (IPokemon wielder, EventType type, Move moveUsed)
				{
					return 1;
				}
		});
		
		statusMap.put("Confusion", new IStatus()
		{
				EventType trigger = EventType.PRE_ATTACK;
				String name = "Confusion";
				String description = "The confused condition causes a Pokémon to hurt itself in its confusion 50% of the time. The damage is done as if the Pokémon attacked itself with a 40-power typeless physical attack.";
				private int degree = 0;
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public int getDegree(){return degree;}
				public void setDegree(int deg)//can be between 0 and 100
				{
					degree += deg;
					if(degree >= 100)
						degree %= 100;
				}
				public double run (IPokemon wielder, EventType type, Move moveUsed)
				{
					double damage;
			        double numerator, denomenator;
			        numerator = ( ( 2 * wielder.getLevel() ) + 10  ); 
			        numerator = numerator * wielder.getAtk() * 40;
			        denomenator = 250 * wielder.getDef();
			        damage = (numerator / denomenator) + 2;
			        wielder.changeHP((int)damage);
					return 1;
				}
		});
		
		/**
		 * One of two effects of the curse status condition.
		 * Curse1 is in charge of subtracting the inflicted pokemon's HP
		 * Curse2 is in charge of making sure the inflicted pokemon cannot heal
		 */
		statusMap.put("Curse1", new IStatus()
		{
				EventType trigger = EventType.CONTINUOUS;
				String name = "Curse";
				String description = "The curse condition causes a Pokémon to lose ¼ of its maximum hit points every turn. A Pokémon afflicted by Curse cannot be healed except by switching out. If the victim of a Ghost-type Curse uses Baton Pass, the health-sapping effect is transferred to its replacement.";
				private int degree = -1;
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public int getDegree(){return degree;}
				public void setDegree(int deg)
				{
					//not applicable
				}
				private boolean active = false;
				public double run (IPokemon wielder, EventType type, Move moveUsed)
				{
				   Timer timer = new Timer();
				   class SetTimer extends TimerTask
				   {
					   @Override
					   public void run()
					   {
						   if(!model.getPlayerPokemonName(wielder.getPlayerID()).equals(wielder.getNickName()))
						   {
							   timer.cancel();
							   active = false;
							   return;
						   }
						   wielder.changeHP(wielder.getMaxHP() / 4);
						   return;
					   }
				   }
				   
				   if(!active)
				   {
					   TimerTask task = new SetTimer();
					   timer.schedule(task, 10000, 10000);
					   active = true;
				   }
				   return 1;
				}
		});
		
		statusMap.put("Curse2", new IStatus()
		{
				EventType trigger = EventType.HP_CHANGE;
				String name = "Curse";
				String description = "The curse condition causes a Pokémon to lose ¼ of its maximum hit points every turn. A Pokémon afflicted by Curse cannot be healed except by switching out. If the victim of a Ghost-type Curse uses Baton Pass, the health-sapping effect is transferred to its replacement.";
				private int degree = -1;
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public int getDegree(){return degree;}
				public void setDegree(int deg)
				{
					//not applicable
				}
				public double run (IPokemon wielder, EventType type, Move moveUsed)
				{
				    System.out.println(wielder.getNickName()+" is prevented from healing!");
					return 1;
				}
		});
		
		statusMap.put("Heal Block1", new IStatus()
		{
				EventType trigger = EventType.CONTINUOUS;
				String name = "Heal Block";
				String description = "A Pokémon affected by Heal Block is prevented from healing for five turns. It cannot use Ingrain, Aqua Ring, Moonlight, Morning Sun, Roost, Recover, Heal Order, Rest, Soft-Boiled, Wish, Milk Drink, Slack Off, or Synthesis while it is under effect. "
						+ "It is unaffected by Ingrain, Aqua Ring, and Heal Pulse. The player can still use items such as Potions to heal the Pokémon.The moves Absorb, Mega Drain, Giga Drain, Leech Life, Dream Eater, Drain Punch, Horn Leech, Parabolic Charge, Draining Kiss, Oblivion Wing, and Leech Seed will still inflict damage, but will not restore HP when the user is affected by Heal Block. "
						+ "Pokémon with the Ability Volt Absorb or Water Absorb will take damage, as opposed to healing, from Electric- or Water-type attacks respectively while Heal Block is in effect. A poisoned Pokémon with Poison Heal is neither healed nor damaged. Leftovers are also negated by Heal Block.";
				private int degree = -1;
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public int getDegree(){return degree;}
				private boolean active = false;
				public void setDegree(int deg)
				{
					//not applicable
				}
				public double run (IPokemon wielder, EventType type, Move moveUsed)
				{
				   Timer timer = new Timer();
				   class SetTimer extends TimerTask
				   {
					   @Override
					   public void run()
					   {
						   timer.cancel();
						   wielder.getVolatileStatus().remove("Heal Block1");
						   wielder.getVolatileStatus().remove("Heal Block2");
						   return;
					   }
				   }
				   
				   if(!active)
				   {
					   TimerTask task = new SetTimer();
					   timer.schedule(task,50000); //5 turns
					   active = true;
				   }
				   return 1;
				}
		});
		
		statusMap.put("Heal Block2", new IStatus()
		{
				EventType trigger = EventType.HP_CHANGE;
				String name = "Heal Block";
				String description = "A Pokémon affected by Heal Block is prevented from healing for five turns. It cannot use Ingrain, Aqua Ring, Moonlight, Morning Sun, Roost, Recover, Heal Order, Rest, Soft-Boiled, Wish, Milk Drink, Slack Off, or Synthesis while it is under effect. "
						+ "It is unaffected by Ingrain, Aqua Ring, and Heal Pulse. The player can still use items such as Potions to heal the Pokémon.The moves Absorb, Mega Drain, Giga Drain, Leech Life, Dream Eater, Drain Punch, Horn Leech, Parabolic Charge, Draining Kiss, Oblivion Wing, and Leech Seed will still inflict damage, but will not restore HP when the user is affected by Heal Block. "
						+ "Pokémon with the Ability Volt Absorb or Water Absorb will take damage, as opposed to healing, from Electric- or Water-type attacks respectively while Heal Block is in effect. A poisoned Pokémon with Poison Heal is neither healed nor damaged. Leftovers are also negated by Heal Block.";
				private int degree = -1;
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public int getDegree(){return degree;}
				private boolean active = false;
				public void setDegree(int deg)
				{
					//not applicable
				}
				public double run (IPokemon wielder, EventType type, Move moveUsed)
				{
				    System.out.println(wielder.getNickName()+" is prevented from healing!");
					return 1;
				}
		});
		
		statusMap.put("Flinch", new IStatus()
		{
				EventType trigger = EventType.POST_ATTACK;
				String name = "Flinch";
				String description = "Prevents a Pokémon from attacking.";
				private int degree = 0;
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public int getDegree(){return degree;}
				public void setDegree(int deg)
				{
					degree += deg;
					if(degree > 100)
						degree %= 100;
				}
				public double run (IPokemon wielder, EventType type, Move moveUsed)
				{
				    //pause the opposing pokemon's move queue
					return 1;
				}
		});
		
		statusMap.put("Encore", new IStatus()
		{
				EventType trigger = EventType.PRE_ATTACK;
				String name = "Encore";
				String description = "Forces the Pokémon to repeat its last attack for 3 turns.";
				private int degree = -1;
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public int getDegree(){return degree;}
				private boolean active = false;
				public void setDegree(int deg)
				{
					//not applicable
				}
				
				private Move forcedMove;
				public void setForcedMove(Move move)
				{
					forcedMove = move;
				}
					
				public double run (IPokemon wielder, EventType type, Move moveUsed)
				{
					Timer timer = new Timer();
					class SetTimer extends TimerTask
					{
					   @Override
					   public void run()
					   {
						   timer.cancel();
						   wielder.getVolatileStatus().remove("Encore");
						   active = false;
						   return;
					   }
			     	}
					
					if(!active)
					{
						TimerTask task = new SetTimer();
						timer.schedule(task,30000); //3 turns
						active = true;
					}
					
					IPokemon defender = model.getOpponentPokemon(wielder.getPlayerID());
					int damage = Formula.calcDamage(wielder, defender, forcedMove, model.getField());
					//add events
					defender.changeHP(damage);
					return 1;
				}
		});
		
		statusMap.put("Protection1", new IStatus()
		{
				EventType trigger = EventType.CONTINUOUS;
				String name = "Protection";
				String description = "A Pokémon that uses Protect or Detect will be impervious to attacks and negative status moves targeting them that turn except; "
						+ "if the protected Pokémon is hit by Feint or Shadow Force, which can both hit through protection, the Pokémon's protection is removed for the rest of the turn.";
				private int degree = 0;
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public int getDegree(){return degree;}
				private boolean active = false;
				public void setDegree(int deg)
				{
					degree += deg;
					if(degree > 100)
						degree %= 100;
				}
				public double run (IPokemon wielder, EventType type, Move moveUsed)
				{
				   Timer timer = new Timer();
				   class SetTimer extends TimerTask
				   {
					   @Override
					   public void run()
					   {
						   timer.cancel();
						   active = false;
						   wielder.getVolatileStatus().remove("Protection1");
						   wielder.getVolatileStatus().remove("Protection2");
						   return;
					   }
				   }
					   
				   if(!active)
				   {
					   TimerTask task = new SetTimer();
					   timer.schedule(task, 10000);
					   active = true;
				   }
				   return 1;
				}
		});
		
		statusMap.put("Protection2", new IStatus()
		{
				EventType trigger = EventType.PRE_ATTACK;
				String name = "Protection";
				String description = "A Pokémon that uses Protect or Detect will be impervious to attacks and negative status moves targeting them that turn except; "
						+ "if the protected Pokémon is hit by Feint or Shadow Force, which can both hit through protection, the Pokémon's protection is removed for the rest of the turn.";
				private int degree = -1;
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public int getDegree(){return degree;}
				public void setDegree(int deg)
				{
					//not applicable
				}
				public double run (IPokemon wielder, EventType type, Move moveUsed)
				{
				    if(moveUsed.getName().equals("Feint") || moveUsed.getName().equals("Shadow Force"))
				    {
				    	IPokemon attacker = model.getOpponentPokemon(wielder.getPlayerID());
						int damage = Formula.calcDamage(attacker, wielder, moveUsed, model.getField());
						//add events
						wielder.changeHP(damage);
						wielder.getVolatileStatus().remove("Protection1");
						wielder.getVolatileStatus().remove("Protection2");
				    }
				    else if(moveUsed.getName().equals("Hyperspace Fury"))
				    {
				    	IPokemon attacker = model.getOpponentPokemon(wielder.getPlayerID());
						int damage = Formula.calcDamage(attacker, wielder, moveUsed, model.getField());
						//add events
						wielder.changeHP(damage);
				    }
				    else
				    	System.out.println(wielder.getNickName()+" protected itself!");
					return 1;
				}
		});
		
		statusMap.put("Burn", new IStatus()
		{
				EventType trigger = EventType.CONTINUOUS;
				String name = "Burn";
				String description = "The burn condition halves damage dealt by a Pokémon's physical moves (except for Pokémon with the Guts Ability, where this condition raises Attack by 50%). "
						+ "Additionally, at the end of a turn, the Pokémon loses 1/8 its maximum hit points.";
				private int degree = 0;
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public int getDegree(){return degree;}
				public void setDegree(int deg)
				{
					degree += deg;
					if(degree > 100)
						degree = 100;
				}
				
				private int originalAttack;
				public void setOriginalAttack(int baseAtk)
				{
					originalAttack = baseAtk;
				}
				
				boolean active = false;
				
				public double run (IPokemon wielder, EventType type, Move moveUsed)
				{
				   Timer timer = new Timer();
				   class SetTimer extends TimerTask
				   {
					   @Override
					   public void run()
					   {
						   if(wielder.getHP() == 0)
						   {
							   timer.cancel();
							   active = false;
						   }
						   
						   if(!model.getPlayerPokemonName(wielder.getPlayerID()).equals(wielder.getNickName()))
						   {
							   timer.cancel();
							   active = false;
						   }
						   
						   if(degree == 0)
						   {
							   timer.cancel();
							   wielder.setNonVolatileStatus("Healthy");
							   active = false;
							   wielder.setMaxAtk(originalAttack);
							   return;
						   }
						   wielder.setMaxAtk((int)( (double)originalAttack - (((double)originalAttack)/2) * ((double)degree/100)) );
						   wielder.changeHP((int)( (double)(wielder.getMaxHP()/8) - ((double)(wielder.getMaxHP()/8)) * ((double)degree/100)) );
						   return;
					   }
				   }
				   
				   if(!active && degree > 0)
				   {
					   TimerTask task = new SetTimer();
				   	   timer.schedule(task, 0, 10000);
				   	   active = true;
				   	   originalAttack = wielder.getMaxAtk();
				   }
					   
				   return 1;
				}
		});
	}
}
