package me.tmy;

import org.fusesource.jansi.Ansi;

import java.io.IOException;
import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;

public class Menu {
    static private final AudioClip modeSelectSound = new AudioClip("mode_select");
    static private final AudioClip selectVehiculeSound = new AudioClip("select_your_vehicle");

    static public int titleScreen(){
        modeSelectSound.play();
        System.out.println("*****Welcome to this race*****");
        System.out.println("Choose your car ");
        System.out.println("1-> Slow car (25% chance to have speed boost)");
        System.out.println("2-> Fast car(35% chance to break down )");
        return getIntInput(2);
    }

    static public int getIntInput(int max){
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            if (choice>max || choice<1){
                throw new Exception();
            }
            return choice;
        }

        catch (Exception e){
            System.out.println("Wrong input");
            System.out.println("Write a correct value");
            return getIntInput(max);
        }
    }

    static public Ansi.Color askColor(){
        selectVehiculeSound.play();
        Ansi.Color [] colors = Ansi.Color.values();
        for(int i = 0; i<colors.length - 1; i++ ){
            System.out.println(ansi().fg(colors[i]).a((i + 1) + "-" + colors[i].name() + " Car"));
        }
        System.out.println(ansi().fg(Ansi.Color.RED).a("9-").fg(Ansi.Color.CYAN).a("Ran").fg(Ansi.Color.WHITE).a("dom").fg(Ansi.Color.YELLOW).a(" ca").fg(Ansi.Color.GREEN).a("r").reset());
        int choix = getIntInput(9);
        if (choix==9){
            choix = Main.random.nextInt(colors.length);
        }
        return colors[choix - 1];

    }

    static public boolean gameOver(){
        System.out.println("Play again?\n" +
                "1-YES\n" +
                "2-NO");
         return getIntInput(2) == 1;
    }

    static public void pressEnter() {
        System.out.println("Press enter to continue");
        new Scanner(System.in).nextLine();
    }

    public static void clearConsole() {
        if (System.getProperty("os.name").startsWith("Windows")){
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

}

