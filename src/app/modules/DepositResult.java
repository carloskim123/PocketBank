package app.modules;

public class DepositResult {
    public boolean success;
    public String message;

    public DepositResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
