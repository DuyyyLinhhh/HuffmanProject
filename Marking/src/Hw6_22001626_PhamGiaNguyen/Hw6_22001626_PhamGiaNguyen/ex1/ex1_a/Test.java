package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex1.ex1_a;

public class Test {
    public static void main(String[] args) {
        UnsortedArrayPriorityQueue<Integer, String> unSAPriorityQueue
                = new UnsortedArrayPriorityQueue<>();
        unSAPriorityQueue.insert(2, "B");
        unSAPriorityQueue.insert(3, "C");
        unSAPriorityQueue.insert(1, "R");
        unSAPriorityQueue.print();
        System.out.println(unSAPriorityQueue.min());
        System.out.println(unSAPriorityQueue.removeMin());
        unSAPriorityQueue.print();
    }
}
