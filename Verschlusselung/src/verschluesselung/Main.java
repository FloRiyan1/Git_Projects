package verschluesselung;

import verschluesselung.gui.*;

public class Main {

	public static void main(String[] args) {

		View gui = new View();
		Tool tool = new Tool(gui);
		
		//TODO das man den schlüssel  kopieren und einfügen kann um andere / Ältere Daten wiederherzustellen
		
		gui.updateGui();
		tool.connectToGui();
		tool.updateGui();
	}

}
