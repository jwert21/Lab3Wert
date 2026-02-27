import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class CustomerMongoCRUD {
    public static void main(String[] args) {
        // Create a MongoClient using the factory method
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // Access the database and collection
            MongoDatabase database = mongoClient.getDatabase("your_database_name");
            MongoCollection<Document> collection = database.getCollection("customers");

            // Example: Insert a document
            Document newCustomer = new Document("first_name", "John")
                    .append("last_name", "Doe")
                    .append("age", 20)
                    .append("email", "john@example.com");
            collection.insertOne(newCustomer);

            Document newCustomer2 = new Document("first_name", "Jonah")
                    .append("last_name", "Wert")
                    .append("age", 22)
                    .append("email", "jwert@gmail.com");
            collection.insertOne(newCustomer2);

            // Read
            FindIterable<Document> customers = collection.find();
            for (Document customer : customers) {
                System.out.println(customer.toJson());
            }

            // Update
            Document updatedCustomer = new Document("$set", new Document("first_name", "Updated First Name"));
            collection.updateOne(new Document("first_name", "John"), updatedCustomer);

            // Read again
            customers = collection.find();
            for (Document student : customers) {
                System.out.println(customer.toJson());
            }

            // Delete
            collection.deleteOne(new Document("first_name", "John"));

        }
    }
}

