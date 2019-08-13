package coding.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("Duplicates")
public class TreeReverseOrder {

    private static class Node {

        Node left;
        Node right;
        int val;

        Node(int value) {
            val = value;
        }
    }

    /*

                5
       4              6
    3      7       8       9
   1 2 | 87 21 | 12 13 | 15 16
*/

    private static void printReverse(Node node) {
        if (node != null) {
            System.out.println(node.val);
            final List<Node> list = new ArrayList<>();
            appendChildren(node, list);
            processList(list, true);
        }
    }

    private static void processList(List<Node> list, boolean flag) {
        final List<Node> list2 = new ArrayList<>();
        for (Node child : list) {
            appendChildren(child, list2);
        }
        if (flag) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).val + " ");
            }
        } else {
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.print(list.get(i).val + " ");
            }
        }
        System.out.println();
        if (!list2.isEmpty()) {
            processList(list2, !flag);
        }
    }

    private static void appendChildren(Node node, Collection<Node> children) {
        if (node != null) {
            if (node.left != null) {
                children.add(node.left);
            }
            if (node.right != null) {
                children.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node87 = new Node(87);
        Node node21 = new Node(21);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node15 = new Node(15);
        Node node16 = new Node(16);

        Node node9 = new Node(9);
        Node node8 = new Node(8);
        Node node7 = new Node(7);
        Node node3 = new Node(3);

        Node node4 = new Node(4);
        Node node6 = new Node(6);

        Node node5 = new Node(5);

        node5.left = node4;
        node5.right = node6;

        node4.left = node3;
        node4.right = node7;

        node6.left = node8;
        node6.right = node9;

        node3.left = node1;
        node3.right = node2;

        node7.left = node87;
        node7.right = node21;

        node8.left = node12;
        node8.right = node13;

        node9.left = node15;
        node9.right = node16;

        printReverse(node5);
    }
}
