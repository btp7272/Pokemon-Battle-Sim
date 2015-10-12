package pokemonBattleSim.services.swapProvider;

import pokemonBattleSim.types.Pokemon;

public interface ISwapRequestProvider {

	public void requestSwap( Pokemon activePokemon, Pokemon inactivePokemon );
	public boolean requestedSwapReady ();
	public Pokemon getRequestedSwapPokemon ();
}
