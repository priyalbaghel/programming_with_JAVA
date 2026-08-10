import java.util.Scanner;

abstract class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract void processPayment(); // abstract method
}

class CreditCardPayment extends Payment {
    String cardNumber;
    String cardHolderName;

    CreditCardPayment(double amount, String cardNumber, String cardHolderName) {
        super(amount);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    void processPayment() {
        System.out.println("\n----- Credit Card Payment -----");
        System.out.println("Card Holder: " + cardHolderName);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Amount Paid: " + amount);
        System.out.println("Payment processed successfully via Credit Card.");
    }
}

class UPIPayment extends Payment {
    String upiId;

    UPIPayment(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    void processPayment() {
        System.out.println("\n----- UPI Payment -----");
        System.out.println("UPI ID: " + upiId);
        System.out.println("Amount Paid: " + amount);
        System.out.println("Payment processed successfully via UPI.");
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Payment System =====");
            System.out.println("1. Pay via Credit Card");
            System.out.println("2. Pay via UPI");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Amount: ");
                    double ccAmount = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Card Number: ");
                    String cardNum = sc.nextLine();
                    System.out.print("Enter Card Holder Name: ");
                    String holder = sc.nextLine();
                    Payment cc = new CreditCardPayment(ccAmount, cardNum, holder);
                    cc.processPayment();
                    break;

                case 2:
                    System.out.print("Enter Amount: ");
                    double upiAmount = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter UPI ID: ");
                    String upiId = sc.nextLine();
                    Payment upi = new UPIPayment(upiAmount, upiId);
                    upi.processPayment();
                    break;

                case 3:
                    System.out.println("Exiting program. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}