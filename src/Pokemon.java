
public class Pokemon {
	int indexNum;
	int hp;
	int atk;
	int def;
	int spAtk;
	int spDef;
	int speed;
	double weight;
	//Ability ability;
	//Move moveOne = null;
	//Move moveTwo = null;
	//Move moveThree = null;
	//Move moveFour = null;
	//Type typeOne = null;
	//Type typeTwo = null;
	//Gender gender = null;
	//heldItem item = null;
	
	private void setIndex(int index){ indexNum = index;}
	private void setHp(int health){	hp = health;}
	private void setAtk(int attack){ atk = attack;}
	private void setDef(int defense){ def = defense;}
	private void setSpAtk(int spattack){ spAtk = spattack;}
	private void setSpDef(int spdefense){ spDef = spdefense;}
	private void setSpeed(int newSpeed){ speed = newSpeed;}
	private void setWeight(double newWeight){ weight = newWeight;}
	//private void setAbility(Ability newAbility){ ability = newAbility;}
	private void setMove(Move newMove, int moveNum)
	{
		switch(moveNum)
		{
			case 1:
			{
				moveOne = newMove;
			}
			case 2:
			{
				moveTwo = newMove;
			}
			case 3:
			{
				moveThree = newMove;
			}
			case 4:
			{
				moveFour = newMove;
			}
		}
	}
}
