package src;

/**
 * Basic NFA Fragment - Single character class
 */
public class NFA {

    private State input;
    private State output;

    public NFA(State input, State output) {
        this.input = input;
        this.output = output;
    }

    public State getInputState() {
        return input;
    }

    public State getOutputState() {
        return output;
    }

    public boolean test(String string) {
        return input.test(string);
    }
}
