package src;

/**
 * Convenient class for constructing different NFA machines.
 */
public class Factory {

    private static char EPSILON = 'Ɛ';

    /**
     * Single character machine: /a/.
     */
    public static NFA character(char symbol) {
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
        return character(EPSILON);
    }

    /**
     * Concatenation of an arbitrary number of machines: /ABCD/
     */
    public static NFA concatenation(NFA first, NFA... rest) {
        NFA accumulator = first;
        for (NFA next : rest) {
            accumulator = pairConcatenation(accumulator, next);
        }
        return accumulator;
    }

    /**
     * Disjunction of an arbitrary number of machines: /A|B|C|D/
     */
    public static NFA union(NFA first, NFA... rest) {
        NFA accumulator = first;
        for (NFA next : rest) {
            accumulator = pairUnion(accumulator, next);
        }
        return accumulator;
    }

    /**
     * Repetition machine aka Kleene closure: /^a*$/
     */
    public static NFA repetition(NFA fragment) {
        State startingState = new State();
        State endingState = new State();
        endingState.setAcceptingState(true);

        State fragmentOutputState = fragment.getOutputState();
        State fragmentInputState = fragment.getInputState();
        fragmentOutputState.setAcceptingState(false);
        fragmentOutputState.addTransitionForSymbol(EPSILON, endingState);

        startingState.addTransitionForSymbol(EPSILON, startingState);
        startingState.addTransitionForSymbol(EPSILON, endingState);
        endingState.addTransitionForSymbol(EPSILON, fragmentInputState);

        return new NFA(startingState, endingState);
    }

    // public static NFA characterClass(char characterClass) {
    //
    // }

    public static NFA plus(NFA fragment) {
        return concatenation(fragment, fragment);
    }

    public static NFA optional(NFA fragment) {
        return union(fragment, epsilon());
    }

    /**
     * Concatenation of two character machines: /AB/
     */
    private static NFA pairConcatenation(NFA left, NFA right) {
        State leftOutputState = left.getOutputState();
        State rightIntputState = right.getInputState();
        State rightOutputState = right.getOutputState();
        leftOutputState.setAcceptingState(false);
        rightOutputState.setAcceptingState(true);
        leftOutputState.addTransitionForSymbol(EPSILON, rightIntputState);
        return new NFA(leftOutputState, rightOutputState);
    }

    /**
     * Disjunction of two machines: /A|B/
     */
    private static NFA pairUnion(NFA left, NFA right) {
        State startingState = new State();
        State endingState = new State();
        endingState.setAcceptingState(true);

        State leftInputState = left.getInputState();
        State leftOutputState = left.getOutputState();
        leftInputState.setAcceptingState(false);
        leftOutputState.setAcceptingState(false);

        State rightInputState = right.getInputState();
        State rightOutputState = right.getOutputState();
        rightInputState.setAcceptingState(false);
        rightOutputState.setAcceptingState(false);

        startingState.addTransitionForSymbol(EPSILON, leftInputState);
        startingState.addTransitionForSymbol(EPSILON, rightInputState);
        leftOutputState.addTransitionForSymbol(EPSILON, endingState);
        rightOutputState.addTransitionForSymbol(EPSILON, endingState);

        return new NFA(startingState, endingState);
    }
}
