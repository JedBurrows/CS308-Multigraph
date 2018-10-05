package graph;

import java.util.*;

public class Multigraph implements IMultigraph {

    private Map<INode, List<Edge>> graph;
    private int nEdges;
    private int nNodes;
    private Set<String> edgesLabels;
    private Set<INode> nodes;

    public Multigraph() {
        graph = new HashMap<>();
        edgesLabels = new TreeSet<>();
        nodes = new TreeSet<>();
    }

    @Override
    public void addEdge(int startNodeId, int endNodeId) {
        addEdge(startNodeId, endNodeId, "", "");
    }

    @Override
    public void addEdge(int startNodeId, int endNodeId, String nodeLabel, String edgeLabel) {

        Node startNode = Node.getInstance(startNodeId, nodeLabel);
        Node.getInstance(startNodeId).setName(nodeLabel);

        Node endNode = Node.getInstance(endNodeId);

        Edge edge = new Edge(startNode, endNode, edgeLabel);

        addToGraph(startNode, edge);

        // Add edge
        edgesLabels.add(edgeLabel);

        // Add node
        nodes.add(Node.getInstance(startNodeId, nodeLabel));
    }


    private void addToGraph(Node originNode, Edge edge) {
        if (!graph.containsKey(originNode)) {
            graph.put(originNode, new ArrayList<>());
            nNodes++;
        }

        List<Edge> edges = graph.get(originNode);

        if (!edges.contains(edge)) {
            edges.add(edge);
        }

        nEdges++;
    }

    @Override
    public List<IEdge> findPath(INode origin, INode destination) {

        Set<Node> checked = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        Node current;

        // STORES ALL EDGES
        List<Edge> edges = new ArrayList<>();
        // MAPS NODE TO ITS PARENT 
        Map<Node, Node> parentMap = new HashMap<>();

        checked.add((Node) origin);
        queue.add((Node) origin);

        while (!queue.isEmpty()) {
            //System.out.println("QUEUE " + queue);

            current = queue.remove();

            if (current.equals(destination)) {
                break;
            }

            List<Edge> adjacentEdges = getAdjacentEdges(current);

            // loop through adjacent edgesLabels of the current node
            for (Edge edge : adjacentEdges) {
                Node node = (edge.getStart().equals(current)) ? edge.getFinish() : edge.getStart();

                edges.add(edge);

                // System.out.println("~Adjacent node of " + current + " is " + node);

                if (!checked.contains(node)) {
                    checked.add(node);
                    queue.add(node);
                    parentMap.put(node, current);
                }

                if (node.equals(destination)) {
                    current = (Node) destination;
//                    System.out.println("FOUND " + current);
                    return traverseUp(edges, parentMap, current, (Node) origin);
                }

            }
        }

        return null;
    }

    /**
     * Traverses up the tree to the root node
     *
     * @param edges
     * @param parentMap
     * @param destination
     * @param origin
     * @return
     */
    private List<IEdge> traverseUp(List<Edge> edges, Map<Node, Node> parentMap, Node destination, Node origin) {
        List<IEdge> path = new ArrayList<>();

        nodes.add(destination);

        Node parent;
        Node current = destination;

        while (!current.equals(origin)) {
            parent = parentMap.get(current);
            Edge edge = new Edge(current, parent);
            current = parent;

            for (Edge e : edges) {
                if (e.equals(edge) && e.getStart().equals(current)) {
                    path.add(e);
                }
            }
        }

        Collections.reverse(path);
        return path;
    }

    @Override
    public INode findNodeById(int id) {
        for (INode node : nodes) {
            if (node.getId() == id) {
                return node;
            }
        }

        return null;
    }

    public List<Edge> getAdjacentEdges(Node node) {
        return (graph.get(node) == null) ? new ArrayList<>() : graph.get(node);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<INode, List<Edge>> entry : graph.entrySet()) {
            sb.append("Node: ");
            sb.append(entry.getKey());
            sb.append("\n");
            sb.append(entry.getValue());
        }

        return sb.toString();
    }

    @Override
    public Set<String> getEdgesLabels() {
        return edgesLabels;
    }

    @Override
    public Set<INode> getNodes() {
        return new HashSet<>(nodes);
    }

    @Override
    public int getNoEdges() {
        return nEdges;
    }

    @Override
    public int getNoNodes() {
        return nNodes;
    }
}
