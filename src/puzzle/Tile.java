package puzzle;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends StackPane{
    static private Double side = 60.0;

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
