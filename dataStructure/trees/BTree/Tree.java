package trees.BTree;

import java.util.ArrayList;

public class Tree<T extends Comparable<T>> {
    private BTreeNode<T> root;
    private int t;

    public Tree(int t) {
        this.root = new BTreeNode<>(true, t, null);
        this.t = t;
    }

    public void insert(T k) {
        BTreeNode<T> root = this.root;
        if (root.keys.size() == (2 * t - 1)) {
            BTreeNode<T> temp = new BTreeNode<>(false, t, null);
            this.root = temp;
            temp.child.add(0, root);
            splitChild(temp, 0);
        }
        insertNonFull(this.root, k);
    }

    public void insertNonFull(BTreeNode<T> x, T k) {
        int i = x.keys.size() - 1;
        if (x.leaf) {
            x.keys.add(null);
            while (i >= 0 && k.compareTo(x.keys.get(i)) < 0) {
                x.keys.set(i + 1, x.keys.get(i));
                i--;
            }
            x.keys.set(i + 1, k);
        } else {
            while (i >= 0 && k.compareTo(x.keys.get(i)) < 0) {
                i--;
            }
            i++;
            if (x.child.get(i).keys.size() == (2 * t - 1)) {
                splitChild(x, i);
                if (k.compareTo(x.keys.get(i)) > 0) {
                    i++;
                }
            }
            insertNonFull(x.child.get(i), k);
        }
    }

    public void splitChild(BTreeNode<T> x, int i) {
        int t = this.t;
        BTreeNode<T> y = x.child.get(i);
        BTreeNode<T> z = new BTreeNode<>(y.leaf, t, x);
        x.child.add(i + 1, z);
        x.keys.add(i, y.keys.get(t - 1));
        z.keys = new ArrayList<>(y.keys.subList(t, (2 * t - 1)));
        y.keys.subList(t - 1, (2 * t - 1)).clear();
        if (!y.leaf) {
            z.child = new ArrayList<>(y.child.subList(t, 2 * t));
            y.child.subList(t, 2 * t).clear();
        }
    }

    public void remove(T k) {
        root = remove(root, k);
    }

    private BTreeNode<T> remove(BTreeNode<T> x, T k) {
        if (x == null) {
            return null;
        }

        int i = 0;
        while (i < x.keys.size() && k.compareTo(x.keys.get(i)) > 0) {
            i++;
        }

        if (i < x.keys.size() && k.compareTo(x.keys.get(i)) == 0) {
            if (x.leaf) {
                x.keys.remove(i);
            } else {
                T successorKey = findSuccessorKey(x, i);
                x.keys.set(i, successorKey);
                x.child.set(i + 1, remove(x.child.get(i + 1), successorKey));
            }
        } else {
            x.child.set(i, remove(x.child.get(i), k));
        }

        return adjustTree(x);
    }

    private BTreeNode<T> adjustTree(BTreeNode<T> x) {
        if (x.keys.size() >= t - 1) {
            return x;
        }

        BTreeNode<T> parent = x.parent;
        if (parent == null) {
            if (x.keys.size() == 0 && !x.leaf) {
                x = x.child.get(0);
            }
            return x;
        }

        int indexOfX = parent.child.indexOf(x);

        // Tente emprestar uma chave do irmão à direita.
        if (indexOfX < parent.keys.size() && parent.child.get(indexOfX + 1).keys.size() > t - 1) {
            BTreeNode<T> rightSibling = parent.child.get(indexOfX + 1);
            x.keys.add(parent.keys.get(indexOfX));
            parent.keys.set(indexOfX, rightSibling.keys.get(0));
            rightSibling.keys.remove(0);
            if (!rightSibling.leaf) {
                x.child.add(rightSibling.child.get(0));
                rightSibling.child.remove(0);
            }
            return x;
        }

        // Tente emprestar uma chave do irmão à esquerda.
        if (indexOfX > 0 && parent.child.get(indexOfX - 1).keys.size() > t - 1) {
            BTreeNode<T> leftSibling = parent.child.get(indexOfX - 1);
            x.keys.add(0, parent.keys.get(indexOfX - 1));
            parent.keys.set(indexOfX - 1, leftSibling.keys.get(leftSibling.keys.size() - 1));
            leftSibling.keys.remove(leftSibling.keys.size() - 1);
            if (!leftSibling.leaf) {
                x.child.add(0, leftSibling.child.get(leftSibling.child.size() - 1));
                leftSibling.child.remove(leftSibling.child.size() - 1);
            }
            return x;
        }

        // Fusão com o irmão à direita.
        if (indexOfX < parent.keys.size()) {
            BTreeNode<T> rightSibling = parent.child.get(indexOfX + 1);
            x.keys.add(parent.keys.get(indexOfX));
            parent.keys.remove(indexOfX);
            parent.child.remove(indexOfX + 1);
            x.keys.addAll(rightSibling.keys);
            x.child.addAll(rightSibling.child);
        } else { // Fusão com o irmão à esquerda.
            BTreeNode<T> leftSibling = parent.child.get(indexOfX - 1);
            leftSibling.keys.add(parent.keys.get(indexOfX - 1));
            parent.keys.remove(indexOfX - 1);
            parent.child.remove(indexOfX);
            leftSibling.keys.addAll(x.keys);
            leftSibling.child.addAll(x.child);
        }

        return adjustTree(parent);
    }

    private T findSuccessorKey(BTreeNode<T> x, int i) {
        BTreeNode<T> currentNode = x.child.get(i + 1);
        while (!currentNode.leaf) {
            currentNode = currentNode.child.get(0);
        }
        return currentNode.keys.get(0);
    }

    public void printTree(BTreeNode<T> x, int l) {
        if (x != null) {
            System.out.print("Level " + l + ": [");
            for (int i = 0; i < x.keys.size(); i++) {
                System.out.print(x.keys.get(i));
                if (i < x.keys.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]\n");

            l++;
            if (!x.child.isEmpty()) {
                for (BTreeNode<T> child : x.child) {
                    printTree(child, l);
                }
            }
        }
    }

    public T search(T k) {
        return search(root, k);
    }

    private T search(BTreeNode<T> x, T k) {
        int i = 0;
        while (i < x.keys.size() && k.compareTo(x.keys.get(i)) > 0) {
            i++;
        }
        if (i < x.keys.size() && k.compareTo(x.keys.get(i)) == 0) {
            return k;
        } else if (x.leaf) {
            return null;
        } else {
            return search(x.child.get(i), k);
        }
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BTreeNode<T> x) {
        if (x == null) {
            return 0;
        }

        if (x.leaf) {
            return 0;
        }

        int maxHeight = 0;

        for (BTreeNode<T> child : x.child) {
            int childHeight = getHeight(child);
            maxHeight = Math.max(maxHeight, childHeight);
        }

        return maxHeight + 1;
    }

    public T findMaxKey() {
        BTreeNode<T> currentNode = root;

        while (!currentNode.leaf) {
            currentNode = currentNode.child.get(currentNode.keys.size());
        }

        return currentNode.keys.get(currentNode.keys.size() - 1);
    }

    public T findMinKey() {
        BTreeNode<T> currentNode = root;

        while (!currentNode.leaf) {
            currentNode = currentNode.child.get(0);
        }

        return currentNode.keys.get(0);
    }

    public void preOrderTraversal(BTreeNode<T> node) {
        if (node != null) {
            System.out.print("[");

            for (int i = 0; i < node.keys.size(); i++) {
                System.out.print(node.keys.get(i));
                if (i < node.keys.size() - 1) {
                    System.out.print(", ");
                }
            }

            System.out.print("] ");

            for (BTreeNode<T> child : node.child) {
                preOrderTraversal(child);
            }
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
        System.out.println();
    }

    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }

        int height = getHeight(root);

        for (int level = 0; level < height; level++) {
            printLevel(root, level);
            System.out.println();
        }
    }

    private void printLevel(BTreeNode<T> node, int level) {
        if (node == null) {
            return;
        }
        if (level == 0) {
            System.out.print("[");
            for (int i = 0; i < node.keys.size(); i++) {
                System.out.print(node.keys.get(i));
                if (i < node.keys.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("] ");
        } else if (level > 0) {
            for (int i = 0; i < node.child.size(); i++) {
                printLevel(node.child.get(i), level - 1);
            }
        }
    }

    public static void main(String[] args) {
        Tree<Integer> b = new Tree<>(3);

        for (int i = 10; i > 1; i--) {
            b.insert(i);
            b.printTree(b.root, 0);
        }

        Integer keyToSearch = 5;
        Integer result = b.search(keyToSearch);
        if (result != null) {
            System.out.println("Chave " + keyToSearch + " encontrada.");
        } else {
            System.out.println("Chave " + keyToSearch + " não encontrada.");
        }

        int height = b.getHeight();
        System.out.println("Altura da árvore B: " + height);

        Integer maxKey = b.findMaxKey();
        System.out.println("Maior chave na árvore B: " + maxKey);

        Integer minKey = b.findMinKey();
        System.out.println("Menor chave na árvore B: " + minKey);

        Integer keyToRemove = 7;
        System.out.println("Removendo chave " + keyToRemove + " da árvore...");
        b.remove(keyToRemove);

        System.out.println("Árvore B em pré-ordem:");
        b.preOrderTraversal();


    }
}
