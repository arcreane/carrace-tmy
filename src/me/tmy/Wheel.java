package me.tmy;

public class Wheel extends CarPart {

    private Position position;

    public Wheel(Position position) {
        this.position = position;
    }

    @Override
    public void partBreak() {

    }

    public enum Position{
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,

    }
}
