package graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    int value;
    List<GraphNode> neighbors;

    GraphNode(int value){
        this.value = value;
        neighbors = new ArrayList<>();
    }
}