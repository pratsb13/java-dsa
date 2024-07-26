public class App {
    public static void main(String[] args) throws Exception {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1, 12);
        graph.addEdge(0, 2, 15);
        graph.addEdge(1, 2, 10);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 1, 7);

        graph.print();
    }
}
