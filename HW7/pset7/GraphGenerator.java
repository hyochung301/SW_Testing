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
        Set<Graph> ret = new HashSet<>();
        long numAllGraphs = (long) Math.pow(2, num*num);

        for(long i = 0; i < numAllGraphs; i++){
            Graph graph = new Graph(num);

            String binary = Long.toBinaryString(i);
            binary = String.format("%" + num * num + "s", binary).replace(' ', '0');
            int curIndex = 0;
            for(int j = 0; j < num; j++){
                for(int k = 0; k < num; k++){
                    if(binary.charAt(curIndex) == '1') {
                        graph.addEdge(j, k);
                    }
                    curIndex ++;
                }
            }
            ret.add(graph);
        }

        return ret;

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
        Set<Graph> allGraphs = generateAllGraphs(num);
        Set<Graph> ret = new HashSet<>();

        for(Graph graph : allGraphs){
            boolean match = true;
            for(String property : properties){
                try{
                    Boolean holds = (Boolean) Graph.class.getMethod(property).invoke(graph);
                    if(!holds){
                        match = false;
                        break;
                    }
                } catch(Exception e){
                    e.printStackTrace();
                    match = false;
                    break;
                }
            }
            if(match){
                ret.add(graph);
            }
        }
        return ret;
    }

    public static void main(String[] a) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        int num = 4;
        Set<Graph> graphs = generateAllGraphs(num, new String[]{"hasExactlyOneEdge"});
        System.out.println("numGraphs: " + graphs.size());
    }
}
