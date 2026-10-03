import java.sql.*;
import java.util.Scanner;

public class HospitalStaffLogin {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "your_password";
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Login ID: ");
        String loginId = sc.nextLine();

        System.out.print("Enter Password: ");
        String inputPassword = sc.nextLine();

        String query =
                "SELECT login_id, role FROM hospital_staff " +
                "WHERE login_id = ? AND password = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    url, username, password);

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, loginId);
            pstmt.setString(2, inputPassword);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                String role = rs.getString("role");

                System.out.println("Login Successful.");
                System.out.println("Login ID: " + rs.getString("login_id"));

                if (role.equalsIgnoreCase("Doctor")) {
                    System.out.println("Access Granted: Doctor Portal");
                } else if (role.equalsIgnoreCase("Nurse")) {
                    System.out.println("Access Granted: Nurse Portal");
                }

            } else {
                System.out.println("Invalid Login ID or Password.");
                System.out.println("Access Denied.");
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