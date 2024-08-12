package app.modules;

import app.PocketBankHost.Account;
import utils.AccountFinder;
import utils.BankData;
import utils.BigIntegerUtils;

import java.math.BigInteger;
import java.util.Scanner;

public class CreateAccount {
    public static void createAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's create a new account");

        System.out.print("Enter Account Name: ");
        String accountName = scanner.nextLine();

        System.out.println("Your account will be created with a starting balance of: $0.00");
        System.out.println("You can begin depositing once you have completed the account creation process!!");

        BigInteger accountNumber;
        boolean isUnique;

        do {
            // Generate a random BigInteger with sufficient bit length (e.g., 64 bits)
            accountNumber = BigIntegerUtils.generateRandomBigInteger(64);

            // Check if the generated account number is unique
            isUnique = AccountFinder.locateByAccountNumber(BankData.BANK, accountNumber) == null;
        } while (!isUnique);  // Repeat until a unique account number is found

        Account newAccount = new Account(accountNumber, 0.00, accountName);
        BankData.BANK.add(newAccount);
        saveAccounts.SAVE(newAccount);

        System.out.println("Your account number is: " + accountNumber);
        System.out.println("Account created!!!");
    }
}
