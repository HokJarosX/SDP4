public class InventoryService {
    private int stock = 10;

    public boolean reserve(int quantity) {
        if(stock < quantity || quantity <= 0){
            return false;
        }


        else{
            stock -= quantity;
            return true;
        }
    }

    public void release(int quantity) {
        if (quantity <= 0) {
            return;
        }

        stock += quantity;
    }

    public int getStock() {
        return stock;
    }
}
