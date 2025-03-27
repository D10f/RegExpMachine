import java.util.List;

public class AutomataFactory {
    public Automata createNFA(State input, State output) {
        return new Automata(input, output);
    }

    public Automata concatNFA(Automata first, Automata... rest) {
        for (Automata second : rest) {
            first = _concatNFA(first, second);
        }
        return first;
    }

    private Automata _concatNFA(Automata first, Automata second) {
        State firstOutputState = first.getOutputState();
        State secondOutputState = second.getOutputState();

        firstOutputState.setAccepting(false);
        firstOutputState.addTransitionForSymbol("", second.getInputState());

        secondOutputState.setAccepting(true);

        return new Automata(first.getInputState(), secondOutputState);
    }

    public Automata disjunctionNFA(Automata... rest) {
        State newInput = new State("q0", false);
        State newOutput = new State("q1", true);
        Automata result = createNFA(newInput, newOutput);

        for (Automata automata : rest) {
            State input = automata.getInputState();
            State output = automata.getOutputState();
            newInput.addTransitionForSymbol("", input);
            output.addTransitionForSymbol("", newOutput);
            output.setAccepting(false);
        }

        return result;
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
