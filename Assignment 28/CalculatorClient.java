
import java.rmi.*;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Calculator obj = (Calculator)
                Naming.lookup("rmi://localhost/CalculatorService");

            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n--- Remote Calculator ---");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                if (choice >= 1 && choice <= 4) {
                    System.out.print("Enter first number: ");
                    double a = sc.nextDouble();

                    System.out.print("Enter second number: ");
                    double b = sc.nextDouble();

                    try {
                        switch (choice) {
                            case 1:
                                System.out.println("Result: " + obj.add(a, b));
                                break;
                            case 2:
                                System.out.println("Result: " + obj.subtract(a, b));
                                break;
                            case 3:
                                System.out.println("Result: " + obj.multiply(a, b));
                                break;
                            case 4:
                                System.out.println("Result: " + obj.divide(a, b));
                                break;
                        }
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (choice != 5) {
                    System.out.println("Invalid choice!");
                }

            } while (choice != 5);

            System.out.println("Calculator closed.");
            sc.close();

        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
