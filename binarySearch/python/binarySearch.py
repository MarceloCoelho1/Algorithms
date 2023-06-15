def binary_search(vector, target, lo=None, hi=None):

    if lo == None:
        lo = 0
        hi = len(vector) - 1

    if lo > hi:
        return -1
    
    mid = int(lo + (hi - lo) / 2)

    if target < vector[mid]:
        return binary_search(vector, target, lo, mid -1)
    elif target > vector[mid]:
        return binary_search(vector, target, mid + 1, hi)
    else:
        return mid


vector = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

print(binary_search(vector, 3))