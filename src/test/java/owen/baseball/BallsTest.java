package owen.baseball;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import owen.baseball.domain.BallStatus;
import owen.baseball.domain.ball.Ball;
import owen.baseball.domain.ball.Balls;
import owen.baseball.util.BallFactory;

import java.util.Arrays;

public class BallsTest {

    private Balls answerBalls;

    @BeforeEach
    void ListUp() {
        answerBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("낫싱 테스트")
    void nothingTest() {
        Assertions.assertThat(answerBalls.playBall(new Ball(9, 1))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    @DisplayName("스트라이크 테스트")
    void strikeTest() {
        Assertions.assertThat(answerBalls.playBall(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("볼 테스트")
    void ballTest() {
        Assertions.assertThat(answerBalls.playBall(new Ball(1, 3))).isEqualTo(BallStatus.BALL);
    }

}
