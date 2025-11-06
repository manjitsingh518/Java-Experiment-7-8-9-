import java.sql.*;

public class FetchEmployeeData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database_name";  // Replace with your DB name
        String user = "root";      // Replace with your MySQL username
        String password = "root";  // Replace with your MySQL password

        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to Database!");

            // Step 3: Create statement
            Statement stmt = con.createStatement();

            // Step 4: Execute query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");

            // Step 5: Display records
            System.out.println("EmpID\tName\tSalary");
            while (rs.next()) {
                int id = rs.getInt("EmpID");
                String name = rs.getString("Name");
                double salary = rs.getDouble("Salary");
                System.out.println(id + "\t" + name + "\t" + salary);
            }

            // Step 6: Close connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
