package brickBreaker.gamePlay;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static brickBreaker.gamePlay.GamePlayProperties.*;

public class Brick extends ImageView {

    public Brick(int x, int y) {
        Image blockImage;
        try {
            blockImage = new Image(new FileInputStream("src/main/resources/tiles/" + "block.png"));
            setImage(blockImage);
            setRotate(90);
            setX(x * brickPosWidth + offsetX);
            setY(y * brickPosHeight + offsetY);
            setFitWidth(brickHeight);
            setFitHeight(brickWidth);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
