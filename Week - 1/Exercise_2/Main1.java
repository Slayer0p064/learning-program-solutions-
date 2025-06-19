package Exercise_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Product2[] products = {
            new Product2(1, "Laptop", "Electronics"),
            new Product2(2, "Phone", "Electronics"),
            new Product2(3, "Shoes", "Footwear"),
            new Product2(4, "Jeans", "Clothing"),
            new Product2(5, "Watch", "Accessories")
        };

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Linear Search ===");
        System.out.print("Enter product name to search: ");
        String name1 = sc.nextLine();
        Product2 result1 = linearSearchByName(products, name1);
        System.out.println(result1 != null ? "✅ Found: " + result1 : "❌ Not found");

        System.out.println("\n=== Binary Search ===");
        sortByName(products); // Sort array first
        System.out.print("Enter product name to search: ");
        String name2 = sc.nextLine();
        Product2 result2 = binarySearchByName(products, name2);
        System.out.println(result2 != null ? "✅ Found: " + result2 : "❌ Not found");

        sc.close();
    }

    // ✅ Linear Search using Product2
    public static Product2 linearSearchByName(Product2[] products, String name) {
        for (Product2 p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // ✅ Sort products by name using Product2
    public static void sortByName(Product2[] products) {
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
    }

    // ✅ Binary Search using Product2
    public static Product2 binarySearchByName(Product2[] products, String name) {
        int left = 0, right = products.length - 1;
        name = name.toLowerCase();

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.toLowerCase().compareTo(name);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }
}
