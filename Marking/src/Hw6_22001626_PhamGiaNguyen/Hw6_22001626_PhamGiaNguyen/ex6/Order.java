package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex6;

class Order {
    int quantity;
    double price;
    String type; // "buy" or "sell"

    public Order(int quantity, double price, String type) {
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }
}
