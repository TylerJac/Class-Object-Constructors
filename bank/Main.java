package bank;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();
        System.out.println("Welcome to the Bank!");

        while (true) {
            System.out.println("1. Create a new account");
            System.out.println("2. Access an existing account");
            System.out.println("0. Exit");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (option == 0) {
                break;
            }

            switch (option) {
                case 1:
                    accounts.add(new BankAccount());
                    break;
                case 2:
                    System.out.print("Enter your account name: ");
                    String accountName = scanner.nextLine();
                    BankAccount foundAccount = accounts.stream()
                            .filter(acc -> acc.getAccountName().equalsIgnoreCase(accountName))
                            .findFirst()
                            .orElse(null);

                    if (foundAccount == null) {
                        System.out.println("Account not found.");
                    } else {
                        mainMenu(scanner, foundAccount, accounts);
                    }
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();


        BankAccount account = new BankAccount("Tyler", 500, 100);
        account.deposit(100);
        System.out.println("My balance after deposit: " + account.getBalance());
        System.out.println(account);

        BankAccount account2 = new BankAccount("Larry", 5000,1);
        BankAccount account3 = new BankAccount("Mary", 300,12);
        System.out.println("Larry's balance after withdrawal: " + account2.withdraw(100));
        System.out.println("Marry's balance after deposit: " + account3.deposit(100));
    }
    private static void mainMenu(Scanner scanner, BankAccount foundAccount, ArrayList<BankAccount> accounts) {
        System.out.println("Welcome, " + foundAccount.getAccountName() + "!");
        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check balance");
            System.out.println("2. Withdraw money");
            System.out.println("3. Deposit money");
            System.out.println("4. Make a transfer to another bank account");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: $" + foundAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    foundAccount.withdraw(withdrawAmount);
                    System.out.println("Withdrawal successful!");
                    break;
                case 3:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    foundAccount.deposit(depositAmount);
                    System.out.println("Deposit successful!");
                    break;
                case 4:
                    System.out.print("Please enter the account number to transfer to: ");
                    int targetAccountNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    BankAccount targetAccount = accounts.stream()
                            .filter(acc -> acc.getNumber() == targetAccountNumber)
                            .findFirst()
                            .orElse(null);

                    if (targetAccount != null) {
                        System.out.print("Please enter the amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        foundAccount.transfer(transferAmount, targetAccount);
                        System.out.println( foundAccount);
                        System.out.println(targetAccount);
                    } else {
                        System.out.println("Target account not found.");
                    }

                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
