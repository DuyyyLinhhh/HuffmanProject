package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex3;

public abstract class Sortee implements Sorter {
    private int[] data;
    private long start, end = 0;
    private int countSwap = 0, countCompare = 0;

    public int getCountCompare() {
        return countCompare;
    }

    public int getCountSwap() {
        return countSwap;
    }

    @Override
    public void sort() {

    }

    public void sortAndPrint() {

    }

    @Override
    public void setData(int[] Data) {

    }

    @Override
    public long time() {
        return 0;
    }
}
