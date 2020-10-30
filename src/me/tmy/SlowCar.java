package me.tmy;

public class SlowCar extends Car {

    public SlowCar() {
        percent = 25;
        speed = 50;
    }

    @Override
    public void capacity(){
       String shuffle = classeTemporaire.shuffle("VITESSE");
        System.out.println(shuffle);
       String input = InputManager.getInput(5);

       boolean result = Game.checkAnswer(input,shuffle);

       }

}



