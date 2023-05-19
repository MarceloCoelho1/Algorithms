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
        if (first == null) {
            return;
        }
        first = first.next;
        if(first == null) {
            last = null;
        }
   
    }

    public void insertAtEnd(T element) {
        Node<T> newNode = new Node<>(element);

        if(first == null) { 
            first = newNode;
            last = newNode;
            return;
        }

        last.next = newNode;
        last = newNode;
    }

    public void removeFromEnd() {
        if(first == null) return;
        if(first == last) {
            first = null;
            last = null;
            return;
        }

        Node<T> currentNode = first;
        Node<T> previous = null;

        while( currentNode != last ) {
            previous = currentNode;
            currentNode = currentNode.next;
        }

        if(currentNode != null) {
            previous.next = null;
            last = previous;
        }
    }

    public void remove(T element) {
        if(first == null) return;

        if(first.data.equals(element)) {
            first = first.next;

            if(first == null) {                
                last = null;
            }
            return;
        }


        Node<T> currentNode = first;
        Node<T> previous = null;

        while(currentNode != null && !currentNode.data.equals(element)) {
            previous = currentNode;
            currentNode = currentNode.next;
        }

        if(currentNode != null) {
            previous.next = currentNode.next;

            if(currentNode == last) {
                last = previous;
            }
        }
    }

    public void print() {
        Node<T> current = first;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}
