import java.util.Scanner;

abstract class FoodOrder {
    String itemName;
    double itemPrice;
    int quantity;

    FoodOrder(String itemName, double itemPrice, int quantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }

    abstract double calculateBill(); // abstract method

    void displayOrder(double bill) {
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: " + itemPrice);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Bill: " + bill);
    }
}

class DineInOrder extends FoodOrder {
    double serviceTaxRate = 0.10; // 10%

    DineInOrder(String itemName, double itemPrice, int quantity) {
        super(itemName, itemPrice, quantity);
    }

    double calculateBill() {
        double base = itemPrice * quantity;
        double tax = base * serviceTaxRate;
        return base + tax;
    }
}

class TakeAwayOrder extends FoodOrder {
    double packagingCharge = 20.0; // flat charge

    TakeAwayOrder(String itemName, double itemPrice, int quantity) {
        super(itemName, itemPrice, quantity);
    }

    double calculateBill() {
        double base = itemPrice * quantity;
        return base + packagingCharge;
    }
}

public class FoodOrderDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Food Order System =====");
            System.out.println("1. Dine-In Order");
            System.out.println("2. Take-Away Order");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Item Name: ");
                    String dName = sc.nextLine();
                    System.out.print("Enter Item Price: ");
                    double dPrice = sc.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int dQty = sc.nextInt();
                    sc.nextLine();
                    FoodOrder dine = new DineInOrder(dName, dPrice, dQty);
                    double dineBill = dine.calculateBill();
                    System.out.println("\n----- Dine-In Bill -----");
                    dine.displayOrder(dineBill);
                    break;

                case 2:
                    System.out.print("Enter Item Name: ");
                    String tName = sc.nextLine();
                    System.out.print("Enter Item Price: ");
                    double tPrice = sc.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int tQty = sc.nextInt();
                    sc.nextLine();
                    FoodOrder takeaway = new TakeAwayOrder(tName, tPrice, tQty);
                    double takeBill = takeaway.calculateBill();
                    System.out.println("\n----- Take-Away Bill -----");
                    takeaway.displayOrder(takeBill);
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