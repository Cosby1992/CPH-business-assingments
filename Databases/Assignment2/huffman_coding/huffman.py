
# The node class contains a node in the huffman tree
# it consists of a frequency of the letter
# the letter/symbol itself
# a left child
# a right child
class node:
    def __init__(self, frequency, letter, left=None, right=None):
        self.frequency = frequency
        self.letter = letter
        self.left = left
        self.right = right
        self.huff = ''


class huffman_class: 

    # Constructor
    def __init__(self):
        super().__init__()
        self.decompressed_string = ''
    
    # method compresses a string using huffman compression
    # param:string_to_compress string to be compressed
    # param:huffman_tree a tree as a node binary tree structure
    def compress(self, string_to_compress, huffman_tree):
        
        # Get the translator table from the huffman tree
        dictionary_translator_table = {}
        self.create_dictionary_from_huffman_tree(huffman_tree, dictionary=dictionary_translator_table)

        # string to hold the output
        compressed_string = ''

        # iterate through all chars of the string and 
        # append the translated string fx. 'a' --> '0101'
        for char in string_to_compress: 
            compressed_string += dictionary_translator_table[char]

        # return the complete bit string
        return compressed_string
    
    # This method recursively decompresses a string compressed with the huffman compression
    # param:string_to_decompress string to decompress
    # param:node tree structure as node that is updated on recurtion
    # param:original_node original tree to reset node when a letter is found
    def decompress(self, stringToDecompress, node, original_node):

        # run loop as long as it's not an end node
        while node.left or node.right:
            # if the first bit in the string is 0
            # then "move" left in the huffman tree 
            if(stringToDecompress[0] == '0'): 
                node = node.left
                stringToDecompress = stringToDecompress[1:]
            # if the first bit in the string is 1
            # then "move" right in the huffman tree 
            elif(stringToDecompress[0] == '1'):
                node = node.right
                stringToDecompress = stringToDecompress[1:]

        # when loop breaks an end node is found, we know we have the letter
        # concatinate the letter to class variable
        self.decompressed_string += str(node.letter)

        # if the string length is 0 we know we are done and 
        # we can return the resulting decrompressed string
        if (len(stringToDecompress) == 0):
            return str(self.decompressed_string)
        else: 
            # if the string is more than 0 length, reset the node 
            # (start from top node in next recurtion) and move on 
            # to the next letter recursively
            node = original_node
            return self.decompress(stringToDecompress, node, original_node)

    # This method recursively creates a dictionary (tranlation table fx. {'a' --> 01010}) 
    # from a binary huffman tree defined with nodes
    # param:huffman_tree a tree as a node binary tree structure
    # param:val used to append the binary string recusively
    # param:dictionary disctionary to hold the translation table
    def create_dictionary_from_huffman_tree(self, huffman_tree, val='', dictionary={}):
        # huffman code for current node in huffman tree
        node = huffman_tree
        newVal = val + str(node.huff)
    
        # if node is not an edge node
        # recursively append bits
        if(node.left):
            self.create_dictionary_from_huffman_tree(huffman_tree=node.left, val=newVal, dictionary=dictionary)
        if(node.right):
            self.create_dictionary_from_huffman_tree(huffman_tree=node.right, val=newVal, dictionary=dictionary)

        # if the node is an end node we have the value 
        # and can add it to the dictionary as value
        # with the letter as the key
        if(not node.left and not node.right):
            dictionary[node.letter] = newVal

    # Creates a huffman tree structure from a array of nodes
    # param:node_array an array of nodes
    def create_huffman_tree_from_node_array(self, node_array):

        # while theres more nodes in the array
        while(len(node_array) > 1):

            # Sort the array in acending order by their frequency
            node_array = sorted(node_array, key=lambda node: node.frequency)

            # get the lowest frequency nodes
            left = node_array[0]
            right = node_array[1]

            # set their "huff" (number that tells weather it's left or right node)
            left.huff = 0
            right.huff = 1

            # Create new node with lowest frequency nodes as left an right child nodes
            # The new node is named after it's left and right childs names combined 
            # The new node also has the combined frequency from it's two child nodes
            newNode = node(left.frequency + right.frequency, left.letter + right.letter, left, right)

            # Remove the lowest frequency nodes from the array
            # and then append the new node to the array
            node_array.remove(left)
            node_array.remove(right)
            node_array.append(newNode)

            # next iteration will sort the array again placing 
            # the new node correctly according to frequency

        # return the array (structured huffman node tree) when loop is done
        return node_array[0]   

    # Generates an array of nodes (with letter and frequency) from a string
    # param:string_to_count the string the convert to a node array
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
    



    
    
