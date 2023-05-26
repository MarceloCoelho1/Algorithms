package stacks;

public class StackWithLinkedlist {
    private Integer length;
    private Node bottom;
    private Node top;

    public StackWithLinkedlist() {
        this.length = -1;
    }

    public void peek(){}

    public void push(Integer value){
        if(length == -1) {
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


    public void pop(){}

    public boolean isEmpty(){
        return true;
    }
}
