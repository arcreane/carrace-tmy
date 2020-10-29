package me.tmy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputManager {
    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static String getInput(float limitTime){
        Timer timer = new Timer(limitTime);
        timer.start();
        clear();

        try {
            while (!timer.isOver()){
                if (input.ready())
                {
                    return input.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void clear(){
        try {
            while (input.ready())
                input.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
