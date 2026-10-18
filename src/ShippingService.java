public class ShippingService {

    public boolean createShipment(String address) {
        if (address == null || address.isBlank()) {
            System.out.println("Shipping failed: invalid address");
            return false;
        }

        System.out.println("Shipment created for: " + address);
        return true;
    }
}