package puzzle;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    private int[][] board = new int[4][4];

    private class TileCoordinates {
        public int x;
        public int y;

        TileCoordinates(int x, int y) {
              this.x = x;
              this.y = y;
        }
    }

    private TileCoordinates[] Coordinates = new TileCoordinates[16];

    public Board() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = i * 4 + j + 1;
                if (i != 3 || j != 3) Coordinates[i * 4 + j + 1] = new TileCoordinates(j + 1, i + 1);
            }
        }
        board[3][3] = 0;
        Coordinates[0] = new TileCoordinates(4, 4);
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public boolean moveUp() {
        if (Coordinates[0].y > 1) {
            int movedTile = board[Coordinates[0].y - 2][Coordinates[0].x - 1];
            Coordinates[movedTile].y++;
            Coordinates[0].y--;
            board[Coordinates[0].y - 1][Coordinates[0].x - 1] = 0;
            board[Coordinates[movedTile].y - 1][Coordinates[movedTile].x - 1] = movedTile;
        }
        else return false;

        return true;
    }

    public boolean moveDown() {
        if (Coordinates[0].y < 4) {
            int movedTile = board[Coordinates[0].y][Coordinates[0].x - 1];
            Coordinates[movedTile].y--;
            Coordinates[0].y++;
            board[Coordinates[0].y - 1][Coordinates[0].x - 1] = 0;
            board[Coordinates[movedTile].y - 1][Coordinates[movedTile].x - 1] = movedTile;
        }
        else return false;

        return true;
    }

    public boolean moveLeft() {
        if (Coordinates[0].x > 1) {
            int movedTile = board[Coordinates[0].y - 1][Coordinates[0].x - 2];
            Coordinates[movedTile].x++;
            Coordinates[0].x--;
            board[Coordinates[0].y - 1][Coordinates[0].x - 1] = 0;
            board[Coordinates[movedTile].y - 1][Coordinates[movedTile].x - 1] = movedTile;
        }
        else return false;

        return true;
    }

    public boolean moveRight() {
        if (Coordinates[0].x < 4) {
            int movedTile = board[Coordinates[0].y - 1][Coordinates[0].x];
            Coordinates[movedTile].x--;
            Coordinates[0].x++;
            board[Coordinates[0].y - 1][Coordinates[0].x - 1] = 0;
            board[Coordinates[movedTile].y - 1][Coordinates[movedTile].x - 1] = movedTile;
        }
        else return false;

        return true;
    }

    public void shuffle () {
        Random rand = new Random();
        for (int i = 0; i < 2000; i++) {
            int temp = rand.nextInt(4);
            if (temp == 3) moveRight();
            else if (temp == 2) moveLeft();
            else if (temp == 1) moveDown();
            else if (temp == 0) moveUp();
        }
    }

    public Solver getSolver() {
        return new Solver(board);
    }

    public ArrayList<int[][]> getMoves() {
        ArrayList<int[][]> moves = new ArrayList<>();
        if (this.moveUp()) {
            moves.add(board);
            this.moveDown();
        }
        if (this.moveDown()) {
            moves.add(board);
            this.moveUp();
        }
        if (this.moveLeft()) {
            moves.add(board);
            this.moveRight();
        }
        if (this.moveRight()) {
            moves.add(board);
            this.moveLeft();
        }
        return moves;
    }

    public String toString() {
        StringBuilder board = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            board.append("‖");
            for (int j = 0; j < 4; j++) {
               if(this.board[i][j] / 10 == 0){
                   board.append(" ");
                   board.append(this.board[i][j]);
                   board.append(" ");
               } else board.append(this.board[i][j]);


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
