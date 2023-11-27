package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex3;

public class MergeSort implements Sorter {
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
        mergeSort(data, 0, data.length - 1);
        end = System.currentTimeMillis();
    }

    public void sortAndPrint() {
        mergeSortAndPrint(data, 0, data.length - 1);
    }

    public void mergeSort(int[] data, int low, int high) {
        if(low < high) {
            int mid = (low + high)/2;

            mergeSort(data, low, mid);
            mergeSort(data, mid + 1, high);

            merge(data, low, mid, high);
        }
    }

    public void mergeSortAndPrint(int[] data, int low, int high) {
        if(low < high) {
            int mid = (low + high)/2;

            mergeSortAndPrint(data, low, mid);
            mergeSortAndPrint(data, mid + 1, high);

            merge2(data, low, mid, high);
        }
    }

    void merge(int[] a, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = a[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = a[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
                countCompare++;
            } else {
                a[k] = R[j];
                j++;
                countCompare++;
            }
            countSwap++;
            k++;
        }
        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
            countSwap++;
        }
        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
            countSwap++;
        }
    }

    void merge2(int[] a, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = a[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = a[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
                countCompare++;
            } else {
                a[k] = R[j];
                j++;
                countCompare++;
            }
            countSwap++;
            print(a);
            k++;
        }
        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
            countSwap++;
            print(a);
        }
        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
            countSwap++;
            print(a);
        }
    }

    public void print(int[] array){
        System.out.println();
        for (int i : array) {
            System.out.print(i+" ");
        }
    }

    public long  time() {
        return this.end - this.start;
    }
}
