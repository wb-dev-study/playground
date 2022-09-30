package owen.racingcar;

import java.util.Random;

public class RandomMovingStrategy implements MoveStrategy{

    private static final int FORWARD_NUM = 4;
    private static final int MAX_BOUND = 10;

    @Override
    public boolean move() {
        return makeRandom() >= FORWARD_NUM;
    }

    private int makeRandom() {
        Random random = new Random();
        int randomNumber = random.nextInt(MAX_BOUND);
        return randomNumber;
    }


}
