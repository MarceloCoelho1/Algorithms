package linkedList;

public class LinkedList<T> {
    Node<T> first;

    public LinkedList () {
        this.first = null;
    }

    public void insertAtBegin(T element) {
        Node<T> newNode = new Node<T>(element);

        if(first == null) {
            first = newNode;
        } else {
            Node<T> oldFirst = first;
            first = newNode;
            first.next = oldFirst;
        }

    }

}
