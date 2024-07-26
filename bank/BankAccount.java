package bank;
import java.util.Scanner;
public class BankAccount {
    private final String accountName;
    private double balance;
    private final int number;

    public BankAccount(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the account holder's name: ");
        this.accountName = scanner.nextLine();
        System.out.print("Enter the starting balance: ");
        this.balance = scanner.nextDouble();
        System.out.print("Enter the account number: ");
        this.number = scanner.nextInt();
        scanner.nextLine();
    }

    public BankAccount(String accountName, double initialBalance, int number) {
        this.accountName = accountName;
        this.balance = initialBalance;
        this.number = number;
    }
    public String getAccountName() {
        return accountName;
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
    public int getNumber() {
        return number;
    }
    public void transfer(double amount, BankAccount targetAccount) {
        if (targetAccount != null && amount > 0 && amount <= this.balance) {
            this.withdraw(amount);
            targetAccount.deposit(amount);
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Invalid transfer amount or target account.");
        }
    }

    public String toString() {
        return "The name on the account is: " + this.accountName + " and they have a balance of $" + this.balance;
    }
}
