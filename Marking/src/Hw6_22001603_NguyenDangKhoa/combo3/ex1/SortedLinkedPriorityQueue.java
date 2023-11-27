package Hw6_22001603_NguyenDangKhoa.combo3.ex1;

public class SortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
    private NodeEntry<K, E> headNode;
    private NodeEntry<K, E> tailNode;
    int n = 0;

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
            return;
        }
        NodeEntry<K, E> newNode = new NodeEntry<>(entry.getKey(), entry.getValue());
        if (isEmpty()) {
            headNode = newNode;
            tailNode = newNode;
        } else if (newNode.getKey().compareTo(headNode.getKey()) <= 0) {
            newNode.next = headNode;
            headNode = newNode;
        } else if (newNode.getKey().compareTo(tailNode.getKey()) >= 0) {
            tailNode.next = newNode;
            tailNode = newNode;
        } else {
            NodeEntry<K, E> currentNode = headNode;
            while (currentNode.next != null && newNode.getKey().compareTo(currentNode.next.getKey()) > 0) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        n++;
    }

    @Override
    public void insert(K k, E e) {
        insert(new NodeEntry<>(k, e));

    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }
        NodeEntry<K, E> removedNode = headNode;
        headNode = headNode.next;
        if (headNode == null) {
            tailNode = null;
        }
        n--;
        return removedNode;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }

        return headNode;
    }


    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            this.key = k;
            this.element = e;
            this.next = null;
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
        SortedLinkedPriorityQueue<Integer, String> queue = new SortedLinkedPriorityQueue<>();

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
        System.out.println(2);
    }
}