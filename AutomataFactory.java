public class AutomataFactory {
    public Automata createNFA(State input, State output) {
        return new Automata(input, output);
    }

    public Automata concatNFA(Automata first, Automata second) {
        State firstOutputState = first.getOutputState();
        firstOutputState.setAccepting(false);
        return new Automata(first.getInputState(), second.getOutputState());
    }

    // public NFA BuildNFA(String symbol) {
    //
    // State input = new State("q1", false);
    // State output = new State("q2", true);
    //
    // input.addTransitionForSymbol(symbol, output);
    //
    // return new NFA(input, output);
    // }
    //
    // public NFA concatPair(NFA first, NFA second) {
    // return new NFA(first.initialState, second.finalState);
    // }

}
