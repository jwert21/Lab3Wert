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

        StudentCRUDExample mysql = new StudentCRUDExample();
        StudentMongoCRUDExample mongo = new StudentMongoCRUDExample();

        // CREATE
        mysql.create(student1);
        mongo.create(student1);

        // READ (read the same id you created)
        mysql.read(1);
        mongo.read(1);

        // UPDATE
        student1.setEmail("newjohn@example.com");
        student1.setFirstName("Johnny");
        mysql.update(student1);
        mongo.update(student1);

        // DELETE
        mysql.delete(1);
        mongo.delete(1);

        // cleanup
        mysql.close();
        mongo.close();
    }
}