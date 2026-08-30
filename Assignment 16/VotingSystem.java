import java.util.Scanner;

// User-defined exception
class InvalidVotingAgeException extends Exception {

    public InvalidVotingAgeException(String message) {
        super(message);
    }
}

public class VotingSystem {

    static void checkEligibility(int age) throws InvalidVotingAgeException {

        if (age < 18) {
            throw new InvalidVotingAgeException(
                "You are not eligible to vote. Minimum age is 18."
            );
        }

        System.out.println("You are eligible to vote.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== VOTING SYSTEM =====");
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            checkEligibility(age);
        }
        catch (InvalidVotingAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}