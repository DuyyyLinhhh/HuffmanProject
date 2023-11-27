package project.original;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffmanCoding {

    private Node root = null;
    private Map<Character, Integer> freqMap;
    private Map<Character, String> codeMap;
    private String str;

    public HuffmanCoding process(String str) {
        this.str = str;
        countFreq(str);
        this.root = buildTree(freqMap);
        this.codeMap = new HashMap<>();
        buildCode(root, "");
        return this;
    }

    public String encode() {
        if (this.codeMap == null || this.codeMap.isEmpty()) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : str.toCharArray()) {
            builder.append(codeMap.get(c));
        }
        return builder.toString();
    }

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

    public Node getRoot() {
        return root;
    }

    public void buildTree() {
        this.root = buildTree(freqMap);
    }

    private Node buildTree(Map<Character, Integer> freqMap) {
        PriorityQueue<Node> q = new PriorityQueue<>(freqMap.size(), Comparator.comparingInt(Node::getData));
        for (Map.Entry<Character, Integer> i : freqMap.entrySet())
            q.add(new Node(i.getValue(), i.getKey()));

        Node root = null;
        while (q.size() > 1) {
            Node x = q.poll();
            Node y = q.poll();
            root = new Node(x.getData() + y.getData(), x, y);
            q.add(root);
        }
        return root;
    }

    private void buildCode(Node node, String code) {
        if (node.isLeaf()) {
            codeMap.put(node.getCharacter(), code);
            return;
        }
        buildCode(node.getLeft(), code + "0");
        buildCode(node.getRight(), code + "1");
    }

    private void countFreq(String str) {
        this.freqMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            int rs = this.freqMap.getOrDefault(c, 0);
            this.freqMap.put(c, rs + 1);
        }
    }
}
