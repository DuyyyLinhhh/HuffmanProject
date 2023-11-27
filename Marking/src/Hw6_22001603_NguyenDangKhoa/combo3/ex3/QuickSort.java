package Hw6_22001603_NguyenDangKhoa.combo3.ex3;

public class QuickSort {
    static void quickSort(int[] array, int L, int R) {
        if (L>= R)
            return;
        int key = array[(L+R) / 2];
        int k = partition(array, L, R, key);
        quickSort(array, L, k-1);
        quickSort(array, k, R);
    }
    static int partition(int[] array, int L, int R, int key) {
        int iL = L;
        int iR = R;
        while (iL <= iR) {
            while (array[iL] < key )
                iL++;
            while (array[iR] >key)
                iR--;
            if (iL<=iR) {
                int temp = array[iL];
                array[iL] = array[iR];
                array[iR] = temp;
                iL++;
                iR--;
            }
        }
        return iL;
    }


}
