package tests;

import app.modules.loadAccounts;

public class TestIO {
    public static void main(String[] args) {
        loadAccounts.LOAD();
        System.out.println(utils.BankData.BANK);
    }
}
