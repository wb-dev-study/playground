package jay.racingcar.domain;

import java.util.Objects;

public class GameRound {
    private static final int ZERO = 0;

    private int round;

    public int getRound() {
        return round;
    }

    public GameRound(String round) {
        validationGameRound(round);
        this.round = Integer.parseInt(round);
    }

    private void validationGameRound(String round) {
        if (Integer.parseInt(round) < ZERO) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}
