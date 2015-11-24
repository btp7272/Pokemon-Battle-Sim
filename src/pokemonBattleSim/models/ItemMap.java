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
