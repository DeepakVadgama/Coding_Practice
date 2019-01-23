package general.java.criteriaqueue.test;

import java.util.Random;

public class CandyFactory {

    public static final String[] colors = {"RED", "GREEN", "BLUE"};
    public static final Random random = new Random();

    public static Candy getCandy() {
        String color = colors[random.nextInt(colors.length)];
        return new Candy(color);
    }
}
