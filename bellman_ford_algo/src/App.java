public class App {
    public static void main(String[] args) throws Exception {
        Graph graph = new Graph(5, 8);
        graph.addEdge(0, 1, -1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 2, 5);
        graph.addEdge(3, 1, 1);
        graph.addEdge(4, 3, -3);

        graph.shortestPath(0);

        Graph graph2 = new Graph(6, 7);
        graph2.addEdge(0, 1, 5);
        graph2.addEdge(1, 2, 1);
        graph2.addEdge(1, 3, 2);
        graph2.addEdge(2, 4, 1);
        graph2.addEdge(4, 3, -1);
        graph2.addEdge(3, 5, 2);
        graph2.addEdge(5, 4, -3);

        graph2.shortestPath(0);
    }
}
