package pokemonBattleSim.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import pokemonBattleSim.formulas.Formula;
import pokemonBattleSim.online.Send;
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
					  if (model == null) model = BattleModel.getInstance();
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
					Timer timer = new Timer();
					   class SetTimer extends TimerTask
					   {
						   @Override
						   public void run()
						   {
								  if (model == null) model = BattleModel.getInstance();
							   if(!model.getPlayerPokemon(wielder.getPlayerID()).equals(wielder.getSpeciesName()))
							   {
								   timer.cancel();
								   wielder.removeVolatileStatus("Confusion");
								   return;
							   }
							  
							   wielder.getVolatileStatus("Confusion").addToDegree(-35, false);
							   model.addLogItem(wielder.getNickName()+" snapped a little out of confusion!");
							   if(wielder.getVolatileStatus("Confusion").getDegree() == 0)
							   {
								   wielder.removeVolatileStatus("Confusion");
								   model.addLogItem(wielder.getNickName()+" is confused no more!");
								   timer.cancel();
							   }
							   else if(wielder.getVolatileStatus("Confusion").getDegree() >= 65)
							   {
								   model.addLogItem(wielder.getNickName()+" will still hit itself!");
							   }
							   else 
							   {
								   model.addLogItem(wielder.getNickName()+" will no longer hit itself!");
							   }
							   return;
						   }
					   }
					
					 if(wielder.getVolatileStatus("Confusion").getActiveStatus() == false)
					 {
						   TimerTask task = new SetTimer();
						   timer.schedule(task, 10000, 10000);
						   wielder.getVolatileStatus("Confusion").setActiveStatus(true);
					 }
					
					if(wielder.getVolatileStatus("Confusion").getDegree() >= 65)
					{
						double damage;
				        double numerator, denomenator;
				        numerator = ( ( 2 * wielder.getLevel() ) + 10  ); 
				        numerator = numerator * wielder.getAtk() * 40;
				        denomenator = 250 * wielder.getDef();
				        damage = (numerator / denomenator) + 2;
				        wielder.changeHP((int)damage);
				        model.addLogItem(wielder.getNickName()+" hit itself in confusion!");
					}
					else
					{
						model.addLogItem(wielder.getNickName()+" is too confused to attack!");
					}
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
					  if (model == null) model = BattleModel.getInstance();
				   Timer timer = new Timer();
				   class SetTimer extends TimerTask
				   {
					   @Override
					   public void run()
					   {
						   if(!model.getPlayerPokemon(wielder.getPlayerID()).equals(wielder.getSpeciesName()))
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
				   
				   if(wielder.getVolatileStatus("Curse").getActiveStatus() == false)
				   {
					   TimerTask task = new SetTimer();
					   timer.schedule(task, 10000, 10000);
					   wielder.getVolatileStatus("Curse").setActiveStatus(true);
					   wielder.addVolatileStatus(new StatusContainer("Curse2"));
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
					  if (model == null) model = BattleModel.getInstance();
				    model.addLogItem(wielder.getSpeciesName()+" is prevented from healing!");
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
					  if (model == null) model = BattleModel.getInstance();
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
				   
				   if(wielder.getVolatileStatus("Heal Block").getActiveStatus() == false)
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
					  if (model == null) model = BattleModel.getInstance();
				    model.addLogItem(wielder.getSpeciesName()+" is prevented from healing!");
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
					  if (model == null) model = BattleModel.getInstance();
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
					  if (model == null) model = BattleModel.getInstance();
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
					Move move = wielder.getVolatileStatus("Encore").getForcedMove();
					
					if(Event.itemPrimaryEffectEvent(wielder, EventType.PRE_ATTACK, move))
					{
						//run method automatically executed
					}
					else if(Event.itemSecondaryEffectEvent(wielder, EventType.PRE_ATTACK, move))
					{
						//run method automatically executed
					}
					else if(Event.statusVolatileEvent(defender, EventType.PRE_ATTACK, move))
					{
						//run method automatically executed
					}
					//check for ability event of the wielder
					else if(Event.abilityEvent(EventType.PRE_ATTACK, wielder, defender, model.getField(), wielder, defender, move))
					{
						//run method automatically executed
					}
					//check for move event of the wielder
					else if(Event.movePrimaryEffectEvent(wielder, EventType.PRE_ATTACK, move))
					{
						//run method automatically executed
						Event.moveSecondaryEffectEvent(wielder, EventType.PRE_ATTACK, move);
					}
					else
					{
						if(move.getCategory() == Attribute.STATUS)
						{
							if(Event.statusVolatileEvent(defender, EventType.PRE_STATUS_CHANGE, move))
							{
								  //run method automatic
							}
							else
							{
								Event.abilityEvent(EventType.PRE_DAMAGE, defender, wielder, model.getField(), wielder, defender, move);
								Event.movePrimaryEffectEvent(wielder, EventType.POST_ATTACK, move);
								Event.itemPrimaryEffectEvent(defender, EventType.POST_STATUS_CHANGE, move);
								Event.itemSecondaryEffectEvent(defender, EventType.POST_STATUS_CHANGE, move);
								Event.statusVolatileEvent(wielder, EventType.POST_STATUS_CHANGE, move);
								Event.statusVolatileEvent(defender, EventType.POST_STATUS_CHANGE, move);
								Event.statusNonVolatileEvent(defender, EventType.POST_STATUS_CHANGE, move);
							}
						}
						else
						{
							int damage = Formula.calcDamage(wielder, defender, move, model.getField());
							damage = defender.changeHP(damage);
							//check for ability even of the defender
							Event.abilityEvent(EventType.HP_CHANGE, defender, wielder, model.getField(), wielder, defender, move);
							Event.itemPrimaryEffectEvent(defender, EventType.HP_CHANGE, move);
							Event.itemSecondaryEffectEvent(defender, EventType.HP_CHANGE, move);
							//check for ability event of the defender
							Event.statusVolatileEvent(wielder, EventType.POST_ATTACK, move);
							//Event.statusVolatileEvent(defender, EventType.POST_ATTACK, move);
							Event.abilityEvent(EventType.POST_ATTACK, defender, wielder, model.getField(), wielder, defender, move);
							move.getMoveEffectContainer().updateMoveEffectContainer(wielder, damage);
							Event.movePrimaryEffectEvent(wielder, EventType.POST_ATTACK, move);
							Event.moveSecondaryEffectEvent(wielder, EventType.POST_ATTACK, move);
							Event.itemPrimaryEffectEvent(wielder, EventType.POST_ATTACK, move);
							Event.itemSecondaryEffectEvent(wielder, EventType.POST_ATTACK, move);
							Event.itemPrimaryEffectEvent(defender, EventType.POST_ATTACK, move);
							Event.itemSecondaryEffectEvent(defender, EventType.POST_ATTACK, move);
						}
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
					  if (model == null) model = BattleModel.getInstance();
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
						+ "if the protected Pokémon is hit by Feint or Shadow Force, which can both hit through protection, "
						+ "the Pokémon's protection is removed for the rest of the turn.";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				public double run (IPokemon wielder,  Move moveUsed)
				{
					  if (model == null) model = BattleModel.getInstance();
				    if(moveUsed.getName().equals("Feint") || moveUsed.getName().equals("Shadow Force"))
				    {
				    	IPokemon attacker = model.getOpponentPokemon(wielder.getPlayerID());
				    	//check for ability event of the attacker
						if(Event.abilityEvent(EventType.PRE_ATTACK, attacker, wielder, model.getField(), attacker, wielder, moveUsed))
						{
							//run method automatically executed
						}
						//check for move event of the attacker
						else if(Event.movePrimaryEffectEvent(attacker, EventType.PRE_ATTACK, moveUsed))
						{
							//run method automatically executed
							Event.moveSecondaryEffectEvent(attacker, EventType.PRE_ATTACK, moveUsed);
						}
						else
						{
							if(moveUsed.getCategory() == Attribute.STATUS)
							{
								if(Event.statusVolatileEvent(wielder, EventType.PRE_STATUS_CHANGE, moveUsed))
								{
									  //run method automatic
								}
								else
								{
									Event.abilityEvent(EventType.PRE_DAMAGE, wielder, attacker, model.getField(), attacker, wielder, moveUsed);
									Event.movePrimaryEffectEvent(attacker, EventType.POST_ATTACK, moveUsed);
									Event.itemPrimaryEffectEvent(wielder, EventType.POST_STATUS_CHANGE, moveUsed);
									Event.itemSecondaryEffectEvent(wielder, EventType.POST_STATUS_CHANGE, moveUsed);
									Event.statusVolatileEvent(attacker, EventType.POST_STATUS_CHANGE, moveUsed);
									Event.statusVolatileEvent(wielder, EventType.POST_STATUS_CHANGE, moveUsed);
									Event.statusNonVolatileEvent(wielder, EventType.POST_STATUS_CHANGE, moveUsed);
								}
							}
							else
							{
								int damage = Formula.calcDamage(attacker, wielder, moveUsed, model.getField());
								damage = wielder.changeHP(damage);
								//check for ability even of the wielder
								Event.abilityEvent(EventType.HP_CHANGE, wielder, attacker, model.getField(), attacker, wielder, moveUsed);
								Event.itemPrimaryEffectEvent(wielder, EventType.HP_CHANGE, moveUsed);
								Event.itemSecondaryEffectEvent(wielder, EventType.HP_CHANGE, moveUsed);
								//check for ability event of the defender
								Event.statusVolatileEvent(attacker, EventType.POST_ATTACK, moveUsed);
								//Event.statusVolatileEvent(defender, EventType.POST_ATTACK, moveUsed);
								Event.abilityEvent(EventType.POST_ATTACK, wielder, attacker, model.getField(), attacker, wielder, moveUsed);
								moveUsed.getMoveEffectContainer().updateMoveEffectContainer(attacker, damage);
								Event.movePrimaryEffectEvent(attacker, EventType.POST_ATTACK, moveUsed);
								Event.moveSecondaryEffectEvent(attacker, EventType.POST_ATTACK, moveUsed);
								Event.itemPrimaryEffectEvent(attacker, EventType.POST_ATTACK, moveUsed);
								Event.itemSecondaryEffectEvent(attacker, EventType.POST_ATTACK, moveUsed);
								Event.itemPrimaryEffectEvent(wielder, EventType.POST_ATTACK, moveUsed);
								Event.itemSecondaryEffectEvent(wielder, EventType.POST_ATTACK, moveUsed);
							}
						}
				    }
				    else if(moveUsed.getName().equals("Hyperspace Fury"))
				    {
				    	IPokemon attacker = model.getOpponentPokemon(wielder.getPlayerID());
				    	//check for ability event of the attacker
						if(Event.abilityEvent(EventType.PRE_ATTACK, attacker, wielder, model.getField(), attacker, wielder, moveUsed))
						{
							//run method automatically executed
						}
						//check for move event of the attacker
						else if(Event.movePrimaryEffectEvent(attacker, EventType.PRE_ATTACK, moveUsed))
						{
							//run method automatically executed
							Event.moveSecondaryEffectEvent(attacker, EventType.PRE_ATTACK, moveUsed);
						}
						else
						{
							if(moveUsed.getCategory() == Attribute.STATUS)
							{
								if(Event.statusVolatileEvent(wielder, EventType.PRE_STATUS_CHANGE, moveUsed))
								{
									  //run method automatic
								}
								else
								{
									Event.abilityEvent(EventType.PRE_DAMAGE, wielder, attacker, model.getField(), attacker, wielder, moveUsed);
									Event.movePrimaryEffectEvent(attacker, EventType.POST_ATTACK, moveUsed);
									Event.itemPrimaryEffectEvent(wielder, EventType.POST_STATUS_CHANGE, moveUsed);
									Event.itemSecondaryEffectEvent(wielder, EventType.POST_STATUS_CHANGE, moveUsed);
									Event.statusVolatileEvent(attacker, EventType.POST_STATUS_CHANGE, moveUsed);
									Event.statusVolatileEvent(wielder, EventType.POST_STATUS_CHANGE, moveUsed);
									Event.statusNonVolatileEvent(wielder, EventType.POST_STATUS_CHANGE, moveUsed);
								}
							}
							else
							{
								int damage = Formula.calcDamage(attacker, wielder, moveUsed, model.getField());
								damage = wielder.changeHP(damage);
								//check for ability even of the defender
								Event.abilityEvent(EventType.HP_CHANGE, wielder, attacker, model.getField(), attacker, wielder, moveUsed);
								Event.itemPrimaryEffectEvent(wielder, EventType.HP_CHANGE, moveUsed);
								Event.itemSecondaryEffectEvent(wielder, EventType.HP_CHANGE, moveUsed);
								Event.itemPrimaryEffectEvent(wielder, EventType.HP_CHANGE, moveUsed);
								Event.itemSecondaryEffectEvent(wielder, EventType.HP_CHANGE, moveUsed);
								//check for ability event of the defender
								Event.statusVolatileEvent(attacker, EventType.POST_ATTACK, moveUsed);
								//Event.statusVolatileEvent(defender, EventType.POST_ATTACK, move);
								Event.abilityEvent(EventType.POST_ATTACK, wielder, attacker, model.getField(), attacker, wielder, moveUsed);
								moveUsed.getMoveEffectContainer().updateMoveEffectContainer(attacker, damage);
								Event.movePrimaryEffectEvent(attacker, EventType.POST_ATTACK, moveUsed);
								Event.moveSecondaryEffectEvent(attacker, EventType.POST_ATTACK, moveUsed);
								Event.itemPrimaryEffectEvent(attacker, EventType.POST_ATTACK, moveUsed);
								Event.itemSecondaryEffectEvent(attacker, EventType.POST_ATTACK, moveUsed);
								Event.itemPrimaryEffectEvent(wielder, EventType.POST_ATTACK, moveUsed);
								Event.itemSecondaryEffectEvent(wielder, EventType.POST_ATTACK, moveUsed);
							}
						}
				    }
				    else
				    {
				    	model.addLogItem(wielder.getSpeciesName()+" protected itself!");
				    }
					return 1;
				}
		});
		
		statusMap.put("Burn", new IStatus()
		{
				EventType trigger = EventType.POST_STATUS_CHANGE;
				String name = "Burn";
				String description = "The burn condition halves damage dealt by a Pokémon's physical moves (except for Pokémon with the Guts Ability, "
						+ "where this condition raises Attack by 50%). "
						+ "Additionally, at the end of a turn, the Pokémon loses 1/8 its maximum hit points.";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				
				public double run (IPokemon wielder,  Move moveUsed)
				{
					  if (model == null) model = BattleModel.getInstance();
				   Timer timer = new Timer();
				   class SetTimer extends TimerTask
				   {
					   @Override
					   public void run()
					   {
						   if(!wielder.hasNonVolatileStatus("Burn"))
						   {
							   timer.cancel();
							   return;
						   }
						   
						   if(wielder.getHP() == 0)
						   {
							   timer.cancel();
							   wielder.getNonVolatileStatusContainer().setActiveStatus(false);
							   return;
						   }
						   
						   if(!model.getPlayerPokemonSpeciesName(wielder.getPlayerID()).equals(wielder.getSpeciesName()))
						   {
							   wielder.getNonVolatileStatusContainer().addToDegree(-10, false);
							   if(wielder.getNonVolatileStatusContainer().getDegree() == 0)
							   {
								   timer.cancel();
								   wielder.setNonVolatileStatus(new StatusContainer("Healthy"));
								   wielder.setMaxAtk(wielder.getNonVolatileStatusContainer().getOriginalStat());
							   }
							   return;
						   }
						   
						   wielder.changeHP((int)(((double)(wielder.getMaxHP()/8)) * ((double)wielder.getNonVolatileStatusContainer().getDegree()/100)) );
						   model.addLogItem(wielder.getNickName()+" is hurt by its burn!");
						   
						   wielder.getNonVolatileStatusContainer().addToDegree(-10, false);
						   if(wielder.getNonVolatileStatusContainer().getDegree() == 0)
						   {
							   timer.cancel();
							   wielder.setNonVolatileStatus(new StatusContainer("Healthy"));
							   wielder.setMaxAtk(wielder.getNonVolatileStatusContainer().getOriginalStat());
							   model.addLogItem(wielder.getNickName()+" is burnt no more!");
							   return;
						   }
						   
						   model.addLogItem(wielder.getNickName()+"'s burn healed a little!");
						   wielder.setMaxAtk((int)( (double)wielder.getNonVolatileStatusContainer().getOriginalStat() 
								   - (((double)wielder.getNonVolatileStatusContainer().getOriginalStat())/2) 
								   * ((double)wielder.getNonVolatileStatusContainer().getDegree()/100)) );
						   return;
					   }
				   }
				   
				   if(wielder.getNonVolatileStatusContainer().getActiveStatus() == false)
				   {
					   TimerTask task = new SetTimer();
				   	   timer.schedule(task, 10000, 10000);
				   	   wielder.getNonVolatileStatusContainer().setActiveStatus(true);
				   	   wielder.getNonVolatileStatusContainer().setOriginalStat(wielder.getMaxAtk());
				   	   wielder.setMaxAtk((int)( (double)wielder.getNonVolatileStatusContainer().getOriginalStat() 
							   - (((double)wielder.getNonVolatileStatusContainer().getOriginalStat())/2) 
							   * ((double)wielder.getNonVolatileStatusContainer().getDegree()/100)) );
				   }
					   
				   return 1;
				}
		});
		
		statusMap.put("Paralysis", new IStatus()
		{
				EventType trigger = EventType.POST_STATUS_CHANGE;
				String name = "Paralysis";
				String description = "The paralysis condition causes a Pokémon to be unable to attack if 100% paralyzed. "
						+ "Additionally, its Speed is reduced to 25% of its previous value (except for Pokémon with the "
						+ "Quick Feet Ability, where this condition raises the Speed by 50%).";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				
				public double run (IPokemon wielder,  Move moveUsed)
				{
					  if (model == null) model = BattleModel.getInstance();
				   Timer timer = new Timer();
				   class SetTimer extends TimerTask
				   {
					   @Override
					   public void run()
					   {
						   if(!wielder.hasNonVolatileStatus("Paralysis"))
						   {
							   timer.cancel();
							   return;
						   }
						   
						   if(wielder.getHP() == 0)
						   {
							   timer.cancel();
							   wielder.getNonVolatileStatusContainer().setActiveStatus(false);
							   return;
						   }
						   
						   if(!model.getPlayerPokemonSpeciesName(wielder.getPlayerID()).equals(wielder.getSpeciesName()))
						   {
							   wielder.getNonVolatileStatusContainer().addToDegree(-10, false);
							   if(wielder.getNonVolatileStatusContainer().getDegree() == 0)
							   {
								   timer.cancel();
								   wielder.setNonVolatileStatus(new StatusContainer(-1,-1,"Healthy",null));
								   wielder.setMaxSpeed(wielder.getNonVolatileStatusContainer().getOriginalStat());
							   }
							   return;
						   }
						   
						   wielder.getNonVolatileStatusContainer().addToDegree(-10, false);
						   if(wielder.getNonVolatileStatusContainer().getDegree() == 0)
						   {
							   timer.cancel();
							   wielder.setNonVolatileStatus(new StatusContainer(-1,-1,"Healthy",null));
							   wielder.setMaxSpeed(wielder.getNonVolatileStatusContainer().getOriginalStat());
							   model.addLogItem(wielder.getNickName()+" is paralyzed no more!");
							   return;
						   }
						   
						   wielder.setMaxSpeed((int)( (double)wielder.getNonVolatileStatusContainer().getOriginalStat() 
								   - 3 * (((double)wielder.getNonVolatileStatusContainer().getOriginalStat())/4) 
								   * ((double)wielder.getNonVolatileStatusContainer().getDegree()/100)) );
						   model.addLogItem(wielder.getNickName()+"'s paralysis healed a little!");
						   
						   if(wielder.getNonVolatileStatusContainer().getDegree() < 80)
						   {
							   model.addLogItem(wielder.getNickName()+" is able to break through its paralysis!");
							   return;
						   }
						   else if(wielder.getNonVolatileStatusContainer().getDegree() >= 80)
						   {
							   model.addLogItem(wielder.getNickName()+" is still too paralyzed to attack!");
							   return;
						   }
						   
						   return;
					   }
				   }
				   
				   if(wielder.getNonVolatileStatusContainer().getActiveStatus() == false)
				   {
					   TimerTask task = new SetTimer();
				   	   timer.schedule(task, 10000, 10000);
				   	   wielder.getNonVolatileStatusContainer().setActiveStatus(true);
				   	   wielder.getNonVolatileStatusContainer().setOriginalStat(wielder.getMaxSpeed());
				   	   wielder.setMaxSpeed((int)( (double)wielder.getNonVolatileStatusContainer().getOriginalStat() 
				   			   - 3 * (((double)wielder.getNonVolatileStatusContainer().getOriginalStat())/4) 
				   			   * ((double)wielder.getNonVolatileStatusContainer().getDegree()/100)) );
				   }
					   
				   return 1;
				}
		});
		
		statusMap.put("Poison", new IStatus()
		{
				EventType trigger = EventType.POST_STATUS_CHANGE;
				String name = "Poison";
				String description = "The poison condition causes a Pokémon to lose 1/8 of its maximum hit points every turn."
						+ "Normally Steel- and Poison-type Pokémon and Pokémon with the Immunity Ability cannot be poisoned; "
						+ "however, if a Pokémon is poisoned then has its type changed to Steel or Poison or its "
						+ "Ability changed to Immunity, the poison will remain. A Pokémon with the Poison Heal Ability will "
						+ "gradually recover health instead when poisoned.";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				
				public double run (IPokemon wielder,  Move moveUsed)
				{
					  if (model == null) model = BattleModel.getInstance();
				   Timer timer = new Timer();
				   class SetTimer extends TimerTask
				   {
					   @Override
					   public void run()
					   {
						   if(!wielder.hasNonVolatileStatus("Poison"))
						   {
							   timer.cancel();
							   return;
						   }
						   
						   if(wielder.getHP() == 0)
						   {
							   timer.cancel();
							   wielder.getNonVolatileStatusContainer().setActiveStatus(false);
							   return;
						   }
						   
						   if(!model.getPlayerPokemonSpeciesName(wielder.getPlayerID()).equals(wielder.getSpeciesName()))
						   {
							   wielder.getNonVolatileStatusContainer().addToDegree(-10, false);
							   if(wielder.getNonVolatileStatusContainer().getDegree() == 0)
							   {
								   timer.cancel();
								   wielder.setNonVolatileStatus(new StatusContainer(-1,-1,"Healthy",null));
							   }
							   return;
						   }
						   
						   wielder.changeHP((int)(((double)(wielder.getMaxHP()/8)) * ((double)wielder.getNonVolatileStatusContainer().getDegree()/100)) );
						   model.addLogItem(wielder.getNickName()+" was hurt by poison!");
						   
						   wielder.getNonVolatileStatusContainer().addToDegree(-10, false);
						   if(wielder.getNonVolatileStatusContainer().getDegree() == 0)
						   {
							   timer.cancel();
							   wielder.setNonVolatileStatus(new StatusContainer(-1,-1,"Healthy",null));
							   model.addLogItem(wielder.getNickName()+" is no longer poisoned!");
							   return;
						   }
						   
						   model.addLogItem(wielder.getNickName()+"'s poisoning healed a little!");
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
		
		statusMap.put("Toxic Poison", new IStatus()
		{
				EventType trigger = EventType.POST_STATUS_CHANGE;
				String name = "Toxic Poison";
				String description = "The badly poison condition causes a Pokémon to lose 1/2 of its maximum hit points multiplied "
						+ "by the degree of the status (a percent) every turn."
						+ "The degree of the status increases over time.";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				
				public double run (IPokemon wielder,  Move moveUsed)
				{
					  if (model == null) model = BattleModel.getInstance();
				   Timer timer = new Timer();
				   class SetTimer extends TimerTask
				   {
					   @Override
					   public void run()
					   {
						   if(!wielder.hasNonVolatileStatus("Toxic Poison"))
						   {
							   timer.cancel();
							   return;
						   }
						   
						   if(wielder.getHP() == 0)
						   {
							   timer.cancel();
							   wielder.getNonVolatileStatusContainer().setActiveStatus(false);
							   return;
						   }
						   
						   if(!model.getPlayerPokemonSpeciesName(wielder.getPlayerID()).equals(wielder.getSpeciesName()))
						   {
							   timer.cancel();
							   wielder.getNonVolatileStatusContainer().setDegree(1);
							   wielder.getNonVolatileStatusContainer().setActiveStatus(false);
							   return;
						   }
						   
						   wielder.changeHP((int)( ((double)(wielder.getMaxHP()/2)) * ((double)wielder.getNonVolatileStatusContainer().getDegree()/100)) );
						   wielder.getNonVolatileStatusContainer().addToDegree(5, false);
						   model.addLogItem(wielder.getNickName()+" was hurt by poison!");
						   model.addLogItem(wielder.getNickName()+"'s poisoning got worse!");
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
		
		statusMap.put("Frozen", new IStatus()
		{
				EventType trigger = EventType.POST_STATUS_CHANGE;
				String name = "Frozen";
				String description = "The freeze condition causes a Pokémon to be unable to make a move. "
						+ "Damaging Fire-type moves used on a frozen Pokémon will remove the freeze status."
						+ "Ice-type Pokémon cannot be frozen by any method.";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
				
				public double run (IPokemon wielder,  Move moveUsed)
				{
					  if (model == null) model = BattleModel.getInstance();
				   Timer timer = new Timer();
				   class SetTimer extends TimerTask
				   {
					   @Override
					   public void run()
					   {						
						   if(!wielder.hasNonVolatileStatus("Frozen"))
						   {
							   timer.cancel();
							   return;
						   }
						   
						   if(!model.getPlayerPokemonSpeciesName(wielder.getPlayerID()).equals(wielder.getSpeciesName()))
						   {
							   wielder.getNonVolatileStatusContainer().addToDegree(-5,false);
							   if(wielder.getNonVolatileStatusContainer().getDegree() == 0)
							   {
								   timer.cancel();
								   wielder.setNonVolatileStatus(new StatusContainer(-1,-1,"Healthy",null));
							   }
							   return;
						   }
						   
						   wielder.getNonVolatileStatusContainer().addToDegree(-5, false);
						   model.addLogItem(wielder.getNickName()+" thawed a little!");
						   
						   if(wielder.getNonVolatileStatusContainer().getDegree() == 0)
						   {
							   timer.cancel();
							   wielder.setNonVolatileStatus(new StatusContainer(-1,-1,"Healthy",null));
							   model.addLogItem(wielder.getNickName()+" is completely thawed!");
							   return;
						   }
						   else if(wielder.getNonVolatileStatusContainer().getDegree() < 50)
						   {
							   model.addLogItem(wielder.getNickName()+" is thawed enough to attack!");
							   return;
						   }
						   else if(wielder.getNonVolatileStatusContainer().getDegree() >= 50)
						   {
							   model.addLogItem(wielder.getNickName()+" is too frozen to attack!");
							   return;
						   }
						   return;
					   }
				   }
				   
				   if(wielder.getNonVolatileStatusContainer().getActiveStatus() == false)
				   {
					   TimerTask task = new SetTimer();
				   	   timer.schedule(task, 10000, 10000);
				   	   wielder.getNonVolatileStatusContainer().setActiveStatus(true);
				   	   model.addLogItem(wielder.getNickName()+" is frozen!");
				   }

				   return 1;
					   
				}
		});
		
		statusMap.put("Taunt", new IStatus()
		{
				EventType trigger = EventType.PRE_ATTACK;
				String name = "Taunt";
				String description = "Forces the Pokémon to repeat its last attack for 3 turns.";
				public EventType getEventTrigger(){return trigger;}
				public String getName(){return name;}					
				public String getDescription(){return description;}
					
				public double run (IPokemon wielder,  Move moveUsed)
				{
					  if (model == null) model = BattleModel.getInstance();
					Timer timer = new Timer();
					class SetTimer extends TimerTask
					{
					   @Override
					   public void run()
					   {
						   timer.cancel();
						   wielder.removeVolatileStatus("Taunt");
						   model.addLogItem(wielder.getNickName()+" Taunt ended!");
						   return;
					   }
			     	}
					
					if(wielder.getVolatileStatus("Taunt").getActiveStatus() == false)
					{
						TimerTask task = new SetTimer();
						timer.schedule(task,30000); //3 turns
						wielder.getVolatileStatus("Taunt").setActiveStatus(true);
					}

					IPokemon defender = model.getOpponentPokemon(wielder.getPlayerID());
					
					if(Event.itemPrimaryEffectEvent(wielder, EventType.PRE_ATTACK, moveUsed))
					{
						//run method automatically executed
					}
					else if(Event.itemSecondaryEffectEvent(wielder, EventType.PRE_ATTACK, moveUsed))
					{
						//run method automatically executed
					}
					else if(Event.statusVolatileEvent(defender, EventType.PRE_ATTACK, moveUsed))
					{
						//run method automatically executed
					}
					//check for ability event of the wielder
					else if(Event.abilityEvent(EventType.PRE_ATTACK, wielder, defender, model.getField(), wielder, defender, moveUsed))
					{
						//run method automatically executed
					}
					//check for move event of the wielder
					else if(Event.movePrimaryEffectEvent(wielder, EventType.PRE_ATTACK, moveUsed))
					{
						//run method automatically executed
						Event.moveSecondaryEffectEvent(wielder, EventType.PRE_ATTACK, moveUsed);
					}
					else
					{
						if(moveUsed.getCategory() == Attribute.STATUS)
						{
							model.addLogItem(wielder.getNickName()+" can't use "+moveUsed.getName()+" after the taunt!");
						}
						else
						{
							int damage = Formula.calcDamage(wielder, defender, moveUsed, model.getField());
							damage = defender.changeHP(damage);
							//check for ability even of the defender
							Event.abilityEvent(EventType.HP_CHANGE, defender, wielder, model.getField(), wielder, defender, moveUsed);
							Event.itemPrimaryEffectEvent(defender, EventType.HP_CHANGE, moveUsed);
							Event.itemSecondaryEffectEvent(defender, EventType.HP_CHANGE, moveUsed);
							//check for ability event of the defender
							Event.statusVolatileEvent(wielder, EventType.POST_ATTACK, moveUsed);
							//Event.statusVolatileEvent(defender, EventType.POST_ATTACK, move);
							Event.abilityEvent(EventType.POST_ATTACK, defender, wielder, model.getField(), wielder, defender, moveUsed);
							moveUsed.getMoveEffectContainer().updateMoveEffectContainer(wielder, damage);
							Event.movePrimaryEffectEvent(wielder, EventType.POST_ATTACK, moveUsed);
							Event.moveSecondaryEffectEvent(wielder, EventType.POST_ATTACK, moveUsed);
							Event.itemPrimaryEffectEvent(wielder, EventType.POST_ATTACK, moveUsed);
							Event.itemSecondaryEffectEvent(wielder, EventType.POST_ATTACK, moveUsed);
							Event.itemPrimaryEffectEvent(defender, EventType.POST_ATTACK, moveUsed);
							Event.itemSecondaryEffectEvent(defender, EventType.POST_ATTACK, moveUsed);
						}
					}

					return 1;
				}
		});
	}
}
