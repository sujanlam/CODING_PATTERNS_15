package graphs;

import java.util.Set;

public class GraphDFS {

    public static void main(String[] args) {

    }

    public static void dfs(GraphNode node, Set<GraphNode> visited){
        visited.add(node);
        process(node);
        System.out.println(node.value);
        for (GraphNode neighbor: node.neighbors){
            if(!visited.contains(neighbor)){
                dfs(neighbor, visited);
            }
        }
    }

    private static void process(GraphNode node) {
        System.out.println("Processing a node. ");
    }
}
