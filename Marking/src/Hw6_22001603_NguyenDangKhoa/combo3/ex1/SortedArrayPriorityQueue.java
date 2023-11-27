package Hw6_22001603_NguyenDangKhoa.combo3.ex1;

public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
    protected ArrEntry<K, E>[] array;
     protected int n = 0;
    protected int DEFAULT_SIZE = 1000;

    public SortedArrayPriorityQueue(int size) {
        array = new ArrEntry[size];
    }

    public SortedArrayPriorityQueue() {
        array = new ArrEntry[DEFAULT_SIZE];
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
        if (entry == null) {
            System.out.println("Entry is null!!!");
        } else if (n == array.length) {
            System.out.println("Full!!!");
        } else if (isEmpty()) {
            array[0]= (ArrEntry<K, E>) entry;
            n++;
        } else {
            int index = 0;
            while (index < n && entry.getKey().compareTo(array[index].getKey()) > 0) {
                index++;
            }
            for (int i = n; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = (ArrEntry<K, E>) entry;
            n++;
        }

    }

    @Override
    public void insert(K k, E e) {
        insert(new ArrEntry<>(k, e));

    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, E> minEntry = array[0];
        for (int i = 0; i < n - 1; i++) {
            array[i] = array[i + 1];
        }
        array[n - 1] = null;
        n--;
        return minEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }
        return array[0];
    }
    public static class ArrEntry<K extends Comparable, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry(K k, E e) {
            key = k;
            element = e;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return element;
        }
    }
    public static void main(String[] args) {
        SortedArrayPriorityQueue<Integer, String> queue = new SortedArrayPriorityQueue<>();

        queue.insert(3, "C");
        queue.insert(1, "A");
        queue.insert(2, "B");
        queue.insert(4, "D");

        Entry<Integer, String> minEntry = queue.min();
        System.out.println("Minimum element: Key = " + minEntry.getKey() + ", Value = " + minEntry.getValue());

        Entry<Integer, String> removedEntry = queue.removeMin();
        System.out.println("Removed element: Key = " + removedEntry.getKey() + ", Value = " + removedEntry.getValue());

        minEntry = queue.min();
        System.out.println("Minimum element after removal: Key = " + minEntry.getKey() + ", Value = " + minEntry.getValue());

        System.out.println("Size: " + queue.size());
        System.out.println("Is empty: " + queue.isEmpty());
        System.out.println(1);
    }
}