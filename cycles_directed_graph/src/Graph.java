import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

class Graph {

    ArrayList<Integer>[] graph;
    int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.graph = new ArrayList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            this.graph[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int a, int b) {
        this.graph[a].add(b);
    }

    public void detectCycle() {
        // For each vertex in graph as the starting vertex
        outer: for (int i = 0; i < this.numVertices; i++) {
            Stack<Integer> stack = new Stack<Integer>(); // For traversal
            boolean[] visited = new boolean[this.graph.length];
            List<Integer> currentPath = new ArrayList<>(); // Holds a current traversal path
            stack.push(i);
    
            System.out.println(String.format("Depth first traversal from vertex - %d", i));
    
            while (!stack.isEmpty()) {
                int currentVertex = stack.pop();
                ArrayList<Integer> connectedVertices = this.graph[currentVertex];
                connectedVertices.sort(Comparator.reverseOrder()); // Explained in dfs code

                for (Integer connectedVertex : connectedVertices) {
                    /**
                     * Traversing through the graph, if a vertex in the traversal path points to the
                     * starting vertex in the current path of traversal, then it forms a cycle.
                     * Capturing the cycle and moving to the next vertex in line as the starting point.
                     */
                    if (!currentPath.isEmpty() && connectedVertex == currentPath.get(0)) {
                        currentPath.add(currentVertex);
                        currentPath.add(connectedVertex);
                        System.out.println(String.format("Cycle detected on path - %s", Arrays.toString(currentPath.toArray())));
                        continue outer;
                    }
                    /**
                     * The stack is used for traversing, so a connectedVertex will not be recaptured
                     * that is either visited already or is currently existing in the stack.
                     */
                    if (!(stack.contains(connectedVertex) || visited[connectedVertex])) {
                        stack.add(connectedVertex);
                    }
                }
    
                if (!visited[currentVertex]) {
                    System.out.println(String.format("Next vertex - %d", currentVertex));
                    visited[currentVertex] = true;
                    currentPath.add(currentVertex);
                }
            }
        }
    }
}
