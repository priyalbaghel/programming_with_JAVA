import java.sql.*;
import java.util.Scanner;

public class LoginApplication {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "your_password";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String inputUsername = sc.nextLine();

        System.out.print("Enter Password: ");
        String inputPassword = sc.nextLine();

        String query = "SELECT * FROM login WHERE username = ? AND password = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    url, username, password);

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, inputUsername);
            pstmt.setString(2, inputPassword);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successful.");
                System.out.println("Welcome, " + rs.getString("username") + "!");
            } else {
                System.out.println("Invalid Username or Password.");
            }

            rs.close();
            pstmt.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}