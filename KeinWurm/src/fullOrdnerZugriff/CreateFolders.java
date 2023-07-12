package fullOrdnerZugriff;

import java.io.File;


public class CreateFolders {

	  public static void main(String[] args) {
	        // Beispielverwendung:
	        String parentFolder = "D:/Test1";
	        int numFolders = 10;
	        
	        createFolders(parentFolder, numFolders);
	    }
	    
	    public static void createFolders(String parentFolder, int numFolders) {
	        File parentDir = new File(parentFolder);
	        parentDir.mkdirs();
	        
	        for (int i = 1; i <= numFolders; i++) {
	            String folderName = "Ordner " + i;
	            String folderPath = parentFolder + File.separator + folderName;
	            
	            File folder = new File(folderPath);
	            folder.mkdirs();
	            
	            createSubfoldersRecursively(folder, i - 1);
	        }
	    }
	    
	    public static void createSubfoldersRecursively(File folder, int numSubfolders) {
	        if (numSubfolders <= 0) {
	            return;
	        }
	        
	        for (int i = 1; i <= numSubfolders; i++) {
	            String subfolderName = "Unterordner " + i;
	            String subfolderPath = folder.getAbsolutePath() + File.separator + subfolderName;
	            
	            File subfolder = new File(subfolderPath);
	            subfolder.mkdirs();
	            
	            createSubfoldersRecursively(subfolder, i - 1);
	        }
	    }
	
}
