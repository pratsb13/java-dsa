import java.util.ArrayList;
import java.util.List;

public class Graph {
    
    List<List<Edge>> graph; // The indices of the graph list will serve as the vertices

    public Graph(int numVertices) {
        this.graph = new ArrayList<>(numVertices); // Create numVertices vertices in the graph
        for (int i = 0; i < numVertices; i++) {
            this.graph.add(new ArrayList<>(numVertices-1)); // For each vertex, add placeholder for edge to other vertices 
        }
    }

    public void addEdge(int u, int v, int w) { // Because this is an undirected graph edge vertices u and v will be connected to each other
        this.graph.get(u).add(new Edge(v, w));
        this.graph.get(v).add(new Edge(u, w));
    }
    
    public void print() {
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("Vertex " + i);
            List<Edge> currentVertex = this.graph.get(i);

            for (Edge edge:currentVertex) {
                System.out.println(i + " -> " + edge.vertex + " (Weight: " + edge.weight + ")");
            }
        }
    }

}
