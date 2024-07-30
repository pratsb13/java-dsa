import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {

    ArrayList<Integer>[] graph;

    public Graph(int numVertices) {
        this.graph = new ArrayList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            this.graph[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int a, int b) throws Exception {
        if (a == b) {
            throw new Exception(String.format("Adding edge to same vertex %d->%d", a));
        }
        this.graph[a].add(b);
    }

    public void bfTraversal(int startingVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startingVertex);
        boolean[] visited = new boolean[this.graph.length];
        visited[startingVertex] = true;

        System.out.println(String.format("Breadth first traversal from vertex - %d", startingVertex));

        while (!queue.isEmpty()) {
            /**
             * For the current vertex from the front of the queue get all connected vertices
             * and add them to the end of the queue.
             */
            int currentVertex = queue.poll();
            ArrayList<Integer> connectedVertices = this.graph[currentVertex];
            queue.addAll(connectedVertices);

            if (!visited[currentVertex]) {
                System.out.println(String.format("Next vertex - %d", currentVertex));
                visited[currentVertex] = true;
            }
        }
    }

    public void dfTraversal(int startingVertex) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(startingVertex);
        boolean[] visited = new boolean[this.graph.length];
        visited[startingVertex] = true;

        System.out.println(String.format("Depth first traversal from vertex - %d", startingVertex));

        while (!stack.isEmpty()) {
            /**
             * For the current vertex from the top of the stack get all connected vertices
             * and add them to the top of the stack.
             * The connected vertices will be in natural order so adding them directly to stack
             * would cause the higher value to be at the top of the stack. For ex., if the
             * connected vertices are [1, 2, 4] then adding this to the stack as is would cause
             * 4 to be at the top then 2 followed by 1. This is why the order of the connected
             * vertices are reversed.
             */
            int currentVertex = stack.pop();
            ArrayList<Integer> connectedVertices = this.graph[currentVertex];
            connectedVertices.sort(Comparator.reverseOrder());
            stack.addAll(connectedVertices);

            if (!visited[currentVertex]) {
                System.out.println(String.format("Next vertex - %d", currentVertex));
                visited[currentVertex] = true;
            }
        }
    }
}