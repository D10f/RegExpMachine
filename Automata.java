public class Automata {

    private State inputState;
    private State outputState;

    public Automata(State input, State output) {
        this.inputState = input;
        this.outputState = output;
    }

    public State getInputState() {
        return inputState;
    }

    public State getOutputState() {
        return outputState;
    }

    public void setInputState(State newInputState) {
        inputState = newInputState;
    }

    public void setOutputState(State newOutputState) {
        outputState = newOutputState;
    }

    /**
     * Tests whether this NFA matches the input string.
     * Delegates to the input state.
     */
    // public String test(String str) {
    // return inputState.test(str);
    // }
}
