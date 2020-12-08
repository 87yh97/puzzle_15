package puzzle;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solver {

    ArrayList<int[][]> history = new ArrayList<>();

    PriorityQueue<State> open = new PriorityQueue<>();

    State currentState = null;

    class State implements Comparable<State>{
        State lastState;
        //State nextState;
        int[][] board;
        int metric;

        public State(int[][] board, State lastState, int prevStepsNum) {
            this.board = board;
            int tempMetric = prevStepsNum;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i == 3 && j == 3) {
                        if (board[i][j] != 0) tempMetric++;
                    } else if (board[i][j] != i * 4 + j + 1) tempMetric++;
                }
            }
            metric = tempMetric;
            this.lastState = lastState;
        }

        @Override
        public int compareTo(State state) {
            return Integer.compare(metric, state.metric);
        }
    }


    public Solver(int[][] board) {
        State initialState = new State(board, null, 0);
        //initialState.lastState = null;
        //initialState.board = board;
        //initialState.metric = 0;
        currentState = initialState;
    }

    public ArrayList<int[][]> solve() {

    }

}
