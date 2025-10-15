import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while (true) {
            System.out.println("\n===== SIMPLE INVENTORY SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Quantity");
            System.out.println("4. Update Price");  // NEW
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter product name: ");
                    String name = sc.next();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    dao.addProduct(new Product(name, price, qty));
                }
                case 2 -> {
                    List<Product> list = dao.getAllProducts();
                    System.out.println("ID | Name | Price | Quantity");
                    for (Product p : list) {
                        System.out.println(p.getId() + " | " + p.getName() + " | ₹" +
                                p.getPrice() + " | " + p.getQuantity());
                    }
                }
                case 3 -> {
                    System.out.print("Enter product ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new quantity: ");
                    int qty = sc.nextInt();
                    dao.updateQuantity(id, qty);
                }
                case 4 -> { // NEW CASE
                    System.out.print("Enter product ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new price: ");
                    double price = sc.nextDouble();
                    dao.updatePrice(id, price);
                }
                case 5 -> {
                    System.out.print("Enter product ID to delete: ");
                    int id = sc.nextInt();
                    dao.deleteProduct(id);
                }
                case 6 -> {
                    System.out.println("👋 Exiting program...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }

        }
    }
}
