package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex2;

import ex1.Entry;
import ex1.PriorityQueueInterface;

public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

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

    ArrEntry<K, E>[] array;
    int n = 0;
    final int defaultSize = 1000;

    public SortedArrayPriorityQueue() {
        array = (ArrEntry<K, E>[]) new ArrEntry[defaultSize];
    }

    public SortedArrayPriorityQueue(ArrEntry<K, E>[] array) {
        this.array = array;
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
        int i = 0;
        if (n != 0) {
            for (i = n - 1; i >= 0; i--) {
                if (entry.getKey().compareTo(array[i].getKey()) <= 0) {
                    break;
                }
                array[i + 1] = array[i];
            }
            array[i + 1] = (ArrEntry<K, E>) entry;
        } else {
            array[i] = (ArrEntry<K, E>) entry;
        }

        n++;
    }

    @Override
    public void insert(K k, E e) {
        insert(new ArrEntry<>(k, e));
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) return null;
        Entry<K, E> minEntry = array[n - 1];
        array[n - 1] = null;
        n--;
        return minEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) return null;
        return array[n - 1];
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] +" ");
        }
    }
}