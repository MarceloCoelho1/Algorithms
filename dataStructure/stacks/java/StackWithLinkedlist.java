package java;

public class StackWithLinkedlist {
    private Integer length;
    private Node bottom;
    private Node top;

    public StackWithLinkedlist() {
        this.length = -1;
    }

    public Integer peek(){
        if(isEmpty()) {
            return null;
        }
        return top.value;
    }

    public void push(Integer value){
        if(isEmpty()) {
            Node newNode = new Node(value);
            bottom = newNode;
            top = newNode;
        } else {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
        }
        length++;
    }


    public boolean pop(){
        if(isEmpty()) {
            return false;
        }

        length--;
        top = top.next;
        return true;

    }

    public boolean isEmpty(){
        return length == -1;
    }
}
