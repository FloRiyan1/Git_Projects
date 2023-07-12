package worm;

public class main {

	public static void main(String[] args)
	{
		 String startDirectory = "D://Test1"; // Das Startverzeichnis, von dem aus der Wurm startet
		 Worm worm = new Worm();
	     worm.startWurm(startDirectory);
	     System.out.println("Wurm ausgeführt!");
	}

}
