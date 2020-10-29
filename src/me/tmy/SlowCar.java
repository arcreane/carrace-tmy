package me.tmy;

public class SlowCar extends Car {

    public SlowCar() {
        percent = 25;
    }

    @Override
    protected void capacity(){
       String shuffle = classeTemporaire.shuffle("VITESSE");
        System.out.println(shuffle);
       String input = InputManager.getInput(3);
       if (input == null)
           System.out.println("temps écoulé");
       else if(shuffle == input)
           System.out.println("Bien joué");
       else{
           System.out.println("Perdu");

       }
    }





}


