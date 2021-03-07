
array = ['a', 'z', 't', 'e', 'v', 'u', 'b', 'q', 'z', 'x', 'å', '1', '2', '5', '0', 'f', 'g']

###################### Selection sort ####################
# Sets a pointer at start of the array, then iterates 
# through "rest" of the array finding the lowest value.
# The lowest value is then set at the pointer index.
# This way the interval from start of the array to the
# pointer index will always be sorted and we wil only be
# iterating through the remaining array from the pointer 
# posistion to the end of the array in next iteration.
# 
# @param arr: Array to be sorted
# The method manipulates the array directly and does not
# return a "copy"
###########################################################
def selection_sort(arr):
    
    # index to swab with
    pointer = 0
    
    # until whole array is sorted
    while pointer < len(arr):

        # reset lowest index by assigning pointer index
        lowest_index = pointer

        # Run through array and find lowest value index
        for i in range(pointer, len(array)):
            if arr[lowest_index] > arr[i]:
                lowest_index = i
        
        # Swab lowest index value with next index in array (pointer)
        temp = arr[pointer]
        arr[pointer] = arr[lowest_index]
        arr[lowest_index] = temp

        # Increment pointer
        pointer += 1

print(array)
selection_sort(array)
print(array)