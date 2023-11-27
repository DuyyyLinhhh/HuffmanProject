package Hw6_22001603_NguyenDangKhoa.combo3.ex6;

import hw6_22001603_NguyenDangKhoa.combo3.ex1.SortedArrayPriorityQueue;
import hw6_22001603_NguyenDangKhoa.combo3.ex2.MinHeapPriorityQueue;

import java.util.Scanner;

public class StockTradingSystem {
    //Min Heap các lệnh vào theo khóa là giá của mỗi cổ phiếu
    private MinHeapPriorityQueue<Integer, Command> buyCommand;
    private MinHeapPriorityQueue<Integer, Command> sellCommand;
    //Id của mỗi lệnh
    private int commandIdCounter;

    //Hàm dựng
    public StockTradingSystem() {
        buyCommand = new MinHeapPriorityQueue<>();
        sellCommand = new MinHeapPriorityQueue<>();
        commandIdCounter = 1;
    }

    //Tương tác với người dùng, lưu các lệnh hợp lệ
    public void processCommand() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Options:\n" +
                    "1.To place a buy Command.\n" +
                    "2.To place a sell Command.\n" +
                    "3.To see Command.\n" +
                    "4.To quit.\n" +
                    "Your option: ");
            String option = scanner.next();

            switch (option) {
                case "4":
                    return;
                case "3":
                    viewCommand();
                    break;
                case "1":
                case "2":
                    System.out.print("Enter the number of shares: ");
                    int shares = scanner.nextInt();
                    System.out.print("Enter the price per share: ");
                    int price = scanner.nextInt();

                    Command command = new Command(commandIdCounter++, shares, price);

                    if (option.equals("1")) {
                        buyCommand.insert(new SortedArrayPriorityQueue.ArrEntry<>(command.getPrice(), command));
                        System.out.println("Buy purchase processed: " + command);
                    } else {
                        sellCommand.insert(new SortedArrayPriorityQueue.ArrEntry<>(command.getPrice(), command));
                        System.out.println("Sell purchase processed: " + command);
                    }
                    processMatchingCommand();
                    break;
                default:
                    System.out.println("Invalid command!!!!\nPlease enter '1', '2', '3', or '4'.");
                    break;
            }
        }
    }

    //Cho người dùng xem các lệnh đang có
    private void viewCommand() {
        System.out.println("*-*-*-*-*-*- Buy Command -*-*-*-*-*-*");
        printCommand(buyCommand);

        System.out.println("*-*-*-*-*-*- Sell Command -*-*-*-*-*-*");
        printCommand(sellCommand);
    }

    //In ra các lệnh
    private void printCommand(MinHeapPriorityQueue<Integer, Command> command) {
        if (command.isEmpty()) {
            System.out.println("No Command");
        } else {
            Object[] commandArray = command.toArray();

            for (int i = 0; i < commandArray.length; i++) {
                SortedArrayPriorityQueue.ArrEntry<Integer, Command> entry = (SortedArrayPriorityQueue.ArrEntry<Integer, Command>) commandArray[i];
                System.out.println(entry.getValue());
            }
        }
    }

    //Khớp các lệnh mua bán , cập nhật lệnh mua bán , in giao dịch thành công
    private void processMatchingCommand() {
        while (!buyCommand.isEmpty() && !sellCommand.isEmpty()) {
            Command sellCommand = this.sellCommand.min().getValue();
            Command matchingBuyCommand = findMatchingBuyCommand(sellCommand);

            if (matchingBuyCommand != null) {
                int matchedShares = Math.min(matchingBuyCommand.getShares(), sellCommand.getShares());

                matchingBuyCommand.setShares(matchingBuyCommand.getShares() - matchedShares);
                sellCommand.setShares(sellCommand.getShares() - matchedShares);

                if (matchingBuyCommand.getShares() == 0) {
                    this.buyCommand.removeMin();
                }

                if (sellCommand.getShares() == 0) {
                    this.sellCommand.removeMin();
                }

                System.out.println("Matched: Buy " + matchedShares + " shares at $" + sellCommand.getPrice() + " each");
            } else {
                break;
            }
        }
    }

    //Tìm lệnh mua phù hợp đầu tiên với lệnh bán
    private Command findMatchingBuyCommand(Command sellCommand) {
        for (int i = 0; i < buyCommand.size(); i++) {
            Command buyCommand = this.buyCommand.toArray()[i].getValue();
            if (buyCommand.getPrice() >= sellCommand.getPrice()) {
                return buyCommand;
            }
        }
        return null;
    }


}