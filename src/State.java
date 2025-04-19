package src;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class State {

    private boolean acceptingState;
    private Map<Character, List<State>> states;

    public State() {
        this.states = new HashMap<>();
    }

    public boolean getAcceptingState() {
        return acceptingState;
    }

    public void setAcceptingState(boolean newValue) {
        acceptingState = newValue;
    }

    public void addTransitionForSymbol(Character symbol, State state) {

        List<State> stateArray = states.get(symbol);

        if (stateArray != null) {
            stateArray.add(state);
        } else {
            states.put(symbol, new ArrayList<State>());
            states.get(symbol).add(state);
        }
    }

    public List<State> getTransitionsForSymbol(Character symbol) {
        return states.get(symbol);
    }

    public boolean test(String string) {
        return false;
    }
}
