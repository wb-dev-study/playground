package jay.racingcar;

import jay.racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class Output {

    public static void printCars(List<Car> cars) {
        for (Car car : cars) {
            String position = showCarNameAndPosition(car);
            System.out.println(position);
        }
        System.out.println("\n");
    }

    public static void printWinners(List<Car> winners) {
        String winner = winners.stream().map(Car::getName).collect(Collectors.joining(","));

        System.out.println(String.join(",", winner) + "가 최종 우승했습니다.");
    }

    private static String showCarNameAndPosition(Car car) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            builder.append("-");
        }
        return car.getName() + ":" + builder.toString();
    }
}
