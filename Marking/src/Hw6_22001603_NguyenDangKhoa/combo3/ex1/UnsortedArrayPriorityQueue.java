package Hw6_22001603_NguyenDangKhoa.combo3.ex1;

public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
    ArrEntry<K, E>[] array;
    int n = 0;
    final int DEFAULT_SIZE = 1000;

    public UnsortedArrayPriorityQueue() {
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
        }
        if (n >= array.length) {
            System.out.println("Full!!!");
        }
        if (n < array.length) {
            array[n] = (ArrEntry<K, E>) entry;
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
        int minIndex = 0;
        K minKey = array[0].getKey();
        for (int i = 1; i < n; i++) {
            K currentKey = array[i].getKey();
            if (currentKey.compareTo(minKey) < 0) {
                minKey = currentKey;
                minIndex = i;
            }
        }
        Entry<K, E> minEntry = array[minIndex];
        array[minIndex] = array[n - 1];
        n--;
        return minEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, E> minEntry = array[0];
        K minKey = array[0].getKey();
        for (int i = 1; i < n; i++) {
            K currentKey = array[i].getKey();
            if (currentKey.compareTo(minKey) < 0) {
                minKey = currentKey;
                minEntry = array[i];
            }
        }
        return minEntry;
    }

    public class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry(K k, E e) {
            this.key = k;
            this.element = e;
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
        UnsortedArrayPriorityQueue<Integer, String> queue = new UnsortedArrayPriorityQueue<>();

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
        System.out.println(3);
    }
}
