package pokemonBattleSim.types;

import pokemonBattleSim.models.SpeciesMap;


/*
 * This class is used to create an instance of a pokemon for the team builder
 */


public class PokemonInitializer implements IPokemonInitializer{
	private Species pokemon;
	private Move[] moves;
	
	public PokemonInitializer(String pokemonName, Move[] moves) 
	{
		// initialize and validate pokemon;
		this.pokemon = SpeciesMap.speciesMap.get(pokemonName);
		if (pokemon == null)
		{
			throw new IllegalArgumentException ("Pokemon name does not exist");
		}
		
		// initialize and validate moves
		this.moves = moves;
		if (moves.length != 6)
		{
			throw new IllegalArgumentException ("Pokemon must be given 6 moves");
		}
		for (Move move : moves)
		{
			if ( move == null )
			{
				throw new IllegalArgumentException ("Pokemon may not have have a NULL move");
			}
		}
	}

	@Override
	public IPokemon getPokemon() {
		int[] IVs = {2,2,2,2,2,2};
		int[] EVs = {1,1,1,1,1,1};
		int level = 100;
		Nature nature = Nature.Timid;
		return new Pokemon(SpeciesMap.speciesMap.get(this.pokemon.getName()), "nickname", moves, IVs, EVs, level, nature, new AbilityContainer("None"), new ItemContainer("None"));
	}

}
