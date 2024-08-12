package app.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static app.modules.loadAccounts.LOAD;

public class PocketBankGUI extends JFrame {

    public PocketBankGUI() {
        // Set up the main frame
        setTitle("Pocket Banking Agency");
        setSize(900, 700); // Larger window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); // Disable resizing
        setLayout(new GridBagLayout()); // Use GridBagLayout for better positioning

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); // Add padding around components
        gbc.anchor = GridBagConstraints.BASELINE;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make buttons stretch horizontally

        // Create and style components
        JLabel titleLabel = new JLabel("Welcome to Pocket Banking Agency");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton createAccountButton = new JButton("Create a New Account");
        JButton depositMoneyButton = new JButton("Deposit Money");
        JButton withdrawMoneyButton = new JButton("Withdraw Money");
        JButton checkBalanceButton = new JButton("Check Account Balance");
        JButton exitButton = new JButton("Exit");

        // Style buttons
        styleButton(createAccountButton);
        styleButton(depositMoneyButton);
        styleButton(withdrawMoneyButton);
        styleButton(checkBalanceButton);
        styleButton(exitButton);

        // Add components to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(createAccountButton, gbc);

        gbc.gridx = 1;
        add(depositMoneyButton, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        add(withdrawMoneyButton, gbc);

        gbc.gridx = 1;
        add(checkBalanceButton, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(exitButton, gbc);

        // Add action listeners to buttons
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateAccountGUI().setVisible(true);
            }
        });

        depositMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DepositMoneyGUI().setVisible(true);
            }
        });

        withdrawMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WithdrawMoneyGUI().setVisible(true);
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CheckAccountBalanceGUI().setVisible(true);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBackground(new Color(70, 130, 180)); // SteelBlue background
        button.setForeground(Color.WHITE); // White text
        button.setFocusPainted(false); // Remove focus border
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1),
                BorderFactory.createEmptyBorder(10, 20, 10, 20))); // Padding inside button
        button.setPreferredSize(new Dimension(250, 40)); // Consistent button size
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LOAD(); // Load accounts from a prepopulated access point
            new PocketBankGUI().setVisible(true);
        });
    }
}
