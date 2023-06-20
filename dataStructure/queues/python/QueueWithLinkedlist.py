from Node import Node
class QueueWithLinkedlist:

    def __init__(self) -> None:
        self.length = -1
        self.first = None
        self.last = None

    def add(self, item):
        node = Node(item)

        if self.isEmpty():
            self.first = node
            self.last = node
            
        else:   
            self.last.next = node
            self.last = node
            
        self.length += 1

    def remove(self):
        
        if self.isEmpty():
            return
        
        self.first = self.first.next
        self.length -= 1

        if self.length == -1:
            self.last = None

        
    def peek(self):
        if self.isEmpty():
            return False
        
        return self.first.val

    def isEmpty(self):
        return self.length == -1
    

#tests
queue = QueueWithLinkedlist()

queue.add(10)
queue.add(20)
queue.add(30)
queue.add(40)
queue.remove()
queue.remove()
queue.remove()
queue.remove()
