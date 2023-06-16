# Sum two inversed linkedlists

## Problem Description
Write code to sum two inversed linkedlist

**list1:**
1, 5, 6 -> 6, 5, 1

**list2**
3, 7, 2 -> 2, 7, 3


**Output:**
651 + 273 

## Code in Python

```python
    def sum_list(list1, list2, carry=None):
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

```

# time complexity and space

The time complexity of the recursive solution to add two linked lists in reverse order is O(max(N, M)), where N and M are the lengths of the two input lists. This is because we traverse through both lists simultaneously, visiting each node once. The maximum length between the two lists determines the number of recursive calls made.

