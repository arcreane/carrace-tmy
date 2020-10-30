package me.tmy;

public abstract class Car {

    protected int percent;
    protected float speed;

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

