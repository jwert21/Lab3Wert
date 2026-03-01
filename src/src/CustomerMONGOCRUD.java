import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import org.bson.Document;

import static jdk.internal.org.jline.utils.AttributedStringBuilder.append;

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
                    .append("phoneNumber", "9876543211")
                    .append("address", "123 Pine Street, Willow Grove PA, 19090");
            collection.insertOne(newCustomer);

            Document newCustomer2 = new Document("first_name", "Jonah")
                    .append("last_name", "Wert")
                    .append("age", 22)
                    .append("email", "jwert@gmail.com");
                    .append("phoneNumber", "1234567899")
                    .append("address", "456 Broad Street, Philadelphia PA, 19115");
            collection.insertOne(newCustomer2);

            Document newCustomer3 = new Document("first_name", "Jane")
                    .append("last_name", "Doe")
                    .append("age", 21)
                    .append("email", "jdoe@gmail.com");
                    .append("phoneNumber", "3216549877")
                    .append("address", "221 Woodland Road, Abington PA, 19001");
            collection.insertOne(newCustomer3);

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
            for (Document customer : customers) {
                System.out.println(customer.toJson());
            }

            // Delete
            collection.deleteOne(new Document("first_name", "John"));

            // Read
            FindIterable<Document> customers = collection.find();
            for (Document customer2 : customers) {
                System.out.println(customer2.toJson());
            }

            // Update
            Document updatedCustomer2 = new Document("$set", new Document("first_name", "Updated First Name"));
            collection.updateOne(new Document("first_name", "Jonah"), updatedCustomer2);

            // Read again
            customers = collection.find();
            for (Document customer2 : customers) {
                System.out.println(customer2.toJson());
            }

            // Delete
            collection.deleteOne(new Document("first_name", "Jonah"));

            // Read
            FindIterable<Document> customers = collection.find();
            for (Document customer3 : customers) {
                System.out.println(customer3.toJson());
            }

            // Update
            Document updatedCustomer3 = new Document("$set", new Document("first_name", "Updated First Name"));
            collection.updateOne(new Document("first_name", "Joe"), updatedCustomer3);

            // Read again
            customers = collection.find();
            for (Document customer3 : customers) {
                System.out.println(customer3.toJson());
            }

            // Delete
            collection.deleteOne(new Document("first_name", "Joe"));

        }
    }
}

