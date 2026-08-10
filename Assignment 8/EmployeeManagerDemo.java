import java.util.Scanner;

class Employee {
    int empId;
    String name;
    double salary;

    Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    void displayEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    String department;

    Manager(int empId, String name, double salary, String department) {
        super(empId, name, salary); // calling parent constructor using super
        this.department = department;
    }

    void displayManagerDetails() {
        System.out.println("----- Manager Details -----");
        super.displayEmployeeDetails(); // accessing parent method using super
        System.out.println("Department: " + department);
    }
}

public class EmployeeManagerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Enter Manager (Employee) Details ---");
        System.out.print("Enter Employee ID: ");
        int empId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        Manager mgr = new Manager(empId, name, salary, department);
        mgr.displayManagerDetails();

        sc.close();
    }
}