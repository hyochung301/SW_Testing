package fall24ee360t.pset4;

import java.util.Arrays;
import java.util.LinkedList;
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
        return "numNodes: " + numNodes + "\n" + "edges: " + Arrays.deepToString(edges);
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != Graph.class) return false;
        return toString().equals(o.toString());
    }

    public void addEdge(int from, int to) {
        // postcondition: adds a directed edge "from" -> "to" to this graph
        if(from >= 0 && from < numNodes && to >= 0 && to < numNodes){
            edges[from][to] = true;
        }
        else{
            throw new IllegalArgumentException();
        }

    }

    public boolean reachable(Set<Integer> sources, Set<Integer> targets) {
        if (sources == null || targets == null) throw new IllegalArgumentException();

        // postcondition: returns true if (1) "sources" does not contain an illegal node,
        //                        (2) "targets" does not contain an illegal node, and
        //                        (3) for each node "m" in set "targets", there is some
        //                        node "n" in set "sources" such that there is a directed
        //                        path that starts at "n" and ends at "m" in "this"; and
        //                        false otherwise

        for(int source : sources){
            if(!(source >= 0 && source < numNodes)) throw new IllegalArgumentException();
        }
        for(int target : targets){
            if(!(target >= 0 && target < numNodes)) throw new IllegalArgumentException();
        }

        for(int target : targets){
            boolean path = false; //any path from one -> target[i]
            for(int source : sources){
                if(bfs(source, target)){
                    path = true;
                    break;
                }
            }
            if(!path) return false; //if none reach target[i]
        }

        return true;
    }

    public boolean bfs(int source, int target){
        boolean[] visited = new boolean[numNodes];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;

        while(!queue.isEmpty()){
            int current_Node = queue.poll();
            if(current_Node == target) return true;

            for(int i = 0; i < numNodes; i++){
                boolean pathToNode = edges[current_Node][i];
                if(pathToNode && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }

        }
        return false;
    }
}

