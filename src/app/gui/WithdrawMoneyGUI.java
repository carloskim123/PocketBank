package app.gui;

import app.modules.WithdrawMoney;
import app.modules.WithdrawResult;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class WithdrawMoneyGUI extends JFrame {

    private final JTextField accountNumberField;
    private final JTextField withdrawAmountField;
    private final JLabel resultLabel;

    public WithdrawMoneyGUI() {
        // Set up the frame
        setTitle("Withdraw Money");
        setSize(800, 500); // Larger window size
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); // Prevent resizing
        setLayout(new GridBagLayout()); // Use GridBagLayout for modern layout

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); // Add padding around components
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Create and style components
        JLabel titleLabel = new JLabel("Withdraw Money");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel accountNumberLabel = new JLabel("Account Number:");
        accountNumberLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        accountNumberField = new JTextField();
        accountNumberField.setFont(new Font("Arial", Font.PLAIN, 16));
        accountNumberField.setPreferredSize(new Dimension(250, 30)); // Adjust size

        JLabel withdrawAmountLabel = new JLabel("Amount to Withdraw:");
        withdrawAmountLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        withdrawAmountField = new JTextField();
        withdrawAmountField.setFont(new Font("Arial", Font.PLAIN, 16));
        withdrawAmountField.setPreferredSize(new Dimension(250, 30)); // Adjust size

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setFont(new Font("Arial", Font.PLAIN, 16));
        withdrawButton.setBackground(new Color(70, 130, 180)); // SteelBlue background
        withdrawButton.setForeground(Color.WHITE); // White text
        withdrawButton.setFocusPainted(false); // Remove focus border
        withdrawButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1),
                BorderFactory.createEmptyBorder(10, 20, 10, 20))); // Padding inside button
        withdrawButton.setPreferredSize(new Dimension(180, 40)); // Consistent button size

        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setForeground(Color.BLUE);

        // Add components to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        add(accountNumberLabel, gbc);

        gbc.gridx = 1;
        add(accountNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(withdrawAmountLabel, gbc);

        gbc.gridx = 1;
        add(withdrawAmountField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(withdrawButton, gbc);

        gbc.gridy = 4;
        add(resultLabel, gbc);

        // Add action listener to the withdraw button
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BigInteger accountNumber = new BigInteger(accountNumberField.getText());
                    double withdrawAmount = Double.parseDouble(withdrawAmountField.getText());

                    // Call the existing withdrawMoney method
                    WithdrawResult result = WithdrawMoney.withdrawMoney(accountNumber, withdrawAmount);
                    resultLabel.setText(result.message);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Please enter a valid account number and amount.");
                }
            }
        });
    }
}
