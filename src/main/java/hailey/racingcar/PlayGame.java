package hailey.racingcar;

import hailey.racingcar.domain.Car;
import hailey.racingcar.domain.Score;
import hailey.racingcar.util.GameRulesUtils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class PlayGame {

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요");
        System.out.println("이름은 쉼표(,)를 기준으로 구분해주세요");
        String inputCarNames = scanner.nextLine();
        Map<Car, Score> cars = readyGame(inputCarNames);

        System.out.println("시도할 회수는 몇회인가요?");
        int repeatNumber = scanner.nextInt();

        for (int i = 0; i < repeatNumber; i++) {
            turnAround(cars);
        }

        Map<Car, Score> winners = findWinners(cars);

        endGame(winners);
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

    public void turnAround(Map<Car, Score> cars) {
        cars.forEach((car, score) -> {
            int advanceNumber = makeRandomNum();
            if (GameRulesUtils.isPossibleAdvance(advanceNumber)) {
                score.advance(advanceNumber);
            }
            System.out.println(car.getName() + " : " + score.getProgress().toString());
        });
        System.out.println();
    }

    private int makeRandomNum() {
        Random random = new Random();
        int advanceNumber = 0;
        try {
            advanceNumber =  GameRulesUtils.validateAdvanceNumber(random.nextInt(100) % 9);
        } catch (IllegalArgumentException e) {
            makeRandomNum();
        }
        return advanceNumber;
    }

    public Map<Car, Score> findWinners(Map<Car, Score> cars) {
        Map<Car, Score> winners = new LinkedHashMap<>();
        final int[] max = {0};
        cars.forEach((car, score) -> {
            if (score.isSameMaxScore(max[0])) {
                winners.put(car, score);
            }
            if (score.isOnlyMaxScore(max[0])) {
                winners.clear();
                winners.put(car, score);
                max[0] = score.getScore();
            }
        });
        return winners;
    }

    public void endGame(Map<Car, Score> winners) {
        Iterator<Car> winner = winners.keySet().iterator();
        int count = 0;
        while(winner.hasNext()) {
            String win = winner.next().getName();
            System.out.print(win);
            count++;
            if (winners.size() != count) {
                System.out.print(", ");
            }
        }
        System.out.println(" 가 최종 우승했습니다.");
    }
}
