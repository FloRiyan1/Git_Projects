package Prim;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import DatenSpeicherBank.*;
import java.util.*;

public class GetLastNumber {

	public static void main(String[] args) {
        String filePath = "output_100.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            ZahlReiheDatenbank db = new ZahlReiheDatenbank("localhost/", "Primzahlen");
            List<Long> lines = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
            	if(Long.parseLong(line) > 0)
            	{
            		if(lines.size() > 1_000_000) 
            		{
            			db.addNumbers(lines);
            			lines.clear();            			
            		}
            		else
            		{
            			lines.add(Long.parseLong(line));
            			System.out.println(line);
            		}
            	}
            }
            
            long[] numbers = db.getNumbers();
            for (long number : numbers) {
            	System.out.println(number);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

