package ee360t.pset7;

import java.util.Arrays;
import java.util.Set;

public class Graph {
    private int numNodes; // number of nodes in the graph
    private boolean[][] edges;
    // edges[i][j] is true if and only if there is an edge from node i to node j

    // class invariant: edges != null; edges is a square matrix;
    //                  numNodes >= 0; numNodes is number of rows in edges

    public Graph(int size) {
        numNodes = size;
        edges = new boolean[size][size];
    }

    @Override
    public String toString() {
        return "numNodes: " + numNodes + "; " + "edges: " + Arrays.deepToString(edges);
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != ee360t.pset7.Graph.class) return false;
        return toString().equals(o.toString());
    }

    @Override
    public int hashCode() {
        // your code goes here
        // ...

    }

    public void addEdge(int from, int to) {
        // postcondition: adds a directed edge "from" -> "to" to this graph
        edges[from][to] = true;
    }

    public int numEdges() {
        // post: returns the number of edges in this

        // your code goes here
        // ...

    }

    public boolean hasExactlyOneEdge() {
        // post: returns true if and only if there is exactly one edge in this

        // your code goes here
        // ...

    }

    public boolean isReflexive() {
        // post: returns true if this represents a reflexive relation

        // your code goes here
        // ...

    }

    public boolean isSymmetric() {
        // post: returns true if and only if this represents a symmetric relation

        // your code goes here
        // ...

    }

    public boolean isTransitive() {
        // post: returns true if and only if this represents a transitive relation

        // your code goes here
        // ...

    }

    public static void main(String[] a) {
        Graph g = new Graph(2);
        System.out.println(g);
    }
}
