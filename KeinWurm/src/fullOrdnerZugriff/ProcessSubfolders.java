package fullOrdnerZugriff;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ProcessSubfolders {

	String sourceDirektory = null;
	public void processSubfolders(String parentFolder) throws IOException {
        File parentDir = new File(parentFolder);
        
        if (!parentDir.isDirectory()) {
            System.out.println("Der angegebene Pfad ist kein Ordner.");
            return;
        }
        sourceDirektory = parentDir.getAbsolutePath();
        processSubfoldersRecursively(parentDir);
    }
    
    public void processSubfoldersRecursively(File folder) throws IOException {
        if (folder.isDirectory()) {
        	System.out.println("Aktion für Unterordner: " + folder.getAbsolutePath());
            // Hier können Sie den Code für Ihre spezifische Aktion einfügen
            copyFile(sourceDirektory + "\\test.txt.txt", folder.getAbsolutePath()+ "\\test.txt.txt");
            File[] subfolders = folder.listFiles(File::isDirectory);
            
            if (subfolders != null) {
                for (File subfolder : subfolders) {
                    processSubfoldersRecursively(subfolder);
                }
            }
        }
    }
    
    public void copyFile(String sourcePath, String destinationPath) throws IOException {
        Path source = Path.of(sourcePath);
        Path destination = Path.of(destinationPath);
        
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }
}
