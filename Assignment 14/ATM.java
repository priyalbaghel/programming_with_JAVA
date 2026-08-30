import java.util.Scanner;

public class ATM {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 10000;

        try {
            System.out.println("===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Current Balance: Rs. " + balance);
            }
            else if (choice == 2) {
                try {
                    System.out.print("Enter withdrawal amount: ");
                    double amount = sc.nextDouble();

                    if (amount <= 0) {
                        throw new IllegalArgumentException(
                            "Withdrawal amount must be greater than zero."
                        );
                    }

                    if (amount > balance) {
                        throw new ArithmeticException(
                            "Insufficient balance."
                        );
                    }

                    balance = balance - amount;
                    System.out.println("Withdrawal successful!");
                    System.out.println("Remaining Balance: Rs. " + balance);
                }
                catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
            else if (choice == 3) {
                System.out.println("Thank you for using the ATM.");
            }
            else {
                System.out.println("Invalid choice!");
            }
        }
        catch (java.util.InputMismatchException e) {
            System.out.println("Error: Please enter a valid numeric value.");
        }

        sc.close();
    }
}