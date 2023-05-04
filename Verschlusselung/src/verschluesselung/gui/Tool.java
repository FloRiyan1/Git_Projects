package verschluesselung.gui;

import java.awt.Color;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.security.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.util.ArrayList;
import java.util.List;

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
	private String entschluesseltString;

	public Tool(View gui)
	{
		this.gui = gui;
		keyService = new KeyServiceImpl();
		verschluesselungsService = new VerschluesselungsServiceImpl(keyService);
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
		this.gui.btnEntschluesselDatein.addActionListener(e -> decryptFile());
		this.gui.btnVerschluesselDatein.addActionListener(e -> encryptFile());
		this.gui.btnExport.addActionListener(e -> exportDecrypted());
		this.gui.btnImport.addActionListener(e -> importDecrypted());
	}
	
	private void exportDecrypted() 
	{
		String key = this.gui.txtPrivateKey.getText().replace("\n", "");
		String Text = this.gui.txtVerschluesselt.getText();
		
		writeCSV(Text, key);
		
		
	}

	private void importDecrypted() {
		String decryptetText = null;
		String key = null;
		
		try 
		{
			List<String[]> inhalt = readCsvFile();
			for (String[] strings : inhalt) 
			{
				decryptetText = strings[0];
				key = insertLineBreaks(strings[1]);
			}
			
			this.privateKeyString = key;
			this.verschluesseltString = decryptetText;
			
			this.gui.txtPrivateKey.setText(key);
			this.gui.txtVerschluesselt.setText(decryptetText);
			
			decrypt();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void decrypt() 
	{
		try 
		{
			this.privateKeyString = this.gui.txtPrivateKey.getText().replace("\n", "");
			this.entschluesseltString = verschluesselungsService.decrypt(this.gui.txtVerschluesselt.getText(), privateKeyString);
			this.gui.txtEntschluesselt.setText(entschluesseltString);
			this.gui.txtPrivateKey.setBackground(gui.txtVerschluesselt.getBackground());
			this.gui.txtPrivateKey.setToolTipText("");
		}
		catch (Exception e) 
		{
			this.gui.txtPrivateKey.setBackground(Color.RED);
			this.gui.txtPrivateKey.setToolTipText("Falscher Schlüssel");
		}
	}

	private void encrypt() 
	{
		try 
		{
			this.privateKeyString = this.gui.txtPrivateKey.getText().replace("\n", "");
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
	
    private void writeCSV(String string1, String string2) 
    {
        try (FileWriter writer = new FileWriter(chooseFilePath("CSV File", ".csv"))) 
        {
            writer.append(string1)
                  .append(";")
                  .append(string2);
        }
        catch (IOException e) 
        {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }
    
    public List<String[]> readCsvFile() throws IOException 
    {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(chooseFilePath("CSV File", ".csv")))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] row = line.split(";");
                data.add(row);
            }
        }
        return data;
    }

    public String chooseFilePath(String anzeige, String filter) 
    {
        JFileChooser fileChooser = new JFileChooser();
        if(filter != null)
        {
        	FileNameExtensionFilter filterext = new FileNameExtensionFilter(anzeige, filter);
        	fileChooser.setFileFilter(filterext);
        }
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) 
        {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        }
        return null;
    }

    //##############################################
    //##############################################
    //##############################################
    //##############################################
    //##############################################
    
    private void decryptFile() 
    {
    	try {
    		fileDecrypt(new File(chooseFilePath(null, null)), new File(chooseFilePath("Irgendein File:", "Alle Datein")), privateKeyString);
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	//TODO
    }
    
//    private void encryptFile()
//    {
//    	try {
//    		fileEncrypt(new File(chooseFilePath(null, null)), new File(chooseFilePath("Irgendein File:", "Alle Datein")), privateKeyString);
//    	} catch (Exception e) {
//    		// TODO Auto-generated catch block
//    		e.printStackTrace();
//    	}
//    	//TODO
//    }

    // Verschlüsseln der Datei
    public void fileEncrypt(File inputFile, File outputFile, String key) throws Exception {
        Key secretKey = new SecretKeySpec(keyService.stringToByteArray(key), "DESede");
        Cipher cipher = Cipher.getInstance("DESede");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        
        FileInputStream inputStream = new FileInputStream(inputFile);
        byte[] inputBytes = new byte[(int) inputFile.length()];
        inputStream.read(inputBytes);
        
        byte[] outputBytes = cipher.doFinal(inputBytes);
        
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(outputBytes);
        
        inputStream.close();
        outputStream.close();
    }
    
    // Entschlüsseln der Datei
    public void fileDecrypt(File inputFile, File outputFile, String key) throws Exception {
        Key secretKey = new SecretKeySpec(keyService.stringToByteArray(key), "DESede");
        Cipher cipher = Cipher.getInstance("DESede");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        
        FileInputStream inputStream = new FileInputStream(inputFile);
        byte[] inputBytes = new byte[(int) inputFile.length()];
        inputStream.read(inputBytes);
        
        byte[] outputBytes = cipher.doFinal(inputBytes);
        
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(outputBytes);
        
        inputStream.close();
        outputStream.close();
    }
    


private void encryptFile()
{
    try {
        File inputFile = new File(chooseFilePath(null, null));
        File outputFile = new File(chooseFilePath("Irgendein File:", "Alle Datein"));
        String key = this.gui.txtPrivateKey.getText().replace("\n", "");
        String extension = getFileExtension(inputFile);
        String keyFileName = "D:/key.txt";
        String extensionFileName = "D:/extension.txt";
        
        fileEncrypt(inputFile, outputFile, key);
        writeToFile(keyFileName, key);
        writeToFile(extensionFileName, extension);
        System.out.println("Die Datei wurde verschlüsselt und in '" + outputFile.getName() + "' gespeichert.");
        System.out.println("Der Schlüssel wurde in '" + keyFileName + "' gespeichert.");
        System.out.println("Die Dateierweiterung wurde in '" + extensionFileName + "' gespeichert.");
    } catch (Exception e) {
        e.printStackTrace();
    }
	}

	private String getFileExtension(File file) {
		String fileName = file.getName();
		int dotIndex = fileName.lastIndexOf('.');
		if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
			return fileName.substring(dotIndex + 1).toLowerCase();
		} else {
			return "";
		}
	}

	private void writeToFile(String fileName, String content) {
		try {
			FileWriter writer = new FileWriter(fileName);
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
