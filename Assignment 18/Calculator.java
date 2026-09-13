import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField num1, num2, result;
    JButton addButton, subButton;

    Calculator() {
        setTitle("Simple Calculator");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("First Number:"));
        num1 = new JTextField();
        add(num1);

        add(new JLabel("Second Number:"));
        num2 = new JTextField();
        add(num2);

        add(new JLabel("Result:"));
        result = new JTextField();
        result.setEditable(false);
        add(result);

        addButton = new JButton("Addition");
        subButton = new JButton("Subtraction");

        add(addButton);
        add(subButton);

        addButton.addActionListener(this);
        subButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double a = Double.parseDouble(num1.getText());
        double b = Double.parseDouble(num2.getText());

        if (e.getSource() == addButton) {
            result.setText(String.valueOf(a + b));
        } 
        else if (e.getSource() == subButton) {
            result.setText(String.valueOf(a - b));
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}