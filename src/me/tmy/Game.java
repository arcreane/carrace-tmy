package me.tmy;

import org.fusesource.jansi.Ansi;

import static org.fusesource.jansi.Ansi.ansi;

public class Game {
    static String smallCarAscii = Main.loadAsciiFile("small-car");
    static String whiteChar = "░", blackChar = "▓";

    private static final long TIME_BETWEEN_STEPS = 2000;
    int nbtours;
     private int progress;

    private Car car;

    private final int mode; // 1: slow 2: fast
    private final Ansi.Color color;

    private boolean visialCarPosition = true;

    private int getProgressionPervent() {
        return 75;
    }

    public Game(int mode, Ansi.Color color) {
        this.mode = mode;
        this.color = color;
    }

    public void start() {
        car = mode == 1 ? new SlowCar() : new FastCar();

        do {
            step();
            try {
                Thread.sleep(TIME_BETWEEN_STEPS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (true);
    }

    public void step() {
        String msg = ansi().fg(color).a(smallCarAscii).a('\n') +
                blackChar.repeat(getProgressionPervent()) + whiteChar.repeat(100 - getProgressionPervent()) + ansi().a('\n').reset() +
                "Progression: 0km       Tours 1/10";

        System.out.println(msg);

        car.tryCapacity();
        progress += car.getSpeed();
        if (progress>10){
            progress = 0;
            nbtours++;
        }
    }

    public static boolean checkAnswer(String check, String answer) {
        if (check == null) {
            System.out.println("Temps écoulé");
            return false;
        } else if (answer.equals(check.toUpperCase())) {
            System.out.println("Bien joué");
            return true;
        } else {
            System.out.println("Perdu");
            return false;
        }

    }

}

