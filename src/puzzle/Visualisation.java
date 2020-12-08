package puzzle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import java.io.IOException;

public class Visualisation extends Application {

    static public Stage stage = null;
    public TilePane root = new TilePane();
    //public static Visualisation thisVis = null;
    //Scene scene;


    Board board;
    //int[][] Board;

    private class Tile extends StackPane{
        private final Double side = 60.0;

        Label numLabel;

        public Tile(Integer num) {
            //Label numLabel;
            if (num == 16) {
                numLabel = new Label("X");}
            else {
                numLabel = new Label(num.toString());
            }
            numLabel.setPrefSize(side, side);
            numLabel.setAlignment(Pos.CENTER);
            Rectangle border = new Rectangle();
            border.setWidth(side);
            border.setHeight(side);
            border.setFill(Color.WHITE);
            border.setStroke(Color.DARKRED);
            //StackPane tile = new StackPane();
            this.getChildren().add(border);
            this.getChildren().add(numLabel);
            //tile.setAlignment(Pos.CENTER);
            this.setPrefSize(side, side);
        }

        public void setNum(Integer num) {
            Label newLabel;
            if (num == 16) {
                numLabel = new Label("X");}
            else {
                numLabel = new Label(num.toString());
            }
//            newLabel.setPrefSize(side, side);
//            newLabel.setAlignment(Pos.CENTER);
            //numLabel
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        root.setPrefRows(4);
        root.setPrefColumns(4);

        int[][] array = board.getBoard();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Integer temp = array[i][j];
                //Integer temp = i * 4 + j + 1;
                StackPane tile = new Tile(temp);
                root.getChildren().add(tile);
            }
        }


        Scene scene = new Scene(root);
        //scene.setRoot(root);
        Visualisation.stage = stage;
        stage.setResizable(false);
        stage.setTitle("15 Puzzle");
        stage.setScene(scene);
        stage.show();

    }


    public Visualisation() {
        board = new Board();
        board.shuffle();
    }

//    public void setBoard(Board board) {
//        this.board = board;
//    }

    public void show() {
        if (this.board != null) {
            TilePane root = new TilePane();
            int[][] array = board.getBoard();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    Integer temp = array[i][j];
                    StackPane tile = new Tile(temp);
                    root.getChildren().add(tile);
                }
            }
            //scene.setRoot(root);
        }
    }

    public static void main(String[] args) {
        //Board board = new Board();

//        new Thread() {
//            @Override
//            public void run() {
//                app.start();
//            }
//        }.start();
//        Visualisation visualisation;
//        visualisation = Visualisation.thisVis;
//        visualisation.setBoard(board);
//        visualisation.show();
        //startUpTest.printSomething();
        /// Visualisation visualisation = new Visualisation(board);
        //visualisation.main(new String[0]);
//        System.out.println(this.board.toString());
//        this.board.shuffle();
//        System.out.println(this.board.toString());
        //visualisation.show();
//	    board.moveUp();
//        System.out.println(board.toString());
//        board.moveDown();
//        System.out.println(board.toString());
//        board.moveLeft();
//        System.out.println(board.toString());
//        board.moveRight();
//        System.out.println(board.toString());
        launch();
    }

}
