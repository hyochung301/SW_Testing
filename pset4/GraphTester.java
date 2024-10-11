package fall23ee360t.pset4;

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

    // ...

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

    // ...

}
