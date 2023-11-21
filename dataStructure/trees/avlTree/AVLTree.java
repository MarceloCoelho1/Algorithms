public class AVLTree<T extends Comparable<T>> {
    private AVLNode<T> root;

    public AVLTree() {
        this.root = null;
    }

    public void insert(T value) {
        this.root = insertRec(this.root, value);
    }

    private AVLNode<T> insertRec(AVLNode<T> node, T value) {
        if (node == null) {
            return new AVLNode<>(value);
        }

        if (value.compareTo(node.getInfo()) < 0) {
            node.setLeft(insertRec(node.getLeft(), value));
        } else if (value.compareTo(node.getInfo()) > 0) {
            node.setRight(insertRec(node.getRight(), value));
        } else {
            return node;
        }

        updateBalanceFactor(node);

        return balance(node);
    }

    private void updateBalanceFactor(AVLNode<T> node) {
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        int balanceFactor = rightHeight - leftHeight;
        node.setFatBal(balanceFactor);
    }

    private int getHeight(AVLNode<T> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
    }

    private AVLNode<T> balance(AVLNode<T> node) {
        int balanceFactor = node.getFatBal();

        if (balanceFactor > 1) {
            if (getHeight(node.getRight().getLeft()) <= getHeight(node.getRight().getRight())) {
                return rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                return rotateLeft(node);
            }
        } else if (balanceFactor < -1) {
            if (getHeight(node.getLeft().getRight()) <= getHeight(node.getLeft().getLeft())) {
                return rotateRight(node);
            } else {
                node.setLeft(rotateLeft(node.getLeft()));
                return rotateRight(node);
            }
        }
        return node;
    }

    private AVLNode<T> rotateLeft(AVLNode<T> node) {
        AVLNode<T> newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        updateBalanceFactor(node);
        updateBalanceFactor(newRoot);
        return newRoot;
    }

    private AVLNode<T> rotateRight(AVLNode<T> node) {
        AVLNode<T> newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        updateBalanceFactor(node);
        updateBalanceFactor(newRoot);
        return newRoot;
    }

    public void inorderTraversal() {
        inorderTraversalRec(root);
    }

    private void inorderTraversalRec(AVLNode<T> node) {
        if (node != null) {
            inorderTraversalRec(node.getLeft());
            System.out.print(node.getInfo() + " ");
            inorderTraversalRec(node.getRight());
        }
    }

    public int getHeight() {
        return getHeightt(this.root);
    }

    private int getHeightt(AVLNode<T> root) {
        int cont = 0;
        while (true) {
            if (root.getLeft() == null && root.getLeft() == null) {
                break;
            }

            cont++;
            if (root.getFatBal() > 0) {
                root = root.getRight();
            } else {
                root = root.getLeft();
            }
        }

        return cont + 1;
    }

    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        int height = avlTree.getHeight();
        System.out.println(height);
    }
}
