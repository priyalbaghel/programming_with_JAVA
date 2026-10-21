import java.util.Scanner;

class BankAccount {
    private double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        balance += amount;
        System.out.printf(
            "%s deposited Rs. %.2f | Balance: Rs. %.2f%n",
            Thread.currentThread().getName(), amount, balance
        );
    }

    public synchronized void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.printf(
                "%s: Insufficient balance for Rs. %.2f%n",
                Thread.currentThread().getName(), amount
            );
        } else {
            balance -= amount;
            System.out.printf(
                "%s withdrew Rs. %.2f | Balance: Rs. %.2f%n",
                Thread.currentThread().getName(), amount, balance
            );
        }
    }

    public synchronized double getBalance() {
        return balance;
    }
}

class DepositThread extends Thread {
    private BankAccount account;
    private double amount;
    private int count;

    DepositThread(BankAccount account, double amount, int count) {
        super("Deposit Thread");
        this.account = account;
        this.amount = amount;
        this.count = count;
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            account.deposit(amount);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

class WithdrawalThread extends Thread {
    private BankAccount account;
    private double amount;
    private int count;

    WithdrawalThread(BankAccount account, double amount, int count) {
        super("Withdrawal Thread");
        this.account = account;
        this.amount = amount;
        this.count = count;
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            account.withdraw(amount);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class BankTransaction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial balance: Rs. ");
        double balance = sc.nextDouble();

        System.out.print("Enter deposit amount per transaction: Rs. ");
        double deposit = sc.nextDouble();

        System.out.print("Enter withdrawal amount per transaction: Rs. ");
        double withdrawal = sc.nextDouble();

        System.out.print("Enter number of transactions per thread: ");
        int count = sc.nextIncdt();

        if (balance < 0 || deposit <= 0 ||
                withdrawal <= 0 || count <= 0) {
            System.out.println("Invalid input.");
            sc.close();
            return;
        }

        BankAccount account = new BankAccount(balance);

        DepositThread dt =
            new DepositThread(account, deposit, count);

        WithdrawalThread wt =
            new WithdrawalThread(account, withdrawal, count);

        dt.start();
        wt.start();

        try {
            dt.join();
            wt.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted.");
        }

        System.out.printf(
            "Final balance: Rs. %.2f%n", account.getBalance()
        );

        sc.close();
    }
}