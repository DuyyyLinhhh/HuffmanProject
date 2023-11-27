package Hw6_22001603_NguyenDangKhoa.combo3.ex3;
public class InsertionSort {
    public static void shiftElement(int[] array, int i) {
        int temp = array[i];
        while (i > 0 && array[i - 1] > temp) {
            array[i] = array[i - 1];
            i--;
        }
        array[i] = temp;

    }
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++)
            if (array[i] < array[i - 1])
                shiftElement(array, i);
    }
}