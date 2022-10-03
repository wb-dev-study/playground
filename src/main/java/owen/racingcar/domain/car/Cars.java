package owen.racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public List<Car> getCarList() {
        return carList;
    }

    public Cars(List<String> userInputName) {
        this.carList = createCars(userInputName);
    }

    private List<Car> createCars(List<String> userInput) {
        if (userInput.size() < 2) {
            throw new IllegalArgumentException("자동차는 최소 2개 이상 입력하여야 합니다");
        }

        if (userInput.stream().distinct().count() != userInput.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름은 입력할 수 없습니다.");
        }

        List<Car> cars = new ArrayList<>();
        for (String name : userInput) {
            cars.add(new Car(name));
        }

        return cars;
    }
}

