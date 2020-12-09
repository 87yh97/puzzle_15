package puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Solver {

    //ArrayList<int[][]> history = new ArrayList<>();

    PriorityQueue<State> open = new PriorityQueue<>();
    //ArrayList<State> closed = new ArrayList<>();
    HashSet<State> closed = new HashSet<>();

    State initialState;

    State currentState;

    //int currentStep = 0;

    class State implements Comparable<State>{
        State prevState;
        //State nextState;
        int[] board;
        int metric;
        int stateMetric;
        int currentStep;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return Arrays.equals(board, state.board);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(board);
        }

        public State(int[] board, State prevState, int currentStep) {
            this.board = board.clone();
            this.currentStep = currentStep;
            stateMetric = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
//                    if (i == 3 && j == 3) {
//                        //if (board[i * 4 + j] != 0) stateMetric++;
//                    } else if (board[i * 4 + j] != i * 4 + j + 1) stateMetric++;
                    if (board[i * 4 + j] != i * 4 + j + 1) {
                        if (board[i * 4 + j] == 0) {
                            stateMetric += (3 - i) + (3 - j);
                        } else
                            stateMetric += (Math.abs((((board[i * 4 + j] - 1) / 4) - i)) + Math.abs((((board[i * 4 + j] - 1) % 4) - j)));
                    }
                }
            }
            metric = stateMetric + stateMetric / 2 + currentStep;
            this.prevState = prevState;
        }

        public boolean isFinal() {
            return stateMetric == 0;
        }

        public boolean equal(State state) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (board[i * 4 + j] != state.board[i * 4 + j]) return false;
                }
            }
            return true;
        }

        @Override
        public int compareTo(State state) {
            return Integer.compare(metric, state.metric);
        }
    }


    public Solver(int[] board) {
        initialState = new State(board, null, 0);
        //initialState.lastState = null;
        //initialState.board = board;
        //initialState.metric = 0;
        currentState = initialState;
        closed.add(currentState);
    }

    public ArrayList<int[]> solve() {
        open.add(initialState);

        while(!currentState.isFinal()) {
            closed.add(currentState);
            currentState = open.poll();

            assert currentState != null;
            int currentStep = currentState.currentStep;
            //System.out.println(new Board(currentState.board).toString());
            Board currentBoard = new Board(currentState.board);
            ArrayList<int[]> moves = currentBoard.getMoves();
            point: for (int[] move : moves) {
                State newState = new State(move, currentState, currentStep + 1);
//                if (currentState != initialState ) {
//                    State prev = currentState.prevState;
//                    while (prev != null) {
//                        if (newState.equal(prev)) continue point;
//                        prev = prev.prevState;
//                    }
//                }
//                for (State prev : closed) {
//                    if (newState.equal(prev)) continue point;
//                }
                if (closed.contains(newState)) continue;
                open.add(newState);
            }
            //System.out.println(currentState.stateMetric);
            //System.out.println(currentState.metric);
            //System.out.println("IM STUCK");
        }

        ArrayList<int[]> solution = new ArrayList<>();

        while(currentState != null) {
            solution.add(currentState.board);
            currentState = currentState.prevState;
        }

        return solution;
    }

}
