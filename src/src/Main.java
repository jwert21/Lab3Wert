//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;

    public Customer(int id, String firstName, String lastName, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public String toString() {
        return "Customer{id=" + this.id + ", firstName='" + this.firstName + "', lastName='" + this.lastName + "', age=" + this.age + ", email='" + this.email + "'}";
    }
}
