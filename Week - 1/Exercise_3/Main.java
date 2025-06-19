package Exercise_3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>(Arrays.asList(
            new Order(1, "Alice", 2500.0),
            new Order(2, "Bob", 1800.5),
            new Order(3, "Charlie", 3200.0),
            new Order(4, "David", 1500.0),
            new Order(5, "Eva", 4100.0)
        ));

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Customer Order Sorting ---");
            System.out.println("1. View Unsorted Orders");
            System.out.println("2. Sort using Bubble Sort (Descending)");
            System.out.println("3. Sort using Quick Sort (Descending)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n📦 Orders:");
                    for (Order o : orders) System.out.println(o);
                    break;

                case 2:
                    bubbleSort(orders);
                    System.out.println("✅ Orders sorted by Bubble Sort.");
                    break;

                case 3:
                    quickSort(orders, 0, orders.size() - 1);
                    System.out.println("✅ Orders sorted by Quick Sort.");
                    break;

                case 4:
                    System.out.println("👋 Exiting...");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice. Try again.");
            }
        } while (choice != 4);

        sc.close();
    }

    // 🔁 Bubble Sort (Descending)
    public static void bubbleSort(List<Order> orders) {
        int n = orders.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders.get(j).totalPrice < orders.get(j + 1).totalPrice) {
                    Collections.swap(orders, j, j + 1);
                }
            }
        }
    }

    // ⚡ Quick Sort (Descending)
    public static void quickSort(List<Order> orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    public static int partition(List<Order> orders, int low, int high) {
        double pivot = orders.get(high).totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders.get(j).totalPrice > pivot) {
                i++;
                Collections.swap(orders, i, j);
            }
        }

        Collections.swap(orders, i + 1, high);
        return i + 1;
    }
}
