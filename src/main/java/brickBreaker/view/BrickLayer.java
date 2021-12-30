package brickBreaker.view;

import brickBreaker.gamePlay.Ball;
import brickBreaker.gamePlay.Brick;
import javafx.scene.layout.Pane;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static brickBreaker.gamePlay.GamePlayProperties.col;
import static brickBreaker.gamePlay.GamePlayProperties.row;

@Component
public class BrickLayer extends Pane {

    public BrickLayer() {
        paint();
    }

    public void setBrick(int x, int y) {
        Brick brick = new Brick(x, y);
        getChildren().add(brick);
    }

    public void paint() {
        getChildren().clear();
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                setBrick(x, y);
            }
        }
    }

    public int intersects(Ball ball) {
        List<Brick> tempMap = getChildren().stream()
                .map(b -> (Brick) b)
                .filter(b -> ball.intersects(b.getBoundsInParent()))
                .collect(Collectors.toList());

        if (tempMap.size() >= 1) {
            ball.onBrickReact(tempMap.get(0).getBoundsInParent());
        }
        getChildren().removeAll(tempMap);
        return tempMap.size();
    }
}
