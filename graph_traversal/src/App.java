public class App {
    public static void main(String[] args) throws Exception {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);

        System.out.println();
        graph.bfTraversal(0);
        System.out.println();
        graph.dfTraversal(0);
    }
}
