package linkedList;

public class LinkedList<T> {
    Node<T> first;

    public LinkedList () {
        this.first = null;
    }

    public void insertAtBegin(T element) {
        Node<T> newNode = new Node<T>(element);
        newNode.next = first;
        first = newNode;

    }

    public void removeFromBegin() {
        
        first = first.next;
    }

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();

        

        l1.removeFromBegin();
    }

}
