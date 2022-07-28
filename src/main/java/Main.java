import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        // Main method doesn't run logic. Only calls runner
        Scanner scanner = new Scanner(System.in);
        // create an executor
        ExecutorService executor = Executors.newSingleThreadExecutor();
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            // submit tasks to your executor
            PrimeLogger primelogger = new PrimeLogger(num);
            if (num != 0) {
                primelogger.run();
            } else {
                break;
            }
            executor.shutdown();
        }
    }
}

class PrimeLogger implements Runnable {
    private final int num;

    public PrimeLogger(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        boolean notPrime = false;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                notPrime = true;
                break;
            }
        }

        if (notPrime)
            System.out.println(num + " is not a prime number.");
        else
            System.out.println(num + " is a prime number.");
    }
}