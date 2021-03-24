package com.company;

public class UseAlphabet implements Alphabet {


    //Returns an integer based on the symbol.
    //symbol range : a - e
    //Integer range : 0 - 4
    @Override
    public int indexOf(char symbol) {
        if(symbol < 'a' || 'e' < symbol) throw new IllegalArgumentException("characters must be between a-e");
        return symbol - 'a';
    }

    //Returns character based on the index + the letter a.
    @Override
    public char symbolOf(int index) {
        if (index < 0 || 4 < index) throw new IllegalArgumentException("index must be between 0 and 4");
        return (char)('a' +index);
    }

    //Returns the size of the Index, which is 5
    @Override
    public int size() {
        return 5;
    }
}
