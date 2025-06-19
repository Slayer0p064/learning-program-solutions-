package Exercise_2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(); // Start with empty product list

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- E-commerce Product Search ---");
            System.out.println("1. Add Product");
            System.out.println("2. Search by Linear Search");
            System.out.println("3. Search by Binary Search");
            System.out.println("4. View All Products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine(); // consume newline

                    System.out.print("Enter Type: ");
                    String type = sc.nextLine();

                    products.add(new Product(id, name, quantity, price, type));
                    System.out.println("Product added successfully.");
                    break;

                case 2:
                    System.out.print("Enter product name to search (Linear): ");
                    String name1 = sc.nextLine();
                    Product result1 = linearSearchByName(products, name1);
                    System.out.println(result1 != null ? "Found: " + result1 : "Not found");
                    break;

                case 3:
                    System.out.print("Enter product name to search (Binary): ");
                    String name2 = sc.nextLine();
                    sortByName(products); // Sort before binary search
                    Product result2 = binarySearchByName(products, name2);
                    System.out.println(result2 != null ? "Found: " + result2 : " Not found");
                    break;

                case 4:
                    System.out.println("\n All Products:");
                    if (products.isEmpty()) {
                        System.out.println(" No products added yet.");
                    } else {
                        for (Product p : products) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 5:
                    System.out.println(" Exiting...");
                    break;

                default:
                    System.out.println(" Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }

    // Linear Search
    public static Product linearSearchByName(List<Product> products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // Sort products by name (for binary search)
    public static void sortByName(List<Product> products) {
        products.sort(Comparator.comparing(p -> p.productName.toLowerCase()));
    }

    // Binary Search
    public static Product binarySearchByName(List<Product> products, String name) {
        int left = 0, right = products.size() - 1;
        name = name.toLowerCase();

        while (left <= right) {
            int mid = (left + right) / 2;
            String midName = products.get(mid).productName.toLowerCase();
            int cmp = midName.compareTo(name);

            if (cmp == 0) return products.get(mid);
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }

        return null;
    }
}
