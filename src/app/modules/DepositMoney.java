package app.modules;

import app.PocketBankHost.Account;
import utils.AccountFinder;
import utils.BankData;
import app.modules.DepositResult;

import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.Scanner;

public class DepositMoney {
    public static DepositResult depositMoney(BigInteger accountNumber, double depositAmount) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Welcome to the Depositing Portal");
//        System.out.print("Enter account number: ");
//
//        BigInteger providedAccountNumber = scanner.nextBigInteger();
        System.out.println("provided acc. number: " + accountNumber);
        Account account = AccountFinder.locateByAccountNumber(BankData.BANK, accountNumber);

        if (account != null) {
            System.out.println("Account Found!!");
            System.out.println("Confirming account number");
            System.out.println("The account's account number is: " + account.accountNumber);
            System.out.println("Account Name: " + account.accountName);
            System.out.println("Current Balance: $" + account.balance);

            // Prompt user for deposit amount
//            System.out.print("Enter amount to deposit: ");
//            double depositAmount = scanner.nextDouble();

            // Check if deposit amount is positive
            if (depositAmount > 0) {
                account.balance += depositAmount;
                System.out.println("Deposit successful!");
                System.out.println("New Balance: $" + account.balance);
                saveAccounts.SAVE(account);

                return new DepositResult(true, "Deposit successful!");

            } else {
                return new DepositResult(false, "Deposit unsuccessful!");
            }
        } else {
            return new DepositResult(false, "Invalid account number");
        }
    }
}
