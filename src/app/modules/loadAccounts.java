package app.modules;

import app.PocketBankHost;
import utils.BankData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class loadAccounts {
    public static void LOAD() {
        // LOAD accounts
        try (BufferedReader reader = new BufferedReader(new FileReader(BankData.BANK_STORAGE))){
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts.length == 3) {
                    BigInteger accountNumber = new BigInteger(parts[0]);
                    double balance = Double.parseDouble(parts[1]);
                    String accountName = parts[2];
                    System.out.println(Arrays.toString(parts));
                    PocketBankHost.Account account = new PocketBankHost.Account(accountNumber, balance, accountName);
                    BankData.BANK.add(account);

                }

            }
        } catch (IOException ioe) {
            System.out.println("An error occured while loading accounts!!" + ioe.toString());
        }
    }
}
