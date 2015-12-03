package pokemonBattleSim.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import pokemonBattleSim.formulas.Formula;
import pokemonBattleSim.models.AbilityMap.Stat;
import pokemonBattleSim.online.Send;
import pokemonBattleSim.types.*;

public class ItemMap 
{
	/*
	 * This class is similar to Ability map, where it maps items and contains runnables for how they affect pokemon.
	 */
	public static Map < String, IItem > itemMap = new HashMap<>();
	private static IBattleModel model = BattleModel.getInstance();
	
	static
	{
		itemMap.put("None", new IItem()
		{
			   EventType primaryTrigger = EventType.NONE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "None";
			   String description = "This Pokemon is not holding an item.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return primaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
				  return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Sitrus Berry", new IItem()
		{
			   EventType primaryTrigger = EventType.HP_CHANGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Sitrus Berry";
			   String description = "Restores 1/4 of the max HP when at 1/2 HP or less. One-time use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(holder.getHP() <= holder.getMaxHP() / 2)
				   {
					   if(Event.statusVolatileEvent(holder, EventType.HEAL, moveUsed))
					   {
						   //runPrimaryEffectevent automatic
						   return 0;
					   }
					   holder.changeHP(- holder.getMaxHP() / 4);
					   model.addLogItem(holder.getNickName()+" ate it's Sitrus Berry!");
					   holder.setItem(new ItemContainer("None"));
					   Event.abilityEvent(EventType.HP_CHANGE, holder, null, null, null, null, null);
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		
		itemMap.put("Liechi Berry", new IItem()
		{
			   EventType primaryTrigger = EventType.HP_CHANGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Liechi Berry";
			   String description = "Raises Attack by one stage when at 25% HP or less. One-time use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(holder.getHP() <= holder.getMaxHP() / 4)
				   {
					   AbilityMap.statChangeQueue[Stat.ATTACK.getMask()] = 1;
					   if(Event.abilityEvent(EventType.STATISTIC_CHANGE,holder,null,null,null,null,null))
					   {
						   AbilityMap.statChangeQueue[Stat.ATTACK.getMask()] = 0;
						   return 1;
					   }
					   else
					   {
						   holder.changeAtk(AbilityMap.statChangeQueue[Stat.ATTACK.getMask()]);
						   model.addLogItem(holder.getNickName()+" ate it's Liechi Berry!");
						   if (model == null) model = BattleModel.getInstance(); model.addLogItem(Formula.printAtkChange(AbilityMap.statChangeQueue[Stat.ATTACK.getMask()],holder));
						   holder.setItem(new ItemContainer("None"));
						   AbilityMap.statChangeQueue[Stat.ATTACK.getMask()] = 0;
					   }
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Berry", new IItem()
		{
			   EventType primaryTrigger = EventType.HP_CHANGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Berry";
			   String description = "Restores 10 HP when at 50% HP or less. One-time use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(holder.getHP() <= holder.getMaxHP() / 2)
				   {
					   if(Event.statusVolatileEvent(holder, EventType.HEAL, moveUsed))
					   {
						   //runPrimaryEffectevent automatic
						   return 0;
					   }
					   holder.changeHP(- 10);
					   model.addLogItem(holder.getNickName()+" ate it's Berry!");
					   holder.setItem(new ItemContainer("None"));
					   Event.abilityEvent(EventType.HP_CHANGE, holder, null, null, null, null, null);
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Berry Juice", new IItem()
		{
			   EventType primaryTrigger = EventType.HP_CHANGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Berry Juice";
			   String description = "Restores 20 HP when at 50% HP or less. One-time use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(holder.getHP() <= holder.getMaxHP() / 2)
				   {
					   if(Event.statusVolatileEvent(holder, EventType.HEAL, moveUsed))
					   {
						   //runPrimaryEffectevent automatic
						   return 0;
					   }
					   holder.changeHP(- 20);
					   model.addLogItem(holder.getNickName()+" drank it's Berry Juice!");
					   holder.setItem(new ItemContainer("None"));
					   Event.abilityEvent(EventType.HP_CHANGE, holder, null, null, null, null, null);
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		//Next 17 items are the berries for each type besides normal, which can't be super effective
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		itemMap.put("Colbur Berry", new IItem()
		{
			   EventType primaryTrigger = EventType.PRE_DAMAGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Colbur Berry";
			   String description = "Reduces damage from a super effective Dark-type attack by 50%. Consumed after use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getType() == Type.DARK && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   model.addLogItem(holder.getNickName()+" ate it's Colbur Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Occa Berry", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_DAMAGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Occa Berry";
			   String description = "Reduces damage from a super effective Fire-type attack by 50%. Consumed after use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getType() == Type.FIRE && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   model.addLogItem(holder.getNickName()+" ate it's Occa Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Passho Berry", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_DAMAGE;
			   EventType secondaryTrigger = EventType.NONE;;
			   String name = "Passho Berry";
			   String description = "Reduces damage from a super effective Water-type attack by 50%. Consumed after use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getType() == Type.WATER && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   model.addLogItem(holder.getNickName()+" ate it's Passho Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Wacon Berry", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_DAMAGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Wacon Berry";
			   String description = "Reduces damage from a super effective Electric-type attack by 50%. Consumed after use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getType() == Type.ELECTRIC && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   model.addLogItem(holder.getNickName()+" ate it's Wacon Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		
		itemMap.put("Rindo Berry", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_DAMAGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Rindo Berry";
			   String description = "Reduces damage from a super effective Grass-type attack by 50%. Consumed after use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getType() == Type.GRASS && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   model.addLogItem(holder.getNickName()+" ate it's Rindo Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Yache Berry", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_DAMAGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Yache Berry";
			   String description = "Reduces damage from a super effective Ice-type attack by 50%. Consumed after use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getType() == Type.ICE && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   model.addLogItem(holder.getNickName()+" ate it's Yache Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Chople Berry", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_DAMAGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Chople Berry";
			   String description = "Reduces damage from a super effective Fighting-type attack by 50%. Consumed after use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getType() == Type.FIGHTING && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   model.addLogItem(holder.getNickName()+" ate it's Chople Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Shuca Berry", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_DAMAGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Shuca Berry";
			   String description = "Reduces damage from a super effective Ground-type attack by 50%. Consumed after use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getType() == Type.GROUND && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   model.addLogItem(holder.getNickName()+" ate it's sHUCA Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Coba Berry", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_DAMAGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Coba Berry";
			   String description = "Reduces damage from a super effective Flying-type attack by 50%. Consumed after use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getType() == Type.FLYING && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   model.addLogItem(holder.getNickName()+" ate it's Coba Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Payapa Berry", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_DAMAGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Payapa Berry";
			   String description = "Reduces damage from a super effective Psychic-type attack by 50%. Consumed after use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getType() == Type.PSYCHIC && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   model.addLogItem(holder.getNickName()+" ate it's Payapa Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Tanga Berry", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_DAMAGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Tanga Berry";
			   String description = "Reduces damage from a super effective Bug-type attack by 50%. Consumed after use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getType() == Type.BUG && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   model.addLogItem(holder.getNickName()+" ate it's Tanga Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Charti Berry", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_DAMAGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Charti Berry";
			   String description = "Reduces damage from a super effective Rock-type attack by 50%. Consumed after use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getType() == Type.ROCK && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   model.addLogItem(holder.getNickName()+" ate it's Charti Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Haban Berry", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_DAMAGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Haban Berry";
			   String description = "Reduces damage from a super effective Dragon-type attack by 50%. Consumed after use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getType() == Type.DRAGON && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   model.addLogItem(holder.getNickName()+" ate it's Haban Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Babiri Berry", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_DAMAGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Babiri Berry";
			   String description = "Reduces damage from a super effective Steel-type attack by 50%. Consumed after use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getType() == Type.STEEL && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   model.addLogItem(holder.getNickName()+" ate it's Babiri Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		
		itemMap.put("Kasib Berry", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_DAMAGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Kasib Berry";
			   String description = "Reduces damage from a super effective Ghost-type attack by 50%. Consumed after use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getType() == Type.GHOST && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   model.addLogItem(holder.getNickName()+" ate it's Kasib Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Kebia Berry", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_DAMAGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Kebia Berry";
			   String description = "Reduces damage from a super effective Poison-type attack by 50%. Consumed after use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getType() == Type.POISON && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   model.addLogItem(holder.getNickName()+" ate it's Kebia Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Roseli Berry", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_DAMAGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Roseli Berry";
			   String description = "Reduces damage from a super effective Fairy-type attack by 50%. Consumed after use.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getType() == Type.FAIRY && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   model.addLogItem(holder.getNickName()+" ate it's Roseli Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		itemMap.put("Pink Bow", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_DAMAGE;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Pink Bow";
			   String description = "Raises power of Normal-type moves by 20%.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getType() == Type.NORMAL && moveUsed.getCategory() != Attribute.STATUS)
					   Formula.item *= 1.2;
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Life Orb", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_DAMAGE;
			   EventType secondaryTrigger = EventType.POST_ATTACK;
			   String name = "Life Orb";
			   String description = "Boosts power by 30%, user takes 10% recoil each turn it attacks.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   Formula.item *= 1.3;
				   return 1.3;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
					  if (model == null) model = BattleModel.getInstance();
				   holder.changeHP(holder.getMaxHP() / 10);
				   Event.abilityEvent(EventType.HP_CHANGE, holder, null, null, null, null, null);
				   return 1;
			   }
		});
		
		itemMap.put("Choice Specs", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_ATTACK;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Choice Specs";
			   String description = "Hold item which raises Special Attack by 50%, but locks holder into one move.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(holder.getItemContainer().getActiveStatus() == false)
				   {
					   holder.getItemContainer().setForcedMove(moveUsed);
					   holder.getItemContainer().setActiveStatus(true);
				   }
				   
				   IPokemon defender = model.getOpponentPokemon(holder.getPlayerID());
				   
				   	if(Event.statusVolatileEvent(defender, EventType.PRE_ATTACK, holder.getItemContainer().getForcedMove()))
			   	    {
					//runPrimaryEffectmethod automatically executed
					}
					//check for ability event of the attacker
					else if(Event.abilityEvent(EventType.PRE_ATTACK, holder, defender, model.getField(), holder, defender,holder.getItemContainer().getForcedMove()))
					{
						//runPrimaryEffectmethod automatically executed
					}
					//check for move event of the attacker
					else if(Event.movePrimaryEffectEvent(holder, EventType.PRE_ATTACK, holder.getItemContainer().getForcedMove()))
					{
						//runPrimaryEffectmethod automatically executed
						Event.moveSecondaryEffectEvent(holder, EventType.PRE_ATTACK, holder.getItemContainer().getForcedMove());
					}
					else
					{
						if(holder.getItemContainer().getForcedMove().getCategory() == Attribute.STATUS)
						{
							if(Event.statusVolatileEvent(defender, EventType.PRE_STATUS_CHANGE, holder.getItemContainer().getForcedMove()))
							{
								  //run method automatic
							}
							else if(Event.abilityEvent(EventType.PRE_DAMAGE, defender, holder, model.getField(), holder, defender, holder.getItemContainer().getForcedMove()))
							{
								 //run method automatic
							}
							else
							{
								Event.movePrimaryEffectEvent(holder, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
								Event.itemPrimaryEffectEvent(defender, EventType.POST_STATUS_CHANGE, holder.getItemContainer().getForcedMove());
								Event.itemSecondaryEffectEvent(defender, EventType.POST_STATUS_CHANGE, holder.getItemContainer().getForcedMove());
								Event.statusVolatileEvent(holder, EventType.POST_STATUS_CHANGE, holder.getItemContainer().getForcedMove());
								Event.statusVolatileEvent(defender, EventType.POST_STATUS_CHANGE, holder.getItemContainer().getForcedMove());
								Event.statusNonVolatileEvent(defender, EventType.POST_STATUS_CHANGE, holder.getItemContainer().getForcedMove());
							}
						}
						else
						{
						   int damage = Formula.calcDamage(holder, defender, holder.getItemContainer().getForcedMove(), model.getField());
						   if(holder.getItemContainer().getForcedMove().getCategory() == Attribute.SPECIAL)
							   damage = defender.changeHP((int)(damage * 1.5));
						   else
							   damage = defender.changeHP((int)(damage));
						   //check for ability even of the defender
						   Event.abilityEvent(EventType.HP_CHANGE, defender, holder, model.getField(), holder, defender, holder.getItemContainer().getForcedMove());
						   Event.itemPrimaryEffectEvent(defender, EventType.HP_CHANGE, holder.getItemContainer().getForcedMove());
						   Event.itemSecondaryEffectEvent(defender, EventType.HP_CHANGE, holder.getItemContainer().getForcedMove());
						   //check for ability event of the defender
						   Event.statusVolatileEvent(holder, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
						   Event.abilityEvent(EventType.POST_ATTACK, defender, holder, model.getField(), holder, defender, holder.getItemContainer().getForcedMove());
						   holder.getItemContainer().getForcedMove().getMoveEffectContainer().updateMoveEffectContainer(holder, damage);
						   Event.movePrimaryEffectEvent(holder, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
						   Event.moveSecondaryEffectEvent(holder, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
						   Event.itemPrimaryEffectEvent(holder, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
						   Event.itemSecondaryEffectEvent(holder, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
						   Event.itemPrimaryEffectEvent(defender, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
						   Event.itemSecondaryEffectEvent(defender, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
						}
					}
				   
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Choice Band", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_ATTACK;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Choice Specs";
			   String description = "Hold item which raises Special Attack by 50%, but locks holder into one move.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(holder.getItemContainer().getActiveStatus() == false)
				   {
					   holder.getItemContainer().setForcedMove(moveUsed);
					   holder.getItemContainer().setActiveStatus(true);
				   }
				   
				   IPokemon defender = model.getOpponentPokemon(holder.getPlayerID());
				   
				   	if(Event.statusVolatileEvent(defender, EventType.PRE_ATTACK, holder.getItemContainer().getForcedMove()))
			   	    {
					//runPrimaryEffect method automatically executed
					}
					//check for ability event of the attacker
					else if(Event.abilityEvent(EventType.PRE_ATTACK, holder, defender, model.getField(), holder, defender,holder.getItemContainer().getForcedMove()))
					{
						//runPrimaryEffectmethod automatically executed
					}
					//check for move event of the attacker
					else if(Event.movePrimaryEffectEvent(holder, EventType.PRE_ATTACK, holder.getItemContainer().getForcedMove()))
					{
						//runPrimaryEffect method automatically executed
						Event.moveSecondaryEffectEvent(holder, EventType.PRE_ATTACK, holder.getItemContainer().getForcedMove());
					}
					else
					{
						if(holder.getItemContainer().getForcedMove().getCategory() == Attribute.STATUS)
						{
							if(Event.statusVolatileEvent(defender, EventType.PRE_STATUS_CHANGE, holder.getItemContainer().getForcedMove()))
							{
								  //run method automatic
							}
							else if(Event.abilityEvent(EventType.PRE_DAMAGE, defender, holder, model.getField(), holder, defender, holder.getItemContainer().getForcedMove()))
							{
								 //run method automatic
							}
							else
							{
								Event.movePrimaryEffectEvent(holder, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
								Event.itemPrimaryEffectEvent(defender, EventType.POST_STATUS_CHANGE, holder.getItemContainer().getForcedMove());
								Event.itemSecondaryEffectEvent(defender, EventType.POST_STATUS_CHANGE, holder.getItemContainer().getForcedMove());
								Event.statusVolatileEvent(holder, EventType.POST_STATUS_CHANGE, holder.getItemContainer().getForcedMove());
								Event.statusVolatileEvent(defender, EventType.POST_STATUS_CHANGE, holder.getItemContainer().getForcedMove());
								Event.statusNonVolatileEvent(defender, EventType.POST_STATUS_CHANGE, holder.getItemContainer().getForcedMove());
							}
					   }
					   else
					   {
						   int damage = Formula.calcDamage(holder, defender, holder.getItemContainer().getForcedMove(), model.getField());
						   if(holder.getItemContainer().getForcedMove().getCategory() == Attribute.PHYSICAL)
							   damage = defender.changeHP((int)(damage * 1.5));
						   else
							   damage = defender.changeHP((int)(damage));
						   //check for ability even of the defender
						   Event.abilityEvent(EventType.HP_CHANGE, defender, holder, model.getField(), holder, defender, holder.getItemContainer().getForcedMove());
						   Event.itemPrimaryEffectEvent(defender, EventType.HP_CHANGE, holder.getItemContainer().getForcedMove());
						   Event.itemSecondaryEffectEvent(defender, EventType.HP_CHANGE, holder.getItemContainer().getForcedMove());
						   //check for ability event of the defender
						   Event.statusVolatileEvent(holder, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
						   Event.abilityEvent(EventType.POST_ATTACK, defender, holder, model.getField(), holder, defender, holder.getItemContainer().getForcedMove());
						   holder.getItemContainer().getForcedMove().getMoveEffectContainer().updateMoveEffectContainer(holder, damage);
						   Event.movePrimaryEffectEvent(holder, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
						   Event.moveSecondaryEffectEvent(holder, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
						   Event.itemPrimaryEffectEvent(holder, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
						   Event.itemSecondaryEffectEvent(holder, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
						   Event.itemPrimaryEffectEvent(defender, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
						   Event.itemSecondaryEffectEvent(defender, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
					   }
					}
				   
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Leftovers", new IItem()
		{
			   EventType primaryTrigger = EventType.ENTRY;
			   EventType secondaryTrigger = EventType.NONE;
			   String name = "Leftovers";
			   String description = "Heals 1/16 of max HP each turn.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   Timer timer = new Timer();
				   class SetTimer extends TimerTask
				   {
					   @Override
					   public void run()
					   {
						  if(holder.getItemContainer().getActiveStatus() == false)
						  {
							  timer.cancel();
							  return;
						  }
						  
						  if(holder.getHP() == holder.getMaxHP())
						  {
							  return;
						  }
						  
						  if(Event.statusVolatileEvent(holder, EventType.HEAL, moveUsed))
						   {
							   //runPrimaryEffectevent automatic
							   return;
						   }
						   holder.changeHP(- holder.getMaxHP() / 16);
						   Event.abilityEvent(EventType.HP_CHANGE, holder, null, null, null, null, null);
					   }
				   }
				   if(holder.getItemContainer().getActiveStatus() == false)
				   {
					   TimerTask task = new SetTimer();
					   timer.schedule(task, 10000, 10000);
					   holder.getItemContainer().setActiveStatus(true);
				   }
				   return 1;
			   }
			   
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
				   return 1;
			   }
		});
		
		itemMap.put("Assault Vest", new IItem()
		{
			EventType primaryTrigger = EventType.PRE_ATTACK;
			   EventType secondaryTrigger = EventType.PRE_DAMAGE;
			   String name = "Assault Vest";
			   String description = "Holder's Sp. Def is 1.5x, but it can only use damaging moves.";
			   public EventType getPrimaryEventTrigger(){return primaryTrigger;}
			   public EventType getSecondaryEventTrigger(){return secondaryTrigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double runPrimaryEffect(IPokemon holder, Move moveUsed)
			   { 
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getCategory() == Attribute.STATUS)
				   {
					   model.addLogItem(holder.getNickName()+" cannot use status moves because its wear an Assault Vest!");
					   return 0;
				   }
				   
				   IPokemon defender = model.getOpponentPokemon(holder.getPlayerID());
				   
				   	if(Event.statusVolatileEvent(defender, EventType.PRE_ATTACK, moveUsed))
			   	    {
					//runPrimaryEffect method automatically executed
					}
					//check for ability event of the attacker
					else if(Event.abilityEvent(EventType.PRE_ATTACK, holder, defender, model.getField(), holder, defender,moveUsed))
					{
						//runPrimaryEffectmethod automatically executed
					}
					//check for move event of the attacker
					else if(Event.movePrimaryEffectEvent(holder, EventType.PRE_ATTACK, moveUsed))
					{
						//runPrimaryEffect method automatically executed
						Event.moveSecondaryEffectEvent(holder, EventType.PRE_ATTACK, moveUsed);
					}
					else
					{
					   int damage = Formula.calcDamage(holder, defender, moveUsed, model.getField());
					   damage = defender.changeHP((int)(damage));
					   //check for ability even of the defender
					   Event.abilityEvent(EventType.HP_CHANGE, defender, holder, model.getField(), holder, defender, moveUsed);
					   Event.itemPrimaryEffectEvent(defender, EventType.HP_CHANGE, moveUsed);
					   Event.itemSecondaryEffectEvent(defender, EventType.HP_CHANGE, moveUsed);
					   //check for ability event of the defender
					   Event.statusVolatileEvent(holder, EventType.POST_ATTACK, moveUsed);
					   Event.abilityEvent(EventType.POST_ATTACK, defender, holder, model.getField(), holder, defender, moveUsed);
					   moveUsed.getMoveEffectContainer().updateMoveEffectContainer(holder, damage);
					   Event.movePrimaryEffectEvent(holder, EventType.POST_ATTACK, moveUsed);
					   Event.moveSecondaryEffectEvent(holder, EventType.POST_ATTACK, moveUsed);
					   Event.itemPrimaryEffectEvent(holder, EventType.POST_ATTACK, moveUsed);
					   Event.itemSecondaryEffectEvent(holder, EventType.POST_ATTACK, moveUsed);
					   Event.itemPrimaryEffectEvent(defender, EventType.POST_ATTACK, moveUsed);
					   Event.itemSecondaryEffectEvent(defender, EventType.POST_ATTACK, moveUsed);
					}
				   
				   return 1;
			   }
			   public double runSecondaryEffect(IPokemon holder, Move moveUsed)
			   {
					  if (model == null) model = BattleModel.getInstance();
				   if(moveUsed.getCategory() == Attribute.SPECIAL)
					   Formula.item = (1 / 1.5);
				   return 1;
			   }
		});
	}
}
