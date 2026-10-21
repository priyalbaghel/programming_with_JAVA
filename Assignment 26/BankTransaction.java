
import java.util.Scanner;

class Bank implements Runnable {
    private int balance;
    private int amount;
    private String operation;

    Bank(int balance, int amount, String operation) {
        this.balance = balance;
        this.amount = amount;
        this.operation = operation;
    }

    public synchronized void run() {
        if (operation.equals("deposit")) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount);
            } else {
                System.out.println("Insufficient balance!");
            }
        }

        System.out.println("Current balance: " + balance);
    }
}

public class BankTransaction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        int balance = sc.nextInt();

        System.out.print("Enter deposit amount: ");
        int deposit = sc.nextInt();

        System.out.print("Enter withdrawal amount: ");
        int withdraw = sc.nextInt();

        Bank b1 = new Bank(balance, deposit, "deposit");
        Bank b2 = new Bank(balance, withdraw, "withdraw");

        Thread t1 = new Thread(b1);
        Thread t2 = new Thread(b2);

        t1.start();
        t2.start();

        sc.close();
    }
}
