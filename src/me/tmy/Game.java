package me.tmy;

import org.fusesource.jansi.Ansi;

import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;

public class Game {
    private static final String smallCarAscii = Main.loadAsciiFile("small-car");
    private static final String completedAscii = Main.loadAsciiFile("completed");
    private static final String whiteChar = "_", blackChar = "#";

    private static final long TIME_BETWEEN_STEPS = 2;
    private static final int TOTAL_LAPS = 5;
    private static final float LAP_LENGTH = 10;

    private int stepCount;

    private int lapsCount;
    private float progress;

    private final Car car;

    private final Ansi.Color color;

    private boolean visialCarY = true;

    private int getProgressionPercent() {
        return (int) (progress / LAP_LENGTH * 100);
    }

    public Game(int mode, Ansi.Color color) {
        // 1: slow 2: fast
        this.color = color;
        car = mode == 1 ? new SlowCar() : new FastCar();
    }

    public void start() {
        stepCount = 0;
        Timer timer = new Timer(TIME_BETWEEN_STEPS);
        timer.start();

        try {
            while (lapsCount < TOTAL_LAPS) {
                frame();

                if (timer.isOver()) {
                    step();
                    timer.start();
                }

                Thread.sleep(100);
            }

            gameOver();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void frame(){
        Menu.clearConsole();
        System.out.println(
                ansi().cursor(visialCarY ? 1 : 2, 1).fg(color).a(smallCarAscii).a('\n').reset().cursor(7, 0)
                .a("  ").a(stepCount).a(" munites since the begining of the race.\n")
                .a("     ").a(Math.round(progress)).a("km(s)       ").a(lapsCount).a('/').a(TOTAL_LAPS).a(" laps\n")
                .a('[').a(blackChar.repeat(getProgressionPercent())).a(whiteChar.repeat(100 - getProgressionPercent()) + "]")
        );
        visialCarY = !visialCarY;

        car.frame();
    }

    private void step() {
        stepCount++;
        car.tryCapacity();

        progress += car.getSpeed();
        if (progress>10){
            progress = 0;
            lapsCount++;
        }

        car.step();
    }

    private void gameOver() {
        Menu.clearConsole();
        System.out.println(
                ansi().fg(color).a(completedAscii).reset()
                .a("\nYou completed the race in ").a(stepCount).a(" minutes.")
                .a("\nPress enter to continue.")
        );
        new Scanner(System.in).nextLine();
    }

    public static boolean checkAnswer(String check, String answer) {
        if (check == null) {
            System.out.println("Time out");
            return false;
        } else if (answer.equals(check.toUpperCase())) {
            System.out.println("Nice job");
            return true;
        } else {
            System.out.println("Oops");
            return false;
        }

    }

}

