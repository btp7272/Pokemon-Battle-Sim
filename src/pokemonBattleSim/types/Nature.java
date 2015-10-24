package pokemonBattleSim.types;

public enum Nature {
	Adamant(0, "Attack", "SpAtk"),
	Bashful(1, "SpAtk", "SpAtk"),
	Bold(2, "Defense", "Attack"),
	Brave(3, "Attack","Speed"),
	Calm(4,"SpDef", "Attack"),
	Careful(5, "SpDef", "SpAtk"),
	Docile(6, "Defense", "Defense"),
	Gentle(7, "SpDef", "Defense"),
	Hardy(8, "Attack", "Attack"),
	Hasty(9, "Speed", "Defense"),
	Impish(10, "Defense", "SpAtk"),
	Jolly(11, "Speed", "SpAtk"),
	Lax(12, "Defense", "SpDef"),
	Lonely(13, "Attack", "Defense"),
	Mild(14, "SpAtk", "Defense"),
	Modest(15, "SpAtk", "Attack"),
	Naive(16, "Speed", "SpDef"),
	Naughty(17, "Attack", "SpDef"),
	Quiet(18, "SpAtk", "Speed"),
	Quirky(19, "SpDef", "SpDef"),
	Rash(20, "SpAtk", "SpDef"),
	Relaxed(21, "Defense", "Speed"),
	Sassy(22, "SpDef", "Speed"),
	Serious(23, "Speed", "Speed"),
	Timid(24, "Speed", "Attack");

	private final int mask;
	private final String increase;
	private final String decrease;
	Nature(int mask, String incr, String decr)
	{
		this.mask = mask;
		this.increase = incr;
		this.decrease = decr;
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
		//error
		return -1;
	}
}
