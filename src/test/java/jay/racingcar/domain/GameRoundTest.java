package jay.racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameRoundTest {
    @Test
    public void gameRoundTest() {
        GameRound gameRound = new GameRound("5");
        Assertions.assertThat(gameRound.getRound()).isEqualTo(5);
    }

    @Test
    public void gameRoundFailTest() {
        Assertions.assertThatThrownBy(() ->
                new GameRound("-100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }
}