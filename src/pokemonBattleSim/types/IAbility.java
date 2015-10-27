package pokemonBattleSim.types;

public interface IAbility 
{
	public int getPriority ();
	public void run (IPokemonTrainer source, IPokemonTrainer target, IBattleModel model);
}
