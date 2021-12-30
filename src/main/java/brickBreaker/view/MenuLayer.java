package brickBreaker.view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.springframework.stereotype.Component;

@Component
public class MenuLayer extends Pane {

    private Text scoreDisplay;
    private int score = 0;

    public MenuLayer() {}

    public void paint() {
        getChildren().clear();
        scoreDisplay = new Text();
        scoreDisplay.setFill(Color.DARKBLUE);
        scoreDisplay.setFont(Font.font("serif", FontWeight.BOLD, 25));
        scoreDisplay.setX(560);
        scoreDisplay.setY(30);
        setScore(score);
        getChildren().add(scoreDisplay);
    }

    public void setScore(int score) {
        this.score = score;
        scoreDisplay.setText("Score: " + score);
    }

    public void youWon(int score) {
        getChildren().clear();

        Text youWon = new Text();
        youWon.setFill(Color.GREEN);
        youWon.setFont(Font.font("serif", FontWeight.BOLD, 30));
        youWon.setText("You won, Score: " + score);
        youWon.setLayoutX(190);
        youWon.setLayoutY(300);

        Text pressEnter = new Text();
        pressEnter.setFill(Color.GREEN);
        pressEnter.setFont(Font.font("serif", FontWeight.BOLD, 20));
        pressEnter.setText("Press Enter to restart.");
        pressEnter.setLayoutX(230);
        pressEnter.setLayoutY(350);

        getChildren().addAll(youWon, pressEnter);
    }

    public void gameOver(int score) {
        getChildren().clear();

        Text gameOver = new Text();
        gameOver.setFill(Color.RED);
        gameOver.setFont(Font.font("serif", FontWeight.BOLD, 30));
        gameOver.setText("Game Over, Score: " + score);
        gameOver.setLayoutX(190);
        gameOver.setLayoutY(300);

        Text pressEnter = new Text();
        pressEnter.setFill(Color.RED);
        pressEnter.setFont(Font.font("serif", FontWeight.BOLD, 20));
        pressEnter.setText("Press Enter to restart.");
        pressEnter.setLayoutX(230);
        pressEnter.setLayoutY(350);

        getChildren().addAll(gameOver, pressEnter);
    }

    public void start() {
        getChildren().clear();

        Text startMessage = new Text();
        startMessage.setFill(Color.GREEN);
        startMessage.setFont(Font.font("serif", FontWeight.BOLD, 30));
        startMessage.setText("Press Enter to start");
        startMessage.setLayoutX(190);
        startMessage.setLayoutY(300);

        getChildren().addAll(startMessage);
    }
}
