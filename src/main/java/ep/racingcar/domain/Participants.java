package ep.racingcar.domain;

import ep.racingcar.domain.strategy.MovingStrategy;
import ep.racingcar.exception.RaceException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Participants {

    private Set<Car> cars;

    public Participants(Collection<Car> cars) {
        this.cars = new HashSet<>(cars);
    }

    public List<Car> currentCars() {
        return new ArrayList<>(this.cars);
    }

    public Integer count() {
        return this.cars.size();
    }

    public Boolean isParticipant(Car target) {
        return this.cars.contains(target);
    }

    public void participate(Car kimCar) {
        this.cars.add(kimCar);
    }

    public void move(MovingStrategy movingStrategy) {
        this.cars.forEach(car -> car.move(movingStrategy));
    }

    public List<Car> winners(Position finishPosition) {
        return this.cars.stream().filter(car -> car.equalPosition(finishPosition)).collect(Collectors.toList());
    }

    public Position currentFirstPosition() {
        Optional<Position> first = this.cars.stream().map(Car::position).sorted(Comparator.reverseOrder()).findFirst();
        if (first.isPresent()) {
            return first.get();
        }

        throw new RaceException("참가자가 없습니다.");
    }
}
