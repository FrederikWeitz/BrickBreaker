package brickBreaker.gamePlay;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static brickBreaker.gamePlay.GamePlayProperties.*;

public class Player {

    private final Pane pane;
    private Image playerImage;
    private ImageView player;

    public Player(Pane pane) {
        this.pane = pane;
        setPlayer();
    }

    public void setPlayer() {
        try {
            playerImage = new Image(new FileInputStream("src/main/resources/tiles/" + "paddle.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        player = new ImageView(playerImage);
        player.setX(playerX);
        player.setY(playerY);
        player.setFitWidth(playerWidth);
        player.setFitHeight(playerHeight);

        pane.getChildren().add(player);
    }

    public void moveRight() {
        int playerMaxX = gameWidth - backgroundBorder - playerWidth;
        playerX = (playerX < (playerMaxX) ? playerX + playerStep : (playerMaxX));
        player.setX(playerX);
    }

    public void moveLeft() {
        playerX = (playerX > backgroundBorder) ? playerX - playerStep : backgroundBorder;
        player.setX(playerX);
    }

    public Bounds getLayoutBounds() {
        return player.getLayoutBounds();
    }

}
