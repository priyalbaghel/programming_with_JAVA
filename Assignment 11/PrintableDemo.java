import java.util.Scanner;

interface Printable {
    void print(); // interface method
}

class Student implements Printable {
    int rollNo;
    String name;
    String course;

    Student(int rollNo, String name, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
    }

    public void print() {
        System.out.println("\n----- Student Details -----");
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
    }
}

class Employee implements Printable {
    int empId;
    String name;
    String designation;

    Employee(int empId, String name, String designation) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
    }

    public void print() {
        System.out.println("\n----- Employee Details -----");
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
    }
}

public class PrintableDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Printable Interface Demo =====");
            System.out.println("1. Student Details");
            System.out.println("2. Employee Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int rollNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String sName = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    Printable student = new Student(rollNo, sName, course);
                    student.print();
                    break;

                case 2:
                    System.out.print("Enter Employee ID: ");
                    int empId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String eName = sc.nextLine();
                    System.out.print("Enter Designation: ");
                    String designation = sc.nextLine();
                    Printable emp = new Employee(empId, eName, designation);
                    emp.print();
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