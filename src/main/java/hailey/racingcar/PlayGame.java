package hailey.racingcar;

import hailey.racingcar.domain.Car;
import hailey.racingcar.domain.Score;
import hailey.racingcar.util.GameRulesUtils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class PlayGame {

    public void startGame(Map<Car, Score> cars, int repeatNumber) {
        for (int i = 0; i < repeatNumber; i++) {
            turnAround(cars);
        }

        Map<Car, Score> winners = findWinners(cars);

        endGame(winners);
    }

    private void turnAround(Map<Car, Score> cars) {
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

    private Map<Car, Score> findWinners(Map<Car, Score> cars) {
        Map<Car, Score> winners = new LinkedHashMap<>();
        final int[] max = {0};
        cars.forEach((car, score) -> {
            if (score.isSameMaxScore(max[0])) {
                winners.put(car, score);
            } else if (score.isOnlyMaxScore(max[0])) {
                winners.clear();
                winners.put(car, score);
                max[0] = score.getScore();
            }
        });
        return winners;
    }

    private void endGame(Map<Car, Score> winners) {
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
