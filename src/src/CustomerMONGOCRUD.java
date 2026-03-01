import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class CustomerMongoCRUD {

    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "store";
    private static final String COLLECTION_NAME = "customers";

    public static void main(String[] args) {

        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {

            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection =
                    database.getCollection(COLLECTION_NAME);

            // Clear collection (optional for testing)
            collection.deleteMany(new Document());

            // CREATE
            insertCustomer(collection, "John", "Doe", 20, "john@example.com", "9876543211", "123 Pine Street, Willow Grove PA, 19090");

            insertCustomer(collection, "Jonah", "Wert", 22, "jwert@gmail.com", "1234567899", "456 Broad Street, Philadelphia PA, 19115");

            insertCustomer(collection, "Jane", "Doe", 21, "jdoe@gmail.com", "3216549877", "221 Woodland Road, Abington PA, 19001");

            System.out.println("After Insert:");
            printAllCustomers(collection);

            // UPDATE
            updateCustomer(collection, "John", "Updated First Name");

            System.out.println("\nAfter Update:");
            printAllCustomers(collection);

            // DELETE
            deleteCustomer(collection, "Updated First Name");

            System.out.println("\nAfter Delete:");
            printAllCustomers(collection);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertCustomer(MongoCollection<Document> collection, String firstName, String lastName, int age, String email, String phoneNumber, String address) {

        Document customer = new Document("first_name", firstName)
                .append("last_name", lastName)
                .append("age", age)
                .append("email", email)
                .append("phoneNumber", phoneNumber)
                .append("address", address);

        collection.insertOne(customer);
    }

    private static void updateCustomer(MongoCollection<Document> collection, String existingFirstName, String newFirstName) {

        Document filter = new Document("first_name", existingFirstName);
        Document update = new Document("$set",
                new Document("first_name", newFirstName));

        collection.updateOne(filter, update);
    }

    private static void deleteCustomer(MongoCollection<Document> collection, String firstName) {

        Document filter = new Document("first_name", firstName);
        collection.deleteOne(filter);
    }

    private static void printAllCustomers(MongoCollection<Document> collection) {

        FindIterable<Document> customers = collection.find();

        for (Document customer : customers) {
            System.out.println(customer.toJson());
        }
    }
}