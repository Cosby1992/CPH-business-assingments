
array = ['a', 'z', 't', 'e', 'v', 'u', 'b', 'q', 'z', 'x', 'å', '1', '2', '5', '0', 'f', 'g']

# If the index of any element in the array is i, 
# the element in the index 2i+1 will become the 
# left child and element in 2i+2 index will become 
# the right child. Also, the parent of any element 
# at index i is given by the lower bound of (i-1)/2.

def get_left_child(i):
    return 2*i+1

def get_right_child(i):
    return 2*i+2

def get_parent(i):
    return (i-1)//2

# Method that recursively swabs root/parent with 
# bigger child elements until its in the right 
# place in the heap
def heapify(arr, arr_len, current_node):
    parent = current_node
    left_child = get_left_child(current_node)
    right_child = get_right_child(current_node)

    # check if children nodes are bigger than parent
    # then swab to get biggest number as parent 
    if left_child < arr_len and arr[left_child] > arr[parent]:
        parent = left_child
    
    if right_child < arr_len and arr[right_child] > arr[parent]:
        parent = right_child
    
    # swabbing and heapyfing next layer in heap
    if parent != current_node:
        arr[current_node], arr[parent] = arr[parent], arr[current_node]
        heapify(arr, arr_len, parent)

# This method takes an unsorted arr and creates 
# a max-heap of it. The biggest node placed in 
# the top layer and decreasing for each layer
# in the heap
def create_max_heap(arr):
    arr_len = len(arr)
    for i in range(arr_len // 2, -1, -1):
        heapify(arr, arr_len, i)

# Heap sorts an unsorted array.
def heap_sort(arr):

    # create max heap of unsorted array
    create_max_heap(arr)

    # heapify 
    for i in range(len(arr)-1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]

        heapify(arr, i, 0)



print(array)
heap_sort(array)
print(array)