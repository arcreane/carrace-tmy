package me.tmy;

public abstract class Car {

    protected int percent;

    public void tryCapacityS() {
        int randomNumber = Main.random.nextInt(101);
        if (randomNumber < percent) {
            capacity();

        }
    }

    public abstract void capacity();
}

