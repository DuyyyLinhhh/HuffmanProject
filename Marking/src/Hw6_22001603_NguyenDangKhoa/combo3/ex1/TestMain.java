package Hw6_22001603_NguyenDangKhoa.combo3.ex1;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("**************** Danh sách số nguyên , giá trị phần tử dùng làm khóa ****************\n");
        //UnsortedArrayPriorityQueue
        System.out.println("---UnsortedArrayPriorityQueue---\n");
        UnsortedArrayPriorityQueue<Integer, Integer> unsortedArrayPriorityQueue = new UnsortedArrayPriorityQueue();
        System.out.println("Is empty: " + unsortedArrayPriorityQueue.isEmpty());
        unsortedArrayPriorityQueue.insert(3,3);
        unsortedArrayPriorityQueue.insert(2,2);
        unsortedArrayPriorityQueue.insert(1,1);
        unsortedArrayPriorityQueue.insert(5,5);
        Entry<Integer, Integer> minEntry1 = unsortedArrayPriorityQueue.min();
        System.out.println("Minimum element: Key = " + minEntry1.getKey() + ", Value = " + minEntry1.getValue());

        Entry<Integer, Integer> removedEntry1 = unsortedArrayPriorityQueue.removeMin();
        System.out.println("Removed element: Key = " + removedEntry1.getKey() + ", Value = " + removedEntry1.getValue());

        minEntry1 = unsortedArrayPriorityQueue.min();
        System.out.println("Minimum element after removal: Key = " + minEntry1.getKey() + ", Value = " + minEntry1.getValue());

        System.out.println("Size: " + unsortedArrayPriorityQueue.size());
        System.out.println("Is empty: " + unsortedArrayPriorityQueue.isEmpty());

        //UnsortedLinkedPriorityQueue
        System.out.println("\n---UnsortedLinkedPriorityQueue---\n");
        UnsortedLinkedPriorityQueue<Integer, Integer> unsortedLinkedPriorityQueue = new UnsortedLinkedPriorityQueue<>();
        System.out.println("Is empty: " + unsortedLinkedPriorityQueue.isEmpty());
        unsortedLinkedPriorityQueue.insert(3,3);
        unsortedLinkedPriorityQueue.insert(2,2);
        unsortedLinkedPriorityQueue.insert(1,1);
        unsortedLinkedPriorityQueue.insert(5,5);
        Entry<Integer, Integer> minEntry2 = unsortedLinkedPriorityQueue.min();
        System.out.println("Minimum element: Key = " + minEntry2.getKey() + ", Value = " + minEntry2.getValue());

        Entry<Integer, Integer> removedEntry2 = unsortedLinkedPriorityQueue.removeMin();
        System.out.println("Removed element: Key = " + removedEntry2.getKey() + ", Value = " + removedEntry2.getValue());

        minEntry2 = unsortedLinkedPriorityQueue.min();
        System.out.println("Minimum element after removal: Key = " + minEntry2.getKey() + ", Value = " + minEntry2.getValue());

        System.out.println("Size: " + unsortedLinkedPriorityQueue.size());
        System.out.println("Is empty: " + unsortedLinkedPriorityQueue.isEmpty());

        //SortedArrayPriorityQueue
        System.out.println("\n---SortedArrayPriorityQueue---\n");
        SortedArrayPriorityQueue<Integer, Integer> sortedArrayPriorityQueue = new SortedArrayPriorityQueue<>();
        System.out.println("Is empty: " + sortedArrayPriorityQueue.isEmpty());
        sortedArrayPriorityQueue.insert(3,3);
        sortedArrayPriorityQueue.insert(2,2);
        sortedArrayPriorityQueue.insert(1,1);
        sortedArrayPriorityQueue.insert(5,5);
        Entry<Integer, Integer> minEntry3 = sortedArrayPriorityQueue.min();
        System.out.println("Minimum element: Key = " + minEntry3.getKey() + ", Value = " + minEntry3.getValue());

        Entry<Integer, Integer> removedEntry3 = sortedArrayPriorityQueue.removeMin();
        System.out.println("Removed element: Key = " + removedEntry3.getKey() + ", Value = " + removedEntry3.getValue());

        minEntry3 = sortedArrayPriorityQueue.min();
        System.out.println("Minimum element after removal: Key = " + minEntry3.getKey() + ", Value = " + minEntry3.getValue());

        System.out.println("Size: " + sortedArrayPriorityQueue.size());
        System.out.println("Is empty: " + sortedArrayPriorityQueue.isEmpty());

        //SortedLinkedPriorityQueue
        System.out.println("\n---SortedLinkedPriorityQueue---\n");
        SortedLinkedPriorityQueue<Integer, Integer> sortedLinkedPriorityQueue = new SortedLinkedPriorityQueue<>();
        System.out.println("Is empty: " + sortedLinkedPriorityQueue.isEmpty());
        sortedLinkedPriorityQueue.insert(3,3);
        sortedLinkedPriorityQueue.insert(2,2);
        sortedLinkedPriorityQueue.insert(1,1);
        sortedLinkedPriorityQueue.insert(5,5);
        Entry<Integer, Integer> minEntry4 = sortedLinkedPriorityQueue.min();
        System.out.println("Minimum element: Key = " + minEntry4.getKey() + ", Value = " + minEntry4.getValue());

        Entry<Integer, Integer> removedEntry4 = sortedLinkedPriorityQueue.removeMin();
        System.out.println("Removed element: Key = " + removedEntry4.getKey() + ", Value = " + removedEntry4.getValue());

        minEntry4 = sortedLinkedPriorityQueue.min();
        System.out.println("Minimum element after removal: Key = " + minEntry4.getKey() + ", Value = " + minEntry4.getValue());

        System.out.println("Size: " + sortedLinkedPriorityQueue.size());
        System.out.println("Is empty: " + sortedLinkedPriorityQueue.isEmpty());

        System.out.println("**************** Danh sách các đối tượng có khóa và giá trị khác nhau ***************\n");
        //UnsortedArrayPriorityQueue
        System.out.println("---UnsortedArrayPriorityQueue---");
        UnsortedArrayPriorityQueue<Integer, String> queue1 = new UnsortedArrayPriorityQueue<>();

        System.out.println("Is empty" + queue1.isEmpty());

        queue1.insert(3, "C");
        queue1.insert(1, "A");
        queue1.insert(2, "B");
        queue1.insert(4, "D");

        Entry<Integer, String> minEntry5 = queue1.min();
        System.out.println("Minimum element: Key = " + minEntry5.getKey() + ", Value = " + minEntry5.getValue());

        Entry<Integer, String> removedEntry5 = queue1.removeMin();
        System.out.println("Removed element: Key = " + removedEntry5.getKey() + ", Value = " + removedEntry5.getValue());

        minEntry5 = queue1.min();
        System.out.println("Minimum element after removal: Key = " + minEntry5.getKey() + ", Value = " + minEntry5.getValue());

        System.out.println("Size: " + queue1.size());
        System.out.println("Is empty: " + queue1.isEmpty());
        //UnsortedLinkedPriorityQueue
        System.out.println("\n---UnsortedLinkedPriorityQueue\n");
        UnsortedLinkedPriorityQueue<Integer, String> queue2 = new UnsortedLinkedPriorityQueue<>();

        System.out.println("Is empty: " + queue2.isEmpty() );

        queue2.insert(3, "C");
        queue2.insert(1, "A");
        queue2.insert(2, "B");
        queue2.insert(4, "D");

        Entry<Integer, String> minEntry6 = queue2.min();
        System.out.println("Minimum element: Key = " + minEntry6.getKey() + ", Value = " + minEntry6.getValue());

        Entry<Integer, String> removedEntry6 = queue2.removeMin();
        System.out.println("Removed element: Key = " + removedEntry6.getKey() + ", Value = " + removedEntry6.getValue());

        minEntry6 = queue2.min();
        System.out.println("Minimum element after removal: Key = " + minEntry6.getKey() + ", Value = " + minEntry6.getValue());

        System.out.println("Size: " + queue2.size());
        System.out.println("Is empty: " + queue2.isEmpty());

        //SortedArrayPriorityQueue
        System.out.println("\n---SortedArrayPriorityQueue---\n");
        SortedArrayPriorityQueue<Integer, String> queue3 = new SortedArrayPriorityQueue<>();
        System.out.println("Is empty: " + queue3.isEmpty());

        queue3.insert(3, "C");
        queue3.insert(1, "A");
        queue3.insert(2, "B");
        queue3.insert(4, "D");

        Entry<Integer, String> minEntry7 = queue3.min();
        System.out.println("Minimum element: Key = " + minEntry7.getKey() + ", Value = " + minEntry7.getValue());

        Entry<Integer, String> removedEntry7 = queue3.removeMin();
        System.out.println("Removed element: Key = " + removedEntry7.getKey() + ", Value = " + removedEntry7.getValue());

        minEntry7 = queue3.min();
        System.out.println("Minimum element after removal: Key = " + minEntry7.getKey() + ", Value = " + minEntry7.getValue());

        System.out.println("Size: " + queue3.size());
        System.out.println("Is empty: " + queue3.isEmpty());

        //SortedLinkedPriorityQueue
        System.out.println("\n---SortedLinkedPriorityQueue---\n");
        SortedLinkedPriorityQueue<Integer, String> queue4 = new SortedLinkedPriorityQueue<>();
        System.out.println("Is empty: " + queue4.isEmpty());

        queue4.insert(3, "C");
        queue4.insert(1, "A");
        queue4.insert(2, "B");
        queue4.insert(4, "D");

        Entry<Integer, String> minEntry8 = queue4.min();
        System.out.println("Minimum element: Key = " + minEntry8.getKey() + ", Value = " + minEntry8.getValue());

        Entry<Integer, String> removedEntry8 = queue4.removeMin();
        System.out.println("Removed element: Key = " + removedEntry8.getKey() + ", Value = " + removedEntry8.getValue());

        minEntry8 = queue4.min();
        System.out.println("Minimum element after removal: Key = " + minEntry8.getKey() + ", Value = " + minEntry8.getValue());

        System.out.println("Size: " + queue4.size());
        System.out.println("Is empty: " + queue4.isEmpty());
    }
}
