package app;


import app.modules.CheckAccountBalance;
import app.modules.DepositMoney;
import app.modules.WithdrawMoney;
import app.modules.CreateAccount;



import java.math.BigInteger;
import java.util.Scanner;



public class PocketBankHost {

    public static class Account {
        public BigInteger accountNumber;
        public Double balance;
        public String accountName;

        public Account(BigInteger accountNumber, Double balance, String accountName) {
            this.accountNumber = accountNumber;
            this.balance = balance;
            this.accountName = accountName;
        }
    }

    public static void displayMenu() {
        System.out.println("Welcome to Pocket Banking Agency");
        System.out.println("1. Create a New Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Account Balance");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void runBankSystem() {
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
//                    CreateAccount.createAccount();
                    break;
                case 2:
//                    DepositMoney.depositMoney();
                    break;
                case 3:
//                    WithdrawMoney.withdrawMoney();
                    break;
                case 4:
                    CheckAccountBalance.checkAccountBalance();
                    break;
                case 5:
                    System.out.println("Thanks for visiting Pocket Banking Agency");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }


}
