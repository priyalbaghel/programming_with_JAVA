import java.sql.*;

public class JDBCComponents {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "your_password";

        try {
            // Loading JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishing connection
            Connection con = DriverManager.getConnection(
                    url, username, password);

            System.out.println("Database connected successfully.");
            System.out.println("Connection Status: Connected");

            // Creating Statement
            Statement stmt = con.createStatement();

            System.out.println("Statement object created successfully.");

            stmt.close();
            con.close();

            System.out.println("Database connection closed.");

        } catch (Exception e) {
            System.out.println("Connection Status: Failed");
            e.printStackTrace();
        }
    }
}