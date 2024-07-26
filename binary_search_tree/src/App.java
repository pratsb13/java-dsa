public class App {
    public static void main(String[] args) throws Exception {
        BST bst = new BST(5);

        bst.add(3);
        bst.add(7);
        bst.add(2);
        bst.add(4);
        bst.add(6);
        bst.add(8);

        bst.delete(5);

        System.out.print("Inorder traversal: ");
        String output = bst.traverse(BST.TraverseOrder.IN_ORDER);
        System.out.println(output);

        System.out.print("Preorder traversal: ");
        output = bst.traverse(BST.TraverseOrder.PRE_ORDER);
        System.out.println(output);

        System.out.print("Postorder traversal: ");
        output = bst.traverse(BST.TraverseOrder.POST_ORDER);
        System.out.println(output);

        bst.find(8);
    }
}
