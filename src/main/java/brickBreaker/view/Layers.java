package brickBreaker.view;

public enum Layers {
    MENU(3),
    MOVING(2),
    BRICKS(1),
    BACKGROUND(0);

    private final int layer;

    Layers(int layer) {
        this.layer = layer;
    }

    public int layer() {
        return layer;
    }
}
