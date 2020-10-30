package me.tmy;

public class Wheel extends CarPart {

    private final Position position;
    private final String sequence;

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
        boolean result = false;

        System.out.println("\nYour " + position.name().toLowerCase().replace('_', ' ') + " tire has just burst!\n" +
                "Type this sequence to change it:");

        while (!result) {
            System.out.println(sequence);
            String input = InputManager.getInput(4);
            result = Game.checkAnswer(input , sequence);
        }
    }

    public enum Position{
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT
    }
}
