import java.sql.*;

public class StudentRecords {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "your_password";

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Create statement
            Statement stmt = con.createStatement();

            // SELECT query
            String query = "SELECT * FROM student";

            // Execute query
            ResultSet rs = stmt.executeQuery(query);

            // Display records
            System.out.println("Student Records");
            System.out.println("-------------------------");

            while (rs.next()) {
                int rollno = rs.getInt("rollno");
                String name = rs.getString("name");

                System.out.println(
                    "Roll No: " + rollno +
                    ", Name: " + name
                );
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}