# Remove Dups!

## Problem Description
Write code to remove `n` duplicates from an unsorted linked list.

**Input:**
1 -> 5 -> 1 -> 2 -> 11 -> 2 -> 10

**Output:**
1 -> 5 -> 2 -> 11 -> 10

## Code in Python

```python
def removeDuplicates(self, current_node=None, compare_node=None, previous_node=None, identifier=0):
    if identifier == 0:
        current_node = self.head
        compare_node = current_node.next
        previous_node = Node(None)

    if current_node.next == None:
        return False

    if current_node.val == compare_node.val:
        previous_node.next = compare_node.next

        if compare_node.next == None:
            self.tail = previous_node

        self.removeDuplicates()

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
```
## the complexity analysis


The complexity analysis of the provided code can be broken down as follows:

Time Complexity: The code uses recursion to traverse the linked list and remove duplicates. In the worst-case scenario, where all the elements of the linked list are duplicates, the function will traverse the entire list once for each duplicate element. Hence, the time complexity is O(N^2), where N is the number of elements in the linked list.

Space Complexity: The code doesn't use any additional data structures that grow with the input size. The space complexity is O(1), as it only requires a constant amount of additional memory for the function's variables and pointers.

It's important to note that the provided code is a specific implementation and assumes the presence of a linked list class and a Node class with the appropriate methods and attributes.