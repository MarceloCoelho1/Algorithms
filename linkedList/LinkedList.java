package linkedList;

public class LinkedList<T> {
    Node<T> first;
    Node<T> last;

    public LinkedList () {
        this.first = null;
    }

    public void insertAtBegin(T element) {
        Node<T> newNode = new Node<T>(element);
        newNode.next = first;
        first = newNode;

        if(last == null) {
            last = newNode;
        }

    }

    public void removeFromBegin() {
        if(first == null) {
            return;
        }
        first = first.next;
    }

   


}
