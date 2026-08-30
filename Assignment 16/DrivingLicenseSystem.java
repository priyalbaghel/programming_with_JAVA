import java.util.Scanner;

// User-defined exception
class InvalidDrivingAgeException extends Exception {

    public InvalidDrivingAgeException(String message) {
        super(message);
    }
}

public class DrivingLicenseSystem {

    static void checkEligibility(int age) throws InvalidDrivingAgeException {

        if (age < 18) {
            throw new InvalidDrivingAgeException(
                "You are not eligible for a driving license. Minimum age is 18."
            );
        }

        System.out.println("You are eligible for a driving license.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== DRIVING LICENSE SYSTEM =====");
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            checkEligibility(age);
        }
        catch (InvalidDrivingAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}