import java.util.Arrays;


public class Graph {
    
    int numVertices, numEdges, edgeCounter;
    Edge[] edges;

    public Graph(int numVertices, int numEdges) {
        this.numVertices = numVertices;
        this.numEdges = numEdges;
        this.edges = new Edge[numEdges];
        this.edgeCounter = 0;
    }

    public void addEdge(int a, int b, int cost) {
        this.edges[edgeCounter] = new Edge(a, b, cost);
        edgeCounter++;
    }

    /**
     * BELLMAN FORD ALGO for graph with negative edges.
     * Tries to relax all edges (numVertices-1) times.
     * If more relaxation are possible then graph has negative edge cycle.
     */
    public void shortestPath(int startingVertex) {
        /**
         * Initialize a costs array to MAX_VALUE for all vertices.
         * There will be no cost to the startingVertex(self).
         */
        int[] costs = new int[this.numVertices];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[startingVertex] = 0;

        // Relaxation of all edges for (numVertices-1) times should be performed.
        for (int i = 0; i < this.numVertices; i++) {
            for (Edge edge : edges) {
                int a = edge.a;
                int b = edge.b;
                int cost = edge.cost;

                /**
                 * Try to relax the cost of a->b if 
                 *      1. cost of a from startingVertex < MAX_VALUE
                 *      2. cost of b > cost of a from startingVertex + cost of edge a->b
                 */
                if (costs[a] != Integer.MAX_VALUE && costs[b] > costs[a] + cost) {
                    // If relaxation is still possible after (numVertices-1) times then negative edge cycle exist.
                    if (i == this.numVertices - 1) {
                        System.out.println("Negative edge cycle exist");
                        return;
                    }
                    costs[b] = costs[a] + cost;
                }
            }
        }
        
        System.out.println("Starting vertex: " + startingVertex);

        for (int i = 0; i < this.numVertices; i++) {
            System.out.println("Cost to vertex " + i + ": " + costs[i]);
        }
    }

}
