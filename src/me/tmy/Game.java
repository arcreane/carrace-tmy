package me.tmy;

import org.fusesource.jansi.Ansi;

public class Game {
    private static final long TIME_BETWEEN_STEPS = 2000;
    int nbtours;
     private int progress;

    private Car car;

    private final int mode; // 1: slow 2: fast
    private final Ansi.Color color;

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

    public void step()  {
        progress += car.getSpeed();
        if (progress>10){
            progress = 0;
            nbtours++;
        }
//        Menu.clearConsole();
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

