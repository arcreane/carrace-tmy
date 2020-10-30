package me.tmy;

import org.fusesource.jansi.Ansi;

public abstract class Car {

    protected int percent;
    protected float speed;

    protected final Ansi.Color color;

    public Car(Ansi.Color color) {
        this.color = color;
    }

    public float getSpeed() {
        return speed;
    }

    public void tryCapacity() {
        int randomNumber = Main.random.nextInt(101);
        if (randomNumber < percent) {
            capacity();
        }
    }

    public abstract void capacity();

    public void step() {} // Pas abstract car elle est facultative

    public void frame() {}

}

