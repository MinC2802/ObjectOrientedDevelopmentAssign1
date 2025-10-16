
//Classes
public class Guest {
    private void register() {
        // Registers user
    }
}

public class User {
    public String userid;

    private void login() {
        // login function
    }

    private void logout() {
        // logout function
    }
}

public class Admin extends User {
    private void addProduct(String productid, String name, String description, double price, int stock,
            String category) {
        // adds Product
    }

    private void removeProduct(String productid, String name, String description, double price, int stock,
            String category) {
        // removes product
    }

    private void updateProduct(String productid, String name, String description, double price, int stock,
            String category) {
        // updates product
    }

    private void updateStock(String productid, int stock) {
        // updates inventory
    }
}

public class Customer extends User {
    private String username;
    private String email;
    private String contact;
    private String passwordHash;
    private String address;

    protected browseProducts(){
        //returns list of products 
    }

    protected searchProducts(String productid){
        //returns list of products 
    }

    protected searchProducts(String productname){
        //returns list of products 
    }
}

public class Product {
    public String productid;
    public String name;
    private String description;
    private double price;
    private int stock;
    private String category;

    public getDetails(){
        //get product details
    }

    public setDetails(){
        //set product details
    }

    public checkStock(){
        //returns boolean
    }
}

public class Gadget extends Product {
    public String brand;
}

public class Cart {
    public String cartid;
    public String[] cartitems;

    public void addItem(String productid, int quantity) {
        // adds item to cart
    }

    public void removeItem(String productid) {
        // adds item to cart
    }

    public double calculateTotal() {
        // calculates total
    }

    public void reviewCart() {
        // check cart items
    }

    public void clearCart() {
        // removes all items from cart
    }
}

public class Order {
    public String orderid;
    private String orderDate;
    private double totalAmount;
    private String customerid;
    public String status;
    private String[] orderItems;

    public void updateStatus(String newStatus) {
        // updates status of order
    }

    public String[] viewHistory() {
        // view order history
    }

    public boolean processOrder() {
        // sends order for processing
    }
}

public class CartItem {
    public String productid;
    private int quantity;

    public void updateQuantity(String productid, int newQuantity) {
        // updates quantity of product in cart
    }

    public double calculateSubotal(int quantity, double price) {
        // returns double of subtotal
    }
}

public class OrderItem {
    private int quantity;

    public void updateQuantity(String productid, int newQuantity) {
        // updates quantity of product in cart
    }

    public double calculateSubotal(int quantity, double price) {
        // returns double of subtotal
    }
}

public class Payment {
    public String paymentid;
    private double amount;
    private String paymentDate;
    private String paymentStatus;

    public boolean processPayment() {
        // processes payment
    }

    public boolean validatePayment() {
        // view order history
    }

    public String[] viewPaymentDetails() {
        // sends order for processing
    }
}

public class EmailSystem {
    public void sendConfirmationEmail(String email) {
        // sends confirmation email
    }
}

// Main Program
public class CustomerManagementSystem {
    public static void main(String[] args) {
    }

}