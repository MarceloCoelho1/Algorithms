package java;

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

    public Integer get(Integer key) {
        return get(key, this.root);
    }

    private Integer get(Integer key, Node node) {
        if (node == null) {
            return null;
        }

        if (key == null) {
            throw new IllegalArgumentException("Null key");
        }

        if (key > node.key) {
            return get(key, node.right);
        } else if (key < node.key) {
            return get(key, node.left);
        } else {
            return node.key;
        }
    }

    public Node removeWithRecursion(Integer key) {
        return removeWithRecursion(key, this.root);
    }

    private Node removeWithRecursion(Integer key, Node node) {
        if (node == null)
            return null;
        if (key > node.key) {
            return removeWithRecursion(key, node.right);
        } else if (key < node.key) {
            return removeWithRecursion(key, node.left);
        } else {

            if (node.right == null && node.left == null) { // If it is leaf node
                node = null;

            } else if (node.left == null) { // If only right node is present
                Node temp = node.right;
                node.right = null;
                node = temp;
            } else if (node.right == null) { // Only left node is present
                Node temp = node.left;
                node.left = null;
                node = temp;
            } else { // both children are present
                // Node temp = node.right;
                Node temp1 = node.left;
                // Find leftmost child of right subtree
                temp1 = max(node.left);

                node.key = temp1.key;
                node.left = removeWithRecursion(temp1.key, node.left);

                // temp = min(node.right);
                // node.key = temp.key;  
                // node.right = removeWithRecursion(temp.key, node.right);
            }
        }
        return node;

    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }

        return min(node.left);
    }

    private Node max(Node node) {
        if(node.right == null) {
            return node;
        }
        return max(node.right);
    }

 
}
