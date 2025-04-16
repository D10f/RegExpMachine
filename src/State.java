package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class State {

    private boolean acceptingState;
    private HashMap<String, List<State>> states;

    public State() {
        this.states = new HashMap<>();
    }

    public boolean getAcceptingState() {
        return acceptingState;
    }

    public void setAcceptingState(boolean newValue) {
        acceptingState = newValue;
    }

    public void addTransitionForSymbol(String symbol, State state) {

        List<State> stateArray = states.get(symbol);

        if (stateArray != null) {
            stateArray.add(state);
        } else {
            states.put(symbol, new ArrayList<State>());
            states.get(symbol).add(state);
        }
    }

    public List<State> getTransitionsForSymbol(String symbol) {
        return states.get(symbol);
    }

    public boolean test(String string) {
        return false;
    }
}
