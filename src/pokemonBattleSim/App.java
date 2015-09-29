package pokemonBattleSim;

import pokemonBattleSim.controllers.BattleController;
import pokemonBattleSim.models.BattleModel;
import pokemonBattleSim.views.BattleView;

public class App {
	public static void main (String[] args)
	{
		// This is the main entry point to the program, will use other classes
		BattleView view = new BattleView();
		BattleModel model = new BattleModel();
		BattleController controller = new BattleController(view,model);
		
		view.setVisible(true);
	}
}
