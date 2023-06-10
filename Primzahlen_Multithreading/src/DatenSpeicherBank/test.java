package DatenSpeicherBank;

	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.io.RandomAccessFile;

	public class test {

	    public static void main(String[] args) {
	        String filePath = "output_100.txt";
	        String lastLine = readLastLine(filePath);
	        System.out.println(lastLine);
	    }

	    private static String readLastLine(String filePath) {
	        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
	            long fileLength = file.length();
	            if (fileLength == 0) {
	                return ""; // File is empty
	            }
	            long filePointer = fileLength - 1;

	            StringBuilder lastLine = new StringBuilder();

	            for (long pointer = filePointer; pointer >= 0; pointer--) {
	                file.seek(pointer);
	                int currentByte = file.readByte();

	                if (currentByte == '\n' && lastLine.length() > 0) {
	                    return lastLine.reverse().toString();
	                } else if (currentByte != '\r') {
	                    lastLine.append((char) currentByte);
	                }
	            }
	            return lastLine.reverse().toString();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return ""; // Error occurred while reading the file
	    }
	}

