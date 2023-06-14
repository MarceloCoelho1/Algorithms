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
```
