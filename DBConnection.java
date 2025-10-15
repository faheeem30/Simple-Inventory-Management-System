import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql:#mysqljdbc link",
                "root",
                "#mysql password"
            );
        } catch (Exception e) {
            System.out.println("Database connection error: " + e);
        }
        return con;
    }
}


