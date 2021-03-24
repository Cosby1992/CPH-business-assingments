package com.company;

/**
 * Alphabet interface, includes:
 * indexOf, returns the integer of a specific symbol
 * symbolOf, returns a character from a symbol
 * size, returns the size of the alphabet.
 */
public interface Alphabet {
    int indexOf(char symbol);
    char symbolOf(int index);
    int size();
}
