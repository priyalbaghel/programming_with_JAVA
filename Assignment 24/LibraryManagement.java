import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class LibraryManagement extends JFrame {

    JTextField bookIdField, bookNameField, authorField, priceField;
    JTable table;
    DefaultTableModel tableModel;

    public LibraryManagement() {

        setTitle("Library Management System");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        formPanel.add(new JLabel("Book ID:"));
        bookIdField = new JTextField();
        formPanel.add(bookIdField);

        formPanel.add(new JLabel("Book Name:"));
        bookNameField = new JTextField();
        formPanel.add(bookNameField);

        formPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        formPanel.add(authorField);

        formPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        formPanel.add(priceField);

        // Buttons
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add");
        JButton viewButton = new JButton("View");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear");

        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        // Table
        tableModel = new DefaultTableModel(
                new String[]{"Book ID", "Book Name", "Author", "Price"}, 0
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
        addButton.addActionListener(e -> addBook());
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

    // Add Book
    void addBook() {

        String sql = "INSERT INTO library VALUES (?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(bookIdField.getText()));
            ps.setString(2, bookNameField.getText());
            ps.setString(3, authorField.getText());
            ps.setDouble(4, Double.parseDouble(priceField.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Book added successfully.");

            clearFields();
            viewBooks();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    // View Books
    void viewBooks() {

        tableModel.setRowCount(0);

        String sql = "SELECT * FROM library";

        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                tableModel.addRow(new Object[]{
                        rs.getInt("book_id"),
                        rs.getString("book_name"),
                        rs.getString("author"),
                        rs.getDouble("price")
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    // Update Book
    void updateBook() {

        String sql = "UPDATE library SET book_name=?, author=?, price=? WHERE book_id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, bookNameField.getText());
            ps.setString(2, authorField.getText());
            ps.setDouble(3, Double.parseDouble(priceField.getText()));
            ps.setInt(4, Integer.parseInt(bookIdField.getText()));

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Book updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Book ID not found.");
            }

            clearFields();
            viewBooks();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    // Delete Book
    void deleteBook() {

        String sql = "DELETE FROM library WHERE book_id=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(bookIdField.getText()));

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Book deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Book ID not found.");
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
        bookNameField.setText("");
        authorField.setText("");
        priceField.setText("");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new LibraryManagement();
        });
    }
}