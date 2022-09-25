package jay.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> racingCars = new ArrayList<>();

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public Cars(List<String> carNames) {
        validationCars(carNames);
        racingCars = generateCars(carNames);
    }

    private void validationCars(List<String> carNames) {
        if (carNames.size() == 1) {
            throw new IllegalArgumentException("최소 하나 이상의 자동차 이름을 입력하세요.");
        }
    }

    public List<Car> generateCars(List<String> carNames) {
        for (String carName : carNames) {
            racingCars.add(new Car(carName));
        }

        return racingCars;
    }
}
