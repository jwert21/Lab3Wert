/** Project: Lab 3
 * Purpose Details:
 * Course: IST 242
 * Author: Jonah Wert
 * Date Developed: 2/26/2026
 * Last Date Changed: 3/1/2026
 * Rev: 3/1/2026

 */

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class CustomerMongoCRUD implements CustomerCRUD {

    private MongoCollection<Document> collection;

    public CustomerMongoCRUD() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("store");
        this.collection = database.getCollection("customers");
    }

    @Override
    public void create(Customer customer) {
        Document doc = new Document("id", customer.getId())
                .append("first_name", customer.getFirstName())
                .append("last_name", customer.getLastName())
                .append("age", customer.getAge())
                .append("email", customer.getEmail())
                .append("phoneNumber", customer.getPhoneNumber());
        collection.insertOne(doc);
    }

    @Override
    public Customer read(int id) {
        Document filter = new Document("id", id);
        Document doc = collection.find(filter).first();
        if (doc != null) {
            return new Customer(
                    doc.getInteger("id"),
                    doc.getString("first_name"),
                    doc.getString("last_name"),
                    doc.getInteger("age"),
                    doc.getString("email"),
                    doc.getString("phoneNumber")
            );
        }
        return null;
    }

    @Override
    public void update(Customer customer) {
        Document filter = new Document("id", customer.getId());
        Document update = new Document("$set", new Document("email", customer.getEmail()));
        collection.updateOne(filter, update);
    }

    @Override
    public void delete(int id) {
        Document filter = new Document("id", id);
        collection.deleteOne(filter);
    }
}