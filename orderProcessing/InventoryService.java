package orderProcessing;

public interface InventoryService {
    Product findProductById(String productId);
    boolean reserveStock(String productId, int quantity);
    void releaseStock(String productId, int quantity);
    void commitStock(String productId, int quantity);
}
