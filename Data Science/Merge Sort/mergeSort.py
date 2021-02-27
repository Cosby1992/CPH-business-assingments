

int_array = [9,3,6,5,2,8,5,6,3,4,5,2,9,8,3,2,6,9]
double_array = [6.7, 5.4, 2.7, 2.8, 9.6, 5.6, 7.2, 1.8, 2.2, 3.6]
string_arr = ['q','w','e','r','y','a','s','s','d','f','g','g']

# array_res = merge_array.merge(arr_sort1, arr_sort2)
# print(array_res)           

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



print("------------------- INT MERGE SORT --------------------")
print("Before Merge Sort:")
print(int_array)
merge_sort(int_array)
print('After Merge Sort:')
print(int_array)
print()

print("------------------- DOUBLE MERGE SORT --------------------")
print("Before Merge Sort:")
print(double_array)
merge_sort(double_array)
print('After Merge Sort:')
print(double_array)
print()

print("------------------- STRING MERGE SORT --------------------")
print("Before Merge Sort:")
print(string_arr)
merge_sort(string_arr)
print('After Merge Sort:')
print(string_arr)
print()









