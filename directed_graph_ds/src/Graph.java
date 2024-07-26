import java.util.ArrayList;
import java.util.List;

public class Graph {
    
    List<List<Integer>> graph; // The indices of the graph list will serve as the vertices

    public Graph(int numVertices) {
        this.graph = new ArrayList<>(numVertices); // Create numVertices vertices in the graph
        for (int i = 0; i < numVertices; i++) {
            this.graph.add(new ArrayList<>(numVertices-1)); // For each vertex, add placeholder for edge to other vertices 
        }
    }

    public void addEdge(int u, int v) { // Because this is an directed graph edge will be u -> v
        this.graph.get(u).add(v);
    }
    
    public void print() {
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("Vertex " + i);
            List<Integer> currentVertex = this.graph.get(i);

            for (int j = 0; j < currentVertex.size(); j++) {
                System.out.println(i + " -> " + currentVertex.get(j));
            }
        }
    }

}
