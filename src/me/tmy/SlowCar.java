package me.tmy;

public class SlowCar extends Car {

    public SlowCar() {
        percentS = 25;
    }

    @Override
    protected void capacity(){
        System.out.println(classeTemporaire.shuffle("VITESSE"));
    }

}


