package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex3;

import java.util.*;

public class DataSet {
    private int[] data;
    private Sorter sorter;
    private long time;

    public DataSet() {
    }

    public DataSet inPutData(Scanner sc) {
        System.out.println("Enter length of the array: ");
        int n = sc.nextInt();
        Random rd = new Random();
        data = new int[n];
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < n) {
            int randomNumber = rd.nextInt(1, (int) Math.pow(10, 7));
            uniqueNumbers.add(randomNumber);
        }
        Integer[] number = uniqueNumbers.toArray(new Integer[0]);
        for (int i = 0; i < n; i++) {
            data[i] = number[i];
        }

        return this;
    }

    public DataSet creatData(Scanner sc) {
        Random rd = new Random();
        System.out.println("Enter length of the array: ");
        int n = sc.nextInt();
        data = new int[n];
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < n) {
            int randomNumber = rd.nextInt(1, (int) Math.pow(10, 7));
            uniqueNumbers.add(randomNumber);
        }
        Integer[] number = uniqueNumbers.toArray(new Integer[0]);
        for (int i = 0; i < n; i++) {
            data[i] = number[i];
        }

        return this;
    }

    public DataSet creatData2(int n) {
        Random rd = new Random();
        data = new int[n];
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < n) {
            int randomNumber = rd.nextInt(1, (int) Math.pow(10, 7));
            uniqueNumbers.add(randomNumber);
        }
        Integer[] number = uniqueNumbers.toArray(new Integer[0]);
        for (int i = 0; i < n; i++) {
            data[i] = number[i];
        }

        return this;
    }

    public void printData(){
        System.out.println(Arrays.toString(data));
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public void sort() {
        sorter.setData(data);
        sorter.sort();
        time = sorter.time();
    }

    public void sortAndPrint() {
        sorter.setData(data);
        sorter.sortAndPrint();
    }


    public double[][] runtimeStatistics() {
        double[][] statistics = new double[110][2];
        int count = 0;
        int length = 10;
        for (int j = 0; j < statistics.length; j++) {
            double averageRunTime = 0;
            for (int i = 0; i < 20; i++) {
                creatData2(length);
                sort();
                averageRunTime += (double) sorter.time();
            }
            statistics[count][0] = length;
            statistics[count][1] = averageRunTime / 20;
            count++;
            length += 100;
        }

        return statistics;
    }

    public void printRuntime() {
        double[][] statistics = runtimeStatistics();
        for (int i = 0; i < statistics.length; i++) {
            System.out.println(statistics[i][0] + ":" + statistics[i][1]);
        }
    }

    public void getTime() {
        System.out.println(sorter.time());
    }
}