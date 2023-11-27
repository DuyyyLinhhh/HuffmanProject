package Hw6_22001603_NguyenDangKhoa.combo3.ex3;

public class MergeSort {
    public static int[] merge(int[] array1, int[] array2) {
        int n = array1.length + array2.length;
        int[] result = new int[n];
        int i = 0, i1 = 0, i2 = 0;
        while (i < n) {
            if (i1 < array1.length && i2 < array2.length) {
                if (array1[i1] <= array2[i2]) {
                    result[i] = array1[i1];
                    i++;
                    i1++;
                } else {
                    result[i] = array2[i2];
                    i++;
                    i2++;
                }
            } else {
                if (i1 < array1.length) {
                    result[i] = array1[i1];
                    i++;
                    i1++;
                } else {
                    result[i] = array2[i2];
                    i++;
                    i2++;
                }
            }
        }
        return result;
    }

    public static int[] mergeSort(int[] array, int L, int R) {
        if (L > R)
            return new int[0];
        if (L == R) {
            int[] singleElement = {array[L]};
            return singleElement;
        }
        int k = (L + R) / 2;
        int[] array1 = mergeSort(array, L, k);
        int[] array2 = mergeSort(array, k + 1, R);
        int[] result = merge(array1, array2);
        return result;
    }

}
