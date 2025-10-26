package gadgetManagement;

public class Products {
    protected String productId;
    protected String name;
    protected String description;
    protected double price;
    protected int stock;
    protected String category; 

    public Products(String productId, String name, String description, double price, int stock, String category){
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;}

    public String getProductId(){
        return productId;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public double getPrice(){
        return price;
    }
    public int getStock(){
        return stock;
    }
    public String getCategory(){
        return category;
    }
    
    public synchronized void setProductId(String productId) {
        this.productId = productId;
    }
    public synchronized void setName(String name) {
        this.name = name;
    }
    public synchronized void setDescription(String description) {
        this.description = description;
    }
    public synchronized void setPrice(double price) {
        this.price = price;
    }
    public synchronized void setStock(int stock) {
        this.stock = stock;
    }
    public synchronized void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("Gadget{productId='%s', name='%s', description='%s', price=%.2f, stock=%d, category='%s'}",
                productId, name, description, price, stock, category);
    }
}




