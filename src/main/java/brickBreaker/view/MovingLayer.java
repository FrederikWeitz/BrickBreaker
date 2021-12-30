package brickBreaker.view;

import brickBreaker.gamePlay.Ball;
import brickBreaker.gamePlay.Player;
import javafx.scene.layout.Pane;
import org.springframework.stereotype.Component;

@Component
public class MovingLayer extends Pane {

    private Player player;
    private Ball ball;
    private final BrickLayer brickLayer;

    public MovingLayer(
            BrickLayer brickLayer
    ) {
        this.brickLayer = brickLayer;
    }

    public void paint() {
        getChildren().clear();
        player = new Player(this);
        ball = new Ball(this);
    }

    public void moveRight() {
        player.moveRight();
    }

    public void moveLeft() {
        player.moveLeft();
    }

    public void stop() {
        ball.stop();
    }

    public int react() {
        if (ball.intersects(player.getLayoutBounds())) {
            ball.onPlayerReact();
        }

        int count = brickLayer.intersects(ball);
        ball.move();
        return count;
    }

    public boolean ballOutOfBounds() {
        return ball.outOfBounds();
    }
}
