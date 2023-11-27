package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex3;

import java.util.Scanner;

public class App {
    private DataSet dataSet;

    private double[][] algorithmStatistics;

    public void chooseAlgorithm(Scanner sc) {
        System.out.print("Choose the algorithm you want (1_BubbleSort)(2_BubbleSort2)(3_SelectionSort)" +
                "(4_InsertionSort)(5_MergeSort)(6_QuickSort):  \n");
        int n = sc.nextInt();
        switch (n) {
            case 1 :
                dataSet = new DataSet();
                dataSet.setSorter(new BubbleSort());
                dataSet.creatData(sc);
                System.out.println("Array before sort: ");
                dataSet.printData();
                dataSet.sort();
                System.out.println("Array after sort: ");
                dataSet.printData();
                System.out.println("Algorithm info: ");

                break;
            case 2 :
                dataSet = new DataSet();
                dataSet.setSorter(new BubbleSort2());
                dataSet.creatData(sc);
                System.out.println("Array before sort: ");
                dataSet.printData();
                dataSet.sort();
                System.out.println("Array after sort: ");
                dataSet.printData();
                System.out.println("Algorithm info: ");

//                dataSet.printRuntime();
                break;
            case 3 :
                dataSet = new DataSet();
                dataSet.setSorter(new SelectionSort());
                dataSet.creatData(sc);
                System.out.println("Array before sort: ");
                dataSet.printData();
                dataSet.sort();
                System.out.println("Array after sort: ");
                dataSet.printData();
                System.out.println("Algorithm info: ");

//                dataSet.printRuntime();
                break;
            case 4 :
                dataSet = new DataSet();
                dataSet.setSorter(new MergeSort());
                dataSet.creatData(sc);
                System.out.println("Array before sort: ");
                dataSet.printData();
                dataSet.sort();
                System.out.println("Array after sort: ");
                dataSet.printData();
                System.out.println("Algorithm info: ");

//                dataSet.printRuntime();
                break;
            case 5 :
                dataSet = new DataSet();
                dataSet.setSorter(new MergeSort());
                dataSet.creatData(sc);
                System.out.println("Array before sort: ");
                dataSet.printData();
                dataSet.sort();
                System.out.println("Array after sort: ");
                dataSet.printData();
                System.out.println("Algorithm info: ");

//                dataSet.printRuntime();
                break;
            case 6 :
                dataSet = new DataSet();
                dataSet.setSorter(new QuickSort());
                dataSet.creatData(sc);
                System.out.println("Array before sort: ");
                dataSet.printData();
                dataSet.sort();
                System.out.println("Array after sort: ");
                dataSet.printData();
                System.out.println("Algorithm info: ");

//                dataSet.printRuntime();
                break;
            case 7 :
                dataSet = new DataSet();
                dataSet.setSorter(new HeapSort());
                dataSet.creatData(sc);
                System.out.println("Array before sort: ");
                dataSet.printData();
                dataSet.sort();
                System.out.println("Array after sort: ");
                dataSet.printData();
                System.out.println("Algorithm info: ");

        }
    }

    public void chooseTest() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select the test you want (1_Print each line(Not working!))(2_Test Algorithm):  ");
        int c = sc.nextInt();
        switch (c) {
//            case 1 :
//                printEachLine();
//                break;
            case 2 :
                testAlgorithm();
                break;
        }
    }

    public void printEachLine() {
        Scanner sc = new Scanner(System.in);
        dataSet.creatData(sc);
        dataSet.sortAndPrint();
    }

    public void testAlgorithm() {
        dataSet.runtimeStatistics();
        dataSet.printRuntime();
    }




}
