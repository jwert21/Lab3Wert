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
            insertCustomer(connection, 1, "John", "Doe", 20, "john@example.com", 9876543211, "123 Pine Street, Willow Grove PA, 19090");

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
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Store", "root", "IST888IST888");
            insertCustomer(connection, 2, "Jonah", "Wert", 22, "jwert@gmail.com", 1234567899, "456 Broad Street, Philadelphia PA, 19115");

            for(Customer customer : getAllCustomers(connection)) {
                System.out.println(customer.toString());
            }

            updateCustomer(connection, 2, "Updated First Name");

            for(Customer customer : getAllCustomers(connection)) {
                System.out.println(customer.toString());
            }

            deleteCustomer(connection, 2);
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

            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Store", "root", "IST888IST888");
            insertCustomer(connection, 3, "Jane", "Doe", 21, "jdoe@gmail.com", 3216549877, "221 Woodland Road, Abington PA, 19001");

            for(Customer customer : getAllCustomers(connection)) {
                System.out.println(customer.toString());
            }

            updateCustomer(connection, 3, "Updated First Name");

            for(Customer customer : getAllCustomers(connection)) {
                System.out.println(customer.toString());
            }

            deleteCustomer(connection, 3);
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

    private static void insertCustomer(Connection connection, int id, String firstName, String lastName, int age, String email, String phoneNumber, String address) throws SQLException {
        String sql = "INSERT INTO customers (id, firstName, lastName, age, email, phoneNumber, address) VALUES (?, ?, ?, ?, ?, ?, ?)"

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, phoneNumber);
            preparedStatement.setString(7, address);
            preparedStatement.executeUpdate();
        }

    }

    private static List<Customer> getAllCustomers(Connection connection) throws SQLException {
        List<Customer> customers = new ArrayList();
        String sql = "SELECT id, firstName, lastName, age, email, phoneNumber, address FROM customers";

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
                int phoneNumber = resultSet.getString("phoneNumber")
                customers.add(new Customer(id, firstName, lastName, age, email, phoneNumber));
            }
        }

        return customers;
    }

    private static void updateCustomer(Connection connection, int id, String newFirstName) throws SQLException {
        String sql = "UPDATE customers SET firstName = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newFirstName);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }

    }

    private static void deleteCustomer(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM customers WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }

    }

    private static void insertCustomer2(Connection connection, int id, String firstName, String lastName, int age, String email, String phoneNumber) throws SQLException {
        String sql = "INSERT INTO customers (id, firstName, lastName, age, email, phoneNumber, address) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, phoneNumber)
            preparedStatement.executeUpdate();
        }

    }

    private static List<Customer2> getAllCustomers(Connection connection) throws SQLException {
        List<Customer2> customers = new ArrayList();
        String sql = "SELECT id, firstName, lastName, age, email, phoneNumber, address FROM customers";

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
                String phoneNumber = resultSet.getInt("phoneNumber")
                customers.add(new Customer(id, firstName, lastName, age, email, phoneNumber, address));
            }
        }

        return customers;
    }

    private static void updateCustomer2(Connection connection, int id, String newFirstName) throws SQLException {
        String sql = "UPDATE customers SET firstName = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newFirstName);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }

    }

    private static void deleteCustomer2(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM customers WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }

    }

    private static void insertCustomer3(Connection connection, int id, String firstName, String lastName, int age, String email, int phoneNumber) throws SQLException {
        String sql = "INSERT INTO customers (id, firstName, lastName, age, email, phoneNumber, address) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, phoneNumber)
            preparedStatement.executeUpdate();
        }

    }

    private static List<Customer3> getAllCustomers(Connection connection) throws SQLException {
        List<Customer3> customers = new ArrayList();
        String sql = "SELECT id, firstName, lastName, age, email, phoneNumber, address FROM customers";

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
                int phoneNumber = resultSet.getInt("phoneNumber")
                customers.add(new Customer(id, firstName, lastName, age, email, phoneNumber, address));
            }
        }

        return customers;
    }

    private static void updateCustomer3(Connection connection, int id, String newFirstName) throws SQLException {
        String sql = "UPDATE customers SET firstName = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newFirstName);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }

    }

    private static void deleteCustomer3(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM customers WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }

    }
}

