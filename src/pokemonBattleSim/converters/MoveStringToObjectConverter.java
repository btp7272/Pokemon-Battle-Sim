package pokemonBattleSim.converters;

import java.lang.reflect.Field;

import pokemonBattleSim.models.MoveList;
import pokemonBattleSim.types.Move;

public class MoveStringToObjectConverter {

	static MoveList list = new MoveList();
	public static Move convert (String name)
	{
		Move move = null;
		try {
			Class<?> c = list.getClass();
			Field m = c.getDeclaredField(name);
			m.setAccessible(true);
			move = (Move) m.get(list);
		} catch (NoSuchFieldException e) {
			System.err.println(e);
	    } catch (SecurityException e) {
	    	System.err.println(e);
	    } catch (IllegalAccessException e) {
	    	System.err.println(e);
	    }
		return move;
	}

}
