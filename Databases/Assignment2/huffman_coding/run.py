from huffman import huffman_class

# This class is used to demonstrate tho huffman_class
# It compressed and decompresses string according to huffman code

# The message to compress
message = "beebs beepps!!!!!  their eerie ears hear pears"
second_message = "pete is here"

# New instance of huffman coding
huffman = huffman_class()

print("-----------------------------------------------------------------------------")
print("\nOriginal message:", message, "\n")

# Get the tree structure as a node from the message
node_list = huffman.count_letter_occurences(message)
tree_node = huffman.create_huffman_tree_from_node_array(node_list)

# Compress the original message
compressed = huffman.compress(message, tree_node)

# Print data about the compression
print("Lenght of original message:", len(message)*8, "bits")
print("Length of the compressed message:", len(compressed), "bits", "\n")
print("First 40 bits of compressed message:", compressed[0:40], "\n")

# Decrompress the compressed message using the tree structure node
decompressed_message = huffman.decompress(compressed, tree_node, tree_node)

print("Decompressed message:", decompressed_message)

print("\nTranslation table generated:")
translation_table = {}
huffman.create_dictionary_from_huffman_tree(tree_node, dictionary=translation_table)
print(translation_table)

print("\n-----------------------------------------------------------------------------\n")

print("Compressing the second message using the same huffman tree as the first message:\n")
print("message: ", second_message)
print("message length:", len(second_message), "bits\n")

# Compressing the second message using the same tree from the first message 

compressed_second_message = huffman.compress(second_message, tree_node)

print("Second message compressed:", compressed_second_message)
print("Compressed length:", len(compressed_second_message), "bits")

print("\n-----------------------------------------------------------------------------")

self_made_message = "Hej med dig gamle dreng, vil du se et huffman table?"

# Get the tree structure as a node from the message
new_node_list = huffman.count_letter_occurences(self_made_message)
new_tree_node = huffman.create_huffman_tree_from_node_array(new_node_list)

print("\nSelf made massage:", self_made_message, "\n")

new_compressed = huffman.compress(self_made_message, new_tree_node)

print("Compressed:", new_compressed, "\n")
print("Compressed length:", len(new_compressed), "bits\n")

new_translation_table = {}
huffman.create_dictionary_from_huffman_tree(new_tree_node, dictionary=new_translation_table)

print("New translation table: ")
print(new_translation_table)

print("\n-----------------------------------------------------------------------------")