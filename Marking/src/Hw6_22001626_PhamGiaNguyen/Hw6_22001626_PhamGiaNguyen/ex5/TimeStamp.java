package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex5;

public class TimeStamp implements Comparable<TimeStamp> {
    private int hour;
    private int minute;
    private int second;

    public TimeStamp(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    @Override
    public int compareTo(TimeStamp timeStamp) {
        return (this.hour > timeStamp.hour) ?
                1 : ((this.minute > timeStamp.minute) ?
                1 : ((this.second > timeStamp.second) ?
                1 : -1));
    }

    @Override
    public String toString() {
        return hour + ":" + minute + ":" + second;
    }
}
