package me.tmy;


import org.fusesource.jansi.Ansi;


import java.util.Random;

public class Main {
    public static final Random random = new Random();

    public static void main(String[] args) {
        int mode = Menu.titleScreen();
        new RefreshConsole();
        Ansi.Color color = Menu.askColor();
        System.out.println(color);
        new RefreshConsole();
        Menu.gameOver();
        System.out.println("Hi!");
        System.out.println(classeTemporaire.shuffle("VITESSE"));

    }
}

