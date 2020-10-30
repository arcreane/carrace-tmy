package me.tmy;

public abstract class Car {

    protected int percent;

    public void tryCapacity() {
        int randomNumber = Main.random.nextInt(101);
        if (randomNumber < percent) {
            capacity();
        }
    }

    public abstract void capacity();

    protected int speed;
}

