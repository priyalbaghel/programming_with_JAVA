import java.util.Scanner;

class BankAccount {
    final long accountNumber; // final - cannot be changed once assigned
    String accountHolderName;
    double balance;

    BankAccount(long accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully. New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully. New Balance: " + balance);
        } else {
            System.out.println("Invalid or insufficient balance.");
        }
    }

    void displayDetails() {
        System.out.println("\n----- Account Details -----");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Create Bank Account ---");
        System.out.print("Enter Account Number: ");
        long accNum = sc.nextLong();
        sc.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(accNum, name, balance);

        int choice;
        do {
            System.out.println("\n===== Bank Account Menu =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depAmt = sc.nextDouble();
                    account.deposit(depAmt);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double witAmt = sc.nextDouble();
                    account.withdraw(witAmt);
                    break;
                case 3:
                    account.displayDetails();
                    break;
                case 4:
                    System.out.println("Exiting program. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}