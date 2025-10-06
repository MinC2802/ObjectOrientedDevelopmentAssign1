import java.util.*;

// -----------------------------
// Class: Product
// -----------------------------
class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "[" + id + "] " + name + " - $" + price;
    }
}

// -----------------------------
// Class: Order
// -----------------------------
class Order {
    private static int counter = 1;
    private int orderId;
    private Date orderDate;
    private List<Product> productList;

    public Order(List<Product> products) {
        this.orderId = counter++;
        this.orderDate = new Date();
        this.productList = new ArrayList<>(products);
    }

    public int getOrderId() { return orderId; }
    public Date getOrderDate() { return orderDate; }
    public List<Product> getProductList() { return productList; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order #" + orderId + " (" + orderDate + ")\n");
        for (Product p : productList) {
            sb.append("   - ").append(p.getName()).append(" ($").append(p.getPrice()).append(")\n");
        }
        return sb.toString();
    }
}

// -----------------------------
// Class: Customer
// -----------------------------
class Customer {
    private String name;
    private String email;
    private List<Order> orderHistory;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.orderHistory = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getEmail() { return email; }

    // Place an order
    public void placeOrder(List<Product> products) {
        Order newOrder = new Order(products);
        orderHistory.add(newOrder);
        System.out.println("✅ Order placed successfully!");
    }

    // View past orders
    public void viewOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("No past orders found.");
        } else {
            System.out.println("🧾 Order History for " + name + ":");
            for (Order order : orderHistory) {
                System.out.println(order);
            }
        }
    }

    @Override
    public String toString() {
        return name + " (" + email + ")";
    }
}

// -----------------------------
// Main Class: CustomerManagementSystem
// -----------------------------
public class CustomerManagementSystem {
    public static void main(String[] args) {
        // Sample products
        Product p1 = new Product("P001", "Laptop", 3500.00);
        Product p2 = new Product("P002", "Smartphone", 1200.00);
        Product p3 = new Product("P003", "Headphones", 150.00);

        // Create a customer
        Customer customer = new Customer("Alice Tan", "alice@example.com");

        // Place first order
        List<Product> order1Products = Arrays.asList(p1, p3);
        customer.placeOrder(order1Products);

        // Place second order
        List<Product> order2Products = Arrays.asList(p2);
        customer.placeOrder(order2Products);

        // View past orders
        customer.viewOrderHistory();
    }
}
