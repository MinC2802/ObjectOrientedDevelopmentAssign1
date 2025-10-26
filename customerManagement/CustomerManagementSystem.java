
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


// Main Program
public class CustomerManagementSystem {
    public static void main(String[] args) {
    }

}