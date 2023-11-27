package Hw6_22001603_NguyenDangKhoa.combo3.ex3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class TestRunTime {
    public static void main(String[] args) {
        int[] arraySizes = {100, 1000, 5000, 7000, 10000, 25000, 50000, 75000, 100000};
        int numRuns = 20;

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("C:\\Learning\\java1\\dsa\\src\\hw6_22001603_NguyenDangKhoa\\ex3\\runtime.csv"));
            writer.println("---------------Average run time 20 times(milliseconds)---------------");
            writer.println("Array Size  | BubbleSort | SelectionSort | InsertionSort  | Mergesort | QuickSort  | HeapSort");

            for (int size : arraySizes) {
                double bubbleSortTotalTime = 0,
                        selectionSortTotalTime = 0,
                        insertionSortTotalTime = 0,
                        mergeSortTotalTime = 0,
                        quickSortTotalTime = 0,
                        heapSortTotalTime = 0;

                for (int run = 1; run <= numRuns; run++) {
                    int[] array = generateRandomArray(size);

                    int[] bubbleSortArray = Arrays.copyOf(array, array.length);
                    int[] selectionSortArray = Arrays.copyOf(array, array.length);
                    int[] insertionSortArray = Arrays.copyOf(array, array.length);
                    int[] mergeSortArray = Arrays.copyOf(array, array.length);
                    int[] quickSortArray = Arrays.copyOf(array, array.length);
                    int[] heapSortArray = Arrays.copyOf(array, array.length);

                    long startTime, endTime;

                    // Bubblesort
                    startTime = System.nanoTime();
                    BubbleSort.bubbleSort(bubbleSortArray);
                    endTime = System.nanoTime();
                    bubbleSortTotalTime += (endTime - startTime) / 1000000.0;

                    // Selectionsort
                    startTime = System.nanoTime();
                    SelectionSort.selectionSort(selectionSortArray);
                    endTime = System.nanoTime();
                    selectionSortTotalTime += (endTime - startTime) / 1000000.0;

                    // Insertionsort
                    startTime = System.nanoTime();
                    InsertionSort.insertionSort(insertionSortArray);
                    endTime = System.nanoTime();
                    insertionSortTotalTime += (endTime - startTime) / 1000000.0;

                    // Mergesort
                    startTime = System.nanoTime();
                    MergeSort.mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
                    endTime = System.nanoTime();
                    mergeSortTotalTime += (endTime - startTime) / 1000000.0;

                    // Quicksort
                    startTime = System.nanoTime();
                    QuickSort.quickSort(quickSortArray, 0, quickSortArray.length - 1);
                    endTime = System.nanoTime();
                    quickSortTotalTime += (endTime - startTime) / 1000000.0;

                    //HeapSort
                    startTime = System.nanoTime();
                    HeapSort.heapSort(heapSortArray);
                    endTime = System.nanoTime();
                    heapSortTotalTime += (endTime - startTime) / 1000000.0;
                }

                double bubbleSortAvgTime = Math.round((bubbleSortTotalTime / numRuns) * 1000.0) / 1000.0;
                double selectionSortAvgTime = Math.round((selectionSortTotalTime / numRuns) * 1000.0) / 1000.0;
                double insertionSortAvgTime = Math.round((insertionSortTotalTime / numRuns) * 1000.0) / 1000.0;
                double mergeSortAvgTime = Math.round((mergeSortTotalTime / numRuns) * 1000.0) / 1000.0;
                double quickSortAvgTime = Math.round((quickSortTotalTime / numRuns) * 1000.0) / 1000.0;
                double heapSortAvgTime = Math.round((heapSortTotalTime / numRuns) * 1000.0) / 1000.0;

                String formattedRow = String.format("%-11d | %-10.3f | %-13.3f | %-14.3f | %-9.3f | %-10.3f | %-8.3f",
                        size, bubbleSortAvgTime, selectionSortAvgTime,
                        insertionSortAvgTime, mergeSortAvgTime, quickSortAvgTime, heapSortAvgTime);

                writer.println(formattedRow);
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            int x = random.nextInt((int) Math.pow(10, 6) + 1);
            array[i] = x;
        }
        return array;
    }
}

