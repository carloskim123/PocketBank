package app.modules;

public class WithdrawResult {
    public boolean success;
    public String message;

    public WithdrawResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
