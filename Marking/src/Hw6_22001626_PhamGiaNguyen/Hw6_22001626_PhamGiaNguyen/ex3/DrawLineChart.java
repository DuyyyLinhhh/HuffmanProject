package Hw6_22001626_PhamGiaNguyen.Hw6_22001626_PhamGiaNguyen.ex3;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DrawLineChart extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Thời gian chạy của các thuật toán");
        StackPane pane = new StackPane();
        pane.getChildren().add(createChart2(putData()));
        stage.setScene(new Scene(pane, 1550, 750));
        stage.show();
    }

    public double[][] putData() {
        double[][] dataMap = new double[770][2];
        DataSet dataSet = new DataSet();
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (i == 0) {
                dataSet.setSorter(new BubbleSort());
                double[][] matrix = dataSet.runtimeStatistics();
                for (int j = 0; j < matrix.length; j++) {
                    dataMap[count][0] = matrix[j][0];
                    dataMap[count][1] = matrix[j][1];
                    count++;
                }
            } else if (i == 1) {
                dataSet.setSorter(new BubbleSort2());
                double[][] matrix = dataSet.runtimeStatistics();
                for (int j = 0; j < matrix.length; j++) {
                    dataMap[count][0] = matrix[j][0];
                    dataMap[count][1] = matrix[j][1];
                    count++;
                }
            } else if (i == 3) {
                dataSet.setSorter(new InsertionSort());
                double[][] matrix = dataSet.runtimeStatistics();
                for (int j = 0; j < matrix.length; j++) {
                    dataMap[count][0] = matrix[j][0];
                    dataMap[count][1] = matrix[j][1];
                    count++;
                }
            } else if (i == 4) {
                dataSet.setSorter(new SelectionSort());
                double[][] matrix = dataSet.runtimeStatistics();
                for (int j = 0; j < matrix.length; j++) {
                    dataMap[count][0] = matrix[j][0];
                    dataMap[count][1] = matrix[j][1];
                    count++;
                }
            } else if (i == 5) {
                dataSet.setSorter(new MergeSort());
                double[][] matrix = dataSet.runtimeStatistics();
                for (int j = 0; j < matrix.length; j++) {
                    dataMap[count][0] = matrix[j][0];
                    dataMap[count][1] = matrix[j][1];
                    count++;
                }
            } else if (i == 6) {
                dataSet.setSorter(new HeapSort());
                double[][] matrix = dataSet.runtimeStatistics();
                for (int j = 0; j < matrix.length; j++) {
                    dataMap[count][0] = matrix[j][0];
                    dataMap[count][1] = matrix[j][1];
                    count++;
                }
            }
            else if (i == 7) {
                dataSet.setSorter(new QuickSort());
                double[][] matrix = dataSet.runtimeStatistics();
                for (int j = 0; j < matrix.length; j++) {
                    dataMap[count][0] = matrix[j][0];
                    dataMap[count][1] = matrix[j][1];
                    count++;
                }
            }
        }
        return dataMap;
    }

    public Node createChart2(double[][] dataMap) {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Time");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Number of elements");

        XYChart.Series dataSeries = new XYChart.Series();
        dataSeries.setName("BubbleSort");
        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("BubbleSort2");
        XYChart.Series dataSeries2 = new XYChart.Series();
        dataSeries2.setName("InsertionSort");
        XYChart.Series dataSeries3 = new XYChart.Series();
        dataSeries3.setName("SelectionSort");
        XYChart.Series dataSeries4 = new XYChart.Series();
        dataSeries4.setName("MergeSort");
        XYChart.Series dataSeries5 = new XYChart.Series();
        dataSeries5.setName("HeapSort");
        XYChart.Series dataSeries6 = new XYChart.Series();
        dataSeries6.setName("QuickSort");
        for (int i = 0; i < dataMap.length; i++) {
            if (i >= 0 && i < 110) {
                dataSeries.getData().add(new XYChart.Data(dataMap[i][0], dataMap[i][1]));
            } else if (i >= 110 && i < 220) {
                dataSeries1.getData().add(new XYChart.Data(dataMap[i][0], dataMap[i][1]));
            } else if (i >= 220 && i < 330) {
                dataSeries2.getData().add(new XYChart.Data(dataMap[i][0], dataMap[i][1]));
            } else if (i >= 330 && i < 440) {
                dataSeries3.getData().add(new XYChart.Data(dataMap[i][0], dataMap[i][1]));
            } else if (i >= 440 && i < 550) {
                dataSeries4.getData().add(new XYChart.Data(dataMap[i][0], dataMap[i][1]));
            } else if (i >= 550 && i < 660) {
                dataSeries5.getData().add(new XYChart.Data(dataMap[i][0], dataMap[i][1]));
            } else if (i >= 660 && i < 770) {
                dataSeries6.getData().add(new XYChart.Data(dataMap[i][0], dataMap[i][1]));
            }
        }
        LineChart chart = new LineChart(xAxis, yAxis);
        chart.getData().addAll(dataSeries, dataSeries1, dataSeries2, dataSeries3, dataSeries4, dataSeries5, dataSeries6);
        chart.setTitle("Compare running times of algorithms");
        return chart;
    }

}