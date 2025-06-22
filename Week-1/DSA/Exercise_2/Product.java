package DSA.Exercise_2;

public class Product {
    int productId;
    String productName;
    int quantity;
    double price;
    String type;

    public Product(int productId, String productName, int quantity, double price, String type) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "[" + productId + "] " + productName + " | Qty: " + quantity + " | Price " + price + " | Type: " + type;
    }
}
