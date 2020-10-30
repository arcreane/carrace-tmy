package me.tmy;

import org.fusesource.jansi.Ansi;

public abstract class Car {
    private static final AudioClip hurryUpSound = new AudioClip("hurry_up");

    protected int percent;
    protected float speed;

    protected boolean capacityActive;

    protected final Ansi.Color color;

    public Car(Ansi.Color color) {
        this.color = color;
    }

    public float getSpeed() {
        return speed;
    }

    public int tryCapacity() {
        if(capacityActive)
            return 0;

        int randomNumber = Main.random.nextInt(101);
        if (randomNumber < percent) {
            hurryUpSound.play();
            return capacity();
        }

        return 0;
    }

    public abstract int capacity();

    public void step() {} // Pas abstract car elle est facultative

    public void frame() {}

}

