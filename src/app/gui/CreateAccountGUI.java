package app.gui;

import app.modules.CreateAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.datatransfer.*;
import java.math.BigInteger;

public class CreateAccountGUI extends JFrame {

    private final JTextField accountNameField;
    private final JLabel resultLabel;

    public CreateAccountGUI() {
        // Set up the frame
        setTitle("Create New Account");
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
        JLabel titleLabel = new JLabel("Create a New Account");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel accountNameLabel = new JLabel("Account Name:");
        accountNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        accountNameField = new JTextField();
        accountNameField.setFont(new Font("Arial", Font.PLAIN, 16));
        accountNameField.setPreferredSize(new Dimension(250, 30)); // Adjust size

        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setFont(new Font("Arial", Font.PLAIN, 16));
        createAccountButton.setBackground(new Color(70, 130, 180)); // SteelBlue background
        createAccountButton.setForeground(Color.WHITE); // White text
        createAccountButton.setFocusPainted(false); // Remove focus border
        createAccountButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1),
                BorderFactory.createEmptyBorder(10, 20, 10, 20))); // Padding inside button
        createAccountButton.setPreferredSize(new Dimension(180, 40)); // Consistent button size

        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setForeground(Color.GREEN);

        // Add components to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        add(accountNameLabel, gbc);

        gbc.gridx = 1;
        add(accountNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(createAccountButton, gbc);

        gbc.gridy = 3;
        add(resultLabel, gbc);

        // Add action listener to the create account button
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountName = accountNameField.getText().trim();
                if (!accountName.isEmpty()) {
                    // Call the existing createAccount method
                    BigInteger accountNumber = CreateAccount.createAccount(accountName);

                    // Show a success message dialog
                    JOptionPane.showMessageDialog(CreateAccountGUI.this,
                            "Account created successfully!\nAccount Number: " + accountNumber,
                            "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Copy the account number to the clipboard
                    copyToClipboard(accountNumber.toString());

                    // Delay before closing the window
                    new Timer(5000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dispose(); // Close the CreateAccountGUI
                        }
                    }).start();
                } else {
                    resultLabel.setText("Please enter an account name.");
                }
            }
        });
    }

    private void copyToClipboard(String text) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, null);
    }
}
