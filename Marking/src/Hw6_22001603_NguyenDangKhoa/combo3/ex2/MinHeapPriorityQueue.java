package Hw6_22001603_NguyenDangKhoa.combo3.ex2;

import hw6_22001603_NguyenDangKhoa.combo3.ex1.Entry;
import hw6_22001603_NguyenDangKhoa.combo3.ex1.SortedArrayPriorityQueue;

import java.util.Arrays;


public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue<K, E> {
    protected ArrEntry<K, E>[] heapPQ = array;

    public MinHeapPriorityQueue() {
    }

    public MinHeapPriorityQueue(int size) {
        super(size);
    }

    private void swap(int i, int j) {
        if (i >= 0 && i < heapPQ.length && j >= 0 && j < heapPQ.length) {
            ArrEntry<K, E> temp = heapPQ[i];
            array[i] = array[j];
            array[j] = temp;
        }else {
            System.out.println("Không thể đổi chỗ!!!");
        }
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (entry == null) {
            System.out.println("Entry is NULL!!!");
        } else if (isEmpty()) {
            heapPQ[0] = (ArrEntry<K, E>) entry;
            n++;
        } else {
            heapPQ[n] = (ArrEntry<K, E>) entry;
            n++;
            upHeap();
        }
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, E> min = array[0];
        swap(0, n - 1);
        n--;
        downHeap();
        return min;
    }

    @Override
    public Entry<K, E> min() {
        return heapPQ[0];
    }

    protected void upHeap() {
        int currentIndex = n - 1;
        int parentIndex = (currentIndex - 1) / 2;
        while (currentIndex > 0) {
            if (heapPQ[parentIndex].getKey().compareTo(heapPQ[currentIndex].getKey()) > 0) {
                swap(parentIndex, currentIndex);
                currentIndex = parentIndex;
                parentIndex = (currentIndex - 1) / 2;
            } else {
                break;
            }
        }
    }

    protected void downHeap() {
        int currentIndex = 0;
        while (2 * currentIndex + 1 < n) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = leftChildIndex + 1;
            int smallerChildIndex = leftChildIndex;

            if (rightChildIndex < n && heapPQ[rightChildIndex].getKey().compareTo(heapPQ[leftChildIndex].getKey()) < 0) {
                smallerChildIndex = rightChildIndex;
            }

            if (heapPQ[currentIndex].getKey().compareTo(heapPQ[smallerChildIndex].getKey()) > 0) {
                swap(currentIndex, smallerChildIndex);
                currentIndex = smallerChildIndex;
            } else {
                break;
            }
        }
    }
    public ArrEntry<K, E>[] toArray() {
        return Arrays.copyOfRange(heapPQ, 0, n);
    }
}