package utils;

import java.math.BigInteger;
import java.util.ArrayList;

import static app.PocketBankHost.Account;

public class AccountFinder {

    /**
     * Locates an account by its account number.
     *
     * @param BANK The list of accounts in the bank.
     * @param accountNumber The account number to locate.
     * @return The account with the specified account number, or null if not found.
     */
    public static Account locateByAccountNumber(ArrayList<Account> BANK, BigInteger accountNumber) {
        for (Account account : BANK) {
            if (account.accountNumber.equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}

