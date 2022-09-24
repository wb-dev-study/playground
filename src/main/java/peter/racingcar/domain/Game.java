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
        validate(entry, round);
        this.entry = entry;
        this.round = round;
    }


    private void validate(List<Car> entry, Integer round) {
        if (entry.isEmpty()) {
            throw new EmptyEntryException("참가 차량이 없습니다.");
        }

        if (round == null || round > 10 || round < 0) {
            throw new InvalidRoundException("시도횟수는 1부터 10 사이의 값만 가능합니다.");
        }
    }
}
