package puzzle;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solver {

    //ArrayList<int[][]> history = new ArrayList<>();

    PriorityQueue<State> open = new PriorityQueue<>();

    State initialState;

    State currentState;

    //int currentStep = 0;

    class State implements Comparable<State>{
        State prevState;
        //State nextState;
        int[][] board;
        int metric;
        int stateMetric;
        int currentStep;

        public State(int[][] board, State prevState, int currentStep) {
            this.board = board;
            this.currentStep = currentStep;
            stateMetric = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i == 3 && j == 3) {
                        if (board[i][j] != 0) stateMetric++;
                    } else if (board[i][j] != i * 4 + j + 1) stateMetric++;
                }
            }
            metric = stateMetric + currentStep;
            this.prevState = prevState;
        }

        public boolean isFinal() {
            return stateMetric == 0;
        }

        @Override
        public int compareTo(State state) {
            return Integer.compare(metric, state.metric);
        }
    }


    public Solver(int[][] board) {
        initialState = new State(board, null, 0);
        //initialState.lastState = null;
        //initialState.board = board;
        //initialState.metric = 0;
        currentState = initialState;
    }

    public ArrayList<int[][]> solve() {
        open.add(initialState);

        while(!currentState.isFinal()) {
            currentState = open.poll();
            assert currentState != null;
            int currentStep = currentState.currentStep;
            Board currentBoard = new Board(currentState.board);
            ArrayList<int[][]> moves = currentBoard.getMoves();
            for (int[][] move : moves) {
                open.add(new State(move, currentState, currentStep + 1));
            }
            System.out.println("IM STUCK");
        }

        ArrayList<int[][]> solution = new ArrayList<>();

        while(currentState != null) {
            solution.add(currentState.board);
            currentState = currentState.prevState;
        }

        return solution;
    }

}
