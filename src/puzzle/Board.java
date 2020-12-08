package puzzle;

import java.util.Random;

public class Board {
    private int[][] Board = new int[4][4];

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
                Board[i][j] = i * 4 + j + 1;
                if (i != 3 || j != 3) Coordinates[i * 4 + j + 1] = new TileCoordinates(j + 1, i + 1);
            }
        }
        Board[3][3] = 0;
        Coordinates[0] = new TileCoordinates(4, 4);
    }

    public int[][] getBoard() {
        return Board;
    }



    public boolean moveUp() {
        if (Coordinates[0].y > 1) {
            int movedTile = Board[Coordinates[0].y - 2][Coordinates[0].x - 1];
            Coordinates[movedTile].y++;
            Coordinates[0].y--;
            Board[Coordinates[0].y - 1][Coordinates[0].x - 1] = 0;
            Board[Coordinates[movedTile].y - 1][Coordinates[movedTile].x - 1] = movedTile;
        }
        else return false;

        return true;
    }

    public boolean moveDown() {
        if (Coordinates[0].y < 4) {
            int movedTile = Board[Coordinates[0].y][Coordinates[0].x - 1];
            Coordinates[movedTile].y--;
            Coordinates[0].y++;
            Board[Coordinates[0].y - 1][Coordinates[0].x - 1] = 0;
            Board[Coordinates[movedTile].y - 1][Coordinates[movedTile].x - 1] = movedTile;
        }
        else return false;

        return true;
    }

    public boolean moveLeft() {
        if (Coordinates[0].x > 1) {
            int movedTile = Board[Coordinates[0].y - 1][Coordinates[0].x - 2];
            Coordinates[movedTile].x++;
            Coordinates[0].x--;
            Board[Coordinates[0].y - 1][Coordinates[0].x - 1] = 0;
            Board[Coordinates[movedTile].y - 1][Coordinates[movedTile].x - 1] = movedTile;
        }
        else return false;

        return true;
    }

    public boolean moveRight() {
        if (Coordinates[0].x < 4) {
            int movedTile = Board[Coordinates[0].y - 1][Coordinates[0].x];
            Coordinates[movedTile].x--;
            Coordinates[0].x++;
            Board[Coordinates[0].y - 1][Coordinates[0].x - 1] = 0;
            Board[Coordinates[movedTile].y - 1][Coordinates[movedTile].x - 1] = movedTile;
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

    public String toString() {
        StringBuilder board = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            board.append("‖");
            for (int j = 0; j < 4; j++) {
               if(Board[i][j] / 10 == 0){
                   board.append(" ");
                   board.append(Board[i][j]);
                   board.append(" ");
               } else board.append(Board[i][j]);


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
