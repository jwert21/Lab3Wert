/** Project: Lab 3
 * Purpose Details:
 * Course: IST 242
 * Author: Jonah Wert
 * Date Developed: 2/26/2026
 * Last Date Changed: 3/1/2026
 * Rev: 3/1/2026

 */

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "John", "Doe", 20, "john@example.com", "9876543211");
        Customer customer2 = new Customer(2, "Jonah", "Wert", 22, "jwert@gmail.com", "1234569877");
        Customer customer3 = new Customer(3, "Jane", "Doe", 21, "jdoe@gmail.com", "3216549877");

        Customer mysql = new CustomerMySQLCRUD();
        Customer mongo = new CustomerMongoCRUD();

        mysql.create(customer1);
        mysql.create(customer2);
        mysql.create(customer3);

        mongo.create(customer1);
        mongo.create(customer2);
        mongo.create(customer3);

        mysql.read(1);
        mongo.read(2);

        customer1.setEmail("newjohn@example.com");
        mysql.update(customer1);
        mongo.update(customer1);

        mysql.delete(3);
        mongo.delete(3);
    }
}