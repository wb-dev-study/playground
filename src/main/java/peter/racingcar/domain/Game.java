package peter.racingcar.domain;

import peter.racingcar.exception.EmptyEntryException;
import peter.racingcar.exception.InvalidRoundException;

import java.util.List;

/**
 * Created by peter on 2022/09/24
 */
public class Game {
    private Integer round;
    private List<Car> entry;

    public Integer getRound() {
        return round;
    }

    public List<Car> getEntry() {
        return entry;
    }

    public Game(List<Car> entry, Integer round) {
        this.entry = entry;
        this.round = round;
        validate();
    }

    public Game(GameEntryInput gameEntryInput) {
        this.entry = gameEntryInput.getEntries();
        this.round = gameEntryInput.getRound();
        validate();
    }

    public void play() {
        for (int round = 0; round < this.round; round++) {
            System.out.println(round + "회차");
            drive();
        }
    }

    public void drive() {
        for (Car car : entry) {
            car.move();
        }
        showProgress();
    }

    public void showProgress() {
        for (Car car : entry) {
            car.showLocation();
        }
        System.out.println();
    }



    private void validate() {
        if (entry.isEmpty()) {
            throw new EmptyEntryException("참가 차량이 없습니다.");
        }

        if (round == null || round > 10 || round < 0) {
            throw new InvalidRoundException("시도횟수는 1부터 10 사이의 값만 가능합니다.");
        }
    }
}
