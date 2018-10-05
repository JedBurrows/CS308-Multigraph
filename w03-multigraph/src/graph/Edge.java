package graph;

public class Edge implements IEdge {
    private Node startNode;
    private Node endNode;
    private String label;

    public Edge(Node startNode, Node endNode) {
        this(startNode, endNode, "");
    }

    public Edge(Node startNode, Node endNode, String label) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.label = label;
    }

    @Override
    public Node getStart() {
        return startNode;
    }

    @Override
    public void setStart(INode node) {
        startNode = (Node) node;
    }

    @Override
    public Node getFinish() {
        return endNode;
    }

    @Override
    public void setFinish(INode node) {
        endNode = (Node) node;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Edge)) {
            return false;
        }

        Edge edge = (Edge) obj;

        return (isSameNode(edge));
    }

    /*
    private boolean isSameName(Edge edge) {
        return (this.getLabel().equals(edge.getLabel()));
    }
    */


    private boolean isSameNode(Edge edge) {
        return (this.getStart().equals(edge.getStart()) && this.getFinish().equals(edge.getFinish())) ||
                (this.getStart().equals(edge.getFinish()) && this.getFinish().equals(edge.getStart()));
    }

    @Override
    public String toString() {
        return "Edge is " + label + " from " + startNode + " " + startNode.getName() + " to " + endNode + " " + endNode.getName() + "\n";
    }
}
