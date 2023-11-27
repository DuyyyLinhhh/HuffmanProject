package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex3;

public class QuickSort implements Sorter {
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
    public void sort() {
        start = System.currentTimeMillis();
        quickSort(data, 0, data.length - 1);
        end = System.currentTimeMillis();
    }

    public void sortAndPrint() {
        quickSort2(data, 0, data.length - 1);
    }

    public void quickSort(int[] data, int low, int high) {
        int pivotIdx;

        if (low < high) {
            pivotIdx = partition(data, low, high);

            quickSort(data, low, pivotIdx);
            quickSort(data, pivotIdx + 1, high);
        }
    }

    public void quickSort2(int[] data, int low, int high) {
        int pivotIdx;

        if (low < high) {
            pivotIdx = partition2(data, low, high);

            quickSort2(data, low, pivotIdx);
            quickSort2(data, pivotIdx + 1, high);
        }
    }

    public int partition(int[] a, int low, int high) {
        int pivot = a[low];
        int i = low;
        for (int j = low + 1; j <= high; j++) {
            if (a[j] < pivot) {
                i++;

                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                countCompare++;
                countSwap++;
            }
        }

        int tempSwap = a[i];
        a[i] = a[low];
        a[low] = tempSwap;
        countSwap++;

        return i;
    }

    public int partition2(int[] a, int low, int high) {
        int pivot = a[low];
        int i = low;
        for (int j = low + 1; j <= high; j++) {
            if (a[j] < pivot) {
                i++;

                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                countCompare++;
                countSwap++;
            }
        }

        int tempSwap = a[i];
        a[i] = a[low];
        a[low] = tempSwap;
        countSwap++;
        print(a);
        return i;
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
