package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex1.ex1_a;

import Hw6_22001626_PhamGiaNguyen.ex1.Entry;
import Hw6_22001626_PhamGiaNguyen.ex1.PriorityQueueInterface;

public class UnsortedArrayPriorityQueue <K extends Comparable, E> implements PriorityQueueInterface<K, E> {

    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;

        E eValue;

        public ArrEntry(K k, E e) {
            this.key = k;
            this.eValue = e;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return eValue;
        }

        @Override
        public String toString() {
            return "{" +
                    "key=" + key +
                    ", eValue=" + eValue +
                    '}';
        }
    }

    ArrEntry<K, E> [] array;
    int n = 0;
    final int defaultSize = 1000;

    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[defaultSize];
    }

    private boolean isContainKey(Entry<K, E> arrEntry) {
        for (int i = 0; i < n; i++) {
            if (arrEntry.getKey().equals(array[i].getKey())) return true;
        }
        return false;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (n >= defaultSize) throw new IllegalStateException("Queue is full");
        if (isContainKey(entry)) throw new RuntimeException("Key: " + entry.getKey() + " is contain");
        array[n++] = (ArrEntry<K, E>) entry;
    }

    @Override
    public void insert(K k, E e) {
        insert(new ArrEntry<>(k, e));
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) return null;
        int minIndex = 0;
        ArrEntry<K, E> minEntry = array[0];
        for (int i = 1; i < n; i++) {
            if (minEntry.getKey().compareTo(array[i].getKey()) > 0 ) minIndex = i;
        }

        for (int i = minIndex; i < n - 1; i++) {
            array[i] = array[i + 1];
        }
        n--;
        return array[minIndex];
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) return null;
        int minIndex = 0;
        ArrEntry<K, E> minEntry = array[0];
        for (int i = 1; i < n; i++) {
            if (minEntry.getKey().compareTo(array[i].getKey()) > 0 ) minIndex = i;
        }
        return array[minIndex];
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] +" ");
        }
    }
}
