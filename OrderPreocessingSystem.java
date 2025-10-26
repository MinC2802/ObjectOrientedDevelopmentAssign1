import java.util.*;
// Main class representing the overall Order Processing System
public class OrderPreocessingSystem {
    //Abstraction
    public interface InventoryService {
        Product findProductById(String productId);
        boolean reserveStock(String productId, int quantity);
        void releaseStock(String productId, int quantity);
        void commitStock(String productId, int quantity);
    }
    public interface EmailService{
        void sendOrderConfirmation(String email, String orderId);
    }

    //Product class
    public class Product {
        public String productid;
        public String name;
        private String description;
        private double price;
        private int stock;
        private String category;

        public String getDetails() {
            //get product details
        }

        public void setDetails() {
            //set product details
        }

        public boolean checkStock() {
            //returns boolean
        }
}