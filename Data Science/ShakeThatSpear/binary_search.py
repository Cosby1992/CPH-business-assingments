
# Returns index of search argument in arr if present, else -1
def binary_search(arr, search):
    return binary_search_recursive(arr, 0, len(arr), search)
    
# Calls itself recursively until search is found 
def binary_search_recursive(arr, low, high, search):

    if high >= low:

        mid = (high + low) // 2

        if arr[mid] == search:
            return mid
        
        elif arr[mid] > search:
            return binary_search_recursive(arr, low, mid-1, search)
        
        else:
            return binary_search_recursive(arr, mid + 1, high, search)
    else:
        return -1

# Example
# Given a sorted array
#arr = ['an', 'be', 'circus', 'cycle', 'dance', 'elephant', 'fantastic', 'zebra']

# Returns the index of the searched item or -1
#result = binary_search(arr, 'circus')

#print(result)
# OUTPUT: 2