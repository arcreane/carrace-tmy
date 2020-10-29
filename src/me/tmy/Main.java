package me.tmy;

import java.util.Random;

public class Main {
    public static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Hi!");
        System.out.println(classeTemporaire.shuffle("VITESSE"));
        Wheel w = new Wheel(Wheel.Position.TOP_LEFT);
        while (true)
            w.partBreak();

    }
}

