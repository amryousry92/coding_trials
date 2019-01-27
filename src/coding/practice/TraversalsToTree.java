package coding.practice;

import java.util.HashMap;
import java.util.Map;

public class TraversalsToTree {

    static class Node {

        char data;
        Node left, right;

        Node(char item) {
            data = item;
            left = right = null;
        }
    }

    private static int preIndex = 1;

    private static Node buildeTree(Map<Integer, Character> preOrder, Map<Character, Integer> inOrder,
        int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        char currentChar = preOrder.get(preIndex++);
        Node node = new Node(currentChar);
        if (inStart == inEnd) {
            return node;
        }
        node.left = buildeTree(preOrder, inOrder, inStart, inOrder.get(currentChar) - 1);
        node.right = buildeTree(preOrder, inOrder, inOrder.get(currentChar) + 1, inEnd);

        return node;
    }

    private static void inOrderTraversal(Node root) {
        if(root == null){
            return;
        }
        if (root.left != null) {
            inOrderTraversal(root.left);
        }
        System.out.print(root.data + " ");
        if (root.right != null) {
            inOrderTraversal(root.right);
        }
    }

    private static void postOrderTraversal(Node root) {
        if(root == null){
            return;
        }
        if (root.left != null) {
            postOrderTraversal(root.left);
        }
        if (root.right != null) {
            postOrderTraversal(root.right);
        }
        System.out.print(root.data + " ");
    }

    private static void preOrderTraversal(Node root) {
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        if (root.left != null) {
            preOrderTraversal(root.left);
        }
        if (root.right != null) {
            preOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        final Map<Character, Integer> inOrder = new HashMap<>();
        inOrder.put('D', 1);
        inOrder.put('B', 2);
        inOrder.put('L', 3);
        inOrder.put('E', 4);
        inOrder.put('A', 5);
        inOrder.put('G', 6);
        inOrder.put('K', 7);
        inOrder.put('F', 8);
        inOrder.put('C', 9);

        final Map<Integer, Character> preOrder = new HashMap<>();
        preOrder.put(1, 'A');
        preOrder.put(2, 'B');
        preOrder.put(3, 'D');
        preOrder.put(4, 'E');
        preOrder.put(5, 'L');
        preOrder.put(6, 'C');
        preOrder.put(7, 'F');
        preOrder.put(8, 'G');
        preOrder.put(9, 'K');

        final Node tree = buildeTree(preOrder, inOrder, 1, 9);
        System.out.println("PreOrder: ");
        preOrderTraversal(tree);
        System.out.println();
        System.out.println("InOrder: ");
        inOrderTraversal(tree);
        System.out.println();
        System.out.println("PostOrder: ");
        postOrderTraversal(tree);
    }
}
