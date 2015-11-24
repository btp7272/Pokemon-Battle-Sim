package pokemonBattleSim.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import pokemonBattleSim.formulas.Formula;
import pokemonBattleSim.types.*;

public class StatusMap 
{
	private static IBattleModel model = BattleModel.getInstance();
	public static Map < String, IStatus > statusMap = new HashMap<>();
	
	static
	{
		statusMap.put("Healthy", new IStatus()
		{
				EventType trigger = EventType.NONE;
				String name = "Healthy";
				private String description = "No non-volitile status conditions";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public double run (IPokemon wielder,  Move moveUsed)
				{
					return 1;
				}
		});
		
		statusMap.put("Confusion", new IStatus()
		{
				EventType trigger = EventType.PRE_ATTACK;
				String name = "Confusion";
				String description = "The confused condition causes a Pokémon to hurt itself in its confusion 50% of the time. The damage is done as if the Pokémon attacked itself with a 40-power typeless physical attack.";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public double run (IPokemon wielder,  Move moveUsed)
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
		 * Curse is in charge of subtracting the inflicted pokemon's HP and activating Curse2
		 * Curse2 is in charge of making sure the inflicted pokemon cannot heal
		 */
		statusMap.put("Curse", new IStatus()
		{
				EventType trigger = EventType.POST_STATUS_CHANGE;
				String name = "Curse";
				String description = "The curse condition causes a Pokémon to lose ¼ of its maximum hit points every turn. A Pokémon afflicted by Curse cannot be healed except by switching out. If the victim of a Ghost-type Curse uses Baton Pass, the health-sapping effect is transferred to its replacement.";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public double run (IPokemon wielder,  Move moveUsed)
				{
				   Timer timer = new Timer();
				   class SetTimer extends TimerTask
				   {
					   @Override
					   public void run()
					   {
						   if(!model.getPlayerPokemon(wielder.getPlayerID()).equals(wielder.getNickName()))
						   {
							   timer.cancel();
							   wielder.removeVolatileStatus("Curse");
							   wielder.removeVolatileStatus("Curse2");
							   return;
						   }
						   wielder.changeHP(wielder.getMaxHP() / 4);
						   return;
					   }
				   }
				   
				   if(wielder.getVolatileStatus("Curse1").getActiveStatus() == false)
				   {
					   TimerTask task = new SetTimer();
					   timer.schedule(task, 10000, 10000);
					   wielder.getVolatileStatus("Curse").setActiveStatus(true);
					   wielder.addVolatileStatus(new StatusContainer(-1,-1,"Curse2",null));
					   wielder.getVolatileStatus("Curse2").setActiveStatus(true);
				   }
				   return 1;
				}
		});
		
		statusMap.put("Curse2", new IStatus()
		{
				EventType trigger = EventType.HEAL;
				String name = "Curse";
				String description = "The curse condition causes a Pokémon to lose ¼ of its maximum hit points every turn. A Pokémon afflicted by Curse cannot be healed except by switching out. If the victim of a Ghost-type Curse uses Baton Pass, the health-sapping effect is transferred to its replacement.";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public double run (IPokemon wielder,  Move moveUsed)
				{
				    System.out.println(wielder.getNickName()+" is prevented from healing!");
					return 1;
				}
		});
		
		statusMap.put("Heal Block", new IStatus()
		{
				EventType trigger = EventType.POST_STATUS_CHANGE;
				String name = "Heal Block";
				String description = "A Pokémon affected by Heal Block is prevented from healing for five turns. It cannot use Ingrain, Aqua Ring, Moonlight, Morning Sun, Roost, Recover, Heal Order, Rest, Soft-Boiled, Wish, Milk Drink, Slack Off, or Synthesis while it is under effect. "
						+ "It is unaffected by Ingrain, Aqua Ring, and Heal Pulse. The player can still use items such as Potions to heal the Pokémon.The moves Absorb, Mega Drain, Giga Drain, Leech Life, Dream Eater, Drain Punch, Horn Leech, Parabolic Charge, Draining Kiss, Oblivion Wing, and Leech Seed will still inflict damage, but will not restore HP when the user is affected by Heal Block. "
						+ "Pokémon with the Ability Volt Absorb or Water Absorb will take damage, as opposed to healing, from Electric- or Water-type attacks respectively while Heal Block is in effect. A poisoned Pokémon with Poison Heal is neither healed nor damaged. Leftovers are also negated by Heal Block.";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public double run (IPokemon wielder,  Move moveUsed)
				{
				   Timer timer = new Timer();
				   class SetTimer extends TimerTask
				   {
					   @Override
					   public void run()
					   {
						   timer.cancel();
						   wielder.getVolatileStatus().remove("Heal Block");
						   wielder.getVolatileStatus().remove("Heal Block2");
						   return;
					   }
				   }
				   
				   if(wielder.getVolatileStatus("Curse1").getActiveStatus() == false)
				   {
					   TimerTask task = new SetTimer();
					   timer.schedule(task,50000); //5 turns
					   wielder.getVolatileStatus("Heal Block").setActiveStatus(true);
					   wielder.addVolatileStatus(new StatusContainer(-1,-1,"Heal Block2",null));
					   wielder.getVolatileStatus("Heal Block2").setActiveStatus(true);
				   }
				   return 1;
				}
		});
		
		statusMap.put("Heal Block2", new IStatus()
		{
				EventType trigger = EventType.HEAL;
				String name = "Heal Block";
				String description = "A Pokémon affected by Heal Block is prevented from healing for five turns. It cannot use Ingrain, Aqua Ring, Moonlight, Morning Sun, Roost, Recover, Heal Order, Rest, Soft-Boiled, Wish, Milk Drink, Slack Off, or Synthesis while it is under effect. "
						+ "It is unaffected by Ingrain, Aqua Ring, and Heal Pulse. The player can still use items such as Potions to heal the Pokémon.The moves Absorb, Mega Drain, Giga Drain, Leech Life, Dream Eater, Drain Punch, Horn Leech, Parabolic Charge, Draining Kiss, Oblivion Wing, and Leech Seed will still inflict damage, but will not restore HP when the user is affected by Heal Block. "
						+ "Pokémon with the Ability Volt Absorb or Water Absorb will take damage, as opposed to healing, from Electric- or Water-type attacks respectively while Heal Block is in effect. A poisoned Pokémon with Poison Heal is neither healed nor damaged. Leftovers are also negated by Heal Block.";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public double run (IPokemon wielder,  Move moveUsed)
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
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public double run (IPokemon wielder,  Move moveUsed)
				{
				    if(wielder.getVolatileStatus("Flinch").getDegreeResetStatus())
				    {
				    	//push dead space to the opponent's queue
				    }
					return 1;
				}
		});
		
		statusMap.put("Encore", new IStatus()
		{
				EventType trigger = EventType.PRE_ATTACK;
				String name = "Encore";
				String description = "Forces the Pokémon to repeat its last attack for 3 turns.";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
					
				public double run (IPokemon wielder,  Move moveUsed)
				{
					Timer timer = new Timer();
					class SetTimer extends TimerTask
					{
					   @Override
					   public void run()
					   {
						   timer.cancel();
						   wielder.removeVolatileStatus("Encore");
						   return;
					   }
			     	}
					
					if(wielder.getVolatileStatus("Encore").getActiveStatus() == false)
					{
						TimerTask task = new SetTimer();
						timer.schedule(task,30000); //3 turns
						wielder.getVolatileStatus("Encore").setActiveStatus(true);
					}

					IPokemon defender = model.getOpponentPokemon(wielder.getPlayerID());
					if(Event.abilityEvent(EventType.PRE_ATTACK, wielder, defender, model.getField(), wielder, defender, wielder.getVolatileStatus("Encore").getForcedMove()))
					{
						//run method automatically executed
					}
					//check for ability event of the defender
					else if(Event.abilityEvent(EventType.PRE_ATTACK, defender, wielder, model.getField(), wielder, defender, wielder.getVolatileStatus("Encore").getForcedMove()))
					{
						//run method automatically executed
					}
					else
					{
						int damage = Formula.calcDamage(wielder, defender, wielder.getVolatileStatus("Encore").getForcedMove(), model.getField());
						defender.changeHP(damage);
						//check for ability even of the defender
						Event.abilityEvent(EventType.HP_CHANGE, defender, wielder, model.getField(), wielder, defender, wielder.getVolatileStatus("Encore").getForcedMove());
						//check for ability event of the defender
						Event.abilityEvent(EventType.POST_ATTACK, defender, wielder, model.getField(), wielder, defender, wielder.getVolatileStatus("Encore").getForcedMove());
					}

					return 1;
				}
		});
		
		statusMap.put("Protection", new IStatus()
		{
				EventType trigger = EventType.POST_STATUS_CHANGE;
				String name = "Protection";
				String description = "A Pokémon that uses Protect or Detect will be impervious to attacks and negative status moves targeting them that turn except; "
						+ "if the protected Pokémon is hit by Feint or Shadow Force, which can both hit through protection, the Pokémon's protection is removed for the rest of the turn.";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}
				public String getDescription(){return description;}
				public double run (IPokemon wielder,  Move moveUsed)
				{
					Timer timer = new Timer();
					class SetTimer extends TimerTask
					{
					   @Override
					   public void run()
					   {
						   timer.cancel();
						   wielder.removeVolatileStatus("Protection");
						   wielder.removeVolatileStatus("Protection2");
						   return;
					   }
			     	}
					
					if(wielder.getVolatileStatus("Protection").getActiveStatus() == false)
					{
						TimerTask task = new SetTimer();
						timer.schedule(task,10000); //3 turns
						wielder.getVolatileStatus("Protection").setActiveStatus(true);
						wielder.addVolatileStatus(new StatusContainer(-1,-1,"Protection2",null));
						wielder.getVolatileStatus("Protection").setActiveStatus(true);
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
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public double run (IPokemon wielder,  Move moveUsed)
				{
				    if(moveUsed.getName().equals("Feint") || moveUsed.getName().equals("Shadow Force"))
				    {
				    	IPokemon attacker = model.getOpponentPokemon(wielder.getPlayerID());
						if(Event.abilityEvent(EventType.PRE_ATTACK, attacker, wielder, model.getField(), attacker, wielder, moveUsed))
						{
							//run method automatically executed
						}
						//check for ability event of the defender
						else if(Event.abilityEvent(EventType.PRE_ATTACK, wielder, attacker, model.getField(), attacker, wielder, moveUsed))
						{
							//run method automatically executed
						}
						else
						{
							int damage = Formula.calcDamage(attacker, wielder, moveUsed, model.getField());
							wielder.changeHP(damage);
							//check for ability even of the defender
							Event.abilityEvent(EventType.HP_CHANGE, wielder, attacker, model.getField(), attacker, wielder, moveUsed);
							//check for ability event of the defender
							Event.abilityEvent(EventType.POST_ATTACK, wielder, attacker, model.getField(), attacker, wielder, moveUsed);
						}
				    }
				    else if(moveUsed.getName().equals("Hyperspace Fury"))
				    {
				    	IPokemon attacker = model.getOpponentPokemon(wielder.getPlayerID());
						if(Event.abilityEvent(EventType.PRE_ATTACK, attacker, wielder, model.getField(), attacker, wielder, moveUsed))
						{
							//run method automatically executed
						}
						//check for ability event of the defender
						else if(Event.abilityEvent(EventType.PRE_ATTACK, wielder, attacker, model.getField(), attacker, wielder, moveUsed))
						{
							//run method automatically executed
						}
						else
						{
							int damage = Formula.calcDamage(attacker, wielder, moveUsed, model.getField());
							wielder.changeHP(damage);
							//check for ability even of the defender
							Event.abilityEvent(EventType.HP_CHANGE, wielder, attacker, model.getField(), attacker, wielder, moveUsed);
							//check for ability event of the defender
							Event.abilityEvent(EventType.POST_ATTACK, wielder, attacker, model.getField(), attacker, wielder, moveUsed);
						}
				    }
				    else
				    	System.out.println(wielder.getNickName()+" protected itself!");
					return 1;
				}
		});
		
		statusMap.put("Burn", new IStatus()
		{
				EventType trigger = EventType.POST_STATUS_CHANGE;
				String name = "Burn";
				String description = "The burn condition halves damage dealt by a Pokémon's physical moves (except for Pokémon with the Guts Ability, where this condition raises Attack by 50%). "
						+ "Additionally, at the end of a turn, the Pokémon loses 1/8 its maximum hit points.";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				
				public double run (IPokemon wielder,  Move moveUsed)
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
							   wielder.getNonVolatileStatusContainer().setActiveStatus(false);
							   return;
						   }
						   
						   if(!model.getPlayerPokemonName(wielder.getPlayerID()).equals(wielder.getNickName()))
						   {
							   timer.cancel();
							   wielder.getNonVolatileStatusContainer().setActiveStatus(false);
							   return;
						   }
						   
						   if(wielder.getNonVolatileStatusContainer().getDegree() == 0)
						   {
							   timer.cancel();
							   wielder.setNonVolatileStatus(new StatusContainer(-1,-1,"Healthy",null));
							   wielder.setMaxAtk(wielder.getNonVolatileStatusContainer().getOriginalStat());
							   return;
						   }
						   wielder.setMaxAtk((int)( (double)wielder.getNonVolatileStatusContainer().getOriginalStat() - (((double)wielder.getNonVolatileStatusContainer().getOriginalStat())/2) * ((double)wielder.getNonVolatileStatusContainer().getDegree()/100)) );
						   wielder.changeHP((int)( (double)(wielder.getMaxHP()/8) - ((double)(wielder.getMaxHP()/8)) * ((double)wielder.getNonVolatileStatusContainer().getDegree()/100)) );
						   wielder.getNonVolatileStatusContainer().addToDegree(-10, false);
						   return;
					   }
				   }
				   
				   if(wielder.getNonVolatileStatusContainer().getActiveStatus() == false)
				   {
					   TimerTask task = new SetTimer();
				   	   timer.schedule(task, 0, 10000);
				   	   wielder.getNonVolatileStatusContainer().setActiveStatus(true);
				   	   wielder.getNonVolatileStatusContainer().setOriginalStat(wielder.getMaxAtk());
				   }
					   
				   return 1;
				}
		});
		
		statusMap.put("Paralysis", new IStatus()
		{
				EventType trigger = EventType.POST_STATUS_CHANGE;
				String name = "Paralysis";
				String description = "The paralysis condition causes a Pokémon to be unable to attack if 100% paralyzed. "
						+ "Additionally, its Speed is reduced to 25% of its previous value (except for Pokémon with the Quick Feet Ability, where this condition raises the Speed by 50%).";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				
				public double run (IPokemon wielder,  Move moveUsed)
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
							   wielder.getNonVolatileStatusContainer().setActiveStatus(false);
							   return;
						   }
						   
						   if(!model.getPlayerPokemonName(wielder.getPlayerID()).equals(wielder.getNickName()))
						   {
							   timer.cancel();
							   wielder.getNonVolatileStatusContainer().setActiveStatus(false);
							   return;
						   }
						   
						   if(wielder.getNonVolatileStatusContainer().getDegree() == 0)
						   {
							   timer.cancel();
							   wielder.setNonVolatileStatus(new StatusContainer(-1,-1,"Healthy",null));
							   wielder.setMaxSpeed(wielder.getNonVolatileStatusContainer().getOriginalStat());
							   return;
						   }
						   wielder.setMaxSpeed((int)( (double)wielder.getNonVolatileStatusContainer().getOriginalStat() - 3 * (((double)wielder.getNonVolatileStatusContainer().getOriginalStat())/4) * ((double)wielder.getNonVolatileStatusContainer().getDegree()/100)) );
						   wielder.getNonVolatileStatusContainer().addToDegree(-10, false);
						   return;
					   }
				   }
				   
				   if(wielder.getNonVolatileStatusContainer().getActiveStatus() == false)
				   {
					   TimerTask task = new SetTimer();
				   	   timer.schedule(task, 0, 10000);
				   	   wielder.getNonVolatileStatusContainer().setActiveStatus(true);
				   	   wielder.getNonVolatileStatusContainer().setOriginalStat(wielder.getMaxSpeed());
				   }
					   
				   return 1;
				}
		});
		
		statusMap.put("Poison", new IStatus()
		{
				EventType trigger = EventType.POST_STATUS_CHANGE;
				String name = "Poison";
				String description = "The poison condition causes a Pokémon to lose 1/8 of its maximum hit points every turn."
						+ "Normally Steel- and Poison-type Pokémon and Pokémon with the Immunity Ability cannot be poisoned; however, if a Pokémon is poisoned then has its type changed to Steel or Poison or its "
						+ "Ability changed to Immunity, the poison will remain. A Pokémon with the Poison Heal Ability will gradually recover health instead when poisoned.";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				
				public double run (IPokemon wielder,  Move moveUsed)
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
							   wielder.getNonVolatileStatusContainer().setActiveStatus(false);
							   return;
						   }
						   
						   if(!model.getPlayerPokemonName(wielder.getPlayerID()).equals(wielder.getNickName()))
						   {
							   timer.cancel();
							   wielder.getNonVolatileStatusContainer().setActiveStatus(false);
							   return;
						   }
						   
						   if(wielder.getNonVolatileStatusContainer().getDegree() == 0)
						   {
							   timer.cancel();
							   wielder.setNonVolatileStatus(new StatusContainer(-1,-1,"Healthy",null));
							   return;
						   }
						   
						   wielder.changeHP((int)( (double)(wielder.getMaxHP()/8) - ((double)(wielder.getMaxHP()/8)) * ((double)wielder.getNonVolatileStatusContainer().getDegree()/100)) );
						   wielder.getNonVolatileStatusContainer().addToDegree(-10, false);
						   return;
					   }
				   }
				   
				   if(wielder.getNonVolatileStatusContainer().getActiveStatus() == false)
				   {
					   TimerTask task = new SetTimer();
				   	   timer.schedule(task, 10000, 10000);
				   	   wielder.getNonVolatileStatusContainer().setActiveStatus(true);
				   }
					   
				   return 1;
				}
		});
		
		statusMap.put("Badly Poison", new IStatus()
		{
				EventType trigger = EventType.POST_STATUS_CHANGE;
				String name = "Badly Poison";
				String description = "The badly poison condition causes a Pokémon to lose 1/2 of its maximum hit points multiplied by the degree of the status (a percent) every turn."
						+ "The degree of the status increases over time.";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				
				public double run (IPokemon wielder,  Move moveUsed)
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
							   wielder.getNonVolatileStatusContainer().setActiveStatus(false);
							   return;
						   }
						   
						   if(!model.getPlayerPokemonName(wielder.getPlayerID()).equals(wielder.getNickName()))
						   {
							   timer.cancel();
							   wielder.getNonVolatileStatusContainer().setActiveStatus(false);
							   return;
						   }
						   
						   if(wielder.getNonVolatileStatusContainer().getDegree() == 0)
						   {
							   timer.cancel();
							   wielder.setNonVolatileStatus(new StatusContainer(-1,-1,"Healthy",null));
							   return;
						   }
						   
						   wielder.changeHP((int)( ((double)(wielder.getMaxHP()/2)) * ((double)wielder.getNonVolatileStatusContainer().getDegree()/100)) );
						   wielder.getNonVolatileStatusContainer().addToDegree(10, false);
						   return;
					   }
				   }
				   
				   if(wielder.getNonVolatileStatusContainer().getActiveStatus() == false)
				   {
					   TimerTask task = new SetTimer();
				   	   timer.schedule(task, 10000, 10000);
				   	   wielder.getNonVolatileStatusContainer().setActiveStatus(true);
				   }
					   
				   return 1;
				}
		});
	}
}
