import java.sql.*;

public class StudentDatabaseConnection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "your_password";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    url, username, password);

            if (con != null) {
                System.out.println("Connection Status: Connected");
                System.out.println(
                    "Student database connected successfully.");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Connection Status: Failed");
            e.printStackTrace();
        }
    }
}