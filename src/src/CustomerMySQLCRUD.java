//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompile
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerMySQLCRUD {
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/Store"
    private static final String USERNAME = "root";
    private static final String PASSWORD = "IST888IST888";

    public static void main(String[] args) {
        Connection connection = null;

        try (Connection connection =
                     DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {

            // INSERT
            insertCustomer(connection, 1, "John", "Doe", 20, "john@example.com", "9876543211", "123 Pine Street, Willow Grove PA, 19090");

            // READ
            System.out.println("After Insert:");
            printAllCustomers(connection);

            // UPDATE
            updateCustomer(connection, 1, "UpdatedFirstName");

            System.out.println("\nAfter Update:");
            printAllCustomers(connection);

            // DELETE
            deleteCustomer(connection, 1);

            System.out.println("\nAfter Delete:");
            printAllCustomers(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertCustomer(Connection connection, int id, String firstName, String lastName, int age, String email, String phoneNumber, String address) throws SQLException {

        String sql = "INSERT INTO customers " + "(id, firstName, lastName, age, email, phoneNumber, address) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, firstName);
            ps.setString(3, lastName);
            ps.setInt(4, age);
            ps.setString(5, email);
            ps.setString(6, phoneNumber);
            ps.setString(7, address);
            ps.executeUpdate();
        }
    }

    private static List<Customer> getAllCustomers(Connection connection) throws SQLException {

        List<Customer> customers = new ArrayList<>();

        String sql = "SELECT id, firstName, lastName, age, email, phoneNumber, address FROM customers";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                customers.add(new Customer(
                        rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"),
                        rs.getString("address")
                ));
            }
        }

        return customers;
    }

    private static void updateCustomer(Connection connection, int id, String newFirstName) throws SQLException {

        String sql = "UPDATE customers SET firstName = ? WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, newFirstName);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    private static void deleteCustomer(Connection connection, int id) throws SQLException {

        String sql = "DELETE FROM customers WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private static void printAllCustomers(Connection connection) throws SQLException {
        for (Customer customer : getAllCustomers(connection)) {
            System.out.println(customer);
        }
    }
}