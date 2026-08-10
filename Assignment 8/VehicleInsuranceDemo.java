import java.util.Scanner;

class Vehicle {
    String vehicleNumber;
    String model;
    String type;

    Vehicle(String vehicleNumber, String model, String type) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.type = type;
    }

    void displayVehicleInfo() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Model: " + model);
        System.out.println("Type: " + type);
    }
}

class CarInsurance extends Vehicle {
    double insuredAmount;
    double premiumRate = 0.03; // 3%

    CarInsurance(String vehicleNumber, String model, double insuredAmount) {
        super(vehicleNumber, model, "Car"); // using super to set parent fields
        this.insuredAmount = insuredAmount;
    }

    void displayInsuranceDetails() {
        System.out.println("----- Car Insurance Details -----");
        super.displayVehicleInfo(); // accessing parent info using super
        double premium = insuredAmount * premiumRate;
        System.out.println("Insured Amount: " + insuredAmount);
        System.out.println("Premium Amount: " + premium);
    }
}

class BikeInsurance extends Vehicle {
    double insuredAmount;
    double premiumRate = 0.02; // 2%

    BikeInsurance(String vehicleNumber, String model, double insuredAmount) {
        super(vehicleNumber, model, "Bike");
        this.insuredAmount = insuredAmount;
    }

    void displayInsuranceDetails() {
        System.out.println("----- Bike Insurance Details -----");
        super.displayVehicleInfo();
        double premium = insuredAmount * premiumRate;
        System.out.println("Insured Amount: " + insuredAmount);
        System.out.println("Premium Amount: " + premium);
    }
}

public class VehicleInsuranceDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Vehicle Insurance System =====");
            System.out.println("1. Car Insurance");
            System.out.println("2. Bike Insurance");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Vehicle Number: ");
                    String carNum = sc.nextLine();
                    System.out.print("Enter Car Model: ");
                    String carModel = sc.nextLine();
                    System.out.print("Enter Insured Amount: ");
                    double carAmount = sc.nextDouble();
                    sc.nextLine();
                    CarInsurance car = new CarInsurance(carNum, carModel, carAmount);
                    car.displayInsuranceDetails();
                    break;

                case 2:
                    System.out.print("Enter Vehicle Number: ");
                    String bikeNum = sc.nextLine();
                    System.out.print("Enter Bike Model: ");
                    String bikeModel = sc.nextLine();
                    System.out.print("Enter Insured Amount: ");
                    double bikeAmount = sc.nextDouble();
                    sc.nextLine();
                    BikeInsurance bike = new BikeInsurance(bikeNum, bikeModel, bikeAmount);
                    bike.displayInsuranceDetails();
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