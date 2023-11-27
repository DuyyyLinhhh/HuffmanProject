package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex3;

public class HeapSort extends MinHeapPriorityQueue implements Sorter {

    private int[] arr;

    private long start, end = 0;

    public void sort(){
        MinHeapPriorityQueue minHeapPriorityQueue = new MinHeapPriorityQueue<>();
        ArrEntry<Integer, Integer>[] arrEntry;
        arrEntry = new ArrEntry[arr.length];
        for (int i = 0; i < arr.length; i++) {
            minHeapPriorityQueue.insert(new ArrEntry<>(arr[i], arr[i]));
        }
        start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arrEntry[i] = (ArrEntry<Integer, Integer>) minHeapPriorityQueue.removeMin();
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrEntry[i].getKey();
        }
        end = System.currentTimeMillis();
    }

    @Override
    public void sortAndPrint() {

    }

    @Override
    public void setData(int[] data) {
        arr = data;
    }

    @Override
    public long time() {
        return this.end - this.start;
    }
}
