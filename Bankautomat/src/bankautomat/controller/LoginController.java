package bankautomat.controller;

import java.awt.event.ActionEvent;

import bankautomat.view.LoginGui;

public class LoginController
{
	private static LoginController instance;
	
	public LoginController getInstance()
	{
		if(instance == null)
		{
			instance = new LoginController();
		}
		return instance;
	}
	
	private LoginController()
	{
		
	}
	
	public void connectToGui(LoginGui gui)
	{
		gui.btnBestaetigen.addActionListener((e) -> handleButtonClicked(e));
	}
	
	private void handleButtonClicked(ActionEvent e)
	{
		
	}
}
