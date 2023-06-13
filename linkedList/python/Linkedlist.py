from Node import Node

class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        
    def insertAtBegin(self, value):
        node = Node(value)

        node.next = self.head
        self.head = node

        if(self.tail == None):
            self.tail = node

    




        
        

