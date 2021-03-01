

arr = [9,3,5,8,11]
arr2 = [9,3,5]


##arr2 = [5,3]

def quick_sort(arr, start_index, end_index):
    print(f" values in sort { start_index,end_index} and array in the range {arr[start_index:end_index], len(arr[start_index:end_index])}")
    if start_index >= end_index : return

    pivotarray = arr[start_index:end_index]
    print(f"Pivotarray : {pivotarray} length spot : { len(arr[start_index:end_index])//2}")
    pivot = pivotarray[len(arr[start_index:end_index])//2]
    pointer_left = start_index
    pointer_right = end_index

    while pointer_left < pointer_right:
        print(f"pivot : {pivot}")
        while arr[pointer_left] < pivot and pointer_left < pointer_right:
            pointer_left += 1

        print(f"pointer right value : {arr[pointer_right]}")

        while arr[pointer_right] > pivot and pointer_left < pointer_right:
            pointer_right -= 1

        print(f"pointer left value : {arr[pointer_left]}")

        if pointer_left < pointer_right:
            temp = arr[pointer_left]
            arr[pointer_left] = arr[pointer_right]
            arr[pointer_right] = temp

    print(f"Pre Left quick sort ---- start index : {start_index} pointerleft: {pointer_left}")

    quick_sort(arr, start_index, pointer_left-1)


    print(f"Pre Right quick sort ---- start index : {start_index} pointerleft: {pointer_left}")
    quick_sort(arr, pointer_left+1, end_index)
    
print(arr)
quick_sort(arr, 0, len(arr)-1)
print(arr)

