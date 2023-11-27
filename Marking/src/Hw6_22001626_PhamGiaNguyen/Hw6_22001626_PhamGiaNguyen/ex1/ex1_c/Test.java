package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex1.ex1_c;

public class Test {
    public static void main(String[] args) {
        UnsortedLinkedPriorityQueue<Integer, String> uSLPriorityQueue
                = new UnsortedLinkedPriorityQueue<>();
        uSLPriorityQueue.insert(3,"T");
        System.out.println(uSLPriorityQueue.removeMin());
//        uSLPriorityQueue.insert(1, "B");
        uSLPriorityQueue.insert(2, "C");
//        uSLPriorityQueue.insert(7, "R");
        uSLPriorityQueue.print();
        System.out.println();
        System.out.println(uSLPriorityQueue.min());
        System.out.println(uSLPriorityQueue.removeMin());
        uSLPriorityQueue.print();
    }
}
