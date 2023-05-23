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

    public static void main(String[] args) {
        BST bst = new BST();

        bst.put(50);
        bst.put(40);
        bst.put(60);
        bst.put(30);
        bst.put(70);
    }
}
