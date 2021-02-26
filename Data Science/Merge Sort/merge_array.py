def merge(arr, arr2):
    
    print("Input merge arr: " + str(arr) + " arr2: " + str(arr2))

    pointer = 0
    pointer2 = 0
    merged_arr = []

    while len(arr) > pointer and len(arr2) > pointer2:
        if arr[pointer] <= arr2[pointer2]:
                merged_arr.append(arr[pointer])
                pointer += 1
        else:
            merged_arr.append(arr2[pointer2])
            pointer2 += 1
    
    while len(arr) > pointer:
        merged_arr.append(arr[pointer])
        pointer += 1
    
    while len(arr2) > pointer2:
        merged_arr.append(arr2[pointer2])
        pointer2 += 1


    print("MERGED ARRAY: " + str(merged_arr))
    return merged_arr