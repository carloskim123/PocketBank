
import static app.PocketBankHost.runBankSystem;
import static app.modules.loadAccounts.LOAD;

public class PocketBank {

    public static void main(String[] args) {
        LOAD();
        runBankSystem();
    }
}
