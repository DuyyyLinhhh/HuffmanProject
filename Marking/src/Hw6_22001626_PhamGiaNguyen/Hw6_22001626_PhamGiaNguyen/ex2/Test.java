package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex2;

import ex1.Entry;

public class Test {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> minHeapPQ = new MinHeapPriorityQueue<>();

        minHeapPQ.insert(3, "Three");
        minHeapPQ.insert(1, "One");
        minHeapPQ.insert(4, "Four");
        minHeapPQ.insert(2, "Two");

        Entry<Integer, String> minEntry = minHeapPQ.min();
        System.out.println("Min Entry: " + minEntry.getKey() + " - " + minEntry.getValue());

        Entry<Integer, String> removedEntry = minHeapPQ.removeMin();
        System.out.println("Removed Entry: " + removedEntry.getKey() + " - " + removedEntry.getValue());

        System.out.println("Size of Priority Queue: " + minHeapPQ.size());
        Entry<Integer, String> removedEntry2 = minHeapPQ.removeMin();
        System.out.println("Removed Entry: " + removedEntry2.getKey() + " - " + removedEntry2.getValue());


        minHeapPQ.insert(0, "Zero");

        minEntry = minHeapPQ.min();
        System.out.println("Min Entry after insertion: " + minEntry.getKey() + " - " + minEntry.getValue());
    }
}
