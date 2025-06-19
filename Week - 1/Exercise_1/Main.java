package Exercise_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        inventory inv = new inventory();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Product\n2. Update Product\n3. Delete Product\n4. View All\n5. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter ID, Name, Quantity, Price: ,Type");
                    product p = new product(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble(),sc.next());
                    inv.addProduct(p);
                    break;
                case 2:
                    System.out.println("Enter ID to Update:");
                    int idU = sc.nextInt();
                    System.out.println("Enter New Name, Quantity, Price: , Type");
                    product upd = new product(idU, sc.next(), sc.nextInt(), sc.nextDouble(),sc.next());
                    inv.updateProduct(idU, upd);
                    break;
                case 3:
                    System.out.println("Enter ID to Delete:");
                    inv.deleteProduct(sc.nextInt());
                    break;
                case 4:
                    inv.viewAll();
                    break;
            }
        } while (choice != 5);
        sc.close();
    }
}
// This is the main class that runs the inventory management system.
// It provides a menu for the user to add, update, delete, and view products in the inventory.
// The user interacts with the system through a console interface, and the inventory is managed using the `inventory` class.
// The program continues to run until the user chooses to exit by entering 5.
