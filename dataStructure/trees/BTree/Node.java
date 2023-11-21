package trees.BTree;

import java.util.ArrayList;
import java.util.List;
class BTreeNode <T extends Comparable<T>>{
    boolean leaf;
        List<T> keys;
        List<BTreeNode<T>> child;
        BTreeNode<T> parent;

        public BTreeNode(boolean leaf, int t, BTreeNode<T> parent) {
            this.leaf = leaf;
            this.keys = new ArrayList<>(2 * t - 1); 
            this.child = new ArrayList<>(2 * t); 
            this.parent = parent;
        }

        public BTreeNode<T> getParent() {
            return parent;
        }
}

