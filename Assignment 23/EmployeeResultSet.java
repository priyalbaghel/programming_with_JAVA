import java.sql.*;

public class EmployeeResultSet {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "your_password";

        String query = "SELECT * FROM employee";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    url, username, password);

            Statement stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Employee Records:");
            System.out.println("--------------------------------");

            // Move to first record
            if (rs.first()) {
                System.out.println("First Employee:");
                System.out.println("Employee ID: " + rs.getInt("emp_id"));
                System.out.println("Name: " + rs.getString("emp_name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Salary: " + rs.getDouble("salary"));
            }

            // Move to next records
            System.out.println("\nAll Employee Records:");
            System.out.println("--------------------------------");

            rs.beforeFirst();

            while (rs.next()) {
                System.out.println("Employee ID: " + rs.getInt("emp_id"));
                System.out.println("Name: " + rs.getString("emp_name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("--------------------------------");
            }

            // Move to last record
            if (rs.last()) {
                System.out.println("\nLast Employee:");
                System.out.println("Employee ID: " + rs.getInt("emp_id"));
                System.out.println("Name: " + rs.getString("emp_name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Salary: " + rs.getDouble("salary"));
            }

            // Move to previous record
            if (rs.previous()) {
                System.out.println("\nPrevious Employee:");
                System.out.println("Employee ID: " + rs.getInt("emp_id"));
                System.out.println("Name: " + rs.getString("emp_name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Salary: " + rs.getDouble("salary"));
            }

            // Move to second record
            if (rs.absolute(2)) {
                System.out.println("\nEmployee at Position 2:");
                System.out.println("Employee ID: " + rs.getInt("emp_id"));
                System.out.println("Name: " + rs.getString("emp_name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Salary: " + rs.getDouble("salary"));
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}