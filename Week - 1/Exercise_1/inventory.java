package Exercise_1;

import java.util.*;

public class inventory {
    private Map<Integer, product> inventory = new HashMap<>();

    public void addProduct(product p) {
        inventory.put(p.productId, p);
        System.out.println("Product added: " + p);
    }

    public void updateProduct(int id, product updated) {
        if (inventory.containsKey(id)) {
            inventory.put(id, updated);
            System.out.println("Product updated: " + updated);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int id) {
        product removed = inventory.remove(id);
        if (removed != null) {
            System.out.println("Product removed: " + removed);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void viewAll() {
        System.out.println("\n--- Inventory ---");
        for (product p : inventory.values()) {
            System.out.println(p);
        }
    }
}

// This class manages the inventory of products.
// It allows adding, updating, deleting, and viewing products.