package com.company;

import java.util.List;

/**
 * Automaton interface includes:
 * getAlphabet returns alphabet,
 * getStates, returns a List of States,
 * getInitialState, returns the initial state,
 * nextState, returns a State when given a state and a symbol.
 */
public interface Automaton {
    Alphabet getAlphabet();
    List<State> getStates();
    State getInitialState();
    State nextState(State state, char symbol);
}

