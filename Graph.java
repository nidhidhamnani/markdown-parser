import java.util.ArrayList;

import javax.sound.sampled.SourceDataLine;
import javax.swing.plaf.nimbus.State;

import java.util.*;

public class Graph {

    ArrayList<State> states = new ArrayList<>(); 
    public final State START;
    public State currentState;
    ArrayList<String> links = new ArrayList<>();

    public Graph(){
        START = new State("Start");
        currentState = START;

        State linkBracketState = new State("Bracket");
        CheckState linkCheckParenState = new CheckState("Paren");
        ReadState linkReadParenState = new ReadState("Read");
        CheckState imageState = new CheckState("Image");

        HashMap<String, State> startNeighbors = new HashMap<>();
        startNeighbors.put("[", linkBracketState);
        startNeighbors.put("!", imageState);

        HashMap<String, State> linkBracketNeighbors = new HashMap<>();
        linkBracketNeighbors.put("]", linkCheckParenState);
        linkBracketNeighbors.put("\n", START);

        HashMap<String, State> linkCheckParenNeighbors = new HashMap<>();
        linkCheckParenNeighbors.put("(", linkReadParenState);
        
        HashMap<String, State> linkReadParenNeighbors = new HashMap<>();
        linkReadParenNeighbors.put(")", START);
        linkReadParenNeighbors.put("\n", START);

        HashMap<String, State> imageNeighbors = new HashMap<>();

        START.setupNeighbors(startNeighbors);
        linkBracketState.setupNeighbors(linkBracketNeighbors);
        linkCheckParenState.setupNeighbors(linkCheckParenNeighbors);
        linkReadParenState.setupNeighbors(linkReadParenNeighbors);
        imageState.setupNeighbors(imageNeighbors);
    }

    public ArrayList<String> getLinks(String str){
        for(int i = 0; i < str.length(); i++){
            currentState.moveToNeighbor(""+ str.charAt(i));
        }
        return links;
    }

    private class State{

        HashMap<String,State> neighbors;
        String name;

        public State(HashMap neighborList){
            neighbors = neighborList;
        }

        public State(String name){
            neighbors = new HashMap<>();
            this.name = name;
        }

        public void moveToNeighbor(String s){
            State moveTo = neighbors.get(s);
            if(moveTo != null){
                currentState = moveTo;
            }
        }

        public void setupNeighbors(HashMap<String, State> map){
            neighbors = map;
        }
    }

    private class CheckState extends State{

        public CheckState(String name){
            super(name);
        }

        public void moveToNeighbor(String s){
            State moveTo = neighbors.get(s);
            if(moveTo != null){
                currentState = moveTo;
            }else{
                currentState = START;
            }
        }
    }

    private class ReadState extends State{

        public String value = "";

        public ReadState(String name){
            super(name);
        }

        public void moveToNeighbor(String s){
            State moveTo = neighbors.get(s);
            if(moveTo != null){
                currentState = moveTo;
                reset();
            }else{
                value+=s;
            }  
        }

        public void reset(){
            links.add(value);
            value = "";
        }

    }
    
}
