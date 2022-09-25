package ep.racingcar.view;

import ep.racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToCar {

    private String carNames;
    private List<Car> cars;

    public StringToCar(String carNames) {
        this.cars = parse(carNames);
    }

    private List<Car> parse(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> toCars() {
        return this.cars;
    }
}
