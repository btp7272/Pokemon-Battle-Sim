package pokemonBattleSim.types;

public interface IPokemon 
{
		public void setIndex(double index);
		public void setName(String newName);
		public void setHp(int health, int IV, int EV, int level);
		public void setAtk(int attack, int IV, int EV, int level);
		public void setDef(int defense, int IV, int EV, int level);
		public void setSpAtk(int spattack, int IV, int EV, int level);
		public void setSpDef(int spdefense, int IV, int EV, int level);
		public void setSpeed(int newSpeed, int IV, int EV, int level);
		public void setWeight(double newWeight);
		public void setGender(Gender gen);
		public void setLevel(int lev);
		
		//para: number -6 to 6. The stage of the stat
		public void changeAtk(int change);
		public void changeDef(int change);
		public void changeSpAtk(int change);
		public void changeSpDef(int change);
		public void changeSpeed(int change);
		public void changeHP(int damage);
		public void changeWeight(double newWeight);
		
		public void resetHP();
		public void resetAtk();
		public void resetDef();
		public void resetSpAtk();
		public void resetSpDef();
		public void resetSpeed();
		
		//void setAbility(Ability newAbility){ ability = newAbility;}
		void setMove(Move newMove, int moveNum);
		void setType(Type newType, int typeNum);

		public double getIndex();
		public String getName();
		public int getHP();
		public int getBaseHP();
		public int getAtk();
		public int getBaseAtk();
		public int getDef();
		public int getBaseDef();
		public int getSpAtk();
		public int getBaseSpAtk();
		public int getSpDef();
		public int getBaseSpDef();
		public int getSpeed();
		public int getBaseSpeed();
		public double getWeight();
		public Type getType1();
		public Type getType2();
		public Gender getGender();
		public int getAtkModifier();
		public int getDefModifier();
		public int getSpAtkModifier();
		public int getSpDefModifier();
		public int getSpeedModifier();
		public int getLevel();
		
		public void addHPChangeEvent(IAbility a);
		public void removeHPChangeEvent(IAbility a);
		public void onHPChange();
		public void addStatisticChangeEvent(IAbility a);
		public void removeStatisticChangeEvent(IAbility a);
		public void onStatisticChange();
		public void addEntryEvent(IAbility a);
		public void removeEntryEvent(IAbility a);
		public void onEntry();
		public void addExitEvent(IAbility a);
		public void removeExitEvent(IAbility a);
		public void onExit();
		public void addPreDamageEvent(IAbility a);
		public void removePreDamageEvent(IAbility a);
		public void onPreDamage();
		public void addPostDamageEvent(IAbility a);
		public void removePostDamageEvent(IAbility a);
		public void onPostDamage();
		public void addPreAttackEvent(IAbility a);
		public void removePreAttackEvent(IAbility a);
		public void onPreAttack();
		public void addContinuousEvent(IAbility a);
		public void removeContinuousEvent(IAbility a);
		public void onContinuous();
		public void addStatusChangeEvent(IAbility a);
		public void removeStatusChangeEvent(IAbility a);
		public void onStatusChange();
		public void addKOEvent(IAbility a);
		public void removeKOEvent(IAbility a);
		public void onKO();
		public void addWeatherEvent(IAbility a);
		public void removeWeatherEvent(IAbility a);
		public void onWeather();
		
		
		
}
