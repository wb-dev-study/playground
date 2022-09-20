package jay.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BaseballBatsmanTest {
    private List<Integer> computer;

    BaseballBatsman baseballBatsman;

    @BeforeEach
    void setUp() {
        baseballBatsman = new BaseballBatsman();
        computer = Arrays.asList(1, 2, 3);
    }

    @Test
    @DisplayName("낫싱 테스트")
    public void nothing() {
        int total = baseballBatsman.total(computer, Arrays.asList(4, 5, 6));
        Assertions.assertThat(0).isEqualTo(total);
    }

    @Test
    @DisplayName("스트라이크 테스트")
    public void strike() {
        int strike = baseballBatsman.strike(computer, Arrays.asList(1, 2, 3));
        Assertions.assertThat(3).isEqualTo(strike);
    }

    @Test
    @DisplayName("볼 테스트")
    public void ball() {
        int total = baseballBatsman.total(computer, Arrays.asList(3, 2, 1));
        int strike = baseballBatsman.strike(computer, Arrays.asList(3, 2, 1));

        int ball = baseballBatsman.ball(total, strike);
        Assertions.assertThat(3).isEqualTo(ball);
    }
}