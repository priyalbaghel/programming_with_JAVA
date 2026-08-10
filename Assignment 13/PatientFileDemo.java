import java.io.*;
import java.util.Scanner;

public class PatientFileDemo {
    static final String FILE_NAME = "patients.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Patient File Management =====");
            System.out.println("1. Add Patient Details (Write to File)");
            System.out.println("2. Display All Patients (Read from File)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    writePatient(sc);
                    break;
                case 2:
                    readPatients();
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

    static void writePatient(Scanner sc) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            System.out.print("Enter Patient ID: ");
            int patientId = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Patient Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Diagnosis: ");
            String diagnosis = sc.nextLine();

            bw.write(patientId + "," + name + "," + age + "," + diagnosis);
            bw.newLine();
            System.out.println("Patient details saved to file successfully.");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    static void readPatients() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No records found. File does not exist yet.");
            return;
        }

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            System.out.println("\n----- Patient Records -----");
            boolean empty = true;
            while ((line = br.readLine()) != null) {
                empty = false;
                String[] parts = line.split(",");
                System.out.println("Patient ID: " + parts[0]);
                System.out.println("Name: " + parts[1]);
                System.out.println("Age: " + parts[2]);
                System.out.println("Diagnosis: " + parts[3]);
                System.out.println("----------------------------");
            }
            if (empty) {
                System.out.println("No records found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}