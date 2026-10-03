import java.sql.*;

public class DatabaseConnection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "your_password";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    url, username, password);

            if (con != null) {
                System.out.println("Database connected successfully.");
                System.out.println("Connection Status: Connected");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Connection Status: Failed");
            e.printStackTrace();
        }
    }
}