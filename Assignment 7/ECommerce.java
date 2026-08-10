
import java.util.Scanner;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price);
    }
}

// Interface
interface ProductOperations {
    void showCategory();
}

// Electronic product
class Electronic extends Product implements ProductOperations {

    Electronic(String name, double price) {
        super(name, price);
    }

    public void showCategory() {
        System.out.println("Category: Electronics");
    }

    @Override
    void display() {
        super.display();
        showCategory();
    }
}

// Clothing product
class Clothing extends Product implements ProductOperations {

    Clothing(String name, double price) {
        super(name, price);
    }

    public void showCategory() {
        System.out.println("Category: Clothing");
    }

    @Override
    void display() {
        super.display();
        showCategory();
    }
}

// Grocery product
class Grocery extends Product implements ProductOperations {

    Grocery(String name, double price) {
        super(name, price);
    }

    public void showCategory() {
        System.out.println("Category: Grocery");
    }

    @Override
    void display() {
        super.display();
        showCategory();
    }
}

public class ECommerce {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product product = null;
        int choice;

        do {
            System.out.println("\n===== E-COMMERCE MENU =====");
            System.out.println("1. Add Electronic Product");
            System.out.println("2. Add Clothing Product");
            System.out.println("3. Add Grocery Product");
            System.out.println("4. Display Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter electronic product name: ");
                    String electronicName = sc.nextLine();

                    System.out.print("Enter price: ");
                    double electronicPrice = sc.nextDouble();

                    product = new Electronic(electronicName, electronicPrice);

                    System.out.println("Electronic product added!");
                    break;

                case 2:
                    System.out.print("Enter clothing product name: ");
                    String clothingName = sc.nextLine();

                    System.out.print("Enter price: ");
                    double clothingPrice = sc.nextDouble();

                    product = new Clothing(clothingName, clothingPrice);

                    System.out.println("Clothing product added!");
                    break;

                case 3:
                    System.out.print("Enter grocery product name: ");
                    String groceryName = sc.nextLine();

                    System.out.print("Enter price: ");
                    double groceryPrice = sc.nextDouble();

                    product = new Grocery(groceryName, groceryPrice);

                    System.out.println("Grocery product added!");
                    break;

                case 4:
                    if (product != null) {
                        System.out.println("\n--- PRODUCT DETAILS ---");
                        product.display();
                    } else {
                        System.out.println("No product added yet.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using E-Commerce System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}

