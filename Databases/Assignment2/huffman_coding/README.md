# Huffman Coding

## Enviroment
Make sure you have python 3 installed<br>
Test by running ```py --version``` in CLI <br>
Expected output: ```Python 3.x.x``` 

If that doesn't work -> download python here: https://www.python.org/downloads/ and follow the installation instructions on the website <br>

## To run
1. clone this repo or download only this folder as zip using this link https://minhaskamal.github.io/DownGit/#/home?url=https://github.com/Cosby1992/CPH-business-assingments/tree/master/Databases/Assignment2/huffman_coding and unzip the folder.

2. Navigate to the root folder of the project ```Assignment2/huffman_coding/```

3. In CLI run this command: ```py run.py``` 

#### Expected output
```
-----------------------------------------------------------------------------

Original message: beebs beepps!!!!!  their eerie ears hear pears

Lenght of original message: 368 bits
Length of the compressed message: 148 bits

First 40 bits of compressed message: 1010010110101111110101001011011101111110

Decompressed message: beebs beepps!!!!!  their eerie ears hear pears

Translation table generated:
{'!': '000', 'r': '001', 'e': '01', 'i': '1000', 'a': '1001', 'b': '1010', 'p': '1011', ' ': '110', 't': '11100', 'h': '11101', 's': '1111'}

-----------------------------------------------------------------------------

Compressing the second message using the same huffman tree as the first message:

message:  pete is here
message length: 12 bits

Second message compressed: 101101111000111010001111110111010100101
Compressed length: 39 bits

-----------------------------------------------------------------------------

Self made massage: Hej med dig gamle dreng, vil du se et huffman table?

Compressed: 1110101001111010001111001011001011110000101000101010001110110100001011111110100110010101111000001010011000011000101111011001111111000010011010001111001101110101101010111010011001001101001001110110110100111001

Compressed length: 208 bits

New translation table:
{' ': '00', 'a': '0100', 'g': '0101', 'l': '0110', 'm': '0111', 'e': '100', 'v': '10100', 'f': '10101', 'd': '1011', 'i': '11000', 'n': '11001', 't': '11010', 'u': '11011', ',': '111000', '?': '111001', 'H': '111010', 'b': '111011', 'h': '111100', 'j': '111101', 'r': '111110', 's': '111111'}

-----------------------------------------------------------------------------
```
## Information
We could not figure out how to turn the translation table into a bit string according to the huffman standard. The compression and decompression uses the Node class witch is build as a huffman tree. 

```huffman.py``` contains the Node and the Huffman class used to compress and decompress messages<br>
```run.py``` contains code to demonstrate the contents of ```huffman.py```

For more information about the specific methods and classes, read the code comments. 


