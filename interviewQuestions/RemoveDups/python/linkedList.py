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
    
    # remove duplicates values with recursion
    def removeDuplicates(self, current_node=None, compare_node=None, previous_node=None,first_time=0):
        
        if first_time == 0:
            if(current_node == None):
                current_node = self.head

            compare_node = current_node.next
            previous_node = Node(None)

        if current_node.next == None:
            return False

        if current_node.val == compare_node.val:
            previous_node.next = compare_node.next

            if compare_node.next == None:
                self.tail = previous_node
            
            self.removeDuplicates(current_node.next)

            

        if current_node.val != compare_node.val:
            if compare_node.next == None:
                current_node = current_node.next
                compare_node = current_node.next
                previous_node = current_node
                self.removeDuplicates(current_node, compare_node, previous_node, 1)
            else:
                previous_node = compare_node
                compare_node = compare_node.next
                self.removeDuplicates(current_node, compare_node, previous_node, 1)



                
    
    def print(self):

        current_node = self.head

        while current_node != None:
            print(current_node.val)
            current_node = current_node.next





#code for test

list = LinkedList()
list.add(1)
list.add(5)
list.add(1)
list.add(2)
list.add(11)
list.add(2)
list.add(10)

print("linkedlist with duplicates values:")
list.print()

list.removeDuplicates()
print("linkedlist without duplicates values")
list.print()


