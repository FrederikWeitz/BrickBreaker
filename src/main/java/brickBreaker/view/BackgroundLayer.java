package brickBreaker.view;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Component
public class BackgroundLayer extends Pane {

    public BackgroundLayer() {
        paint();
    }

    public void paint() {
        Image img = null;
        try {
            img = new Image(new FileInputStream("src/main/resources/background/" + "background.jpg"));
            BackgroundImage bImg = new BackgroundImage(img,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);
            Background bGround = new Background(bImg);
            setBackground(bGround);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        getChildren().clear();
        Rectangle leftBorder = new Rectangle(0, 0, 3, 600);
        Rectangle upperBorder = new Rectangle(0, 0, 700, 3);
        Rectangle rightBorder = new Rectangle(697, 0, 3, 600);
        leftBorder.setFill(Color.YELLOW);
        upperBorder.setFill(Color.YELLOW);
        rightBorder.setFill(Color.YELLOW);
        getChildren().addAll(leftBorder, upperBorder, rightBorder);
    }
}
