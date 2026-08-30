import java.util.Scanner;

public class ATM_PIN {

    // Method using throws
    static void verifyPIN(int pin) throws Exception {

        if (pin < 1000 || pin > 9999) {
            throw new Exception("Invalid PIN! PIN must contain 4 digits.");
        }

        if (pin != 1234) {
            throw new Exception("Incorrect PIN!");
        }

        System.out.println("PIN verified successfully!");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== ATM PIN VERIFICATION =====");

        System.out.print("Enter your 4-digit PIN: ");
        int pin = sc.nextInt();

        try {
            verifyPIN(pin);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            System.out.println("PIN verification process completed.");
        }

        sc.close();
    }
}   