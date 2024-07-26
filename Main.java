public class Main {

    public static void main(String[] args) {

        Product product = new Product("Cola", 8.65, 100);
        System.out.println(product.printProduct(product.getPrice(), product.getQuantity()));
        System.out.println("Total cost is " + product.totalCost());
    }
}
