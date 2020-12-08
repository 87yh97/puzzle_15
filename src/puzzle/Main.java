package puzzle;

public class Main {

    public static void main(String[] args) {
	    Board board = new Board();
	    Visualisation visualisation = new Visualisation(board);
	    Visualisation.main(new String[0]);
	    System.out.println(board.toString());
	    board.shuffle();
        System.out.println(board.toString());
//	    board.moveUp();
//        System.out.println(board.toString());
//        board.moveDown();
//        System.out.println(board.toString());
//        board.moveLeft();
//        System.out.println(board.toString());
//        board.moveRight();
//        System.out.println(board.toString());
    }
}
