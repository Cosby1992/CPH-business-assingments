
stringToCompress = "beebs beepps!!!!!  their eerie ears hear pears"

# e14 = 25 (internal node)
# 10-11 = 21 (internal node)
# 7" "= 14 (internal node) (used)
# "e" = 11 (used)
#  !6 = 11 (internal node) (used)
#  5r = 10 (internal node) (used)
# " " = 7 (used)
#  as = 7 (internal node) (used)
#  pb = 6 (internal node) (used)
# "!" = 5 (used)
# "r" = 5 (used)
# 3h  = 5 (internal node) (used)
# "s" = 4 (used)
# "a" = 3 (used)
# "b" = 3 (used)
# "p" = 3 (used)
#  ti = 3 (internal node) (used)
# "h" = 2 (used)
# "i" = 2 (used)
# "t" = 1 (used)

# The node class contains a node in the huffman tree
# it consists of a frequency of the letter
# the letter/symbol itself
# a left child
# a right child
class node:
    def __init__(self, frequency, letter, left=None, right=None):
        super().__init__()
        self.frequency = frequency
        self.letter = letter
        self.left = left
        self.right = right
        self.huff = ''


class huffman_coding: 

    def __init__(self):
        super().__init__()
    
    def compress(self, stringToCompress):
        return 0
    
    def decompress(self, stringToDecompress):
        return 0
    
    def create_huffman_tree_from_node_array(self, node_array):

        if(len(node_array) == 1): 
            return node_array[0]
        
        node_array = sorted(node_array, key=lambda node: node.frequency)
        
        left = node_array[0]
        right = node_array[1]

        newNode = node(left.frequency + right.frequency, left.letter + right.letter, left, right)

        node_array.remove(left)
        node_array.remove(right)
        node_array.append(newNode)

        create_huffman_tree_from_node_array(node_array)
        

    def count_letter_occurences(self, stringToCount):
        # convert string to a char array fx. ['c','e','c','e','e']
        arr = list(stringToCount)
        # sort fx. ['c','c','e','e','e']
        arr.sort()

        # list to countain nodes with letters and frequencies
        letterFrequency = []
        # frequency counter
        count = 0

        # iterate through sorted array of letters
        for i in range(len(arr)):

            # increment counter for each occurence
            count +=1 

            # When the next letter is not the same or it's the last index
            # add the letter and frequency to a node and append it to the 
            # list and reset the counter
            if((i+1 < len(arr) and arr[i+1] != arr[i]) or i == (len(arr)-1)):
                letterFrequency.append(node(count, arr[i]))
                count = 0
        
        # Sort the nodes in the array according to frequency (lowest first) fx. [Node(2, c), Node(3, e)]
        sortedNodeArray = sorted(letterFrequency, key=lambda item: item.frequency)

        # return the sorted array of nodes fx. [Node(2, c), Node(3, e)]
        return sortedNodeArray
    

huffman = huffman_coding()

nodes = huffman.count_letter_occurences(stringToCompress)

tree = huffman_coding.create_huffman_tree_from_node_array(nodes)

print(tree)

    
    
