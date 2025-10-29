package orderProcessing;

import com.gadgetstore.entities.CartItem;

public class OrderItem extends CartItem {
    private String orderId;

    public OrderItem() {}

    public OrderItem(String orderId, String productId, int quantity) {
        super(productId, quantity);
        this.orderId = orderId;
    }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    @Override
    public double calculateSubtotal(int quantity, double price) { return 0; }

    @Override
    public void updateQuantity(int newQuantity) {}
}

