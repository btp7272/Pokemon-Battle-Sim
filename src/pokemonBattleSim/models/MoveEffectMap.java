package pokemonBattleSim.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import pokemonBattleSim.formulas.Formula;
import pokemonBattleSim.models.AbilityMap.Stat;
import pokemonBattleSim.online.Send;
import pokemonBattleSim.types.Event;
import pokemonBattleSim.types.EventType;
import pokemonBattleSim.types.IAbility;
import pokemonBattleSim.types.IField;
import pokemonBattleSim.types.IMoveEffect;
import pokemonBattleSim.types.IPokemon;
import pokemonBattleSim.types.Move;
import pokemonBattleSim.types.StatusContainer;
import pokemonBattleSim.types.Type;

public class MoveEffectMap 
{
	public static Map < String, IMoveEffect > effectMap = new HashMap<>();
	private static IBattleModel model = BattleModel.getInstance();
	public static int sereneGraceMultiplier = 1;
	
	
	static
	{
		effectMap.put("Giga Drain", new IMoveEffect()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Giga Drain";
			   String description = "Leeches 50% of the damage dealt.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon attacker, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				  if(Event.statusVolatileEvent(attacker, EventType.HEAL, moveUsed))
				  {
					  //runPrimaryEffectevent automatic
					  return 0;
				  }
				  if(Event.abilityEvent(EventType.HEAL, attacker, null, null, null, null, null))
				  {
					  return 1;
				  }
				  attacker.changeHP(- moveUsed.getMoveEffectContainer().getDamageDelt() / 2);
				  return 1;
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		effectMap.put("Flamethrower", new IMoveEffect()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Flamethrower";
			   String description = "10% chance to burn the target.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				  if(Event.statusVolatileEvent(attacker, EventType.PRE_STATUS_CHANGE, moveUsed))
				  {
					  //runPrimaryEffectevent automatic
					  return 0;
				  }
				  
				  IPokemon opponent = model.getOpponentPokemon(attacker.getPlayerID());
				  
				  if(!opponent.hasNonVolatileStatus() && !opponent.isType(Type.FIRE))
				  {
					  opponent.setNonVolatileStatus(new StatusContainer(opponent.getMaxAtk(),10 * sereneGraceMultiplier,"Burn",null));
					  Event.statusNonVolatileEvent(opponent, EventType.POST_STATUS_CHANGE, moveUsed);
					  model.addLogItem(opponent.getNickName()+" was burnt with a degree of "+ 10 * sereneGraceMultiplier +"!");
				  }
				  else if(opponent.hasNonVolatileStatus("Burn"))
				  {
					  opponent.getNonVolatileStatusContainer().addToDegree(10 * sereneGraceMultiplier, false);
					  model.addLogItem(opponent.getNickName()+" was burnt more !");
				  }
				  
				  return 1;
			   }
		});
		
		effectMap.put("Scald", new IMoveEffect()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Scald";
			   String description = "30% chance to burn the target.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				  if(Event.statusVolatileEvent(attacker, EventType.PRE_STATUS_CHANGE, moveUsed))
				  {
					  //run method automatic
					  return 0;
				  }

				  if (model == null) model = BattleModel.getInstance();
				  IPokemon opponent = model.getOpponentPokemon(attacker.getPlayerID());

				  if(!opponent.hasNonVolatileStatus() && !opponent.isType(Type.FIRE))
				  {
					  opponent.setNonVolatileStatus(new StatusContainer(opponent.getMaxAtk(),30 * sereneGraceMultiplier,"Burn",null));
					  Event.statusNonVolatileEvent(opponent, EventType.POST_STATUS_CHANGE, moveUsed);
					  model.addLogItem(opponent.getNickName()+" was burnt with a degree of "+ 30 * sereneGraceMultiplier +"!");
				  }
				  else if(opponent.hasNonVolatileStatus("Burn"))
				  {
					  opponent.getNonVolatileStatusContainer().addToDegree(30 * sereneGraceMultiplier, false);
					  model.addLogItem(opponent.getNickName()+" was burnt more !");
				  }
				  
				  return 1;
			   }
		});
		
		effectMap.put("Roost", new IMoveEffect()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Roost";
			   String description = "Heals 50% of the user's max HP. "
			   		+ "Temporarily removes the user's Flying type and turns it into a Normal-type if it is a pure Flying-type.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon attacker, Move moveUsed)
			   {  
					  if (model == null) model = BattleModel.getInstance();
				  Timer timer = new Timer();
				  class SetTimer extends TimerTask
				  {
					  @Override
					  public void run()
					  {
						  timer.cancel();
						  moveUsed.getMoveEffectContainer().restoreOriginalTyping(attacker);
						  return;
					  }
				  }
				  
				  if(Event.statusVolatileEvent(attacker, EventType.HEAL, moveUsed))
				  {
					  //runPrimaryEffectevent automatic
					  return 0;
				  }
				  attacker.changeHP(- attacker.getMaxHP() / 2);
				  
				  moveUsed.getMoveEffectContainer().setOriginalTyping(attacker.getType1(), attacker.getType2());
				  
				  if(attacker.getType1() == Type.FLYING && attacker.getType2() == null)
				  {
					  attacker.setType(Type.NORMAL, 1);
				  }
				  
				  else if(attacker.getType1() == Type.FLYING)
				  {
					  attacker.setType(null, 1);
				  }
				  
				  else if(attacker.getType2() == Type.FLYING)
				  {
					  attacker.setType(null, 2);
				  }
					  
				  TimerTask task = new SetTimer();
				  timer.schedule(task, 0, 10000);
				  return 1;
					  
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		effectMap.put("Recover", new IMoveEffect()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Recover";
			   String description = "Heals 50% of the user's max HP.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon attacker, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				  if(Event.statusVolatileEvent(attacker, EventType.HEAL, moveUsed))
				  {
					  //runPrimaryEffectevent automatic
					  return 0;
				  }
				  attacker.changeHP(- attacker.getMaxHP() / 2);
				  return 1;
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		effectMap.put("Bullet Seed", new IMoveEffect()
		{
			   EventType trigger = EventType.PRE_ATTACK;
			   String name = "Bullet Seed";
			   String description = "Hits two to five times.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon attacker, Move moveUsed)
			   { 

					  if (model == null) model = BattleModel.getInstance();
				   	IPokemon defender = model.getOpponentPokemon(attacker.getPlayerID());
				   	Random gen = new Random();
				   	int timesExecuted = gen.nextInt(5 - 2) + 2;
				   	
				   	for(int i = 0; i < timesExecuted; i++)
				   	{
							int damage = Formula.calcDamage(attacker, defender, moveUsed, model.getField());
							damage = defender.changeHP(damage);
							Event.abilityEvent(EventType.HP_CHANGE, defender, attacker, model.getField(), attacker, defender, moveUsed);Event.itemPrimaryEffectEvent(defender, EventType.HP_CHANGE, moveUsed);
							Event.itemSecondaryEffectEvent(defender, EventType.HP_CHANGE, moveUsed);
							Event.statusVolatileEvent(attacker, EventType.POST_ATTACK, moveUsed);
							Event.abilityEvent(EventType.POST_ATTACK, defender, attacker, model.getField(), attacker, defender, moveUsed);
							moveUsed.getMoveEffectContainer().updateMoveEffectContainer(attacker, damage);
							Event.movePrimaryEffectEvent(attacker, EventType.POST_ATTACK, moveUsed);
							Event.moveSecondaryEffectEvent(attacker, EventType.POST_ATTACK, moveUsed);
				   	}
				   	model.addLogItem("It hit "+timesExecuted+" times!");
				  return 1;
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		effectMap.put("Thunder Wave", new IMoveEffect()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Thunder Wave";
			   String description = "Paralyzes the target.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon attacker, Move moveUsed)
			   { 

					  if (model == null) model = BattleModel.getInstance();
					  IPokemon opponent = model.getOpponentPokemon(attacker.getPlayerID());
					  
					  if(!(opponent.hasNonVolatileStatus()) && !(opponent.isType(Type.ELECTRIC)))
					  {
						  opponent.setNonVolatileStatus(new StatusContainer(opponent.getMaxSpeed(),100,"Paralysis",null));
						  model.addLogItem(opponent.getNickName()+" was paralyzed fully!");
					  }
					  else if(opponent.hasNonVolatileStatus("Paralysis"))
					  {
						  opponent.getNonVolatileStatusContainer().addToDegree(100, false);
						  model.addLogItem(opponent.getNickName()+" was paralyzed fully again!");
					  }
					  else
					  {
						  model.addLogItem("The move failed!");
					  }
					  
				  return 1;
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		effectMap.put("Will-O-Wisp", new IMoveEffect()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Will-O-Wisp";
			   String description = "Burns the target.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon attacker, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
					  IPokemon opponent = model.getOpponentPokemon(attacker.getPlayerID());

					  if(!(opponent.hasNonVolatileStatus()) && !(opponent.isType(Type.FIRE)))
					  {
						  opponent.setNonVolatileStatus(new StatusContainer(opponent.getMaxAtk(),100,"Burn",null));
						  model.addLogItem(opponent.getNickName()+" was burnt fully!");
					  }
					  else if(opponent.hasNonVolatileStatus("Burn"))
					  {
						  opponent.getNonVolatileStatusContainer().addToDegree(100, false);
						  model.addLogItem(opponent.getNickName()+" was burnt fully again!");
					  }
					  else
					  {
						  model.addLogItem("The move failed!");
					  }
					  
				  return 1;
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		effectMap.put("Toxic", new IMoveEffect()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Toxic";
			   String description = "Badly Poisons the target.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon attacker, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
					  IPokemon opponent = model.getOpponentPokemon(attacker.getPlayerID());

					  if(!(opponent.hasNonVolatileStatus()) && !(opponent.isType(Type.POISON)))
					  {
						  opponent.setNonVolatileStatus(new StatusContainer(-1,1,"Toxic Poison",null));
						  model.addLogItem(opponent.getNickName()+" was badly poisoned!");
					  }
					  else if(opponent.hasNonVolatileStatus("Toxic Poison"))
					  {
						  opponent.getNonVolatileStatusContainer().addToDegree(10, false);
						  model.addLogItem(opponent.getNickName()+" was poisoned even more!");
					  }
					  else
					  {
						  model.addLogItem("The move failed!");
					  }
					  
				  return 1;
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		effectMap.put("Draco Meteor", new IMoveEffect()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Draco Meteor";
			   String description = "Lowers the user's Special Attack by two stages.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon attacker, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()] = -2;
				   
				   if(Event.abilityEvent(EventType.STATISTIC_CHANGE,attacker,null,null,null,null,null))
				   {
					   AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()] = 0;
					   return 1;
				   }
				   else
				   {
					   attacker.changeSpAtk(AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()]);
					   if (model == null) model = BattleModel.getInstance(); model.addLogItem(Formula.printSpAtkChange(AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()],attacker));
					   AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()] = 0;
					   return 1;
				   }
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		effectMap.put("Leaf Storm", new IMoveEffect()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Leaf Storm";
			   String description = "Lowers the user's Special Attack by two stages.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon attacker, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()] = -2;
				   
				   if(Event.abilityEvent(EventType.STATISTIC_CHANGE,attacker,null,null,null,null,null))
				   {
					   AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()] = 0;
					   return 1;
				   }
				   else
				   {
					   attacker.changeSpAtk(AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()]);
					   if (model == null) model = BattleModel.getInstance(); model.addLogItem(Formula.printSpAtkChange(AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()],attacker));
					   AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()] = 0;
					   return 1;
				   }
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		effectMap.put("Dragon Dance", new IMoveEffect()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Dragon Dance";
			   String description = "Boosts the user's Attack and Speed by one stage each.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon attacker, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   AbilityMap.statChangeQueue[Stat.ATTACK.getMask()] = 1;
				   AbilityMap.statChangeQueue[Stat.SPEED.getMask()] = 1;
				   
				   if(Event.abilityEvent(EventType.STATISTIC_CHANGE,attacker,null,null,null,null,null))
				   {
					   AbilityMap.statChangeQueue[Stat.ATTACK.getMask()] = 0;
					   AbilityMap.statChangeQueue[Stat.SPEED.getMask()] = 0;
					   return 1;
				   }
				   else
				   {
					   attacker.changeAtk(AbilityMap.statChangeQueue[Stat.ATTACK.getMask()]);
					   attacker.changeSpeed(AbilityMap.statChangeQueue[Stat.SPEED.getMask()]);
					   if (model == null) model = BattleModel.getInstance(); model.addLogItem(Formula.printAtkChange(AbilityMap.statChangeQueue[Stat.ATTACK.getMask()],attacker));
					   if (model == null) model = BattleModel.getInstance(); model.addLogItem(Formula.printSpeedChange(AbilityMap.statChangeQueue[Stat.SPEED.getMask()],attacker));
					   AbilityMap.statChangeQueue[Stat.ATTACK.getMask()] = 0;
					   AbilityMap.statChangeQueue[Stat.SPEED.getMask()] = 0;
					   return 1;
				   }
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		effectMap.put("Swords Dance", new IMoveEffect()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Swords Dance";
			   String description = "Boosts the user's Attack by two stages.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon attacker, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   AbilityMap.statChangeQueue[Stat.ATTACK.getMask()] = 2;
				   
				   if(Event.abilityEvent(EventType.STATISTIC_CHANGE,attacker,null,null,null,null,null))
				   {
					   AbilityMap.statChangeQueue[Stat.ATTACK.getMask()] = 0;
					   return 1;
				   }
				   else
				   {
					   attacker.changeAtk(AbilityMap.statChangeQueue[Stat.ATTACK.getMask()]);
					   if (model == null) model = BattleModel.getInstance(); model.addLogItem(Formula.printAtkChange(AbilityMap.statChangeQueue[Stat.ATTACK.getMask()],attacker));
					   AbilityMap.statChangeQueue[Stat.ATTACK.getMask()] = 0;
					   return 1;
				   }
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		effectMap.put("Calm Mind", new IMoveEffect()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Calm Mind";
			   String description = "Boosts the user's Special Attack and Special Defense by one stage each.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon attacker, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()] = 1;
				   AbilityMap.statChangeQueue[Stat.SPECIAL_DEFENSE.getMask()] = 1;
				   
				   if(Event.abilityEvent(EventType.STATISTIC_CHANGE,attacker,null,null,null,null,null))
				   {
					   AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()] = 0;
					   AbilityMap.statChangeQueue[Stat.SPECIAL_DEFENSE.getMask()] = 0;
					   return 1;
				   }
				   else
				   {
					   attacker.changeSpAtk(AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()]);
					   attacker.changeSpDef(AbilityMap.statChangeQueue[Stat.SPECIAL_DEFENSE.getMask()]);
					   if (model == null) model = BattleModel.getInstance(); model.addLogItem(Formula.printSpAtkChange(AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()],attacker));
					   if (model == null) model = BattleModel.getInstance(); model.addLogItem(Formula.printSpDefChange(AbilityMap.statChangeQueue[Stat.SPECIAL_DEFENSE.getMask()],attacker));
					   AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()] = 0;
					   AbilityMap.statChangeQueue[Stat.SPECIAL_DEFENSE.getMask()] = 0;
					   return 1;
				   }
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		effectMap.put("Tail Glow", new IMoveEffect()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Tail Glow";
			   String description = "Boosts the user's Special Attack by three stages.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon attacker, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()] = 3;
				   
				   if(Event.abilityEvent(EventType.STATISTIC_CHANGE,attacker,null,null,null,null,null))
				   {
					   AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()] = 0;
					   return 1;
				   }
				   else
				   {
					   attacker.changeSpAtk(AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()]);
					   if (model == null) model = BattleModel.getInstance(); model.addLogItem(Formula.printSpAtkChange(AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()],attacker));
					   AbilityMap.statChangeQueue[Stat.SPECIAL_ATTACK.getMask()] = 0;
					   return 1;
				   }
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		effectMap.put("Belly Drum", new IMoveEffect()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Belly Drum";
			   String description = "Boosts the user's Special Attack by three stages.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon attacker, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(attacker.getAtkModifier() == 6 || attacker.getHP() <= attacker.getMaxHP() / 2)
				   {
					   model.addLogItem("But it failed!");
					   return 1;
				   }
				   
				   attacker.changeHP(attacker.getHP() / 2);
				   AbilityMap.statChangeQueue[Stat.ATTACK.getMask()] = 12;
				   
				   if(Event.abilityEvent(EventType.STATISTIC_CHANGE,attacker,null,null,null,null,null))
				   {
					   AbilityMap.statChangeQueue[Stat.ATTACK.getMask()] = 0;
					   return 1;
				   }
				   else
				   {
					   attacker.changeAtk(AbilityMap.statChangeQueue[Stat.ATTACK.getMask()]);
					   if (model == null) model = BattleModel.getInstance(); model.addLogItem(Formula.printAtkChange(AbilityMap.statChangeQueue[Stat.ATTACK.getMask()],attacker));
					   AbilityMap.statChangeQueue[Stat.ATTACK.getMask()] = 0;
					   return 1;
				   }
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		effectMap.put("Curse", new IMoveEffect()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Tail Glow";
			   String description = "Does 1/4 of max HP damage per turn at the cost of half the user's max HP if the user is a Ghost-type. "
			   		+ "Boosts the user's Attack and Defense and lowers Speed by one stage each otherwise.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon attacker, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(! (attacker.isType(Type.GHOST)) )
				   {
					   
					   AbilityMap.statChangeQueue[Stat.ATTACK.getMask()] = 1;
					   AbilityMap.statChangeQueue[Stat.DEFENSE.getMask()] = 1;
					   AbilityMap.statChangeQueue[Stat.SPEED.getMask()] = -1;
					   
					   if(Event.abilityEvent(EventType.STATISTIC_CHANGE,attacker,null,null,null,null,null))
					   {
						   AbilityMap.statChangeQueue[Stat.ATTACK.getMask()] = 0;
						   AbilityMap.statChangeQueue[Stat.DEFENSE.getMask()] = 0;
						   AbilityMap.statChangeQueue[Stat.SPEED.getMask()] = 0;
						   return 1;
					   }
					   else
					   {
						   attacker.changeAtk(AbilityMap.statChangeQueue[Stat.ATTACK.getMask()]);
						   attacker.changeDef(AbilityMap.statChangeQueue[Stat.DEFENSE.getMask()]);
						   attacker.changeSpeed(AbilityMap.statChangeQueue[Stat.SPEED.getMask()]);
						   if (model == null) model = BattleModel.getInstance(); model.addLogItem(Formula.printAtkChange(AbilityMap.statChangeQueue[Stat.ATTACK.getMask()],attacker));
						   if (model == null) model = BattleModel.getInstance(); model.addLogItem(Formula.printDefChange(AbilityMap.statChangeQueue[Stat.DEFENSE.getMask()],attacker));
						   if (model == null) model = BattleModel.getInstance(); model.addLogItem(Formula.printSpeedChange(AbilityMap.statChangeQueue[Stat.SPEED.getMask()],attacker));
						   AbilityMap.statChangeQueue[Stat.ATTACK.getMask()] = 0;
						   AbilityMap.statChangeQueue[Stat.DEFENSE.getMask()] = 0;
						   AbilityMap.statChangeQueue[Stat.SPEED.getMask()] = 0;
						   return 1;
					   }
				   }
				   
				   else
				   {
					   IPokemon defender = model.getOpponentPokemon(attacker.getPlayerID());
					   attacker.changeHP( attacker.getMaxHP() / 2 );
					   Event.abilityEvent(EventType.HP_CHANGE, attacker, defender, null, attacker, defender, moveUsed);
					   Event.itemPrimaryEffectEvent(attacker, EventType.HP_CHANGE, moveUsed);
					   Event.itemSecondaryEffectEvent(attacker, EventType.HP_CHANGE, moveUsed);
					   defender.addVolatileStatus(new StatusContainer("Cruse"));
					   Event.statusVolatileEvent(defender, EventType.POST_STATUS_CHANGE, null);
				   }
				   
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		effectMap.put("Wild Charge", new IMoveEffect()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Wild Charge";
			   String description = "User takes a quarter of damage dealt in recoil.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon attacker, Move moveUsed)
			   { 
				  if (model == null) model = BattleModel.getInstance();
				  attacker.changeHP(moveUsed.getMoveEffectContainer().getDamageDelt() / 4);
				  Event.abilityEvent(EventType.HP_CHANGE, attacker, null, null, null, null, null);
				  Event.itemPrimaryEffectEvent(attacker, EventType.HP_CHANGE, moveUsed);
				  Event.itemSecondaryEffectEvent(attacker, EventType.HP_CHANGE, moveUsed);
				  return 1;
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		effectMap.put("Taunt", new IMoveEffect()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Taunt";
			   String description = "The target cannot use status moves for three turns.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon attacker, Move moveUsed)
			   { 
				  if (model == null) model = BattleModel.getInstance();
				  IPokemon opponent = model.getOpponentPokemon(attacker.getPlayerID());
				  
				  if(opponent.getLastMoveUsed() == null)
				  {
					  model.addLogItem("but it failed!");
					  return 1;
				  }
				  
				  opponent.addVolatileStatus(new StatusContainer(-1,-1,"Taunt",opponent.getLastMoveUsed()));
				  model.addLogItem(opponent.getNickName()+" fell for the Taunt!");
				  return 1;
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
		});
	}
}
