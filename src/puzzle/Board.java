package puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Board {
    private int[] board = new int[16];

    private class TileCoordinates {
        public int x;
        public int y;

        TileCoordinates(int x, int y) {
              this.x = x;
              this.y = y;
        }
    }

    private final TileCoordinates[] Coordinates = new TileCoordinates[16];

    public Board() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i * 4 + j] = i * 4 + j + 1;
                if (i != 3 || j != 3) Coordinates[i * 4 + j + 1] = new TileCoordinates(j + 1, i + 1);
            }
        }
        board[15] = 0;
        Coordinates[0] = new TileCoordinates(4, 4);
    }

    public Board(int[] board) {
        this.board = board.clone();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //board[i][j] = i * 4 + j + 1;
                Coordinates[board[i * 4 + j]] = new TileCoordinates(j + 1, i + 1);
            }
        }
//        board[3][3] = 0;
//        Coordinates[0] = new TileCoordinates(4, 4);
    }

    public int[] getBoard() {
        return board.clone();
    }

//    public void setBoard(int[][] board) {
//        this.board = board;
//    }

    public boolean moveUp() {
        if (Coordinates[0].y > 1) {
            int movedTile = board[(Coordinates[0].y - 2) * 4 + (Coordinates[0].x - 1)];
            Coordinates[movedTile].y++;
            Coordinates[0].y--;
            board[(Coordinates[0].y - 1) * 4 + (Coordinates[0].x - 1)] = 0;
            board[(Coordinates[movedTile].y - 1) * 4 + (Coordinates[movedTile].x - 1)] = movedTile;
        }
        else return false;

        return true;
    }

    public boolean moveDown() {
        if (Coordinates[0].y < 4) {
            int movedTile = board[(Coordinates[0].y) * 4 + (Coordinates[0].x - 1)];
            Coordinates[movedTile].y--;
            Coordinates[0].y++;
            board[(Coordinates[0].y - 1) * 4 + (Coordinates[0].x - 1)] = 0;
            board[(Coordinates[movedTile].y - 1) * 4 + (Coordinates[movedTile].x - 1)] = movedTile;
        }
        else return false;

        return true;
    }

    public boolean moveLeft() {
        if (Coordinates[0].x > 1) {
            int movedTile = board[(Coordinates[0].y - 1) * 4 + (Coordinates[0].x - 2)];
            Coordinates[movedTile].x++;
            Coordinates[0].x--;
            board[(Coordinates[0].y - 1) * 4 + (Coordinates[0].x - 1)] = 0;
            board[(Coordinates[movedTile].y - 1) * 4 + (Coordinates[movedTile].x - 1)] = movedTile;
        }
        else return false;

        return true;
    }

    public boolean moveRight() {
        if (Coordinates[0].x < 4) {
            int movedTile = board[(Coordinates[0].y - 1) * 4 + (Coordinates[0].x)];
            Coordinates[movedTile].x--;
            Coordinates[0].x++;
            board[(Coordinates[0].y - 1) * 4 + (Coordinates[0].x - 1)] = 0;
            board[(Coordinates[movedTile].y - 1) * 4 + (Coordinates[movedTile].x - 1)] = movedTile;
        }
        else return false;

        return true;
    }

    public boolean shuffle () {
        Random rand = new Random();
        for (int i = 0; i < 2000; i++) {
            int temp = rand.nextInt(4);
            if (temp == 3) moveRight();
            else if (temp == 2) moveLeft();
            else if (temp == 1) moveDown();
            else if (temp == 0) moveUp();
        }
        int isSolv = 0;
        for (int i = 0; i < 16; i++) {
            for (int j = i; j < 16; j++) {
                if (board[j] == 0) continue;
                if (board[i] > board[j]) isSolv++;
            }
        }
        isSolv += Coordinates[0].y;
        if (isSolv % 2 == 1) {
            System.out.println(isSolv);
            System.out.println("IT IS NOT SOLVABLE");
            System.out.println(toString());
            return false;
        }
        return true;
    }

    public Solver getSolver() {
        return new Solver(board.clone());
    }

    public ArrayList<int[]> getMoves() {
        ArrayList<int[]> moves = new ArrayList<>();
        if (moveUp()) {
            //System.out.println("I MOVED UP");
            moves.add(board.clone());
            moveDown();
        }
        if (moveDown()) {
            //System.out.println("I MOVED DOWN");
            moves.add(board.clone());
            moveUp();
        }
        if (moveLeft()) {
            //System.out.println("I MOVED LEFT");
            moves.add(board.clone());
            moveRight();
        }
        if (moveRight()) {
            //System.out.println("I MOVED RIGHT");
            moves.add(board.clone());
            moveLeft();
        }



        return moves;
    }

    public String toString() {
        StringBuilder board = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            board.append("‖");
            for (int j = 0; j < 4; j++) {
               if(this.board[i * 4 + j] / 10 == 0){
                   board.append(" ");
                   board.append(this.board[i * 4 + j]);
                   board.append(" ");
               } else board.append(this.board[i * 4 + j]);


                board.append("‖");
            }
            board.append(System.getProperty("line.separator"));
            //board.append(Character.charCount(13));
            for (int j = 0; j < 4; j++) board.append(" ═");
            board.append(System.getProperty("line.separator"));
        }
        return board.toString();
    }
}
