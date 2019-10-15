package coding.practice;

// Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
// route between two nodes.

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RouteBetweenNodes {

    private static class Node {

        String name;
        Set<Node> children = new HashSet<>();
        boolean visited;

        Node(String n) {
            name = n;
        }
    }

    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node f = new Node("F");
        Node k = new Node("K");

        a.children.add(f);
        a.children.add(b);

        b.children.add(d);
        b.children.add(c);

        d.children.add(f);

        c.children.add(k);

        System.out.println(routeExists(b, a));
    }

    private static boolean routeExists(Node src, Node dst) {
        Queue<Node> queue = new LinkedList<>();
        ((LinkedList<Node>) queue).push(src);
        do {
            Node current = ((LinkedList<Node>) queue).pop();
            current.visited = true;
            if (current.children.contains(dst)) {
                return true;
            } else {
                for (Node n : current.children) {
                    if (!n.visited) {
                        ((LinkedList<Node>) queue).push(n);
                    }
                }
            }
        } while (!queue.isEmpty());

        return false;
    }
}
