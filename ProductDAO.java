import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public void addProduct(Product p) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                 "INSERT INTO products(name, price, quantity) VALUES (?, ?, ?)")) {

            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getQuantity());
            ps.executeUpdate();
            System.out.println("✅ Product added successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM products")) {

            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return list;
    }

    public void updateQuantity(int id, int newQty) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                 "UPDATE products SET quantity=? WHERE id=?")) {

            ps.setInt(1, newQty);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();

            if (rows > 0) System.out.println("✅ Quantity updated!");
            else System.out.println("❌ Product not found!");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // ✅ Update price method MUST be INSIDE the class
    public void updatePrice(int id, double newPrice) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                 "UPDATE products SET price=? WHERE id=?")) {

            ps.setDouble(1, newPrice);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();

            if (rows > 0) System.out.println("✅ Price updated!");
            else System.out.println("❌ Product not found!");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    public void deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("✅ Product deleted successfully!");
            else
                System.out.println("⚠️ No product found with ID: " + id);

        } catch (SQLException e) {
            System.out.println("❌ Error deleting product: " + e.getMessage());
        }
    }
}
    
    
