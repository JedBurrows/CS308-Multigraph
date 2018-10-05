package graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EdgeTest {

    private IEdge line;
    private Node node2;
    private Node node;

    @Before
    public void setUp() throws Exception {
        node = Node.getInstance(1, "");
        node2 = Node.getInstance(10, "");

        line = new Edge(node, node2, "");
    }

    @Test
    public void equals() throws Exception {
        node = Node.getInstance(1, "");
        node2 = Node.getInstance(10, "");

        IEdge line2 = new Edge(node, node2, "");

        assertEquals("Should be equal", line, line2);
    }

}