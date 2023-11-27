package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockTradingSystemGUI {
    private StockTradingSystem tradingSystem;
    private JFrame frame;
    private JTextArea pendingOrdersArea;
    private JTextArea transactionHistoryArea;

    public StockTradingSystemGUI() {
        tradingSystem = new StockTradingSystem();
        frame = new JFrame("Stock Trading System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        JPanel panel = new JPanel(new GridLayout(1, 2));

        pendingOrdersArea = new JTextArea();
        JScrollPane pendingOrdersScrollPane = new JScrollPane(pendingOrdersArea);
        panel.add(pendingOrdersScrollPane);

        transactionHistoryArea = new JTextArea();
        JScrollPane transactionHistoryScrollPane = new JScrollPane(transactionHistoryArea);
        panel.add(transactionHistoryScrollPane);

        JButton enterButton = new JButton("Enter Order");
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEnterOrderDialog();
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(enterButton, BorderLayout.SOUTH);
        frame.setVisible(true);

        // Cập nhật hiển thị
        updateDisplays();
    }

    private void showEnterOrderDialog() {
        String[] orderTypes = {"buy", "sell"};
        JComboBox<String> typeComboBox = new JComboBox<>(orderTypes);
        JTextField quantityField = new JTextField();
        JTextField priceField = new JTextField();

        Object[] message = {
                "Type:", typeComboBox,
                "Quantity:", quantityField,
                "Price:", priceField
        };

        int option = JOptionPane.showConfirmDialog(frame, message, "Enter Order", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String type = (String) typeComboBox.getSelectedItem();
                int quantity = Integer.parseInt(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());
                Order order = new Order(quantity, price, type);
                if (!tradingSystem.enterOrder(order)) {
                    JOptionPane.showMessageDialog(frame, "Order entered but not processed. It will be processed in the future.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numbers.");
            }
            updateDisplays();
        }
    }

    private void updateDisplays() {
        // Hiển thị danh sách đơn hàng chưa được xử lí
        StringBuilder pendingOrdersText = new StringBuilder("Pending Orders:\n");
        for (Order order : tradingSystem.getPendingOrders()) {
            pendingOrdersText.append(order.type)
                    .append(" ")
                    .append(order.quantity)
                    .append(" shares at $")
                    .append(order.price)
                    .append("\n");
        }
        pendingOrdersArea.setText(pendingOrdersText.toString());

        // Hiển thị danh sách giao dịch đã xử lí
        StringBuilder transactionHistoryText = new StringBuilder("Transaction History:\n");
        for (String transaction : tradingSystem.getTransactionHistory()) {
            transactionHistoryText.append(transaction).append("\n");
        }
        transactionHistoryArea.setText(transactionHistoryText.toString());
    }
//    Nhấn nút "Enter Order" để mở hộp thoại nhập thông tin đơn đặt hàng.
//    Chọn loại đơn đặt hàng từ menu dropdown ("buy" hoặc "sell").
//    Nhập số lượng và giá cho đơn đặt hàng.
//            Nhấn "OK" để xác nhận đơn đặt hàng hoặc "Cancel" để hủy bỏ.
//    Nếu nhập liệu không hợp lệ, hộp thoại cảnh báo sẽ xuất hiện.

    public static void main(String[] args) {
        new StockTradingSystemGUI();
    }
}
