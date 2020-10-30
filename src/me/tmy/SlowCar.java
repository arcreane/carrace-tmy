package me.tmy;

import java.util.ArrayList;
import java.util.List;

public class SlowCar extends Car {

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

       }

}



