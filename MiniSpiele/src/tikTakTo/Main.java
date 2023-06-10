package tikTakTo;

import tikTakTo.View.BasisView;
import tikTakTo.controller.BasisController;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasisView gui = BasisView.getInstance();
		gui.initGUI();
		BasisController controller = BasisController.getInstance(gui);
		controller.connectToGUI();
	}

}
