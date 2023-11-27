package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex6;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class StockTradingSystem {
    private PriorityQueue<Order> buyOrders;
    private PriorityQueue<Order> sellOrders;
    private List<String> transactionHistory;

    public StockTradingSystem() {
        buyOrders = new PriorityQueue<>((o1, o2) -> Double.compare(o2.price, o1.price)); // Sắp xếp giảm dần
        sellOrders = new PriorityQueue<>((o1, o2) -> Double.compare(o1.price, o2.price)); // Sắp xếp tăng dần
        transactionHistory = new ArrayList<>();
    }

    public boolean enterOrder(Order order) {
        if ("buy".equals(order.type)) {
            return processBuyOrder(order);
        } else if ("sell".equals(order.type)) {
            return processSellOrder(order);
        } else {
            System.out.println("Invalid order type");
            return false;
        }
    }

    private boolean processBuyOrder(Order buyOrder) {
        while (!sellOrders.isEmpty() && sellOrders.peek().price <= buyOrder.price) {
            Order sellOrder = sellOrders.poll();
            int quantityToProcess = Math.min(buyOrder.quantity, sellOrder.quantity);

            transactionHistory.add("Processed buy order: " + buyOrder.quantity + " shares at $" + buyOrder.price
                    + " with sell order: " + quantityToProcess + " shares at $" + sellOrder.price);

            buyOrder.quantity -= quantityToProcess;
            sellOrder.quantity -= quantityToProcess;

            if (sellOrder.quantity > 0) {
                sellOrders.offer(sellOrder);
            }
        }

        if (buyOrder.quantity > 0) {
            buyOrders.offer(buyOrder);
            return false; // Đơn đặt hàng không được xử lý ngay lập tức
        }

        return true; // Đơn đặt hàng đã được xử lý
    }

    private boolean processSellOrder(Order sellOrder) {
        while (!buyOrders.isEmpty() && buyOrders.peek().price >= sellOrder.price) {
            Order buyOrder = buyOrders.poll();
            int quantityToProcess = Math.min(buyOrder.quantity, sellOrder.quantity);

            transactionHistory.add("Processed sell order: " + sellOrder.quantity + " shares at $" + sellOrder.price
                    + " with buy order: " + quantityToProcess + " shares at $" + buyOrder.price);

            buyOrder.quantity -= quantityToProcess;
            sellOrder.quantity -= quantityToProcess;

            if (buyOrder.quantity > 0) {
                buyOrders.offer(buyOrder);
            }
        }

        if (sellOrder.quantity > 0) {
            sellOrders.offer(sellOrder);
            return false; // Đơn đặt hàng không được xử lý ngay lập tức
        }

        return true; // Đơn đặt hàng đã được xử lý
    }

    public List<Order> getPendingOrders() {
        List<Order> pendingOrders = new ArrayList<>();
        for (Order order : buyOrders) {
            pendingOrders.add(order);
        }
        for (Order order : sellOrders) {
            pendingOrders.add(order);
        }
        return pendingOrders;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}
