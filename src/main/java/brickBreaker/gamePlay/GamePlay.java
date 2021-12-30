package brickBreaker.gamePlay;

import brickBreaker.view.BrickLayer;
import brickBreaker.view.MenuLayer;
import brickBreaker.view.MovingLayer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import org.springframework.stereotype.Component;

import static brickBreaker.gamePlay.GamePlayProperties.brickCount;
import static brickBreaker.gamePlay.GamePlayProperties.scoreGain;

@Component
public class GamePlay {

    private static final long serialVersionUID = -1116274226097990448L;
    private boolean play = false;
    private int score = 0;

    private int totalBricks;

    private final MovingLayer movingLayer;
    private final BrickLayer brickLayer;
    private final MenuLayer menuLayer;

    public GamePlay(
            BrickLayer brickLayer,
            MovingLayer movingLayer,
            MenuLayer menuLayer
    ) {
        totalBricks = brickCount;

        this.movingLayer = movingLayer;
        this.brickLayer = brickLayer;
        this.menuLayer = menuLayer;
        menuLayer.start();

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(20), (e) -> react()));
        timeline.play();
    }

    public void eventAction(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.RIGHT) && play) {
            movingLayer.moveRight();
        }
        if (keyEvent.getCode().equals(KeyCode.LEFT) && play) {
            movingLayer.moveLeft();
        }
        if (keyEvent.getCode().equals(KeyCode.ENTER) && !play) {
            play = true;
            score = 0;
            totalBricks = brickCount;
            movingLayer.paint();
            brickLayer.paint();
            menuLayer.paint();
        }
    }

    private void react() {
        if (play) {
            int count = movingLayer.react();
            totalBricks -= count;
            score += scoreGain * count;
            menuLayer.setScore(score);

            if (totalBricks == 0) {
                play = false;
                movingLayer.stop();
                menuLayer.youWon(score);
            }

            if (movingLayer.ballOutOfBounds()) {
                play = false;
                movingLayer.stop();
                menuLayer.gameOver(score);
            }
        }
    }
}
