# Shakespears collected works 
This repository contains code that can read a file, sanitize it for bad symbols and spaces etc. Then it has four sorting algorithms to sort all the words from the file. Afterwords there is two methods of searching through the words.

## Sorting and searching
**Sorting algorithms:** Heap Sort, Merge Sort, Insertion Sort, Selection Sort <br>
**Search Methods:** Trie dictionary and Binary Search

## Language
Python

## To run
1. Clone this repository
2. Run SnakeSpear.py 

## Change sorting algorithm
Edit SnakeSpear.py to use another sorting algorithm on line 33-39

## Files
1. heap, merge, insertion and selection sorting algorithms is in respectively called python files
2. Binary search is same name python file
3. Trie is in individual file, implemented as a class
4. Everything is imported in the SnakeSpear file, whitch is used as main file
5. Shake.txt has shakespears complete works. Copyright and info in top and bottom has been removed. The rest is sanitized in the code.

## Expected output
```
####Starting Program####
Starting sorting timer...
Sorting 899449 items.
Sorting took 3.4455763000000004s
Looking if the words 'bamboozle','to', 'be', 'or' and 'not' exists in the Trie Dictionary(False, True, True, True, True)
Looking up the first index in a binary search for the word 'horse' 329301
Looking up the word on that index, which is... horse
```
