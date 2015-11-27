package pokemonBattleSim.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import pokemonBattleSim.formulas.Formula;
import pokemonBattleSim.models.AbilityMap.Stat;
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
				  if(Event.statusVolatileEvent(attacker, EventType.HEAL, moveUsed))
				  {
					  //runPrimaryEffectevent automatic
					  return 0;
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
				  if(Event.statusNonVolatileEvent(attacker, EventType.PRE_STATUS_CHANGE, moveUsed))
				  {
					  //runPrimaryEffectevent automatic
					  return 0;
				  }
				  IPokemon opponent = model.getOpponentPokemon(attacker.getPlayerID());
				  
				  if(!opponent.hasNonVolatileStatus())
				  {
					  opponent.setNonVolatileStatus(new StatusContainer(opponent.getMaxAtk(),10,"Burn",null));
				  }
				  else if(opponent.hasNonVolatileStatus("Burn"))
				  {
					  opponent.getNonVolatileStatusContainer().addToDegree(10, false);
				  }
				  
				  Event.statusNonVolatileEvent(attacker, EventType.POST_STATUS_CHANGE, moveUsed);
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
				  if(Event.statusNonVolatileEvent(attacker, EventType.PRE_STATUS_CHANGE, moveUsed))
				  {
					  //runPrimaryEffectevent automatic
					  return 0;
				  }
				  IPokemon opponent = model.getOpponentPokemon(attacker.getPlayerID());
				  
				  if(!opponent.hasNonVolatileStatus())
				  {
					  opponent.setNonVolatileStatus(new StatusContainer(opponent.getMaxAtk(),30,"Burn",null));
					  Event.statusNonVolatileEvent(attacker, EventType.POST_STATUS_CHANGE, moveUsed);
				  }
				  else if(opponent.hasNonVolatileStatus("Burn"))
				  {
					  opponent.getNonVolatileStatusContainer().addToDegree(30, false);
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
				   	IPokemon defender = model.getOpponentPokemon(attacker.getPlayerID());
				   	Random gen = new Random();
				   	int timesExecuted = gen.nextInt(5 - 2) + 2;
				   	
				   	for(int i = 0; i < timesExecuted; i++)
				   	{
					    if(Event.abilityEvent(EventType.PRE_ATTACK, defender, attacker, model.getField(), attacker, defender, moveUsed))
						{
							//runPrimaryEffectmethod automatically executed
						}
						else
						{
							int damage = Formula.calcDamage(attacker, defender, moveUsed, model.getField());
							damage = defender.changeHP(damage);
							Event.abilityEvent(EventType.HP_CHANGE, defender, attacker, model.getField(), attacker, defender, moveUsed);
							Event.statusVolatileEvent(attacker, EventType.POST_ATTACK, moveUsed);
							Event.abilityEvent(EventType.POST_ATTACK, defender, attacker, model.getField(), attacker, defender, moveUsed);
							moveUsed.getMoveEffectContainer().updateMoveEffectContainer(attacker, damage);
							Event.movePrimaryEffectEvent(attacker, EventType.POST_ATTACK, moveUsed);
							Event.moveSecondaryEffectEvent(attacker, EventType.POST_ATTACK, moveUsed);
						}
				   	}
				   	System.out.println("It hit "+timesExecuted+" times!");
				  return 1;
			   }
			   public double runSecondaryEffect(IPokemon attacker, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
	}
}
