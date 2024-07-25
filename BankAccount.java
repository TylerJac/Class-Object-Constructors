public class BankAccount {
    private final String accountName;
    private double balance;

    public BankAccount(String accountName, double initialBalance) {
        this.accountName = accountName;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
        return balance;

    }

    public double withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid withdrawal amount." +
                    " Please enter a positive value and not exceeding the current balance.");
        }
        return balance;
    }
    public String toString() {
        return "Bank Account: " + this.accountName + ", Balance: $" + this.balance;
    }
}
