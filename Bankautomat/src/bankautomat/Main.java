package bankautomat;

import bankautomat.view.*;
import bankautomat.model.*;
import bankautomat.controller.*;
import bankautomat.service.*;

public class Main
{

	public static void main(String[] args)
	{
		LoginGui login = new LoginGui();
		login.initGui();
	}

}
