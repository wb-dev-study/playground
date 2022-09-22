package hailey.racingcar;

import hailey.racingcar.domain.Car;
import hailey.racingcar.domain.Score;
import hailey.racingcar.util.ValidationUtils;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요");
        System.out.println("이름은 쉼표(,)를 기준으로 구분해주세요");
        String inputCarNames = scanner.nextLine();
        Map<Car, Score> cars = readyGame(inputCarNames);

        System.out.println("시도할 회수는 몇회인가요?");
        int repeatNumber = scanner.nextInt();
        for (int i = 0; i < repeatNumber; i++) {
            cars.forEach((k, v) -> {
                Random random = new Random();
                int advanceNumber = random.nextInt(100) % 9;
                if (advanceNumber >= 4) {
                    v.setScore(v.getScore() + advanceNumber);
                    v.getProgress().append("-".repeat(advanceNumber));
                }
                System.out.println(k + " : " + v.getProgress().toString());
            });
        }
    }

    private static Map<Car, Score> readyGame(String inputCarNames) {
        Map<Car, Score> cars = new LinkedHashMap<>();
        String[] carNames = inputCarNames.replace(" ", "").split(",");
        for (int i = 0; i < carNames.length; i++) {
            if (ValidationUtils.validate(carNames[i], carNames)) {
                cars.put(new Car(carNames[i]), new Score());
            }
        }
        return cars;
    }
}
