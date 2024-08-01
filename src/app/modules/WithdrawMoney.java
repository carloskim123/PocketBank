package app.modules;

import app.PocketBankHost.Account;
import utils.AccountFinder;
import utils.BankData;

import java.math.BigInteger;
import java.util.Scanner;

public class WithdrawMoney {
    public static void withdrawMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");

        BigInteger providedAccountNumber = scanner.nextBigInteger();

        Account account = AccountFinder.locateByAccountNumber(BankData.BANK, providedAccountNumber);

        if (account != null) {
            System.out.println("Account Found!!");
            System.out.println("The account's account number is: " + account.accountNumber);
            System.out.println("Account Name: " + account.accountName);
            System.out.println("Current Balance: $" + account.balance);

            // Prompt user for withdraw amount
            System.out.print("Enter amount to withdraw: ");
            double withdrawAmount = scanner.nextDouble();

            // Check if withdraw amount is positive and the account has enough funds
            if (withdrawAmount > 0 && account.balance >= withdrawAmount) {
                account.balance -= withdrawAmount;
                System.out.println("Withdraw successful!");
                System.out.println("New Balance: $" + account.balance);
            } else {
                System.out.println("Insufficient funds. You can withdraw anything less than or equal to " + account.balance);
            }
        } else {
            System.out.println("Invalid account number");
        }
    }
}
