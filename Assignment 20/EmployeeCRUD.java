import java.sql.*;
import java.util.Scanner;

public class EmployeeCRUD {

    static String url = "jdbc:mysql://localhost:3306/jdbc_demo";
    static String username = "root";
    static String password = "your_password";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            int choice;

            do {
                System.out.println("\n===== Employee Management =====");
                System.out.println("1. Insert Employee");
                System.out.println("2. Display Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Employee ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Employee Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Department: ");
                        String department = sc.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();

                        String insertQuery =
                                "INSERT INTO employee VALUES (?, ?, ?, ?)";

                        PreparedStatement insertStmt =
                                con.prepareStatement(insertQuery);

                        insertStmt.setInt(1, id);
                        insertStmt.setString(2, name);
                        insertStmt.setString(3, department);
                        insertStmt.setDouble(4, salary);

                        insertStmt.executeUpdate();

                        System.out.println("Employee inserted successfully.");
                        break;

                    case 2:
                        String selectQuery = "SELECT * FROM employee";

                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(selectQuery);

                        System.out.println("\nEmployee Records:");
                        System.out.println("----------------------------------------");

                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("emp_id"));
                            System.out.println("Name: " + rs.getString("emp_name"));
                            System.out.println("Department: " + rs.getString("department"));
                            System.out.println("Salary: " + rs.getDouble("salary"));
                            System.out.println("----------------------------------------");
                        }

                        rs.close();
                        stmt.close();
                        break;

                    case 3:
                        System.out.print("Enter Employee ID to update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new Employee Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter new Department: ");
                        String newDepartment = sc.nextLine();

                        System.out.print("Enter new Salary: ");
                        double newSalary = sc.nextDouble();

                        String updateQuery =
                                "UPDATE employee SET emp_name=?, department=?, salary=? WHERE emp_id=?";

                        PreparedStatement updateStmt =
                                con.prepareStatement(updateQuery);

                        updateStmt.setString(1, newName);
                        updateStmt.setString(2, newDepartment);
                        updateStmt.setDouble(3, newSalary);
                        updateStmt.setInt(4, updateId);

                        int updated = updateStmt.executeUpdate();

                        if (updated > 0)
                            System.out.println("Employee updated successfully.");
                        else
                            System.out.println("Employee not found.");

                        updateStmt.close();
                        break;

                    case 4:
                        System.out.print("Enter Employee ID to delete: ");
                        int deleteId = sc.nextInt();

                        String deleteQuery =
                                "DELETE FROM employee WHERE emp_id=?";

                        PreparedStatement deleteStmt =
                                con.prepareStatement(deleteQuery);

                        deleteStmt.setInt(1, deleteId);

                        int deleted = deleteStmt.executeUpdate();

                        if (deleted > 0)
                            System.out.println("Employee deleted successfully.");
                        else
                            System.out.println("Employee not found.");

                        deleteStmt.close();
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } while (choice != 5);

            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}