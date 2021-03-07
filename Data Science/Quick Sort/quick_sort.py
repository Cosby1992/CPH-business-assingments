

arr = [1,5,2,3,43,25,7,8,2,3,39,5,8,11,5,7,9,5,97,4,7,23,97,56,43,9]
arr2 = [9,3,5]


##arr2 = [5,3]

def quick_sort(arr, start_index, end_index):
    if start_index > end_index : return

    pivotarray = arr[start_index:end_index+1]
    pivot = pivotarray[len(arr[start_index:end_index])//2]
    pointer_left = start_index
    pointer_right = end_index

    while pointer_left < pointer_right:
        while arr[pointer_left] <= pivot and pointer_left < pointer_right:
            pointer_left += 1

        while arr[pointer_right] > pivot and pointer_left < pointer_right:
            pointer_right -= 1
       # print(f"recursion is {pointer_left , pointer_right} and indexes are { start_index, pointer_left, pointer_left+1, end_index}")

        if pointer_left < pointer_right:
            temp = arr[pointer_left]
            arr[pointer_left] = arr[pointer_right]
            arr[pointer_right] = temp
    quick_sort(arr, start_index, pointer_left-1)
    quick_sort(arr, pointer_left+1, end_index)
    
print(arr)
quick_sort(arr, 0, len(arr)-1)
print(arr)

