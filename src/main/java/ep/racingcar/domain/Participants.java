package ep.racingcar.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Participants {

    private Set<Car> cars;

    public Participants(Collection<Car> cars) {
        this.cars = new HashSet<>(cars);
    }

    public Integer count() {
        return this.cars.size();
    }

    public Boolean isParticipant(Car target) {
        return this.cars.contains(target);
    }
}
