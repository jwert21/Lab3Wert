/** Project: Lab 3
 * Purpose Details:
 * Course: IST 242
 * Author: Jonah Wert
 * Date Developed: 2/26/2026
 * Last Date Changed: 3/1/2026
 * Rev: 3/1/2026

 */

import com.mongodb.client.*;
        import org.bson.Document;

public class CustomerMongoCRUD {

    private final MongoClient mongoClient;
    private final MongoCollection<Document> collection;

    public CustomerMongoCRUD() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("store");
        collection = database.getCollection("customers");
    }

    public void close() {
        mongoClient.close();
    }

    // CREATE
    public void create(Customer customer) {
        Document doc = new Document("id", customer.getId())
                .append("first_name", customer.getFirstName())
                .append("last_name", customer.getLastName())
                .append("age", customer.getAge())
                .append("email", customer.getEmail())
                .append("phoneNumber", customer.getPhoneNumber());

        collection.insertOne(doc);
    }

    // READ (by id)
    public void read(int id) {
        Document doc = collection.find(new Document("id", id)).first();
        if (doc == null) {
            System.out.println("Mongo: No customer found with id=" + id);
        } else {
            System.out.println(doc.toJson());
        }
    }

    // UPDATE (by id)
    public void update(Customer customer) {
        Document filter = new Document("id", customer.getId());
        Document set = new Document("first_name", customer.getFirstName())
                .append("last_name", customer.getLastName())
                .append("age", customer.getAge())
                .append("email", customer.getEmail())
                .append("phoneNumber", customer.getPhoneNumber());

        collection.updateOne(filter, new Document("$set", set));
    }

    // DELETE (by id)
    public void delete(int id) {
        collection.deleteOne(new Document("id", id));
    }
}