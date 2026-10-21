import java.util.Scanner;

class NumberThread extends Thread {
    private int start, end;

    NumberThread(String name, int start, int end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    public void run() {
        try {
            System.out.println(getName() + " is running.");

            for (int i = start; i <= end; i++) {
                System.out.println(getName() + ": " + i);
                Thread.sleep(300);
            }

            System.out.println(getName() + " has completed.");
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}

public class ThreadLifecycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of threads: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Number of threads must be positive.");
            sc.close();
            return;
        }

        NumberThread[] threads = new NumberThread[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter range for Thread " + (i + 1));
            System.out.print("Start: ");
            int start = sc.nextInt();
            System.out.print("End: ");
            int end = sc.nextInt();

            threads[i] = new NumberThread(
                "Thread-" + (i + 1), start, end
            );
        }

        // NEW state
        for (NumberThread t : threads) {
            System.out.println(t.getName() + ": " + t.getState());
        }

        // Start all threads
        for (NumberThread t : threads) {
            t.start();
        }

        // Wait for all threads to finish
        for (NumberThread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Main thread interrupted.");
                sc.close();
                return;
            }
        }

        // TERMINATED state
        for (NumberThread t : threads) {
            System.out.println(t.getName() + ": " + t.getState());
        }

        System.out.println("All threads completed.");
        sc.close();
    }
}