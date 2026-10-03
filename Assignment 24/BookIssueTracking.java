import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class BookIssueTracking extends JFrame {

    JTextField bookIdField, studentNameField, issueDateField, returnDateField;
    JTable table;
    DefaultTableModel tableModel;

    public BookIssueTracking() {

        setTitle("Book Issue Tracking System");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        formPanel.add(new JLabel("Book ID:"));
        bookIdField = new JTextField();
        formPanel.add(bookIdField);

        formPanel.add(new JLabel("Student Name:"));
        studentNameField = new JTextField();
        formPanel.add(studentNameField);

        formPanel.add(new JLabel("Issue Date (YYYY-MM-DD):"));
        issueDateField = new JTextField();
        formPanel.add(issueDateField);

        formPanel.add(new JLabel("Return Date (YYYY-MM-DD):"));
        returnDateField = new JTextField();
        formPanel.add(returnDateField);

        // Buttons
        JPanel buttonPanel = new JPanel();

        JButton issueButton = new JButton("Issue Book");
        JButton viewButton = new JButton("View");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear");

        buttonPanel.add(issueButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        // Table
        tableModel = new DefaultTableModel(
                new String[]{"Book ID", "Student Name", "Issue Date", "Return Date"}, 0
        );

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Top Panel
        JPanel topPanel = new JPanel(new BorderLayout());

        topPanel.add(formPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Button Actions
        issueButton.addActionListener(e -> issueBook());
        viewButton.addActionListener(e -> viewBooks());
        updateButton.addActionListener(e -> updateBook());
        deleteButton.addActionListener(e -> deleteBook());
        clearButton.addActionListener(e -> clearFields());

        setVisible(true);
    }

    // Database Connection
    public Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "your_password";

        return DriverManager.getConnection(url, username, password);
    }

    // Issue Book
    void issueBook() {

        String sql = "INSERT INTO book_issue VALUES (?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(bookIdField.getText()));
            ps.setString(2, studentNameField.getText());
            ps.setDate(3, Date.valueOf(issueDateField.getText()));

            if (returnDateField.getText().trim().isEmpty()) {
                ps.setNull(4, Types.DATE);
            } else {
                ps.setDate(4, Date.valueOf(returnDateField.getText()));
            }

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    this,
                    "Book issued successfully."
            );

            clearFields();
            viewBooks();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    // View Books
    void viewBooks() {

        tableModel.setRowCount(0);

        String sql = "SELECT * FROM book_issue";

        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                tableModel.addRow(new Object[]{
                        rs.getInt("book_id"),
                        rs.getString("student_name"),
                        rs.getDate("issue_date"),
                        rs.getDate("return_date")
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    // Update Book Issue
    void updateBook() {

        String sql = "UPDATE book_issue SET student_name=?, issue_date=?, return_date=? WHERE book_id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studentNameField.getText());
            ps.setDate(2, Date.valueOf(issueDateField.getText()));

            if (returnDateField.getText().trim().isEmpty()) {
                ps.setNull(3, Types.DATE);
            } else {
                ps.setDate(3, Date.valueOf(returnDateField.getText()));
            }

            ps.setInt(4, Integer.parseInt(bookIdField.getText()));

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Book issue record updated successfully."
                );
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Book ID not found."
                );
            }

            clearFields();
            viewBooks();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    // Delete Book Issue
    void deleteBook() {

        String sql = "DELETE FROM book_issue WHERE book_id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(bookIdField.getText()));

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Book issue record deleted successfully."
                );
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Book ID not found."
                );
            }

            clearFields();
            viewBooks();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    // Clear Fields
    void clearFields() {

        bookIdField.setText("");
        studentNameField.setText("");
        issueDateField.setText("");
        returnDateField.setText("");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new BookIssueTracking();
        });
    }
}