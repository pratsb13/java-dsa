public class BST {

    private Node root;
    public enum TraverseOrder{
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

    public BST(int rootData) {
        this.root = new Node(rootData);
    }

    public void add(int value) {
        addNode(root, value);
        System.out.println(value + " is added in the tree");
    }

    private void addNode(Node node, int data) {
        if (node.data > data)
            if (node.leftNode != null)
                this.addNode(node.leftNode, data);
            else
                node.leftNode = new Node(data);

        else if (node.data < data)
            if (node.rightNode != null)
                this.addNode(node.rightNode, data);
            else
                node.rightNode = new Node(data);
    }

    public void find(int value) {
        searchNode(root, value);
    }

    private void searchNode(Node node, int data) {
        if (node.data == data)
            System.out.println(data + " is found in the tree");
        else if (data < node.data && node.leftNode != null)
            searchNode(node.leftNode, data);
        else if (data > node.data && node.rightNode != null)
            searchNode(node.rightNode, data);
        else
            System.out.println(data + " is not found in the tree");
    }

    public void delete(int value) {
        removeNode(root, null, value);
        System.out.println(value + " is deleted from the tree");
    }

    private void removeNode(Node node, Node parentNode, int data) {
        if (node.data == data) {
            if (isLeafNode(node)) {
                if (data < parentNode.data)
                    parentNode.leftNode = null;
                else
                    parentNode.rightNode = null;
            } else if (node.leftNode != null && node.rightNode != null) {
                node.data = findInorderSuccessor(node.rightNode, null).data;
            } else if (node.leftNode != null) {
                if (node.data > parentNode.data)
                    parentNode.rightNode = node.leftNode;
                else
                    parentNode.leftNode = node.leftNode;

                node.leftNode = null;
            } else {
                if (node.data > parentNode.data)
                    parentNode.rightNode = node.rightNode;
                else
                    parentNode.leftNode = node.rightNode;
                    
                node.rightNode = null;
            }

            node = null; // GC
        }
        else if (data < node.data && node.leftNode != null)
            removeNode(node.leftNode, node, data);
        else if (data > node.data && node.rightNode != null)
            removeNode(node.rightNode, node, data);
        else
            System.out.println("Not found");
    }

    private Node findInorderSuccessor(Node node, Node parentNode) {
        if (node.leftNode != null) {
            parentNode = node;
            node = findInorderSuccessor(node.leftNode, parentNode);
        }
        else
            parentNode.leftNode = null;

        return node;
    }

    private boolean isLeafNode(Node node) {
        return (node.leftNode == null && node.rightNode == null);
    }

    public String traverse(TraverseOrder order) throws Exception {
        if (order == TraverseOrder.IN_ORDER || order == null)
            return inorder(root, "");
        else if (order == TraverseOrder.PRE_ORDER)
            return preorder(root, "");
        else if (order == TraverseOrder.POST_ORDER)
            return postorder(root, "");
        else
            throw new Exception("Invalid order provided");
    }

    private String inorder(Node node, String output) {
        if (node == null) {
            return output;
        }

        output = this.inorder(node.leftNode, output);
        output += node.data + " ";
        output = this.inorder(node.rightNode, output);

        return output;
    }

    private String preorder(Node node, String output) {
        if (node == null) {
            return output;
        }

        output += node.data + " ";
        output = this.preorder(node.leftNode, output);
        output = this.preorder(node.rightNode,output);

        return output;
    }

    private String postorder(Node node, String output) {
        if (node == null) {
            return output;
        }

        output = this.postorder(node.leftNode, output);
        output = this.postorder(node.rightNode, output);
        output += node.data + " ";

        return output;
    }

}
