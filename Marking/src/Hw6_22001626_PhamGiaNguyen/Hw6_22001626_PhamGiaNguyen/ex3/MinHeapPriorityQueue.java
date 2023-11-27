package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex3;

import ex1.Entry;

public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue<K, E> {
    ArrEntry<K, E>[] heapPQ;

    public MinHeapPriorityQueue() {
        super();
        this.heapPQ = super.array;
    }

    protected void upHeap() {
        int index = n - 1;
        while (index > 0) {
            int parent = getParent(index);
            if (heapPQ[index].getKey().compareTo(heapPQ[parent].getKey()) < 0) {
                break;
            }
            swap(index, parent);
            index = parent;
        }
    }

    protected void downHeap() {
        int index = 0;
        while (hasLeft(index)) {
            int leftIndex = getLeftChildren(index);
            int smallChildIndex = leftIndex;
            if (hasRight(index)) {
                int rightIndex = getRightChildren(index);
                if (heapPQ[leftIndex].getKey().compareTo(heapPQ[rightIndex].getKey()) > 0) {
                    smallChildIndex = rightIndex;
                }
            }
            if (heapPQ[smallChildIndex].getKey().compareTo(heapPQ[index].getKey()) < 0) {
                break;
            }
            swap(smallChildIndex, index);
            index = smallChildIndex;
        }
    }

    @Override
    public Entry<K, E> removeMin() {
        Entry<K, E> entry = super.removeMin();
        downHeap();
        return entry;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        super.insert(entry);
        upHeap();
    }


    @Override
    public void insert(K key, E element) {
        this.insert(new ArrEntry<K, E>(key, element));
    }

    private void swap(int i, int j) {
        ArrEntry<K, E> tmp = heapPQ[i];
        heapPQ[i] = heapPQ[j];
        heapPQ[j] = tmp;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildren(int index) {
        return index * 2 + 1;
    }

    private int getRightChildren(int index) {
        return index * 2 + 2;
    }

    private boolean hasLeft(int index) {
        return getLeftChildren(index) < n;
    }

    private boolean hasRight(int index) {
        return getRightChildren(index) < n;
    }
}