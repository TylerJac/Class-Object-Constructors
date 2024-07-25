public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Tyler", 500);
        account.deposit(100);
        System.out.println("My balance after deposit: " + account.getBalance());
        System.out.println(account);

        BankAccount account2 = new BankAccount("Larry", 5000);
        BankAccount account3 = new BankAccount("Mary", 300);
        System.out.println("Larry's balance after withdrawal: " + account2.withdraw(100));
        System.out.println("Marry's balance after deposit: " + account3.deposit(100));

        Product product = new Product("Cola", 8.65, 100);

        System.out.println(product.printProduct(product.getPrice(), product.getQuantity()));
        System.out.println("Total cost is " + product.totalCost());
    }
}
