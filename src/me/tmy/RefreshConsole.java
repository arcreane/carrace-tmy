package me.tmy;

import java.io.IOException;

public class RefreshConsole {
    private static ProcessBuilder builder = new ProcessBuilder("/c", "cls").inheritIO();

    public RefreshConsole() {
        process();
    }

    public void process() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
