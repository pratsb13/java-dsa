import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {
    
    List<List<Edge>> graph; // The indices of the graph list will serve as the vertices
    int numVertices;

    public Graph(int numVertices) {
        this.graph = new ArrayList<>(numVertices); // Create numVertices vertices in the graph
        this.numVertices = numVertices;
        for (int i = 0; i < numVertices; i++) {
            this.graph.add(new ArrayList<>(numVertices-1)); // For each vertex, add placeholder for edge to other vertices 
        }
    }

    public void addEdge(int u, int v, int c) { 
        // Because this is an undirected graph edge vertices u and v will be connected to each other
        this.graph.get(u).add(new Edge(v, c));
        this.graph.get(v).add(new Edge(u, c));
    }
    
    public void print() {
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("Vertex " + i);
            List<Edge> currentVertex = this.graph.get(i);

            for (Edge edge:currentVertex) {
                System.out.println(i + " -> " + edge.vertex + " (Cost: " + edge.cost + ")");
            }
        }
    }

    
    /**
     * DIJKSTRA's ALGO
     * Calculates the shortest path from the startingVertex
     * by traversing through the connected edges of least cost.
     */
    public void shortestPath(int startingVertex) {
        // Priority queue of edges in ascending order of cost
        PriorityQueue<Edge> edgeQ = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost)); 
        /**
         * startingVertex is the initial vertex, there is no edge pointing to it,
         * so a new Edge is created.
         */
        edgeQ.add(new Edge(startingVertex, 0)); // Edge to the starting vertex would cost 0

        /**
         * Array of costs where indices represent vertices of graph and value at an index
         * is the cost of traversing to the corresponding vertex from startingVertex.
         * When this array is referred, it would always mean the cost of traversing from startingVertex.
         */
        int[] costs = new int[this.numVertices];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[startingVertex] = 0; // Cost of traversing to the same vertex is 0

        while(!edgeQ.isEmpty()) {
            Edge currentEdge = edgeQ.poll();
            int currentVertex = currentEdge.vertex;

            // For all edges from currentVertex
            for (Edge connectedEdge : this.graph.get(currentVertex)) {
                int connectedVertex = connectedEdge.vertex;
                int connectedEdgeCost = connectedEdge.cost; // Cost of edge conneting currentVertex and connectedVertex. This does not consider a path connecting more than 2 vertices.

                /**
                 * The cost of connectedVertex could be initialized to max value or 
                 * evaluated to a higher cost value in previous iteration with another edge path (from startingVertex)
                 * then the path with lower cost is selected.
                 * The connectedEdge being part of the low cost path is then added in the queue
                 * for further low cost path discovery.
                 */ 
                if (costs[connectedVertex] > costs[currentVertex] + connectedEdgeCost) {
                    costs[connectedVertex] = costs[currentVertex] + connectedEdgeCost;
                    edgeQ.add(connectedEdge);
                }
            }
        }

        System.out.println("Starting vertex: " + startingVertex);

        for (int i = 0; i < this.numVertices; i++) {
            System.out.println("Cost to vertex " + i + ": " + costs[i]);
        }
    }

}
