package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex3;

public class BubbleSort implements Sorter {
    private int[] data;
    private long start, end = 0;
    private int countSwap = 0, countCompare = 0;

    public void setData(int[] data) {
        this.data = data;
    }

//    public int getCountCompare() {
//        return countCompare;
//    }
//
//    public int getCountSwap() {
//        return countSwap;
//    }

    @Override
    public void sort() {
        start = System.currentTimeMillis();
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data.length; j++) {
                if (data[j] < data[j - 1]) {
                    int tmp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = tmp;
                    countSwap++;
                }
                countCompare++;
            }
        }
        end = System.currentTimeMillis();
    }

    public void sortAndPrint() {
        start = System.currentTimeMillis();
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data.length; j++) {
                if (data[j] < data[j - 1]) {
                    int tmp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = tmp;
                    countSwap++;
                }
                print(data);
                countCompare++;
            }
        }
        end = System.currentTimeMillis();
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