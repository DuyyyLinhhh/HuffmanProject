package Hw6_22001603_NguyenDangKhoa.combo3.ex3;

import hw6_22001603_NguyenDangKhoa.combo3.ex1.Entry;
import hw6_22001603_NguyenDangKhoa.combo3.ex2.MinHeapPriorityQueue;

public class HeapSort {
    public static void heapSort(int[] array) {
        MinHeapPriorityQueue minHeapPriorityQueue = new MinHeapPriorityQueue<>(array.length);
        for (int i : array) {
            minHeapPriorityQueue.insert(i, i);
        }
        int i = 0;
        while (!minHeapPriorityQueue.isEmpty()) {
            Entry<Integer, Integer> entry = minHeapPriorityQueue.removeMin();
            array[i] = entry.getValue();
            i++;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,9,5,2,3,2,2,4};
        heapSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
