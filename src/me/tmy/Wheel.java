package me.tmy;

public class Wheel extends CarPart {

    private Position position;
    private String sequence;

    public Wheel(Position position) {
        this.position = position;

        sequence = switch(position){
            case TOP_LEFT -> "L U C D R";
            case TOP_RIGHT -> "L U R C L D R";
            case BOTTOM_LEFT -> "L D C U R";
            case BOTTOM_RIGHT -> "L D R C L U R";
        };
    }

    @Override
    public void partBreak() {
        System.out.println(sequence);
        String input = InputManager.getInput(4);
        boolean result = Game.checkAnswer(input , sequence);


    }

    public enum Position{
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,

    }
}
