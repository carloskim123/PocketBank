package app.modules;

import app.PocketBankHost.Account;
import utils.AccountFinder;
import utils.BankData;

import java.math.BigInteger;

public class WithdrawMoney {
    public static WithdrawResult withdrawMoney(BigInteger accountNumber, double withdrawAmount) {
        Account account = AccountFinder.locateByAccountNumber(BankData.BANK, accountNumber);

        if (account != null) {
            // Check if withdraw amount is positive and the account has enough funds
            if (withdrawAmount > 0 && account.balance >= withdrawAmount) {
                account.balance -= withdrawAmount;
                saveAccounts.SAVE(account);

                return new WithdrawResult(true, "Withdraw successful!");
            } else {
                return new WithdrawResult(false, "Insufficient funds. Please check your current balance before making a withdrawal.");
            }
        } else {
            return new WithdrawResult(false, "Invalid account number.");
        }
    }
}
