package me.tmy;

import java.util.ArrayList;
import java.util.List;

public class SlowCar extends Car {

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

    public SlowCar() {
        percent = 25;
        speed = 50;
    }

    @Override
    public void capacity(){
       String shuffle = shuffle("VITESSE");
        System.out.println(shuffle);
       String input = InputManager.getInput(5);

       boolean result = Game.checkAnswer(input,shuffle);
       if (result) {
           speed *=3;
           counter = 4;
       }
    }
       @Override
    public void step(){
        if (counter > 0){
            counter--;
        }
        else if (counter == 0){
            speed /= 3;
        }
    }
}



