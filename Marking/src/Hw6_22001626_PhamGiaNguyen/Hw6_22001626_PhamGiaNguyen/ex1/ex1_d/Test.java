package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex1.ex1_d;

public class Test {
    public static void main(String[] args) {
        SortedLinkedPriorityQueue<Integer, String> sLPriorityQueue
                = new SortedLinkedPriorityQueue<>();
        sLPriorityQueue.insert(7,"T");
        sLPriorityQueue.insert(2, "B");
        sLPriorityQueue.insert(1, "C");
        sLPriorityQueue.insert(3, "R");
        sLPriorityQueue.print();
        System.out.println();
        System.out.println(sLPriorityQueue.min());
        System.out.println(sLPriorityQueue.removeMin());
        sLPriorityQueue.print();
    }
}
