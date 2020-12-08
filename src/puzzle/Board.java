package puzzle;

public class Board {
    private int[][] Board = new int[4][4];

    public Board() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Board[i][j] = i * 4 + j + 1;
            }
        }
        Board[3][3] = 0;
    }

    public int[][] getBoard() {
        return Board;
    }

    //public

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
