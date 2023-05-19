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

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();

        l1.insertAtEnd(10);
        l1.insertAtEnd(20);
        l1.insertAtEnd(30);
        l1.insertAtEnd(40);
        l1.insertAtEnd(0);

        l1.insertAtBegin(5);

       
    }


}
