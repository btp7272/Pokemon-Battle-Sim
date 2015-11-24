package pokemonBattleSim.types;

import java.util.ArrayList;

public interface IPokemon 
{

		public void setPlayerID(int id);
		public void setBenchPosition(int pos);
		public void setHp(int health, int IV, int EV, int level);
		public void setAtk(int attack, int IV, int EV, int level);
		public void setDef(int defense, int IV, int EV, int level);
		public void setSpAtk(int spattack, int IV, int EV, int level);
		public void setSpDef(int spdefense, int IV, int EV, int level);
		public void setSpeed(int newSpeed, int IV, int EV, int level);
		public void setWeight(double newWeight);
		public void setGender(Gender gen);
		public void setLevel(int lev);
		public void setAbility(AbilityContainer abil);
		public void setBaseAbility(AbilityContainer abil);
		public void addVolatileStatus(StatusContainer status);
		public void setNonVolatileStatus(StatusContainer status);
		public void setBattleState(BattleState state);
		public void setLastMoveUsed(Move move);
		
		//para: number -6 to 6. The stage of the stat
		public void changeAtk(int change);
		public void changeDef(int change);
		public void changeSpAtk(int change);
		public void changeSpDef(int change);
		public void changeSpeed(int change);
		public int changeHP(int damage);
		public void changeWeight(double newWeight);
		public void changeAtkNoModifier(double multiplier, boolean wasOdd);
		public void changeSpAtkNoModifier(double multiplier, boolean wasOdd);
		
		public void resetHP();
		public void resetAtk();
		public void resetDef();
		public void resetSpAtk();
		public void resetSpDef();
		public void resetSpeed();
		public void resetVolatileStatus();
		
		public void setMaxAtk(int atk);
		public void setMaxDef(int def);
		public void setMaxSpAtk(int spatk);
		public void setMaxSpDef(int spdef);
		public void setMaxSpeed(int spd);
		
		public void setMove(Move newMove, int moveNum);
		public void setType(Type newType, int typeNum);

		public String getSpeciesName();
		public String getNickName();
		public int getPlayerID();
		public int getBenchPosition();
		public int getHP();
		public int getMaxHP();
		public int getAtk();
		public int getMaxAtk();
		public int getDef();
		public int getMaxDef();
		public int getSpAtk();
		public int getMaxSpAtk();
		public int getSpDef();
		public int getMaxSpDef();
		public int getSpeed();
		public int getMaxSpeed();
		public double getWeight();
		public Type getType1();
		public Type getType2();
		public Type getType3();
		public Gender getGender();
		public int getAtkModifier();
		public int getDefModifier();
		public int getSpAtkModifier();
		public int getSpDefModifier();
		public int getSpeedModifier();
		public int getLevel();
		public AbilityContainer getAbility();
		public AbilityContainer getBaseAbility();
		public IStatus getNonVolatileStatus();
		public StatusContainer getNonVolatileStatusContainer();
		public ArrayList<StatusContainer> getVolatileStatus();
		public Move getMove(int i);
		public BattleState getBattleState();
		public StatusContainer getVolatileStatus(String name);
		public boolean removeVolatileStatus(String name);
		public boolean hasVolatileStatus(String name);
		public boolean hasNonVolatileStatus(String name);
		public boolean hasNonVolatileStatus();
		public void activeNonVolatileStatus();
		public Move getLastMoveUsed();
}
