package fullOrdnerZugriff;

import java.io.IOException;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProcessSubfolders subFoolder = new ProcessSubfolders();
		try {
			subFoolder.processSubfolders("D:/Test1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
