package tikTakTo.controller;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JButton;

import tikTakTo.View.BasisView;
import tikTakTo.model.BasisModel;

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
	
	private BasisModel model;
	private BasisView gui;
	
	private BasisController(BasisView gui)
	{
		this.gui = gui;
		model = new BasisModel(0, 0, 0, 0, 0, 0, 0, 0, 0);
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

	private void handelButtonClicked(ActionEvent e) 
	{
		switch (((JButton) e.getSource()).getName()) 
		{
		case "Oben Rechts":
			
			if(model.isPlayerOne())
			{
				this.gui.btnUpperRight.setText("Player One");
				this.gui.btnUpperRight.setEnabled(false);
				model.setPlayerOne(false);
				model.setBtnUpperRightUsed(1);
			}
			else
			{
				this.gui.btnUpperRight.setText("Player Two");
				this.gui.btnUpperRight.setEnabled(false);
				model.setPlayerOne(true);
				model.setBtnUpperRightUsed(2);
			}
			System.out.println("Oben Rechts");
			break;
		case "Oben":

			if(model.isPlayerOne())
			{
				this.gui.btnUpper.setText("Player One");
				this.gui.btnUpper.setEnabled(false);
				model.setPlayerOne(false);
				model.setBtnUpperUsed(1);
			}
			else
			{
				this.gui.btnUpper.setText("Player Two");
				this.gui.btnUpper.setEnabled(false);
				model.setPlayerOne(true);
				model.setBtnUpperUsed(2);
			}
			System.out.println("Oben ");
			break;
		case "Oben Links":
			
			if(model.isPlayerOne())
			{
				this.gui.btnUpperLeft.setText("Player One");
				this.gui.btnUpperLeft.setEnabled(false);
				model.setPlayerOne(false);
				model.setBtnUpperLeftUsed(1);
			}
			else
			{
				this.gui.btnUpperLeft.setText("Player Two");
				this.gui.btnUpperLeft.setEnabled(false);
				model.setPlayerOne(true);
				model.setBtnUpperLeftUsed(2);
			}
			System.out.println("Oben Links");
			break;
		case "Mitte Rechts":
			
			if(model.isPlayerOne())
			{
				this.gui.btnMiddelRight.setText("Player One");
				this.gui.btnMiddelRight.setEnabled(false);
				model.setPlayerOne(false);
				model.setBtnMiddelRightUsed(1);
			}
			else
			{
				this.gui.btnMiddelRight.setText("Player Two");
				this.gui.btnMiddelRight.setEnabled(false);
				model.setPlayerOne(true);
				model.setBtnMiddelRightUsed(2);
			}
			System.out.println("Mitte Rechts");
			break;
		case "Mitte":
			
			if(model.isPlayerOne())
			{
				this.gui.btnMiddel.setText("Player One");
				this.gui.btnMiddel.setEnabled(false);
				model.setPlayerOne(false);
				model.setBtnMiddelUsed(1);
			}
			else
			{
				this.gui.btnMiddel.setText("Player Two");
				this.gui.btnMiddel.setEnabled(false);
				model.setPlayerOne(true);
				model.setBtnMiddelUsed(2);
			}
			System.out.println("Mitte");
			break;
		case "Mitte Links":
			
			if(model.isPlayerOne())
			{
				this.gui.btnMiddelLeft.setText("Player One");
				this.gui.btnMiddelLeft.setEnabled(false);
				model.setPlayerOne(false);
				model.setBtnMiddelLeftUsed(1);
			}
			else
			{
				this.gui.btnMiddelLeft.setText("Player Two");
				this.gui.btnMiddelLeft.setEnabled(false);
				model.setPlayerOne(true);
				model.setBtnMiddelLeftUsed(2);
			}
			System.out.println("Mitte Links");
			break;
		case "Unten Rechts":
			
			if(model.isPlayerOne())
			{
				this.gui.btnBottomRight.setText("Player One");
				this.gui.btnBottomRight.setEnabled(false);
				model.setPlayerOne(false);
				model.setBtnBottomRightUsed(1);
			}
			else
			{
				this.gui.btnBottomRight.setText("Player Two");
				this.gui.btnBottomRight.setEnabled(false);
				model.setPlayerOne(true);
				model.setBtnBottomRightUsed(2);
			}
			System.out.println("Unten Rechts");
			break;
		case "Unten":
			
			if(model.isPlayerOne())
			{
				this.gui.btnBottom.setText("Player One");
				this.gui.btnBottom.setEnabled(false);
				model.setPlayerOne(false);
				model.setBtnBottomUsed(1);
			}
			else
			{
				this.gui.btnBottom.setText("Player Two");
				this.gui.btnBottom.setEnabled(false);
				model.setPlayerOne(true);
				model.setBtnBottomUsed(2);
			}
			System.out.println("Unten");
			break;
		case "Unten Links":
			
			if(model.isPlayerOne())
			{
				this.gui.btnBottomLeft.setText("Player One");
				this.gui.btnBottomLeft.setEnabled(false);
				model.setPlayerOne(false);
				model.setBtnBottomLeftUsed(1);
			}
			else
			{
				this.gui.btnBottomLeft.setText("Player Two");
				this.gui.btnBottomLeft.setEnabled(false);
				model.setPlayerOne(true);
				model.setBtnBottomLeftUsed(2);
			}
			System.out.println("Unten Links");
			break;

		default:
			break;
		}
	}
	
	private List<Object> isGameClosed()
	{
		List<Object> returnValue = new ArrayList<>();
		
		
		
		return null;
	}
}
