import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class State {

    private String name;
    private boolean accepting;
    private HashMap<String, List<State>> states;

    public State(String name, boolean accepting) {
        this.name = name;
        this.accepting = accepting;
        this.states = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public boolean getIsAccepting() {
        return accepting;
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
}
