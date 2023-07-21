package bankautomat.model;

import java.util.List;

public class UserKonto
{
	private String userLogin;
	private char[] userPassword;
	private long kontostand;
	private List<String> kontoAuszug;
	
	public UserKonto(String userLogin, char[] userPassword)
	{
		this.userLogin = userLogin;
		this.userPassword = userPassword;
	}
	
	public String getUserLogin()
	{
		return userLogin;
	}
	
	public void setUserLogin(String userLogin)
	{
		this.userLogin = userLogin;
	}
	
	public char[] getUserPassword()
	{
		return userPassword;
	}
	
	public void setUserPassword(char[] userPassword)
	{
		this.userPassword = userPassword;
	}
	
	public long getKontostand()
	{
		return kontostand;
	}
	
	public void setKontostand(long kontostand)
	{
		this.kontostand = kontostand;
	}
	
	public List<String> getKontoAuszug()
	{
		return kontoAuszug;
	}
	
	public void setKontoAuszug(List<String> kontoAuszug)
	{
		this.kontoAuszug = kontoAuszug;
	}
	
	public void addKontoAuszugEintrag(String eintrag)
	{
		this.kontoAuszug.add(eintrag);
	}
}
