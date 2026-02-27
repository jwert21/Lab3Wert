//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerMySQLCRUD {
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/Store"
    private static final String USERNAME = "root";
    private static final String PASSWORD = "IST888IST888";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Store", "root", "IST888IST888");
            insertCustomer(connection, 1, "John", "Doe", 20, "john@example.com");

            for(Customer customer : getAllCustomers(connection)) {
                System.out.println(customer.toString());
            }

            updateCustomer(connection, 1, "Updated First Name");

            for(Customer customer : getAllCustomers(connection)) {
                System.out.println(customer.toString());
            }

            deleteCustomer(connection, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    private static void insertCustomer(Connection connection, int id, String firstName, String lastName, int age, String email) throws SQLException {
        String sql = "INSERT INTO customers (id, firstName, lastName, age, email) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, email);
            preparedStatement.executeUpdate();
        }

    }

    private static List<Customer> getAllCustomers(Connection connection) throws SQLException {
        List<Customer> customers = new ArrayList();
        String sql = "SELECT id, firstName, lastName, age, email FROM customers";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                customers.add(new Customer(id, firstName, lastName, age, email));
            }
        }

        return students;
    }

    private static void updateStudent(Connection connection, int id, String newFirstName) throws SQLException {
        String sql = "UPDATE students SET firstName = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newFirstName);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }

    }

    private static void deleteStudent(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }

    }
}

