package pokemonBattleSim.services.moveProvider;

import pokemonBattleSim.types.Move;

public interface IMoveRequestProvider {
	public void requestMove( Move move );
	public boolean requestedMoveReady ();
	public Move getRequestedMove ();
}
