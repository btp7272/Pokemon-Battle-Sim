package pokemonBattleSim.types;

public enum Nature {
	Adamant(0, "Attack",	"SpAtk"),
	Bashful(1, "SpAtk", "SpAtk"),
	Bold(2, "Defense", "Attack"),
	Brave(3	Attack,"Speed"),
	Calm(4	SpDef	Attack"),
	Careful(5	SpDef	SpAtk"),
	Docile(6	Defense	Defense"),
	Gentle(7	SpDef	Defense"),
	Hardy	Attack	Attack"),
	Hasty	Speed	Defense"),
	Impish	Defense	SpAtk"),
	Jolly	Speed	SpAtk"),
	Lax	Defense	SpDef"),
	Lonely	Attack	Defense"),
	Mild	SpAtk	Defense"),
	Modest	SpAtk	Attack"),
	Naive	Speed	SpDef"),
	Naughty	Attack	SpDef"),
	Quiet	SpAtk	Speed"),
	Quirky	SpDef	SpDef"),
	Rash	SpAtk	SpDef"),
	Relaxed	Defense	Speed"),
	Sassy	SpDef	Speed"),
	Serious	Speed	Speed"),
	Timid	Speed	Attack")

	private final int mask;
	private final String increase;
	private final String decrease;
	Nature(int mask, String increase, String decrease)
	{
		this.mask=mask;
	}
	public int getMask()
	{
		return mask;
	}
	public String getIncrease()
	{
		return increase;
	}
	public String getDecrease()
	{
		return decrease;
	}
	
	/*
	 * Attack = 0 
	 * Defense = 1
	 * Special Attack = 2
	 * Special Defense = 3
	 * Speed = 4
	 */
	public int getType(String a)
	{
		switch(a)
		{
			case "Attack":
				return 0;
			case "Defense":
				return 1;
			case "SpAtk":
				return 2;
			case "SpDef":
				return 3;
			case "Speed":
				return 4;
		}
	}
}
