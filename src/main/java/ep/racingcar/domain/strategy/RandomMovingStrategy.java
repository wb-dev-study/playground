package ep.racingcar.domain.strategy;

import ep.racingcar.domain.Car;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private static final Integer RANDOM_MOVE_START_VALUE = 4;
    private static final Integer MAX_RANDOM_NUMBER = 9;
    private static final Integer MIN_RANDOM_NUMBER = 1;

    @Override
    public void move(Car car) {
        if (generateRandomNumber() >= RANDOM_MOVE_START_VALUE) {
            car.move();
        }
    }

    private Integer generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_NUMBER) + MIN_RANDOM_NUMBER;
    }
}
