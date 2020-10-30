package me.tmy;

import org.fusesource.jansi.Ansi;

import static org.fusesource.jansi.Ansi.ansi;

public class FastCar extends Car {
    private final String ohnoAscii = Main.loadAsciiFile("oh-no");

    private final CarPart[] parts = new CarPart[5];

    public FastCar(Ansi.Color color) {
        super(color);
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
        Menu.clearConsole();
        System.out.println(ansi().fg(color).a(ohnoAscii).reset());

        int part = Main.random.nextInt(parts.length);
        parts[part].partBreak();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
