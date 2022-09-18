package owen.baseball.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import owen.baseball.domain.ball.Balls;

import java.util.Arrays;


class ResultTest {

    private Balls answerBalls;

    @BeforeEach
    void ListUp() {
        answerBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("낫싱 테스트")
    void test_Nothing() {
        Balls userBall = BallFactory.makeBall("456");
        Result result = answerBalls.play(userBall);
        Assertions.assertThat(result.getStrike()).isEqualTo(0);
        Assertions.assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("2ball 1strike 테스트")
    void test_2ball1Strike() {
        Balls userBall = BallFactory.makeBall("132");
        Result result = answerBalls.play(userBall);
        Assertions.assertThat(result.getStrike()).isEqualTo(1);
        Assertions.assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    @DisplayName("3strike 테스트")
    void test_3strike() {
        Balls userBall = BallFactory.makeBall("123");
        Result result = answerBalls.play(userBall);
        Assertions.assertThat(result.getStrike()).isEqualTo(3);
        Assertions.assertThat(result.is3Strike()).isEqualTo(true);

    }

}