package woFi.srctest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Test;

import woFi.service.FileEncryptionService;

public class FileEncryptionServiceTest {

	private File file = null;
	private File encryptetFile = null;

	@After
	public void tearDown()
	{
		if(file != null)
		{
			file.delete();
		}
		
		if(encryptetFile != null)
		{
			encryptetFile.delete();
		}
	}
	
	@Test
	public void testEncryption() throws Exception
	{
		FileEncryptionService service = new FileEncryptionService();
		String pfad = "D:\\Git_Projects\\WoFi\\test.txt";
		file = new File(pfad);
		
		if(!file.exists())
		{
			file.createNewFile();
		}
		assertThat(file.getAbsolutePath(), is("D:\\Git_Projects\\WoFi\\test.txt"));
		
		String content = "Test des Schreibens zur verschlüsselung";
		writeToFile(file, content);
		
		String key = "MySecretKey12345";
		file.getPath();		
		encryptetFile = new File(Paths.get(file.getAbsolutePath()).getFileName() + ".enc");
		service.encryptFile(file, encryptetFile, key);
		
		assertThat(file.getAbsolutePath(), is(pfad));

		String encryptedContent = readFromFile(encryptetFile);
		
		assertThat(encryptedContent, not(is(content)));
		
		service.decryptFile(encryptetFile, file, key);
		String decryptedContent = readFromFile(file);
		
		assertThat(decryptedContent, is(content));
		
		
	}

	private void writeToFile(File file, String content)
	{
		  try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	            writer.write(content);
	        } catch (IOException e) {
	        	//NIX
	        }
	}
	
	private String readFromFile(File file)
	{
StringBuilder content = new StringBuilder();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
        	//NIX
        }
        
        return content.toString();
	}
	
}
