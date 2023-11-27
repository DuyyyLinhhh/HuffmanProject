package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex3;

public class BubbleSort2 implements Sorter {
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
    public void setData(int[] data) {
        this.data = data;
    }
    @Override
    public void sort() {
        start = System.currentTimeMillis();
        for (int i = 0; i < data.length; i++) {
            boolean is_sorted = true;
            for (int j = 1; j < data.length; j++) {
                if (data[j] < data[j - 1]) {
                    int tmp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = tmp;
                    is_sorted = false;
                    countSwap++;
                }
                countCompare++;
            }
            if (is_sorted) break;
        }
        end = System.currentTimeMillis();
    }

    public void sortAndPrint() {
        for (int i = 0; i < data.length; i++) {
            boolean is_sorted = true;
            for (int j = 1; j < data.length; j++) {
                if (data[j] < data[j - 1]) {
                    int tmp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = tmp;
                    is_sorted = false;
                    countSwap++;
                }
                print(data);
                countCompare++;
            }
            if (is_sorted) break;
        }
    }

    public void print(int[] array){
        System.out.println();
        for (int i : array) {
            System.out.print(i+" ");
        }
    }

    public long time() {
        return this.end - this.start;
    }
}
