package graphs;

import java.util.*;

public class GraphBFS {

    public static void process(GraphNode node) {
        System.out.println("Processing node: "+node);
    }

    public static void bfs(GraphNode start){
        Set<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()){
            GraphNode current = queue.poll();
            process(current);
            for (GraphNode neighbor: current.neighbors){
                if(!visited.contains(current)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}
