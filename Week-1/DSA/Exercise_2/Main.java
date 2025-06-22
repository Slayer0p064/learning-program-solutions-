package DSA.Exercise_2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Apple", 50, 0.5, "Fruit"));
        products.add(new Product(2, "Banana", 30, 0.3, "Fruit"));
        products.add(new Product(3, "Carrot", 20, 0.2, "Vegetable"));
        products.add(new Product(4, "Doughnut", 15, 0.1, "Snack"));
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Product Search ---");
            System.out.println("1. Add Product");
            System.out.println("2. Linear Search");
            System.out.println("3. Binary Search");
            System.out.println("4. View All");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Qty: ");
                    int qty = sc.nextInt();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Type: ");
                    String type = sc.nextLine();
                    products.add(new Product(id, name, qty, price, type));
                    break;

                case 2:
                    System.out.print("Search (Linear) Name: ");
                    String searchL = sc.nextLine();
                    Product foundL = linearSearch(products, searchL);
                    System.out.println(foundL != null ? foundL : "Not found");
                    break;

                case 3:
                    System.out.print("Search (Binary) Name: ");
                    String searchB = sc.nextLine();
                    sortByName(products);
                    Product foundB = binarySearch(products, searchB);
                    System.out.println(foundB != null ? foundB : "Not found");
                    break;

                case 4:
                    for (Product p : products) System.out.println(p);
                    break;
            }

        } while (choice != 5);
        sc.close();
    }

    public static Product linearSearch(List<Product> products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) return p;
        }
        return null;
    }

    public static void sortByName(List<Product> products) {
        products.sort(Comparator.comparing(p -> p.productName.toLowerCase()));
    }

    public static Product binarySearch(List<Product> products, String name) {
        int left = 0, right = products.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products.get(mid).productName.compareToIgnoreCase(name);
            if (cmp == 0) return products.get(mid);
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }
}
