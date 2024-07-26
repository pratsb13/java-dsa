import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    private Queue<Node> nodeQ;
    private Node root;
    
    public Tree(String rootData) {
        this.nodeQ = new LinkedList<Node>();
        this.root = new Node(rootData);
        this.nodeQ.add(this.root);
    }

    public Node getRoot() {
        return root;
    }

    public void addNode(String data) {
        Node newNode = new Node(data);

        if (this.nodeQ.peek().leftNode == null)
            this.nodeQ.peek().leftNode = newNode;
        else {
            this.nodeQ.peek().rightNode = newNode;
            this.nodeQ.poll();
        }

        this.nodeQ.add(newNode);
    }

    public void inorder(Node node) {
        if (node == null)
            return;
        
        this.inorder(node.leftNode);
        System.out.println(node.data + " ");
        this.inorder(node.rightNode);
    }

    public void preorder(Node node) {
        if (node == null)
            return;
        
        System.out.println(node.data + " ");
        this.preorder(node.leftNode);
        this.preorder(node.rightNode);
    }

    public void postorder(Node node) {
        if (node == null)
            return;
        
        this.postorder(node.leftNode);
        this.postorder(node.rightNode);
        System.out.println(node.data + " ");
    }

}
