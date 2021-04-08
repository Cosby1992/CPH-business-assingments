# Bloom Filter
This is an implementation of a very simple bloom filter. 
it will take a specified length array of bits<br>

This is very simplified, but it illustrates the point of a Bloom Filter
There's is no calculation of properbility in this project, only add and check methods.

## To run
1. clone this repo or download only this folder as zip using this link https://minhaskamal.github.io/DownGit/#/home?url=https://github.com/Cosby1992/CPH-business-assingments/tree/master/Databases/Assignment2/bloom_filter and unzip the folder.

2. Navigate to the root folder of the project ```Assignment2/bloom_filter/``` or just ```bloom_filter/```

3. In CLI run this command: ```py bloom_filter.py``` 

## Expected output
```
Added 0 to the bit array on index 0
Added 17 to the bit array on index 7
Added 34 to the bit array on index 4
Added 51 to the bit array on index 1
Added 68 to the bit array on index 8
Added 85 to the bit array on index 5
The number 0  probably exists in the array
The number 15  probably exists in the array
The number 33  does not exists in the array
The number 51  probably exists in the array
The number 52  does not exists in the array
The number 68  probably exists in the array
The number 76  does not exists in the array
The number 85  probably exists in the array
The number 125  probably exists in the array
```

## Troubleshoot
Make sure you have python 3 installed<br>
Test by running ```py --version``` in CLI <br>
Expected output: ```Python 3.x.x``` 

If that doesn't work -> download python here: https://www.python.org/downloads/ and follow the installation instructions on the website <br>