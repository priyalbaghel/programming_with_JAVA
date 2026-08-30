import java.util.Scanner;

public class Login {

    // Method using throws
    static void verifyPassword(String password) throws Exception {
        if (!password.equals("admin123")) {
            // Explicitly throwing an exception
            throw new Exception("Invalid password!");
        }

        System.out.println("Login successful!");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== LOGIN SYSTEM =====");

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        try {
            verifyPassword(password);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            System.out.println("Login verification process completed.");
        }

        sc.close();
    }
}