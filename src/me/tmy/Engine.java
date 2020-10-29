package me.tmy;

public class Engine extends CarPart {


    @Override
    public void partBreak() {
        StringBuilder builder = new StringBuilder();

        int[]randomNumbers = new int[5];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = Main.random.nextInt(10);
            builder.append(randomNumbers[i]).append(" ");

        }
        System.out.println(builder.toString());

    }
}
