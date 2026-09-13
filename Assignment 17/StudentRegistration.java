import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends JFrame implements ActionListener {

    JLabel nameLabel, rollLabel, branchLabel, yearLabel;
    JTextField nameField, rollField;
    JComboBox<String> branchBox, yearBox;
    JButton submitButton;

    StudentRegistration() {
        setTitle("Student Registration Form");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        nameLabel = new JLabel("Student Name:");
        rollLabel = new JLabel("Roll Number:");
        branchLabel = new JLabel("Branch:");
        yearLabel = new JLabel("Year:");

        nameField = new JTextField();
        rollField = new JTextField();

        String[] branches = {"CSE", "AIML", "ENTC", "Mechanical", "Civil"};
        branchBox = new JComboBox<>(branches);

        String[] years = {"First Year", "Second Year", "Third Year", "Fourth Year"};
        yearBox = new JComboBox<>(years);

        submitButton = new JButton("Submit");

        add(nameLabel);
        add(nameField);

        add(rollLabel);
        add(rollField);

        add(branchLabel);
        add(branchBox);

        add(yearLabel);
        add(yearBox);

        add(new JLabel(""));
        add(submitButton);

        submitButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText();
        String roll = rollField.getText();
        String branch = (String) branchBox.getSelectedItem();
        String year = (String) yearBox.getSelectedItem();

        JOptionPane.showMessageDialog(
            this,
            "Student Name: " + name +
            "\nRoll Number: " + roll +
            "\nBranch: " + branch +
            "\nYear: " + year,
            "Student Details",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}