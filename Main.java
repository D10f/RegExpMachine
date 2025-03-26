import java.util.List;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        State s1 = new State("A", false);
        State s2 = new State("B", false);
        State s3 = new State("C", true);

        s1.addTransitionForSymbol("a", s2);
        s2.addTransitionForSymbol("b", s3);
        List<State> states = s2.getTransitionsForSymbol("b");

        for (State state : states) {
            System.out.println(state.getName());
        }
    }
}
