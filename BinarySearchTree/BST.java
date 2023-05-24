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

    public boolean remove(Integer key) {
        return remove(key, this.root, null);
    }

    private boolean remove(Integer key, Node node, Node parentNode) {
        if (node == null) {
            return false;
        }

        if (key < node.key) {
            parentNode = node;
            node = node.left;

            return remove(key, node, parentNode);
        } else if (key > node.key) {
            parentNode = node;
            node = node.right;

            return remove(key, node, parentNode);
        } else if (node.key == key) {

            if (node.right == null) {
                if (parentNode == null) {
                    this.root = node.left;
                } else {

                    if (node.key < parentNode.key) {
                        parentNode.left = node.left;
                    } else if (node.key > parentNode.key) {
                        parentNode.right = node.left;
                    }
                }
            } else if (node.right.left == null) {
                node.right.left = node.left;
                if (parentNode == null) {
                    this.root = node.right;
                } else {

                    // if parent > current, make right child of the left the parent
                    if (node.key < parentNode.key) {
                        parentNode.left = node.right;

                        // if parent < current, make right child a right child of the parent
                    } else if (node.key > parentNode.key) {
                        parentNode.right = node.right;
                    }
                }

            } else {

                //find the Right child's left most child
                Node leftmost = node.right.left;
                Node leftmostParent = node.right;
                while(leftmost.left != null) {
                  leftmostParent = leftmost;
                  leftmost = leftmost.left;
                }
                
                //Parent's left subtree is now leftmost's right subtree
                leftmostParent.left = leftmost.right;
                leftmost.left = node.left;
                leftmost.right = node.right;
      
                if(parentNode == null) {
                  this.root = leftmost;
                } else {
                  if(node.key < parentNode.key) {
                    parentNode.left = leftmost;
                  } else if(node.key > parentNode.key) {
                    parentNode.right = leftmost;
                  }
                }
              }
            return true;
        }

        return false;
    }

}
