package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataSet dataSet = new DataSet();
        dataSet.creatData(sc);
        dataSet.printData();
        dataSet.setSorter(new QuickSort());
        dataSet.sort();
        dataSet.printData();
        dataSet.getTime();
//        App app = new App();
//        app.chooseAlgorithm(sc);
//        app.chooseTest();
//        app.testAlgorithm();
//        app.printEachLine();
//        float a = -4.2f;
//        float b = 10;
//        float c = (float) (a * Math.pow(10, 4));
//        System.out.println(c);
    }


}
