package app.modules;

import app.PocketBankHost;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static utils.BankData.BANK;
import static utils.BankData.BANK_STORAGE;

public class saveAccounts {
    public static void SAVE(PocketBankHost.Account newAccount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BANK_STORAGE))) {
            for (PocketBankHost.Account account : BANK) {
                writer.write(account.accountNumber.toString() + ","
                        + account.balance.toString() + ","
                        + account.accountName);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }
}
