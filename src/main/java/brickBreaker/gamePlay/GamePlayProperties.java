package brickBreaker.gamePlay;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class GamePlayProperties {
    public static int gameWidth;
    public static int gameHeight;
    public static int brickfieldWidth;
    public static int brickfieldHeight;

    public static int row;
    public static int col;

    public static int brickCount;
    public static int scoreGain;
    public static int highScore;

    public static int brickWidth;
    public static int brickHeight;

    public static int gap;
    public static int offsetX;
    public static int offsetY;

    public static int brickPosWidth;
    public static int brickPosHeight;

    public static int playerX;
    public static int playerY;
    public static int playerWidth;
    public static int playerHeight;
    public static int playerStep;

    public static int ballX;
    public static int ballY;
    public static int ball_XDir;
    public static int ball_YDir;
    public static int ballDiameter;

    public static int backgroundBorder;

    public GamePlayProperties() throws IOException {
        Properties pro = new Properties();
        InputStream is = Thread.currentThread().getContextClassLoader().
                getResourceAsStream("properties/game.properties");
        pro.load(is);

        gameWidth = Integer.parseInt(pro.getProperty("game.gameWidth"));
        gameHeight = Integer.parseInt(pro.getProperty("game.gameHeight"));
        brickfieldWidth = Integer.parseInt(pro.getProperty("game.brickfieldWidth"));
        brickfieldHeight = Integer.parseInt(pro.getProperty("game.brickfieldHeight"));

        row = Integer.parseInt(pro.getProperty("game.row"));
        col = Integer.parseInt(pro.getProperty("game.col"));

        brickCount = row * col;
        scoreGain = Integer.parseInt(pro.getProperty("game.scoreGain"));
        highScore = brickCount * scoreGain;

        brickWidth = brickfieldWidth/col;
        brickHeight = brickfieldHeight/row;

        gap = Integer.parseInt(pro.getProperty("game.gap"));
        offsetX = (gameWidth - brickfieldWidth) / 2 + brickHeight;
        offsetY = Integer.parseInt(pro.getProperty("game.offsetY"));

        brickPosWidth = brickWidth + gap;
        brickPosHeight = brickHeight + gap;

        playerX = Integer.parseInt(pro.getProperty("player.x"));
        playerY = Integer.parseInt(pro.getProperty("player.y"));
        playerWidth = Integer.parseInt(pro.getProperty("player.width"));
        playerHeight = Integer.parseInt(pro.getProperty("player.height"));
        playerStep = Integer.parseInt(pro.getProperty("player.step"));

        ballX = Integer.parseInt(pro.getProperty("ball.x"));
        ballY = Integer.parseInt(pro.getProperty("ball.y"));
        ball_XDir = Integer.parseInt(pro.getProperty("ball.xDir"));
        ball_YDir = Integer.parseInt(pro.getProperty("ball.yDir"));
        ballDiameter = Integer.parseInt(pro.getProperty("ball.diameter"));

        backgroundBorder = Integer.parseInt(pro.getProperty("background.border"));
    }
}
