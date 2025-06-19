package Exercise_1;

public class product {
    int productId;
    String productName;
    int quantity;
    String type;
    double price;

    public product(int productId, String productName, int quantity, double price, String type) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "[" + productId + "] " + productName + " | Qty: " + quantity + " | " + price + " | Type: " + type;
    }
}
// This class represents a product with an ID, name, quantity, and price.
// It includes a constructor to initialize these fields and a toString method for easy display.
