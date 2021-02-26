import merge_array
import copy

# arr_sort1 = [55,55,105, 200, 600, 1000000]
# arr_sort2 = [10,11,99]

unsorted_int_arr = [9,3,6,5,2,8,5,6,3,4,5,2,9,8,3,2,6,9]
unsorted_double_arr = [6.7, 5.4, 2.7, 2.8, 9.6, 5.6, 7.2, 1.8, 2.2, 3.6]

# array_res = merge_array.merge(arr_sort1, arr_sort2)
# print(array_res)           

def merge_sort(unsorted_arr):

    if len(unsorted_arr) > 1:

        # finding array center (midpoint)
        m = len(unsorted_arr)//2

        # Splitting array in left and right parts
        split_left = unsorted_arr[:m]
        split_right = unsorted_arr[m:]

        # Sorting left recursive
        merge_sort(split_left)
        # Sorting right recursive
        merge_sort(split_right)

        print("---------------------------------------------------------------------------")    
        print("PRE MERGE: split_left: " + str(split_left) + " Split right: " + str(split_right))
        sorted_arr = merge_array.merge(split_left, split_right)

        return sorted_arr

def merge_sortcopy(unsorted_arr):

    temp_arr = copy.deepcopy(unsorted_arr)

    if len(temp_arr) > 1:

        # finding array center (midpoint)
        m = len(temp_arr)//2

        # Splitting array in left and right parts
        split_left = copy.deepcopy(temp_arr[:m])
        split_right = copy.deepcopy(temp_arr[m:])

        # Sorting left recursive
        merge_sort(split_left)
        # Sorting right recursive
        merge_sort(split_right)

        print("---------------------------------------------------------------------------")    
        print("PRE MERGE: split_left: " + str(split_left) + " Split right: " + str(split_right))
        sorted_arr = merge_array.merge(split_left, split_right)

        return sorted_arr

sorted_arr = merge_sort(unsorted_int_arr)
copySorted = merge_sortcopy(unsorted_int_arr)

print(unsorted_int_arr)
print(sorted_arr)
print(copySorted)






