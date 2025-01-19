package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class CheckBipartite {
    public static void main(String[] args) {
        int[][] graph = {
                {1, 2}, // Edges from node 0
                {0, 2}, // Edges from node 1
                {0, 1}  // Edges from node 2
        };

        System.out.println(isBipartite(graph) ? "Graph is Bipartite" : "Graph is not Bipartite");
    }

    private static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if(colors[i] == 0){
                if(!bfsCheck(graph, i, colors)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfsCheck(int[][] graph, int start, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 1;

        while (!queue.isEmpty()){
            int current = queue.poll();

            for(int neighbor: graph[current]){
                if(colors[neighbor] == 0){
                    colors[neighbor] = -colors[current];
                    queue.add(neighbor);
                }else if(colors[neighbor] == colors[current]){
                    return false;
                }
            }
        }
        return true;
    }
}
