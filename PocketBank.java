
import app.gui.PocketBankGUI;

import javax.swing.*;

import static app.modules.loadAccounts.LOAD;

public class PocketBank {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LOAD(); // Load accounts from a prepopulated access point
            new PocketBankGUI().setVisible(true);
        });
    }
}