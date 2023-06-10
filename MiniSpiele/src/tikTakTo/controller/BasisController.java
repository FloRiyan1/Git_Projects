package tikTakTo.controller;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import tikTakTo.View.BasisView;

public class BasisController {

	private static BasisController instance;
	public static BasisController getInstance(BasisView gui)
	{
		if(instance == null)
		{
			instance = new BasisController(gui);
		}
		return instance;
	}
	
	private BasisView gui;
	
	private BasisController(BasisView gui)
	{
		this.gui = gui;
	}
	
	public void connectToGUI()
	{
		this.gui.btnUpperRight.addActionListener((ActionEvent e) -> handelButtonClicked(e));
		this.gui.btnUpper.addActionListener((ActionEvent e) -> handelButtonClicked(e));
		this.gui.btnUpperLeft.addActionListener((ActionEvent e) -> handelButtonClicked(e));
		this.gui.btnMiddelRight.addActionListener((ActionEvent e) -> handelButtonClicked(e));
		this.gui.btnMiddel.addActionListener((ActionEvent e) -> handelButtonClicked(e));
		this.gui.btnMiddelLeft.addActionListener((ActionEvent e) -> handelButtonClicked(e));
		this.gui.btnBottomRight.addActionListener((ActionEvent e) -> handelButtonClicked(e));
		this.gui.btnBottom.addActionListener((ActionEvent e) -> handelButtonClicked(e));
		this.gui.btnBottomLeft.addActionListener((ActionEvent e) -> handelButtonClicked(e));
	}

	private void handelButtonClicked(ActionEvent e) {
		// TODO Auto-generated method stub

		switch (((JButton) e.getSource()).getName()) {
		case "Oben Rechts":
			System.out.println("Oben Rechts");
			break;
		case "Oben":
			
			System.out.println("Oben ");
			break;
		case "Oben Links":
			
			System.out.println("Oben Links");
			break;
		case "Mitte Rechts":
			
			System.out.println("Mitte Rechts");
			break;
		case "Mitte":
			
			System.out.println("Mitte");
			break;
		case "Mitte Links":
			
			System.out.println("Mitte Links");
			break;
		case "Unten Rechts":
			
			System.out.println("Unten Rechts");
			break;
		case "Unten":
			
			System.out.println("Unten");
			break;
		case "Unten Links":
			
			System.out.println("Unten Links");
			break;

		default:
			break;
		}
	}
}
