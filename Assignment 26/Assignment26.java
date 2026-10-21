
import java.util.Scanner;

class MyTask implements Runnable {
    private String taskName;
    private int count;

    MyTask(String taskName, int count) {
        this.taskName = taskName;
        this.count = count;
    }

    public void run() {
        for (int i = 1; i <= count; i++) {
            System.out.println(taskName + ": " + i);
        }
    }
}

public class Assignment26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of iterations: ");
        int n = sc.nextInt();

        Thread t1 = new Thread(new MyTask("Task 1", n));
        Thread t2 = new Thread(new MyTask("Task 2", n));

        t1.start();
        t2.start();

        sc.close();
    }
}
