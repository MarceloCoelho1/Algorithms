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

    def removeFromBegin(self):
        if self.head == None: return

        self.head = self.head.next
        if self.head == None: 
            self.tail = None
            return


    def insertAtEnd(self, value):
        node = Node(value)

        if self.head == None: 
            self.head = node
            self.tail = node
            return
        

        self.tail.next = node
        self.tail = node

    def removeFromEnd(self):
        if self.head == None: return

        if self.head == self.tail:
            self.head = None
            self.tail = None
            return
        
        current_node = self.head
        previous = Node(0)

        while( current_node != self.tail ):
            previous = current_node
            current_node = current_node.next
            
        

        if(current_node != None):
            previous.next = None
            self.tail = previous


    def remove(self, val):
        if self.head == None: return

        if self.head.val == val:
            self.head = self.head.next

            if self.head == None:
                self.tail = None

            return
        
        current_node = self.head
        previous = Node(0)

        while( current_node != None and current_node.val != val ):
            previous = current_node
            current_node = current_node.next
            
        if current_node != None:
            previous.next = current_node.next

            if current_node == self.tail:
                self.tail = previous
            
        
