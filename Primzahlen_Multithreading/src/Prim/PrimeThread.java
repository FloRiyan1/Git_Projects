package Prim;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PrimeThread extends Thread {
    private final long start;
    private final long end;
    private final int suffix;
    private final String fileName;

    PrimeThread(long start, long end, int suffix, String fileName) {
        this.start = start;
        this.end = end;
        this.suffix = suffix;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (long i = start; i < end; i++) {
                if (isPrime(i)) {
                    writer.write(i + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isPrime(long number) {
        if (number < 2) {
            return false;
        }
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        long sqrt = (long) Math.sqrt(number);
        for (long i = 5; i <= sqrt; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
