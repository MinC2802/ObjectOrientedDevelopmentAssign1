package gadgetManagement;

public class Gadgets extends Products{

    public String brand;
    public Gadgets(String productId, String name, String description, double price, int stock, String category, String brand) {
        super(productId, name, description, price, stock, category);
        this.brand = brand;
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }
    
    @Override
    public String toString() {
        return String.format("Gadget{productId='%s', name='%s', description='%s', price=%.2f, stock=%d, category='%s'}",
                productId, name, description, price, stock, category, brand);
    }
}
