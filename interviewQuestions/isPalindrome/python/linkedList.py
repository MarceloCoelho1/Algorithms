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
    
   
    def isPalindrome(self, list: Node):
        vector = []

        while list != None:
            vector.append(list.val)
            list = list.next

        first_pointer = 0
        last_pointer = len(vector) - 1

        for i in vector:
            if vector[first_pointer] != vector[last_pointer]:
                return False
        
            if first_pointer == last_pointer:
                return True
            
            first_pointer += 1
            last_pointer -= 1

            

    def print(self, node):

        current_node = node

        while current_node != None:
            print(current_node.val)
            current_node = current_node.next
    
    def get_root(self):
        return self.head


list = LinkedList()

list.add(1)
list.add(0)
list.add(1)


node = list.get_root()

list.isPalindrome(node)