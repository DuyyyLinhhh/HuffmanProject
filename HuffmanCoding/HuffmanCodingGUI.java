package project.original;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class HuffmanCodingGUI extends Application {
    private Stage primaryStage;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Khởi tạo giao diện chính
        primaryStage.setTitle("Chương trình nén dữ liệu");
        // Thêm nhãn tiêu đề
        Label titleLabel = new Label("\t\t\t\t\tHuffman Coding");
        titleLabel.getStyleClass().add("title-label"); // Thêm CSS class để tùy chỉnh kiểu dáng

        HBox inputBox = new HBox(10); // 10 là khoảng cách giữa các thành phần
        Label labelInput = new Label("Input Encode String:");
        labelInput.getStyleClass().add("codinh-label"); // Thêm CSS class để tùy chỉnh kiểu dáng
        TextField inputTextField = new TextField();
        inputTextField.getStyleClass().add("input-label");

        inputBox.getChildren().addAll(labelInput, inputTextField);

        Button encodeButton = new Button("Encode");

        Button showTreeButton = new Button("Show Tree");

        Button readFromFileButton = new Button("Read from File");

        Label resultLabel = new Label("Encoded Result:");

        resultLabel.getStyleClass().add("codinh-label");// Thêm CSS class để tùy chỉnh kiểu dán

        Canvas canvas = new Canvas(1800, 800);
        GraphicsContext gc = canvas.getGraphicsContext2D();


        Label decodedLabel = new Label("Decoded Result:");
        decodedLabel.getStyleClass().add("codinh-label");// Thêm CSS class để tùy chỉnh kiểu dán

        HBox buttonLayout = new HBox(10);
        buttonLayout.getChildren().addAll(encodeButton, showTreeButton);
        TextField decodeTextField = new TextField();
        decodeTextField.getStyleClass().add("input-label");
        Button decodeInputButton = new Button("Decode");

        HBox decodeBox = new HBox(10);
        Label labelDecode = new Label("Input Decode String:");
        labelDecode.getStyleClass().add("codinh-label");
        decodeBox.getChildren().addAll(labelDecode, decodeTextField, decodeInputButton);


        // Đặt lề cho các phần tử chính
        Insets elementInsets = new Insets(0, 0, 0, 50);
        titleLabel.setPadding(elementInsets);
        labelInput.setPadding(elementInsets);
        buttonLayout.setPadding(elementInsets);
        resultLabel.setPadding(elementInsets);
        decodedLabel.setPadding(elementInsets);


        // Thêm CSS cho các nút và layout
        encodeButton.getStyleClass().add("button-styling");
        showTreeButton.getStyleClass().add("button-styling");
        readFromFileButton.getStyleClass().add("button-styling");

        HuffmanCoding huffmanCoding = new HuffmanCoding();
        // Biến để kiểm soát hiển thị cây và kết quả encode/decode
        final boolean[] treeVisible = {false};
        final boolean[] isEncodeResultVisible = {false};
        final boolean[] isDecodeResultVisible = {false};

        // Xử lý sự kiện khi nhấn nút "Encode"
        encodeButton.setOnAction(event -> {
            String inputStr = inputTextField.getText();
            try {
                huffmanCoding.process(inputStr);
                String encodedResult = huffmanCoding.encode();
                encodedResult = insertNewline(encodedResult, 200);

                if (!isEncodeResultVisible[0]) {
                    resultLabel.setText("Encoded Result:\n" + encodedResult);
                    isEncodeResultVisible[0] = true;
                    // Ghi kết quả encode vào file
                    writeToFile(encodedResult, "output_encode.txt");
                } else {
                    resultLabel.setText("Encoded Result: ");
                    isEncodeResultVisible[0] = false;
                }

            } catch (Exception e) {
                Platform.runLater(() -> resultLabel.setText("An error occurred: " + e.getMessage()));
            }
        });

        // Xử lý sự kiện khi nhấn nút "Show Tree"
        showTreeButton.setOnAction(event -> {
            try {

                if (!treeVisible[0]) {
                    huffmanCoding.buildTree();
                    Node root = huffmanCoding.getRoot();

                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    drawHuffmanTree(root, gc, canvas.getWidth() / 3, 0, 300, 70);

                    treeVisible[0] = true;
                } else {
                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    treeVisible[0] = false;
                }
            } catch (Exception e) {
                Platform.runLater(() -> resultLabel.setText("An error occurred: " + e.getMessage()));
            }
        });
        // Thêm nút "Read from File" cho "input string"
        Button readInputStringFromFileButton = new Button("Read from File");
        inputBox.getChildren().add(readInputStringFromFileButton);

        readInputStringFromFileButton.getStyleClass().add("button-styling");

        readInputStringFromFileButton.setOnAction(event -> {
            String content = readContentFromFile();
            if (content != null) {
                inputTextField.setText(content);
            }
        });

        // Thêm nút "Read from File" cho "input decode string"
        Button readDecodeStringFromFileButton = new Button("Read from File");
        decodeBox.getChildren().add(readDecodeStringFromFileButton);

        readDecodeStringFromFileButton.getStyleClass().add("button-styling");

        readDecodeStringFromFileButton.setOnAction(event -> {
            String content = readContentFromFile();
            if (content != null) {
                decodeTextField.setText(content);
            }
        });

        VBox decodeLayout = new VBox(10);
        decodeLayout.getChildren().addAll(decodeInputButton);
        decodeLayout.setPadding(elementInsets);

        decodeInputButton.getStyleClass().add("button-styling");

        // Xử lý sự kiện khi nhấn nút "Decode"
        decodeInputButton.setOnAction(event -> {
            String decodeInput = decodeTextField.getText();
            try {
                String decodedResult = huffmanCoding.decode(decodeInput, huffmanCoding.getRoot());
                decodedResult = insertNewline(decodedResult, 200);

                if (!isDecodeResultVisible[0]) {
                    decodedLabel.setText("Decoded Result:\n" + decodedResult);
                    isDecodeResultVisible[0] = true;
                    // Ghi kết quả decode vào file
                    writeToFile(decodedResult, "output_decode.txt");
                } else {
                    decodedLabel.setText("Decoded Result: ");
                    isDecodeResultVisible[0] = false;
                }
            } catch (Exception e) {
                Platform.runLater(() -> decodedLabel.setText("An error occurred: " + e.getMessage()));
            }
        });
        VBox layout = new VBox(13);
        layout.getChildren().addAll(titleLabel, inputBox, buttonLayout, resultLabel, decodeBox, decodeLayout, decodedLabel, canvas);
        layout.setId("layout-container");
        // Wrap the layout in a ScrollPane
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(layout);

        Scene scene = new Scene(scrollPane, 1525, 800);
        // Thêm CSS cho Scene
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Hàm vẽ cây Huffman trên canvas
    private void drawHuffmanTree(Node node, GraphicsContext gc, double x, double y, double hSpacing, double vSpacing) {
        if (node != null) {
            double circleRadius = 20;
            double circleDiameter = circleRadius * 2;

            if (node.getLeft() != null) {
                double leftX = x - hSpacing;
                double leftY = y + vSpacing;
                drawLine(gc, x, y + circleDiameter, leftX, leftY);
                drawHuffmanTree(node.getLeft(), gc, leftX, leftY, hSpacing / 2, vSpacing);
            }

            if (node.getRight() != null) {
                double rightX = x + hSpacing;
                double rightY = y + vSpacing;
                drawLine(gc, x, y + circleDiameter, rightX, rightY);
                drawHuffmanTree(node.getRight(), gc, rightX, rightY, hSpacing / 2, vSpacing);
            }

            // Nếu node có chứa kí tự, hoặc là dấu cách (' ')
            if (node.isLeaf() && node.getCharacter() != '\0') {
                // Vẽ hình tròn (node) với màu nền vàng
                gc.setFill(javafx.scene.paint.Color.YELLOW);
                gc.fillOval(x - circleRadius, y, circleDiameter, circleDiameter);

                // Vẽ đường viền đen cho hình tròn
                gc.setStroke(javafx.scene.paint.Color.BLACK);
                gc.strokeOval(x - circleRadius, y, circleDiameter, circleDiameter);

                // Vẽ giá trị của node với dấu "_"
                gc.setFill(javafx.scene.paint.Color.BLACK);
                gc.fillText((node.getCharacter() == ' ' ? "_" : String.valueOf(node.getCharacter())) + ":" + node.getData(), x - 5, y + circleRadius);
            } else {
                // Nếu không chứa kí tự, vẽ giá trị của node thông thường
                gc.setStroke(javafx.scene.paint.Color.BLACK);
                gc.strokeOval(x - circleRadius, y, circleDiameter, circleDiameter);

                // Vẽ giá trị của node không có dấu "-"
                gc.setFill(javafx.scene.paint.Color.BLACK);
                gc.strokeText(String.valueOf(node.getData()), x - 5, y + circleRadius);
            }
        }
    }

    // Hàm chèn dòng mới vào chuỗi theo độ dài kí tự
    private String insertNewline(String input, int interval) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (char c : input.toCharArray()) {
            result.append(c);
            count++;
            if (count == interval) {
                result.append('\n');
                count = 0;
            }
        }
        return result.toString();
    }

    // Hàm vẽ mũi tên chỉ nối trong cây
    private void drawLine(GraphicsContext gc, double x1, double y1, double x2, double y2) {
        double arrowSize = 10;

        // Vẽ đường thẳng
        gc.strokeLine(x1, y1, x2, y2);

        // Tính toán hướng của mũi tên
        double angle = Math.atan2(y2 - y1, x2 - x1);

        // Vẽ mũi tên
        gc.strokeLine(x2, y2, x2 - arrowSize * Math.cos(angle - Math.toRadians(30)), y2 - arrowSize * Math.sin(angle - Math.toRadians(30)));
        gc.strokeLine(x2, y2, x2 - arrowSize * Math.cos(angle + Math.toRadians(30)), y2 - arrowSize * Math.sin(angle + Math.toRadians(30)));
    }

    // Hàm ghi nội dung vào file
    private void writeToFile(String content, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(content);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm đọc nội dung từ file
    private String readContentFromFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        if (selectedFile != null) {
            try {
                StringBuilder content = new StringBuilder();
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));

                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }

                reader.close();
                return content.toString().trim();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

