package ep.racingcar.domain;

import ep.racingcar.domain.strategy.MovingStrategy;

public class Car {

    private CarName name;
    private Position position;

    public Car(CarName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Integer currentPosition() {
        return this.position.current();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!name.equals(car.name)) return false;
        return position.equals(car.position);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + position.hashCode();
        return result;
    }

    public void move() {
        this.position.moveForward();
    }

    public void move(MovingStrategy movingStrategy) {
        movingStrategy.move(this);
    }
}
