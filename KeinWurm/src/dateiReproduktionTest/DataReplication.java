package dateiReproduktionTest;

import java.util.*;

public class DataReplication {
	
	   public static void main(String[] args) {
	        // Beispielverwendung:
	        DataStructure data = new DataStructure("", 0, "");
	        List<String> names = new ArrayList<>();
	        names.add("Alice");
	        names.add("Bob");
	        names.add("Charlie");
	        
	        List<DataStructure> replicatedData = replicateData(data, names);
	        
	        for (DataStructure version : replicatedData) {
	            System.out.println(version);
	        }
	   }
	   
	   public static List<DataStructure> replicateData(DataStructure data, List<String> names) {
	        List<DataStructure> versions = new ArrayList<>();
	        
	        for (String name : names) {
	            DataStructure version = new DataStructure(data.getName(), data.getAge(), data.getCity());
	            version.setName(name);
	            versions.add(version);
	        }
	        
	        return versions;
	    }
}
