package owen.baseball;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import owen.baseball.domain.BallStatus;
import owen.baseball.domain.ball.Ball;
import owen.baseball.domain.ball.Balls;
import owen.baseball.util.BallFactory;
import owen.baseball.util.Result;

import java.util.Arrays;

public class BallsTest {

    private Balls answerBalls;

    @BeforeEach
    void ListUp() {
        answerBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void outOfRange_error() {
        Assertions.assertThatThrownBy(() -> BallFactory.makeBall("012")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("1 ~ 9 까지의 정수만 입력이 가능합니다.");
    }

    @Test
    void inputOtherType_error() {
        Assertions.assertThatThrownBy(() -> BallFactory.makeBall("s@1")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("정수만 입력 가능합니다.");
    }

    @Test
    void inputLength_error() {
        Assertions.assertThatThrownBy(() -> BallFactory.makeBall("1112")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("3자리의 숫자를 입력 바랍니다.");

        Assertions.assertThatThrownBy(() -> BallFactory.makeBall("11")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("3자리의 숫자를 입력 바랍니다.");
    }

    @Test
    void duplicate_error() {
        Assertions.assertThatThrownBy(() -> BallFactory.makeBall("111")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("중복된 숫자는 입력 불가능 합니다.");
    }

    @Test
    void test_Nothing() {
        Balls userBall = BallFactory.makeBall("456");
        Result result = answerBalls.play(userBall);
        Assertions.assertThat(result.getStrike()).isEqualTo(0);
        Assertions.assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void test_2ball1Strike() {
        Balls userBall = BallFactory.makeBall("132");
        Result result = answerBalls.play(userBall);
        Assertions.assertThat(result.getStrike()).isEqualTo(1);
        Assertions.assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    void test_3strike() {
        Balls userBall = BallFactory.makeBall("123");
        Result result = answerBalls.play(userBall);
        Assertions.assertThat(result.getStrike()).isEqualTo(3);
        Assertions.assertThat(result.is3Strike()).isEqualTo(true);

    }

    @Test
    void nothingTest() {
        Assertions.assertThat(answerBalls.playBall(new Ball(9, 1))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void strikeTest() {
        Assertions.assertThat(answerBalls.playBall(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ballTest() {
        Assertions.assertThat(answerBalls.playBall(new Ball(1, 3))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void totalTest() {
        Balls userBalls = new Balls(Arrays.asList(2, 1, 3));
        Assertions.assertThat(answerBalls.playBall(new Ball(1, 3))).isEqualTo(BallStatus.BALL);
    }
}
