def merge_sort(arr):

    if len(arr) > 1:

        # finding array center (midpoint)
        m = len(arr)//2

        # Splitting array in left and right parts
        split_left = arr[:m]
        split_right = arr[m:]

        # Sorting left recursive
        merge_sort(split_left)
        # Sorting right recursive
        merge_sort(split_right)

        # print("---------------------------------------------------------------------------")    
        # print("PRE MERGE: split_left: " + str(split_left) + " Split right: " + str(split_right))

        # Pointers to keep track of array indexes
        pointer_left = 0
        pointer_right = 0
        arr_pos = 0

        # Merging left_split and right_split til one is empty
        while len(split_left) > pointer_left and len(split_right) > pointer_right:
            if split_left[pointer_left] < split_right[pointer_right]:
                arr[arr_pos] = split_left[pointer_left]
                pointer_left += 1
            else:
                arr[arr_pos] = split_right[pointer_right]
                pointer_right += 1
            arr_pos += 1
        
        # If left has elements, fill them in
        while len(split_left) > pointer_left:
            arr[arr_pos] = split_left[pointer_left]
            pointer_left += 1
            arr_pos += 1
        
        # if right has elements, fill them in
        while len(split_right) > pointer_right:
            arr[arr_pos] = split_right[pointer_right]
            pointer_right += 1
            arr_pos += 1

