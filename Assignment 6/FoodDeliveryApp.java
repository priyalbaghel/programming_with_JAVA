import java.util.Scanner;

class FoodDelivery {

    String customerName;
    String foodName;
    int quantity;

    FoodDelivery(String name, String food, int qty) {
        customerName = name;
        foodName = food;
        quantity = qty;
    }

    // Inner class
    class OrderDetails {
        void displayOrder() {
            System.out.println("\n--- Order Details ---");
            System.out.println("Customer Name: " + customerName);
            System.out.println("Food Item: " + foodName);
            System.out.println("Quantity: " + quantity);
        }
    }

    // Interface
    interface DeliveryStatus {
        void updateStatus();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        FoodDelivery order = null;
        int choice;

        do {
            System.out.println("\n===== FOOD DELIVERY MENU =====");
            System.out.println("1. Place Order");
            System.out.println("2. Display Order Details");
            System.out.println("3. Check Delivery Status");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter food item: ");
                    String food = sc.nextLine();

                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();

                    order = new FoodDelivery(name, food, quantity);

                    System.out.println("Order placed successfully!");
                    break;

                case 2:
                    if (order != null) {
                        // Inner class
                        OrderDetails details = order.new OrderDetails();
                        details.displayOrder();
                    } else {
                        System.out.println("Please place an order first.");
                    }
                    break;

                case 3:
                    if (order != null) {

                        System.out.println("\n--- Delivery Status ---");

                        // Anonymous class 1
                        DeliveryStatus preparing = new DeliveryStatus() {
                            public void updateStatus() {
                                System.out.println("Order is being prepared.");
                            }
                        };

                        // Anonymous class 2
                        DeliveryStatus delivered = new DeliveryStatus() {
                            public void updateStatus() {
                                System.out.println("Order is out for delivery.");
                            }
                        };

                        preparing.updateStatus();
                        delivered.updateStatus();

                    } else {
                        System.out.println("Please place an order first.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using Food Delivery!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}