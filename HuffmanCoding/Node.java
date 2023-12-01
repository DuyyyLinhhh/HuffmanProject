package project.original;

class Node {
    private int data; // Lưu tần suất
    private char character; // Kí tự được lưu trong các nút lá
    private Node left; // Nút con trái
    private Node right; // Nút con phải

    // Constructor cho các nút lá
    public Node(int data, char character) {
        this.data = data;
        this.character = character;
        this.left = null;
        this.right = null;
    }

    // Constructor cho các nút trong
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.character = '\0'; // Các nút nội trong lưu ký tự
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public char getCharacter() {
        return character;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    // Kiểm tra xem nút có phải là nút lá không
    public boolean isLeaf() {
        return left == null && right == null && character != '\0';
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
