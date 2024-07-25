public class Product {
    private final String name;
    private final double price;
    private final int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    public double totalCost() {
        return this.price * this.quantity;
    }
    public String printProduct( double price, int quantity){
        return "Bottles of " + this.name + " costs $" + price + " and " + quantity + " units were purchased";
    }

}
