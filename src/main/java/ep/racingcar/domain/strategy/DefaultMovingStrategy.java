package ep.racingcar.domain.strategy;

import ep.racingcar.domain.Car;

public class DefaultMovingStrategy implements MovingStrategy {
    @Override
    public void move(Car car) {
        car.move();;
    }
}
