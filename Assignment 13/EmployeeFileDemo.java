import java.io.*;
import java.util.Scanner;

public class EmployeeFileDemo {
    static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Employee File Management =====");
            System.out.println("1. Add Employee Details (Write to File)");
            System.out.println("2. Display All Employees (Read from File)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    writeEmployee(sc);
                    break;
                case 2:
                    readEmployees();
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

    static void writeEmployee(Scanner sc) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            System.out.print("Enter Employee ID: ");
            int empId = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Employee Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            bw.write(empId + "," + name + "," + salary);
            bw.newLine();
            System.out.println("Employee details saved to file successfully.");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    static void readEmployees() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No records found. File does not exist yet.");
            return;
        }

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            System.out.println("\n----- Employee Records -----");
            boolean empty = true;
            while ((line = br.readLine()) != null) {
                empty = false;
                String[] parts = line.split(",");
                System.out.println("Employee ID: " + parts[0]);
                System.out.println("Name: " + parts[1]);
                System.out.println("Salary: " + parts[2]);
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