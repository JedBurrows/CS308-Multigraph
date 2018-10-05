package graph;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MultigraphTest {

    @Test
    public void findPathById() throws Exception {
        IMultigraph graph;
        graph = new Multigraph();
        graph.addEdge(1, 2, "Test", "node1");
        graph.addEdge(2, 3, "Test", "node2");

        INode node = Node.getInstance(1, "");
        INode node3 = Node.getInstance(3, "");
        List<IEdge> list = graph.findPath(node, node3);

        assertEquals("There must be 2 edges", 2, list.size());
    }

    @Test
    public void getNoEdges() throws Exception {
        IMultigraph graph = new Multigraph();
        graph.addEdge(1, 2, "Test", "node1");
        graph.addEdge(2, 3, "Test", "node2");

        assertEquals("There must be 2 edges", 2, graph.getNoNodes());
    }

    @Test
    public void getNoNodes() throws Exception {
        IMultigraph graph = new Multigraph();
        graph.addEdge(1, 2, "Test", "node1");
        graph.addEdge(2, 3, "Test", "node2");

        assertEquals("There must be 3 nodes ", 3, graph.getNoNodes());
    }

}