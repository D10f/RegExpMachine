package src;

/**
 * Convenient class for constructing different NFA machines.
 */
public class Factory {

    /**
     * Single character machine: "a".
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
        return character("e");
    }
}
