package Prim;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;

public class SavePrimeNumbers 
{
	private static final int numThreads = 64;
	
	private static long iterationsPerThread = 1_000_000;
    private static long doneIterations = 72_473_600_989L;
    static List<LocalDateTime> timeList = new ArrayList<>();
    static List<Long> durationList = new ArrayList<>();
    
	public static void main (String[] args)
	{
        System.out.println(LocalDateTime.now() + " start");
        while (doneIterations < 100_000_000_000_000L) 
        {
        	doneIterations = threadSachen();	
        	timeList.add(LocalDateTime.now());
        	getTimeInfo();
        	copyToOneFileAndDeleteOther();
        }
	}	
	
	private static void getTimeInfo() 
	{
		System.out.println(sekUmrechnen(zeitInfo()) + " Sekunden dauer");		
	}

	public static long threadSachen()
	{
		Thread[] threads = new Thread[numThreads];
        long end = 0;

        for (int i = 0; i < numThreads; i++) {
            long start = i * iterationsPerThread + 1 + doneIterations;
            end = start + iterationsPerThread;
            String fileName = "output_" + i + ".txt";
            threads[i] = new PrimeThread(start, end, i, fileName);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

        return end;
	}
	
	private static void copyFile(String sourceFile, String targetFile) {
	    try {
	        byte[] sourceData = Files.readAllBytes(Path.of(sourceFile));
	        Files.write(Path.of(targetFile), sourceData, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	private static void copyToOneFileAndDeleteOther() {
	    for (int i = 0; i < numThreads; i++) {
	        String fileName = "output_" + i + ".txt";
	        copyFile(fileName, "output_100.txt");
	        try {
	            Files.delete(Path.of(fileName));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	private static double zeitInfo() {
	    long now = System.currentTimeMillis();
	    timeList.add(timeList.size() - 1, LocalDateTime.ofInstant(Instant.ofEpochMilli(now), ZoneId.systemDefault()));

	    int length = timeList.size();
	    for (int i = 1; i < length; i++) {
	        durationList.add(timeList.get(i).toEpochSecond(ZoneOffset.UTC) - timeList.get(i - 1).toEpochSecond(ZoneOffset.UTC));
	    }

	    long sumDuration = 0;
	    for (long duration : durationList) {
	        sumDuration += duration;
	    }
	    length = durationList.size();

	    return (double) sumDuration / length / 1000;
	}

	private static String sekUmrechnen(double totalSeconds) {
	    int secondsPerDay = 86400;
	    int totalSecondsInt = (int) totalSeconds;

	    if (totalSecondsInt > 1) {
	        int elapsedSeconds = totalSecondsInt % secondsPerDay;

	        int hours = elapsedSeconds / 3600;
	        int minutes = (elapsedSeconds % 3600) / 60;
	        int seconds = (elapsedSeconds % 3600) % 60;

	        return String.format("Uhrzeit: %02d:%02d:%02d", hours, minutes, seconds);
	    }

	    return String.valueOf(totalSeconds);
	}


	
}
