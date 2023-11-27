package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex3;

public class SelectionSort implements Sorter {
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
        for (int i = data.length - 1; i >= 0; i--) {
            int minIndx = i;
            for (int j = 0; j < i; j++) {
                if (data[minIndx] < data[j]) {
                    minIndx = j;
                    countCompare++;
                }
            }
            int tmp = data[i];
            data[i] = data[minIndx];
            data[minIndx] = tmp;
            countSwap++;
        }
        end = System.currentTimeMillis();
    }

    public void sortAndPrint() {
        start = System.currentTimeMillis();
        for (int i = data.length - 1; i >= 0; i--) {
            int minIndx = i;
            for (int j = 0; j < i; j++) {
                if (data[minIndx] < data[j]) {
                    minIndx = j;
                    countCompare++;
                }
            }
            int tmp = data[i];
            data[i] = data[minIndx];
            data[minIndx] = tmp;
            countSwap++;
            print(data);
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