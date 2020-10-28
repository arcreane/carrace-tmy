package me.tmy;

import java.util.Random;

public abstract class Car {

    protected int percent;

    public void tryCapacity() {
        int randomNumber = Main.random.nextInt(101);
        if (randomNumber < percent) {
            capacity();

        }
    }

    protected abstract void capacity();
}


