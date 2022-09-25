package jay.racingcar.utils;

import java.util.Random;

public class RandomNumber {
    private static final int MAX_RANGE = 10;

    public static int generateRandom() {
        Random random = new Random();

        return random.nextInt(MAX_RANGE);
    }
}
