package hailey.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {

    private Ball answerBall;

    @BeforeEach
    void setUp() {
        answerBall = new Ball(0, 4);
    }

    @Test
    @DisplayName("잘못된 num으로 Ball 생성시 IllegalArgumentException 발생")
    void create_with_wrong_num() {
        assertThatThrownBy(() -> new Ball(1, 0)).hasMessage("Utility class");
        assertThatThrownBy(() -> new Ball(1, 10)).hasMessage("Utility class");
    }

    @Test
    @DisplayName("볼 생성")
    void make_balls() {
        List<Ball> balls = Ball.makeBall(Arrays.asList(8, 5, 9));
        assertThat(balls.get(0).getNumber().getNo()).isEqualTo(8);
        assertThat(balls.get(1).getNumber().getNo()).isEqualTo(5);
        assertThat(balls.get(2).getNumber().getNo()).isEqualTo(9);
    }

    @Test
    @DisplayName("스트라이크 판별")
    void check_strike() {
        Ball userBall = new Ball(0, 4);
        BallStatus ballStatus = answerBall.compareAnswer(userBall);
        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("볼 판별")
    void check_ball() {
        Ball userBall = new Ball(1, 4);
        BallStatus ballStatus = answerBall.compareAnswer(userBall);
        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("Noting 판별")
    void check_noting() {
        Ball userBall = new Ball(1, 8);
        BallStatus ballStatus = answerBall.compareAnswer(userBall);
        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}
