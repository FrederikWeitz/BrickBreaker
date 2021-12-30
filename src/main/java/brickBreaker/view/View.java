package brickBreaker.view;

import brickBreaker.gamePlay.GamePlay;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import org.springframework.stereotype.Component;

@Component
public class View extends StackPane {

    BackgroundLayer backgroundLayer;
    MovingLayer movingLayer;
    BrickLayer brickLayer;
    MenuLayer menuLayer;
    GamePlay gamePlay;

    public View(
            BackgroundLayer backgroundLayer,
            BrickLayer brickLayer,
            MovingLayer movingLayer,
            MenuLayer menuLayer,
            GamePlay gamePlay
    ) {
        this.backgroundLayer = backgroundLayer;
        this.movingLayer = movingLayer;
        this.brickLayer = brickLayer;
        this.menuLayer = menuLayer;
        this.gamePlay = gamePlay;

        setOnKeyPressed(this::keyPressed);

        getChildren().add(Layers.BACKGROUND.layer(), backgroundLayer);
        getChildren().add(Layers.BRICKS.layer(), movingLayer);
        getChildren().add(Layers.MOVING.layer(), brickLayer);
        getChildren().add(Layers.MENU.layer(), menuLayer);
    }

    private void keyPressed(KeyEvent keyEvent) {
        gamePlay.eventAction(keyEvent);
    }
}
