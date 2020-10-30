package me.tmy;

public abstract class Car {

    protected int percent;
    protected int speed;

    public int getSpeed() {
        return speed;
    }

    public void tryCapacity() {
        int randomNumber = Main.random.nextInt(101);
        if (randomNumber < percent) {
            capacity();
        }
    }

    public abstract void capacity();

    public void step (){

    }

}

