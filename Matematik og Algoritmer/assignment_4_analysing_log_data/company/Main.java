package com.company;

import org.w3c.dom.ls.LSOutput;

public class Main {

    public static void main(String... args) {


        Automaton automaton = new UseAutomaton();
        //word to check if it fits the following regular expression A(B|C)*D
        String word = "abbcccccbbbc";
        //get our inital state
        State state = automaton.getInitialState();
        System.out.println("state"+state.getIndex());

        //iterate through the symbols in the word
        for (char symbol : word.toCharArray()) {
            if (state == null) System.out.println(word+" does not match");
            //check if there is a state based on the symbol
            state = automaton.nextState(state, symbol);
            System.out.println(state!=null ? "State"+state.getIndex() : "State is null");
        }
        //State is null if it does not match the regular expression.
        if (state == null) System.out.println(word+" does not match");
        // if the state is a final state, you had a complete match
        else if (state.isFinal()) System.out.println("You had a match");
        // if the state is not a final state and the word is compliant to the regular expression A(B|C)*D, there is a partial match.
        else System.out.println("Partially match");
    }
}
