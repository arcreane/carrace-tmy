package me.tmy;

import java.util.Random;

public abstract class Car {

    protected int percentS;

    public void tryCapacityS() {
        int randomNumber = Main.random.nextInt(101);
        if (randomNumber < percentS) {
            capacity();

        }
    }

    protected abstract void capacity();

}

