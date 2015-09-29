/*
 * !!IMPORTANT: MUST CHANGE IMPLEMENTATION!!
 * Reflection should NOT be used in any builds after demo 0
 */

package pokemonBattleSim.converters;

import java.lang.reflect.Field;

import pokemonBattleSim.models.PokemonList;
import pokemonBattleSim.types.Pokemon;

// should implement an interface, but that can be done later
public class PokemonStringToObjectConverter {

	static PokemonList list = new PokemonList();
	public static Pokemon convert (String name)
	{
		Pokemon pokemon = null;
		Class<?> c = list.getClass();
		try {
			Field p = c.getDeclaredField(name);
			p.setAccessible(true);
			pokemon = (Pokemon) p.get(list);
		} catch (NoSuchFieldException e) {
			System.err.println(e);
	    } catch (SecurityException e) {
	    	System.err.println(e);
	    } catch (IllegalAccessException e) {
	    	System.err.println(e);
	    }
		return pokemon;
	}

}
