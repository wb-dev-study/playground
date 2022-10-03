package jay.racingcar.factory;

import jay.racingcar.Output;
import jay.racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public static void findWinners(List<Car> racingCars) {
        List<Car> winnders = new ArrayList<>();

        for (Car racingCar : racingCars) {
            if (racingCar.isWinner(findMaxPosition(racingCars))) {
                winnders.add(racingCar);
            }
        }

        Output.printWinners(winnders);
    }

    private static int findMaxPosition(List<Car> racingCars) {
        return racingCars.stream().map(Car::getPosition).mapToInt(v -> v).max().orElse(0);
    }
}
