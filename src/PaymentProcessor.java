public class PaymentProcessor {

    public boolean processPayment(double amount) {
        if (amount <= 0 || amount > 1000) {
            System.out.println("Payment declined");
            return false;
        }

        System.out.println("Payment successful");
        return true;
    }
    public void refundPayment(double amount) {
        System.out.println("Refunded: " + amount);
    }
}