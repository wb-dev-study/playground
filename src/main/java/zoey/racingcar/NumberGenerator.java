package zoey.racingcar;

import java.util.Random;

public class NumberGenerator {
    public static final int MAX_NUMBER = 9;

    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER);
    }
}
