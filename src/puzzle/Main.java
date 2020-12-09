package puzzle;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
//        int[] b = {2,1,7,4,5,6,8,12,9,11,10,0,13,14,3,15};
//        int isSolv = 0;
//        for (int i = 0; i < 16; i++) {
//            for (int j = i; j < 16; j++) {
//                if (b[j] == 0) continue;
//                if (b[i] > b[j]) isSolv++;
//            }
//        }
//        System.out.println(isSolv);
        for (int p = 0; p < 10; p++) {
            Board board = new Board();
            if (!board.shuffle()) return;
            System.out.println("INITIAL STATE=========================================================");
            System.out.println(board.toString());
            System.out.println("INITIAL STATE=========================================================");
            System.out.println();
            System.out.println();
            System.out.println();

            Solver solver = board.getSolver();
            long start = System.currentTimeMillis();
            ArrayList<int[]> solution = solver.solve();
            long stop = System.currentTimeMillis();
            for (int i = solution.size() - 1; i >= 0; i--) {
                int[] tempBoard = solution.get(i);
                int stateMetric = 0;
                for (int k = 0; k < 4; k++) {
                    for (int j = 0; j < 4; j++) {
                        if (k == 3 && j == 3) {
                            //if (board[i * 4 + j] != 0) stateMetric++;
                        } else if (tempBoard[k * 4 + j] != k * 4 + j + 1) stateMetric++;
                    }
                }
//                System.out.println(stateMetric);
//                Board boardClass = new Board(tempBoard);
//                System.out.println(boardClass.toString());
//                System.out.println(solution.size() - 1 - i);
//                System.out.println("READY ");
            }
            System.out.println("NUMBER OF STEPS: " + solution.size());
            System.out.println("TIME: " + (stop - start) / 1000 / 60 + "." + (stop - start) / 1000 % 60);

        }
//        int[][] arr = new int[2][2];
//        arr[0][0] = 0;
//        arr[0][1] = 0;
//        arr[1][0] = 0;
//        arr[1][1] = 0;
//        test(arr);
    }

    static void test(int[][] arr) {
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[1][0] = 3;
        arr[1][1] = 4;

    }
}
