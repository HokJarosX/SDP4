public class OrderFacade {
    private InventoryService inventory;
    private PaymentProcessor payment;
    private ShippingService shipping;
    private NotificationService notification;

    public OrderFacade() {
        inventory = new InventoryService();
        payment = new PaymentProcessor();
        shipping = new ShippingService();
        notification = new NotificationService();
    }

    public boolean placeOrder(int quantity, double price, String customer, String address){
        double total = quantity * price;

        if (inventory.reserve(quantity) == false) {
            notification.sendNotification(customer, "Not enough stock");
            return false;
        }

        if (payment.processPayment(total) == false){
            inventory.release(quantity);
            notification.sendNotification(customer, "Payment declined");
            return false;
        }

        if (shipping.createShipment(address) == false) {
            notification.sendNotification(customer, "Shipping failed");
            inventory.release(quantity);
            payment.refundPayment(total);
            return false;
        }

        notification.sendNotification(customer, "Order completed successfully");
        return true;
    }
}