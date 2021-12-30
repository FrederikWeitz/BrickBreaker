package brickBreaker.gamePlay;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static brickBreaker.gamePlay.GamePlayProperties.*;

public class Ball {

    private final Pane pane;
    private int ballposX;
    private int ballposY;
    private int ballXdir;
    private int ballYdir;
    private Image ballImage;
    private ImageView ball;

    public Ball(Pane pane) {
        this.pane = pane;
        initialize();
    }

    public void initialize() {
        try {
            ballImage = new Image(new FileInputStream("src/main/resources/tiles/" + "ball.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ball = new ImageView(ballImage);

        ballposX = ballX;
        ballposY = ballY;
        ballXdir = ball_XDir;
        ballYdir = ball_YDir;

        ball.setX(ballposX);
        ball.setY(ballposY);
        ball.setFitWidth(ballDiameter);
        ball.setFitHeight(ballDiameter);
        pane.getChildren().add(ball);
    }

    private void paint() {
        ball.setX(ballposX);
        ball.setY(ballposY);
    }

    public void move() {
        ballposX += ballXdir;
        ballposY += ballYdir;
        if (ballposX < backgroundBorder || ballposX > (gameWidth - backgroundBorder - ballDiameter)) ballXdir = -ballXdir;
        if (ballposY < backgroundBorder) ballYdir = -ballYdir;
        paint();
    }

    public void stop() {
        ballXdir = 0;
        ballYdir = 0;
    }

    public boolean intersects(Bounds bounds) {
        return ball.getLayoutBounds().intersects(bounds);
    }

    public void onBrickReact(Bounds bounds) {
        if ((ballposX + ballDiameter - 1) <= bounds.getMinX() || (ballposX + 1) >= bounds.getMaxX()) {
            ballXdir = -ballXdir;
        } else {
            ballYdir = -ballYdir;
        }
    }

    public void onPlayerReact() {
        ballYdir = -ballYdir;
    }

    public boolean outOfBounds() {
        return ballposY > gameHeight;
    }
}
