import java.util.Scanner;

class Vehicle {
    String vehicleName;
    String vehicleNumber;

    Vehicle(String name, String number) {
        vehicleName = name;
        vehicleNumber = number;
    }

    // Inner class
    class VehicleDetails {
        void displayDetails() {
            System.out.println("\n--- Vehicle Details ---");
            System.out.println("Vehicle Name: " + vehicleName);
            System.out.println("Vehicle Number: " + vehicleNumber);
        }
    }

    // Anonymous class using interface
    interface Action {
        void performAction();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter vehicle name: ");
        String name = sc.nextLine();

        System.out.print("Enter vehicle number: ");
        String number = sc.nextLine();

        Vehicle v = new Vehicle(name, number);

        // Using inner class
        Vehicle.VehicleDetails details = v.new VehicleDetails();
        details.displayDetails();

        // Anonymous class
        Action action = new Action() {
            public void performAction() {
                System.out.println("Vehicle action: Vehicle is starting.");
            }
        };

        action.performAction();

        sc.close();
    }
}