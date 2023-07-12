package tikTakTo.model;

import java.util.List;

public class BasisModel {

	private boolean playerOne;
	private int btnUpperRightUsed;
	private int btnUpperUsed;
	private int btnUpperLeftUsed;
	private int btnMiddelRightUsed;
	private int btnMiddelUsed;
	private int btnMiddelLeftUsed;
	private int btnBottomRightUsed;
	private int btnBottomUsed;
	private int btnBottomLeftUsed;
	
	public BasisModel(int btnUpperRightUsed, int btnUpperUsed, int btnUpperLeftUsed, int btnMiddelRightUsed,
			int btnMiddelUsed, int btnMiddelLeftUsed, int btnBottomRightUsed, int btnBottomUsed,
			int btnBottomLeftUsed) 
	{
		super();
		this.playerOne = true;
		this.btnUpperRightUsed = btnUpperRightUsed;
		this.btnUpperUsed = btnUpperUsed;
		this.btnUpperLeftUsed = btnUpperLeftUsed;
		this.btnMiddelRightUsed = btnMiddelRightUsed;
		this.btnMiddelUsed = btnMiddelUsed;
		this.btnMiddelLeftUsed = btnMiddelLeftUsed;
		this.btnBottomRightUsed = btnBottomRightUsed;
		this.btnBottomUsed = btnBottomUsed;
		this.btnBottomLeftUsed = btnBottomLeftUsed;
	}
	
	public int getBtnUpperRightUsed() 
	{
		return btnUpperRightUsed;
	}
	
	public void setBtnUpperRightUsed(int btnUpperRightUsed) 
	{
		this.btnUpperRightUsed = btnUpperRightUsed;
	}
	
	public int getBtnUpperUsed() 
	{
		return btnUpperUsed;
	}
	
	public void setBtnUpperUsed(int btnUpperUsed) 
	{
		this.btnUpperUsed = btnUpperUsed;
	}
	
	public int getBtnUpperLeftUsed() 
	{
		return btnUpperLeftUsed;
	}
	
	public void setBtnUpperLeftUsed(int btnUpperLeftUsed) 
	{
		this.btnUpperLeftUsed = btnUpperLeftUsed;
	}
	
	public int getBtnMiddelRightUsed() 
	{
		return btnMiddelRightUsed;
	}
	
	public void setBtnMiddelRightUsed(int btnMiddelRightUsed)
	{
		this.btnMiddelRightUsed = btnMiddelRightUsed;
	}
	
	public int getBtnMiddelUsed() 
	{
		return btnMiddelUsed;
	}
	
	public void setBtnMiddelUsed(int btnMiddelUsed) 
	{
		this.btnMiddelUsed = btnMiddelUsed;
	}
	
	public int getBtnMiddelLeftUsed() 
	{
		return btnMiddelLeftUsed;
	}
	
	public void setBtnMiddelLeftUsed(int btnMiddelLeftUsed) 
	{
		this.btnMiddelLeftUsed = btnMiddelLeftUsed;
	}
	
	public int getBtnBottomRightUsed() 
	{
		return btnBottomRightUsed;
	}
	
	public void setBtnBottomRightUsed(int btnBottomRightUsed) 
	{
		this.btnBottomRightUsed = btnBottomRightUsed;
	}
	
	public int getBtnBottomUsed() 
	{
		return btnBottomUsed;
	}
	
	public void setBtnBottomUsed(int btnBottomUsed) 
	{
		this.btnBottomUsed = btnBottomUsed;
	}
	
	public int getBtnBottomLeftUsed() 
	{
		return btnBottomLeftUsed;
	}
	
	public void setBtnBottomLeftUsed(int btnBottomLeftUsed) 
	{
		this.btnBottomLeftUsed = btnBottomLeftUsed;
	}

	public boolean isPlayerOne()
	{
		return playerOne;
	}

	public void setPlayerOne(boolean playerOne)
	{
		this.playerOne = playerOne;
	}
	
	
}
