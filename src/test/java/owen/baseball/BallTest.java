package owen.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import owen.baseball.domain.BallStatus;
import owen.baseball.domain.ball.Ball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallTest {
    private Ball answerBall;

    @BeforeEach
    void setUp() {
        answerBall = new Ball(1, 4);
    }

    @Test
    @DisplayName("낫싱 테스트")
    void nothingTest() {
        Ball userBall = new Ball(2, 1);

        BallStatus status = answerBall.playBall(userBall);
        Assertions.assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    @DisplayName("스트라이크 테스트")
    public void strikeTest() {
        Ball userBall = new Ball(1, 4);

        BallStatus status = answerBall.playBall(userBall);
        Assertions.assertThat(status).isEqualTo(BallStatus.STRIKE);

    }

    @Test
    @DisplayName("볼 테스트")
    public void ballTest() {
        Ball userBall = new Ball(1, 2);

        BallStatus status = answerBall.playBall(userBall);
        Assertions.assertThat(status).isEqualTo(BallStatus.BALL);

    }
}
