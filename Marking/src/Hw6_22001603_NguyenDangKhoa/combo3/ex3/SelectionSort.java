package Hw6_22001603_NguyenDangKhoa.combo3.ex3;
public class SelectionSort {

    public static void selectionSort(int array[]) {
        int n = array.length;
        for (int i = 0; i < n -1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (array[minIndex] >array[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(array,minIndex, i);
            }
        }
    }
    public static void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}