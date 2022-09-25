package ep.racingcar.domain.strategy;

import ep.racingcar.domain.Car;

@FunctionalInterface
public interface MovingStrategy {

    void move(Car car);
}
