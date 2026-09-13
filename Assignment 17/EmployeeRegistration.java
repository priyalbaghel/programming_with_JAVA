import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeRegistration extends JFrame implements ActionListener {

    JLabel idLabel, nameLabel, deptLabel, salaryLabel;
    JTextField idField, nameField, deptField, salaryField;
    JButton submitButton;

    EmployeeRegistration() {
        setTitle("Employee Registration Form");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        idLabel = new JLabel("Employee ID:");
        nameLabel = new JLabel("Name:");
        deptLabel = new JLabel("Department:");
        salaryLabel = new JLabel("Salary:");

        idField = new JTextField();
        nameField = new JTextField();
        deptField = new JTextField();
        salaryField = new JTextField();

        submitButton = new JButton("Submit");

        add(idLabel);
        add(idField);

        add(nameLabel);
        add(nameField);

        add(deptLabel);
        add(deptField);

        add(salaryLabel);
        add(salaryField);

        add(new JLabel(""));
        add(submitButton);

        submitButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String id = idField.getText();
        String name = nameField.getText();
        String department = deptField.getText();
        String salary = salaryField.getText();

        JOptionPane.showMessageDialog(
            this,
            "Employee ID: " + id +
            "\nName: " + name +
            "\nDepartment: " + department +
            "\nSalary: " + salary,
            "Employee Details",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {
        new EmployeeRegistration();
    }
}