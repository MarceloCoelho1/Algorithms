package BinarySearchTree;

public class BST {
    Node root;
    
    public void put(Integer key) {
        root = put(root, key);
    }

    private Node put(Node node, Integer key) {
        if (node == null) {
            Node novoNo = new Node(key);
            return novoNo;
        }

        if (key < node.key) {
            node.left = put(node.left, key);
        } else if (key > node.key) {
            node.right = put(node.right, key);
        }

        return node;
    }

    public int depth() {
        return depth(root) - 1;
    }

    private int depth(Node node) {
        if (node == null)
            return 0;

        int leftHeight = depth(node.left);
        int rightHeight = depth(node.right);

        return 1 + Math.max(leftHeight, rightHeight);

    }

}
