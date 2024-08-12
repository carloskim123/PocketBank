package app.modules;

import app.PocketBankHost.Account;
import utils.AccountFinder;
import utils.BankData;

import java.math.BigInteger;
import java.util.Scanner;
public class CheckAccountBalance {
    public static void checkAccountBalance() {
        System.out.println("Welcome to Pocket Banking Agency : Check Balance");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");

        BigInteger providedAccountNumber = scanner.nextBigInteger();

        Account account = AccountFinder.locateByAccountNumber(BankData.BANK, providedAccountNumber);

        if (account != null) {
            System.out.println("Account Found!!");
            System.out.println("The account's account number is: " + account.accountNumber);
            System.out.println("Account Name: " + account.accountName);
            System.out.println("Current Balance: $" + account.balance);
        } else {
            System.out.println("Invalid account number");
        }
    }
}
