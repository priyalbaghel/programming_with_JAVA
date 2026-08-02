import java.util.Scanner;

class EmployeePayroll {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking employee details as String input
        System.out.print("Enter Employee ID: ");
        String empId = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        String basicSalary = sc.nextLine();

        System.out.print("Enter Bonus Amount: ");
        String bonus = sc.nextLine();

        // Converting String values into Wrapper Class objects
        Integer id = Integer.valueOf(empId);
        Double salary = Double.valueOf(basicSalary);
        Double bonusAmount = Double.valueOf(bonus);

        // Validating salary and bonus values
        if (salary < 0 || bonusAmount < 0) {

            // Display error message for invalid values
            System.out.println("Invalid Salary or Bonus Amount.");

        } 
        else {

            // Calculating net salary
            double netSalary = salary + bonusAmount;

            // Displaying employee payroll details
            System.out.println("\n===== EMPLOYEE PAYROLL =====");
            System.out.println("Employee ID: " + id);
            System.out.println("Basic Salary: ₹" + salary);
            System.out.println("Bonus Amount: ₹" + bonusAmount);
            System.out.println("Net Salary: ₹" + netSalary);
        }

        // Closing Scanner object
        sc.close();
    }
}
