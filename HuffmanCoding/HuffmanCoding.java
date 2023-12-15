package project.original;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {

    private Node root = null; // Gốc của cây Huffman
    private Map<Character, Integer> freqMap; // Map tần suất của các kí tự đầu vào
    private Map<Character, String> codeMap; // Map mã Huffman của các kí tự
    private String string; // Chuỗi đầu vào cần mã hóa

    // Xử lý chuỗi đầu vào để xây dựng cây Huffman và các mã
    public HuffmanCoding process(String str) {
        this.string = str;
        countFreq(str);
        this.root = buildTree(freqMap);
        this.codeMap = new HashMap<>();
        generateHuffmanCodes(root, "");
        return this;
    }

    // Mã hóa chuỗi đầu vào bằng cách sử dụng các mã Huffman đã tạo
    public String encode() {
        if (this.codeMap == null || this.codeMap.isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : string.toCharArray()) {
            stringBuilder.append(codeMap.get(ch));
        }
        return stringBuilder.toString();
    }

    // Giải mã chuỗi đã được mã hóa sử dụng cây Huffman đã cho
    public String decode(String encodedStr, Node treeRoot) {
        if (treeRoot == null || encodedStr == null || encodedStr.isEmpty()) {
            return null;
        }

        StringBuilder decoded = new StringBuilder();
        Node current = treeRoot;

        for (int i = 0; i < encodedStr.length(); i++) {
            char bit = encodedStr.charAt(i);
            if (bit == '0') {
                current = current.getLeft();
            } else if (bit == '1') {
                current = current.getRight();
            }
            if (current.isLeaf()) {
                decoded.append(current.getCharacter());
                current = treeRoot;
            }
        }

        return decoded.toString();
    }

    // Phương thức getter cho gốc của cây Huffman
    public Node getRoot() {
        return root;
    }

    // Xây dựng cây Huffman
    public void buildTree() {
        this.root = buildTree(freqMap);
    }

    // Phương thức riêng để xây dựng cây Huffman sử dụng hàng đợi ưu tiên
    private Node buildTree(Map<Character, Integer> freqMap) {
        // Hàng đợi ưu tiên để lưu trữ nút dựa trên tần suất của chúng
        PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<>(Comparator.comparingInt(Node::getData));
        // Tạo các nút lá cho mỗi ký tự và thêm chúng vào hàng đợi ưu tiên
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet())
            nodePriorityQueue.add(new Node(entry.getValue(), entry.getKey()));
        Node root = null;

        // Khi chỉ có một kí tự, tạo một nút lá với kí tự đó
        if (nodePriorityQueue.size() == 1) {
            Map.Entry<Character, Integer> entry = freqMap.entrySet().iterator().next();
            root = new Node(entry.getValue(), entry.getKey());
            root.setLeft(new Node(entry.getValue(), entry.getKey()));  // Tạo một nút lá mới
            return root;
        }
        // Xây dựng cây Huffman bằng cách kết hợp các nút có tần suất thấp nhất
        while (nodePriorityQueue.size() > 1) {
            Node x = nodePriorityQueue.poll();
            Node y = nodePriorityQueue.poll();
            root = new Node(x.getData() + y.getData(), x, y);
            nodePriorityQueue.add(root);
        }

        return root;
    }

    // Đệ quy xây dựng các mã Huffman cho mỗi ký tự trong cây
    private void generateHuffmanCodes(Node node, String code) {
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            codeMap.put(node.getCharacter(), code);
            return;
        }
        if (node.getLeft() != null) {
            generateHuffmanCodes(node.getLeft(), code + "0");
        }
        if (node.getRight() != null) {
            generateHuffmanCodes(node.getRight(), code + "1");
        }
    }

    // Đếm tần suất của mỗi ký tự trong chuỗi đầu vào
    private void countFreq(String str) {
        this.freqMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            this.freqMap.put(ch, this.freqMap.getOrDefault(ch, 0) + 1);
        }
    }

}
