public class Main {
    public static void main(String[] args) {
        State s1 = new State("A", false);
        State s2 = new State("B", false);

        AutomataFactory factory = new AutomataFactory();
        Automata m1 = factory.createNFA(s1, s2);

        System.out.println(m1.getInputState().getName());

        // s1.addTransitionForSymbol("a", s2);
        // s2.addTransitionForSymbol("b", s3);
        // List<State> states = s2.getTransitionsForSymbol("b");
        //
        // for (State state : states) {
        // System.out.println(state.getName());
        // }
    }
}
