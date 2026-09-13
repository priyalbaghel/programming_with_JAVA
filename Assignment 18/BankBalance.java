import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankBalance extends JFrame implements ActionListener {

    JTextField balanceField, amountField, resultField;
    JButton depositButton, withdrawButton;

    BankBalance() {
        setTitle("Bank Balance Calculator");
        setSize(450, 250);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Initial Balance:"));
        balanceField = new JTextField();
        add(balanceField);

        add(new JLabel("Transaction Amount:"));
        amountField = new JTextField();
        add(amountField);

        add(new JLabel("Updated Balance:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");

        add(depositButton);
        add(withdrawButton);

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double balance = Double.parseDouble(balanceField.getText());
        double amount = Double.parseDouble(amountField.getText());
        double updatedBalance;

        if (e.getSource() == depositButton) {
            updatedBalance = balance + amount;
            resultField.setText(String.valueOf(updatedBalance));
        } 
        else if (e.getSource() == withdrawButton) {
            if (amount <= balance) {
                updatedBalance = balance - amount;
                resultField.setText(String.valueOf(updatedBalance));
            } 
            else {
                JOptionPane.showMessageDialog(
                    this,
                    "Insufficient Balance!"
                );
            }
        }
    }

    public static void main(String[] args) {
        new BankBalance();
    }
}