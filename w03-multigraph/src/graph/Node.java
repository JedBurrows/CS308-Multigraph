package graph;

import java.util.ArrayList;
import java.util.List;

public class Node implements INode, Comparable<INode> {
    private int id;
    private String name;

    private static List<Node> nodeList = new ArrayList<>();

    private Node(int id) {
        this(id, "");
    }

    private Node(int id, String name) {

        this.id = id;
        this.name = name;
    }

    public static Node getInstance(int id) {
        return getInstance(id, "");
    }


    public static Node getInstance(int id, String label) {

        if (nodeList.contains(new Node(id))) {

            for (Node node : nodeList) {
                if (node.getId() == id) {
                    return node;
                }
            }
        }

        Node node = new Node(id, label);
        nodeList.add(node);

        return node;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this || obj instanceof Node && this.id == ((Node) obj).id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    @Override
    public int compareTo(INode node) {
        return this.equals(node) ? 0 : -1;
    }
}
