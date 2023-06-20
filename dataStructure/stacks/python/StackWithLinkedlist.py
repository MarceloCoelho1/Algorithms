from Node import Node
class StackWithLinkedList:
    def __init__(self) -> None:
        self.bottom = None
        self.top = None
        self.length = -1

    def push(self, item):
        node = Node(item)
        if self.isEmpty():
            self.bottom = node
            self.top = node
        else:
            node.next = self.top
            self.top = node
           
        self.length += 1

    def pop(self):

        if self.isEmpty(): 
            return
        
        if self.length == 0:
            self.top = None
            self.bottom = None
            self.length =- 1
            return
        

        self.length -= 1
        self.top = self.top.next
        return 
    
    def peek(self):
        if self.isEmpty():
            return False
        
        return self.top.val

    def isEmpty(self):
        return self.length == -1
    


# code for test
stack = StackWithLinkedList()

stack.push(10)
stack.push(20)
stack.push(30)
stack.push(40)
stack.pop()
stack.pop()
stack.pop()
stack.pop()