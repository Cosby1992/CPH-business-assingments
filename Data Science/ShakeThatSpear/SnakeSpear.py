import time
import re
from mergeSort import merge_sort
from insertionSort import insertionSort
from selection_sort import selection_sort
from heap_sort import heap_sort
from Trie import Trie
from binary_search import binary_search


print('####Starting Program####')
##"opens" the specified file.
file = open("Shake.txt","r")

##Gets the text from the "shake" file and makes it all lowercase
test = file.read()
test = test.lower()

##Regex pattern use to filter out unnecessary characters
pattern = '(?<!\d)[a-z^\'-]+(?!\d)'
## adds all the words in our text to an array, based on the regex pattern
result = re.findall(pattern,test)

##Add every "word" to the trie dictionary:
dictionary = Trie()
for i in range(len(result)):
    dictionary.add(result[i])

##timer start:
print("Starting sorting timer...")
print(f"Sorting {len(result)} items.")
timeStart = time.perf_counter()

## different sorting methods:
merge_sort(result)
##heap_sort(result)

##Slowpokes:
##selection_sort(result)
##insertionSort(result)


##time end
timeEnd = time.perf_counter()
## Sort time duration:
print(f"Sorting took {timeEnd-timeStart}s")

## finds strings in array that contains only "'" or "-"
forDeletion = []
for i in range(len(result)):
    if result[i] == "'":
       forDeletion.append(i)
    if result[i] == "'-":
        forDeletion.append(i)

##Deletes indexes that only contain "'" or "-"
for i in range(len(forDeletion)):
    x = forDeletion[(len(forDeletion)-1)-i]
    del result[x]

##searches the dictionary to find if the specified word exists in it.
print(f"Looking if the words 'bamboozle','to', 'be', 'or' and 'not' exists in the Trie Dictionary{dictionary.find('bamboozle'),dictionary.find('to'),dictionary.find('be'),dictionary.find('or'),dictionary.find('not')}")

##Takes a sorted array and a string, and returns the first index of that word with a binary search
print(f"Looking up the first index in a binary search for the word 'horse' {binary_search(result,'horse')}")
print(f"Looking up the word on that index, which is... {result[binary_search(result,'horse')]}")
