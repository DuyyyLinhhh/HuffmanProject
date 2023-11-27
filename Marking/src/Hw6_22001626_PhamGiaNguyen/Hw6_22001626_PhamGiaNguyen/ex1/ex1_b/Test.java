package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex1.ex1_b;


public class Test {
    public static void main(String[] args) {
        SortedArrayPriorityQueue<Integer, String> sAPriorityQueue
                = new SortedArrayPriorityQueue<>();
        sAPriorityQueue.insert(3,"T");
//        sAPriorityQueue.insert(2, "B");
//        sAPriorityQueue.insert(1, "C");
//        sAPriorityQueue.insert(4, "R");
        sAPriorityQueue.print();
        System.out.println();
        System.out.println(sAPriorityQueue.min());
        System.out.println();
        System.out.println(sAPriorityQueue.removeMin());
        sAPriorityQueue.print();
    }
}
