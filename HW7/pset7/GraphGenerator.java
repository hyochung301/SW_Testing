package ee360t.pset7;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class GraphGenerator {
    public static Set<Graph> generateAllGraphs(int num) {
        // pre: num >= 0
        // post: returns a set of all graphs that have num nodes

        // your code goes here
        // ...

    }

    public static Set<Graph> generateAllGraphs(int num, String property) {
        // pre: num >= 0 and
        //      property is the name of a valid boolean method in class Graph
        // post: returns a set of all graphs (with num nodes) that represent binary
        //       relations with the given property

        return generateAllGraphs(num, new String[]{ property });
    }

    public static Set<Graph> generateAllGraphs(int num, String[] properties) {
        // pre: num >= 0 and
        //      each element of properties is the name of a valid boolean method in class Graph
        // post: returns a set of all graphs (with num nodes) that represent binary
        //       relations with each of the given properties

        // your code goes here
        // ...

    }

    public static void main(String[] a) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        int num = 4;
        Set<Graph> graphs = generateAllGraphs(num, new String[]{"hasExactlyOneEdge"});
        System.out.println("numGraphs: " + graphs.size());
    }
}
