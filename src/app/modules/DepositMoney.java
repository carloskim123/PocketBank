package app.modules;

import app.PocketBankHost.Account;
import utils.AccountFinder;
import utils.BankData;

import java.math.BigInteger;
import java.util.Scanner;

public class DepositMoney {
    public static void depositMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Depositing Portal");
        System.out.print("Enter account number: ");

        BigInteger providedAccountNumber = scanner.nextBigInteger();

        Account account = AccountFinder.locateByAccountNumber(BankData.BANK, providedAccountNumber);

        if (account != null) {
            System.out.println("Account Found!!");
            System.out.println("Confirming account number");
            System.out.println("The account's account number is: " + account.accountNumber);
            System.out.println("Account Name: " + account.accountName);
            System.out.println("Current Balance: $" + account.balance);

            // Prompt user for deposit amount
            System.out.print("Enter amount to deposit: ");
            double depositAmount = scanner.nextDouble();

            // Check if deposit amount is positive
            if (depositAmount > 0) {
                account.balance += depositAmount;
                System.out.println("Deposit successful!");
                System.out.println("New Balance: $" + account.balance);
                saveAccounts.SAVE(account);
            } else {
                System.out.println("Invalid deposit amount. Please enter a positive value.");
            }
        } else {
            System.out.println("Invalid account number");
        }
    }
}
