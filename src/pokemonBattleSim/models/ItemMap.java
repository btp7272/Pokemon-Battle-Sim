package pokemonBattleSim.models;

import java.util.HashMap;
import java.util.Map;

import pokemonBattleSim.formulas.Formula;
import pokemonBattleSim.types.*;

public class ItemMap 
{
	public static Map < String, IItem > itemMap = new HashMap<>();
	private static IBattleModel model = BattleModel.getInstance();
	
	static
	{
		itemMap.put("None", new IItem()
		{
			   EventType trigger = EventType.NONE;
			   String name = "None";
			   String description = "This Pokemon is not holding an item.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				  return 1;
			   }
		});
		
		itemMap.put("Sitrus Berry", new IItem()
		{
			   EventType trigger = EventType.POST_ATTACK;
			   String name = "Sitrus Berry";
			   String description = "Restores 1/4 of the max HP when at 1/2 HP or less. One-time use.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(holder.getHP() <= holder.getMaxHP() / 2)
				   {
					   if(Event.statusVolatileEvent(holder, EventType.HEAL, moveUsed))
					   {
						   //run event automatic
						   return 0;
					   }
					   holder.changeHP(- holder.getMaxHP() / 4);
					   System.out.println(holder.getNickName()+" ate it's Sitrus Berry!");
					   holder.setItem(new ItemContainer("None"));
					   Event.abilityEvent(EventType.HP_CHANGE, holder, null, null, null, null, null);
				   }
				   return 1;
			   }
		});
		
		//Next 18 items are the berries for each type
		itemMap.put("Colbur Berry", new IItem()
		{
			   EventType trigger = EventType.PRE_DAMAGE;
			   String name = "Colbur Berry";
			   String description = "Reduces damage from a super effective Dark-type attack by 50%. Consumed after use.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(moveUsed.getType() == Type.DARK && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   System.out.println(holder.getNickName()+" ate it's Colbur Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
		});
		
		itemMap.put("Occa Berry", new IItem()
		{
			   EventType trigger = EventType.PRE_DAMAGE;
			   String name = "Occa Berry";
			   String description = "Reduces damage from a super effective Fire-type attack by 50%. Consumed after use.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(moveUsed.getType() == Type.FIRE && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   System.out.println(holder.getNickName()+" ate it's Occa Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
		});
		
		itemMap.put("Passho Berry", new IItem()
		{
			   EventType trigger = EventType.PRE_DAMAGE;
			   String name = "Passho Berry";
			   String description = "Reduces damage from a super effective Water-type attack by 50%. Consumed after use.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(moveUsed.getType() == Type.WATER && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   System.out.println(holder.getNickName()+" ate it's Passho Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
		});
		
		itemMap.put("Wacon Berry", new IItem()
		{
			   EventType trigger = EventType.PRE_DAMAGE;
			   String name = "Wacon Berry";
			   String description = "Reduces damage from a super effective Electric-type attack by 50%. Consumed after use.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(moveUsed.getType() == Type.ELECTRIC && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   System.out.println(holder.getNickName()+" ate it's Wacon Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
		});
		
		
		itemMap.put("Rindo Berry", new IItem()
		{
			   EventType trigger = EventType.PRE_DAMAGE;
			   String name = "Rindo Berry";
			   String description = "Reduces damage from a super effective Grass-type attack by 50%. Consumed after use.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(moveUsed.getType() == Type.GRASS && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   System.out.println(holder.getNickName()+" ate it's Rindo Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
		});
		
		itemMap.put("Yache Berry", new IItem()
		{
			   EventType trigger = EventType.PRE_DAMAGE;
			   String name = "Yache Berry";
			   String description = "Reduces damage from a super effective Ice-type attack by 50%. Consumed after use.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(moveUsed.getType() == Type.ICE && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   System.out.println(holder.getNickName()+" ate it's Yache Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
		});
		
		itemMap.put("Chople Berry", new IItem()
		{
			   EventType trigger = EventType.PRE_DAMAGE;
			   String name = "Chople Berry";
			   String description = "Reduces damage from a super effective Fighting-type attack by 50%. Consumed after use.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(moveUsed.getType() == Type.FIGHTING && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   System.out.println(holder.getNickName()+" ate it's Chople Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
		});
		
		itemMap.put("Shuca Berry", new IItem()
		{
			   EventType trigger = EventType.PRE_DAMAGE;
			   String name = "Shuca Berry";
			   String description = "Reduces damage from a super effective Ground-type attack by 50%. Consumed after use.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(moveUsed.getType() == Type.GROUND && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   System.out.println(holder.getNickName()+" ate it's sHUCA Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
		});
		
		itemMap.put("Coba Berry", new IItem()
		{
			   EventType trigger = EventType.PRE_DAMAGE;
			   String name = "Coba Berry";
			   String description = "Reduces damage from a super effective Flying-type attack by 50%. Consumed after use.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(moveUsed.getType() == Type.FLYING && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   System.out.println(holder.getNickName()+" ate it's Coba Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
		});
		
		itemMap.put("Payapa Berry", new IItem()
		{
			   EventType trigger = EventType.PRE_DAMAGE;
			   String name = "Payapa Berry";
			   String description = "Reduces damage from a super effective Psychic-type attack by 50%. Consumed after use.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(moveUsed.getType() == Type.PSYCHIC && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   System.out.println(holder.getNickName()+" ate it's Payapa Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
		});
		
		itemMap.put("Tanga Berry", new IItem()
		{
			   EventType trigger = EventType.PRE_DAMAGE;
			   String name = "Tanga Berry";
			   String description = "Reduces damage from a super effective Bug-type attack by 50%. Consumed after use.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(moveUsed.getType() == Type.BUG && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   System.out.println(holder.getNickName()+" ate it's Tanga Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
		});
		
		itemMap.put("Charti Berry", new IItem()
		{
			   EventType trigger = EventType.PRE_DAMAGE;
			   String name = "Charti Berry";
			   String description = "Reduces damage from a super effective Rock-type attack by 50%. Consumed after use.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(moveUsed.getType() == Type.ROCK && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   System.out.println(holder.getNickName()+" ate it's Charti Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
		});
		
		itemMap.put("Haban Berry", new IItem()
		{
			   EventType trigger = EventType.PRE_DAMAGE;
			   String name = "Haban Berry";
			   String description = "Reduces damage from a super effective Dragon-type attack by 50%. Consumed after use.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(moveUsed.getType() == Type.DRAGON && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   System.out.println(holder.getNickName()+" ate it's Haban Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
		});
		
		itemMap.put("Babiri Berry", new IItem()
		{
			   EventType trigger = EventType.PRE_DAMAGE;
			   String name = "Babiri Berry";
			   String description = "Reduces damage from a super effective Steel-type attack by 50%. Consumed after use.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(moveUsed.getType() == Type.STEEL && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   System.out.println(holder.getNickName()+" ate it's Babiri Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
		});
		
		itemMap.put("Chilan Berry", new IItem()
		{
			   EventType trigger = EventType.PRE_DAMAGE;
			   String name = "Chilan Berry";
			   String description = "Reduces damage from a super effective Normal-type attack by 50%. Consumed after use.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(moveUsed.getType() == Type.NORMAL && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   System.out.println(holder.getNickName()+" ate it's Chilan Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
		});
		
		itemMap.put("Kasib Berry", new IItem()
		{
			   EventType trigger = EventType.PRE_DAMAGE;
			   String name = "Kasib Berry";
			   String description = "Reduces damage from a super effective Ghost-type attack by 50%. Consumed after use.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(moveUsed.getType() == Type.GHOST && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   System.out.println(holder.getNickName()+" ate it's Kasib Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
		});
		
		itemMap.put("Kebia Berry", new IItem()
		{
			   EventType trigger = EventType.PRE_DAMAGE;
			   String name = "Kebia Berry";
			   String description = "Reduces damage from a super effective Poison-type attack by 50%. Consumed after use.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(moveUsed.getType() == Type.POISON && moveUsed.getCategory() != Attribute.STATUS && Formula.isSuperEffective(holder, moveUsed))
				   {
					   Formula.item *= 0.5;
					   System.out.println(holder.getNickName()+" ate it's Kebia Berry!");
					   holder.setItem(new ItemContainer("None"));
				   }
				   return 1;
			   }
		});
		
		itemMap.put("Life Orb", new IItem()
		{
			   EventType trigger = EventType.PRE_DAMAGE;
			   String name = "Life Orb";
			   String description = "Boosts power by 30%, user takes 10% recoil each turn it attacks.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   Formula.item *= 1.3;
				   holder.changeHP(holder.getMaxHP() / 10);
				   Event.abilityEvent(EventType.HP_CHANGE, holder, null, null, null, null, null);
				   return 1;
			   }
		});
		
		itemMap.put("Choice Specs", new IItem()
		{
			   EventType trigger = EventType.PRE_ATTACK;
			   String name = "Choice Specs";
			   String description = "Hold item which raises Special Attack by 50%, but locks holder into one move.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(holder.getItemContainer().getActiveStatus() == false)
				   {
					   holder.getItemContainer().setForcedMove(moveUsed);
					   holder.getItemContainer().setActiveStatus(true);
				   }
				   
				   IPokemon defender = model.getOpponentPokemon(holder.getPlayerID());
				   
				   	if(Event.statusVolatileEvent(defender, EventType.PRE_ATTACK, holder.getItemContainer().getForcedMove()))
			   	    {
					//run method automatically executed
					}
					//check for ability event of the attacker
					else if(Event.abilityEvent(EventType.PRE_ATTACK, holder, defender, model.getField(), holder, defender,holder.getItemContainer().getForcedMove()))
					{
						//run method automatically executed
					}
					//check for move event of the attacker
					else if(Event.moveEffectEvent(holder, EventType.PRE_ATTACK, holder.getItemContainer().getForcedMove()))
					{
						//run method automatically executed
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
					   //check for ability event of the defender
					   Event.statusVolatileEvent(holder, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
					   Event.abilityEvent(EventType.POST_ATTACK, defender, holder, model.getField(), holder, defender, holder.getItemContainer().getForcedMove());
					   holder.getItemContainer().getForcedMove().getMoveEffectContainer().updateMoveEffectContainer(holder, damage);
					   Event.moveEffectEvent(holder, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
					   Event.itemEffectEvent(holder, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
					   Event.itemEffectEvent(defender, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
					}
				   
				   return 1;
			   }
		});
		
		itemMap.put("Choice Band", new IItem()
		{
			   EventType trigger = EventType.PRE_ATTACK;
			   String name = "Choice Specs";
			   String description = "Hold item which raises Special Attack by 50%, but locks holder into one move.";
			   public EventType getEventTrigger(){return trigger;}
			   public String getName(){return name;}
			   public String getDescription(){return description;}
			   public double run (IPokemon holder, Move moveUsed)
			   { 
				   if(holder.getItemContainer().getActiveStatus() == false)
				   {
					   holder.getItemContainer().setForcedMove(moveUsed);
					   holder.getItemContainer().setActiveStatus(true);
				   }
				   
				   IPokemon defender = model.getOpponentPokemon(holder.getPlayerID());
				   
				   	if(Event.statusVolatileEvent(defender, EventType.PRE_ATTACK, holder.getItemContainer().getForcedMove()))
			   	    {
					//run method automatically executed
					}
					//check for ability event of the attacker
					else if(Event.abilityEvent(EventType.PRE_ATTACK, holder, defender, model.getField(), holder, defender,holder.getItemContainer().getForcedMove()))
					{
						//run method automatically executed
					}
					//check for move event of the attacker
					else if(Event.moveEffectEvent(holder, EventType.PRE_ATTACK, holder.getItemContainer().getForcedMove()))
					{
						//run method automatically executed
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
					   //check for ability event of the defender
					   Event.statusVolatileEvent(holder, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
					   Event.abilityEvent(EventType.POST_ATTACK, defender, holder, model.getField(), holder, defender, holder.getItemContainer().getForcedMove());
					   holder.getItemContainer().getForcedMove().getMoveEffectContainer().updateMoveEffectContainer(holder, damage);
					   Event.moveEffectEvent(holder, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
					   Event.itemEffectEvent(holder, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
					   Event.itemEffectEvent(defender, EventType.POST_ATTACK, holder.getItemContainer().getForcedMove());
					}
				   
				   return 1;
			   }
		});
	}
}
