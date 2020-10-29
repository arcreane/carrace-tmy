package me.tmy;

public class Timer {

    private long startTime = 0;
    private final long nanoDuration;

    public Timer(float duration) {
        this.nanoDuration = (long) (duration * 1e9f);
    }

    public void start(){
        startTime = System.nanoTime();
    }

    private long nanoTimeRemaining() {
        return nanoDuration - (System.nanoTime() - startTime);
    }

    public float timeRemaining() {
        return Math.max((float)(nanoTimeRemaining()) * 1e-9f, 0);
    }

    public boolean isOver(){
        return nanoTimeRemaining() < 0;
    }

}
