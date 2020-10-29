package me.tmy;

public class Game {

    private static final long TIME_BETWEEN_STEPS = 2000;

    Car car;

    int mode; // 1: slow 2: fast

    public Game(int mode) {
        this.mode = mode;
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
        System.out.println("step");
    }

    public static boolean checkAnswer(String check, String answer) {
        if (check == null) {
            System.out.println("temps écoulé");
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

