from Node import Node

class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        
    def add(self, value):
        node = Node(value)

        if self.head == None:
            self.head = node
            self.tail = node
            return
    
        self.tail.next = node
        self.tail = node
    
    # iterative way
    def reverseLinkedList(self, list1: Node):

        previous_node, current_node = None, list1

        while current_node != None:
            nxt = current_node.next
            current_node.next = previous_node
            previous_node = current_node
            current_node = nxt

        
        return previous_node
    

    def print(self, node):

        current_node = node

        while current_node != None:
            print(current_node.val)
            current_node = current_node.next
    
    def get_root(self):
        return self.head


#code for test

list = LinkedList()
list.add(1)
list.add(5)
list.add(10)
list.add(12)

head = list.get_root()
node = list.reverseLinkedList(head)

list.print(node)


