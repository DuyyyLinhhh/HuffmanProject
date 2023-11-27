package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex4;


import ex1.ex1_a.UnsortedArrayPriorityQueue;
import ex1.ex1_b.SortedArrayPriorityQueue;
import ex1.ex1_c.UnsortedLinkedPriorityQueue;
import ex1.ex1_d.SortedLinkedPriorityQueue;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("10^2: ");
        test(100);
        System.out.println("10^3:");
        test(1000);
        System.out.println("10^4:");
        test(10000);
        System.out.println("10^5:");
        test(100000);
    }

    public static void test(long number) {
        Random random = new Random();
        System.out.println(" UnsortedArrayPriorityQueue:");
        UnsortedArrayPriorityQueue<Integer, Integer> unsortedArrayPriorityQueue = new UnsortedArrayPriorityQueue<>();
        long preTimeInsert1 = System.nanoTime();
        for (int i = 0; i < number; i++) {
            unsortedArrayPriorityQueue.insert(random.nextInt(), i);
        }
        System.out.println("Time PQ insert: " + (System.nanoTime() - preTimeInsert1));
        long preTimeRemove1 = System.nanoTime();
        for (int i = 0; i < number; i++) {
            unsortedArrayPriorityQueue.removeMin();
        }
        System.out.println("Time PQ remove: " + (System.nanoTime() - preTimeRemove1));
        System.out.println(" SortedArrayPriorityQueue:");
        SortedArrayPriorityQueue<Integer, Integer> sortedArrayPriorityQueue = new SortedArrayPriorityQueue<>();
        long preTimeInsert2 = System.nanoTime();
        for (int i = 0; i < number; i++) {
            sortedArrayPriorityQueue.insert(random.nextInt(), i);
        }
        System.out.println("Time PQ insert: " + (System.nanoTime() - preTimeInsert2));
        long preTimeRemove2 = System.nanoTime();
        for (int i = 0; i < number; i++) {
            sortedArrayPriorityQueue.removeMin();
        }
        System.out.println("Time PQ remove: " + (System.nanoTime() - preTimeRemove2));
        System.out.println(" UnsortedLinkedPriorityQueue:");
        UnsortedLinkedPriorityQueue<Integer, Integer> unsortedLinkedPriorityQueue = new UnsortedLinkedPriorityQueue<>();
        long preTimeInsert3 = System.nanoTime();
        for (int i = 0; i < number; i++) {
            unsortedLinkedPriorityQueue.insert(random.nextInt(), i);
        }
        System.out.println("Time PQ insert: " + (System.nanoTime() - preTimeInsert3));
        long preTimeRemove3 = System.nanoTime();
        for (int i = 0; i < number; i++) {
            unsortedLinkedPriorityQueue.removeMin();
        }
        System.out.println("Time PQ remove: " + (System.nanoTime() - preTimeRemove3));
        System.out.println(" UnsortedArrayPriorityQueue:");
        SortedLinkedPriorityQueue<Integer, Integer> sortedLinkedPriorityQueue = new SortedLinkedPriorityQueue<>();
        long preTimeInsert4 = System.nanoTime();
        for (int i = 0; i < number; i++) {
            sortedLinkedPriorityQueue.insert(random.nextInt(), i);
        }
        System.out.println("Time PQ insert: " + (System.nanoTime() - preTimeInsert4));
        long preTimeRemove4 = System.nanoTime();
        for (int i = 0; i < number; i++) {
            sortedLinkedPriorityQueue.removeMin();
        }
        System.out.println("Time PQ remove: " + (System.nanoTime() - preTimeRemove4));
    }
}
