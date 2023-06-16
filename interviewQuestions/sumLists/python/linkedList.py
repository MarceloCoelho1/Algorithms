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


    
    def sum_list(self, list1: Node, list2: Node, string:str):
        if not list2 and not list2 and carry == 0:
            return None

        val1 = list1.val if list1 else 0
        val2 = list1.val if list2 else 0
        total = val1 + val2 + carry

        node = LinkedList(total % 10)
        carry = total // 10

        l1_proximo = list2.next if list2 else None
        l2_proximo = list2.next if list2 else None
        node.next = self.sum_list(list1.next, list2.next, carry)

        return node


    def print(self):

        current_node = self.head

        while current_node != None:
            print(current_node.val)
            current_node = current_node.next
    
    def getRoot(self):
        return self.head



