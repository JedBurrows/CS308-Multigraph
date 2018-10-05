package graph;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class NodeTest {

    @Test
    public void setTest() {
        Set<INode> set = new TreeSet<>();

        set.add(Node.getInstance(1, "t"));
        set.add(Node.getInstance(1, "b"));

        assertEquals(1, set.size());
    }


    @Test
    public void equalsTest() {
        Set<INode> set = new TreeSet<>();

        INode node1 = Node.getInstance(1, "");
        INode node2 = Node.getInstance(1, "");

        assertTrue(node1.equals(node2));
    }


    @Test
    public void containsTest() {
        Set<INode> set = new TreeSet<>();

        set.add(Node.getInstance(33, "t"));
        set.add(Node.getInstance(60, "b"));

        assertTrue(set.contains(Node.getInstance(33, "")));
    }


}
