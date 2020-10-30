package me.tmy;

public class FastCar extends Car {

    private final CarPart[] parts = new CarPart[5];

    public FastCar() {
        percent = 35;
        parts[0] = new Engine();
        parts[1] = new Wheel(Wheel.Position.TOP_LEFT);
        parts[2] = new Wheel(Wheel.Position.TOP_RIGHT);
        parts[3] = new Wheel(Wheel.Position.BOTTOM_LEFT);
        parts[4] = new Wheel(Wheel.Position.BOTTOM_RIGHT);
        speed = 100f / 60f;
    }

    @Override
    public void capacity() {
        int part = Main.random.nextInt(parts.length);
        parts[part].partBreak();
    }

}
