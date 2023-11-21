class AVLNode<T extends Comparable <T>>{
    private AVLNode<T> left;
    private T info;
    private int fatBal;
    private AVLNode<T> right;
    
    AVLNode (T value) {
        this.info = value;
    }
    
    void setLeft (AVLNode<T> left) {
        this.left = left;
    }
    
    void setRight (AVLNode<T> right) {
        this.right = right;
    }
    
    void setInfo (T value) {
        this.info = value;
    }
    
    void setFatBal (int fb) {
        this.fatBal = fb;
    }
    
    AVLNode<T> getLeft () {
        return this.left;
    }
    
    AVLNode<T> getRight () {
        return this.right;
    }
    
    T getInfo () {
        return this.info;
    }
    
    int getFatBal () {
        return this.fatBal;
    }
    
   
}

