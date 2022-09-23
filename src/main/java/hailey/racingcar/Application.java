package hailey.racingcar;

import hailey.racingcar.domain.Car;
import hailey.racingcar.domain.Score;
import hailey.racingcar.util.GameRulesUtils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요");
        System.out.println("이름은 쉼표(,)를 기준으로 구분해주세요");
        String inputCarNames = scanner.nextLine();
        Map<Car, Score> cars = readyGame(inputCarNames);

        System.out.println("시도할 회수는 몇회인가요?");
        int repeatNumber = scanner.nextInt();

        PlayGame playGame = new PlayGame();
        playGame.startGame(cars, repeatNumber);
    }

    private static Map<Car, Score> readyGame(String inputCarNames) {
        Map<Car, Score> cars = new LinkedHashMap<>();
        String[] carNames = inputCarNames.replace(" ", "").split(",");
        for (int i = 0; i < carNames.length; i++) {
            if (GameRulesUtils.validateCar(i, carNames[i], carNames)) {
                cars.put(new Car(carNames[i]), new Score());
            }
        }
        return cars;
    }
}
