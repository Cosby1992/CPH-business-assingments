

arr2 = [9,3,5,8,11]
arr = [9,3,5]


arr2 = [5,3]

def quick_sort(arr, start_index, end_index):

    if start_index >= end_index: return
    
    pivot = arr[len(arr[start_index:end_index+1])//2]
    pointer_left = start_index
    pointer_right = end_index

    while pointer_left < pointer_right:

        while arr[pointer_left] < pivot and pointer_left < pointer_right:
            pointer_left += 1
        
        while arr[pointer_right] > pivot and pointer_right > pointer_left:
            pointer_right -= 1
        
        if pointer_left < pointer_right:
            temp = arr[pointer_left]
            arr[pointer_left] = arr[pointer_right]
            arr[pointer_right] = temp

    quick_sort(arr, start_index, pointer_left)
    quick_sort(arr, pointer_left, end_index)
    
print(arr)
quick_sort(arr, 0, len(arr)-1)
print(arr)

