from Node import Node
class BST:
    
    def __init__(self) -> None:
        self.root = None
        

    def put(self, key):    
        self.root = self._put_recursive(key, self.root)

    def _put_recursive(self, key, node):

        if node is None:
            return Node(key)
        
        if key < node.val:
            node.left = self._put_recursive(key, node.left)
        elif key > node.val:
            node.right = self._put_recursive(key, node.right)
        
        return node
        
        