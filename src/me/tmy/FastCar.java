package me.tmy;

public class FastCar extends Car {
    int motor;
    int wheels[];

    private CarPart[]parts = new CarPart[5];



    public FastCar() {
        speed = 100;
        percent = 35;
        parts[0] = new Engine();
        parts[1] = new Wheel(Wheel.Position.TOP_LEFT);
        parts[2] = new Wheel(Wheel.Position.TOP_RIGHT);
        parts[3] = new Wheel(Wheel.Position.BOTTOM_LEFT);
        parts[4] = new Wheel(Wheel.Position.BOTTOM_RIGHT);

    }



    @Override
    public void capacity() {
        int part = Main.random.nextInt(parts.length);
        parts[part].partBreak();

    }

}
