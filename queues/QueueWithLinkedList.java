
package queues;

public class QueueWithLinkedList {
    private Node first;
    private Node last;
    private int length;

    public QueueWithLinkedList() {
        this.length = -1;
    }

    public Integer peek(){
        return first.value;
    }

    public void enqueue(Integer value){
        Node newNode = new Node(value);
        if(isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = last;
            last = newNode; 
        }

        length++;
    }

    public void dequeue(){
        if(isEmpty()) return;

        Node currentNode = last;

        while(currentNode.next != first) {
            currentNode = currentNode.next;
        }

        first = currentNode;
        first.next = null;
        length--;
    }

    public boolean isEmpty(){
        return length == -1;
    }


    
}