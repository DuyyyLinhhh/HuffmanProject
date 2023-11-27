package Hw6_22001603_NguyenDangKhoa.combo3.ex2;

import hw6_22001603_NguyenDangKhoa.combo3.ex1.Entry;

public class TestMain {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> minHeap = new MinHeapPriorityQueue<>();
        minHeap.insert(3, "C");
        minHeap.insert(1, "A");
        minHeap.insert(2, "B");
        minHeap.insert(4, "D");
        Entry<Integer, String> minEntry = minHeap.min();
        System.out.println("Minimum element: Key = " + minEntry.getKey() + ", Value = " + minEntry.getValue());
        Entry<Integer, String> removedEntry = minHeap.removeMin();
        System.out.println("Removed element: Key = " + removedEntry.getKey() + ", Value = " + removedEntry.getValue());
        minEntry = minHeap.min();
        if (minEntry != null) {
            System.out.println("Minimum element after removal: Key = " + minEntry.getKey() + ", Value = " + minEntry.getValue());
        } else {
            System.out.println("MinHeap is empty.");
        }
        System.out.println("Size: " + minHeap.size());
        System.out.println("Is empty: " + minHeap.isEmpty());
    }
}
