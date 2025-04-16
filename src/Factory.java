package src;

/**
 * Convenient class for constructing different NFA machines.
 */
public class Factory {

    /**
     * Single character machine: /^ab$/.
     */
    public static NFA character(String symbol) {
        State input = new State();
        State output = new State();
        output.setAcceptingState(false);
        input.addTransitionForSymbol(symbol, output);
        return new NFA(input, output);
    }

    /**
     * The empty string or epsilon transition.
     */
    public static NFA epsilon() {
        return character("Ɛ");
    }

    /**
     * Concatenation of an arbitrary number of character machines: /^ABCD$/
     */
    public static NFA concatenation(NFA first, NFA... rest) {
        NFA accumulator = first;
        for (NFA next : rest) {
            accumulator = pairConcatenation(accumulator, next);
        }
        return accumulator;
    }

    /**
     * Concatenation of two character machines: /^AB$/
     */
    private static NFA pairConcatenation(NFA left, NFA right) {
        State leftOutputState = left.getOutputState();
        State rightIntputState = right.getInputState();
        State rightOutputState = right.getOutputState();
        leftOutputState.setAcceptingState(false);
        rightOutputState.setAcceptingState(true);
        leftOutputState.addTransitionForSymbol("Ɛ", rightIntputState);
        return new NFA(leftOutputState, rightOutputState);
    }

}
