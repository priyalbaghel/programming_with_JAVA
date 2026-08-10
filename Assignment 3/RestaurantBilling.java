class RestaurantBilling {
    static int totalOrders = 0;

    // Dine-in order
    double calculateBill(double amount) {
        totalOrders++;
        return amount;
    }

    // Takeaway order (with packing charge)
    double calculateBill(double amount, double packingCharge) {
        totalOrders++;
        return amount + packingCharge;
    }

    // Delivery order (with packing and delivery charges)
    double calculateBill(double amount, double packingCharge, double deliveryCharge) {
        totalOrders++;
        return amount + packingCharge + deliveryCharge;
    }

    // Static method to display total orders
    static void displayOrders() {
        System.out.println("Total Orders Processed: " + totalOrders);
    }

    public static void main(String[] args) {
        RestaurantBilling bill = new RestaurantBilling();

        System.out.println("Dine-in Bill: ₹" + bill.calculateBill(500));
        System.out.println("Takeaway Bill: ₹" + bill.calculateBill(500, 20));
        System.out.println("Delivery Bill: ₹" + bill.calculateBill(500, 20, 50));

        RestaurantBilling.displayOrders();
    }
}
