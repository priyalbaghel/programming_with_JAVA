import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {

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
                System.out.println("\n===== Student Management =====");
                System.out.println("1. Insert Student");
                System.out.println("2. Display Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Roll Number: ");
                        int rollNo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();

                        String insertQuery =
                                "INSERT INTO student_crud VALUES (?, ?, ?, ?)";

                        PreparedStatement insertStmt =
                                con.prepareStatement(insertQuery);

                        insertStmt.setInt(1, rollNo);
                        insertStmt.setString(2, name);
                        insertStmt.setString(3, course);
                        insertStmt.setDouble(4, marks);

                        insertStmt.executeUpdate();

                        System.out.println("Student inserted successfully.");
                        break;

                    case 2:
                        String selectQuery = "SELECT * FROM student_crud";

                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(selectQuery);

                        System.out.println("\nStudent Records:");
                        System.out.println("----------------------------------------");

                        while (rs.next()) {
                            System.out.println("Roll No: " + rs.getInt("roll_no"));
                            System.out.println("Name: " + rs.getString("name"));
                            System.out.println("Course: " + rs.getString("course"));
                            System.out.println("Marks: " + rs.getDouble("marks"));
                            System.out.println("----------------------------------------");
                        }

                        rs.close();
                        stmt.close();
                        break;

                    case 3:
                        System.out.print("Enter Roll Number to update: ");
                        int updateRollNo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter new Course: ");
                        String newCourse = sc.nextLine();

                        System.out.print("Enter new Marks: ");
                        double newMarks = sc.nextDouble();

                        String updateQuery =
                                "UPDATE student_crud SET name=?, course=?, marks=? WHERE roll_no=?";

                        PreparedStatement updateStmt =
                                con.prepareStatement(updateQuery);

                        updateStmt.setString(1, newName);
                        updateStmt.setString(2, newCourse);
                        updateStmt.setDouble(3, newMarks);
                        updateStmt.setInt(4, updateRollNo);

                        int updated = updateStmt.executeUpdate();

                        if (updated > 0)
                            System.out.println("Student updated successfully.");
                        else
                            System.out.println("Student not found.");

                        updateStmt.close();
                        break;

                    case 4:
                        System.out.print("Enter Roll Number to delete: ");
                        int deleteRollNo = sc.nextInt();

                        String deleteQuery =
                                "DELETE FROM student_crud WHERE roll_no=?";

                        PreparedStatement deleteStmt =
                                con.prepareStatement(deleteQuery);

                        deleteStmt.setInt(1, deleteRollNo);

                        int deleted = deleteStmt.executeUpdate();

                        if (deleted > 0)
                            System.out.println("Student deleted successfully.");
                        else
                            System.out.println("Student not found.");

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