package me.tmy;

import org.fusesource.jansi.Ansi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import static org.fusesource.jansi.Ansi.ansi;

public class Main {
    public static final Random random = new Random();

    public static void main(String[] args) {
        Menu.clearConsole();
        System.out.println(ansi().fgBrightYellow().a(loadAsciiFile("title")));
        System.out.println(ansi().fg(Ansi.Color.CYAN).a(loadAsciiFile("car")).reset());

        do{
            int mode = Menu.titleScreen();
            var color = Menu.askColor();

            new Game(mode, color).start();
        } while (Menu.gameOver());

    }

    public static String loadAsciiFile(String name){
        byte[] data;
        try (InputStream stream = Main.class.getResourceAsStream("/ascii/" + name + ".txt")){
            data = stream.readAllBytes();
            return new String(data);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Fichier " + name + ".txt");
        }
        return null;
    }
}
