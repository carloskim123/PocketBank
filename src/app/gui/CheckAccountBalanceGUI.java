package app.gui;

import utils.AccountFinder;
import utils.BankData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class CheckAccountBalanceGUI extends JFrame {

    private final JTextField accountNumberField;

    public CheckAccountBalanceGUI() {
        // Set up the frame
        setTitle("Check Account Balance");
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
        JLabel titleLabel = new JLabel("Check Account Balance");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel accountNumberLabel = new JLabel("Account Number:");
        accountNumberLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        accountNumberField = new JTextField();
        accountNumberField.setFont(new Font("Arial", Font.PLAIN, 16));
        accountNumberField.setPreferredSize(new Dimension(250, 30)); // Adjust size

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setFont(new Font("Arial", Font.PLAIN, 16));
        checkBalanceButton.setBackground(new Color(70, 130, 180)); // SteelBlue background
        checkBalanceButton.setForeground(Color.WHITE); // White text
        checkBalanceButton.setFocusPainted(false); // Remove focus border
        checkBalanceButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1),
                BorderFactory.createEmptyBorder(10, 20, 10, 20))); // Padding inside button
        checkBalanceButton.setPreferredSize(new Dimension(180, 40)); // Consistent button size

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
        gbc.gridwidth = 2;
        add(checkBalanceButton, gbc);

        // Add action listener to the check balance button
        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BigInteger accountNumber = new BigInteger(accountNumberField.getText());

                    // Find the account using the AccountFinder utility
                    var account = AccountFinder.locateByAccountNumber(BankData.BANK, accountNumber);

                    // Create and display result in a new window
                    JFrame resultFrame = new JFrame("Account Details");
                    resultFrame.setSize(600, 400); // Set size for result window
                    resultFrame.setLocationRelativeTo(null);
                    resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    resultFrame.setLayout(new BorderLayout());

                    JLabel resultLabel = new JLabel();
                    resultLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                    resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    resultLabel.setText("<html>Account Found!<br>" +
                            "Account Number: " + account.accountNumber + "<br>" +
                            "Account Name: " + account.accountName + "<br>" +
                            "Current Balance: $" + account.balance + "</html>");
                    resultLabel.setForeground(Color.BLACK);

                    resultFrame.add(resultLabel, BorderLayout.CENTER);
                    resultFrame.setVisible(true);

                } catch (NumberFormatException ex) {
                    // Display error message in a popup
                    JOptionPane.showMessageDialog(CheckAccountBalanceGUI.this,
                            "Invalid input. Please enter a valid account number.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    // Display generic error message in a popup
                    JOptionPane.showMessageDialog(CheckAccountBalanceGUI.this,
                            "An error occurred while checking the balance.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
