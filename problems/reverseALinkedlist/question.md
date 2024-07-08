# reverse linkedlist!

## Problem Description
given a root of linkedlist, get the reverse linkedlist

**Input:**
1 -> 5 -> 1 -> 2 

**Output:**
2 -> 1 -> 5 -> 1

## Code in Python

```python
    # iterative way
    def reverseLinkedList(self, list1: Node):

        previous_node, current_node = None, list1

        while current_node != None:
            nxt = current_node.next
            current_node.next = previous_node
            previous_node = current_node
            current_node = nxt

        
        return previous_node
```

# time complexity
The time complexity of the reverseLinkedList method is O(N), where N is the number of nodes in the linked list. This is because the algorithm traverses the list once, reversing the direction of the pointers at each node.

In the while loop, each node is visited once, and the pointer reversal operation has a constant time complexity. Therefore, the overall time complexity is linear in relation to the number of nodes in the list.

# space complexity
The space complexity of the reverseLinkedList method is O(1), indicating that it uses constant space. This is because the algorithm performs the reversal operations in-place within the linked list, without requiring any additional space proportional to the size of the list.

The algorithm only uses a few additional variables, such as previous_node, current_node, and nxt, to track the progress and perform the reversal operations. These variables occupy a constant amount of space, regardless of the size of the list.


