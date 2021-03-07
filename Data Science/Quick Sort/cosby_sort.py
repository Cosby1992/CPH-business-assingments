

arr = [9,8,7,65,9,9,9,9,9,9,5,4,3,9,2,1,0,9,4,3,2,1,9,8,7,6,5,4,3,2,1]


def quick_sort(arr, start, end):

    if start >= end: return
    if len(arr[start:end]) < 2: return
    

    p_left = start
    p_right = end
    pivot_index = (start+end)//2
    pivot = arr[pivot_index]

    

    while p_left < p_right:

        while arr[p_left] < pivot:
            p_left += 1
        
        while arr[p_right] > pivot:
            p_right -= 1
        
        if p_left < p_right:
            temp = arr[p_left]
            arr[p_left] = arr[p_right]
            arr[p_right] = temp

            p_left += 1
            p_right -= 1
        
    if len(arr[start:p_left]) == 2: return

    
    swab(arr, pivot_index, p_left-1)
    print(len(arr[start:p_left]))
    quick_sort(arr, start, p_left)
    quick_sort(arr, p_left, end)


def swab(arr, index1, index2):
    temp = arr[index1]
    arr[index1] = arr[index2]
    arr[index2] = temp


print(arr)
quick_sort(arr, 0, len(arr)-1)
print(arr)
# indexes = []
# for i in range(len(arr)):
#     indexes.append(i)
# print(indexes)