package puzzle;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        Board board = new Board();
        board.shuffle();
        Solver solver = board.getSolver();
        ArrayList<int[][]> solution = solver.solve();
        for (int[][] tempBoard : solution) {
            Board boardClass = new Board(tempBoard);
            System.out.println(boardClass.toString());
        }
    }
}
