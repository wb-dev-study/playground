package owen.racingcar.domain;

import org.apache.commons.lang3.StringUtils;
import owen.racingcar.domain.car.Car;
import owen.racingcar.domain.car.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    private final Cars cars;
    private String winnerName;

    public GameResult(Cars cars) {
        this.cars = cars;
    }

    public void checkWinner () {
        int winnerScore = cars.getCarList().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalAccessError::new);


        List<String> winnerList = cars.getCarList().stream()
                .filter(car -> car.getPosition() == winnerScore)
                .map(Car::getName)
                .collect(Collectors.toList());

        winnerName = StringUtils.join(winnerList, ",");
    }

    public String getWinnerName() {
        return winnerName;
    }
}
