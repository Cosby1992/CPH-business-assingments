
# This is an implementation of a very simple bloom filter. 
# it will take a specified length array of bits
#
# This is very simplified, but it illustrates the point of a Bloom Filter
# There's is no calculation of properbility in this project, only add and check methods.

# add a value to the bloom filter
def add(array, inputToBeHashedAndAddedToArray):

    bitIndex = inputToBitIndex(len(array), inputToBeHashedAndAddedToArray) 

    array[bitIndex] = 1

    return bitIndex

# Check if there is a probability that the object exists in the bloom filter
def check(array, valueToCheckIfExistsInArray):
    
    return True if array[inputToBitIndex(len(array), valueToCheckIfExistsInArray)] == 1 else False


# Get the bit to check or set from a value
def inputToBitIndex(array_len, value):

    hashedInput = hash(value)
    index = hashedInput % array_len
    return index


## TESTING THE VERY SIMPLE BLOOM FILTER

# Defining an array representing bits (1 or 0)
array = [0,0,0,0,0,0,0,0,0,0]

for i in range(0, 100, 17):
    idx = add(array, i)
    print("Added", i, "to the bit array on index", idx)

# Added 0 to the bit array on index 0
# Added 17 to the bit array on index 7
# Added 34 to the bit array on index 4
# Added 51 to the bit array on index 1
# Added 68 to the bit array on index 8
# Added 85 to the bit array on index 5

# Checking some numbers to test if the bloom filter calculates correct
numbersToCheck = [0,15,33,51,52,68,76,85,125]
# Expected output: True, unknown, unknown, True, unknown, True, unknown, True,  unknown

for number in numbersToCheck:
    exists = check(array, number)
    if exists: 
        print("The number", number, " probably exists in the array") 
    else: 
        print("The number", number, " does not exists in the array")

# The number 0  probably exists in the array
# The number 15  probably exists in the array
# The number 33  does not exists in the array
# The number 51  probably exists in the array
# The number 52  does not exists in the array
# The number 68  probably exists in the array
# The number 76  does not exists in the array
# The number 85  probably exists in the array
# The number 125  probably exists in the array

# You can now see that we got a few false positives, but overall a good result. 