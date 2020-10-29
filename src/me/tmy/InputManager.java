package me.tmy;

import java.io.IOException;
import java.io.InputStreamReader;

public class InputManager {
    private static InputStreamReader input = new InputStreamReader(System.in);

    public static String getInput(float limitTime){
        Timer timer = new Timer(limitTime);
        timer.start();

        while (true) {
            return "";
        }
    }

    private static void clear(){
        try {
            while (input.ready())
                input.read();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
