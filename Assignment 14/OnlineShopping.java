import java.util.Scanner;

public class OnlineShopping {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("===== ONLINE SHOPPING =====");
            System.out.println("1. Add Product");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                try {
                    System.out.print("Enter product name: ");
                    sc.nextLine();
                    String product = sc.nextLine();

                    System.out.print("Enter product quantity: ");
                    int quantity = sc.nextInt();

                    if (quantity <= 0) {
                        throw new IllegalArgumentException(
                            "Product quantity must be greater than zero."
                        );
                    }

                    System.out.println("\nProduct added successfully!");
                    System.out.println("Product: " + product);
                    System.out.println("Quantity: " + quantity);
                }
                catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                catch (java.util.InputMismatchException e) {
                    System.out.println("Error: Quantity must be a number.");
                }
            }
            else if (choice == 2) {
                System.out.println("Thank you for shopping with us.");
            }
            else {
                System.out.println("Invalid choice!");
            }
        }
        catch (java.util.InputMismatchException e) {
            System.out.println("Error: Please enter a valid choice.");
        }

        sc.close();
    }
}
