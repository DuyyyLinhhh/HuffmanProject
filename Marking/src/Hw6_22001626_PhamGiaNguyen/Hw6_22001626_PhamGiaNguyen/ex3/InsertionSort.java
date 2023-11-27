package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex3;

public class InsertionSort implements Sorter {
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
        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            int index = i-1;
            while (index >= 0 && data[index] > key) {
                data[index + 1] = data[index];
                index--;
                countCompare++;;
            }
            data[index+1] = key;
            countSwap++;

        }
        end = System.currentTimeMillis();
    }

    public void sortAndPrint() {
        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            int index = i-1;
            while (index >= 0 && data[index] > key) {
                data[index + 1] = data[index];
                index--;
                countCompare++;;
            }
            data[index+1] = key;
            countSwap++;
        }
        print(data);
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
