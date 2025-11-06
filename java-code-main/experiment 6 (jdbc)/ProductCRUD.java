import java.sql.*;
import java.util.Scanner;

public class ProductCRUD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String user = "root";
        String password = "root";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con.setAutoCommit(false); // For transaction handling

            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("\n===== Product CRUD Menu =====");
                System.out.println("1. Insert Product");
                System.out.println("2. View Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("Enter ProductID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Product Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();
                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();

                        String insertQuery = "INSERT INTO Product VALUES (?, ?, ?, ?)";
                        PreparedStatement ps1 = con.prepareStatement(insertQuery);
                        ps1.setInt(1, id);
                        ps1.setString(2, name);
                        ps1.setDouble(3, price);
                        ps1.setInt(4, qty);
                        ps1.executeUpdate();
                        con.commit();
                        System.out.println("✅ Product Inserted Successfully!");
                        break;

                    case 2:
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
                        System.out.println("ProductID\tName\tPrice\tQuantity");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" +
                                    rs.getDouble(3) + "\t" + rs.getInt(4));
                        }
                        break;

                    case 3:
                        System.out.print("Enter ProductID to Update: ");
                        int pid = sc.nextInt();
                        System.out.print("Enter new Price: ");
                        double newPrice = sc.nextDouble();

                        String updateQuery = "UPDATE Product SET Price=? WHERE ProductID=?";
                        PreparedStatement ps2 = con.prepareStatement(updateQuery);
                        ps2.setDouble(1, newPrice);
                        ps2.setInt(2, pid);
                        int rows = ps2.executeUpdate();
                        if (rows > 0) {
                            con.commit();
                            System.out.println("✅ Product Updated Successfully!");
                        } else {
                            System.out.println("❌ Product not found!");
                        }
                        break;

                    case 4:
                        System.out.print("Enter ProductID to Delete: ");
                        int did = sc.nextInt();
                        String deleteQuery = "DELETE FROM Product WHERE ProductID=?";
                        PreparedStatement ps3 = con.prepareStatement(deleteQuery);
                        ps3.setInt(1, did);
                        int delRows = ps3.executeUpdate();
                        if (delRows > 0) {
                            con.commit();
                            System.out.println("✅ Product Deleted Successfully!");
                        } else {
                            System.out.println("❌ Product not found!");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        sc.close();
                        con.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
