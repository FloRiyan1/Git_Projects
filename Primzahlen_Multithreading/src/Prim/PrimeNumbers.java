package Prim;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

public class PrimeNumbers {
    private static final int numThreads = 64;

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now() + " start");
        long iterationsPerThread = 100_000;
        long doneIterations = 71_513_601_001L;
        LocalDateTime[] timeList = {LocalDateTime.now()};
        long[] durationList = new long[timeList.length - 1];

        while (doneIterations < 100_000_000_000_000L) {
            doneIterations = threadSachen(iterationsPerThread, doneIterations);
            System.out.println(sekUmrechnen(zeitInfo(timeList, durationList)));
            copyToOneFileAndDeleteOther();
        }

        System.out.println(LocalDateTime.now());
    }

    private static long threadSachen(long iterationsPerThread, long doneIterations) {
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
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile, true))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyToOneFileAndDeleteOther() {
        for (int i = 0; i < numThreads; i++) {
            String fileName = "output_" + i + ".txt";
            copyFile(fileName, "output_100.txt");
            new File(fileName).delete();
        }
    }

    private static double zeitInfo(LocalDateTime[] timeList, long[] durationList) {
        LocalDateTime now = LocalDateTime.now();
        timeList[timeList.length - 1] = now;

        for (int i = 1; i < timeList.length; i++) {
            Duration duration = Duration.between(timeList[i - 1], timeList[i]);
            durationList[i - 1] = duration.toMillis();
        }

        long sumDuration = 0;
        for (long duration : durationList) {
            sumDuration += duration;
        }

        return (double) sumDuration / durationList.length / 1000;
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
