public class App {
    public static void main(String[] args) throws Exception {
        Tree tree = new Tree("A");
        tree.addNode("B");
        tree.addNode("C");
        tree.addNode("D");
        tree.addNode("E");
        tree.addNode("F");
        tree.addNode("G");
        
        System.out.print("Inorder traversal: ");
        tree.inorder(tree.getRoot());
        System.out.print("\nPreorder traversal: ");
        tree.preorder(tree.getRoot());
        System.out.print("\nPostorder traversal: ");
        tree.postorder(tree.getRoot());
    }
}
