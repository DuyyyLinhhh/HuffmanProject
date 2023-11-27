package Hw6_22001603_NguyenDangKhoa.combo3.ex1;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
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
        }
        NodeEntry<K, E> newNode = new NodeEntry<>(entry.getKey(), entry.getValue());
        if (isEmpty()) {
            headNode = newNode;
            tailNode = newNode;
        } else {
            tailNode.next = newNode;
            tailNode = newNode;
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
        NodeEntry<K, E> minNode = findMinNode();
        NodeEntry<K, E> prevNode = findPrevNode(minNode);
        if (prevNode == null) {
            headNode = minNode.next;
        } else {
            prevNode.next = minNode.next;
        }
        if (minNode == tailNode) {
            tailNode = prevNode;
        }
        n--;
        return minNode;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }
        NodeEntry<K, E> minNode = findMinNode();
        return minNode;
    }

    private NodeEntry<K, E> findMinNode() {
        NodeEntry<K, E> currentNode = headNode;
        NodeEntry<K, E> minNode = headNode;
        while (currentNode != null) {
            if (currentNode.getKey().compareTo(minNode.getKey()) < 0) {
                minNode = currentNode;
            }
            currentNode = currentNode.next;
        }
        return minNode;
    }

    private NodeEntry<K, E> findPrevNode(NodeEntry<K, E> node) {
        NodeEntry<K, E> currentNode = headNode;
        NodeEntry<K, E> prevNode = null;
        while (currentNode != null) {
            if (currentNode == node) {
                return prevNode;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        return null;
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
        UnsortedLinkedPriorityQueue<Integer, String> queue = new UnsortedLinkedPriorityQueue<>();

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

    }
}
