package me.tmy;

import org.fusesource.jansi.Ansi;

import java.util.ArrayList;
import java.util.List;

import static org.fusesource.jansi.Ansi.ansi;

public class SlowCar extends Car {
    private final String boostAscii = Main.loadAsciiFile("boost");

    int counter = -1;

    private static String shuffle(String input){
        List<Character> characters = new ArrayList<Character>();
        for(char c: input.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
    }

    public SlowCar(Ansi.Color color) {
        super(color);
        percent = 25;
        speed = 50f / 60f;
    }

    @Override
    public void capacity(){
        Menu.clearConsole();
        System.out.println(ansi().fg(color).a(boostAscii).reset());

       if (counter > 0)
           return;

        System.out.println("\nYour car is ready for a boost.txt!\n" +
                "Type this sequence to use it:");

       String shuffle = shuffle("VITESSE");
       System.out.println(shuffle);
       String input = InputManager.getInput(5);

       boolean result = Game.checkAnswer(input,shuffle);
       if (result) {
           speed *=3;
           counter = 4;
       }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

   @Override
    public void step(){
       if (counter > 0){
            counter--;
        }
        if (counter == 0){
            speed /= 3;
            counter = -1;
        }
    }

    @Override
    public void frame() {
        if (counter > 0)
            System.out.println("Boost active!");
    }
}



