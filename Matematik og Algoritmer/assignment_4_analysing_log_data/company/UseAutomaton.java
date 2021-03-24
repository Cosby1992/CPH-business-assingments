package com.company;

import java.util.ArrayList;
import java.util.List;

public class UseAutomaton implements Automaton {
    private final Alphabet alphabet = new UseAlphabet();
    private final List<State> states = new ArrayList<>();
    private final State[][] stateTable;
    private final State initialState;

    public UseAutomaton() {
        //initialize the initial state and add to the list of states
        initialState = new UseState(0,false);
        states.add(initialState);

        //loop through indexes and create states
        for (int index = 1; index < 3; index++){
            //let the last state be the final state
            if (index == (2)) states.add(new UseState(index,true));
            else states.add(new UseState(index, false));
        }

        //create a 2d array, and add the states
        stateTable = new State[states.size()][alphabet.size()];

        //automaton based on "A(B|C)*D"
        stateTable[0][0] = states.get(1);
        stateTable[1][1] = states.get(1);
        stateTable[1][2] = states.get(1);
        stateTable[1][3] = states.get(2);
    }

    @Override
    public Alphabet getAlphabet() {
        return alphabet;
    }

    @Override
    public List<State> getStates() {
        return states;
    }

    @Override
    public State getInitialState() {
        return initialState;
    }

    //returns the state from the state Table, based on the current state and symbol.
    @Override
    public State nextState(State state, char symbol) {
        return stateTable[state.getIndex()][alphabet.indexOf(symbol)];
    }
}
