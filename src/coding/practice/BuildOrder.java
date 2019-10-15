package coding.practice;

// Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
//    projects, where the second project is dependent on the first project). All of a project's dependencies
//    must be built before the project is. Find a build order that will allow the projects to be built. If there
//    is no valid build order, return an error.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuildOrder {

    private static class Node {

        String name;
        boolean visited;
        Set<Node> dependencies = new HashSet<>();

        Node(String n) {
            name = n;
        }
    }

    private static void projectOrderArray(Node[] projects) {
        if (projects == null || projects.length == 0) {
            return;
        }
        List<Node> output = new ArrayList<>();
        int currentSize = output.size();
        while (output.size() < projects.length) {
            for (Node project : projects) {
                boolean check = true;
                if (!project.visited) {
                    for (Node depend : project.dependencies) {
                        if (!depend.visited) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        project.visited = true;
                        output.add(project);
                    }
                }
            }
            if (currentSize == output.size()) {
                System.out.println("Error");
                return;
            }
        }
        printList(output);
    }

    private static void projectOrderList(Set<Node> projectsList) {
        List<Node> output = new ArrayList<>();
        while (!projectsList.isEmpty()) {
            Set<Node> removes = new HashSet<>();
            for (Node node : projectsList) {
                boolean check = true;
                for (Node dep : node.dependencies) {
                    if (projectsList.contains(dep)) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    output.add(node);
                    removes.add(node);
                }
            }
            if(removes.isEmpty()){
                System.out.println("Error");
                return;
            }
            for(Node remove: removes){
                projectsList.remove(remove);
            }
        }
        printList(output);
    }

    private static void printList(List<Node> output) {
        for (Node out : output) {
            System.out.print(out.name + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");

        a.dependencies.add(f);

        b.dependencies.add(f);

        c.dependencies.add(d);

        d.dependencies.add(b);
        d.dependencies.add(a);
        f.dependencies.add(e);
//        e.dependencies.add(f);
        
        Node[] projects = new Node[]{a, b, c, d, e, f};
        projectOrderArray(projects);

        Set<Node> projectsList = new HashSet<>();
        projectsList.add(a);
        projectsList.add(b);
        projectsList.add(c);
        projectsList.add(d);
        projectsList.add(e);
        projectsList.add(f);

        projectOrderList(projectsList);
    }
}
