package Hw6_22001603_NguyenDangKhoa.combo3.ex6;
public class Command {
    private int commandId;
    private int shares;
    private int price;

    public Command() {
    }

    public Command(int commandId, int shares, int price) {
        this.commandId = commandId;
        this.shares = shares;
        this.price = price;
    }

    public int getCommandId() {
        return commandId;
    }

    public int getShares() {
        return shares;
    }

    public int getPrice() {
        return price;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    @Override
    public String toString() {
        return "Command[" +
                "commandId = " + commandId +
                ", shares = " + shares +
                ", price = " + price +
                ']';
    }
}