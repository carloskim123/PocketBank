package app.gui;

import app.modules.DepositMoney;
import app.modules.DepositResult;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class DepositMoneyGUI extends JFrame {

    private final JTextField accountNumberField;
    private final JTextField depositAmountField;
    private final JLabel resultLabel;

    public DepositMoneyGUI() {
        // Set up the frame
        setTitle("Deposit Money");
        setSize(800, 500); // Increased size for better usability
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); // Prevent resizing
        setLayout(new GridBagLayout()); // Use GridBagLayout for modern layout

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Create components
        JLabel titleLabel = new JLabel("Deposit Money");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Larger title font
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel accountNumberLabel = new JLabel("Account Number:");
        accountNumberLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Larger label font

        accountNumberField = new JTextField();
        accountNumberField.setFont(new Font("Arial", Font.PLAIN, 18));
        accountNumberField.setPreferredSize(new Dimension(250, 30)); // Adjust size

        JLabel depositAmountLabel = new JLabel("Amount to Deposit:");
        depositAmountLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Larger label font

        depositAmountField = new JTextField();
        depositAmountField.setFont(new Font("Arial", Font.PLAIN, 18));
        depositAmountField.setPreferredSize(new Dimension(250, 30)); // Adjust size

        JButton depositButton = new JButton("Deposit");
        depositButton.setFont(new Font("Arial", Font.PLAIN, 18));
        depositButton.setBackground(new Color(34, 139, 34)); // ForestGreen background
        depositButton.setForeground(Color.WHITE); // White text
        depositButton.setFocusPainted(false); // Remove focus border
        depositButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1),
                BorderFactory.createEmptyBorder(10, 20, 10, 20))); // Padding inside button
        depositButton.setPreferredSize(new Dimension(180, 40)); // Consistent button size

        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setForeground(Color.BLUE);

        // Add components to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(accountNumberLabel, gbc);

        gbc.gridx = 1;
        add(accountNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(depositAmountLabel, gbc);

        gbc.gridx = 1;
        add(depositAmountField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(depositButton, gbc);

        gbc.gridy = 4;
        add(resultLabel, gbc);

        // Add action listener to the deposit button
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BigInteger accountNumber = new BigInteger(accountNumberField.getText());
                    double depositAmount = Double.parseDouble(depositAmountField.getText());

                    DepositResult result = DepositMoney.depositMoney(accountNumber, depositAmount);

                    resultLabel.setText(result.message);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Please enter a valid account number and amount.");
                }
            }
        });
    }
}
