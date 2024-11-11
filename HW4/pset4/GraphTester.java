package fall24ee360t.pset4;

import static org.junit.Assert.*;
import java.util.TreeSet;
import java.util.Set;
import org.junit.Test;

public class GraphTester {
    // tests for method "addEdge" in class "Graph"
    @Test public void testAddEdge0() {
        Graph g = new Graph(2);
        g.addEdge(0, 1);
        System.out.println(g);
        assertEquals(g.toString(), "numNodes: 2\nedges: [[false, true], [false, false]]");
    }

    // your tests for method "addEdge" in class "Graph" go here

    // provide at least 4 test methods such that together they provide full statement
    //   coverage of your implementation of addEdge and any helper methods;
    // each test method has at least 1 invocation of addEdge;
    // each test method creates exactly 1 graph
    // each test method creates a unique graph w.r.t. "equals" method
    // each test method has at least 1 test assertion;
    // each test assertion correctly characterizes expected behavior with respect to the spec;

    @Test public void testAddEdge1() {
        Graph g = new Graph(3);
        g.addEdge(0, 1);
        assertEquals(g.toString(), "numNodes: 3\nedges: [[false, true, false], [false, false, false], [false, false, false]]");
    }

    @Test public void testAddEdge2() {
        Graph g = new Graph(3);
        g.addEdge(0, 2);
        g.addEdge(0, 1);
        assertEquals(g.toString(), "numNodes: 3\nedges: [[false, true, true], [false, false, false], [false, false, false]]");
    }

    @Test public void testAddEdge3() {
        Graph g = new Graph(4);
        g.addEdge(1, 2);
        g.addEdge(0, 1);
        g.addEdge(2, 3);
        assertEquals(g.toString(), "numNodes: 4\nedges: [[false, true, false, false], [false, false, true, false], [false, false, false, true], [false, false, false, false]]");
    }

    @Test public void testAddEdge4() {
        Graph g = new Graph(3);
        assertThrows(IllegalArgumentException.class, () -> g.addEdge(4, 1));
    }
    // tests for method "reachable" in class "Graph"

    @Test public void testReachable0() {
        Graph g = new Graph(1);
        Set<Integer> nodes = new TreeSet<Integer>();
        nodes.add(0);
        assertTrue(g.reachable(nodes, nodes));
    }

    // your tests for method "reachable" in class "Graph" go here

    // provide at least 6 test methods such that together they provide full statement
    //   coverage of your implementation of reachable and any helper methods;
    // each test method has at least 1 invocation of reachable;
    // each test method has at least 1 test assertion;
    // at least 2 test methods have at least 1 invocation of addEdge;

    //null for sources and targets
    @Test public void testReachable1() {
        Graph graph = new Graph(5);
        Set<Integer> sources = null;
        Set<Integer> targets = null;
        assertThrows(IllegalArgumentException.class, () -> graph.reachable(sources, targets));
    }

    // Test with out-of-bounds sources
    @Test public void testReachable2() {
        Graph graph = new Graph(3);
        graph.addEdge(1, 2);
        graph.addEdge(0, 2);
        Set<Integer> sources = new TreeSet<>();
        Set<Integer> targets = new TreeSet<>();
        sources.add(4);
        targets.add(1);
        assertThrows(IllegalArgumentException.class, () -> graph.reachable(sources, targets));
    }

    // Test with out-of-bounds targets
    @Test public void testReachable3() {
        Graph graph = new Graph(4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        Set<Integer> sources = new TreeSet<>();
        Set<Integer> targets = new TreeSet<>();
        sources.add(1);
        targets.add(-1);
        assertThrows(IllegalArgumentException.class, () -> graph.reachable(sources, targets));
    }

    // Test where reachable returns true
    @Test public void testReachable4() {
        Graph graph = new Graph(3);
        graph.addEdge(0, 1);
        Set<Integer> sources = new TreeSet<>();
        Set<Integer> targets = new TreeSet<>();
        sources.add(0);
        targets.add(1);
        assertTrue(graph.reachable(sources, targets));
    }

    // Another test where reachable returns true
    @Test public void testReachable5() {
        Graph graph = new Graph(4);
        graph.addEdge(1, 3);
        graph.addEdge(0, 1);
        graph.addEdge(3, 2);
        Set<Integer> sources = new TreeSet<>();
        Set<Integer> targets = new TreeSet<>();
        sources.add(0);
        sources.add(3);
        targets.add(1);
        targets.add(2);
        assertTrue(graph.reachable(sources, targets));
    }

    // Test where reachable returns false
    @Test public void testReachable6() {
        Graph graph = new Graph(5);
        graph.addEdge(1, 2);
        graph.addEdge(0, 1);
        graph.addEdge(2, 3);
        Set<Integer> sources = new TreeSet<>();
        Set<Integer> targets = new TreeSet<>();
        sources.add(3);
        targets.add(0);
        assertFalse(graph.reachable(sources, targets));
    }

    // Another test where reachable returns false
    @Test public void testReachable7() {
        Graph graph = new Graph(5);
        graph.addEdge(1, 3);
        graph.addEdge(0, 1);
        graph.addEdge(3, 2);
        Set<Integer> sources = new TreeSet<>();
        Set<Integer> targets = new TreeSet<>();
        sources.add(3);
        sources.add(2);
        targets.add(2);
        targets.add(0);
        assertFalse(graph.reachable(sources, targets));
    }
}