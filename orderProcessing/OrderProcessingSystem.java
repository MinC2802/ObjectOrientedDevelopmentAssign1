package orderProcessing;
public class OrderProcessingSystem {
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
        public String productId;
        public String name;
        private String description;
        private double price;
        private int stock;
        private String category; 

    //constructor
        public Product (){}
        public Product (String productId, String name, String description, double price, int stock, String category){
            this.productId = productId;
            this.name = name;
            this.description = description;
            this.price = price;
            this.stock = stock;
            this.category = category;
        }
    // Encapsulation (getters/setters)
        public String getProductId() { return productId; }
        public void setProductId(String productId) { this.productId = productId; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }

        public int getStock() { return stock; }
        public void setStock(int stock) { this.stock = stock; }

        public String getCategory() { return category; }
        public void setCategory(String category) { this.category = category; }

        // Placeholder methods (no functionality yet)
        public void getDetails() {}
        public boolean checkStock() { return false; }
    }
    public static class CartItem {
        private String productId;
        private int quantity;

        public CartItem() {}
        public CartItem(String productId, int quantity){
            this.productId = productId;
            this.quantity = quantity;
        }
        // setters and getters
    }
}