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
        
    def get(self, key):
        return self._get_recursive(key, self.root)
    
    def _get_recursive(self, key, node):
        
        if node is None:
            return None
        
        if key is None:
            return None
        
        
        if key == node.val:
            return True
        elif key < node.val:
            return self._get_recursive(key, node.left)
        else:
            return self._get_recursive(key, node.right)

    
    def depth(self):
        return self._depth_recursive(self.root) - 1
    
    def _depth_recursive(self, node):
        if node is None:
            return 0
        
        return 1 + max(self._depth_recursive(node.left), self._depth_recursive(node.right))
    
    def remove(self, key):
        self.root = self._remove_recursive(self.root, key)

    def _remove_recursive(self, node, key):
        if node is None:
            return None

        if key < node.val:
            node.left = self._remove_recursive(node.left, key)
        elif key > node.val:
            node.right = self._remove_recursive(node.right, key)
        else:

            if node.left is None:
                return node.right
            elif node.right is None:
                return node.left
            

            successor = self._find_minimum(node.right)
            node.val = successor.val
            node.right = self._remove_recursive(node.right, successor.val)
        
        return node

    def _find_minimum(self, node):
        if node.left is None:
            return node
        
        return self._find_minimum(node.left)
    
    # binary Tree Transversal

    def in_order(self):
        self._in_order_recursive(self.root)


    def _in_order_recursive(self, node):
        if node is None:
            return node
        
        self._in_order_recursive(node.left)
        print(node.val)
        self._in_order_recursive(node.right)


    def pre_order(self):
            self._pre_order_recursive(self.root)

    def _pre_order_recursive(self, node):
        if node is None:
            return node
        
        print(node.val)
        self._pre_order_recursive(node.left)
        self._pre_order_recursive(node.right)


    def post_order(self):
            self._post_order_recursive(self.root)

    def _post_order_recursive(self, node):
        if node is None:
            return node
        

        self._post_order_recursive(node.left)
        self._post_order_recursive(node.right)
        print(node.val)

    def BFS(self):
        list = []
        queue = [self.root]
        return self._BFS_recursive(queue, list)

    def _BFS_recursive(self, queue: list, list: list):
        length = len(queue)

        if not length:
            return list
        
        current_node = queue.pop(0)
        list.append(current_node.val)
        if current_node.left:
            queue.append(current_node.left)

        if current_node.right:
            queue.append(current_node.right)

        return self._BFS_recursive(queue, list)
        

        
#code example for BFS
    
bst = BST()

bst.put(9)
bst.put(4)
bst.put(6)
bst.put(20)
bst.put(170)
bst.put(15)
bst.put(1)

list = bst.BFS()

print(list)


