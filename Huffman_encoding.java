/*
*   Theory -> https://www.youtube.com/watch?v=uDS8AkTAcIU&ab_channel=GateSmashers
*/  

import java.util.*;

public class Huffman_encoding {

    static class Node {
        char data;
        int freq;
        Node left, right;

        Node(char data, int freq) {
            this.data = data;
            this.freq = freq;
            left = right = null;
        }
    }

    static class HuffmanComparator implements Comparator<Node> {
        public int compare(Node node1, Node node2) {
            return node1.freq - node2.freq;
        }
    }

    static void printCodes(Node root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.data)) {
            System.out.println(root.data + " : " + s);
            return;
        }

        printCodes(root.left, s + "0");
        printCodes(root.right, s + "1");
    }

    static Node buildHuffmanTree(List<Node> nodes) {
        PriorityQueue<Node> q = new PriorityQueue<>(nodes.size(), new HuffmanComparator());
        q.addAll(nodes);

        assert q.size() > 0;

        while (q.size() != 1) {
            Node x = q.poll();
            Node y = q.poll();

            Node f = new Node('\0', x.freq + y.freq);
            f.left = x;
            f.right = y;

            q.add(f);
        }

        return q.poll();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Node> nodes = new ArrayList<>();

        System.out.println("Enter the number of characters: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < n; i++) {
            System.out.println("Enter character " + ( i + 1) +": ");
            char character = scanner.next().charAt(0);

            System.out.println("Enter frequency for " + character + ": ");
            int frequency = scanner.nextInt();

            nodes.add(new Node(character, frequency));
        }

        Node root = buildHuffmanTree(nodes);

        System.out.println("Huffman Codes are:");
        printCodes(root, "");
    }
}
