# is Palindrome?

## Problem Description
given a root of linkedlist, check if is palindrome

**Input:**
1, 2, 1, 3

**Output:**
False


**Input**

1, 2, 2, 1

**Output**
True

## Code in Python

```python
    # iterative way
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
```

## time and space complexity
The code has a time and space complexity of O(n), where "n" is the number of elements in the list. Let's analyze the code in more detail:

Time Complexity:

The first while loop iterates over the linked list and appends the values to a vector. This requires traversing all the elements in the list, resulting in O(n) time complexity, where "n" is the number of elements in the list.
The second for loop iterates over the vector and compares the elements from the beginning and the end to check if it is a palindrome. Since the vector contains all the elements from the list, this loop also has a time complexity of O(n), where "n" is the number of elements in the list.
Therefore, the total time complexity is O(n).

Space Complexity:

The vector is initialized, and all the elements from the list are stored in it. Therefore, the space occupied by the vector is proportional to the number of elements in the list, resulting in O(n) space complexity, where "n" is the number of elements in the list.
Therefore, the total space complexity is also O(n).

