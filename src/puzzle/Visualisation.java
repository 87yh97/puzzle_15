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

    //static public Model.Main Main = new Model.Main();
    static public Stage stage = null;
    public TilePane root = new TilePane();

    Board board;
    //int[][] Board;

    private class Tile extends StackPane{
        private final Double side = 60.0;

        public Tile(Integer num) {
            Label numLabel;
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
//
//                Label num = new Label(temp.toString());
//                num.setPrefSize(50.0, 50.0);
//                num.setAlignment(Pos.CENTER);
//                Rectangle border = new Rectangle();
//                border.setWidth(50);
//                border.setHeight(50);
//                border.setFill(Color.WHITE);
//                border.setStroke(Color.DARKRED);
//                StackPane tile = new StackPane();
//                tile.getChildren().add(border);
//                tile.getChildren().add(num);
//                //tile.setAlignment(Pos.CENTER);
//                tile.setPrefSize(50.0, 50.0);
                StackPane tile = new Tile(temp);
                root.getChildren().add(tile);
            }
        }


        Scene scene = new Scene(root);
        Visualisation.stage = stage;
        stage.setResizable(false);
        stage.setTitle("15 Puzzle");
        stage.setScene(scene);
        stage.show();

    }

    public Visualisation(Board board) {
        this.board = board;
    }

//    public static void setRoot(String fxml) throws IOException {
//        scene.setRoot(loadFXML(fxml));
//    }
//
//    public void setBoard(int[][] Board) {
//        this.Board = Board;
//    }
//
//    public static Parent loadFXML(String fxml) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Visualisation.class.getResource(fxml + ".fxml"));
//        return fxmlLoader.load();
//    }

    public static void main(String[] args) {
        launch();
    }

}
