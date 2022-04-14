import java.util.ArrayList;
import java.util.*;

public class Graph {

    ArrayList<State> states = new ArrayList<>(); 
    public final State START;
    public State currentState;

    public Graph(){
        START = new State();
    }

    private class State{

        HashMap<String,State> neighbors;

        public State(HashMap neighborList){
            neighbors = neighborList;
        }

        public State(){

        }
    }
    
}
