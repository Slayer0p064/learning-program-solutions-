package Exercise_2;

public class Product2 {
    int productId;
    String productName;
    String category;

    public Product2(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }

    public String toString() {
        return "[" + productId + "] " + productName + " - " + category;
    }
}
