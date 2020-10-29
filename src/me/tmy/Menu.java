package me.tmy;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import org.fusesource.jansi.Ansi;

import static org.fusesource.jansi.Ansi.ansi;

public class Menu {

    static public int titleScreen(){
        System.out.println("*****Welcome to this race*****");
        System.out.println("Choose your car ");
        System.out.println("1->Slow car (50% chance to have speed boost");
        System.out.println("2-Fast car(30% chance to break down )");
        return getIntInput(2);
    }


    static public int  getIntInput(int max){
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
        Ansi.Color [] colors = Ansi.Color.values();
        for(int i = 0; i<colors.length - 1; i++ ){
            System.out.println(ansi().fg(colors[i]).a((i + 1) + "-" + colors[i].name() + " Car"));
        }
        System.out.println(ansi().fg(Ansi.Color.BLACK).a("9-").fg(Ansi.Color.BLUE).a("Voi").fg(Ansi.Color.WHITE).a("tu").fg(Ansi.Color.WHITE).a("re").a(" ").fg(Ansi.Color.RED).a("a").fg(Ansi.Color.MAGENTA).a("léa").fg(Ansi.Color.GREEN).a("toi").fg(Ansi.Color.YELLOW).a("re").reset());
        int choix = getIntInput(9);
        if (choix==9){
            choix = Main.random.nextInt(colors.length);
        }
        return colors[choix];

    }

    static public int gameOver(){
        System.out.println("Vous avez perdu la partie, Voulez vous recommencer?\n" +
                "1-OUI\n" +
                "2-Non");
         return getIntInput(2);
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

