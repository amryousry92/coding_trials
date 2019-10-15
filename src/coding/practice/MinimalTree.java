package coding.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
//    to create a binary search tree with minimal height.
public class MinimalTree {

    private static class Node {

        int data;
        Node left;
        Node right;
    }

    private static void constructBST(int[] array) {
        Node root = constructBSTNodes(array);
        Queue<Node> queue = new LinkedList<>();
        ((LinkedList<Node>) queue).push(root);
        while (!queue.isEmpty()) {
            LinkedList<Node> current = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node node = ((LinkedList<Node>) queue).pop();
                System.out.print(node.data + " ");
                current.add(node);
            }
            for (Node n : current) {
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }
            System.out.println();
        }
    }

    private static Node constructBSTNodes(int[] array) {
        if (array != null && array.length != 0) {
            int mid = (array.length % 2 == 0) ? (array.length / 2) + 1 : array.length / 2;
            Node node = new Node();

            node.data = array[mid];
            node.left = constructBSTNodes(Arrays.copyOfRange(array, 0, mid));
            node.right = constructBSTNodes(Arrays.copyOfRange(array, mid + 1, array.length));
            return node;
        }
        return null;
    }

    public static void main(String[] args) {
        final int[] array = {1, 4, 6, 8, 55, 88, 222};
        constructBST(array);
    }

}
