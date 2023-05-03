package verschluesselung.gui;

import javax.swing.JTextArea;

import java.util.*;

import verschluesselung.service.KeyServiceImpl;
import verschluesselung.service.VerschluesselungsServiceImpl;

public class Tool 
{
	private View gui;
	private String verschluesseltString;
	private String publicKeyString;
	private String privateKeyString;
	
	private VerschluesselungsServiceImpl verschluesselungsService;
	private KeyServiceImpl keyService;
	private List<JTextArea> textAreas;
	private String entschluesseltString;

	public Tool(View gui)
	{
		this.gui = gui;
		keyService = new KeyServiceImpl();
		verschluesselungsService = new VerschluesselungsServiceImpl(keyService);
		textAreas = new ArrayList<>();
		textAreas.add(this.gui.txtEntschluesselt);
		textAreas.add(this.gui.txtPrivateKey);
		textAreas.add(this.gui.txtPublicKey);
		textAreas.add(this.gui.txtVerschluesselt);
		try 
		{
			privateKeyString = keyService.getPrivateKeyDes();
			publicKeyString = keyService.getPublicKeyDes();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
	
	public void connectToGui()
	{
		setLabelText();
		
		this.gui.decryptButton.addActionListener(e -> decrypt());
		this.gui.encryptButton.addActionListener(e -> encrypt());
	}
	
	private void decrypt() 
	{
		try 
		{
			this.entschluesseltString = verschluesselungsService.decrypt(this.gui.txtVerschluesselt.getText(), privateKeyString);
			this.gui.txtEntschluesselt.setText(entschluesseltString);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private void encrypt() 
	{
		try 
		{
			this.verschluesseltString = verschluesselungsService.encrypt(this.gui.txtEntschluesselt.getText(), privateKeyString);
			this.gui.txtVerschluesselt.setText(verschluesseltString);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void updateGui()
	{
		this.gui.txtPrivateKey.setText(insertLineBreaks(privateKeyString));
		this.gui.txtPublicKey.setText(insertLineBreaks(publicKeyString));
		this.gui.txtVerschluesselt.setText(verschluesseltString);
	}

	public String insertLineBreaks(String text) {
		
		text = text.replace("\n", "");
		StringBuilder builder = new StringBuilder(text);
	    int i = 0;
	    while (i + 8 < builder.length()) {
	        i += 8;
	        builder.insert(i, "\n");
	        i++;
	    }
	    return builder.toString();
	}
	
	private void setLabelText() 
	{
		this.gui.lblEingabe.setText("Zu Verschlüsselnder Text:");
		this.gui.lblPrivateKey.setText("PrivateKey:");
		this.gui.lblPublicKey.setText("Public Key:");
		this.gui.lblVerschluesseld.setText("Verschlüsselter text:");
	}

	public String getPublicKeyString() {
		return publicKeyString;
	}

	public void setPublicKeyString(String publicKeyString) {
		this.publicKeyString = publicKeyString;
	}

	public String getPrivateKeyString() {
		return privateKeyString;
	}

	public void setPrivateKeyString(String privateKeyString) {
		this.privateKeyString = privateKeyString;
	}
	
	
}
